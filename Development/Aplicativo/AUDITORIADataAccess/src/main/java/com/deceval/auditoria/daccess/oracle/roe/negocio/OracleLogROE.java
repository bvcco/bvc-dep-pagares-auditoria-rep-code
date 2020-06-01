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
import com.deceval.auditoria.daccess.roe.negocio.LogROE;
import com.deceval.auditoria.dto.EstructuraConsultaDTO;
import com.deceval.auditoria.dto.EstructuraLogDTO;
import com.deceval.auditoria.exception.DAOException;
import com.deceval.auditoria.util.converter.DateTypeConverter;
import com.deceval.auditoria.vo.LogVO;
import com.deceval.auditoria.vo.OperacionVO;
import com.deceval.auditoria.vo.OrigenVO;

public class OracleLogROE extends OracleBaseROE  implements LogROE {

	private final static String CLASS_NAME = "OracleLogROE";
	
	private final static String TABLA_OPERACION ="AUD_OPERACION";
	private final static String TABLA_ORIGEN 	="AUD_ORIGEN";
	private final static String TABLA_MODULO 	="AUD_MODULO";
	private final static String TABLA_LOG 		="AUD_LOG";	
	
	//Campos tabla AUD_OPERACION
	private final static String CAMPO_OPERACION_IDOPERACION = "IDOPERACION";
	private final static String CAMPO_OPERACION_IDMODULO = "IDMODULO";
	private final static String CAMPO_OPERACION_DESCRIPCIONOPERACION = "DESCRIPCIONOPERACION";
	
	//Campos tabla AUD_MODULO
	private final static String CAMPO_MODULO_IDMODULO = "IDMODULO";
	private final static String CAMPO_MODULO_IDAPLICACION = "IDAPLICACION";
	
	//Campos tabla AUD_ORIGEN
	private final static String CAMPO_ORIGEN_IDORIGEN = "IDORIGEN";
	private final static String CAMPO_ORIGEN_DESCRIPCIONORIGEN = "DESCRIPCIONORIGEN";
	
	//Campos tabla AUD_LOG
	private final static String CAMPO_LOG_IDORIGEN = "IDORIGEN";
	private final static String CAMPO_LOG_IDOPERACION = "IDOPERACION";	
	private final static String CAMPO_LOG_CODIGOORIGEN = "CODIGOORIGEN";
	private final static String CAMPO_LOG_USERNAME = "USERNAME";		
	private final static String CAMPO_LOG_FECHAANOTACION = "FECHAANOTACION";
	private final static String CAMPO_LOG_IDTRAZA = "IDTRAZA";
	private final static String CAMPO_LOG_IPUSUARIO = "IPUSUARIO";
	private final static String CAMPO_LOG_DESCRIPCIONANOTACION = "DESCRIPCIONANOTACION";
	
	private final static String FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_FROM = 
		" FROM " + TABLA_LOG + " LO " +
		" INNER JOIN " + TABLA_ORIGEN + " ORI ON (ORI." + CAMPO_ORIGEN_IDORIGEN + "=LO." + CAMPO_LOG_IDORIGEN + ") " +
		" INNER JOIN " + TABLA_OPERACION + " OP ON (OP." + CAMPO_OPERACION_IDOPERACION + "=LO." + CAMPO_LOG_IDOPERACION + ") " +
		" INNER JOIN " + TABLA_MODULO + " MD ON (OP." + CAMPO_OPERACION_IDMODULO + "=MD." + CAMPO_MODULO_IDMODULO + ") ";		
	
	private final static String FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_SELECT = 	
		" SELECT " + 
		"OP." + CAMPO_OPERACION_DESCRIPCIONOPERACION + ", " +
		"ORI." + CAMPO_ORIGEN_DESCRIPCIONORIGEN + ", " +
		"LO." + CAMPO_LOG_USERNAME + ", " +
		"LO." + CAMPO_LOG_FECHAANOTACION + ", " +		
		"LO." + CAMPO_LOG_IPUSUARIO + ", " +
		"LO." + CAMPO_LOG_CODIGOORIGEN + ", " +
		"LO." + CAMPO_LOG_DESCRIPCIONANOTACION + ", " +
		"LO." + CAMPO_LOG_IDTRAZA + ", " +	
		"LO." + CAMPO_LOG_IDORIGEN + ", " +	
		"LO." + CAMPO_LOG_IDOPERACION + " ";	
	
	private final static String FIND_CODIGOORIGEN_BY_ESTRUCTURA_CONSULTA_SELECT = 	
		" SELECT " + 
		"DISTINCT(LO." + CAMPO_LOG_CODIGOORIGEN + ") AS " + CAMPO_LOG_CODIGOORIGEN + " ";		
	
	private final static String FIND_CODIGOORIGEN_BY_ESTRUCTURA_CONSULTA_FROM = 
		" FROM " + TABLA_LOG + " LO " +
		" INNER JOIN " + TABLA_ORIGEN + " ORI ON (ORI." + CAMPO_ORIGEN_IDORIGEN + "=LO." + CAMPO_LOG_IDORIGEN + ") " +
		" INNER JOIN " + TABLA_OPERACION + " OP ON (OP." + CAMPO_OPERACION_IDOPERACION + "=LO." + CAMPO_LOG_IDOPERACION + ") " +
		" INNER JOIN " + TABLA_MODULO + " MD ON (OP." + CAMPO_OPERACION_IDMODULO + "=MD." + CAMPO_MODULO_IDMODULO + ") ";			
	
	// Parámetros:
	//  -AP idAplicacion 
	//  -OP idOperacion
	//  -MD idModulo
	//  -OR idOrigen
	//  -CO codigoOrigen
	//  -UN userName
	//  -FA fechaAnotacion (ENTRE FECHA INICIAL Y FINAL)	
	
	// En la siguiente parte de sentencia van los siguientes parámetros:
	//  1- idAplicacion
	//  2- idModulo	
	//  3- idOperacion
	//  4- userName
	//  56- fechaAnotacion (ENTRE FECHA INICIAL Y FINAL)	
	private final static String FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_WHERE_APOPMDUNFA = 	
		" WHERE MD." + CAMPO_MODULO_IDAPLICACION + "=? " + 
		" AND MD." + CAMPO_MODULO_IDMODULO + "=? " +
		" AND OP." + CAMPO_OPERACION_IDOPERACION + "=? " + 
		" AND LO." + CAMPO_LOG_USERNAME + "=? " +
		" AND LO." + CAMPO_LOG_FECHAANOTACION + " BETWEEN ? AND ? ";		
	
	// En la siguiente parte de sentencia van los siguientes parámetros:
	//  1- idAplicacion
	//  2- idModulo
	//  3- idOperacion	
	//  45- fechaAnotacion (ENTRE FECHA INICIAL Y FINAL)	
	private final static String FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_WHERE_APOPMDFA = 	
		" WHERE MD." + CAMPO_MODULO_IDAPLICACION + "=? " + 
		" AND MD." + CAMPO_MODULO_IDMODULO + "=? " +
		" AND OP." + CAMPO_OPERACION_IDOPERACION + "=? " +
		" AND LO." + CAMPO_LOG_FECHAANOTACION + " BETWEEN ? AND ? ";	
	
	// En la siguiente parte de sentencia van los siguientes parámetros:
	//  1- idAplicacion
	//  2- idModulo
	//  3- idOrigen
	//  4- codigoOrigen
	//  5- userName
	//  67- fechaAnotacion (ENTRE FECHA INICIAL Y FINAL)	
	private final static String FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_WHERE_APORCOMDUNFA = 	
		" WHERE MD." + CAMPO_MODULO_IDAPLICACION + "=? " + 
		" AND MD." + CAMPO_MODULO_IDMODULO + "=? " + 
		" AND ORI." + CAMPO_ORIGEN_IDORIGEN + "=? " +
		" AND LO." + CAMPO_LOG_CODIGOORIGEN + "=? " + 
		" AND LO." + CAMPO_LOG_USERNAME + "=? " +
		" AND LO." + CAMPO_LOG_FECHAANOTACION + " BETWEEN ? AND ? ";			
	
	// En la siguiente parte de sentencia van los siguientes parámetros:
	//  1- idAplicacion
	//  2- idModulo
	//  3- idOrigen
	//  45- fechaAnotacion (ENTRE FECHA INICIAL Y FINAL)	
	private final static String FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_WHERE_APORCOMDFA = 	
		" WHERE MD." + CAMPO_MODULO_IDAPLICACION + "=? " + 
		" AND MD." + CAMPO_MODULO_IDMODULO + "=? " + 
		" AND ORI." + CAMPO_ORIGEN_IDORIGEN + "=? " +
		" AND LO." + CAMPO_LOG_FECHAANOTACION + " BETWEEN ? AND ? ";	
	
	// En la siguiente parte de sentencia van los siguientes parámetros:
	//  1- idAplicacion
	//  2- idModulo
	//  3- idOrigen
	//  4- userName
	//  56- fechaAnotacion (ENTRE FECHA INICIAL Y FINAL)	
	private final static String FIND_CODIGOORIGEN_BY_ESTRUCTURA_CONSULTA_WHERE_APORCOMDUNFA = 	
		" WHERE MD." + CAMPO_MODULO_IDAPLICACION + "=? " + 
		" AND MD." + CAMPO_MODULO_IDMODULO + "=? " + 
		" AND ORI." + CAMPO_ORIGEN_IDORIGEN + "=? " + 
		" AND LO." + CAMPO_LOG_USERNAME + "=? " +
		" AND LO." + CAMPO_LOG_FECHAANOTACION + " BETWEEN ? AND ? ";			
	
	// En la siguiente parte de sentencia van los siguientes parámetros:
	//  1- idAplicacion
	//  2- idModulo
	//  3- idOrigen
	//  45- fechaAnotacion (ENTRE FECHA INICIAL Y FINAL)	
	private final static String FIND_CODIGOORIGEN_BY_ESTRUCTURA_CONSULTA_WHERE_APORCOMDFA = 	
		" WHERE MD." + CAMPO_MODULO_IDAPLICACION + "=? " + 
		" AND MD." + CAMPO_MODULO_IDMODULO + "=? " + 
		" AND ORI." + CAMPO_ORIGEN_IDORIGEN + "=? " +
		" AND LO." + CAMPO_LOG_FECHAANOTACION + " BETWEEN ? AND ? ";	
	
	private final static String FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_APOPMDUNFA = 
		FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_SELECT +
		FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_FROM +		
		FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_WHERE_APOPMDUNFA;	
	
	private final static String FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_APOPMDFA = 
		FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_SELECT +
		FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_FROM +		
		FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_WHERE_APOPMDFA;	
	
	private final static String FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_APORCOMDUNFA = 
		FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_SELECT +
		FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_FROM +		
		FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_WHERE_APORCOMDUNFA;	
	
	private final static String FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_APORCOMDFA = 
		FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_SELECT +
		FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_FROM +		
		FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_WHERE_APORCOMDFA;		
	
	private final static String FIND_CODIGOORIGEN_BY_ESTRUCTURA_CONSULTA_APORCOMDUNFA = 
		FIND_CODIGOORIGEN_BY_ESTRUCTURA_CONSULTA_SELECT +
		FIND_CODIGOORIGEN_BY_ESTRUCTURA_CONSULTA_FROM +		
		FIND_CODIGOORIGEN_BY_ESTRUCTURA_CONSULTA_WHERE_APORCOMDUNFA;	
	
	private final static String FIND_CODIGOORIGEN_BY_ESTRUCTURA_CONSULTA_APORCOMDFA = 
		FIND_CODIGOORIGEN_BY_ESTRUCTURA_CONSULTA_SELECT +
		FIND_CODIGOORIGEN_BY_ESTRUCTURA_CONSULTA_FROM +		
		FIND_CODIGOORIGEN_BY_ESTRUCTURA_CONSULTA_WHERE_APORCOMDFA;		
	
	private String devolverCualConsulta(EstructuraConsultaDTO estructuraConsultaDTO) {
		boolean HayUserName;
		if(estructuraConsultaDTO.getUserName() == null) {
			HayUserName = false;
		} else {
			HayUserName = true;
		}
		
		boolean HayIdOperacion;
		if(estructuraConsultaDTO.getIdOperacion() == null) {
			HayIdOperacion = false;
		} else {
			HayIdOperacion = true;
		}	
		
		if(HayUserName && HayIdOperacion) return "APOPMDUNFA";
		if(! HayUserName && HayIdOperacion) return "APOPMDFA";
		if(HayUserName && ! HayIdOperacion) return "APORCOMDUNFA";
		if(! HayUserName && ! HayIdOperacion) return "APORCOMDFA";
		return null;
	}
	
	private PreparedStatement devolverConsulta(String cualConsulta) throws SQLException {
		PreparedStatement sentencia = null;
		String cadena = null;
		if(cualConsulta == "APOPMDUNFA") 
			cadena = FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_APOPMDUNFA;
		
		if(cualConsulta == "APOPMDFA")
			cadena = FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_APOPMDFA;	
		
		if(cualConsulta == "APORCOMDUNFA")
			cadena = FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_APORCOMDUNFA;	
		
		if(cualConsulta == "APORCOMDFA")			
			cadena = FIND_ESTRUCTURA_LOG_BY_ESTRUCTURA_CONSULTA_APORCOMDFA;
		
		sentencia = this.getConnection().prepareStatement(cadena);
		return sentencia;
	}
	
	private PreparedStatement devolverConsultaCodigoOrigen(String cualConsulta) throws SQLException {
		PreparedStatement sentencia = null;
		String cadena = null;
		
		if(cualConsulta == "APORCOMDUNFA")
			cadena = FIND_CODIGOORIGEN_BY_ESTRUCTURA_CONSULTA_APORCOMDUNFA;	
		
		if(cualConsulta == "APORCOMDFA")			
			cadena = FIND_CODIGOORIGEN_BY_ESTRUCTURA_CONSULTA_APORCOMDFA;
		
		sentencia = this.getConnection().prepareStatement(cadena);
		return sentencia;
	}	
	
	private void setearParametros(String cualConsulta, PreparedStatement sentencia,
			EstructuraConsultaDTO estructuraConsultaDTO) throws SQLException, ParseException {
		
		
		if(cualConsulta == "APOPMDUNFA") {
			// En la siguiente parte de sentencia van los siguientes parámetros:
			//  1- idAplicacion
			//  2- idModulo	
			//  3- idOperacion
			//  4- userName
			//  56- fechaAnotacion (ENTRE FECHA INICIAL Y FINAL)				
			sentencia.setInt		(1, estructuraConsultaDTO.getIdAplicacion().intValue());
			sentencia.setInt		(2, estructuraConsultaDTO.getIdModulo().intValue());
			sentencia.setInt		(3, estructuraConsultaDTO.getIdOperacion().intValue());
			sentencia.setString		(4, estructuraConsultaDTO.getUserName());
			sentencia.setTimestamp	(5, new java.sql.Timestamp(estructuraConsultaDTO.getFechaInicial().getTimeInMillis()));
			sentencia.setTimestamp	(6, new java.sql.Timestamp(estructuraConsultaDTO.getFechaFinal().getTimeInMillis()));
		}
		
		if(cualConsulta == "APOPMDFA") {
			// En la siguiente parte de sentencia van los siguientes parámetros:
			//  1- idAplicacion
			//  2- idModulo
			//  3- idOperacion	
			//  45- fechaAnotacion (ENTRE FECHA INICIAL Y FINAL)				
			sentencia.setInt		(1, estructuraConsultaDTO.getIdAplicacion().intValue());
			sentencia.setInt		(2, estructuraConsultaDTO.getIdModulo().intValue());
			sentencia.setInt		(3, estructuraConsultaDTO.getIdOperacion().intValue());
			sentencia.setTimestamp	(4, new java.sql.Timestamp(estructuraConsultaDTO.getFechaInicial().getTimeInMillis()));
			sentencia.setTimestamp	(5, new java.sql.Timestamp(estructuraConsultaDTO.getFechaFinal().getTimeInMillis()));
		}
		
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
			sentencia.setTimestamp	(6, new java.sql.Timestamp(estructuraConsultaDTO.getFechaInicial().getTimeInMillis()));
			sentencia.setTimestamp	(7, new java.sql.Timestamp(estructuraConsultaDTO.getFechaFinal().getTimeInMillis()));
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
			sentencia.setTimestamp	(5, new java.sql.Timestamp(estructuraConsultaDTO.getFechaInicial().getTimeInMillis()));
			sentencia.setTimestamp	(6, new java.sql.Timestamp(estructuraConsultaDTO.getFechaFinal().getTimeInMillis()));
		}
	}
	
	private void setearParametrosCodigoOrigen(String cualConsulta, PreparedStatement sentencia,
			EstructuraConsultaDTO estructuraConsultaDTO) throws SQLException, ParseException {
		
		if(cualConsulta == "APORCOMDUNFA") {
			// En la siguiente parte de sentencia van los siguientes parámetros:
			//  1- idAplicacion
			//  2- idModulo
			//  3- idOrigen
			//  4- userName
			//  56- fechaAnotacion (ENTRE FECHA INICIAL Y FINAL)				
			sentencia.setInt		(1, estructuraConsultaDTO.getIdAplicacion().intValue());
			sentencia.setInt		(2, estructuraConsultaDTO.getIdModulo().intValue());
			sentencia.setInt		(3, estructuraConsultaDTO.getIdOrigen().intValue());
			sentencia.setString		(4, estructuraConsultaDTO.getUserName());
			sentencia.setTimestamp	(5, new java.sql.Timestamp(estructuraConsultaDTO.getFechaInicial().getTimeInMillis()));
			sentencia.setTimestamp	(6, new java.sql.Timestamp(estructuraConsultaDTO.getFechaFinal().getTimeInMillis()));
		}

		if(cualConsulta == "APORCOMDFA") {
			// En la siguiente parte de sentencia van los siguientes parámetros:
			//  1- idAplicacion
			//  2- idModulo
			//  3- idOrigen
			//  45- fechaAnotacion (ENTRE FECHA INICIAL Y FINAL)			
			sentencia.setInt		(1, estructuraConsultaDTO.getIdAplicacion().intValue());
			sentencia.setInt		(2, estructuraConsultaDTO.getIdModulo().intValue());
			sentencia.setInt		(3, estructuraConsultaDTO.getIdOrigen().intValue());
			sentencia.setTimestamp	(4, new java.sql.Timestamp(estructuraConsultaDTO.getFechaInicial().getTimeInMillis()));
			sentencia.setTimestamp	(5, new java.sql.Timestamp(estructuraConsultaDTO.getFechaFinal().getTimeInMillis()));
		}
	}	
	
	public Collection<EstructuraLogDTO> obtenerListaLogs(
			EstructuraConsultaDTO estructuraConsultaDTO) throws DAOException {
		PreparedStatement 	sentencia = null;
		ResultSet 			resultado = null;
		ArrayList<EstructuraLogDTO> coleccionARetornar = new ArrayList<EstructuraLogDTO>();
		EstructuraLogDTO 	estructuraLogDTO;
		OrigenVO 			origenVO;
		OperacionVO 		operacionVO;
		LogVO 				logVO;
		String 				userName;
		String 				ipUsuario;
		String 				descripcionOperacion;
		String 				descripcionOrigen;
		String 				codigoOrigen;
		String 				descripcionAnotacion;	
		Integer 			idOrigen;
		Integer 			idAplicacion;	
		Integer 			idOperacion;
		Integer 			idModulo;	
		Long 				idTraza;
		Calendar 			fechaAnotacion;
		try {
			if (this.getConnection() != null) {
				String cualConsulta = devolverCualConsulta(estructuraConsultaDTO);
				sentencia = devolverConsulta(cualConsulta);
				setearParametros(cualConsulta, sentencia, estructuraConsultaDTO);
				resultado = sentencia.executeQuery();
				
				if(resultado == null) return coleccionARetornar;
				
				while(resultado.next()) {
					userName 				= resultado.getString	(CAMPO_LOG_USERNAME);
					fechaAnotacion 			= DateTypeConverter.getCalendarFromTimestamp(
													resultado.getTimestamp(CAMPO_LOG_FECHAANOTACION));		
					ipUsuario				= resultado.getString	(CAMPO_LOG_IPUSUARIO);
					descripcionOperacion	= resultado.getString	(CAMPO_OPERACION_DESCRIPCIONOPERACION);
					descripcionOrigen		= resultado.getString	(CAMPO_ORIGEN_DESCRIPCIONORIGEN);
					codigoOrigen 			= resultado.getString	(CAMPO_LOG_CODIGOORIGEN);
					descripcionAnotacion	= resultado.getString	(CAMPO_LOG_DESCRIPCIONANOTACION);
					idTraza					= resultado.getLong		(CAMPO_LOG_IDTRAZA);	
					idOrigen				= resultado.getInt		(CAMPO_LOG_IDORIGEN);	
					idAplicacion			= estructuraConsultaDTO.getIdAplicacion().intValue();	
					idOperacion				= resultado.getInt		(CAMPO_LOG_IDOPERACION);		
					idModulo				= estructuraConsultaDTO.getIdModulo().intValue();	
					
					estructuraLogDTO = new EstructuraLogDTO();
					
					origenVO = new OrigenVO();
					origenVO.setIdAplicacion		(idAplicacion);
					origenVO.setIdOrigen			(idOrigen);
					origenVO.setDescripcionOrigen	(descripcionOrigen);					
					
					estructuraLogDTO.setOrigenVO(origenVO);
					
					operacionVO = new OperacionVO();
					
					operacionVO.setIdOperacion			(idOperacion);
					operacionVO.setIdModulo				(idModulo);
					operacionVO.setDescripcionOperacion	(descripcionOperacion);
					
					estructuraLogDTO.setOperacionVO(operacionVO);
					
					logVO = new LogVO();
					logVO.setIdTraza				(idTraza);
					logVO.setIdOperacion			(idOperacion);
					logVO.setIdOrigen				(idOrigen);
					logVO.setCodigoOrigen			(codigoOrigen);
					logVO.setUserName				(userName);
					logVO.setFechaAnotacion			(fechaAnotacion);
					logVO.setIpUsuario				(ipUsuario);
					logVO.setDescripcionAnotacion	(descripcionAnotacion);	
					
					estructuraLogDTO.setLogVO(logVO);
					
					coleccionARetornar.add(estructuraLogDTO);
				}
			}
		} catch (SQLException e) {
			throw new DAOException("AUD-D-001", "Error en el metodo obtenerListaLogs ("+ CLASS_NAME + ")", e);
		} catch (Exception e) {
			throw new DAOException("AUD-D-0002","Error en el metodo obtenerListaLogs, excepcion inesperada("+ CLASS_NAME + ")", e);
		} finally {
			this.closeResources(resultado, sentencia);
		}
		return coleccionARetornar;
	}

	public Collection<String> obtenerListaCodigoOrigen(
			EstructuraConsultaDTO estructuraConsultaDTO) throws DAOException {
		PreparedStatement 	sentencia 			= null;
		ResultSet 			resultado 			= null;
		ArrayList<String> 	coleccionARetornar 	= new ArrayList<String>();	
		String 				codigoOrigen;		
		try {
			if (this.getConnection() != null) {
				String cualConsulta = devolverCualConsulta(estructuraConsultaDTO);
				sentencia = devolverConsultaCodigoOrigen(cualConsulta);
				setearParametrosCodigoOrigen(cualConsulta, sentencia, estructuraConsultaDTO);
				resultado = sentencia.executeQuery();
				
				if(resultado == null) return coleccionARetornar;
				
				while(resultado.next()) {
					codigoOrigen = resultado.getString	(CAMPO_LOG_CODIGOORIGEN);		
					coleccionARetornar.add(codigoOrigen);
				}
			}
		} catch (SQLException e) {
			throw new DAOException("AUD-D-001", "Error en el metodo obtenerListaCodigoOrigen ("+ CLASS_NAME + ")", e);
		} catch (Exception e) {
			throw new DAOException("AUD-D-0002","Error en el metodo obtenerListaCodigoOrigen, excepcion inesperada("+ CLASS_NAME + ")", e);
		} finally {
			this.closeResources(resultado, sentencia);
		}
		return coleccionARetornar;
	}
	
	/**
	 * Contructor del ROE para la estructura de un log
	 * @param connection Define la conexión a la base de datos
	 */
	public OracleLogROE(Connection connection){
		super.setConnection(connection);		
	}
}
