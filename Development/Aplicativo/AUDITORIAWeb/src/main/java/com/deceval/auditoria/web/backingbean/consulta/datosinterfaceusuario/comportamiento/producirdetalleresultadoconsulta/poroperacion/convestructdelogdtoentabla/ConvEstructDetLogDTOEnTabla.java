package com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.comportamiento.producirdetalleresultadoconsulta.poroperacion.convestructdelogdtoentabla;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import com.deceval.auditoria.dto.EstructuraDetalleLogDTO;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.detalleresultadoconsulta.tabladeldetalle.Fila;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.detalleresultadoconsulta.tabladeldetalle.Tabla;

public class ConvEstructDetLogDTOEnTabla {
	private EstructuraDetalleLogDTO entrada;
	private Tabla 					salida;
	
	public void convertir() {
		salida = new Tabla();
		
		String tituloTabla;
		tituloTabla = entrada.getObjetoVO().getTituloTabla();
		salida.setTituloTabla(tituloTabla);
		
		EstructuraDetalleLogDTO entradaOrdenada;
		OrdenarEstructDetLogDTO ordenarEstructDetLogDTO = new OrdenarEstructDetLogDTO();
		ordenarEstructDetLogDTO.setEntrada(entrada);
		ordenarEstructDetLogDTO.ordenar();
		
		entradaOrdenada = ordenarEstructDetLogDTO.getSalida();
		
		ConvEstructDetLogDTOEnFilTit convEstructDetLogDTOEnFilTit = 
			new ConvEstructDetLogDTOEnFilTit();
		convEstructDetLogDTOEnFilTit.setEntrada(entradaOrdenada);
		convEstructDetLogDTOEnFilTit.convertir();
		
		salida.setTitulos(convEstructDetLogDTOEnFilTit.getSalida());
				
		ArrayList<Fila> filas = new ArrayList<Fila>();
		
		ObtenerTrazas obtenerTrazas = new ObtenerTrazas();
		Set<Long> trazas = obtenerTrazas.trazas(entradaOrdenada);
		ConvEstructDetLogDTOEnFila convEstructDetLogDTOEnFila = new ConvEstructDetLogDTOEnFila();
		for (Iterator<Long> iterator = trazas.iterator(); iterator.hasNext();) {
			Long traza = (Long) iterator.next();			
			convEstructDetLogDTOEnFila.setEntrada(entradaOrdenada);
			convEstructDetLogDTOEnFila.convertir(traza);
			filas.add(convEstructDetLogDTOEnFila.getSalida());
		}
		
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
}
