package com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.comportamiento.producirdetalleresultadoconsulta.poroperacion.convestructdelogdtoentabla;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ResourceBundle;

import com.deceval.auditoria.dto.EstructuraDetalleDetalleLogDTO;
import com.deceval.auditoria.dto.EstructuraDetalleLogDTO;
import com.deceval.auditoria.vo.LogHistorialVO;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.detalleresultadoconsulta.tabladeldetalle.Casilla;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.detalleresultadoconsulta.tabladeldetalle.Fila;

public class ConvEstructDetLogDTOEnFila {
	private static String BUNDLEBASENAME 		= "com.deceval.auditoria.web.resources.messages.MessagesResources";
	private static String BUNDLEKEYNOGUARDADO	= "no_guardado";	
	
	private EstructuraDetalleLogDTO entrada;
	private Fila 					salida;
	
	public void convertir(Long traza) {
		salida = new Fila();
		ArrayList<Casilla> casillas = new ArrayList<Casilla>();
		
		Collection<EstructuraDetalleDetalleLogDTO> detalle = entrada.getDetalle();
		Collection<LogHistorialVO> coleccionLogHistorial;
		Casilla casilla;
		String 	valor;
		Boolean esValorEspecial;
		ConvLogHistVOEnCasilla convLogHistVOEnCasilla = new ConvLogHistVOEnCasilla();
		LogHistorialVO logHistorialVO;
		for (Iterator<EstructuraDetalleDetalleLogDTO> iterator = detalle.iterator(); iterator.hasNext();) {
			EstructuraDetalleDetalleLogDTO estructuraDetalleDetalleLogDTO = 
				(EstructuraDetalleDetalleLogDTO) iterator.next();
			coleccionLogHistorial = estructuraDetalleDetalleLogDTO.getColeccionLogHistorial();
			logHistorialVO = devolverElementoConLaTraza(traza, coleccionLogHistorial);
			if(logHistorialVO == null) {
				casilla = new Casilla();
				ResourceBundle bundle 	= ResourceBundle.getBundle	(BUNDLEBASENAME);
				String noGuardado 		= bundle.getString			(BUNDLEKEYNOGUARDADO);					
				valor 					= noGuardado;
				esValorEspecial 		= true;
				casilla.setEsValorEspecial	(esValorEspecial);
				casilla.setValor			(valor);				
			} else {
				convLogHistVOEnCasilla.setEntrada(logHistorialVO);
				convLogHistVOEnCasilla.convertir();
				casilla = convLogHistVOEnCasilla.getSalida();
			}
			
			casillas.add(casilla);
		}
		
		salida.setCasillas(casillas);
	}
	
	private LogHistorialVO devolverElementoConLaTraza(Long traza, Collection<LogHistorialVO> coleccionLogHistorial) {
		for (Iterator<LogHistorialVO> iterator = coleccionLogHistorial.iterator(); 
			 iterator.hasNext();) {
			LogHistorialVO logHistorialVO = (LogHistorialVO) iterator.next();
			if(logHistorialVO.getIdTraza().longValue() == traza.longValue()) 
				return logHistorialVO;
		}
		
		return null;
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
