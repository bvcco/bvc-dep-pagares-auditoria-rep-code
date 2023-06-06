package com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.comportamiento.producirdetalleresultadoconsulta.pororigen.convestructdelogdtoentabla;

import java.util.ResourceBundle;

import com.deceval.auditoria.vo.LogHistorialVO;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.detalleresultadoconsulta.tabladeldetalle.Casilla;

public class ConvLogHistVOEnCasillaOrigen {
	private static String BUNDLEBASENAME 			= "com.deceval.auditoria.web.resources.messages.MessagesResources";
	private static String BUNDLEKEYFORMATOESNULO	= "es_nulo";		
	
	private LogHistorialVO 	entrada;
	private Casilla		 	salida;
	
	public void convertir() {
		salida = new Casilla();
		
		String 	valor;
		Boolean esValorEspecial;	
		
		valor 				= entrada.getValorAtributo();
		esValorEspecial 	= false;			
		
		if(valor == null) {
			ResourceBundle bundle  	= ResourceBundle.getBundle	(BUNDLEBASENAME);
			String esNulo 			= bundle.getString			(BUNDLEKEYFORMATOESNULO);				
			valor 					= esNulo;
			esValorEspecial 		= true;
		}
		
		salida.setEsValorEspecial	(esValorEspecial);
		salida.setValor				(valor);		
	}

	/**
	 * @return the entrada
	 */
	public LogHistorialVO getEntrada() {
		return entrada;
	}

	/**
	 * @param entrada the entrada to set
	 */
	public void setEntrada(LogHistorialVO entrada) {
		this.entrada = entrada;
	}

	/**
	 * @return the salida
	 */
	public Casilla getSalida() {
		return salida;
	}

	/**
	 * @param salida the salida to set
	 */
	public void setSalida(Casilla salida) {
		this.salida = salida;
	}	
}
