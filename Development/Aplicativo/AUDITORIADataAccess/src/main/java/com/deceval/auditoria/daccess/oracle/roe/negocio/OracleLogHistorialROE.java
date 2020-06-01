package com.deceval.auditoria.daccess.oracle.roe.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import com.deceval.auditoria.daccess.oracle.roe.OracleBaseROE;
import com.deceval.auditoria.daccess.roe.negocio.LogHistorialROE;
import com.deceval.auditoria.dto.EstructuraConsultaDTO;
import com.deceval.auditoria.dto.EstructuraDetalleDetalleLogDTO;
import com.deceval.auditoria.dto.EstructuraDetalleLogDTO;
import com.deceval.auditoria.exception.DAOException;
import com.deceval.auditoria.util.converter.DateTypeConverter;
import com.deceval.auditoria.vo.LogHistorialVO;
import com.deceval.auditoria.vo.LogVO;
import com.deceval.auditoria.vo.ObjetoAtributoVO;
import com.deceval.auditoria.vo.ObjetoVO;

public class OracleLogHistorialROE extends OracleBaseROE  implements LogHistorialROE {
	
	private final static String CLASS_NAME = "OracleLogHistorialROE";
	
	private final static String TABLA_OBJETO 						= "AUD_OBJETO";
	private final static String TABLA_OBJETOATRIBUTO 				= "AUD_OBJETOATRIBUTO";
	private final static String TABLA_LOGHISTORIAL 					= "AUD_LOGHISTORIAL";	
	private final static String TABLA_LOG 							= "AUD_LOG";	
	private final static String TABLA_OPERACION					 	= "AUD_OPERACION";
	private final static String TABLA_MODULO 						= "AUD_MODULO";
	
	//Campos tabla AUD_OBJETO
	private final static String CAMPO_OBJETO_IDOBJETO 				= "IDOBJETO";
	private final static String CAMPO_OBJETO_IDAPLICACION			= "IDAPLICACION";
	private final static String CAMPO_OBJETO_NOMBRETABLA 			= "NOMBRETABLA";
	private final static String CAMPO_OBJETO_TITULOTABLA 			= "TITULOTABLA";
	
	//Campos tabla AUD_OBJETOATRIBUTO
	private final static String CAMPO_OBJETOATRIBUTO_IDATRIBUTO 	= "IDATRIBUTO";
	private final static String CAMPO_OBJETOATRIBUTO_IDOBJETO 		= "IDOBJETO";
	private final static String CAMPO_OBJETOATRIBUTO_NOMBRECAMPO 	= "NOMBRECAMPO";
	private final static String CAMPO_OBJETOATRIBUTO_ORDENCAMPO 	= "ORDENCAMPO";	
	
	//Campos tabla AUD_LOGHISTORIAL
	private final static String CAMPO_LOGHISTORIAL_IDHISTORIAL 		= "IDHISTORIAL";
	private final static String CAMPO_LOGHISTORIAL_IDATRIBUTO 		= "IDATRIBUTO";
	private final static String CAMPO_LOGHISTORIAL_IDTRAZA 			= "IDTRAZA";
	private final static String CAMPO_LOGHISTORIAL_VALORATRIBUTO 	= "VALORATRIBUTO";	
		
	//Campos tabla AUD_LOG
	private final static String CAMPO_LOG_IDORIGEN = "IDORIGEN";
	private final static String CAMPO_LOG_IDOPERACION = "IDOPERACION";	
	private final static String CAMPO_LOG_CODIGOORIGEN = "CODIGOORIGEN";
	private final static String CAMPO_LOG_USERNAME = "USERNAME";		
	private final static String CAMPO_LOG_FECHAANOTACION = "FECHAANOTACION";
	private final static String CAMPO_LOG_IDTRAZA = "IDTRAZA";
	private final static String CAMPO_LOG_IPUSUARIO = "IPUSUARIO";
	private final static String CAMPO_LOG_DESCRIPCIONANOTACION = "DESCRIPCIONANOTACION";
	
	//Campos tabla AUD_OPERACION
	private final static String CAMPO_OPERACION_IDOPERACION = "IDOPERACION";
	private final static String CAMPO_OPERACION_IDMODULO = "IDMODULO";
	
	//Campos tabla AUD_MODULO
	private final static String CAMPO_MODULO_IDMODULO = "IDMODULO";
	private final static String CAMPO_MODULO_IDAPLICACION = "IDAPLICACION";	
	
	private final static String FIND_ESTRUCT_DET_LOG_BY_IDTRAZA_SELECT = 	
		" SELECT " + 
		"OBJ." + CAMPO_OBJETO_IDOBJETO + ", " +
		"OBJ." + CAMPO_OBJETO_IDAPLICACION + ", " +
		"OBJ." + CAMPO_OBJETO_NOMBRETABLA + ", " +
		"OBJ." + CAMPO_OBJETO_TITULOTABLA + ", " +		
		"OAT." + CAMPO_OBJETOATRIBUTO_IDATRIBUTO + ", " +
		"OAT." + CAMPO_OBJETOATRIBUTO_NOMBRECAMPO + ", " +
		"OAT." + CAMPO_OBJETOATRIBUTO_ORDENCAMPO + ", " +	
		"HIS." + CAMPO_LOGHISTORIAL_IDHISTORIAL + ", " +	
		"HIS." + CAMPO_LOGHISTORIAL_VALORATRIBUTO + " ";		
	
	private final static String FIND_ESTRUCT_DET_LOG_BY_IDTRAZA_FROM = 
		" FROM " + TABLA_OBJETO + " OBJ " +
		" INNER JOIN " + TABLA_OBJETOATRIBUTO + " OAT ON (OBJ." + CAMPO_OBJETO_IDOBJETO + "=OAT." + CAMPO_OBJETOATRIBUTO_IDOBJETO + ") " +
		" INNER JOIN " + TABLA_LOGHISTORIAL + " HIS ON (OAT." + CAMPO_OBJETOATRIBUTO_IDATRIBUTO + "=HIS." + CAMPO_LOGHISTORIAL_IDATRIBUTO + ") ";		
	
	private final static String FIND_ESTRUCT_DET_LOG_BY_IDTRAZA_WHERE = 	
		" WHERE HIS." + CAMPO_LOGHISTORIAL_IDTRAZA + "=? ";		
	
	private final static String FIND_ESTRUCT_DET_LOG_BY_IDTRAZA_ORDERBY = 	
		" ORDER BY 1 ";		
	
	private final static String FIND_ESTRUCTURA_LOG_BY_IDTRAZA = 
		FIND_ESTRUCT_DET_LOG_BY_IDTRAZA_SELECT +
		FIND_ESTRUCT_DET_LOG_BY_IDTRAZA_FROM +		
		FIND_ESTRUCT_DET_LOG_BY_IDTRAZA_WHERE +
		FIND_ESTRUCT_DET_LOG_BY_IDTRAZA_ORDERBY;
	
	private final static String FIND_ESTRUCT_DET_LOG_BY_ESTRUCTURA_CONSULTA_SELECT = 	
		" SELECT " + 
		"OBJ." + CAMPO_OBJETO_IDOBJETO + ", " +
		"OBJ." + CAMPO_OBJETO_IDAPLICACION + ", " +
		"OBJ." + CAMPO_OBJETO_NOMBRETABLA + ", " +
		"OBJ." + CAMPO_OBJETO_TITULOTABLA + ", " +		
		"OAT." + CAMPO_OBJETOATRIBUTO_IDATRIBUTO + ", " +
		"OAT." + CAMPO_OBJETOATRIBUTO_NOMBRECAMPO + ", " +
		"OAT." + CAMPO_OBJETOATRIBUTO_ORDENCAMPO + ", " +	
		"HIS." + CAMPO_LOGHISTORIAL_IDHISTORIAL + ", " +	
		"HIS." + CAMPO_LOGHISTORIAL_VALORATRIBUTO + ", " +	
		"HIS." + CAMPO_LOGHISTORIAL_IDTRAZA + ", " +
		"LO." + CAMPO_LOG_USERNAME + ", " +
		"LO." + CAMPO_LOG_FECHAANOTACION + ", " +		
		"LO." + CAMPO_LOG_IPUSUARIO + ", " +
		"LO." + CAMPO_LOG_CODIGOORIGEN + ", " +
		"LO." + CAMPO_LOG_DESCRIPCIONANOTACION + ", " +
		"LO." + CAMPO_LOG_IDTRAZA + ", " +	
		"LO." + CAMPO_LOG_IDORIGEN + ", " +	
		"LO." + CAMPO_LOG_IDOPERACION + " ";		
	
	private final static String FIND_ESTRUCT_DET_LOG_BY_ESTRUCTURA_CONSULTA_ORDERBY = 	
		" ORDER BY 1 ";		
	
	private final static String FIND_ESTRUCT_DET_LOG_BY_ESTRUCTURA_CONSULTA_FROM = 
		" FROM " + TABLA_OBJETO + " OBJ " +
		" INNER JOIN " + TABLA_OBJETOATRIBUTO + " OAT ON (OBJ." + CAMPO_OBJETO_IDOBJETO + "=OAT." + CAMPO_OBJETOATRIBUTO_IDOBJETO + ") " +
		" INNER JOIN " + TABLA_LOGHISTORIAL + " HIS ON (OAT." + CAMPO_OBJETOATRIBUTO_IDATRIBUTO + "=HIS." + CAMPO_LOGHISTORIAL_IDATRIBUTO + ") " + 
		" INNER JOIN " + TABLA_LOG + " LO ON (LO." + CAMPO_LOG_IDTRAZA + "=HIS." + CAMPO_LOGHISTORIAL_IDTRAZA + ") " +
		" INNER JOIN " + TABLA_OPERACION + " OP ON (OP." + CAMPO_OPERACION_IDOPERACION + "=LO." + CAMPO_LOG_IDOPERACION + ") " +
		" INNER JOIN " + TABLA_MODULO + " MD ON (OP." + CAMPO_OPERACION_IDMODULO + "=MD." + CAMPO_MODULO_IDMODULO + ") ";	
	
	// En la siguiente parte de sentencia van los siguientes parámetros:
	//  1- idAplicacion
	//  2- idModulo
	//  3- idOrigen
	//  4- codigoOrigen
	//  5- userName
	//  67- fechaAnotacion (ENTRE FECHA INICIAL Y FINAL)	
	private final static String FIND_ESTRUCT_DET_LOG_BY_ESTRUCTURA_CONSULTA_WHERE_APORCOMDUNFA = 	
		" WHERE MD." + CAMPO_MODULO_IDAPLICACION + "=? " + 
		" AND MD." + CAMPO_MODULO_IDMODULO + "=? " + 
		" AND LO." + CAMPO_LOG_IDORIGEN + "=? " +
		" AND LO." + CAMPO_LOG_CODIGOORIGEN + "=? " + 
		" AND LO." + CAMPO_LOG_USERNAME + "=? " +
		" AND LO." + CAMPO_LOG_FECHAANOTACION + " BETWEEN ? AND ? ";		
	
	// En la siguiente parte de sentencia van los siguientes parámetros:
	//  1- idAplicacion
	//  2- idModulo
	//  3- idOrigen
	//  4- codigoOrigen
	//  56- fechaAnotacion (ENTRE FECHA INICIAL Y FINAL)	
	private final static String FIND_ESTRUCT_DET_LOG_BY_ESTRUCTURA_CONSULTA_WHERE_APORCOMDFA = 	
		" WHERE MD." + CAMPO_MODULO_IDAPLICACION + "=? " + 
		" AND MD." + CAMPO_MODULO_IDMODULO + "=? " + 
		" AND LO." + CAMPO_LOG_IDORIGEN + "=? " +
		" AND LO." + CAMPO_LOG_CODIGOORIGEN + "=? " + 
		" AND LO." + CAMPO_LOG_FECHAANOTACION + " BETWEEN ? AND ? ";		
	
	private final static String FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_APORCOMDUNFA = 
		FIND_ESTRUCT_DET_LOG_BY_ESTRUCTURA_CONSULTA_SELECT +
		FIND_ESTRUCT_DET_LOG_BY_ESTRUCTURA_CONSULTA_FROM +
		FIND_ESTRUCT_DET_LOG_BY_ESTRUCTURA_CONSULTA_WHERE_APORCOMDUNFA +
		FIND_ESTRUCT_DET_LOG_BY_ESTRUCTURA_CONSULTA_ORDERBY;
	
	private final static String FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_APORCOMDFA = 
		FIND_ESTRUCT_DET_LOG_BY_ESTRUCTURA_CONSULTA_SELECT +
		FIND_ESTRUCT_DET_LOG_BY_ESTRUCTURA_CONSULTA_FROM +
		FIND_ESTRUCT_DET_LOG_BY_ESTRUCTURA_CONSULTA_WHERE_APORCOMDFA +		
		FIND_ESTRUCT_DET_LOG_BY_ESTRUCTURA_CONSULTA_ORDERBY;
	
	/**
	 * Devuelve la lista de los detalles de los logs
	 * @param Long idTraza
	 * @return Collection de objetos EstructuraDetalleLogDTO
	 * @author gmarroquin
	 * @throws DAOException 
	 */	
	public Collection<EstructuraDetalleLogDTO> obtenerListaDetalleLogs(
			Long idTraza) throws DAOException {
		PreparedStatement 	sentencia 			= null;
		ResultSet 			resultado 			= null;
		Integer 			idAplicacion;
		Integer 			idObjeto;
		Integer 			idAtributo;
		Integer				ordenCampo;
		Long	 			idHistorial;		
		String 				nombreTabla;
		String 				tituloTabla;
		String 				nombreCampo;
		String 				valorAtributo;
		
		Integer 			anteriorIdObjeto 	= null;
		boolean				haIniciadoBucle 	= false;
		Integer 			anteriorIdAtributo 	= null;
		
		ArrayList<EstructuraDetalleLogDTO> 			coleccionARetornar 				= new ArrayList<EstructuraDetalleLogDTO>();
		EstructuraDetalleLogDTO 					estructuraDetalleLogDTO 		= null;
		ObjetoVO 									objetoVO						= null;
		ArrayList<EstructuraDetalleDetalleLogDTO> 	detalle							= null;
		EstructuraDetalleDetalleLogDTO 				estructuraDetalleDetalleLogDTO	= null;
		ObjetoAtributoVO 							objetoAtributoVO				= null;
		ArrayList<LogHistorialVO> 					coleccionLogHistorial			= null;
		LogHistorialVO 								logHistorialVO					= null;

		try {
			if (this.getConnection() != null) {
				sentencia = this.getConnection().prepareStatement(FIND_ESTRUCTURA_LOG_BY_IDTRAZA);
				sentencia.setLong(1, idTraza);
				resultado = sentencia.executeQuery();
				
				if(resultado == null) return coleccionARetornar;
				
				while(resultado.next()) {
					idAplicacion	= resultado.getInt		(CAMPO_OBJETO_IDAPLICACION);
					idObjeto		= resultado.getInt		(CAMPO_OBJETO_IDOBJETO);
					idAtributo		= resultado.getInt		(CAMPO_OBJETOATRIBUTO_IDATRIBUTO);
					ordenCampo		= resultado.getInt		(CAMPO_OBJETOATRIBUTO_ORDENCAMPO);
					idHistorial		= resultado.getLong		(CAMPO_LOGHISTORIAL_IDHISTORIAL);
					nombreTabla		= resultado.getString	(CAMPO_OBJETO_NOMBRETABLA);
					tituloTabla		= resultado.getString	(CAMPO_OBJETO_TITULOTABLA);
					nombreCampo		= resultado.getString	(CAMPO_OBJETOATRIBUTO_NOMBRECAMPO);
					valorAtributo	= resultado.getString	(CAMPO_LOGHISTORIAL_VALORATRIBUTO);				
					
					if(! haIniciadoBucle) {
						haIniciadoBucle 	= true;
						anteriorIdObjeto 			= idObjeto;
						estructuraDetalleLogDTO 	= new EstructuraDetalleLogDTO();
						objetoVO					= new ObjetoVO();
						objetoVO.setIdAplicacion			(idAplicacion);
						objetoVO.setIdObjeto				(idObjeto);
						objetoVO.setNombreTabla				(nombreTabla);
						objetoVO.setTituloTabla				(tituloTabla);
						estructuraDetalleLogDTO.setObjetoVO	(objetoVO);
						
						detalle 						= new  ArrayList<EstructuraDetalleDetalleLogDTO>();
						estructuraDetalleDetalleLogDTO 	= new EstructuraDetalleDetalleLogDTO();
						objetoAtributoVO				= new ObjetoAtributoVO();
						objetoAtributoVO.setIdAtributo						(idAtributo);
						objetoAtributoVO.setIdObjeto						(idObjeto);
						objetoAtributoVO.setNombreCampo						(nombreCampo);
						objetoAtributoVO.setOrdenCampo						(ordenCampo);
						estructuraDetalleDetalleLogDTO.setObjetoAtributoVO	(objetoAtributoVO);
						
						anteriorIdAtributo = idAtributo;
						
						coleccionLogHistorial			= new ArrayList<LogHistorialVO>();
						logHistorialVO 					= new LogHistorialVO();
						logHistorialVO.setIdAtributo	(idAtributo);
						logHistorialVO.setIdHistorial	(idHistorial);
						logHistorialVO.setIdTraza		(idTraza);
						logHistorialVO.setNombreCampo	(nombreCampo);
						logHistorialVO.setValorAtributo	(valorAtributo);
						coleccionLogHistorial.add		(logHistorialVO);						
					} else {
						if(anteriorIdObjeto != idObjeto) {
							estructuraDetalleDetalleLogDTO.setColeccionLogHistorial	(coleccionLogHistorial);
							detalle.add												(estructuraDetalleDetalleLogDTO);
							estructuraDetalleLogDTO.setDetalle						(detalle);
							coleccionARetornar.add(estructuraDetalleLogDTO);
							
							anteriorIdObjeto 			= idObjeto;
							estructuraDetalleLogDTO 	= new EstructuraDetalleLogDTO();
							objetoVO					= new ObjetoVO();
							objetoVO.setIdAplicacion			(idAplicacion);
							objetoVO.setIdObjeto				(idObjeto);
							objetoVO.setNombreTabla				(nombreTabla);
							objetoVO.setTituloTabla				(tituloTabla);
							estructuraDetalleLogDTO.setObjetoVO	(objetoVO);
							
							detalle 						= new  ArrayList<EstructuraDetalleDetalleLogDTO>();
							estructuraDetalleDetalleLogDTO 	= new EstructuraDetalleDetalleLogDTO();
							objetoAtributoVO				= new ObjetoAtributoVO();
							objetoAtributoVO.setIdAtributo						(idAtributo);
							objetoAtributoVO.setIdObjeto						(idObjeto);
							objetoAtributoVO.setNombreCampo						(nombreCampo);
							objetoAtributoVO.setOrdenCampo						(ordenCampo);
							estructuraDetalleDetalleLogDTO.setObjetoAtributoVO	(objetoAtributoVO);
							
							anteriorIdAtributo = idAtributo;
							
							coleccionLogHistorial			= new ArrayList<LogHistorialVO>();
							logHistorialVO 					= new LogHistorialVO();
							logHistorialVO.setIdAtributo	(idAtributo);
							logHistorialVO.setIdHistorial	(idHistorial);
							logHistorialVO.setIdTraza		(idTraza);
							logHistorialVO.setNombreCampo	(nombreCampo);
							logHistorialVO.setValorAtributo	(valorAtributo);
							coleccionLogHistorial.add		(logHistorialVO);									
						} else {
							if(anteriorIdAtributo != idAtributo) {
								estructuraDetalleDetalleLogDTO.setColeccionLogHistorial	(coleccionLogHistorial);							
								detalle.add												(estructuraDetalleDetalleLogDTO);
								
								estructuraDetalleDetalleLogDTO 	= new EstructuraDetalleDetalleLogDTO();
								objetoAtributoVO				= new ObjetoAtributoVO();
								objetoAtributoVO.setIdAtributo						(idAtributo);
								objetoAtributoVO.setIdObjeto						(idObjeto);
								objetoAtributoVO.setNombreCampo						(nombreCampo);
								objetoAtributoVO.setOrdenCampo						(ordenCampo);
								estructuraDetalleDetalleLogDTO.setObjetoAtributoVO	(objetoAtributoVO);
								
								anteriorIdAtributo = idAtributo;
								
								coleccionLogHistorial			= new ArrayList<LogHistorialVO>();
								logHistorialVO 					= new LogHistorialVO();
								logHistorialVO.setIdAtributo	(idAtributo);
								logHistorialVO.setIdHistorial	(idHistorial);
								logHistorialVO.setIdTraza		(idTraza);
								logHistorialVO.setNombreCampo	(nombreCampo);
								logHistorialVO.setValorAtributo	(valorAtributo);
								coleccionLogHistorial.add		(logHistorialVO);										
							} else {
								logHistorialVO 					= new LogHistorialVO();
								logHistorialVO.setIdAtributo	(idAtributo);
								logHistorialVO.setIdHistorial	(idHistorial);
								logHistorialVO.setIdTraza		(idTraza);
								logHistorialVO.setNombreCampo	(nombreCampo);
								logHistorialVO.setValorAtributo	(valorAtributo);
								coleccionLogHistorial.add		(logHistorialVO);										
							}
						}
					}
				}
				
				if(haIniciadoBucle) {
					estructuraDetalleDetalleLogDTO.setColeccionLogHistorial	(coleccionLogHistorial);
					detalle.add												(estructuraDetalleDetalleLogDTO);	
					estructuraDetalleLogDTO.setDetalle						(detalle);
					coleccionARetornar.add									(estructuraDetalleLogDTO);
				}
			}
		} catch (SQLException e) {
			throw new DAOException("AUD-D-001", "Error en el metodo obtenerListaDetalleLogs ("+ CLASS_NAME + ")", e);
		} catch (Exception e) {
			throw new DAOException("AUD-D-0002","Error en el metodo obtenerListaDetalleLogs, excepcion inesperada("+ CLASS_NAME + ")", e);
		} finally {
			this.closeResources(resultado, sentencia);
		}
		return coleccionARetornar;
	}
	
	private String devolverCualConsulta(EstructuraConsultaDTO estructuraConsultaDTO) {
		boolean HayUserName;
		if(estructuraConsultaDTO.getUserName() == null) {
			HayUserName = false;
		} else {
			HayUserName = true;
		}	
		
		if(HayUserName) return "APORCOMDUNFA";
		if(! HayUserName) return "APORCOMDFA";
		return null;
	}	
	
	private void setearParametros(String cualConsulta, PreparedStatement sentencia,
			EstructuraConsultaDTO estructuraConsultaDTO) throws SQLException, ParseException {		
		
		if(cualConsulta == "APORCOMDUNFA") {
			// En la siguiente parte de sentencia van los siguientes parámetros:
			//  1- idAplicacion
			//  2- idModulo
			//  3- idOrigen
			//  4- codigoOrigen
			//  5- userName
			//  67- fechaAnotacion (ENTRE FECHA INICIAL Y FINAL)			
			sentencia.setInt		(1, estructuraConsultaDTO.getIdAplicacion().intValue());
			sentencia.setInt		(2, estructuraConsultaDTO.getIdModulo().intValue());
			sentencia.setInt		(3, estructuraConsultaDTO.getIdOrigen().intValue());
			sentencia.setString		(4, estructuraConsultaDTO.getCodigoOrigen());
			sentencia.setString		(5, estructuraConsultaDTO.getUserName());
			sentencia.setTimestamp	(6, DateTypeConverter.getTimestampFromCalendar(estructuraConsultaDTO.getFechaInicial()));
			sentencia.setTimestamp	(7, DateTypeConverter.getTimestampFromCalendar(estructuraConsultaDTO.getFechaFinal()));
		}
		
		if(cualConsulta == "APORCOMDFA") {
			// En la siguiente parte de sentencia van los siguientes parámetros:
			//  1- idAplicacion
			//  2- idModulo
			//  3- idOrigen
			//  4- codigoOrigen
			//  56- fechaAnotacion (ENTRE FECHA INICIAL Y FINAL)			
			sentencia.setInt		(1, estructuraConsultaDTO.getIdAplicacion().intValue());
			sentencia.setInt		(2, estructuraConsultaDTO.getIdModulo().intValue());
			sentencia.setInt		(3, estructuraConsultaDTO.getIdOrigen().intValue());
			sentencia.setString		(4, estructuraConsultaDTO.getCodigoOrigen());
			sentencia.setTimestamp	(5, DateTypeConverter.getTimestampFromCalendar(estructuraConsultaDTO.getFechaInicial()));
			sentencia.setTimestamp	(6, DateTypeConverter.getTimestampFromCalendar(estructuraConsultaDTO.getFechaFinal()));
		}
	}
	
	private PreparedStatement devolverConsulta(String cualConsulta) throws SQLException {
		PreparedStatement sentencia = null;
		String cadena = null;
		
		if(cualConsulta == "APORCOMDUNFA")
			cadena = FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_APORCOMDUNFA;	
		
		if(cualConsulta == "APORCOMDFA")			
			cadena = FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_APORCOMDFA;
		
		sentencia = this.getConnection().prepareStatement(cadena);
		return sentencia;
	}	
	
	/**
	 * Devuelve la lista de los detalles de los logs
	 * @param EstructuraDetalleLogDTO estructuraDetalleLogDTO
	 * @return Collection de objetos EstructuraDetalleLogDTO
	 * @author gmarroquin
	 * @throws DAOException 
	 */	
	public Collection<EstructuraDetalleLogDTO> obtenerListaDetalleLogsByEstructuraConsultaDTO(
			EstructuraConsultaDTO estructuraConsultaDTO) throws DAOException {
		PreparedStatement 	sentencia 			= null;
		ResultSet 			resultado 			= null;
		Integer 			idAplicacion;
		Integer 			idObjeto;
		Integer 			idAtributo;
		Integer				ordenCampo;
		Long	 			idHistorial;		
		String 				nombreTabla;
		String 				tituloTabla;
		String 				nombreCampo;
		String 				valorAtributo;
		Long 				idTraza;
		
		Integer 			anteriorIdObjeto 	= null;
		boolean				haIniciadoBucle 	= false;
		Integer 			anteriorIdAtributo 	= null;
		
		ArrayList<EstructuraDetalleLogDTO> 			coleccionARetornar 				= new ArrayList<EstructuraDetalleLogDTO>();
		EstructuraDetalleLogDTO 					estructuraDetalleLogDTO 		= null;
		ObjetoVO 									objetoVO						= null;
		ArrayList<EstructuraDetalleDetalleLogDTO> 	detalle							= null;
		EstructuraDetalleDetalleLogDTO 				estructuraDetalleDetalleLogDTO	= null;
		ObjetoAtributoVO 							objetoAtributoVO				= null;
		ArrayList<LogHistorialVO> 					coleccionLogHistorial			= null;
		LogHistorialVO 								logHistorialVO					= null;
		LogVO										logVO							= null;
		Integer 									idOperacion;		
		String 										userName;
		Calendar 									fechaAnotacion;
		String 										ipUsuario;		
		String 										descripcionAnotacion;	
		ArrayList<LogVO> 							coleccionLogVO					= null;
		try {
			if (this.getConnection() != null) {
				String cualConsulta = devolverCualConsulta(estructuraConsultaDTO);
				sentencia = devolverConsulta(cualConsulta);
				setearParametros(cualConsulta, sentencia, estructuraConsultaDTO);
				resultado = sentencia.executeQuery();
				
				if(resultado == null) return coleccionARetornar;
				
				while(resultado.next()) {
					idAplicacion	= resultado.getInt		(CAMPO_OBJETO_IDAPLICACION);
					idObjeto		= resultado.getInt		(CAMPO_OBJETO_IDOBJETO);
					idAtributo		= resultado.getInt		(CAMPO_OBJETOATRIBUTO_IDATRIBUTO);
					ordenCampo		= resultado.getInt		(CAMPO_OBJETOATRIBUTO_ORDENCAMPO);
					idHistorial		= resultado.getLong		(CAMPO_LOGHISTORIAL_IDHISTORIAL);
					nombreTabla		= resultado.getString	(CAMPO_OBJETO_NOMBRETABLA);
					tituloTabla		= resultado.getString	(CAMPO_OBJETO_TITULOTABLA);
					nombreCampo		= resultado.getString	(CAMPO_OBJETOATRIBUTO_NOMBRECAMPO);
					valorAtributo	= resultado.getString	(CAMPO_LOGHISTORIAL_VALORATRIBUTO);
					idTraza			= resultado.getLong		(CAMPO_LOGHISTORIAL_IDTRAZA);
					
					idOperacion		= resultado.getInt		(CAMPO_LOG_IDOPERACION);	
					userName 		= resultado.getString	(CAMPO_LOG_USERNAME);
					fechaAnotacion 	= DateTypeConverter.getCalendarFromTimestamp(
							resultado.getTimestamp(CAMPO_LOG_FECHAANOTACION));		
					ipUsuario		= resultado.getString	(CAMPO_LOG_IPUSUARIO);		
					descripcionAnotacion = resultado.getString	(CAMPO_LOG_DESCRIPCIONANOTACION);	
					
					if(! haIniciadoBucle) {
						haIniciadoBucle 	= true;
						anteriorIdObjeto 			= idObjeto;
						estructuraDetalleLogDTO 	= new EstructuraDetalleLogDTO();
						objetoVO					= new ObjetoVO();
						objetoVO.setIdAplicacion			(idAplicacion);
						objetoVO.setIdObjeto				(idObjeto);
						objetoVO.setNombreTabla				(nombreTabla);
						objetoVO.setTituloTabla				(tituloTabla);
						estructuraDetalleLogDTO.setObjetoVO	(objetoVO);
						
						detalle 						= new  ArrayList<EstructuraDetalleDetalleLogDTO>();
						estructuraDetalleDetalleLogDTO 	= new EstructuraDetalleDetalleLogDTO();
						objetoAtributoVO				= new ObjetoAtributoVO();
						objetoAtributoVO.setIdAtributo						(idAtributo);
						objetoAtributoVO.setIdObjeto						(idObjeto);
						objetoAtributoVO.setNombreCampo						(nombreCampo);
						objetoAtributoVO.setOrdenCampo						(ordenCampo);
						estructuraDetalleDetalleLogDTO.setObjetoAtributoVO	(objetoAtributoVO);
						
						anteriorIdAtributo = idAtributo;
						
						coleccionLogHistorial			= new ArrayList<LogHistorialVO>();
						logHistorialVO 					= new LogHistorialVO();
						logHistorialVO.setIdAtributo	(idAtributo);
						logHistorialVO.setIdHistorial	(idHistorial);
						logHistorialVO.setIdTraza		(idTraza);
						logHistorialVO.setNombreCampo	(nombreCampo);
						logHistorialVO.setValorAtributo	(valorAtributo);
						coleccionLogHistorial.add		(logHistorialVO);						
						
						coleccionLogVO					= new ArrayList<LogVO>();
						logVO 							= new LogVO();
						logVO.setIdTraza				(idTraza);
						logVO.setIdOperacion			(idOperacion);
						logVO.setUserName				(userName);
						logVO.setFechaAnotacion			(fechaAnotacion);
						logVO.setIpUsuario				(ipUsuario);
						logVO.setDescripcionAnotacion	(descripcionAnotacion);	
						coleccionLogVO.add				(logVO);
					} else {
						if(anteriorIdObjeto != idObjeto) {
							estructuraDetalleDetalleLogDTO.setColeccionLogHistorial	(coleccionLogHistorial);
							estructuraDetalleDetalleLogDTO.setColeccionLogVO		(coleccionLogVO);							
							detalle.add												(estructuraDetalleDetalleLogDTO);
							estructuraDetalleLogDTO.setDetalle						(detalle);
							coleccionARetornar.add(estructuraDetalleLogDTO);
							
							anteriorIdObjeto 			= idObjeto;
							estructuraDetalleLogDTO 	= new EstructuraDetalleLogDTO();
							objetoVO					= new ObjetoVO();
							objetoVO.setIdAplicacion			(idAplicacion);
							objetoVO.setIdObjeto				(idObjeto);
							objetoVO.setNombreTabla				(nombreTabla);
							objetoVO.setTituloTabla				(tituloTabla);
							estructuraDetalleLogDTO.setObjetoVO	(objetoVO);
							
							detalle 						= new  ArrayList<EstructuraDetalleDetalleLogDTO>();
							estructuraDetalleDetalleLogDTO 	= new EstructuraDetalleDetalleLogDTO();
							objetoAtributoVO				= new ObjetoAtributoVO();
							objetoAtributoVO.setIdAtributo						(idAtributo);
							objetoAtributoVO.setIdObjeto						(idObjeto);
							objetoAtributoVO.setNombreCampo						(nombreCampo);
							objetoAtributoVO.setOrdenCampo						(ordenCampo);
							estructuraDetalleDetalleLogDTO.setObjetoAtributoVO	(objetoAtributoVO);
							
							anteriorIdAtributo = idAtributo;
							
							coleccionLogHistorial			= new ArrayList<LogHistorialVO>();
							logHistorialVO 					= new LogHistorialVO();
							logHistorialVO.setIdAtributo	(idAtributo);
							logHistorialVO.setIdHistorial	(idHistorial);
							logHistorialVO.setIdTraza		(idTraza);
							logHistorialVO.setNombreCampo	(nombreCampo);
							logHistorialVO.setValorAtributo	(valorAtributo);
							coleccionLogHistorial.add		(logHistorialVO);			
														
							coleccionLogVO					= new ArrayList<LogVO>();
							logVO 							= new LogVO();
							logVO.setIdTraza				(idTraza);
							logVO.setIdOperacion			(idOperacion);
							logVO.setUserName				(userName);
							logVO.setFechaAnotacion			(fechaAnotacion);
							logVO.setIpUsuario				(ipUsuario);
							logVO.setDescripcionAnotacion	(descripcionAnotacion);	
							coleccionLogVO.add				(logVO);							
						} else {
							if(anteriorIdAtributo != idAtributo) {
								estructuraDetalleDetalleLogDTO.setColeccionLogHistorial	(coleccionLogHistorial);
								estructuraDetalleDetalleLogDTO.setColeccionLogVO		(coleccionLogVO);	
								detalle.add												(estructuraDetalleDetalleLogDTO);
								
								estructuraDetalleDetalleLogDTO 	= new EstructuraDetalleDetalleLogDTO();
								objetoAtributoVO				= new ObjetoAtributoVO();
								objetoAtributoVO.setIdAtributo						(idAtributo);
								objetoAtributoVO.setIdObjeto						(idObjeto);
								objetoAtributoVO.setNombreCampo						(nombreCampo);
								objetoAtributoVO.setOrdenCampo						(ordenCampo);
								estructuraDetalleDetalleLogDTO.setObjetoAtributoVO	(objetoAtributoVO);
								
								anteriorIdAtributo = idAtributo;
								
								coleccionLogHistorial			= new ArrayList<LogHistorialVO>();
								logHistorialVO 					= new LogHistorialVO();
								logHistorialVO.setIdAtributo	(idAtributo);
								logHistorialVO.setIdHistorial	(idHistorial);
								logHistorialVO.setIdTraza		(idTraza);
								logHistorialVO.setNombreCampo	(nombreCampo);
								logHistorialVO.setValorAtributo	(valorAtributo);
								coleccionLogHistorial.add		(logHistorialVO);		
																
								coleccionLogVO					= new ArrayList<LogVO>();
								logVO 							= new LogVO();
								logVO.setIdTraza				(idTraza);
								logVO.setIdOperacion			(idOperacion);
								logVO.setUserName				(userName);
								logVO.setFechaAnotacion			(fechaAnotacion);
								logVO.setIpUsuario				(ipUsuario);
								logVO.setDescripcionAnotacion	(descripcionAnotacion);	
								coleccionLogVO.add				(logVO);								
							} else {
								logHistorialVO 					= new LogHistorialVO();
								logHistorialVO.setIdAtributo	(idAtributo);
								logHistorialVO.setIdHistorial	(idHistorial);
								logHistorialVO.setIdTraza		(idTraza);
								logHistorialVO.setNombreCampo	(nombreCampo);
								logHistorialVO.setValorAtributo	(valorAtributo);
								coleccionLogHistorial.add		(logHistorialVO);	
																
								logVO 							= new LogVO();
								logVO.setIdTraza				(idTraza);
								logVO.setIdOperacion			(idOperacion);
								logVO.setUserName				(userName);
								logVO.setFechaAnotacion			(fechaAnotacion);
								logVO.setIpUsuario				(ipUsuario);
								logVO.setDescripcionAnotacion	(descripcionAnotacion);	
								coleccionLogVO.add				(logVO);								
							}
						}
					}
				}
				
				if(haIniciadoBucle) {
					estructuraDetalleDetalleLogDTO.setColeccionLogHistorial	(coleccionLogHistorial);
					estructuraDetalleDetalleLogDTO.setColeccionLogVO		(coleccionLogVO);	
					detalle.add												(estructuraDetalleDetalleLogDTO);	
					estructuraDetalleLogDTO.setDetalle						(detalle);
					coleccionARetornar.add									(estructuraDetalleLogDTO);
				}
			}
		} catch (SQLException e) {
			throw new DAOException("AUD-D-001", "Error en el metodo obtenerListaDetalleLogsByEstructuraConsultaDTO ("+ CLASS_NAME + ")", e);
		} catch (Exception e) {
			throw new DAOException("AUD-D-0002","Error en el metodo obtenerListaDetalleLogsByEstructuraConsultaDTO, excepcion inesperada("+ CLASS_NAME + ")", e);
		} finally {
			this.closeResources(resultado, sentencia);
		}
		return coleccionARetornar;
	}	
	
	/**
	 * Contructor del ROE para la estructura de un detalle de log
	 * @param connection Define la conexión a la base de datos
	 */
	public OracleLogHistorialROE(Connection connection){
		super.setConnection(connection);		
	}
}
