package com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.comportamiento.producirdetalleresultadoconsulta.pororigen.convestructdelogdtoentabla;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import com.deceval.auditoria.dto.EstructuraDetalleDetalleLogDTO;
import com.deceval.auditoria.dto.EstructuraDetalleLogDTO;

public class OrdenarEstructDetLogDTOOrigen {
	private EstructuraDetalleLogDTO entrada;
	private EstructuraDetalleLogDTO salida;
	
	public void ordenar() {
		salida = new EstructuraDetalleLogDTO();
		salida.setObjetoVO(entrada.getObjetoVO());
		
		Collection<EstructuraDetalleDetalleLogDTO> detalleEntrada;
		detalleEntrada = entrada.getDetalle();
		
		ArrayList<EstructuraDetalleDetalleLogDTO> detalleSalida = 
			new ArrayList<EstructuraDetalleDetalleLogDTO>();	
		
		for (Iterator<EstructuraDetalleDetalleLogDTO> iterator = detalleEntrada.iterator(); iterator.hasNext();) {
			EstructuraDetalleDetalleLogDTO estructuraDetalleDetalleLogDTO = 
				(EstructuraDetalleDetalleLogDTO) iterator.next();
			detalleSalida.add(estructuraDetalleDetalleLogDTO);
		}
		
		Collections.sort(detalleSalida, new EstructuraDetalleDetalleLogDTOComparator());
		salida.setDetalle(detalleSalida);
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
	public EstructuraDetalleLogDTO getSalida() {
		return salida;
	}

	/**
	 * @param salida the salida to set
	 */
	public void setSalida(EstructuraDetalleLogDTO salida) {
		this.salida = salida;
	}
	
	class EstructuraDetalleDetalleLogDTOComparator implements Comparator<EstructuraDetalleDetalleLogDTO> {

		  public int compare(EstructuraDetalleDetalleLogDTO o1, EstructuraDetalleDetalleLogDTO o2) {		  			 
			  return o1.getObjetoAtributoVO().getOrdenCampo().intValue() - 
			   		 o2.getObjetoAtributoVO().getOrdenCampo().intValue();
		  }

		  public boolean equals(Object o) {
			  return this == o;
		  }
	}	
}
