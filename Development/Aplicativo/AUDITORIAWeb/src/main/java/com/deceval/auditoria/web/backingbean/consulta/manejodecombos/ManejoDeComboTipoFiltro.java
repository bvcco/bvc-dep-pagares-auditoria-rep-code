package com.deceval.auditoria.web.backingbean.consulta.manejodecombos;

import java.util.LinkedList;
import java.util.ResourceBundle;

import javax.faces.model.SelectItem;

import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.parametrosconsulta.ParametrosConsulta;

public class ManejoDeComboTipoFiltro extends ManejoDeCombos {
	
	private static String BUNDLEBASENAME 			= "com.deceval.auditoria.web.resources.messages.MessagesResources";
	private static String BUNDLEKEYPOROPERACION 	= "cmb_tipofiltro_poroperacion";
	private static String BUNDLEKEYPORORIGEN	 	= "cmb_tipofiltro_pororigen";
	
	/*  Corresponde al funcionamiento del combo box de Tipo Filtro */
	public LinkedList<SelectItem> getTiposFiltro() {
		return cargarListaTiposFiltro();
	}	
	
	private LinkedList<SelectItem> cargarListaTiposFiltro() {
		LinkedList<SelectItem> lTiposFiltro = new LinkedList<SelectItem>();		
		
		int 	value;
		String 	label;
		
		ResourceBundle bundle = ResourceBundle.getBundle(BUNDLEBASENAME);
		
		value = ParametrosConsulta.TIPO_FILTRO_POR_OPERACION;
		label = bundle.getString(BUNDLEKEYPOROPERACION);
		
		lTiposFiltro.add(crearSelectItem(value, label));
		
		value = ParametrosConsulta.TIPO_FILTRO_POR_ORIGEN;
		label = bundle.getString(BUNDLEKEYPORORIGEN);		
		
		lTiposFiltro.add(crearSelectItem(value, label));
		return lTiposFiltro;		
	}	
}
