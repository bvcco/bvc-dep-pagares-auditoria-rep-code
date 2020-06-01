package com.deceval.auditoria.dto;

import java.util.Calendar;

import com.deceval.auditoria.BaseDataDTO;

public class EstructuraConsultaDTO implements BaseDataDTO {

	private static final long serialVersionUID = 1L;
	
	private Integer 	idAplicacion;
	private Integer		idModulo;
	private Integer 	idOperacion;
	private Integer 	idOrigen;	
	private String 		codigoOrigen;
	private String 		userName;
	private Calendar 	fechaInicial;
	private Calendar 	fechaFinal;
	/**
	 * @return the idAplicacion
	 */
	public Integer getIdAplicacion() {
		return idAplicacion;
	}
	/**
	 * @param idAplicacion the idAplicacion to set
	 */
	public void setIdAplicacion(Integer idAplicacion) {
		this.idAplicacion = idAplicacion;
	}
	/**
	 * @return the idModulo
	 */
	public Integer getIdModulo() {
		return idModulo;
	}
	/**
	 * @param idModulo the idModulo to set
	 */
	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}
	/**
	 * @return the idOperacion
	 */
	public Integer getIdOperacion() {
		return idOperacion;
	}
	/**
	 * @param idOperacion the idOperacion to set
	 */
	public void setIdOperacion(Integer idOperacion) {
		this.idOperacion = idOperacion;
	}
	/**
	 * @return the idOrigen
	 */
	public Integer getIdOrigen() {
		return idOrigen;
	}
	/**
	 * @param idOrigen the idOrigen to set
	 */
	public void setIdOrigen(Integer idOrigen) {
		this.idOrigen = idOrigen;
	}
	/**
	 * @return the codigoOrigen
	 */
	public String getCodigoOrigen() {
		return codigoOrigen;
	}
	/**
	 * @param codigoOrigen the codigoOrigen to set
	 */
	public void setCodigoOrigen(String codigoOrigen) {
		this.codigoOrigen = codigoOrigen;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the fechaInicial
	 */
	public Calendar getFechaInicial() {
		return fechaInicial;
	}
	/**
	 * @param fechaInicial the fechaInicial to set
	 */
	public void setFechaInicial(Calendar fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	/**
	 * @return the fechaFinal
	 */
	public Calendar getFechaFinal() {
		return fechaFinal;
	}
	/**
	 * @param fechaFinal the fechaFinal to set
	 */
	public void setFechaFinal(Calendar fechaFinal) {
		this.fechaFinal = fechaFinal;
	}	
}
