package com.deceval.auditoria.daccess.oracle.dao.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

import com.deceval.auditoria.daccess.dao.negocio.LogHistorialDAO;
import com.deceval.auditoria.daccess.oracle.dao.OracleBaseDAO;
import com.deceval.auditoria.exception.DAOException;
import com.deceval.auditoria.vo.LogHistorialVO;

public class OracleLogHistorialDAO extends OracleBaseDAO implements LogHistorialDAO {

		
	private final static String CLASS_NAME = "OracleLogHistorialDAO";
	
	public static final String ENTIDAD_NOMBRE = "AUD_LOGHISTORIAL";
	
	public static final String CAMPO_IDHISTORIAL = "IDHISTORIAL";
	public static final String CAMPO_IDTRAZA = "IDTRAZA";
	public static final String CAMPO_IDATRIBUTO = "IDATRIBUTO";
	public static final String CAMPO_VALORATRIBUTO = "VALORATRIBUTO";
	
	private static final String SQL_INSERT = "INSERT INTO " + ENTIDAD_NOMBRE + " (" + CAMPO_IDTRAZA + ", " + CAMPO_IDATRIBUTO + 
											 ", " + CAMPO_VALORATRIBUTO + ") VALUES (?,?,?) ";
	
	/**
	 * Crea un nuevo DAO con la conexión dada por la fábrica.
	 * 
	 * @param connection
	 */
	public OracleLogHistorialDAO(Connection connection) {
		super.setConnection(connection);
	}
	
	public LogHistorialVO insert(LogHistorialVO data) throws DAOException {
		PreparedStatement sentencia = null;
		try {
			if (this.getConnection() != null) {
				sentencia = this.getConnection().prepareStatement(SQL_INSERT);
				sentencia.setLong(1,data.getIdTraza());
				sentencia.setInt(2,data.getIdAtributo());
				sentencia.setString(3,data.getValorAtributo());
				if(sentencia.executeUpdate()!=1)
					throw new DAOException(" coderror ", "descerror ", null);
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

	public void delete(LogHistorialVO llave) throws DAOException {
		throw new DAOException("AUDITORIA-D-003", "Error en el metodo delete ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public LogHistorialVO findByPrimaryKey(LogHistorialVO llave) throws DAOException {
		throw new DAOException("AUDITORIA-D-011", "Error en el metodo getAll ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public LogHistorialVO update(LogHistorialVO data, String[] updateFields)
			throws DAOException {
		throw new DAOException("AUDITORIA-D-005", "Error en el metodo update ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public Collection<LogHistorialVO> getAll() throws DAOException {
		throw new DAOException("AUDITORIA-D-011", "Error en el metodo getAll ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public Collection<LogHistorialVO> findByFilter(LogHistorialVO filter)
			throws DAOException {
		throw new DAOException("AUDITORIA-D-009",
				"Error en el metodo findByFilter (" + CLASS_NAME + ")",
				new Exception("Method is not implemented"));
	}

}