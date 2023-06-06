package com.deceval.auditoria.daccess.oracle.dao.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import com.deceval.auditoria.daccess.dao.negocio.OrigenDAO;
import com.deceval.auditoria.daccess.oracle.dao.OracleBaseDAO;
import com.deceval.auditoria.exception.DAOException;
import com.deceval.auditoria.vo.OrigenVO;

public class OracleOrigenDAO extends OracleBaseDAO implements OrigenDAO {

	private final static String CLASS_NAME = "OracleOrigenDAO"; 

	/**
	 * Constante con nombre de la tabla en base de datos.
	 */
	public final static String ENTIDAD_NOMBRE = "AUD_ORIGEN";

	public static final String CAMPO_IDORIGEN = "IDORIGEN";
	public static final String CAMPO_IDAPLICACION = "IDAPLICACION";
	public static final String CAMPO_DESCRIPCIONORIGEN = "DESCRIPCIONORIGEN";
	public static final String CAMPO_CONSTANTEREFERENCIA = "CONSTANTEREFERENCIA";
	
	public final static String SQL_FIND_BY_PRIMARY_KEY = 
		" SELECT " + CAMPO_IDORIGEN + ", " + CAMPO_IDAPLICACION + ", " + CAMPO_DESCRIPCIONORIGEN + ", " + CAMPO_CONSTANTEREFERENCIA + 
		" FROM " + ENTIDAD_NOMBRE + " WHERE " + CAMPO_IDORIGEN + "=? ";
	
	public final static String SQL_FIND_BY_CONSTANTEREFERENCIA = 
		" SELECT " + CAMPO_IDORIGEN + ", " + CAMPO_IDAPLICACION + ", " + CAMPO_DESCRIPCIONORIGEN + ", " + CAMPO_CONSTANTEREFERENCIA + 
		" FROM " + ENTIDAD_NOMBRE + " WHERE upper(" + CAMPO_CONSTANTEREFERENCIA + ")=upper(?) ";
	
	public final static String SQL_GET_ALL = 
		" SELECT " + CAMPO_IDORIGEN + ", " + CAMPO_IDAPLICACION + ", " + CAMPO_DESCRIPCIONORIGEN + ", " + CAMPO_CONSTANTEREFERENCIA + 
		" FROM " + ENTIDAD_NOMBRE;		
	
	public final static String SQL_FIND_BY_ID_APLICACION = 
		" SELECT " + CAMPO_IDORIGEN + ", " + CAMPO_IDAPLICACION + ", " + CAMPO_DESCRIPCIONORIGEN + ", " + CAMPO_CONSTANTEREFERENCIA + 
		" FROM " + ENTIDAD_NOMBRE + " WHERE " + CAMPO_IDAPLICACION + "=? ";	
	
	/**
	 * Crea un nuevo DAO con la conexión dada por la fábrica.
	 * 
	 * @param connection
	 */
	public OracleOrigenDAO(Connection connection) {
		super.setConnection(connection);
	}
	
	public OrigenVO insert(OrigenVO data) throws DAOException {
		throw new DAOException("AUDITORIA-D-001", "Error en el metodo update ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public void delete(OrigenVO llave) throws DAOException {
		throw new DAOException("AUDITORIA-D-003", "Error en el metodo delete ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	/**
	 * Devuelve el objeto a partir de su clave principal
	 * @param OrigenVO llave
	 * @return objeto OrigenVO
	 * @author gmarroquin
	 * @throws DAOException 
	 */	
	public OrigenVO findByPrimaryKey(OrigenVO llave) throws DAOException {
		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		try {
			if (this.getConnection() != null) {
				sentencia = this.getConnection().prepareStatement(SQL_FIND_BY_PRIMARY_KEY);
				sentencia.setInt(1, llave.getIdOrigen());
				resultado = sentencia.executeQuery();
				if(resultado != null && resultado.next()){
					llave.setIdOrigen(resultado.getInt(CAMPO_IDORIGEN));
					llave.setIdAplicacion(resultado.getInt(CAMPO_IDAPLICACION));
					llave.setDescripcionOrigen(resultado.getString(CAMPO_DESCRIPCIONORIGEN));
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

	public OrigenVO update(OrigenVO data, String[] updateFields)
			throws DAOException {
		throw new DAOException("AUDITORIA-D-005", "Error en el metodo update ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public Collection<OrigenVO> getAll() throws DAOException {
		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		
		ArrayList<OrigenVO> coleccionARetornar = new ArrayList<OrigenVO>();
		OrigenVO elemento;
		
		try {
			if (this.getConnection() != null) {
				sentencia = this.getConnection().prepareStatement(SQL_GET_ALL);
				resultado = sentencia.executeQuery();
				
				if(resultado == null) return coleccionARetornar;	
				
				while(resultado.next()) {
					elemento = new OrigenVO();
					elemento.setIdOrigen			(resultado.getInt		(CAMPO_IDORIGEN));
					elemento.setIdAplicacion		(resultado.getInt		(CAMPO_IDAPLICACION));
					elemento.setDescripcionOrigen	(resultado.getString	(CAMPO_DESCRIPCIONORIGEN));
					elemento.setConstanteReferencia	(resultado.getString	(CAMPO_CONSTANTEREFERENCIA));
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
	
	public Collection<OrigenVO> findByIdAplicacion(Integer idAplicacion) throws DAOException {
		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		
		ArrayList<OrigenVO> coleccionARetornar = new ArrayList<OrigenVO>();
		OrigenVO elemento;
		
		try {
			if (this.getConnection() != null) {
				sentencia = this.getConnection().prepareStatement(SQL_FIND_BY_ID_APLICACION);
				sentencia.setInt(1, idAplicacion);
				resultado = sentencia.executeQuery();
				
				if(resultado == null) return coleccionARetornar;	
				
				while(resultado.next()) {
					elemento = new OrigenVO();
					elemento.setIdOrigen			(resultado.getInt		(CAMPO_IDORIGEN));
					elemento.setIdAplicacion		(resultado.getInt		(CAMPO_IDAPLICACION));
					elemento.setDescripcionOrigen	(resultado.getString	(CAMPO_DESCRIPCIONORIGEN));
					elemento.setConstanteReferencia	(resultado.getString	(CAMPO_CONSTANTEREFERENCIA));
					coleccionARetornar.add(elemento);
				}
			}
		} catch (SQLException e) {
			throw new DAOException("AUD-D-001", "Error en el metodo findByIdAplicacion ("+ CLASS_NAME + ")", e);
		} catch (Exception e) {
			throw new DAOException("AUD-D-0002","Error en el metodo findByIdAplicacion, excepcion inesperada("+ CLASS_NAME + ")", e);
		} finally {
			this.closeResources(null, sentencia);
		}
		return coleccionARetornar;	
	}

	public Collection<OrigenVO> findByFilter(OrigenVO filter)
			throws DAOException {
		throw new DAOException("AUDITORIA-D-009","Error en el metodo findByFilter (" 
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}
	
	public OrigenVO findByConstanteReferencia(OrigenVO llave) throws DAOException{
		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		try {
			if (this.getConnection() != null) {
				sentencia = this.getConnection().prepareStatement(SQL_FIND_BY_CONSTANTEREFERENCIA);
				sentencia.setString(1, llave.getConstanteReferencia());
				resultado = sentencia.executeQuery();
				if(resultado != null && resultado.next()){
					llave.setIdOrigen(resultado.getInt(CAMPO_IDORIGEN));
					llave.setIdAplicacion(resultado.getInt(CAMPO_IDAPLICACION));
					llave.setDescripcionOrigen(resultado.getString(CAMPO_DESCRIPCIONORIGEN));
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

