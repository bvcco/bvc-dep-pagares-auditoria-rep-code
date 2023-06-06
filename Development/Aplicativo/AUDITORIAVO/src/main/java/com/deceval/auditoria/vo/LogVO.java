/*
 * LogVO
 * Date 04/09/2008
 * Copyright (c) 2008
 * Company: Deceval S.A
 * All Rights Reserved.
 * This software is the confidential and proprietary information of Deceval S.A.
 */
package com.deceval.auditoria.vo;

import java.util.Calendar;

import com.deceval.auditoria.BaseDataVO;

/**
 * Clase que representa a la tabla AUD_LOG
 * @version 1.0
 * @author ffonsacos
 */
public class LogVO extends BaseDataVO{
	
	private static final long serialVersionUID = 1L;
	
	/*INICIO Auditoria de Tabla*/
	public String getNombreTablaVO() {
		return "AUD_LOG";
	}
	/*FIN Auditoria de Tabla*/
	
	private Long idTraza;
	private Integer idOperacion;
	private Integer idOrigen;
	private String codigoOrigen;
	private Integer idUsuario; 
	private String userName;
	private Calendar fechaAnotacion;
	private String ipUsuario;
	private String ipServidor;
	private String descripcionAnotacion;
	
	public Long getIdTraza() {
		return idTraza;
	}
	public void setIdTraza(Long idTraza) {
		this.idTraza = idTraza;
	}
	public Integer getIdOperacion() {
		return idOperacion;
	}
	public void setIdOperacion(Integer idOperacion) {
		this.idOperacion = idOperacion;
	}
	public Integer getIdOrigen() {
		return idOrigen;
	}
	public void setIdOrigen(Integer idOrigen) {
		this.idOrigen = idOrigen;
	}
	public String getCodigoOrigen() {
		return codigoOrigen;
	}
	public void setCodigoOrigen(String codigoOrigen) {
		this.codigoOrigen = codigoOrigen;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Calendar getFechaAnotacion() {
		return fechaAnotacion;
	}
	public void setFechaAnotacion(Calendar fechaAnotacion) {
		this.fechaAnotacion = fechaAnotacion;
	}
	public String getIpUsuario() {
		return ipUsuario;
	}
	public void setIpUsuario(String ipUsuario) {
		this.ipUsuario = ipUsuario;
	}
	public String getIpServidor() {
		return ipServidor;
	}
	public void setIpServidor(String ipServidor) {
		this.ipServidor = ipServidor;
	}
	public String getDescripcionAnotacion() {
		return descripcionAnotacion;
	}
	public void setDescripcionAnotacion(String descripcionAnotacion) {
		this.descripcionAnotacion = descripcionAnotacion;
	}
	
}
