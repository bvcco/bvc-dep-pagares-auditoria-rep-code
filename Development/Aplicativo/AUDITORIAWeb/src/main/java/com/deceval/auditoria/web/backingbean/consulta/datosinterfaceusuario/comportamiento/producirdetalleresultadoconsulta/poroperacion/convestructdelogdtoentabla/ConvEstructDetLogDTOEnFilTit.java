package com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.comportamiento.producirdetalleresultadoconsulta.poroperacion.convestructdelogdtoentabla;

import java.util.ArrayList;
import java.util.Iterator;

import com.deceval.auditoria.dto.EstructuraDetalleDetalleLogDTO;
import com.deceval.auditoria.dto.EstructuraDetalleLogDTO;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.detalleresultadoconsulta.tabladeldetalle.Casilla;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.detalleresultadoconsulta.tabladeldetalle.Fila;

public class ConvEstructDetLogDTOEnFilTit {
	private EstructuraDetalleLogDTO entrada;
	private Fila		 			salida;
	
	public void convertir() {
		salida = new Fila();
		ArrayList<Casilla> casillas = new ArrayList<Casilla>();
		
		ConvObjAtribVOEnCasilla convObjAtribVOEnCasilla = new ConvObjAtribVOEnCasilla();
		
		for (Iterator<EstructuraDetalleDetalleLogDTO> iterator = entrada.getDetalle().iterator(); iterator.hasNext();) {
			EstructuraDetalleDetalleLogDTO estructuraDetalleDetalleLogDTO = 
				(EstructuraDetalleDetalleLogDTO) iterator.next();
			
			convObjAtribVOEnCasilla.setEntrada(estructuraDetalleDetalleLogDTO.getObjetoAtributoVO());
			convObjAtribVOEnCasilla.convertir();
			
			casillas.add(convObjAtribVOEnCasilla.getSalida());
		}
		
		salida.setCasillas(casillas);
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
	public Fila getSalida() {
		return salida;
	}

	/**
	 * @param salida the salida to set
	 */
	public void setSalida(Fila salida) {
		this.salida = salida;
	}

}
