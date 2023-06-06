package com.deceval.auditoria.daccess.oracle.dao.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import com.deceval.auditoria.daccess.dao.negocio.HomologacionDAO;
import com.deceval.auditoria.daccess.oracle.dao.OracleBaseDAO;
import com.deceval.auditoria.exception.DAOException;
import com.deceval.auditoria.vo.HomologacionVO;

public class OracleHomologacionDAO extends OracleBaseDAO implements HomologacionDAO  {

	private final static String CLASS_NAME = "OracleHomologacionDAO";

	/**
	 * Constante con nombre de la tabla en base de datos.
	 */
	public final static String ENTIDAD_NOMBRE = "AUD_HOMOLOGACION";
	
	public static final String CAMPO_ID_HOMOLOGACION = "idHomologacion";
	public static final String CAMPO_ID_TABLA_AUDITORIA= "idTablaAuditoria";
	public static final String CAMPO_VALOR_AUDITORIA = "valorAuditoria";
	public static final String CAMPO_VALOR_EXTERNO = "valorExterno";
	public static final String CAMPO_ID_TABLA_REFERENCIA = "idTablaReferencia";
	
	private final static String SQL_FIND_BY_ID_TBL_AUDIT_AND_VAL_AUDIT_AND_ID_TBL_REF= 
		"SELECT " + CAMPO_ID_HOMOLOGACION + ", " + CAMPO_VALOR_EXTERNO + 
		" FROM " + ENTIDAD_NOMBRE +
		" WHERE " + CAMPO_ID_TABLA_AUDITORIA + " = ? AND " +
					CAMPO_VALOR_AUDITORIA + " = ? AND " +
					CAMPO_ID_TABLA_REFERENCIA + " = ? ";
	
	/**
	 * Crea un nuevo DAO con la conexión dada por la fábrica.
	 * 
	 * @param connection
	 */
	public OracleHomologacionDAO(Connection connection) {
		super.setConnection(connection);
	}	
	
	public HomologacionVO insert(HomologacionVO data) throws DAOException {
		throw new DAOException("AUDITORIA-D-001", "Error en el metodo update ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public void delete(HomologacionVO llave) throws DAOException {
		throw new DAOException("AUDITORIA-D-003", "Error en el metodo delete ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public HomologacionVO findByPrimaryKey(HomologacionVO llave) throws DAOException {
		throw new DAOException("AUDITORIA-D-011", "Error en el metodo getAll ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public HomologacionVO update(HomologacionVO data, String[] updateFields)
			throws DAOException {
		throw new DAOException("AUDITORIA-D-005", "Error en el metodo update ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public Collection<HomologacionVO> getAll() throws DAOException {
		throw new DAOException("AUDITORIA-D-011", "Error en el metodo getAll ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public Collection<HomologacionVO> findByFilter(HomologacionVO filter)
			throws DAOException {
		throw new DAOException("AUDITORIA-D-009",
				"Error en el metodo findByFilter (" + CLASS_NAME + ")",
				new Exception("Method is not implemented"));
	}
	
	/**
	 * Devuelve el objeto a partir de su idTablaAuditoria, valorAuditoria y idTablaReferencia
	 * @param HomologacionVO llave
	 * @return objeto HomologacionVO
	 * @author gmarroquin
	 * @throws DAOException 
	 */		
	public HomologacionVO findByIdTblAuditAndValAuditAndIdTblRef(
			HomologacionVO llave) throws DAOException {
		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		try {
			if (this.getConnection() != null) {
				sentencia = this.getConnection().prepareStatement(SQL_FIND_BY_ID_TBL_AUDIT_AND_VAL_AUDIT_AND_ID_TBL_REF);
				sentencia.setInt(1, llave.getIdTablaAuditoria());
				sentencia.setInt(2, llave.getValorAuditoria());
				sentencia.setInt(3, llave.getIdTablaReferencia());
				resultado = sentencia.executeQuery();
				if(resultado != null && resultado.next()){
					llave.setIdHomologacion(resultado.getLong(CAMPO_ID_HOMOLOGACION));
					llave.setValorExterno(resultado.getInt(CAMPO_VALOR_EXTERNO));
				}
			}
		} catch (SQLException e) {
			throw new DAOException("AUD-D-001", "Error en el metodo findByIdTblAuditAndValAuditAndIdTblRef ("+ CLASS_NAME + ")", e);
		} catch (Exception e) {
			throw new DAOException("AUD-D-0002","Error en el metodo findByIdTblAuditAndValAuditAndIdTblRef, excepcion inesperada("+ CLASS_NAME + ")", e);
		} finally {
			this.closeResources(null, sentencia);
		}
		return llave;
	}
}
