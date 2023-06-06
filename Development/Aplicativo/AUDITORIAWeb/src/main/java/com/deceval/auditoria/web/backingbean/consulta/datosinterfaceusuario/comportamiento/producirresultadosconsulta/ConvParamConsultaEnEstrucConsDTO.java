package com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.comportamiento.producirresultadosconsulta;

import java.util.Calendar;

import com.deceval.auditoria.dto.EstructuraConsultaDTO;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.parametrosconsulta.ParametrosConsulta;

public class ConvParamConsultaEnEstrucConsDTO {
	private ParametrosConsulta 		entrada;
	private EstructuraConsultaDTO 	salida;
	
	public void convertir() {
		Calendar calendar;
		
		salida = new EstructuraConsultaDTO();
		
		Integer 	idAplicacion 	= entrada.getIdAplicacion();
		Integer		idModulo		= entrada.getIdModulo();
		Integer 	idOperacion		= entrada.getIdOperacion();
		Integer 	idOrigen		= entrada.getIdOrigen();	
		String 		codigoOrigen	= entrada.getCodigoOrigen();
		String 		userName		= entrada.getUsuario();
		
		if(userName != null) {
			if(userName.trim().length() == 0) userName = null;
		}
		
		if(entrada.getIdTipoFiltro() == ParametrosConsulta.TIPO_FILTRO_POR_OPERACION ) {
			idOrigen 		= null;
			codigoOrigen 	= null;
		} else {
			idOperacion		= null;
		}
		
		calendar = Calendar.getInstance();
		calendar.setTime(entrada.getFechaDesde());		
		Calendar 	fechaInicial	= calendar;
		
		calendar = Calendar.getInstance();
		calendar.setTime(entrada.getFechaHasta());			
		Calendar 	fechaFinal		= calendar;		
		
		salida.setIdAplicacion	(idAplicacion);
		salida.setIdModulo		(idModulo);
		salida.setIdOperacion	(idOperacion);
		salida.setIdOrigen		(idOrigen);
		salida.setCodigoOrigen	(codigoOrigen);
		salida.setUserName		(userName);
		salida.setFechaInicial	(fechaInicial);
		salida.setFechaFinal	(fechaFinal);						
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
	public EstructuraConsultaDTO getSalida() {
		return salida;
	}
	/**
	 * @param salida the salida to set
	 */
	public void setSalida(EstructuraConsultaDTO salida) {
		this.salida = salida;
	}
}
