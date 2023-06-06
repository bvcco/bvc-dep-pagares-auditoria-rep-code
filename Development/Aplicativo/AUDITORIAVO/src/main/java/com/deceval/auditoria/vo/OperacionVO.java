/*
 * OperacionVO
 * Date 04/09/2008
 * Copyright (c) 2008
 * Company: Deceval S.A
 * All Rights Reserved.
 * This software is the confidential and proprietary information of Deceval S.A.
 */

package com.deceval.auditoria.vo;

import com.deceval.auditoria.BaseDataVO;

/**
 * Clase que representa a la tabla AUD_OPERACION
 * @version 1.0
 * @author ffonsacos
 */
public class OperacionVO extends BaseDataVO{
	
	private static final long serialVersionUID = 1L;
	
	private Integer idOperacion;
	private Integer idModulo;
	private Integer idAccion;
	private String descripcionOperacion;
	private String constanteReferencia;
	
	public String getConstanteReferencia() {
		return constanteReferencia;
	}

	public void setConstanteReferencia(String constanteReferencia) {
		this.constanteReferencia = constanteReferencia;
	}

	/*INICIO Auditoria de Tabla*/
	public String getNombreTablaVO() {
		return "AUD_OPERACION";
	}
	/*FIN Auditoria de Tabla*/
	
	public Integer getIdOperacion() {
		return idOperacion;
	}
	public void setIdOperacion(Integer idOperacion) {
		this.idOperacion = idOperacion;
	}
	public Integer getIdModulo() {
		return idModulo;
	}
	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}
	public Integer getIdAccion() {
		return idAccion;
	}
	public void setIdAccion(Integer idAccion) {
		this.idAccion = idAccion;
	}
	public String getDescripcionOperacion() {
		return descripcionOperacion;
	}
	public void setDescripcionOperacion(String descripcionOperacion) {
		this.descripcionOperacion = descripcionOperacion;
	}

}
