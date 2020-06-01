package com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.detalleresultadoconsulta.tabladeldetalle;

public class Casilla {
	private String 	valor;
	private Boolean esValorEspecial;  //Ej: nulo, dato no guardado
	private Integer tipoDato;
	
	public Integer getTipoDato() {
		return tipoDato;
	}
	public void setTipoDato(Integer tipoDato) {
		this.tipoDato = tipoDato;
	}
	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
	/**
	 * @return the esValorEspecial
	 */
	public Boolean getEsValorEspecial() {
		return esValorEspecial;
	}
	/**
	 * @param esValorEspecial the esValorEspecial to set
	 */
	public void setEsValorEspecial(Boolean esValorEspecial) {
		this.esValorEspecial = esValorEspecial;
	}
	
	
}
