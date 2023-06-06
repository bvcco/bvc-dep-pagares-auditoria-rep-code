package com.deceval.auditoria.vo;

import com.deceval.auditoria.BaseDataVO;

public class LogHistorialVO extends BaseDataVO{
	
	private static final long serialVersionUID = 1L;
	
	/*INICIO Auditoria de Tabla*/
	public String getNombreTablaVO() {
		return "AUD_LOGHISTORIAL";
	}
	/*FIN Auditoria de Tabla*/
	
	private Long idHistorial;
	private Long idTraza;
	private Integer idAtributo;
	private String valorAtributo;
	
	//Datos no pertenecientes a la tabla utilizados para logica del negocio
	private String nombreCampo;
	
	
	public Long getIdHistorial() {
		return idHistorial;
	}
	public void setIdHistorial(Long idHistorial) {
		this.idHistorial = idHistorial;
	}
	public Long getIdTraza() {
		return idTraza;
	}
	public void setIdTraza(Long idTraza) {
		this.idTraza = idTraza;
	}
	public String getValorAtributo() {
		return valorAtributo;
	}
	public void setValorAtributo(String valorAtributo) {
		this.valorAtributo = valorAtributo;
	}
	public String getNombreCampo() {
		return nombreCampo;
	}
	public void setNombreCampo(String nombreCampo) {
		this.nombreCampo = nombreCampo;
	}
	public Integer getIdAtributo() {
		return idAtributo;
	}
	public void setIdAtributo(Integer idAtributo) {
		this.idAtributo = idAtributo;
	}
	

}
