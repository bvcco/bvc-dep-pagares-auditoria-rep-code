package com.deceval.auditoria.integration;

import java.util.Collection;

import com.deceval.auditoria.dto.EstructuraConsultaDTO;
import com.deceval.auditoria.dto.EstructuraDetalleLogDTO;
import com.deceval.auditoria.dto.EstructuraLogDTO;
import com.deceval.auditoria.dto.RequestMsgInsertAudObjectDTO;
import com.deceval.auditoria.exception.LogicException;
import com.deceval.auditoria.integration.remote.NegocioRemote;
import com.deceval.auditoria.util.properties.PropertiesLoader;
import com.deceval.auditoria.vo.AplicacionVO;
import com.deceval.auditoria.vo.HomologacionVO;
import com.deceval.auditoria.vo.ModuloVO;
import com.deceval.auditoria.vo.OperacionVO;
import com.deceval.auditoria.vo.OrigenVO;

public class NegocioDelegate extends BaseDelegate {
	
	/**
	 * Nombre de la propiedad que tiene el nombre JNDI del EJB 3.0
	 */
	private static final String FACADE_NAME = "NegocioFacade";

	private static final String TIP = new StringBuffer().append(
			"HINT: The delegate can not invoke a reference  ").append(
			"\n Configure the property [NegociacionFacade] in the ").append(
			"properties file").toString();

	private String value = null;
	
	/**
	 * Obtiene el EJB que implementa la interface que debe cumplir el modulo de auditoria
	 * @return ModuloAuditoriaRemote ejb que implementa los servicios que requiere prestar el modulo de registro
	 * @throws LogicException
	 */
	private NegocioRemote getRemoteInterface() throws LogicException {
		try {
			try {
				if (value == null) {
					value = PropertiesLoader.loadProperty(FACADE_NAME);
				}
			} catch (Exception e) {
				throw new LogicException("", "", e);
			}

			NegocioRemote moduloAuditoriaRemote = (NegocioRemote) this.getDecevalRemote(value);
			return moduloAuditoriaRemote;
		} catch (Exception e) {
			throw new LogicException("", "", e);
		}
	}
	
	
	/**
	 * Hace llamado a EJB para inicio del proceso de registro de anotacion en LOG
	 * @throws LogicException
	 * @author ffonsacos
	 */
	public void crearAnotacionLog(RequestMsgInsertAudObjectDTO reqMsgObj) throws LogicException{
		try {
			getRemoteInterface().crearAnotacionLog(reqMsgObj);
		} catch (Exception e) {
			throw new LogicException("REGISTRO-L-001", "No fue posible iniciar el proceso de anotacion en LOG.", e);
		}
	}
	
	/**
	 * Inicio de proceso para envio a cola de mensajeria
	 * @param log
	 * @return
	 * @throws LogicException
	 */
	public String sendAnotacionLog2Queue(RequestMsgInsertAudObjectDTO reqMsgObj)throws LogicException{
		String resultado = null;
		try {
			resultado = getRemoteInterface().sendAnotacionLog2Queue(reqMsgObj);
		} catch (Exception e) {
			throw new LogicException("REGISTRO-L-001", "No fue posible iniciar el proceso de envio a cola anotacion en LOG.", e);
		}
		return resultado;
	}
	
	/**
	 * Devuelve la lista de las aplicaciones
	 * @param 
	 * @return Collection de objetos AplicacionVO
	 * @author gmarroquin
	 * @throws LogicException 
	 */
	public Collection<AplicacionVO> obtenerListaAplicacion() throws LogicException {
		Collection<AplicacionVO> resultado = null;
		try {
			resultado = getRemoteInterface().obtenerListaAplicacion();
		} catch (LogicException e) {
			throw new LogicException
				("REGISTRO-L-001", "No fue posible iniciar el proceso de obtenerListaAplicacion.", e);
		}
		return resultado;
	}
	
	/**
	 * Devuelve la lista de los modulos
	 * @param 
	 * @return Collection de objetos ModuloVO
	 * @author gmarroquin
	 * @throws LogicException 
	 */
	public Collection<ModuloVO> obtenerListaModulo() throws LogicException {
		Collection<ModuloVO> resultado = null;
		try {
			resultado = getRemoteInterface().obtenerListaModulo();
		} catch (LogicException e) {
			throw new LogicException
				("REGISTRO-L-001", "No fue posible iniciar el proceso de obtenerListaModulo.", e);
		}
		return resultado;
	}
	
	/**
	 * Devuelve la lista de las operaciones
	 * @param 
	 * @return Collection de objetos OperacionVO
	 * @author gmarroquin
	 * @throws LogicException 
	 */
	public Collection<OperacionVO> obtenerListaOperacion() throws LogicException {
		Collection<OperacionVO> resultado = null;
		try {
			resultado = getRemoteInterface().obtenerListaOperacion();
		} catch (LogicException e) {
			throw new LogicException
				("REGISTRO-L-001", "No fue posible iniciar el proceso de obtenerListaOperacion.", e);
		}
		return resultado;
	}	

	/**
	 * Devuelve la lista de los origenes
	 * @param 
	 * @return Collection de objetos OrigenVO
	 * @author gmarroquin
	 * @throws LogicException 
	 */
	public Collection<OrigenVO> obtenerListaOrigen() throws LogicException {
		Collection<OrigenVO> resultado = null;
		try {
			resultado = getRemoteInterface().obtenerListaOrigen();
		} catch (LogicException e) {
			throw new LogicException
				("REGISTRO-L-001", "No fue posible iniciar el proceso de obtenerListaOrigen.", e);
		}
		return resultado;
	}	
	
	/**
	 * Devuelve la lista de los logs
	 * @param EstructuraConsultaDTO estructuraConsultaDTO
	 * @return Collection de objetos EstructuraLogDTO
	 * @author gmarroquin
	 * @throws LogicException 
	 */
	public Collection<EstructuraLogDTO> obtenerListaLogs(EstructuraConsultaDTO estructuraConsultaDTO) throws LogicException {
		Collection<EstructuraLogDTO> resultado = null;
		try {
			resultado = getRemoteInterface().obtenerListaLogs(estructuraConsultaDTO);
		} catch (LogicException e) {
			throw new LogicException
				("REGISTRO-L-001", "No fue posible iniciar el proceso de obtenerListaLogs.", e);
		}
		return resultado;
	}	
	
	/**
	 * Devuelve la lista de códigos de origen
	 * @param EstructuraConsultaDTO estructuraConsultaDTO
	 * @return Collection de objetos String
	 * @author gmarroquin
	 * @throws LogicException 
	 */
	public Collection<String> obtenerListaCodigoOrigen(EstructuraConsultaDTO estructuraConsultaDTO) throws LogicException {
		Collection<String> resultado = null;
		try {
			resultado = getRemoteInterface().obtenerListaCodigoOrigen(estructuraConsultaDTO);
		} catch (LogicException e) {
			throw new LogicException
				("REGISTRO-L-001", "No fue posible iniciar el proceso de obtenerListaCodigoOrigen.", e);
		}
		return resultado;
	}	
	
	/**
	 * Devuelve la lista de los detalles de los logs
	 * @param Long idTraza
	 * @return Collection de objetos EstructuraDetalleLogDTO
	 * @author gmarroquin
	 * @throws LogicException 
	 */
	public Collection<EstructuraDetalleLogDTO> obtenerListaDetalleLogs(Long idTraza) throws LogicException {
		Collection<EstructuraDetalleLogDTO> resultado = null;
		try {
			resultado = getRemoteInterface().obtenerListaDetalleLogs(idTraza);
		} catch (LogicException e) {
			throw new LogicException
				("REGISTRO-L-001", "No fue posible iniciar el proceso de obtenerListaDetalleLogs.", e);
		}
		return resultado;
	}		
	
	/**
	 * Devuelve la lista de los detalles de los logs
	 * @param EstructuraDetalleLogDTO estructuraDetalleLogDTO
	 * @return Collection de objetos EstructuraDetalleLogDTO
	 * @author gmarroquin
	 * @throws LogicException 
	 */	
	public Collection<EstructuraDetalleLogDTO> obtenerListaDetalleLogsByEstructuraConsultaDTO(
			EstructuraConsultaDTO estructuraConsultaDTO) throws LogicException {
		Collection<EstructuraDetalleLogDTO> resultado = null;
		try {
			resultado = getRemoteInterface().obtenerListaDetalleLogsByEstructuraConsultaDTO(estructuraConsultaDTO);
		} catch (LogicException e) {
			throw new LogicException
				("REGISTRO-L-001", "No fue posible iniciar el proceso de obtenerListaDetalleLogsByEstructuraConsultaDTO.", e);
		}
		return resultado;
	}
	
	/**
	 * Devuelve el objeto a partir de su clave principal
	 * @param ModuloVO llave
	 * @return objeto ModuloVO
	 * @author gmarroquin
	 * @throws LogicException 
	 */	
	public OrigenVO findOrigenVOByPrimaryKey(OrigenVO llave) throws LogicException {
		OrigenVO resultado = null;
		try {
			resultado = getRemoteInterface().findOrigenVOByPrimaryKey(llave);
		} catch (LogicException e) {
			throw new LogicException
				("REGISTRO-L-001", "No fue posible iniciar el proceso de findOrigenVOByPrimaryKey.", e);
		}
		return resultado;
	}
	
	/**
	 * Devuelve el objeto a partir de su clave principal
	 * @param AplicacionVO llave
	 * @return objeto AplicacionVO
	 * @author gmarroquin
	 * @throws LogicException 
	 */	
	public AplicacionVO findAplicacionVOByPrimaryKey(AplicacionVO llave) throws LogicException {
		AplicacionVO resultado = null;
		try {
			resultado = getRemoteInterface().findAplicacionVOByPrimaryKey(llave);
		} catch (LogicException e) {
			throw new LogicException
				("REGISTRO-L-001", "No fue posible iniciar el proceso de findAplicacionVOByPrimaryKey.", e);
		}
		return resultado;
	}
	
	/**
	 * Devuelve el objeto a partir de su clave principal
	 * @param OperacionVO llave
	 * @return objeto OperacionVO
	 * @author gmarroquin
	 * @throws LogicException 
	 */	
	public OperacionVO findOperacionVOByPrimaryKey(OperacionVO llave) throws LogicException {
		OperacionVO resultado = null;
		try {
			resultado = getRemoteInterface().findOperacionVOByPrimaryKey(llave);
		} catch (LogicException e) {
			throw new LogicException
				("REGISTRO-L-001", "No fue posible iniciar el proceso de findOperacionVOByPrimaryKey.", e);
		}
		return resultado;
	}
	
	/**
	 * Devuelve el objeto a partir de su clave principal
	 * @param ModuloVO llave
	 * @return objeto ModuloVO
	 * @author gmarroquin
	 * @throws LogicException 
	 */	
	public ModuloVO findModuloVOByPrimaryKey(ModuloVO llave) throws LogicException {
		ModuloVO resultado = null;
		try {
			resultado = getRemoteInterface().findModuloVOByPrimaryKey(llave);
		} catch (LogicException e) {
			throw new LogicException
				("REGISTRO-L-001", "No fue posible iniciar el proceso de findModuloVOByPrimaryKey.", e);
		}
		return resultado;
	}
	
	/**
	 * Devuelve la lista de los modulos por IdAplicacion
	 * @param Integer idAplicacion
	 * @return Collection de objetos ModuloVO
	 * @author gmarroquin
	 * @throws LogicException 
	 */
	public Collection<ModuloVO> obtenerListaModuloPorIdAplicacion(Integer idAplicacion) throws LogicException {
		Collection<ModuloVO> resultado = null;
		try {
			resultado = getRemoteInterface().obtenerListaModuloPorIdAplicacion(idAplicacion);
		} catch (LogicException e) {
			throw new LogicException
				("REGISTRO-L-001", "No fue posible iniciar el proceso de obtenerListaModuloPorIdAplicacion.", e);
		}
		return resultado;
	}
	
	/**
	 * Devuelve la lista de las operaciones por IdModulo
	 * @param Integer idModulo
	 * @return Collection de objetos OperacionVO
	 * @author gmarroquin
	 * @throws LogicException 
	 */
	public Collection<OperacionVO> obtenerListaOperacionPorIdModulo(Integer idModulo) throws LogicException {
		Collection<OperacionVO> resultado = null;
		try {
			resultado = getRemoteInterface().obtenerListaOperacionPorIdModulo(idModulo);
		} catch (LogicException e) {
			throw new LogicException
				("REGISTRO-L-001", "No fue posible iniciar el proceso de obtenerListaOperacionPorIdModulo.", e);
		}
		return resultado;
	}	

	/**
	 * Devuelve la lista de los origenes por IdAplicacion
	 * @param Integer idAplicacion
	 * @return Collection de objetos OrigenVO
	 * @author gmarroquin
	 * @throws LogicException 
	 */
	public Collection<OrigenVO> obtenerListaOrigenPorIdAplicacion(Integer idAplicacion) throws LogicException {
		Collection<OrigenVO> resultado = null;
		try {
			resultado = getRemoteInterface().obtenerListaOrigenPorIdAplicacion(idAplicacion);
		} catch (LogicException e) {
			throw new LogicException
				("REGISTRO-L-001", "No fue posible iniciar el proceso de obtenerListaOrigenPorIdAplicacion.", e);
		}
		return resultado;
	}		
	
	/**
	 * Devuelve el objeto a partir de su idTablaAuditoria, valorAuditoria y idTablaReferencia
	 * @param HomologacionVO llave
	 * @return objeto HomologacionVO
	 * @author gmarroquin
	 * @throws LogicException 
	 */
	public HomologacionVO obtenerHomologacionVOPorIdTblAuditYValAuditYIdTblRef(HomologacionVO llave) throws LogicException {
		HomologacionVO resultado = null;
		try {
			resultado = getRemoteInterface().obtenerHomologacionVOPorIdTblAuditYValAuditYIdTblRef(llave);
		} catch (LogicException e) {
			throw new LogicException
				("REGISTRO-L-001", "No fue posible iniciar el proceso de obtenerHomologacionVOPorIdTblAuditYValAuditYIdTblRef.", e);
		}
		return resultado;
	}	
}
