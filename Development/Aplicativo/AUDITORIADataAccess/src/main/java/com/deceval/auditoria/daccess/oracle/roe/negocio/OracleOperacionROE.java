package com.deceval.auditoria.daccess.oracle.roe.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.deceval.auditoria.daccess.oracle.roe.OracleBaseROE;
import com.deceval.auditoria.daccess.roe.negocio.OperacionROE;
import com.deceval.auditoria.dto.EstructuraOperacionDTO;
import com.deceval.auditoria.exception.DAOException;
import com.deceval.auditoria.vo.AccionVO;
import com.deceval.auditoria.vo.AplicacionVO;
import com.deceval.auditoria.vo.ModuloVO;
import com.deceval.auditoria.vo.OperacionVO;

public class OracleOperacionROE extends OracleBaseROE  implements OperacionROE{
	
	private final static String CLASS_NAME = "OracleOperacionROE";
	
	private final static String TABLA_OPERACION ="AUD_OPERACION";
	private final static String TABLA_ACCION ="AUD_ACCION";
	private final static String TABLA_MODULO ="AUD_MODULO";
	private final static String TABLA_APLICACION ="AUD_APLICACION";
	
	//Campos tabla AUD_OPERACION
	private final static String CAMPO_OPERACION_IDOPERACION = "IDOPERACION";
	private final static String CAMPO_OPERACION_IDMODULO = "IDMODULO";
	private final static String CAMPO_OPERACION_IDACCION = "IDACCION";
	private final static String CAMPO_OPERACION_DESCRIPCIONOPERACION = "DESCRIPCIONOPERACION";
	
	//Campos tabla AUD_ACCION
	private final static String CAMPO_ACCION_IDACCION = "IDACCION";
	private final static String CAMPO_ACCION_NOMBREACCION = "NOMBREACCION";
	
	//Campos tabla AUD_APLICACION
	private final static String CAMPO_APLICACION_IDAPLICACION = "IDAPLICACION";
	private final static String CAMPO_APLICACION_NOMBREAPLICACION = "NOMBREAPLICACION";
		
	//Campos tabla AUD_MODULO
	private final static String CAMPO_MODULO_IDMODULO = "IDMODULO";
	private final static String CAMPO_MODULO_IDAPLICACION = "IDAPLICACION";
	private final static String CAMPO_MODULO_NOMBREMODULO = "NOMBREMODULO";
	
	private final static String FIND_ESTRUCTURA_OPERACION_BY_IDOPERACION = 
		" SELECT OP." + CAMPO_OPERACION_IDOPERACION + ", OP." + CAMPO_OPERACION_IDMODULO + ", OP."+CAMPO_OPERACION_IDACCION +
		" , OP." + CAMPO_OPERACION_DESCRIPCIONOPERACION + ", AC." + CAMPO_ACCION_NOMBREACCION + " , MD." + CAMPO_MODULO_IDMODULO + 
		" , MD." + CAMPO_MODULO_IDAPLICACION + ", MD." + CAMPO_MODULO_NOMBREMODULO + ", AP." + CAMPO_APLICACION_NOMBREAPLICACION +
		" FROM " + TABLA_OPERACION + " OP " +
		" INNER JOIN " + TABLA_MODULO + " MD ON (OP." + CAMPO_OPERACION_IDMODULO + "=MD." + CAMPO_MODULO_IDMODULO + ") "+
		" INNER JOIN " + TABLA_APLICACION + " AP ON (MD." + CAMPO_MODULO_IDAPLICACION + "=AP." + CAMPO_APLICACION_IDAPLICACION + ") " +
		" INNER JOIN " + TABLA_ACCION + " AC ON (OP." + CAMPO_OPERACION_IDACCION + "=AC." + CAMPO_ACCION_IDACCION + ") " +
		" WHERE OP." + CAMPO_OPERACION_IDOPERACION + "=?";
	
	/**
	 * Contructor del ROE para la estructura de  una operacions
	 * @param connection Define la conexión a la base de datos
	 */
	public OracleOperacionROE(Connection connection){
		super.setConnection(connection);		
	}
	
	/**
	 * Metodo que consulta toda la estructura de un idOperacion determinado
	 */
	public EstructuraOperacionDTO consultarEstructuraByIdOperacion(EstructuraOperacionDTO estructura) throws DAOException{
		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		try {
			if (this.getConnection() != null) {
				sentencia = this.getConnection().prepareStatement(FIND_ESTRUCTURA_OPERACION_BY_IDOPERACION);
				sentencia.setInt(1, estructura.getOperacionVO().getIdOperacion());
				resultado = sentencia.executeQuery();
				if(resultado != null && resultado.next()){
					OperacionVO operacion = new OperacionVO(); 
					ModuloVO modulo = new ModuloVO();
					AplicacionVO aplicacion = new AplicacionVO();
					AccionVO accion =  new AccionVO();
					
					operacion.setIdOperacion(estructura.getOperacionVO().getIdOperacion());
					operacion.setIdModulo(resultado.getInt(CAMPO_OPERACION_IDMODULO));
					operacion.setIdAccion(resultado.getInt(CAMPO_OPERACION_IDACCION));
					operacion.setDescripcionOperacion(resultado.getString(CAMPO_OPERACION_DESCRIPCIONOPERACION));
					
					modulo.setIdModulo(operacion.getIdModulo());
					modulo.setIdAplicacion(resultado.getInt(CAMPO_MODULO_IDAPLICACION));
					modulo.setNombreModulo(resultado.getString(CAMPO_MODULO_NOMBREMODULO));
					
					aplicacion.setIdAplicacion(modulo.getIdAplicacion());
					aplicacion.setNombreAplicacion(resultado.getString(CAMPO_APLICACION_NOMBREAPLICACION));
					
					accion.setIdAccion(operacion.getIdAccion());
					accion.setNombreAccion(resultado.getString(CAMPO_ACCION_NOMBREACCION));
					
					estructura.setOperacionVO(operacion);
					estructura.setModuloVO(modulo);
					estructura.setAplicacionVO(aplicacion);
					estructura.setAccionVO(accion);
				}
			}
		} catch (SQLException e) {
			throw new DAOException("AUD-D-001", "Error en el metodo consultarEstructuraByIdOperacion ("+ CLASS_NAME + ")", e);
		} catch (Exception e) {
			throw new DAOException("AUD-D-0002","Error en el metodo consultarEstructuraByIdOperacion, excepcion inesperada("+ CLASS_NAME + ")", e);
		} finally {
			this.closeResources(resultado, sentencia);
		}
		return estructura;
	}

}
