package com.deceval.auditoria.daccess.oracle.dao.negocio;

import java.sql.Connection;
import java.util.Collection;

import com.deceval.auditoria.daccess.dao.negocio.ObjetoDAO;
import com.deceval.auditoria.daccess.oracle.dao.OracleBaseDAO;
import com.deceval.auditoria.exception.DAOException;
import com.deceval.auditoria.vo.ObjetoVO;

public class OracleObjetoDAO extends OracleBaseDAO implements ObjetoDAO {

		
	private final static String CLASS_NAME = "OracleObjetoDAO";
	
	public final static String ENTIDAD_NOMBRE = "AUD_OBJETO";
	
	public static final String CAMPO_ID_OBJETO = "IDOBJETO";
	public static final String CAMPO_ID_APLICACION = "IDAPLICACION";
	public static final String CAMPO_NOMBRE_TABLA = "NOMBRETABLA";
	public static final String CAMPO_TITULO_TABLA = "TITULOTABLA";
	
	/**
	 * Crea un nuevo DAO con la conexión dada por la fábrica.
	 * 
	 * @param connection
	 */
	public OracleObjetoDAO(Connection connection) {
		super.setConnection(connection);
	}
	
	public ObjetoVO insert(ObjetoVO data) throws DAOException {
		throw new DAOException("AUDITORIA-D-001", "Error en el metodo update ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public void delete(ObjetoVO llave) throws DAOException {
		throw new DAOException("AUDITORIA-D-003", "Error en el metodo delete ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public ObjetoVO findByPrimaryKey(ObjetoVO llave) throws DAOException {
		throw new DAOException("AUDITORIA-D-011", "Error en el metodo getAll ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public ObjetoVO update(ObjetoVO data, String[] updateFields)
			throws DAOException {
		throw new DAOException("AUDITORIA-D-005", "Error en el metodo update ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public Collection<ObjetoVO> getAll() throws DAOException {
		throw new DAOException("AUDITORIA-D-011", "Error en el metodo getAll ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public Collection<ObjetoVO> findByFilter(ObjetoVO filter)
			throws DAOException {
		throw new DAOException("AUDITORIA-D-009",
				"Error en el metodo findByFilter (" + CLASS_NAME + ")",
				new Exception("Method is not implemented"));
	}
	
}
