package com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.comportamiento.producirresultadosconsulta.poroperacion;

import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import com.deceval.auditoria.dto.EstructuraLogDTO;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.resultadosconsulta.FilaResultadosConsulta;

public class ConvEstrucLogDTOEnFilaResultConsulta {
	private static String BUNDLEBASENAME 			= "com.deceval.auditoria.web.resources.messages.MessagesResources";
	private static String BUNDLEKEYFORMATOFECHAHORA = "formato_fecha_hora";		
	
	private EstructuraLogDTO 		entrada;
	private FilaResultadosConsulta 	salida;
	
	public void convertir() {
		salida = new FilaResultadosConsulta();
		
		ResourceBundle bundle 			= ResourceBundle.getBundle	(BUNDLEBASENAME);
		String formatoFechaHora			= bundle.getString			(BUNDLEKEYFORMATOFECHAHORA);		
		SimpleDateFormat formateador = new SimpleDateFormat(formatoFechaHora);
		
		String usuario;
		String fecha;
		String ip;
		String operacion;
		String origen;
		String codigoOrigen;
		String descripcion;
		String traza;		
		usuario 		= entrada.getLogVO().getUserName();
		fecha 			= formateador.format(entrada.getLogVO().getFechaAnotacion().getTime());
		ip 				= entrada.getLogVO().getIpUsuario();
		operacion 		= entrada.getOperacionVO().getDescripcionOperacion();
		origen 			= entrada.getOrigenVO().getDescripcionOrigen();
		codigoOrigen 	= entrada.getLogVO().getCodigoOrigen();
		descripcion 	= entrada.getLogVO().getDescripcionAnotacion();
		traza 			= entrada.getLogVO().getIdTraza().toString();			
		salida.setUsuario		(usuario);
		salida.setFecha			(fecha);
		salida.setIp			(ip);
		salida.setOperacion		(operacion);
		salida.setOrigen		(origen);
		salida.setCodigoOrigen	(codigoOrigen);
		salida.setDescripcion	(descripcion);
		salida.setTraza			(traza);			
	}

	/**
	 * @return the entrada
	 */
	public EstructuraLogDTO getEntrada() {
		return entrada;
	}

	/**
	 * @param entrada the entrada to set
	 */
	public void setEntrada(EstructuraLogDTO entrada) {
		this.entrada = entrada;
	}

	/**
	 * @return the salida
	 */
	public FilaResultadosConsulta getSalida() {
		return salida;
	}

	/**
	 * @param salida the salida to set
	 */
	public void setSalida(FilaResultadosConsulta salida) {
		this.salida = salida;
	}
	
}
