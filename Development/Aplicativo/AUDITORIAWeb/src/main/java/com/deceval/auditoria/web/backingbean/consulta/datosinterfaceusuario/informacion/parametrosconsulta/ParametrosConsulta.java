package com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.parametrosconsulta;

import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class ParametrosConsulta {
	private static String BUNDLEBASENAME 				= "com.deceval.auditoria.web.resources.messages.MessagesResources";
	private static String BUNDLEKEYFORMATOFECHA 		= "formato_fecha";	
	
	/*  Corresponde a lo que ha sido seleccionado en los combo box y controles */
	private Integer 		idAplicacion 				= new Integer(0);
	private Integer			idModulo 					= new Integer(0);
	private Integer 		idOperacion 				= new Integer(0);
	private Integer 		idOrigen 					= new Integer(0);	
	private String 			codigoOrigen 				= "";
	private String 			usuario 					= "";
	private java.util.Date 	fechaDesde 					= new java.util.Date();
	private java.util.Date 	fechaHasta 					= new java.util.Date();	
	
	private Integer			idTipoFiltro				= new Integer(0);  // 0 = Por operación, 1 = Por origen
	public static int 		TIPO_FILTRO_POR_OPERACION 	= 0;
	public static int 		TIPO_FILTRO_POR_ORIGEN 		= 1;

	/**
	 * @return the fechaDesdeFormateada
	 */
	public String getFechaDesdeFormateada() {
		ResourceBundle bundle 			= ResourceBundle.getBundle	(BUNDLEBASENAME);
		String formatoFecha 			= bundle.getString			(BUNDLEKEYFORMATOFECHA);		
		SimpleDateFormat formateador 	= new SimpleDateFormat		(formatoFecha);
		return formateador.format(fechaDesde);
	}	
	
	/**
	 * @return the fechaHastaFormateada
	 */
	public String getFechaHastaFormateada() {
		ResourceBundle bundle 			= ResourceBundle.getBundle	(BUNDLEBASENAME);
		String formatoFecha 			= bundle.getString			(BUNDLEKEYFORMATOFECHA);		
		SimpleDateFormat formateador 	= new SimpleDateFormat		(formatoFecha);
		return formateador.format(fechaHasta);
	}	
	
	/**
	 * @return the renderedOperacion
	 */
	public Boolean getRenderedOperacion() {
		if(idTipoFiltro.intValue() == TIPO_FILTRO_POR_OPERACION) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @return the renderedOrigen
	 */
	public Boolean getRenderedOrigen() {
		if(idTipoFiltro.intValue() == TIPO_FILTRO_POR_ORIGEN) {
			return true;
		} else {
			return false;
		}
	}	
	
	/**
	 * @return the idAplicacion
	 */
	public Integer getIdAplicacion() {
		return idAplicacion;
	}

	/**
	 * @param idAplicacion the idAplicacion to set
	 */
	public void setIdAplicacion(Integer idAplicacion) {
		this.idAplicacion = idAplicacion;
	}

	/**
	 * @return the idModulo
	 */
	public Integer getIdModulo() {
		return idModulo;
	}

	/**
	 * @param idModulo the idModulo to set
	 */
	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}

	/**
	 * @return the idOperacion
	 */
	public Integer getIdOperacion() {
		return idOperacion;
	}

	/**
	 * @param idOperacion the idOperacion to set
	 */
	public void setIdOperacion(Integer idOperacion) {
		this.idOperacion = idOperacion;
	}

	/**
	 * @return the idOrigen
	 */
	public Integer getIdOrigen() {
		return idOrigen;
	}

	/**
	 * @param idOrigen the idOrigen to set
	 */
	public void setIdOrigen(Integer idOrigen) {
		this.idOrigen = idOrigen;
	}

	/**
	 * @return the codigoOrigen
	 */
	public String getCodigoOrigen() {
		return codigoOrigen;
	}

	/**
	 * @param codigoOrigen the codigoOrigen to set
	 */
	public void setCodigoOrigen(String codigoOrigen) {
		this.codigoOrigen = codigoOrigen;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the fechaDesde
	 */
	public java.util.Date getFechaDesde() {
		return fechaDesde;
	}

	/**
	 * @param fechaDesde the fechaDesde to set
	 */
	public void setFechaDesde(java.util.Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	/**
	 * @return the fechHasta
	 */
	public java.util.Date getFechaHasta() {
		return fechaHasta;
	}

	/**
	 * @param fechHasta the fechHasta to set
	 */
	public void setFechaHasta(java.util.Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	/**
	 * @return the tipoFiltro
	 */
	public Integer getIdTipoFiltro() {
		return idTipoFiltro;
	}

	/**
	 * @param tipoFiltro the tipoFiltro to set
	 */
	public void setIdTipoFiltro(Integer idTipoFiltro) {
		this.idTipoFiltro = idTipoFiltro;
	}
	
	
}
