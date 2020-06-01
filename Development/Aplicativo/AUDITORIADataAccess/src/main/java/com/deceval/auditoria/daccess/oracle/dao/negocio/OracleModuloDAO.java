package com.deceval.auditoria.daccess.oracle.dao.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import com.deceval.auditoria.daccess.dao.negocio.ModuloDAO;
import com.deceval.auditoria.daccess.oracle.dao.OracleBaseDAO;
import com.deceval.auditoria.exception.DAOException;
import com.deceval.auditoria.vo.ModuloVO;

public class OracleModuloDAO extends OracleBaseDAO implements ModuloDAO {

	private final static String CLASS_NAME = "OracleModuloDAO";

	/**
	 * Constante con nombre de la tabla en base de datos.
	 */
	public final static String ENTIDAD_NOMBRE = "AUD_MODULO";

	public static final String CAMPO_IDMODULO = "IDMODULO";
	public static final String CAMPO_IDAPLICACION = "IDAPLICACION";
	public static final String CAMPO_NOMBREMODULO = "NOMBREMODULO";	
	
	public final static String SQL_GET_ALL = 
		" SELECT " + CAMPO_IDMODULO + ", " + CAMPO_IDAPLICACION + ", " + CAMPO_NOMBREMODULO +
		" FROM " + ENTIDAD_NOMBRE;		
	
	public final static String SQL_FIND_BY_PRIMARY_KEY = 
		" SELECT " + CAMPO_IDMODULO + ", " + CAMPO_IDAPLICACION + ", " + CAMPO_NOMBREMODULO +
		" FROM " + ENTIDAD_NOMBRE + 
		" WHERE " + CAMPO_IDMODULO + " = ? ";		
	
	public final static String SQL_FIND_BY_ID_APLICACION = 
		" SELECT " + CAMPO_IDMODULO + ", " + CAMPO_IDAPLICACION + ", " + CAMPO_NOMBREMODULO +
		" FROM " + ENTIDAD_NOMBRE + 
		" WHERE " + CAMPO_IDAPLICACION + " = ? ";		
	
	/**
	 * Crea un nuevo DAO con la conexión dada por la fábrica.
	 * 
	 * @param connection
	 */
	public OracleModuloDAO(Connection connection) {
		super.setConnection(connection);
	}
	
	public ModuloVO insert(ModuloVO data) throws DAOException {
		throw new DAOException("AUDITORIA-D-001", "Error en el metodo update ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public void delete(ModuloVO llave) throws DAOException {
		throw new DAOException("AUDITORIA-D-003", "Error en el metodo delete ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}
	
	/**
	 * Devuelve el objeto a partir de su clave principal
	 * @param ModuloVO llave
	 * @return objeto ModuloVO
	 * @exception DAOException
	 * @author gmarroquin
	 */	
	public ModuloVO findByPrimaryKey(ModuloVO llave) throws DAOException {
		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		if(llave == null) return null;
		ModuloVO elemento = null;
		Integer 	idModulo;
		Integer 	idAplicacion;
		String 		nombreModulo;	
		try {
			if (this.getConnection() != null) {
				sentencia = this.getConnection().prepareStatement(SQL_FIND_BY_PRIMARY_KEY);
				sentencia.setInt(1, llave.getIdModulo());
				resultado = sentencia.executeQuery();	
				
				if(resultado != null && resultado.next()) {		
					idModulo		= resultado.getInt		(CAMPO_IDMODULO);
					idAplicacion	= resultado.getInt		(CAMPO_IDAPLICACION);
					nombreModulo 	= resultado.getString	(CAMPO_NOMBREMODULO);
					
					elemento = new ModuloVO();
					elemento.setIdModulo		(idModulo);
					elemento.setIdAplicacion	(idAplicacion);
					elemento.setNombreModulo	(nombreModulo);	
				}
			}
		} catch (SQLException e) {
			throw new DAOException("AUD-D-001", "Error en el metodo findByPrimaryKey ("+ CLASS_NAME + ")", e);
		} catch (Exception e) {
			throw new DAOException("AUD-D-0002","Error en el metodo findByPrimaryKey, excepcion inesperada("+ CLASS_NAME + ")", e);
		} finally {
			this.closeResources(null, sentencia);
		}
		return elemento;					
	}

	public ModuloVO update(ModuloVO data, String[] updateFields)
			throws DAOException {
		throw new DAOException("AUDITORIA-D-005", "Error en el metodo update ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public Collection<ModuloVO> getAll() throws DAOException {
		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		
		ArrayList<ModuloVO> coleccionARetornar = new ArrayList<ModuloVO>();
		ModuloVO elemento;
		
		try {
			if (this.getConnection() != null) {
				sentencia = this.getConnection().prepareStatement(SQL_GET_ALL);
				resultado = sentencia.executeQuery();
				
				if(resultado == null) return coleccionARetornar;	
				
				while(resultado.next()) {
					elemento = new ModuloVO();
					elemento.setIdModulo		(resultado.getInt		(CAMPO_IDMODULO));
					elemento.setIdAplicacion	(resultado.getInt		(CAMPO_IDAPLICACION));
					elemento.setNombreModulo	(resultado.getString	(CAMPO_NOMBREMODULO));
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

	public Collection<ModuloVO> findByIdAplicacion(Integer idAplicacion) throws DAOException {
		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		
		ArrayList<ModuloVO> coleccionARetornar = new ArrayList<ModuloVO>();
		ModuloVO elemento;
		
		try {
			if (this.getConnection() != null) {
				sentencia = this.getConnection().prepareStatement(SQL_FIND_BY_ID_APLICACION);
				sentencia.setInt(1, idAplicacion);
				resultado = sentencia.executeQuery();
				
				if(resultado == null) return coleccionARetornar;	
				
				while(resultado.next()) {
					elemento = new ModuloVO();
					elemento.setIdModulo		(resultado.getInt		(CAMPO_IDMODULO));
					elemento.setIdAplicacion	(resultado.getInt		(CAMPO_IDAPLICACION));
					elemento.setNombreModulo	(resultado.getString	(CAMPO_NOMBREMODULO));
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
	
	public Collection<ModuloVO> findByFilter(ModuloVO filter)
			throws DAOException {
		throw new DAOException("AUDITORIA-D-009","Error en el metodo findByFilter (" 
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}
	
}
