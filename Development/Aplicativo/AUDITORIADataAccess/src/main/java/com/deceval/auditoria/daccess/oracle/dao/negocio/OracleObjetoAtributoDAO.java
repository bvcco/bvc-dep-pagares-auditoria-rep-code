package com.deceval.auditoria.daccess.oracle.dao.negocio;

import java.sql.Connection;
import java.util.Collection;

import com.deceval.auditoria.daccess.dao.negocio.ObjetoAtributoDAO;
import com.deceval.auditoria.daccess.oracle.dao.OracleBaseDAO;
import com.deceval.auditoria.exception.DAOException;
import com.deceval.auditoria.vo.ObjetoAtributoVO;

public class OracleObjetoAtributoDAO extends OracleBaseDAO implements ObjetoAtributoDAO {

		
	private final static String CLASS_NAME = "OracleObjetoAtributoDAO";
	
	public static final String CAMPO_ = "";
	
	/**
	 * Crea un nuevo DAO con la conexión dada por la fábrica.
	 * 
	 * @param connection
	 */
	public OracleObjetoAtributoDAO(Connection connection) {
		super.setConnection(connection);
	}
	
	public ObjetoAtributoVO insert(ObjetoAtributoVO data) throws DAOException {
		throw new DAOException("AUDITORIA-D-001", "Error en el metodo update ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public void delete(ObjetoAtributoVO llave) throws DAOException {
		throw new DAOException("AUDITORIA-D-003", "Error en el metodo delete ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public ObjetoAtributoVO findByPrimaryKey(ObjetoAtributoVO llave) throws DAOException {
		throw new DAOException("AUDITORIA-D-011", "Error en el metodo getAll ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public ObjetoAtributoVO update(ObjetoAtributoVO data, String[] updateFields)
			throws DAOException {
		throw new DAOException("AUDITORIA-D-005", "Error en el metodo update ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public Collection<ObjetoAtributoVO> getAll() throws DAOException {
		throw new DAOException("AUDITORIA-D-011", "Error en el metodo getAll ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public Collection<ObjetoAtributoVO> findByFilter(ObjetoAtributoVO filter)
			throws DAOException {
		throw new DAOException("AUDITORIA-D-009",
				"Error en el metodo findByFilter (" + CLASS_NAME + ")",
				new Exception("Method is not implemented"));
	}

}
