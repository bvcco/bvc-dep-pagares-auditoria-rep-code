package com.deceval.auditoria.daccess.oracle.dao.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.deceval.auditoria.daccess.dao.negocio.OperacionDAO;
import com.deceval.auditoria.daccess.oracle.dao.OracleBaseDAO;
import com.deceval.auditoria.exception.DAOException;
import com.deceval.auditoria.vo.OperacionVO;

public class OracleOperacionDAO extends OracleBaseDAO implements OperacionDAO {

	private final static String CLASS_NAME = "OracleOperacionDAO";

	/**
	 * Constante con nombre de la tabla en base de datos.
	 */
	public final static String ENTIDAD_NOMBRE = "AUD_OPERACION";

	public final static String CAMPO_IDOPERACION = "IDOPERACION";
	public final static String CAMPO_IDMODULO = "IDMODULO";
	public final static String CAMPO_IDACCION = "IDACCION";
	public final static String CAMPO_DESCRIPCIONOPERACION = "DESCRIPCIONOPERACION";
	public final static String CAMPO_CONSTANTEREFERENCIA = "CONSTANTEREFERENCIA";
	
	public final static String SQL_FIND_BY_PRIMARY_KEY = 
		" SELECT " + CAMPO_IDOPERACION + ", " + CAMPO_IDMODULO + ", " + CAMPO_IDACCION + ", " + CAMPO_DESCRIPCIONOPERACION + ", " + CAMPO_CONSTANTEREFERENCIA +
		" FROM " + ENTIDAD_NOMBRE + " WHERE " + CAMPO_IDOPERACION + "=? ";
	
	public final static String SQL_FIND_BY_CONSTANTEREFERENCIA = 
		" SELECT " + CAMPO_IDOPERACION + ", " + CAMPO_IDMODULO + ", " + CAMPO_IDACCION + ", " + CAMPO_DESCRIPCIONOPERACION + ", " + CAMPO_CONSTANTEREFERENCIA +
		" FROM " + ENTIDAD_NOMBRE + " WHERE upper(" + CAMPO_CONSTANTEREFERENCIA + ")=upper(?) ";
	
	public final static String SQL_GET_ALL = 
		" SELECT " + CAMPO_IDOPERACION + ", " + CAMPO_IDMODULO + ", " + CAMPO_IDACCION + ", " + CAMPO_DESCRIPCIONOPERACION + ", " + CAMPO_CONSTANTEREFERENCIA +
		" FROM " + ENTIDAD_NOMBRE;			
	
	public final static String SQL_FIND_BY_ID_MODULO = 
		" SELECT " + CAMPO_IDOPERACION + ", " + CAMPO_IDMODULO + ", " + CAMPO_IDACCION + ", " + CAMPO_DESCRIPCIONOPERACION + ", " + CAMPO_CONSTANTEREFERENCIA +
		" FROM " + ENTIDAD_NOMBRE + " WHERE " + CAMPO_IDMODULO + "=? ";	
	
	/**
	 * Crea un nuevo DAO con la conexión dada por la fábrica.
	 * 
	 * @param connection
	 */
	public OracleOperacionDAO(Connection connection) {
		super.setConnection(connection);
	}
	
	public OperacionVO insert(OperacionVO data) throws DAOException {
		throw new DAOException("AUDITORIA-D-001", "Error en el metodo update ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public void delete(OperacionVO llave) throws DAOException {
		throw new DAOException("AUDITORIA-D-003", "Error en el metodo delete ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public OperacionVO findByPrimaryKey(OperacionVO llave) throws DAOException {
		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		try {
			if (this.getConnection() != null) {
				sentencia = this.getConnection().prepareStatement(SQL_FIND_BY_PRIMARY_KEY);
				sentencia.setInt(1, llave.getIdOperacion());
				resultado = sentencia.executeQuery();
				if(resultado != null && resultado.next()){
					llave.setIdOperacion(resultado.getInt(CAMPO_IDOPERACION));
					llave.setIdModulo(resultado.getInt(CAMPO_IDMODULO));
					llave.setIdAccion(resultado.getInt(CAMPO_IDACCION));
					llave.setDescripcionOperacion(resultado.getString(CAMPO_DESCRIPCIONOPERACION));
					llave.setConstanteReferencia(resultado.getString(CAMPO_CONSTANTEREFERENCIA));
				}
			}
		} catch (SQLException e) {
			throw new DAOException("AUD-D-001", "Error en el metodo findByPrimaryKey ("+ CLASS_NAME + ")", e);
		} catch (Exception e) {
			throw new DAOException("AUD-D-0002","Error en el metodo findByPrimaryKey, excepcion inesperada("+ CLASS_NAME + ")", e);
		} finally {
			this.closeResources(null, sentencia);
		}
		return llave;
	}

	public OperacionVO update(OperacionVO data, String[] updateFields)
			throws DAOException {
		throw new DAOException("AUDITORIA-D-005", "Error en el metodo update ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public Collection<OperacionVO> getAll() throws DAOException {
		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		
		ArrayList<OperacionVO> coleccionARetornar = new ArrayList<OperacionVO>();
		OperacionVO elemento;
		
		try {
			if (this.getConnection() != null) {
				sentencia = this.getConnection().prepareStatement(SQL_GET_ALL);
				resultado = sentencia.executeQuery();
				
				if(resultado == null) return coleccionARetornar;	
				
				while(resultado.next()) {
					elemento = new OperacionVO();
					elemento.setIdOperacion				(resultado.getInt		(CAMPO_IDOPERACION));
					elemento.setIdModulo				(resultado.getInt		(CAMPO_IDMODULO));
					elemento.setIdAccion				(resultado.getInt		(CAMPO_IDACCION));
					elemento.setDescripcionOperacion	(resultado.getString	(CAMPO_DESCRIPCIONOPERACION));
					elemento.setConstanteReferencia		(resultado.getString	(CAMPO_CONSTANTEREFERENCIA));
					coleccionARetornar.add(elemento);
				}
			}
		} catch (SQLException e) {
			throw new DAOException("AUD-D-001", "Error en el metodo getAll ("+ CLASS_NAME + ")", e);
		} catch (Exception e) {
			throw new DAOException("AUD-D-0002","Error en el metodo getAll, excepcion inesperada("+ CLASS_NAME + ")", e);
		} finally {
			this.closeResources(null, sentencia);
		}
		return coleccionARetornar;	
	}

	public Collection<OperacionVO> findByIdModulo(Integer idModulo) throws DAOException {
		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		
		ArrayList<OperacionVO> coleccionARetornar = new ArrayList<OperacionVO>();
		OperacionVO elemento;
		
		try {
			if (this.getConnection() != null) {
				sentencia = this.getConnection().prepareStatement(SQL_FIND_BY_ID_MODULO);
				sentencia.setInt(1, idModulo);
				resultado = sentencia.executeQuery();
				
				if(resultado == null) return coleccionARetornar;	
				
				while(resultado.next()) {
					elemento = new OperacionVO();
					elemento.setIdOperacion				(resultado.getInt		(CAMPO_IDOPERACION));
					elemento.setIdModulo				(resultado.getInt		(CAMPO_IDMODULO));
					elemento.setIdAccion				(resultado.getInt		(CAMPO_IDACCION));
					elemento.setDescripcionOperacion	(resultado.getString	(CAMPO_DESCRIPCIONOPERACION));
					elemento.setConstanteReferencia		(resultado.getString	(CAMPO_CONSTANTEREFERENCIA));
					coleccionARetornar.add(elemento);
				}
			}
		} catch (SQLException e) {
			throw new DAOException("AUD-D-001", "Error en el metodo findByIdModulo ("+ CLASS_NAME + ")", e);
		} catch (Exception e) {
			throw new DAOException("AUD-D-0002","Error en el metodo findByIdModulo, excepcion inesperada("+ CLASS_NAME + ")", e);
		} finally {
			this.closeResources(null, sentencia);
		}
		return coleccionARetornar;	
	}
	
	public Collection<OperacionVO> findByFilter(OperacionVO filter)
			throws DAOException {
		throw new DAOException("AUDITORIA-D-009","Error en el metodo findByFilter (" 
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}
	
	public OperacionVO findByConstanteReferencia(OperacionVO llave) throws DAOException {
		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		try {
			if (this.getConnection() != null) {
				sentencia = this.getConnection().prepareStatement(SQL_FIND_BY_CONSTANTEREFERENCIA);
				sentencia.setString(1, llave.getConstanteReferencia());
				resultado = sentencia.executeQuery();
				if(resultado != null && resultado.next()){
					llave.setIdOperacion(resultado.getInt(CAMPO_IDOPERACION));
					llave.setIdModulo(resultado.getInt(CAMPO_IDMODULO));
					llave.setIdAccion(resultado.getInt(CAMPO_IDACCION));
					llave.setDescripcionOperacion(resultado.getString(CAMPO_DESCRIPCIONOPERACION));
					llave.setConstanteReferencia(resultado.getString(CAMPO_CONSTANTEREFERENCIA));
				}
			}
		} catch (SQLException e) {
			throw new DAOException("AUD-D-001", "Error en el metodo findByConstanteReferencia ("+ CLASS_NAME + ")", e);
		} catch (Exception e) {
			throw new DAOException("AUD-D-0002","Error en el metodo findByConstanteReferencia, excepcion inesperada("+ CLASS_NAME + ")", e);
		} finally {
			this.closeResources(null, sentencia);
		}
		return llave;
	}
	
}
