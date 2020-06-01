package com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.comportamiento.producirdetalleresultadoconsulta.pororigen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import com.deceval.auditoria.dto.EstructuraDetalleLogDTO;
import com.deceval.auditoria.exception.LogicException;
import com.deceval.auditoria.integration.NegocioDelegate;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.comportamiento.producirdetalleresultadoconsulta.pororigen.convestructdelogdtoentabla.ConvEstructDetLogDTOEnTablaOrigen;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.comportamiento.producirresultadosconsulta.ConvParamConsultaEnEstrucConsDTO;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.detalleresultadoconsulta.DetalleResultadoConsulta;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.detalleresultadoconsulta.tabladeldetalle.Tabla;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.parametrosconsulta.ParametrosConsulta;

public class ProducirDetalleResultadoConsultaOrigen {
	private ParametrosConsulta 			entrada;
	private DetalleResultadoConsulta 	salida;
	
	public void producir() throws LogicException {
		salida = new DetalleResultadoConsulta();
		salida.setParametrosConsulta(entrada);
		
		ArrayList<Tabla> tablas = new ArrayList<Tabla>();		
		
		NegocioDelegate negocioDelegate = new NegocioDelegate();
		
		ConvParamConsultaEnEstrucConsDTO convParamConsultaEnEstrucConsDTO = new ConvParamConsultaEnEstrucConsDTO();
		convParamConsultaEnEstrucConsDTO.setEntrada(entrada);
		convParamConsultaEnEstrucConsDTO.convertir();
		
		Collection<EstructuraDetalleLogDTO> coleccionEstructuraDetalleLogDTO = 
			negocioDelegate.obtenerListaDetalleLogsByEstructuraConsultaDTO(
					convParamConsultaEnEstrucConsDTO.getSalida());
		
		ConvEstructDetLogDTOEnTablaOrigen convEstructDetLogDTOEnTabla = new ConvEstructDetLogDTOEnTablaOrigen();
		
		for (Iterator<EstructuraDetalleLogDTO> iterator = coleccionEstructuraDetalleLogDTO.iterator(); iterator.hasNext();) {
			EstructuraDetalleLogDTO estructuraDetalleLogDTO = (EstructuraDetalleLogDTO) iterator.next();
			convEstructDetLogDTOEnTabla.setEntrada(estructuraDetalleLogDTO);
			convEstructDetLogDTOEnTabla.convertir();
			tablas.add(convEstructDetLogDTOEnTabla.getSalida());
		}

		salida.setTablas(tablas);
	}

	/**
	 * @return the entrada
	 */
	public ParametrosConsulta getEntrada() {
		return entrada;
	}

	/**
	 * @param entrada the entrada to set
	 */
	public void setEntrada(ParametrosConsulta entrada) {
		this.entrada = entrada;
	}

	/**
	 * @return the salida
	 */
	public DetalleResultadoConsulta getSalida() {
		return salida;
	}

	/**
	 * @param salida the salida to set
	 */
	public void setSalida(DetalleResultadoConsulta salida) {
		this.salida = salida;
	}
}
