package com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.comportamiento.producirdetalleresultadoconsulta.pororigen.convestructdelogdtoentabla;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import com.deceval.auditoria.dto.EstructuraDetalleLogDTO;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.detalleresultadoconsulta.tabladeldetalle.Fila;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.detalleresultadoconsulta.tabladeldetalle.Tabla;

public class ConvEstructDetLogDTOEnTablaOrigen {
	private EstructuraDetalleLogDTO entrada;
	private Tabla 					salida;
	
	public void convertir() {
		salida = new Tabla();
		
		String tituloTabla;
		tituloTabla = entrada.getObjetoVO().getTituloTabla();
		salida.setTituloTabla(tituloTabla);
		
		EstructuraDetalleLogDTO entradaOrdenada;
		OrdenarEstructDetLogDTOOrigen ordenarEstructDetLogDTO = new OrdenarEstructDetLogDTOOrigen();
		ordenarEstructDetLogDTO.setEntrada(entrada);
		ordenarEstructDetLogDTO.ordenar();
		
		entradaOrdenada = ordenarEstructDetLogDTO.getSalida();
		
		ConvEstructDetLogDTOEnFilTitOrigen convEstructDetLogDTOEnFilTit = 
			new ConvEstructDetLogDTOEnFilTitOrigen();
		convEstructDetLogDTOEnFilTit.setEntrada(entradaOrdenada);
		convEstructDetLogDTOEnFilTit.convertir();
		
		salida.setTitulos(convEstructDetLogDTOEnFilTit.getSalida());
				
		ArrayList<Fila> filas = new ArrayList<Fila>();
		
		ObtenerTrazasOrigen obtenerTrazas = new ObtenerTrazasOrigen();
		Set<Long> trazas = obtenerTrazas.trazas(entradaOrdenada);
		ConvEstructDetLogDTOEnFilaOrigen convEstructDetLogDTOEnFila = new ConvEstructDetLogDTOEnFilaOrigen();
		for (Iterator<Long> iterator = trazas.iterator(); iterator.hasNext();) {
			Long traza = (Long) iterator.next();			
			convEstructDetLogDTOEnFila.setEntrada(entradaOrdenada);
			convEstructDetLogDTOEnFila.convertir(traza);
			filas.add(convEstructDetLogDTOEnFila.getSalida());
		}
		
		Collections.sort(filas, new FilaComparator());
		salida.setFilas(filas);
	}

	/**
	 * @return the entrada
	 */
	public EstructuraDetalleLogDTO getEntrada() {
		return entrada;
	}

	/**
	 * @param entrada the entrada to set
	 */
	public void setEntrada(EstructuraDetalleLogDTO entrada) {
		this.entrada = entrada;
	}

	/**
	 * @return the salida
	 */
	public Tabla getSalida() {
		return salida;
	}

	/**
	 * @param salida the salida to set
	 */
	public void setSalida(Tabla salida) {
		this.salida = salida;
	}
	
	class FilaComparator implements Comparator<Fila> {

		  public int compare(Fila o1, Fila o2) {		  			 
			  return o1.getNumFila().compareTo(o2.getNumFila());
		  }

		  public boolean equals(Object o) {
			  return this == o;
		  }
	}
}
