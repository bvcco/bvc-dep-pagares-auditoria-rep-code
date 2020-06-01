package com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.detalleresultadoconsulta.tabladeldetalle;

import java.util.Collection;
import java.util.Iterator;
import java.util.ResourceBundle;

import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.parametrosconsulta.ParametrosConsulta;

public class Tabla {
	private static String BUNDLEBASENAME 								= "com.deceval.auditoria.web.resources.messages.MessagesResources";
	private static String BUNDLEKEYINICIOTABLA 							= "htm_inicio_tabla";		
	private static String BUNDLEKEYFINTABLA 							= "htm_fin_tabla";
	private static String BUNDLEKEYESPACIO 								= "htm_espacio";
	private static String BUNDLEKEYINICIOCUERPOTABLA 					= "htm_inicio_cuerpo_tabla";		
	private static String BUNDLEKEYFINCUERPOTABLA 						= "htm_fin_cuerpo_tabla";
	private static String BUNDLEKEYINICIOTITULOSTABLA 					= "htm_inicio_titulos_tabla";		
	private static String BUNDLEKEYFINTITULOSTABLA 						= "htm_fin_titulos_tabla";	
	private static String BUNDLEKEYINICIOFILASTABLA 					= "htm_inicio_filas_tabla";		
	private static String BUNDLEKEYFINFILASTABLA 						= "htm_fin_filas_tabla";	
	private static String BUNDLEKEYINICIOCASILLATITULOSTABLA 			= "htm_inicio_casilla_titulos_tabla";		
	private static String BUNDLEKEYFINCASILLATITULOSTABLA 				= "htm_fin_casilla_titulos_tabla";	
	private static String BUNDLEKEYINICIOCASILLANORMALTABLA 			= "htm_inicio_casilla_normal_tabla";
	private static String BUNDLEKEYINICIOCASILLAESPECIALTABLA 			= "htm_inicio_casilla_especial_tabla";		
	private static String BUNDLEKEYFINCASILLATABLA 						= "htm_fin_casilla_tabla";		
	private static String BUNDLEKEYINICIOTITULOSTABLAORIGEN 			= "htm_inicio_titulos_tabla_origen";		
	private static String BUNDLEKEYFINTITULOSTABLAORIGEN				= "htm_fin_titulos_tabla_origen";
	private static String BUNDLEKEYTITULOCAMPOSAUDITADOS 				= "htm_titulo_campos_auditados";		
	private static String BUNDLEKEYTITULOSSEGUIMIENTOAUDITORIA			= "htm_titulo_seguimiento_auditoria";
	private static String BUNDLEKEYTITULOCAMPOSAUDITADOSINICIO 			= "htm_titulo_campos_auditados_inicio";		
	private static String BUNDLEKEYTITULOSSEGUIMIENTOAUDITORIAINICIO	= "htm_titulo_seguimiento_auditoria_inicio";
	private static String BUNDLEKEYTITULOCAMPOSAUDITADOSFIN 			= "htm_titulo_campos_auditados_fin";		
	private static String BUNDLEKEYTITULOSSEGUIMIENTOAUDITORIAFIN		= "htm_titulo_seguimiento_auditoria_fin";	
	
	private String 				tituloTabla;
	private Fila 				titulos;
	private Collection<Fila> 	filas;
	
	private Integer			idTipoFiltro;	
	
	/**
	 * @return the idTipoFiltro
	 */
	public Integer getIdTipoFiltro() {
		return idTipoFiltro;
	}


	/**
	 * @param idTipoFiltro the idTipoFiltro to set
	 */
	public void setIdTipoFiltro(Integer idTipoFiltro) {
		this.idTipoFiltro = idTipoFiltro;
	}


	/**
	 * @return the el número de columnas
	 */
	public Integer getNumColumnas() {
		if(titulos == null) return new Integer(0);
		return new Integer(titulos.getCasillas().size());
	}
	
	
	public String getCodigoHtml() {
		ResourceBundle bundle 		= ResourceBundle.getBundle	(BUNDLEBASENAME);
		String formatoInicioTabla	= bundle.getString			(BUNDLEKEYINICIOTABLA);			
		String formatoFinTabla 		= bundle.getString			(BUNDLEKEYFINTABLA);
		
		String s = "";
		s = s + formatoInicioTabla;
				
		if(idTipoFiltro != null) {
			if(idTipoFiltro == ParametrosConsulta.TIPO_FILTRO_POR_ORIGEN) {
				s = s + devolverTitulosParaOrigen();
			}
		}
			
		s = s + devolverTitulos();
		s = s + devolverCuerpo();
		s = s + formatoFinTabla;
		return s;		
	}
	
	public String devolverTitulosParaOrigen() {
		ResourceBundle bundle 							= ResourceBundle.getBundle	(BUNDLEBASENAME);
		String formatoInicioTitulosTablaOrigen			= bundle.getString			(BUNDLEKEYINICIOTITULOSTABLAORIGEN);			
		String formatoFinTitulosTablaOrigen 			= bundle.getString			(BUNDLEKEYFINTITULOSTABLAORIGEN);
		String formatoTituloCamposAuditados				= bundle.getString			(BUNDLEKEYTITULOCAMPOSAUDITADOS);			
		String formatoTituloSeguimientoAuditoria		= bundle.getString			(BUNDLEKEYTITULOSSEGUIMIENTOAUDITORIA);
		String formatoTituloCamposAuditadosInicio		= bundle.getString			(BUNDLEKEYTITULOCAMPOSAUDITADOSINICIO);			
		String formatoTituloSeguimientoAuditoriaInicio	= bundle.getString			(BUNDLEKEYTITULOSSEGUIMIENTOAUDITORIAINICIO);
		String formatoTituloCamposAuditadosFin			= bundle.getString			(BUNDLEKEYTITULOCAMPOSAUDITADOSFIN);			
		String formatoTituloSeguimientoAuditoriaFin		= bundle.getString			(BUNDLEKEYTITULOSSEGUIMIENTOAUDITORIAFIN);

		String s = "";
		s = s + formatoInicioTitulosTablaOrigen;
		
		int longitudTotal = titulos.getCasillas().size();
		
		String inicioTitulo = String.format(formatoTituloCamposAuditadosInicio, 
				String.valueOf(longitudTotal - 4));	
		s = s + inicioTitulo;
		s = s + formatoTituloCamposAuditados;
		s = s + formatoTituloCamposAuditadosFin;
		
		s = s + formatoTituloSeguimientoAuditoriaInicio;
		s = s + formatoTituloSeguimientoAuditoria;
		s = s + formatoTituloSeguimientoAuditoriaFin;
		
		s = s + formatoFinTitulosTablaOrigen;
		return s;
	}	
	
	public String devolverTitulos() {
		ResourceBundle bundle 					= ResourceBundle.getBundle	(BUNDLEBASENAME);
		String formatoInicioTitulosTabla		= bundle.getString			(BUNDLEKEYINICIOTITULOSTABLA);			
		String formatoFinTitulosTabla 			= bundle.getString			(BUNDLEKEYFINTITULOSTABLA);
		String formatoInicioCasillaTitulosTabla	= bundle.getString			(BUNDLEKEYINICIOCASILLATITULOSTABLA);			
		String formatoFinCasillaTitulosTabla 	= bundle.getString			(BUNDLEKEYFINCASILLATITULOSTABLA);		
		String s = "";
		s = s + formatoInicioTitulosTabla;
		
		for (Iterator<Casilla> iterator = titulos.getCasillas().iterator(); iterator.hasNext();) {
			Casilla type = (Casilla) iterator.next();
			s = s + formatoInicioCasillaTitulosTabla;
			s = s + type.getValor();
			s = s + formatoFinCasillaTitulosTabla;
		}
		s = s + formatoFinTitulosTabla;
		return s;
	}

	public String devolverCuerpo() {
		ResourceBundle bundle 			= ResourceBundle.getBundle	(BUNDLEBASENAME);
		String formatoInicioCuerpoTabla	= bundle.getString			(BUNDLEKEYINICIOCUERPOTABLA);			
		String formatoFinCuerpoTabla 	= bundle.getString			(BUNDLEKEYFINCUERPOTABLA);
		
		String s = "";
		s = s + formatoInicioCuerpoTabla;
		
		for (Iterator<Fila> iterator = filas.iterator(); iterator.hasNext();) {
			Fila fila = (Fila) iterator.next();
			s = s + devolverFila(fila);
		}
		
		s = s + formatoFinCuerpoTabla;
		return s;		
	}
	
	public String devolverFila(Fila fila) {
		ResourceBundle bundle 						= ResourceBundle.getBundle	(BUNDLEBASENAME);
		String formatoInicioFilasTabla				= bundle.getString			(BUNDLEKEYINICIOFILASTABLA);			
		String formatoFinFilasTabla 				= bundle.getString			(BUNDLEKEYFINFILASTABLA);
		String formatoInicioCasillaNormalTabla		= bundle.getString			(BUNDLEKEYINICIOCASILLANORMALTABLA);
		String formatoInicioCasillaEspecialTabla	= bundle.getString			(BUNDLEKEYINICIOCASILLAESPECIALTABLA);	
		String formatoFinCasillaTabla 				= bundle.getString			(BUNDLEKEYFINCASILLATABLA);		
		String s = "";
		s = s + formatoInicioFilasTabla;
		
		for (Iterator<Casilla> iterator = fila.getCasillas().iterator(); iterator.hasNext();) {
			Casilla casilla = (Casilla) iterator.next();
			if(casilla.getEsValorEspecial()) {
				s = s + formatoInicioCasillaEspecialTabla;
			} else {
				s = s + formatoInicioCasillaNormalTabla;
			}
			
			s = s + remplazarEspacios(casilla.getValor());
			s = s + formatoFinCasillaTabla;
		}
		s = s + formatoFinFilasTabla;
		return s;
	}	
	
	private String remplazarEspacios(String entrada) {
		String salida = "";
		for(int i = 0; i < entrada.length(); i ++) {
			salida = salida + remplazarEspacio(entrada.substring(i, i + 1));
		}
		return salida;
	}
	
	private String remplazarEspacio(String entrada) {
		ResourceBundle bundle 			= ResourceBundle.getBundle	(BUNDLEBASENAME);
		String formatoEspacio			= bundle.getString			(BUNDLEKEYESPACIO);			
		if(entrada.equals(" ")) return formatoEspacio;
		return entrada;
	}
	
	/**
	 * @return the tituloTabla
	 */
	public String getTituloTabla() {
		return tituloTabla;
	}
	/**
	 * @param nombre the tituloTabla to set
	 */
	public void setTituloTabla(String tituloTabla) {
		this.tituloTabla = tituloTabla;
	}
	/**
	 * @return the titulos
	 */
	public Fila getTitulos() {
		return titulos;
	}
	/**
	 * @param titulos the titulos to set
	 */
	public void setTitulos(Fila titulos) {
		this.titulos = titulos;
	}
	/**
	 * @return the filas
	 */
	public Collection<Fila> getFilas() {
		return filas;
	}
	/**
	 * @param filas the filas to set
	 */
	public void setFilas(Collection<Fila> filas) {
		this.filas = filas;
	}	
}
