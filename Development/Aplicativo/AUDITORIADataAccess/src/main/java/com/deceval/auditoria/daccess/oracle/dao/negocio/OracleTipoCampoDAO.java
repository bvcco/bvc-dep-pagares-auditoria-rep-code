package com.deceval.auditoria.daccess.oracle.dao.negocio;

import java.sql.Connection;
import java.util.Collection;

import com.deceval.auditoria.daccess.dao.negocio.TipoCampoDAO;
import com.deceval.auditoria.daccess.oracle.dao.OracleBaseDAO;
import com.deceval.auditoria.exception.DAOException;
import com.deceval.auditoria.vo.TipoCampoVO;

public class OracleTipoCampoDAO extends OracleBaseDAO implements TipoCampoDAO {

		
	private final static String CLASS_NAME = "OracleTipoCampoDAO";
	
	public static final String CAMPO_ = "";
	
	/**
	 * Crea un nuevo DAO con la conexión dada por la fábrica.
	 * 
	 * @param connection
	 */
	public OracleTipoCampoDAO(Connection connection) {
		super.setConnection(connection);
	}
	
	public TipoCampoVO insert(TipoCampoVO data) throws DAOException {
		throw new DAOException("AUDITORIA-D-001", "Error en el metodo update ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public void delete(TipoCampoVO llave) throws DAOException {
		throw new DAOException("AUDITORIA-D-003", "Error en el metodo delete ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public TipoCampoVO findByPrimaryKey(TipoCampoVO llave) throws DAOException {
		throw new DAOException("AUDITORIA-D-011", "Error en el metodo getAll ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public TipoCampoVO update(TipoCampoVO data, String[] updateFields)
			throws DAOException {
		throw new DAOException("AUDITORIA-D-005", "Error en el metodo update ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public Collection<TipoCampoVO> getAll() throws DAOException {
		throw new DAOException("AUDITORIA-D-011", "Error en el metodo getAll ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public Collection<TipoCampoVO> findByFilter(TipoCampoVO filter)
			throws DAOException {
		throw new DAOException("AUDITORIA-D-009",
				"Error en el metodo findByFilter (" + CLASS_NAME + ")",
				new Exception("Method is not implemented"));
	}

}