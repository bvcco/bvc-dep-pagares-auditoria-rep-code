package com.deceval.auditoria.vo;

import com.deceval.auditoria.BaseDataVO;

public class ObjetoVO extends BaseDataVO{
	
	private static final long serialVersionUID = 1L;
	
	private Integer idObjeto;
	private Integer idAplicacion;
	private String nombreTabla;
	private String tituloTabla;
	
	/*INICIO Auditoria de Tabla*/
	public String getNombreTablaVO() {
		return "AUD_OBJETO";
	}
	/*FIN Auditoria de Tabla*/
	
	public Integer getIdObjeto() {
		return idObjeto;
	}
	public void setIdObjeto(Integer idObjeto) {
		this.idObjeto = idObjeto;
	}
	public Integer getIdAplicacion() {
		return idAplicacion;
	}
	public void setIdAplicacion(Integer idAplicacion) {
		this.idAplicacion = idAplicacion;
	}
	public String getNombreTabla() {
		return nombreTabla;
	}
	public void setNombreTabla(String nombreTabla) {
		this.nombreTabla = nombreTabla;
	}
	public String getTituloTabla() {
		return tituloTabla;
	}
	public void setTituloTabla(String tituloTabla) {
		this.tituloTabla = tituloTabla;
	}
	
	

}
