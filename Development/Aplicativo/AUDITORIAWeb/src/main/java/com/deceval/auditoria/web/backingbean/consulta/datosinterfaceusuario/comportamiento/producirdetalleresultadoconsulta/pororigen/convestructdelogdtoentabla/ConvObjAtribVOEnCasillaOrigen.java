package com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.comportamiento.producirdetalleresultadoconsulta.pororigen.convestructdelogdtoentabla;

import com.deceval.auditoria.vo.ObjetoAtributoVO;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.detalleresultadoconsulta.tabladeldetalle.Casilla;

public class ConvObjAtribVOEnCasillaOrigen {
	private ObjetoAtributoVO 	entrada;
	private Casilla		 		salida;
	
	public void convertir() {
		salida = new Casilla();
		
		String 	valor;
		Boolean esValorEspeacial;	
		
		valor 				= entrada.getNombreCampo();
		esValorEspeacial 	= false;			
		
		salida.setEsValorEspecial	(esValorEspeacial);
		salida.setValor				(valor);		
	}

	/**
	 * @return the entrada
	 */
	public ObjetoAtributoVO getEntrada() {
		return entrada;
	}

	/**
	 * @param entrada the entrada to set
	 */
	public void setEntrada(ObjetoAtributoVO entrada) {
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
