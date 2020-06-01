package com.deceval.auditoria.vo;

import com.deceval.auditoria.BaseDataVO;

public class ObjetoAtributoVO extends BaseDataVO{
	
	private static final long serialVersionUID = 1L;
	
	private Integer idAtributo;
	private Integer idObjeto;
	private String nombreCampo;
	private Integer idTipo;
	private Integer ordenCampo;
	
	/*INICIO Auditoria de Tabla*/
	public String getNombreTablaVO() {
		return "AUD_OBJETOATRIBUTO";
	}
	/*FIN Auditoria de Tabla*/
	
	public Integer getIdAtributo() {
		return idAtributo;
	}
	public void setIdAtributo(Integer idAtributo) {
		this.idAtributo = idAtributo;
	}
	public Integer getIdObjeto() {
		return idObjeto;
	}
	public void setIdObjeto(Integer idObjeto) {
		this.idObjeto = idObjeto;
	}
	public String getNombreCampo() {
		return nombreCampo;
	}
	public void setNombreCampo(String nombreCampo) {
		this.nombreCampo = nombreCampo;
	}
	public Integer getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}
	public Integer getOrdenCampo() {
		return ordenCampo;
	}
	public void setOrdenCampo(Integer ordenCampo) {
		this.ordenCampo = ordenCampo;
	}
	
	

}
