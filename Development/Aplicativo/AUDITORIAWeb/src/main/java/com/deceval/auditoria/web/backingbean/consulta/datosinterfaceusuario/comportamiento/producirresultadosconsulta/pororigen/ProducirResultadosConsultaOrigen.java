package com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.comportamiento.producirresultadosconsulta.pororigen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.ResourceBundle;

import com.deceval.auditoria.exception.LogicException;
import com.deceval.auditoria.integration.NegocioDelegate;
import com.deceval.auditoria.web.backingbean.consulta.ConsultaJSFBean;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.comportamiento.producirresultadosconsulta.ConvParamConsultaEnEstrucConsDTO;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.parametrosconsulta.ParametrosConsulta;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.resultadosconsulta.FilaResultadosConsulta;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.resultadosconsulta.ResultadosConsulta;

public class ProducirResultadosConsultaOrigen {
	private static String BUNDLEBASENAME 			= "com.deceval.auditoria.web.resources.messages.MessagesResources";
	private static String BUNDLEKEYFORMATOTITULO	= "subsubtitulo_consulta_origen";		
	
	private ParametrosConsulta entrada;
	private ResultadosConsulta salida;
	private ConsultaJSFBean util;
	
	/**
	 * @return the util
	 */
	public ConsultaJSFBean getUtil() {
		return util;
	}
	/**
	 * @param util the util to set
	 */
	public void setUtil(ConsultaJSFBean util) {
		this.util = util;
	}
	public void producir() throws LogicException {
		salida = new ResultadosConsulta();
		
		String titulo;
		
		ResourceBundle bundle 	= ResourceBundle.getBundle	(BUNDLEBASENAME);
		String formatoTitulo	= bundle.getString			(BUNDLEKEYFORMATOTITULO);			
		
		titulo = String.format(formatoTitulo, 
				util.getNombreAplicacion(), util.getNombreModulo(), util.getNombreOrigen());		

		salida.setTitulo(titulo);
		
		salida.setParametrosConsulta(entrada);
		
		ArrayList<String> codigosOrigen =	
			new ArrayList<String>();

		NegocioDelegate negocioDelegate = new NegocioDelegate();

		ConvParamConsultaEnEstrucConsDTO convParamConsultaEnEstrucConsDTO = new ConvParamConsultaEnEstrucConsDTO();
		convParamConsultaEnEstrucConsDTO.setEntrada(entrada);
		convParamConsultaEnEstrucConsDTO.convertir();
		
		Collection<String> datos = 
			negocioDelegate.obtenerListaCodigoOrigen(convParamConsultaEnEstrucConsDTO.getSalida());
		
		for (Iterator<String> iterator = datos.iterator(); iterator.hasNext();) {
			String codigoOrigen = (String) iterator.next();						
			codigosOrigen.add(codigoOrigen);			
		}			
		
		Collections.sort(codigosOrigen);
		
		ArrayList<FilaResultadosConsulta> filasResultadosConsulta = new ArrayList<FilaResultadosConsulta>();
		FilaResultadosConsulta filaResultadosConsulta;
		for (Iterator<String> iterator = codigosOrigen.iterator(); iterator
				.hasNext();) {
			filaResultadosConsulta = new FilaResultadosConsulta();
			String codigoOrigen = (String) iterator.next();
			filaResultadosConsulta.setCodigoOrigen(codigoOrigen);
			filasResultadosConsulta.add(filaResultadosConsulta);
		}
		
		salida.setFilasResultadosConsulta(filasResultadosConsulta);
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
	public ResultadosConsulta getSalida() {
		return salida;
	}
	/**
	 * @param salida the salida to set
	 */
	public void setSalida(ResultadosConsulta salida) {
		this.salida = salida;
	}	
}
