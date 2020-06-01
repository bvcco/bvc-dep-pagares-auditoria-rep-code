package com.deceval.auditoria.web.userinfo;

import java.math.BigDecimal;
import java.util.Calendar;

public class UserInfo {
	private String nombre;
	private String apellido;
	private String login;
	private Calendar fechaUltimoIngreso;
	private String codigoDepositante;
	private String nombreDepositante;
	private BigDecimal tipoEntidad;
	
	public UserInfo(){
		nombre=" Fredy Eduardo ";
		apellido=" Fonseca Acosta ";
		login="deceSSprueba4";
		fechaUltimoIngreso=Calendar.getInstance();
		codigoDepositante="131";
		nombreDepositante="FIDUCIARIA BANISTMO S.A.";
		tipoEntidad=new BigDecimal(1);
	}
	
	public String getNombreDepositante() {
		return nombreDepositante;
	}
	public void setNombreDepositante(String nombreDepositante) {
		this.nombreDepositante = nombreDepositante;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Calendar getFechaUltimoIngreso() {
		return fechaUltimoIngreso;
	}
	public void setFechaUltimoIngreso(Calendar fechaUltimoIngreso) {
		this.fechaUltimoIngreso = fechaUltimoIngreso;
	}
	public String getCodigoDepositante() {
		return codigoDepositante;
	}
	public void setCodigoDepositante(String codigoDepositante) {
		this.codigoDepositante = codigoDepositante;
	}
	
	public Calendar getFechaActual(){
		return Calendar.getInstance();
	}

	public BigDecimal getTipoEntidad() {
		return tipoEntidad;
	}

	public void setTipoEntidad(BigDecimal tipoEntidad) {
		this.tipoEntidad = tipoEntidad;
	}

}
