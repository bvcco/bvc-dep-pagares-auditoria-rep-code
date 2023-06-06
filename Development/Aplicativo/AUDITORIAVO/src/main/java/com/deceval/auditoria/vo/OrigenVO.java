/*
 * OrigenVO
 * Date 04/09/2008
 * Copyright (c) 2008
 * Company: Deceval S.A
 * All Rights Reserved.
 * This software is the confidential and proprietary information of Deceval S.A.
 */

package com.deceval.auditoria.vo;

import com.deceval.auditoria.BaseDataVO;

/**
 * Clase que representa a la tabla AUD_ORIGEN
 * @version 1.0
 * @author ffonsacos
 */
public class OrigenVO extends BaseDataVO{
	
	private static final long serialVersionUID = 1L;
	
	private Integer idOrigen;
	private Integer idAplicacion;
	private String descripcionOrigen;
	private String constanteReferencia;
	
	public String getConstanteReferencia() {
		return constanteReferencia;
	}

	public void setConstanteReferencia(String constanteReferencia) {
		this.constanteReferencia = constanteReferencia;
	}

	/*INICIO Auditoria de Tabla*/
	public String getNombreTablaVO() {
		return "AUD_ORIGEN";
	}
	/*FIN Auditoria de Tabla*/
	
	public Integer getIdOrigen() {
		return idOrigen;
	}
	public void setIdOrigen(Integer idOrigen) {
		this.idOrigen = idOrigen;
	}
	public Integer getIdAplicacion() {
		return idAplicacion;
	}
	public void setIdAplicacion(Integer idAplicacion) {
		this.idAplicacion = idAplicacion;
	}
	public String getDescripcionOrigen() {
		return descripcionOrigen;
	}
	public void setDescripcionOrigen(String descripcionOrigen) {
		this.descripcionOrigen = descripcionOrigen;
	}

}
