package com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.detalleresultadoconsulta.tabladeldetalle;

import java.util.Collection;

public class Fila {
	private Collection<Casilla> casillas;
	private Long numFila;

	/**
	 * @return the numFila
	 */
	public Long getNumFila() {
		return numFila;
	}

	/**
	 * @param numFila the numFila to set
	 */
	public void setNumFila(Long numFila) {
		this.numFila = numFila;
	}

	/**
	 * @return the casillas
	 */
	public Collection<Casilla> getCasillas() {
		return casillas;
	}

	/**
	 * @param casillas the casillas to set
	 */
	public void setCasillas(Collection<Casilla> casillas) {
		this.casillas = casillas;
	}
}
