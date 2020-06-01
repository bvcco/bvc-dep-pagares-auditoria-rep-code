/*
 * AccionVO
 * Date 04/09/2008
 * Copyright (c) 2008
 * Company: Deceval S.A
 * All Rights Reserved.
 * This software is the confidential and proprietary information of Deceval S.A.
 */

package com.deceval.auditoria.vo;

import com.deceval.auditoria.BaseDataVO;


/**
 * Clase que representa a la tabla AUD_ACCION
 * @version 1.0
 * @author ffonsacos
 */
public class AccionVO extends BaseDataVO{
	
	private static final long serialVersionUID = 1L;
	
	/*INICIO Auditoria de Tabla*/
	public String getNombreTablaVO() {
		return "AUD_ACCION";
	}
	/*FIN Auditoria de Tabla*/
		
	private Integer idAccion;
	private String nombreAccion;
	
	
	public Integer getIdAccion() {
		return idAccion;
	}
	public void setIdAccion(Integer idAccion) {
		this.idAccion = idAccion;
	}
	public String getNombreAccion() {
		return nombreAccion;
	}
	public void setNombreAccion(String nombreAccion) {
		this.nombreAccion = nombreAccion;
	}

}
