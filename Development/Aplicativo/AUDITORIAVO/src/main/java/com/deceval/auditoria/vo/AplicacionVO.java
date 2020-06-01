/*
 * AplicacionVO
 * Date 04/09/2008
 * Copyright (c) 2008
 * Company: Deceval S.A
 * All Rights Reserved.
 * This software is the confidential and proprietary information of Deceval S.A.
 */
package com.deceval.auditoria.vo;

import com.deceval.auditoria.BaseDataVO;

/**
 * Clase que representa a la tabla AUD_APLICACION
 * @version 1.0
 * @author ffonsacos
 */
public class AplicacionVO extends BaseDataVO{
	
	private static final long serialVersionUID = 1L;
	
	/*INICIO Auditoria de Tabla*/
	public String getNombreTablaVO() {
		return "AUD_APLICACION";
	}
	/*FIN Auditoria de Tabla*/
	
	private Integer idAplicacion;
	private String nombreAplicacion;
	public Integer getIdAplicacion() {
		return idAplicacion;
	}
	public void setIdAplicacion(Integer idAplicacion) {
		this.idAplicacion = idAplicacion;
	}
	public String getNombreAplicacion() {
		return nombreAplicacion;
	}
	public void setNombreAplicacion(String nombreAplicacion) {
		this.nombreAplicacion = nombreAplicacion;
	}
}
