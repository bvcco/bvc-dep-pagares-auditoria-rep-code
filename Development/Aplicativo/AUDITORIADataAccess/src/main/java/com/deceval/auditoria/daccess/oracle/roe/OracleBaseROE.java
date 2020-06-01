package com.deceval.auditoria.daccess.oracle.roe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.deceval.auditoria.exception.DAOException;

/**
 * Clase base de los ROE Oracle Se encarga de gestionar el cierre de los
 * recursos jdbc
 * 
 * @version 1.0
 * @author Johann Camilo Olarte Díaz.
 */
public class OracleBaseROE {

	/**
	 * Conexión de base de datos a usar.
	 */
	private Connection connection = null;

	public void setConnection(Connection conn) {
		this.connection = conn;
	}

	public Connection getConnection() {
		return this.connection;
	}

	/**
	 * Metodo que permite cerrar los recursos que se obtienen de la base de
	 * datos
	 * 
	 * @param rs
	 *            Objeto resulset de la base de datos
	 * @param ps
	 *            Objeto statement de la base de datos
	 * @throws DAOException
	 *             (Si ocurre algún error al intentar cerrar los recursos)
	 */
	public void closeResources(ResultSet rs, Statement ps) throws DAOException {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException sqle) {
			String mensajeError = "\nClase   : "
					+ this.getClass().getName()
					+ "\nMétodo  : cerrarConexion(ResultSet rs, Statement ps, Connection con) "
					+ "\nMensaje Unico  :Imposible cerrar el result set";
			throw new DAOException("", mensajeError, sqle);

		}

		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException sqle) {
			String mensajeError = "\nClase   : "
					+ this.getClass().getName()
					+ "\nMétodo  : cerrarConexion(ResultSet rs, Statement ps, Connection con) "
					+ "\nMensaje Unico  :Imposible cerrar la sentencia";
			throw new DAOException("", mensajeError, sqle);
		}

	}

}
