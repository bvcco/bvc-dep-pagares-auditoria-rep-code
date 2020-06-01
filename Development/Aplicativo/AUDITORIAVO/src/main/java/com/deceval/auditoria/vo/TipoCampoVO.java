package com.deceval.auditoria.vo;

import com.deceval.auditoria.BaseDataVO;

public class TipoCampoVO  extends BaseDataVO{
	
	private static final long serialVersionUID = 1L;
	
	private Integer idTipo;
	private String nombreTipo;
	
	/*INICIO Auditoria de Tabla*/
	public String getNombreTablaVO() {
		return "AUD_TIPOCAMPO";
	}
	/*FIN Auditoria de Tabla*/
	
	public Integer getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}
	public String getNombreTipo() {
		return nombreTipo;
	}
	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

}
