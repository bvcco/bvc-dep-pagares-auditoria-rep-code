package com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.detalleresultadoconsulta;

import java.util.Collection;
import java.util.Iterator;

import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.detalleresultadoconsulta.tabladeldetalle.Tabla;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.parametrosconsulta.ParametrosConsulta;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.resultadosconsulta.FilaResultadosConsulta;

public class DetalleResultadoConsulta {
	private FilaResultadosConsulta 	filaResultadosConsulta;
	private ParametrosConsulta 		parametrosConsulta;
	private Collection<Tabla>		tablas;
	/**
	 * @return the filaResultadosConsulta
	 */
	public FilaResultadosConsulta getFilaResultadosConsulta() {
		return filaResultadosConsulta;
	}
	/**
	 * @param filaResultadosConsulta the filaResultadosConsulta to set
	 */
	public void setFilaResultadosConsulta(
			FilaResultadosConsulta filaResultadosConsulta) {
		this.filaResultadosConsulta = filaResultadosConsulta;
	}
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
	 * @return the tablas
	 */
	public Collection<Tabla> getTablas() {
		if(tablas != null) {
			for (Iterator<Tabla> iterator = tablas.iterator(); iterator.hasNext();) {
				Tabla tabla = iterator.next();
				if(parametrosConsulta != null) {
					tabla.setIdTipoFiltro(parametrosConsulta.getIdTipoFiltro());
				}				
			}
		}
		return tablas;
	}
	/**
	 * @param tablas the tablas to set
	 */
	public void setTablas(Collection<Tabla> tablas) {
		this.tablas = tablas;
	}
	
}
