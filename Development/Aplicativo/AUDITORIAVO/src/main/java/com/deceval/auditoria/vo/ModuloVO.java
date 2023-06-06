/*
 * ModuloVO
 * Date 04/09/2008
 * Copyright (c) 2008
 * Company: Deceval S.A
 * All Rights Reserved.
 * This software is the confidential and proprietary information of Deceval S.A.
 */

package com.deceval.auditoria.vo;

import com.deceval.auditoria.BaseDataVO;

/**
 * Clase que representa a la tabla AUD_MODULO
 * @version 1.0
 * @author ffonsacos
 */
public class ModuloVO extends BaseDataVO{
	
	private static final long serialVersionUID = 1L;
	
	/*INICIO Auditoria de Tabla*/
	public String getNombreTablaVO() {
		return "AUD_MODULO";
	}
	/*FIN Auditoria de Tabla*/
	
	private Integer idModulo;
	private Integer idAplicacion;
	private String nombreModulo;
	
	
	public Integer getIdModulo() {
		return idModulo;
	}
	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}
	public Integer getIdAplicacion() {
		return idAplicacion;
	}
	public void setIdAplicacion(Integer idAplicacion) {
		this.idAplicacion = idAplicacion;
	}
	public String getNombreModulo() {
		return nombreModulo;
	}
	public void setNombreModulo(String nombreModulo) {
		this.nombreModulo = nombreModulo;
	}

}
