package com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.comportamiento.producirresultadosconsulta.poroperacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ResourceBundle;

import com.deceval.auditoria.dto.EstructuraLogDTO;
import com.deceval.auditoria.exception.LogicException;
import com.deceval.auditoria.integration.NegocioDelegate;
import com.deceval.auditoria.web.backingbean.consulta.ConsultaJSFBean;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.comportamiento.producirresultadosconsulta.ConvParamConsultaEnEstrucConsDTO;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.parametrosconsulta.ParametrosConsulta;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.resultadosconsulta.FilaResultadosConsulta;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.resultadosconsulta.ResultadosConsulta;

public class ProducirResultadosConsulta {
	private static String BUNDLEBASENAME 			= "com.deceval.auditoria.web.resources.messages.MessagesResources";
	private static String BUNDLEKEYFORMATOTITULO	= "subsubtitulo_consulta_operacion";
	private static String BUNDLEKEYFORMATOFECHAHORA	= "formato_fecha_hora";	
	
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
				util.getNombreAplicacion(), util.getNombreModulo(), util.getNombreOperacion());			

		salida.setTitulo(titulo);
		
		salida.setParametrosConsulta(entrada);
		
		ArrayList<FilaResultadosConsulta> filasResultadosConsulta =	
			new ArrayList<FilaResultadosConsulta>();

		NegocioDelegate negocioDelegate = new NegocioDelegate();

		ConvParamConsultaEnEstrucConsDTO convParamConsultaEnEstrucConsDTO = new ConvParamConsultaEnEstrucConsDTO();
		convParamConsultaEnEstrucConsDTO.setEntrada(entrada);
		convParamConsultaEnEstrucConsDTO.convertir();
		
		Collection<EstructuraLogDTO> datos = 
			negocioDelegate.obtenerListaLogs(convParamConsultaEnEstrucConsDTO.getSalida());
		
		ConvEstrucLogDTOEnFilaResultConsulta convEstrucLogDTOEnFilaResultConsulta =
			new ConvEstrucLogDTOEnFilaResultConsulta();
		
		for (Iterator<EstructuraLogDTO> iterator = datos.iterator(); iterator.hasNext();) {
			EstructuraLogDTO estructuraLogDTOInterno = (EstructuraLogDTO) iterator.next();			
			convEstrucLogDTOEnFilaResultConsulta.setEntrada(estructuraLogDTOInterno);
			convEstrucLogDTOEnFilaResultConsulta.convertir();				
			filasResultadosConsulta.add(convEstrucLogDTOEnFilaResultConsulta.getSalida());			
		}			
		
		Collections.sort(filasResultadosConsulta, new FilaResultadosConsultaComparator());
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
	
	class FilaResultadosConsultaComparator implements Comparator<FilaResultadosConsulta> {

		  public int compare(FilaResultadosConsulta o1, FilaResultadosConsulta o2) {	
			  Calendar calendar1;
			  calendar1 = Calendar.getInstance();			  
			  
			  Calendar calendar2;
			  calendar2 = Calendar.getInstance();			  			  
			  
			  ResourceBundle bundle = ResourceBundle.getBundle	(BUNDLEBASENAME);
			  String formatoFecha 	= bundle.getString			(BUNDLEKEYFORMATOFECHAHORA);
			  
			  SimpleDateFormat formateador = new SimpleDateFormat(formatoFecha);
			  java.util.Date date1 = null;
				try {
					date1 = formateador.parse(o1.getFecha());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  java.util.Date date2 = null;
				try {
					date2 = formateador.parse(o2.getFecha());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  
			  calendar1.setTime(date1);
			  calendar2.setTime(date2);
			  
			  return (calendar1.compareTo(calendar2));
			  
			  /*return o1.getObjetoAtributoVO().getOrdenCampo().intValue() - 
			   		 o2.getObjetoAtributoVO().getOrdenCampo().intValue();*/
		  }

		  public boolean equals(Object o) {
			  return this == o;
		  }
	}		
	
}
