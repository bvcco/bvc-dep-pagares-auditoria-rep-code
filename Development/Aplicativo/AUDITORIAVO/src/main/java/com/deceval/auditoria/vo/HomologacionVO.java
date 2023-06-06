/*
 * HomologacionVO
 * Date 11/12/2008
 * Copyright (c) 2008
 * Company: Deceval S.A
 * All Rights Reserved.
 * This software is the confidential and proprietary information of Deceval S.A.
 */
package com.deceval.auditoria.vo;

import com.deceval.auditoria.BaseDataVO;

/**
 * Clase que representa a la tabla AUD_HOMOLOGACION
 * @version 1.0
 * @author gmarroquin
 */
public class HomologacionVO extends BaseDataVO{
	
	private static final long serialVersionUID = 1L;

	/*INICIO Auditoria de Tabla*/
	public String getNombreTablaVO() {
		return "AUD_HOMOLOGACION";
	}
	/*FIN Auditoria de Tabla*/
	
	private Long idHomologacion;
	private Integer idTablaAuditoria;	
	private Integer valorAuditoria;
	private Integer valorExterno;	
	private Integer idTablaReferencia;

	/**
	 * @return the idHomologacion
	 */
	public Long getIdHomologacion() {
		return idHomologacion;
	}
	/**
	 * @param idHomologacion the idHomologacion to set
	 */
	public void setIdHomologacion(Long idHomologacion) {
		this.idHomologacion = idHomologacion;
	}
	/**
	 * @return the idTablaAuditoria
	 */
	public Integer getIdTablaAuditoria() {
		return idTablaAuditoria;
	}
	/**
	 * @param idTablaAuditoria the idTablaAuditoria to set
	 */
	public void setIdTablaAuditoria(Integer idTablaAuditoria) {
		this.idTablaAuditoria = idTablaAuditoria;
	}
	/**
	 * @return the valorAuditoria
	 */
	public Integer getValorAuditoria() {
		return valorAuditoria;
	}
	/**
	 * @param valorAuditoria the valorAuditoria to set
	 */
	public void setValorAuditoria(Integer valorAuditoria) {
		this.valorAuditoria = valorAuditoria;
	}
	/**
	 * @return the valorExterno
	 */
	public Integer getValorExterno() {
		return valorExterno;
	}
	/**
	 * @param valorExterno the valorExterno to set
	 */
	public void setValorExterno(Integer valorExterno) {
		this.valorExterno = valorExterno;
	}
	/**
	 * @return the idTablaReferencia
	 */
	public Integer getIdTablaReferencia() {
		return idTablaReferencia;
	}
	/**
	 * @param idTablaReferencia the idTablaReferencia to set
	 */
	public void setIdTablaReferencia(Integer idTablaReferencia) {
		this.idTablaReferencia = idTablaReferencia;
	}

	
}
