package com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.comportamiento.producirdetalleresultadoconsulta.poroperacion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import com.deceval.auditoria.dto.EstructuraDetalleLogDTO;
import com.deceval.auditoria.exception.LogicException;
import com.deceval.auditoria.integration.NegocioDelegate;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.comportamiento.producirdetalleresultadoconsulta.poroperacion.convestructdelogdtoentabla.ConvEstructDetLogDTOEnTabla;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.detalleresultadoconsulta.DetalleResultadoConsulta;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.detalleresultadoconsulta.tabladeldetalle.Tabla;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.resultadosconsulta.FilaResultadosConsulta;

public class ProducirDetalleResultadoConsulta {
	private FilaResultadosConsulta 		entrada;
	private DetalleResultadoConsulta 	salida;
	
	public void producir() throws LogicException {
		salida = new DetalleResultadoConsulta();
		salida.setFilaResultadosConsulta(entrada);
		
		ArrayList<Tabla> tablas = new ArrayList<Tabla>();		
		
		NegocioDelegate negocioDelegate = new NegocioDelegate();
		
		long longIdTraza = Long.parseLong(entrada.getTraza());
		Long idTraza = new Long(longIdTraza);
		Collection<EstructuraDetalleLogDTO> coleccionEstructuraDetalleLogDTO = 
			negocioDelegate.obtenerListaDetalleLogs(idTraza);
		
		ConvEstructDetLogDTOEnTabla convEstructDetLogDTOEnTabla = new ConvEstructDetLogDTOEnTabla();
		
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
	public FilaResultadosConsulta getEntrada() {
		return entrada;
	}

	/**
	 * @param entrada the entrada to set
	 */
	public void setEntrada(FilaResultadosConsulta entrada) {
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
