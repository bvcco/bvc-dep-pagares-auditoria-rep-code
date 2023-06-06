package com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.comportamiento.producirdetalleresultadoconsulta.pororigen.convestructdelogdtoentabla;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;
import com.deceval.auditoria.dto.EstructuraDetalleDetalleLogDTO;
import com.deceval.auditoria.dto.EstructuraDetalleLogDTO;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.detalleresultadoconsulta.tabladeldetalle.Casilla;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.detalleresultadoconsulta.tabladeldetalle.Fila;

public class ConvEstructDetLogDTOEnFilTitOrigen {
	private static String BUNDLEBASENAME 	= "com.deceval.auditoria.web.resources.messages.MessagesResources";
	private static String BUNDLEKEYIDTRAZA 	= "col_idtraza";
	private static String BUNDLEKEYFECHA 	= "col_fecha";	
	private static String BUNDLEKEYDIRIP 	= "col_dirip";	
	private static String BUNDLEKEYUSUARIO 	= "col_usuario";	
	private EstructuraDetalleLogDTO entrada;
	private Fila		 			salida;
	
	private Set<String> conjunto = new HashSet<String>();
	
	public void convertir() {
		salida = new Fila();
		ArrayList<Casilla> casillas = new ArrayList<Casilla>();
		Casilla casilla;
		
		ConvObjAtribVOEnCasillaOrigen convObjAtribVOEnCasilla = new ConvObjAtribVOEnCasillaOrigen();
		
		for (Iterator<EstructuraDetalleDetalleLogDTO> iterator = entrada.getDetalle().iterator(); iterator.hasNext();) {
			EstructuraDetalleDetalleLogDTO estructuraDetalleDetalleLogDTO = 
				(EstructuraDetalleDetalleLogDTO) iterator.next();
			
			convObjAtribVOEnCasilla.setEntrada(estructuraDetalleDetalleLogDTO.getObjetoAtributoVO());
			convObjAtribVOEnCasilla.convertir();
			
			casilla = convObjAtribVOEnCasilla.getSalida();
			if(! conjunto.contains(casilla.getValor())) {
				casillas.add(casilla);
			}			
			conjunto.add(casilla.getValor());
		}
		
		String 	valor;
		Boolean esValorEspeacial;
		
		casilla = new Casilla();
			
		ResourceBundle bundle 	= ResourceBundle.getBundle	(BUNDLEBASENAME);
		String textoIdTraza 	= bundle.getString			(BUNDLEKEYIDTRAZA);
		String textoFecha 		= bundle.getString			(BUNDLEKEYFECHA);	
		String textoDirIp 		= bundle.getString			(BUNDLEKEYDIRIP);	
		String textoUsuario		= bundle.getString			(BUNDLEKEYUSUARIO);	
		
		valor 				= textoIdTraza;
		esValorEspeacial 	= false;			
		
		casilla.setEsValorEspecial	(esValorEspeacial);
		casilla.setValor			(valor);	
		
		casillas.add(casilla);		
		
		casilla = new Casilla();
		
		valor 				= textoFecha;
		esValorEspeacial 	= false;			
		
		casilla.setEsValorEspecial	(esValorEspeacial);
		casilla.setValor			(valor);	
		
		casillas.add(casilla);	
		
		casilla = new Casilla();
		
		valor 				= textoDirIp;
		esValorEspeacial 	= false;			
		
		casilla.setEsValorEspecial	(esValorEspeacial);
		casilla.setValor			(valor);	
		
		casillas.add(casilla);		
		
		casilla = new Casilla();
		
		valor 				= textoUsuario;
		esValorEspeacial 	= false;			
		
		casilla.setEsValorEspecial	(esValorEspeacial);
		casilla.setValor			(valor);	
		
		casillas.add(casilla);			
		
		salida.setCasillas(casillas);
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
