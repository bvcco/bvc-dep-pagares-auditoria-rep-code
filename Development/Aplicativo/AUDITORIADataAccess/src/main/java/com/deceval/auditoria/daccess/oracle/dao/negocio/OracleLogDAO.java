package com.deceval.auditoria.daccess.oracle.dao.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;

import com.deceval.auditoria.daccess.dao.negocio.LogDAO;
import com.deceval.auditoria.daccess.oracle.dao.OracleBaseDAO;
import com.deceval.auditoria.exception.DAOException;
import com.deceval.auditoria.util.converter.DateTypeConverter;
import com.deceval.auditoria.vo.LogVO;


public class OracleLogDAO extends OracleBaseDAO implements LogDAO {

	private final static String CLASS_NAME = "OracleLogDAO";

	/**
	 * Constante con nombre de la tabla en base de datos.
	 */
	public final static String ENTIDAD_NOMBRE = "AUD_LOG";

	public static final String CAMPO_ID_TRAZA = "idTraza";
	public static final String CAMPO_ID_OPERACION = "idOperacion";
	public static final String CAMPO_ID_ORIGEN = "idOrigen";
	public static final String CAMPO_CODIGO_ORIGEN = "codigoOrigen";
	public static final String CAMPO_ID_USUARIO = "idUsuario";
	public static final String CAMPO_USER_NAME = "userName";
	public static final String CAMPO_FECHA_ANOTACION = "fechaAnotacion";
	public static final String CAMPO_IP_USUARIO = "ipUsuario";
	public static final String CAMPO_IP_SERVIDOR = "ipServidor";
	public static final String CAMPO_DESCRIPCION_ANOTACION = "descripcionAnotacion";
	
	/**
	 * Crea un nuevo DAO con la conexión dada por la fábrica.
	 * 
	 * @param connection
	 */
	public OracleLogDAO(Connection connection) {
		super.setConnection(connection);
	}
	
	private final static String SQL_INSERT = 	"INSERT INTO " + ENTIDAD_NOMBRE + " (" +CAMPO_ID_OPERACION+","+CAMPO_ID_ORIGEN+
												","+CAMPO_CODIGO_ORIGEN+","+CAMPO_ID_USUARIO+","+CAMPO_USER_NAME+","+CAMPO_FECHA_ANOTACION+
												","+CAMPO_IP_USUARIO+","+CAMPO_IP_SERVIDOR+","+CAMPO_DESCRIPCION_ANOTACION+")"+
												" VALUES (?,?,?,?,?,?,?,?,?) ";
	
	private final static String SQL_FIND_MAX_IDTRAZA = "SELECT MAX (" + CAMPO_ID_TRAZA + ") AS " + CAMPO_ID_TRAZA + " FROM " + ENTIDAD_NOMBRE;
	
	private final static String SQL_GET_IDTRAZA = "select "+CAMPO_ID_TRAZA+" from " + ENTIDAD_NOMBRE;
												
	public LogVO insert(LogVO data) throws DAOException {
		PreparedStatement sentencia = null;
		try {
			if (this.getConnection() != null) {
				sentencia = this.getConnection().prepareStatement(SQL_INSERT);
				sentencia.setInt(1,data.getIdOperacion());
				sentencia.setInt(2,data.getIdOrigen());
				if(data.getCodigoOrigen() == null)
					sentencia.setNull(3,java.sql.Types.VARCHAR);
				else
					sentencia.setString(3,data.getCodigoOrigen());
				sentencia.setInt(4,data.getIdUsuario());
				sentencia.setString(5,data.getUserName());
				sentencia.setTimestamp(6, DateTypeConverter.getTimestampFromCalendar(data.getFechaAnotacion()));
				sentencia.setString(7, data.getIpUsuario());
				sentencia.setString(8, data.getIpServidor());
				sentencia.setString(9, data.getDescripcionAnotacion());			
				if(sentencia.executeUpdate()!=1)
					throw new DAOException(" coderror ", "descerror ", null);
				else {
					data.setIdTraza(this.findIdLogByFilter(data));
				}
			}
		} catch (SQLException e) {
			throw new DAOException("AUD-D-001", "Error en el metodo insert ("+ CLASS_NAME + ")", e);
		} catch (Exception e) {
			throw new DAOException("AUD-D-0002","Error en el metodo insert,excepcion inesperada("+ CLASS_NAME + ")", e);
		} finally {
			this.closeResources(null, sentencia);
		}
		return data;
	}

	public void delete(LogVO llave) throws DAOException {
		throw new DAOException("AUDITORIA-D-003", "Error en el metodo delete ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public LogVO findByPrimaryKey(LogVO llave) throws DAOException {
		throw new DAOException("AUDITORIA-D-011", "Error en el metodo getAll ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public LogVO update(LogVO data, String[] updateFields)
			throws DAOException {
		throw new DAOException("AUDITORIA-D-005", "Error en el metodo update ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public Collection<LogVO> getAll() throws DAOException {
		throw new DAOException("AUDITORIA-D-011", "Error en el metodo getAll ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public Collection<LogVO> findByFilter(LogVO filter)
	throws DAOException {
		throw new DAOException("AUDITORIA-D-009",
		"Error en el metodo findByFilter (" + CLASS_NAME + ")",
		new Exception("Method is not implemented"));
	}
	
	public Long findIdLogByFilter(LogVO filter)
			throws DAOException {
		Long idData = null;
		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		try {
			if (this.getConnection() != null) {
				String sqlSentencia = SQL_GET_IDTRAZA + " where 1 = 1 ";

				if (filter.getCodigoOrigen() != null) {
					sqlSentencia += " and " + CAMPO_CODIGO_ORIGEN + " = ?";
				}
				if (filter.getDescripcionAnotacion() != null) {
					sqlSentencia += " and " + CAMPO_DESCRIPCION_ANOTACION + " = ?";
				}
				if (filter.getFechaAnotacion() != null) {
					sqlSentencia += " and " + CAMPO_FECHA_ANOTACION + " = ?";
				}
				if (filter.getIdOperacion() != null) {
					sqlSentencia += " and " + CAMPO_ID_OPERACION+ " = ?";
				}
				if (filter.getIdOrigen() != null) {
					sqlSentencia += " and " + CAMPO_ID_ORIGEN + " = ?";
				}
				if (filter.getIdTraza() != null) {
					sqlSentencia += " and " + CAMPO_ID_TRAZA+ " = ?";
				}
				if (filter.getIdUsuario() != null) {
					sqlSentencia += " and " + CAMPO_ID_USUARIO + " = ?";
				}
				if (filter.getIpServidor() != null) {
					sqlSentencia += " and " + CAMPO_IP_SERVIDOR + " = ?";
				}
				if (filter.getIpUsuario() != null) {
					sqlSentencia += " and " + CAMPO_IP_USUARIO+ " = ?";
				}
				if (filter.getUserName() != null) {
					sqlSentencia += " and " + CAMPO_USER_NAME + " = ?";
				}
				
				sentencia = this.getConnection().prepareStatement(sqlSentencia);
				int idParameter = 1;

				if (filter.getCodigoOrigen() != null) {
					sentencia.setString(idParameter++, filter.getCodigoOrigen());
				}
				if (filter.getDescripcionAnotacion() != null) {
					sentencia.setString(idParameter++, filter.getDescripcionAnotacion());
				}
				if (filter.getFechaAnotacion() != null) {
					sentencia.setTimestamp(idParameter++, new Timestamp(filter.getFechaAnotacion().getTimeInMillis()));
				}
				if (filter.getIdOperacion() != null) {
					sentencia.setInt(idParameter++, filter.getIdOperacion());
				}
				if (filter.getIdOrigen() != null) {
					sentencia.setInt(idParameter++, filter.getIdOrigen());
				}
				if (filter.getIdTraza() != null) {
					sentencia.setLong(idParameter++, filter.getIdTraza());
				}
				if (filter.getIdUsuario() != null) {
					sentencia.setInt(idParameter++, filter.getIdUsuario());
				}
				if (filter.getIpServidor() != null) {
					sentencia.setString(idParameter++, filter.getIpServidor());
				}
				if (filter.getIpUsuario() != null) {
					sentencia.setString(idParameter++, filter.getIpUsuario());
				}
				if (filter.getUserName() != null) {
					sentencia.setString(idParameter++, filter.getUserName());
				}
				
				resultado = sentencia.executeQuery();
				if (resultado.next()) {
					idData = resultado.getLong(CAMPO_ID_TRAZA);
				}
			}
		} catch (SQLException e) {
			throw new DAOException("AUD-D-003", "Error en el metodo findIdLogByFilter ("+ CLASS_NAME + ")", e);
		} catch (Exception e) {
			throw new DAOException("AUD-D-0004","Error en el metodo findIdLogByFilter,excepcion inesperada("+ CLASS_NAME + ")", e);
		} finally {
			this.closeResources(null, sentencia);
		}
		return idData;
	}
	
	
	public Long findMaxIdTraza() throws DAOException {
		Long idTraza = null;
		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		try {
			if (this.getConnection() != null) {
				sentencia = this.getConnection().prepareStatement(SQL_FIND_MAX_IDTRAZA);
				resultado = sentencia.executeQuery();
				if(resultado != null && resultado.next())
					idTraza = resultado.getLong(CAMPO_ID_TRAZA);
			}
		} catch (SQLException e) {
			throw new DAOException("AUD-D-001", "Error en el metodo findMaxIdTraza ("+ CLASS_NAME + ")", e);
		} catch (Exception e) {
			throw new DAOException("AUD-D-0002","Error en el metodo findMaxIdTraza, excepcion inesperada("+ CLASS_NAME + ")", e);
		} finally {
			this.closeResources(null, sentencia);
		}
		return idTraza;
	}
	
}