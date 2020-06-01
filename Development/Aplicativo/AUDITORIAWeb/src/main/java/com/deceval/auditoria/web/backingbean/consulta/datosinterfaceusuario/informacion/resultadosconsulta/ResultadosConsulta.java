package com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.resultadosconsulta;

import java.util.Collection;

import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.parametrosconsulta.ParametrosConsulta;

public class ResultadosConsulta {
	private ParametrosConsulta 					parametrosConsulta;
	private String 								titulo;
	private Collection<FilaResultadosConsulta> 	filasResultadosConsulta;
	/**
	 * @return the parametrosConsulta
	 */
	public ParametrosConsulta getParametrosConsulta() {
		return parametrosConsulta;
	}
	/**
	 * @param parametrosConsulta the parametrosConsulta to set
	 */
	public void setParametrosConsulta(ParametrosConsulta parametrosConsulta) {
		this.parametrosConsulta = parametrosConsulta;
	}
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the filasResultadosConsulta
	 */
	public Collection<FilaResultadosConsulta> getFilasResultadosConsulta() {
		return filasResultadosConsulta;
	}
	/**
	 * @param filasResultadosConsulta the filasResultadosConsulta to set
	 */
	public void setFilasResultadosConsulta(
			Collection<FilaResultadosConsulta> filasResultadosConsulta) {
		this.filasResultadosConsulta = filasResultadosConsulta;
	}
}
