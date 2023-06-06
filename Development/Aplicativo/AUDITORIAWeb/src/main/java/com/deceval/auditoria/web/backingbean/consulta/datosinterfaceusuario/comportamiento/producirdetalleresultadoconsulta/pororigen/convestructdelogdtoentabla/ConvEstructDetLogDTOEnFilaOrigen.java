package com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.comportamiento.producirdetalleresultadoconsulta.pororigen.convestructdelogdtoentabla;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;

import com.deceval.auditoria.dto.EstructuraDetalleDetalleLogDTO;
import com.deceval.auditoria.dto.EstructuraDetalleLogDTO;
import com.deceval.auditoria.vo.LogHistorialVO;
import com.deceval.auditoria.vo.LogVO;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.detalleresultadoconsulta.tabladeldetalle.Casilla;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.detalleresultadoconsulta.tabladeldetalle.Fila;

public class ConvEstructDetLogDTOEnFilaOrigen {
	private static String BUNDLEBASENAME 			= "com.deceval.auditoria.web.resources.messages.MessagesResources";
	private static String BUNDLEKEYNOGUARDADO 		= "no_guardado";
	private static String BUNDLEKEYFORMATOFECHAHORA	= "formato_fecha_hora";	
	private EstructuraDetalleLogDTO entrada;
	private Fila 					salida;
	
	private Set<String> conjunto = new HashSet<String>();
	
	public void convertir(Long traza) {
		ResourceBundle bundle 	= ResourceBundle.getBundle	(BUNDLEBASENAME);
		String textoNoGuardado 	= bundle.getString			(BUNDLEKEYNOGUARDADO);
		String formatoFechaHora	= bundle.getString			(BUNDLEKEYFORMATOFECHAHORA);
		
		conjunto = new HashSet<String>();
		salida = new Fila();
		salida.setNumFila(traza);		
		ArrayList<Casilla> casillas = new ArrayList<Casilla>();
		
		Collection<EstructuraDetalleDetalleLogDTO> detalle = entrada.getDetalle();
		Collection<LogHistorialVO> coleccionLogHistorial;
		Collection<LogHistorialVO> coleccionLogHistorial2;
		 Collection<LogVO> coleccionLogVO = null;
		Casilla casilla;
		String 	valor;
		Boolean esValorEspecial;
		ConvLogHistVOEnCasillaOrigen convLogHistVOEnCasilla = new ConvLogHistVOEnCasillaOrigen();
		LogHistorialVO logHistorialVO;
		LogHistorialVO logHistorialVO2;
		String nombreCampo;
		String nombreCampo2;
		LogVO logVO = null;
		for (Iterator<EstructuraDetalleDetalleLogDTO> iterator = detalle.iterator(); iterator.hasNext();) {		
			EstructuraDetalleDetalleLogDTO estructuraDetalleDetalleLogDTO = 
				(EstructuraDetalleDetalleLogDTO) iterator.next();
			coleccionLogVO = estructuraDetalleDetalleLogDTO.getColeccionLogVO();
			logVO = devolverElementoLogVOConLaTraza(traza, coleccionLogVO);
			if(logVO != null) break;
		}
				
		for (Iterator<EstructuraDetalleDetalleLogDTO> iterator = detalle.iterator(); iterator.hasNext();) {		
			EstructuraDetalleDetalleLogDTO estructuraDetalleDetalleLogDTO = 
				(EstructuraDetalleDetalleLogDTO) iterator.next();
			
			nombreCampo = estructuraDetalleDetalleLogDTO.getObjetoAtributoVO().getNombreCampo();				
						
			if(! conjunto.contains(nombreCampo)) {
				coleccionLogHistorial = estructuraDetalleDetalleLogDTO.getColeccionLogHistorial();
				logHistorialVO = devolverElementoConLaTraza(traza, coleccionLogHistorial);
				if(logHistorialVO == null) {
					for (Iterator<EstructuraDetalleDetalleLogDTO> iterator2 = detalle.iterator(); iterator2.hasNext();) {
						EstructuraDetalleDetalleLogDTO estructuraDetalleDetalleLogDTO2 = 
							(EstructuraDetalleDetalleLogDTO) iterator2.next();
						nombreCampo2 = estructuraDetalleDetalleLogDTO2.getObjetoAtributoVO().getNombreCampo();
						
						if(nombreCampo.equals(nombreCampo2)) {
							coleccionLogHistorial2 = estructuraDetalleDetalleLogDTO2.getColeccionLogHistorial();
							logHistorialVO2 = devolverElementoConLaTraza(traza, coleccionLogHistorial2);
							if(logHistorialVO2 != null) {
								logHistorialVO = logHistorialVO2;
								break;
							}
						}
					}
				}				
				if(logHistorialVO == null) {
					casilla = new Casilla();
					valor 				= textoNoGuardado;
					esValorEspecial 	= true;
					casilla.setEsValorEspecial	(esValorEspecial);
					casilla.setValor			(valor);				
				} else {
					convLogHistVOEnCasilla.setEntrada(logHistorialVO);
					convLogHistVOEnCasilla.convertir();
					casilla = convLogHistVOEnCasilla.getSalida();
				}
				
				casillas.add(casilla);
			}			

			conjunto.add(nombreCampo);
		}
		
		SimpleDateFormat formateador = new SimpleDateFormat(formatoFechaHora);
		
		casilla = new Casilla();
		
		valor 				= traza.toString();
		esValorEspecial 	= false;			
		
		casilla.setEsValorEspecial	(esValorEspecial);
		casilla.setValor			(valor);	
		
		casillas.add(casilla);				
		
		casilla = new Casilla();		
		
		valor 				= formateador.format(logVO.getFechaAnotacion().getTime());;
		esValorEspecial 	= false;			
		
		casilla.setEsValorEspecial	(esValorEspecial);
		casilla.setValor			(valor);	
		
		casillas.add(casilla);
		
		casilla = new Casilla();
		
		valor 				= logVO.getIpUsuario();
		esValorEspecial 	= false;			
		
		casilla.setEsValorEspecial	(esValorEspecial);
		casilla.setValor			(valor);	
		
		casillas.add(casilla);	
		
		casilla = new Casilla();
		
		valor 				= logVO.getUserName();
		esValorEspecial 	= false;			
		
		casilla.setEsValorEspecial	(esValorEspecial);
		casilla.setValor			(valor);	
		
		casillas.add(casilla);	
		
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

	private LogVO devolverElementoLogVOConLaTraza(Long traza, Collection<LogVO> coleccionLogVO) {
		for (Iterator<LogVO> iterator = coleccionLogVO.iterator(); 
			 iterator.hasNext();) {
			LogVO logVO = iterator.next();
			if(logVO.getIdTraza().longValue() == traza.longValue()) 
				return logVO;
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
