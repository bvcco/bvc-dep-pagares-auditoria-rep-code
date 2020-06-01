package com.deceval.auditoria.business.bean.pojo.negocio;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.naming.InitialContext;

import com.deceval.auditoria.daccess.dao.DAOFactory;
import com.deceval.auditoria.daccess.dao.negocio.AplicacionDAO;
import com.deceval.auditoria.daccess.dao.negocio.HomologacionDAO;
import com.deceval.auditoria.daccess.dao.negocio.LogDAO;
import com.deceval.auditoria.daccess.dao.negocio.LogHistorialDAO;
import com.deceval.auditoria.daccess.dao.negocio.ModuloDAO;
import com.deceval.auditoria.daccess.dao.negocio.OperacionDAO;
import com.deceval.auditoria.daccess.dao.negocio.OrigenDAO;
import com.deceval.auditoria.daccess.roe.ROEFactory;
import com.deceval.auditoria.daccess.roe.negocio.LogHistorialROE;
import com.deceval.auditoria.daccess.roe.negocio.LogROE;
import com.deceval.auditoria.daccess.roe.negocio.ObjetoROE;
import com.deceval.auditoria.daccess.roe.negocio.OperacionROE;
import com.deceval.auditoria.dto.EstructuraConsultaDTO;
import com.deceval.auditoria.dto.EstructuraDetalleLogDTO;
import com.deceval.auditoria.dto.EstructuraListaMsgDTO;
import com.deceval.auditoria.dto.EstructuraLogDTO;
import com.deceval.auditoria.dto.EstructuraOperacionDTO;
import com.deceval.auditoria.dto.EstructuraTablaDTO;
import com.deceval.auditoria.dto.RequestMsgInsertAudObjectDTO;
import com.deceval.auditoria.exception.DAOException;
import com.deceval.auditoria.exception.ServiceException;
import com.deceval.auditoria.integration.services.location.ServiceLocator;
import com.deceval.auditoria.util.constants.Constants;
import com.deceval.auditoria.util.date.DateUtil;
import com.deceval.auditoria.util.properties.PropertiesLoader;
import com.deceval.auditoria.vo.AplicacionVO;
import com.deceval.auditoria.vo.HomologacionVO;
import com.deceval.auditoria.vo.LogHistorialVO;
import com.deceval.auditoria.vo.LogVO;
import com.deceval.auditoria.vo.ModuloVO;
import com.deceval.auditoria.vo.ObjetoAtributoVO;
import com.deceval.auditoria.vo.ObjetoVO;
import com.deceval.auditoria.vo.OperacionVO;
import com.deceval.auditoria.vo.OrigenVO;

public class NegocioPOJO {
	
	/**
	 * Se encarga de efectuar la anotacion en el log de auditoria
	 * @param log
	 * @return
	 * @throws ServiceException
	 */
	public void crearAnotacionLog(RequestMsgInsertAudObjectDTO reqMsgObj) throws ServiceException{
		Connection connection = null;
		LogVO log = reqMsgObj.getLogVO();
		try {
			connection = ServiceLocator.getInstance().getConnection();
			DAOFactory daoFactory = DAOFactory.getDAOFactory(connection, Constants.DATA_BASE_PROVIDER_ORACLE);
			//Se consultan los id de las constantes recibidas en el MSG
			if (reqMsgObj.getConstanteReferenciaOperacion() != null){
				OperacionVO operacionVO = new OperacionVO();
				operacionVO.setConstanteReferencia(reqMsgObj.getConstanteReferenciaOperacion());
				OperacionDAO operacionDAO = daoFactory.getOperacionDAO();
				log.setIdOperacion(operacionDAO.findByConstanteReferencia(operacionVO).getIdOperacion());
			}
			if (reqMsgObj.getConstanteReferenciaOrigen() != null){
				OrigenVO origenVO = new OrigenVO();
				origenVO.setConstanteReferencia(reqMsgObj.getConstanteReferenciaOrigen());
				OrigenDAO origenDAO = daoFactory.getOrigenDAO(); 
				log.setIdOrigen(origenDAO.findByConstanteReferencia(origenVO).getIdOrigen());
			}
			//Validacion de campos en objeto VO a insertar
			Boolean insertar = Boolean.FALSE;
			if (log != null && 
				log.getIdOperacion() != null &&
				log.getIdOrigen() != null && 
				log.getCodigoOrigen() != null &&
				log.getIdUsuario() != null &&
				log.getUserName() != null && log.getUserName().length() > 0 &&
				log.getIpUsuario() != null && log.getIpUsuario().length() > 0 &&  
				log.getIpServidor() != null && log.getIpServidor().length() > 0 &&
				log.getDescripcionAnotacion() != null && log.getDescripcionAnotacion().length() > 0)
				insertar = Boolean.TRUE;
			
			//Se hace llamado al dao de insercion de LogVO
			if(insertar){
				//Se inserta en el log general tabla AUD_LOG y se obtiene el idTraza generado
				Long idTraza = null;
				LogDAO logDAO = daoFactory.getLogDAO();
				//Se asigna la fecha y hora de la anotacion
				log.setFechaAnotacion(DateUtil.getFechaSistemaCalendar());
				idTraza = logDAO.insert(log).getIdTraza();
				//idTraza = logDAO.findMaxIdTraza();
				
				/*
				* AUDITORIA DETALLADA POR TABLA (SOLO PARA LAS TABLAS PREVIAMENTE PARAMETRIZADAS EN AUDITORIA)
				* Si se recibio la lista de tablas en el mensaje, se busca la respectiva estructura parametrizada en AUDITORIA
				* para determinar de que aplicacion provienen las tablas y que campos se deben auditar en cada una de ellas
				*/
				if (idTraza != null && reqMsgObj.getListaEstructurasTablas() != null && reqMsgObj.getListaEstructurasTablas().size() > 0){
					ROEFactory roeFactory = ROEFactory.getROEFactory(connection, Constants.DATA_BASE_PROVIDER_ORACLE);
					//Consulta la estructura de la operacion que se audita
					EstructuraOperacionDTO estructuraOperacion = new EstructuraOperacionDTO();
					OperacionVO operacion = new OperacionVO();
					operacion.setIdOperacion(log.getIdOperacion());
					estructuraOperacion.setOperacionVO(operacion);
					OperacionROE operacionROE = roeFactory.getOperacionROE();
					estructuraOperacion = operacionROE.consultarEstructuraByIdOperacion(estructuraOperacion);
					
					//Se recorre la lista de tablas se extraen datos y se insertan en el LOGHISTORIAL
					int totalTablas = reqMsgObj.getListaEstructurasTablas().size();
					for(int contadorTabla = 0; contadorTabla < totalTablas; contadorTabla++){
						try {
							EstructuraListaMsgDTO estructuraMsg = reqMsgObj.getListaEstructurasTablas().get(contadorTabla);
							//Consulta la estructura de la tabla que se audita
							ObjetoVO objeto = estructuraMsg.getObjetoVO();
							objeto.setIdAplicacion(estructuraOperacion.getAplicacionVO().getIdAplicacion());
							EstructuraTablaDTO estructuraTabla = new EstructuraTablaDTO(); 
							estructuraTabla.setTabla(objeto);
							ObjetoROE objetoROE = roeFactory.getObjetoROE();
							estructuraTabla = objetoROE.consultarEstructuraByIdAplicacionAndNombreTabla(estructuraTabla);
							//Se alistan los campos que se deben auditar y se les complementa la informacion
							if (estructuraTabla != null && estructuraTabla.getTabla() != null && estructuraTabla.getTabla().getIdObjeto() != null &&
								estructuraTabla.getAtributos() != null && estructuraTabla.getAtributos().size() > 0){
								Collection<LogHistorialVO> i = estructuraMsg.getListaLogHistorialVO();
								LogHistorialVO logHistorial = null;
								ObjetoAtributoVO atributo = null;
								Collection<LogHistorialVO> listaInsercionHistorial = new ArrayList<LogHistorialVO>(); 
								for (Iterator<LogHistorialVO> listaCamposMsg = i.iterator(); listaCamposMsg.hasNext();){
									logHistorial = listaCamposMsg.next();
									for (Iterator<ObjetoAtributoVO> listaAtributos = estructuraTabla.getAtributos().iterator(); listaAtributos.hasNext();){
										atributo = listaAtributos.next();
										if(logHistorial.getNombreCampo().equalsIgnoreCase(atributo.getNombreCampo())){
											logHistorial.setIdAtributo(atributo.getIdAtributo());
											logHistorial.setIdTraza(idTraza);
											if(logHistorial.getValorAtributo().equalsIgnoreCase("NULL"))
												logHistorial.setValorAtributo(null);
											listaInsercionHistorial.add(logHistorial);
											break;
										}
									}
								}
								//Se realizan las inserciones para los campos auditables detectados.
								Iterator<LogHistorialVO> listaCamposMsg = listaInsercionHistorial.iterator();
								if(listaCamposMsg != null && listaCamposMsg.hasNext()){
									LogHistorialDAO logHistorialDAO = daoFactory.getLogHistorialDAO();
									for (;listaCamposMsg.hasNext();)
										logHistorialDAO.insert(listaCamposMsg.next());
								}
							}
						} catch (Exception exc){
							System.out.println(	"\n [ADVERTENCIA]: Metodo <NegocioPOJO>.<crearAnotacionLog> " + DateUtil.getFechaSistemaCalendar().getTime() +
												"\n No se insertaron uno o mas detalles durante la auditoria de la traza: " + idTraza);
						}
					}
				}
			} else {
				System.out.println("\n [ADVERTENCIA]: Metodo <NegocioPOJO>.<crearAnotacionLog> " + DateUtil.getFechaSistemaCalendar().getTime() +
						"\n NO se inserto al Log de AUDITORIA el mesaje recibido (o alguno de sus detalles), verifique la parametrización del mensaje. Datos:" +
						"\n Constante Operacion: " + reqMsgObj.getConstanteReferenciaOperacion() +
						"\n Constante Origen: " + reqMsgObj.getConstanteReferenciaOrigen() +
						"\n Valor idUsuario: " + log.getIdUsuario() +
						"\n Valor userName: " + log.getUserName() +
						"\n Valor ipUsuario: " + log.getIpUsuario() + 
						"\n Valor descripción: " + log.getDescripcionAnotacion() + " \n");
			}
		} catch(Exception de){
			System.out.println("\n [ADVERTENCIA]: Metodo <NegocioPOJO>.<crearAnotacionLog> " + DateUtil.getFechaSistemaCalendar().getTime() +
					"\n NO se inserto al Log de AUDITORIA el mesaje recibido (o alguno de sus detalles), verifique la parametrización del mensaje. Datos:" +
					"\n Constante Operacion: " + reqMsgObj.getConstanteReferenciaOperacion() +
					"\n Constante Origen: " + reqMsgObj.getConstanteReferenciaOrigen() +
					"\n Valor idUsuario: " + log.getIdUsuario() +
					"\n Valor userName: " + log.getUserName() +
					"\n Valor ipUsuario: " + log.getIpUsuario() + 
					"\n Valor descripción: " + log.getDescripcionAnotacion() + " \n");
			de.printStackTrace();
		} finally{
			try{
				ServiceLocator.getInstance().closeConnection(connection);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	} 
	
	
	/**
	 * Recibe la peticion del WebService y la envia a la cola de mensajeria
	 * @param log
	 * @return
	 */
	public String sendAnotacionLog2Queue(RequestMsgInsertAudObjectDTO reqMsgObj){
		String resultado = "";
		QueueConnection cnn = null;
		QueueSender sender = null;
		QueueSession sess = null;
		Queue queue = null;
		try {
			Boolean insertar = Boolean.FALSE;
			//Validacion de campos en objeto VO a insertar
			LogVO log = reqMsgObj.getLogVO();
			if (log != null &&
				reqMsgObj.getConstanteReferenciaOperacion() != null && reqMsgObj.getConstanteReferenciaOperacion().length() > 0 &&
				reqMsgObj.getConstanteReferenciaOrigen() != null && reqMsgObj.getConstanteReferenciaOrigen().length() > 0 && 
				log.getCodigoOrigen() != null &&
				log.getIdUsuario() != null &&
				log.getUserName() != null && log.getUserName().length() > 0 &&
				log.getIpUsuario() != null && log.getIpUsuario().length() > 0 &&  
				log.getIpServidor() != null && log.getIpServidor().length() > 0 &&
				log.getDescripcionAnotacion() != null && log.getDescripcionAnotacion().length() > 0)
				insertar = Boolean.TRUE;
			
			if (insertar){
				InitialContext ctx = new InitialContext();
				QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup(PropertiesLoader.loadProperty(Constants.CONNECTIONFACTORYJNDINAME));
				cnn = factory.createQueueConnection();
				sess = cnn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
				queue = (Queue) ctx.lookup(PropertiesLoader.loadProperty(Constants.QUEUENAME_ANOTACIONLOG));
				ObjectMessage msg = sess.createObjectMessage(reqMsgObj);
				msg.setLongProperty("sent", System.currentTimeMillis());
				sender = sess.createSender(queue);
				sender.send(msg);
				sess.close ();
				resultado = "INFO-001AUD, Anotación enviada a cola JMS.";
			} else
				resultado = "INFO-002AUD, Datos LOG no pasan validación.";
		} catch (Exception e) {
 			resultado = "ERROR-001AUD, al enviar a cola JMS.";
 			e.printStackTrace ();
		}
		return resultado;
	}
	
	/**
	 * Devuelve la lista de las aplicaciones
	 * @param 
	 * @return Collection de objetos AplicacionVO
	 * @author gmarroquin
	 */
	public Collection<AplicacionVO> obtenerListaAplicacion() {
		Connection connection = null;
		
		try {
			connection = ServiceLocator.getInstance().getConnection();
			DAOFactory daoFactory = DAOFactory.getDAOFactory(connection, Constants.DATA_BASE_PROVIDER_ORACLE);
			
			AplicacionDAO aplicacionDAO = daoFactory.getAplicacionDAO();
			return aplicacionDAO.getAll();
		} catch(Exception de){
			System.out.println("\n [ADVERTENCIA]: Metodo <NegocioPOJO>.<obtenerListaAplicacion> " + DateUtil.getFechaSistemaCalendar().getTime() +
					"\n NO se pudo obtener la lista de las aplicaciones." + " \n");
			de.printStackTrace();
		} finally{
			try{
				ServiceLocator.getInstance().closeConnection(connection);

			} catch(Exception e){
				e.printStackTrace();
			}			
		}
		return null;		
	}
	
	/**
	 * Devuelve la lista de los modulos
	 * @param 
	 * @return Collection de objetos ModuloVO
	 * @author gmarroquin
	 */
	public Collection<ModuloVO> obtenerListaModulo() {
		Connection connection = null;
		
		try {
			connection = ServiceLocator.getInstance().getConnection();
			DAOFactory daoFactory = DAOFactory.getDAOFactory(connection, Constants.DATA_BASE_PROVIDER_ORACLE);
			
			ModuloDAO moduloDAO = daoFactory.getModuloDAO();
			return moduloDAO.getAll();
		} catch(Exception de){
			System.out.println("\n [ADVERTENCIA]: Metodo <NegocioPOJO>.<obtenerListaModulo> " + DateUtil.getFechaSistemaCalendar().getTime() +
					"\n NO se pudo obtener la lista de los módulos." + " \n");
			de.printStackTrace();
		} finally{
			try{
				ServiceLocator.getInstance().closeConnection(connection);

			} catch(Exception e){
				e.printStackTrace();
			}			
		}
		return null;	
	}	
	
	/**
	 * Devuelve la lista de las operaciones
	 * @param 
	 * @return Collection de objetos OperacionVO
	 * @author gmarroquin
	 */
	public Collection<OperacionVO> obtenerListaOperacion() {
		Connection connection = null;
		
		try {
			connection = ServiceLocator.getInstance().getConnection();
			DAOFactory daoFactory = DAOFactory.getDAOFactory(connection, Constants.DATA_BASE_PROVIDER_ORACLE);
			
			OperacionDAO operacionDAO = daoFactory.getOperacionDAO();
			return operacionDAO.getAll();
		} catch(Exception de){
			System.out.println("\n [ADVERTENCIA]: Metodo <NegocioPOJO>.<obtenerListaOperacion> " + DateUtil.getFechaSistemaCalendar().getTime() +
					"\n NO se pudo obtener la lista de las operaciones." + " \n");
			de.printStackTrace();
		} finally{
			try{
				ServiceLocator.getInstance().closeConnection(connection);

			} catch(Exception e){
				e.printStackTrace();
			}			
		}
		return null;	
	}		
	
	/**
	 * Devuelve la lista de los origenes
	 * @param 
	 * @return Collection de objetos OrigenVO
	 * @author gmarroquin
	 */
	public Collection<OrigenVO> obtenerListaOrigen() {
		Connection connection = null;
		
		try {
			connection = ServiceLocator.getInstance().getConnection();
			DAOFactory daoFactory = DAOFactory.getDAOFactory(connection, Constants.DATA_BASE_PROVIDER_ORACLE);
			
			OrigenDAO origenDAO = daoFactory.getOrigenDAO();
			return origenDAO.getAll();
		} catch(Exception de){
			System.out.println("\n [ADVERTENCIA]: Metodo <NegocioPOJO>.<obtenerListaOrigen> " + DateUtil.getFechaSistemaCalendar().getTime() +
					"\n NO se pudo obtener la lista de los orígenes." + " \n");
			de.printStackTrace();
		} finally{
			try{
				ServiceLocator.getInstance().closeConnection(connection);

			} catch(Exception e){
				e.printStackTrace();
			}			
		}
		return null;	
	}		
	
	/**
	 * Devuelve la lista de los logs
	 * @param EstructuraConsultaDTO estructuraConsultaDTO
	 * @return Collection de objetos EstructuraLogDTO
	 * @author gmarroquin
	 */
	public Collection<EstructuraLogDTO> obtenerListaLogs(EstructuraConsultaDTO estructuraConsultaDTO) {
		Connection connection = null;
		
		try {
			connection = ServiceLocator.getInstance().getConnection();
			ROEFactory roeFactory = ROEFactory.getROEFactory(connection, Constants.DATA_BASE_PROVIDER_ORACLE);
			
			LogROE logROE = roeFactory.getLogROE();
			return logROE.obtenerListaLogs(estructuraConsultaDTO);
		} catch(Exception de){
			System.out.println("\n [ADVERTENCIA]: Metodo <NegocioPOJO>.<obtenerListaLogs> " + DateUtil.getFechaSistemaCalendar().getTime() +
					"\n NO se pudo obtener la lista de los logs." + " \n");
			de.printStackTrace();
		} finally{
			try{
				ServiceLocator.getInstance().closeConnection(connection);

			} catch(Exception e){
				e.printStackTrace();
			}			
		}
		return null;			
	}
	
	/**
	 * Devuelve la lista de códigos de origen
	 * @param EstructuraConsultaDTO estructuraConsultaDTO
	 * @return Collection de objetos String
	 * @author gmarroquin
	 */
	public Collection<String> obtenerListaCodigoOrigen(EstructuraConsultaDTO estructuraConsultaDTO) {
		Connection connection = null;
		
		try {
			connection = ServiceLocator.getInstance().getConnection();
			ROEFactory roeFactory = ROEFactory.getROEFactory(connection, Constants.DATA_BASE_PROVIDER_ORACLE);
			
			LogROE logROE = roeFactory.getLogROE();
			return logROE.obtenerListaCodigoOrigen(estructuraConsultaDTO);
		} catch(Exception de){
			System.out.println("\n [ADVERTENCIA]: Metodo <NegocioPOJO>.<obtenerListaCodigoOrigen> " + DateUtil.getFechaSistemaCalendar().getTime() +
					"\n NO se pudo obtener la lista de códigos de origen." + " \n");
			de.printStackTrace();
		} finally{
			try{
				ServiceLocator.getInstance().closeConnection(connection);

			} catch(Exception e){
				e.printStackTrace();
			}			
		}
		return null;			
	}	
	
	/**
	 * Devuelve la lista de los detalles de los logs
	 * @param Long idTraza
	 * @return Collection de objetos EstructuraDetalleLogDTO
	 * @author gmarroquin
	 */
	public Collection<EstructuraDetalleLogDTO> obtenerListaDetalleLogs(Long idTraza) {
		
		Connection connection = null;
		
		try {
			connection = ServiceLocator.getInstance().getConnection();
			ROEFactory roeFactory = ROEFactory.getROEFactory(connection, Constants.DATA_BASE_PROVIDER_ORACLE);
			
			LogHistorialROE logROE = roeFactory.getLogHistorialROE();
			return logROE.obtenerListaDetalleLogs(idTraza);
		} catch(Exception de){
			System.out.println("\n [ADVERTENCIA]: Metodo <NegocioPOJO>.<obtenerListaDetalleLogs> " + DateUtil.getFechaSistemaCalendar().getTime() +
					"\n NO se pudo obtener la lista de los detalles de los logs." + " \n");
			de.printStackTrace();
		} finally{
			try{
				ServiceLocator.getInstance().closeConnection(connection);

			} catch(Exception e){
				e.printStackTrace();
			}			
		}
		return null;	
	}
	
	/**
	 * Devuelve la lista de los detalles de los logs
	 * @param EstructuraDetalleLogDTO estructuraDetalleLogDTO
	 * @return Collection de objetos EstructuraDetalleLogDTO
	 * @author gmarroquin
	 */	
	public Collection<EstructuraDetalleLogDTO> obtenerListaDetalleLogsByEstructuraConsultaDTO(
			EstructuraConsultaDTO estructuraConsultaDTO) {
		
		Connection connection = null;
		
		try {
			connection = ServiceLocator.getInstance().getConnection();
			ROEFactory roeFactory = ROEFactory.getROEFactory(connection, Constants.DATA_BASE_PROVIDER_ORACLE);
			
			LogHistorialROE logROE = roeFactory.getLogHistorialROE();
			return logROE.obtenerListaDetalleLogsByEstructuraConsultaDTO(estructuraConsultaDTO);
		} catch(Exception de){
			System.out.println("\n [ADVERTENCIA]: Metodo <NegocioPOJO>.<obtenerListaDetalleLogsByEstructuraConsultaDTO> " + DateUtil.getFechaSistemaCalendar().getTime() +
					"\n NO se pudo obtener la lista de los detalles de los logs." + " \n");
			de.printStackTrace();
		} finally{
			try{
				ServiceLocator.getInstance().closeConnection(connection);

			} catch(Exception e){
				e.printStackTrace();
			}			
		}
		return null;	
	}	
	
	/**
	 * Devuelve el objeto a partir de su clave principal
	 * @param OrigenVO llave
	 * @return objeto OrigenVO
	 * @author gmarroquin
	 */	
	public OrigenVO findOrigenVOByPrimaryKey(OrigenVO llave) {		
		Connection connection = null;
		
		try {
			connection = ServiceLocator.getInstance().getConnection();
			DAOFactory daoFactory = DAOFactory.getDAOFactory(connection, Constants.DATA_BASE_PROVIDER_ORACLE);
			
			OrigenDAO origenDAO = daoFactory.getOrigenDAO();
			return origenDAO.findByPrimaryKey(llave);
		} catch(Exception de){
			System.out.println("\n [ADVERTENCIA]: Metodo <NegocioPOJO>.<findOrigenVOByPrimaryKey> " + DateUtil.getFechaSistemaCalendar().getTime() +
					"\n NO se pudo obtener el objeto a partir de su clave principal." + " \n");
			de.printStackTrace();
		} finally{
			try{
				ServiceLocator.getInstance().closeConnection(connection);

			} catch(Exception e){
				e.printStackTrace();
			}			
		}
		return null;
	}
	
	/**
	 * Devuelve el objeto a partir de su clave principal
	 * @param AplicacionVO llave
	 * @return objeto AplicacionVO
	 * @exception DAOException
	 * @author gmarroquin
	 */	
	public AplicacionVO findAplicacionVOByPrimaryKey(AplicacionVO llave) {		
		Connection connection = null;
		
		try {
			connection = ServiceLocator.getInstance().getConnection();
			DAOFactory daoFactory = DAOFactory.getDAOFactory(connection, Constants.DATA_BASE_PROVIDER_ORACLE);
			
			AplicacionDAO aplicacionDAO = daoFactory.getAplicacionDAO();
			return aplicacionDAO.findByPrimaryKey(llave);
		} catch(Exception de){
			System.out.println("\n [ADVERTENCIA]: Metodo <NegocioPOJO>.<findAplicacionVOByPrimaryKey> " + DateUtil.getFechaSistemaCalendar().getTime() +
					"\n NO se pudo obtener el objeto a partir de su clave principal." + " \n");
			de.printStackTrace();
		} finally{
			try{
				ServiceLocator.getInstance().closeConnection(connection);

			} catch(Exception e){
				e.printStackTrace();
			}			
		}
		return null;
	}
	
	/**
	 * Devuelve el objeto a partir de su clave principal
	 * @param OperacionVO llave
	 * @return objeto OperacionVO
	 * @author gmarroquin
	 */	
	public OperacionVO findOperacionVOByPrimaryKey(OperacionVO llave) {		
		Connection connection = null;
		
		try {
			connection = ServiceLocator.getInstance().getConnection();
			DAOFactory daoFactory = DAOFactory.getDAOFactory(connection, Constants.DATA_BASE_PROVIDER_ORACLE);
			
			OperacionDAO operacionDAO = daoFactory.getOperacionDAO();
			return operacionDAO.findByPrimaryKey(llave);
		} catch(Exception de){
			System.out.println("\n [ADVERTENCIA]: Metodo <NegocioPOJO>.<findOperacionVOByPrimaryKey> " + DateUtil.getFechaSistemaCalendar().getTime() +
					"\n NO se pudo obtener el objeto a partir de su clave principal." + " \n");
			de.printStackTrace();
		} finally{
			try{
				ServiceLocator.getInstance().closeConnection(connection);

			} catch(Exception e){
				e.printStackTrace();
			}			
		}
		return null;
	}
	
	/**
	 * Devuelve el objeto a partir de su clave principal
	 * @param ModuloVO llave
	 * @return objeto ModuloVO
	 * @author gmarroquin
	 */	
	public ModuloVO findModuloVOByPrimaryKey(ModuloVO llave) {		
		Connection connection = null;
		
		try {
			connection = ServiceLocator.getInstance().getConnection();
			DAOFactory daoFactory = DAOFactory.getDAOFactory(connection, Constants.DATA_BASE_PROVIDER_ORACLE);
			
			ModuloDAO moduloDAO = daoFactory.getModuloDAO();
			return moduloDAO.findByPrimaryKey(llave);
		} catch(Exception de){
			System.out.println("\n [ADVERTENCIA]: Metodo <NegocioPOJO>.<findModuloVOByPrimaryKey> " + DateUtil.getFechaSistemaCalendar().getTime() +
					"\n NO se pudo obtener el objeto a partir de su clave principal." + " \n");
			de.printStackTrace();
		} finally{
			try{
				ServiceLocator.getInstance().closeConnection(connection);

			} catch(Exception e){
				e.printStackTrace();
			}			
		}
		return null;
	}	
	
	/**
	 * Devuelve la lista de los modulos por IdAplicacion
	 * @param Integer idAplicacion
	 * @return Collection de objetos ModuloVO
	 * @author gmarroquin
	 */
	public Collection<ModuloVO> obtenerListaModuloPorIdAplicacion(Integer idAplicacion) {
		Connection connection = null;
		
		try {
			connection = ServiceLocator.getInstance().getConnection();
			DAOFactory daoFactory = DAOFactory.getDAOFactory(connection, Constants.DATA_BASE_PROVIDER_ORACLE);
			
			ModuloDAO moduloDAO = daoFactory.getModuloDAO();
			return moduloDAO.findByIdAplicacion(idAplicacion);
		} catch(Exception de){
			System.out.println("\n [ADVERTENCIA]: Metodo <NegocioPOJO>.<obtenerListaModuloPorIdAplicacion> " + DateUtil.getFechaSistemaCalendar().getTime() +
					"\n NO se pudo obtener la lista de los módulos por IdAplicacion." + " \n");
			de.printStackTrace();
		} finally{
			try{
				ServiceLocator.getInstance().closeConnection(connection);

			} catch(Exception e){
				e.printStackTrace();
			}			
		}
		return null;	
	}	
	
	/**
	 * Devuelve la lista de las operaciones por IdModulo
	 * @param Integer idModulo
	 * @return Collection de objetos OperacionVO
	 * @author gmarroquin
	 */
	public Collection<OperacionVO> obtenerListaOperacionPorIdModulo(Integer idModulo) {
		Connection connection = null;
		
		try {
			connection = ServiceLocator.getInstance().getConnection();
			DAOFactory daoFactory = DAOFactory.getDAOFactory(connection, Constants.DATA_BASE_PROVIDER_ORACLE);
			
			OperacionDAO operacionDAO = daoFactory.getOperacionDAO();
			return operacionDAO.findByIdModulo(idModulo);
		} catch(Exception de){
			System.out.println("\n [ADVERTENCIA]: Metodo <NegocioPOJO>.<obtenerListaOperacionPorIdModulo> " + DateUtil.getFechaSistemaCalendar().getTime() +
					"\n NO se pudo obtener la lista de las operaciones por IdModulo." + " \n");
			de.printStackTrace();
		} finally{
			try{
				ServiceLocator.getInstance().closeConnection(connection);

			} catch(Exception e){
				e.printStackTrace();
			}			
		}
		return null;	
	}		
	
	/**
	 * Devuelve la lista de los origenes por IdAplicacion
	 * @param Integer idAplicacion
	 * @return Collection de objetos OrigenVO
	 * @author gmarroquin
	 */
	public Collection<OrigenVO> obtenerListaOrigenPorIdAplicacion(Integer idAplicacion) {
		Connection connection = null;
		
		try {
			connection = ServiceLocator.getInstance().getConnection();
			DAOFactory daoFactory = DAOFactory.getDAOFactory(connection, Constants.DATA_BASE_PROVIDER_ORACLE);
			
			OrigenDAO origenDAO = daoFactory.getOrigenDAO();
			return origenDAO.findByIdAplicacion(idAplicacion);
		} catch(Exception de){
			System.out.println("\n [ADVERTENCIA]: Metodo <NegocioPOJO>.<obtenerListaOrigenPorIdAplicacion> " + DateUtil.getFechaSistemaCalendar().getTime() +
					"\n NO se pudo obtener la lista de los orígenes por IdAplicacion." + " \n");
			de.printStackTrace();
		} finally{
			try{
				ServiceLocator.getInstance().closeConnection(connection);

			} catch(Exception e){
				e.printStackTrace();
			}			
		}
		return null;	
	}		

	/**
	 * Devuelve el objeto a partir de su idTablaAuditoria, valorAuditoria y idTablaReferencia
	 * @param HomologacionVO llave
	 * @return objeto HomologacionVO
	 * @author gmarroquin
	 */		
	public HomologacionVO obtenerHomologacionVOPorIdTblAuditYValAuditYIdTblRef(HomologacionVO llave) {		
		Connection connection = null;
		
		try {
			connection = ServiceLocator.getInstance().getConnection();
			DAOFactory daoFactory = DAOFactory.getDAOFactory(connection, Constants.DATA_BASE_PROVIDER_ORACLE);
			
			HomologacionDAO homologacionDAO = daoFactory.getHomologacionDAO();
			return homologacionDAO.findByIdTblAuditAndValAuditAndIdTblRef(llave);
		} catch(Exception de){
			System.out.println("\n [ADVERTENCIA]: Metodo <NegocioPOJO>.<obtenerHomologacionVOPorIdTblAuditYValAuditYIdTblRef> " + DateUtil.getFechaSistemaCalendar().getTime() +
					"\n NO se pudo obtener el objeto a partir de su idTablaAuditoria, valorAuditoria y idTablaReferencia." + " \n");
			de.printStackTrace();
		} finally{
			try{
				ServiceLocator.getInstance().closeConnection(connection);

			} catch(Exception e){
				e.printStackTrace();
			}			
		}
		return null;
	}	
}
