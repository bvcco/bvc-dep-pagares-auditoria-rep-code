package com.deceval.auditoria.daccess.oracle.roe.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.deceval.auditoria.daccess.oracle.roe.OracleBaseROE;
import com.deceval.auditoria.daccess.roe.negocio.ObjetoROE;
import com.deceval.auditoria.dto.EstructuraTablaDTO;
import com.deceval.auditoria.exception.DAOException;
import com.deceval.auditoria.util.constants.Constants;
import com.deceval.auditoria.util.properties.PropertiesLoader;
import com.deceval.auditoria.vo.ObjetoAtributoVO;
import com.deceval.auditoria.vo.ObjetoVO;

public class OracleObjetoROE  extends OracleBaseROE  implements ObjetoROE{
	
	private final static String CLASS_NAME = "OracleOperacionROE";
	
	private final static String TABLA_OBJETO = "AUD_OBJETO";
	private final static String TABLA_OBJETOATRIBUTO = "AUD_OBJETOATRIBUTO";
	
	//Campos tabla AUD_OBJETO
	private final static String CAMPO_OBJETO_IDOBJETO = "IDOBJETO";
	private final static String CAMPO_OBJETO_IDAPLICACION = "IDAPLICACION";
	private final static String CAMPO_OBJETO_NOMBRETABLA = "NOMBRETABLA";
	private final static String CAMPO_OBJETO_TITULOTABLA = "TITULOTABLA";
	private final static String CAMPO_OBJETO_ESELIMINADO = "ESELIMINADO";
	
	//Campos tabla AUD_OBJETOATRIBUTO
	private final static String CAMPO_OBJETOATRIBUTO_IDATRIBUTO = "IDATRIBUTO";
	private final static String CAMPO_OBJETOATRIBUTO_IDOBJETO = "IDOBJETO";
	private final static String CAMPO_OBJETOATRIBUTO_NOMBRECAMPO = "NOMBRECAMPO";
	private final static String CAMPO_OBJETOATRIBUTO_IDTIPO = "IDTIPO";
	private final static String CAMPO_OBJETOATRIBUTO_ORDENCAMPO = "ORDENCAMPO";
	private final static String CAMPO_OBJETOATRIBUTO_ESELIMINADO = "ESELIMINADO";
	
	private final static String FIND_ESTRUCTURA_TABLA_BY_IDAPLICACION_AND_NOMBRETABLA = 
		" SELECT OB." + CAMPO_OBJETO_IDOBJETO + ", OB." + CAMPO_OBJETO_IDAPLICACION + ", OB." + CAMPO_OBJETO_NOMBRETABLA + 
		" , OB." + CAMPO_OBJETO_TITULOTABLA + ", OA." + CAMPO_OBJETOATRIBUTO_IDATRIBUTO + ", OA." + CAMPO_OBJETOATRIBUTO_NOMBRECAMPO + 
		" , OA." + CAMPO_OBJETOATRIBUTO_IDTIPO + ", OA." + CAMPO_OBJETOATRIBUTO_ORDENCAMPO + 
		" FROM " + TABLA_OBJETO + " OB " +
		" INNER JOIN " + TABLA_OBJETOATRIBUTO + " OA ON (OB." + CAMPO_OBJETO_IDOBJETO + "=OA." + CAMPO_OBJETOATRIBUTO_IDOBJETO + ") " +
		" WHERE upper(OB." + CAMPO_OBJETO_NOMBRETABLA + ")=upper(?) AND OB." + CAMPO_OBJETO_IDAPLICACION + "=? " +
		" AND OB." + CAMPO_OBJETO_ESELIMINADO + "=? AND OA." + CAMPO_OBJETOATRIBUTO_ESELIMINADO + "=?" ;
	
	/**
	 * Contructor del ROE para la estructura de  una operacions
	 * @param connection Define la conexión a la base de datos
	 */
	public OracleObjetoROE(Connection connection){
		super.setConnection(connection);		
	}
	
	public EstructuraTablaDTO consultarEstructuraByIdAplicacionAndNombreTabla(EstructuraTablaDTO estructura) throws DAOException{
		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		try {
			if (this.getConnection() != null) {
				sentencia = this.getConnection().prepareStatement(FIND_ESTRUCTURA_TABLA_BY_IDAPLICACION_AND_NOMBRETABLA);
				sentencia.setString(1, estructura.getTabla().getNombreTabla());
				sentencia.setInt(2, estructura.getTabla().getIdAplicacion());
				Integer noEliminado = new Integer(PropertiesLoader.loadProperty(Constants.CONSTANTE_REGISTRO_NO_ELIMINADO));
				sentencia.setInt(3, noEliminado);
				sentencia.setInt(4, noEliminado);
				resultado = sentencia.executeQuery();
				if(resultado != null && resultado.next()){
					ObjetoVO tabla = new ObjetoVO();
					tabla.setIdAplicacion(resultado.getInt(CAMPO_OBJETO_IDAPLICACION));
					tabla.setIdObjeto(resultado.getInt(CAMPO_OBJETO_IDOBJETO));
					tabla.setNombreTabla(resultado.getString(CAMPO_OBJETO_NOMBRETABLA));
					tabla.setTituloTabla(resultado.getObject(CAMPO_OBJETO_TITULOTABLA)!=null?resultado.getString(CAMPO_OBJETO_TITULOTABLA):"");
					
					Collection<ObjetoAtributoVO> listaAtributos = new ArrayList<ObjetoAtributoVO>();
					ObjetoAtributoVO atributo = new ObjetoAtributoVO();
					atributo.setIdAtributo(resultado.getInt(CAMPO_OBJETOATRIBUTO_IDATRIBUTO));
					atributo.setIdObjeto(resultado.getInt(CAMPO_OBJETO_IDOBJETO));
					atributo.setIdTipo(resultado.getInt(CAMPO_OBJETOATRIBUTO_IDTIPO));
					atributo.setNombreCampo(resultado.getString(CAMPO_OBJETOATRIBUTO_NOMBRECAMPO));
					atributo.setOrdenCampo(resultado.getInt(CAMPO_OBJETOATRIBUTO_ORDENCAMPO));
					listaAtributos.add(atributo);
					
					while (resultado.next()){
						atributo = new ObjetoAtributoVO();
						atributo.setIdAtributo(resultado.getInt(CAMPO_OBJETOATRIBUTO_IDATRIBUTO));
						atributo.setIdObjeto(resultado.getInt(CAMPO_OBJETO_IDOBJETO));
						atributo.setIdTipo(resultado.getInt(CAMPO_OBJETOATRIBUTO_IDTIPO));
						atributo.setNombreCampo(resultado.getString(CAMPO_OBJETOATRIBUTO_NOMBRECAMPO));
						atributo.setOrdenCampo(resultado.getInt(CAMPO_OBJETOATRIBUTO_ORDENCAMPO));
						listaAtributos.add(atributo);
					}
					estructura.setTabla(tabla);
					estructura.setAtributos(listaAtributos);
				}
			}
		} catch (SQLException e) {
			throw new DAOException("AUD-D-001", "Error en el metodo consultarEstructuraByIdAplicacionAndNombreTabla ("+ CLASS_NAME + ")", e);
		} catch (Exception e) {
			throw new DAOException("AUD-D-0002","Error en el metodo consultarEstructuraByIdAplicacionAndNombreTabla, excepcion inesperada("+ CLASS_NAME + ")", e);
		} finally {
			this.closeResources(resultado, sentencia);
		}
		return estructura;
	}

}
