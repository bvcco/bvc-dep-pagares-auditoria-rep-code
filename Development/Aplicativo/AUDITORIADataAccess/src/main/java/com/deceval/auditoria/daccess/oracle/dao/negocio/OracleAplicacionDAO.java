package com.deceval.auditoria.daccess.oracle.dao.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.deceval.auditoria.daccess.dao.negocio.AplicacionDAO;
import com.deceval.auditoria.daccess.oracle.dao.OracleBaseDAO;
import com.deceval.auditoria.exception.DAOException;
import com.deceval.auditoria.vo.AplicacionVO;

public class OracleAplicacionDAO extends OracleBaseDAO implements AplicacionDAO {

	private final static String CLASS_NAME = "OracleAplicacionDAO";

	/**
	 * Constante con nombre de la tabla en base de datos.
	 */
	public final static String ENTIDAD_NOMBRE = "AUD_APLICACION";

	public static final String CAMPO_IDAPLICACION = "IDAPLICACION";
	public static final String CAMPO_NOMBREAPLICACION = "NOMBREAPLICACION";	
	
	public final static String SQL_GET_ALL = 
		" SELECT " + CAMPO_IDAPLICACION + ", " + CAMPO_NOMBREAPLICACION +
		" FROM " + ENTIDAD_NOMBRE;	
	
	public final static String SQL_FIND_BY_PRIMARY_KEY = 
		" SELECT " + CAMPO_IDAPLICACION + ", " + CAMPO_NOMBREAPLICACION +
		" FROM " + ENTIDAD_NOMBRE + 
		" WHERE " + CAMPO_IDAPLICACION + " = ? ";		
	
	/**
	 * Crea un nuevo DAO con la conexión dada por la fábrica.
	 * 
	 * @param connection
	 */
	public OracleAplicacionDAO(Connection connection) {
		super.setConnection(connection);
	}
	
	public AplicacionVO insert(AplicacionVO data) throws DAOException {
		throw new DAOException("AUDITORIA-D-001", "Error en el metodo update ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public void delete(AplicacionVO llave) throws DAOException {
		throw new DAOException("AUDITORIA-D-003", "Error en el metodo delete ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	/**
	 * Devuelve el objeto a partir de su clave principal
	 * @param AplicacionVO llave
	 * @return objeto AplicacionVO
	 * @exception DAOException
	 * @author gmarroquin
	 */	
	public AplicacionVO findByPrimaryKey(AplicacionVO llave) throws DAOException {
		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		if(llave == null) return null;
		AplicacionVO elemento = null;
		Integer idAplicacion;
		String nombreAplicacion;		
		try {
			if (this.getConnection() != null) {
				sentencia = this.getConnection().prepareStatement(SQL_FIND_BY_PRIMARY_KEY);
				sentencia.setInt(1, llave.getIdAplicacion());
				resultado = sentencia.executeQuery();	
				
				if(resultado != null && resultado.next()) {				
					idAplicacion		= resultado.getInt		(CAMPO_IDAPLICACION);
					nombreAplicacion 	= resultado.getString	(CAMPO_NOMBREAPLICACION);
					
					elemento = new AplicacionVO();
					elemento.setIdAplicacion		(idAplicacion);
					elemento.setNombreAplicacion	(nombreAplicacion);		
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

	public AplicacionVO update(AplicacionVO data, String[] updateFields)
			throws DAOException {
		throw new DAOException("AUDITORIA-D-005", "Error en el metodo update ("
				+ CLASS_NAME + ")", new Exception("Method is not implemented"));
	}

	public Collection<AplicacionVO> getAll() throws DAOException {
		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		
		ArrayList<AplicacionVO> coleccionARetornar = new ArrayList<AplicacionVO>();
		AplicacionVO elemento;
		
		try {
			if (this.getConnection() != null) {
				sentencia = this.getConnection().prepareStatement(SQL_GET_ALL);
				resultado = sentencia.executeQuery();
				
				if(resultado == null) return coleccionARetornar;	
				
				while(resultado.next()) {
					elemento = new AplicacionVO();
					elemento.setIdAplicacion(resultado.getInt(CAMPO_IDAPLICACION));
					elemento.setNombreAplicacion(resultado.getString(CAMPO_NOMBREAPLICACION));
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

	public Collection<AplicacionVO> findByFilter(AplicacionVO filter)
			throws DAOException {
		throw new DAOException("AUDITORIA-D-009",
				"Error en el metodo findByFilter (" + CLASS_NAME + ")",
				new Exception("Method is not implemented"));
	}
	
}
