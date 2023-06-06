package com.deceval.auditoria.web.backingbean.consulta.manejodecombos;

import javax.faces.model.SelectItem;

public class ManejoDeCombos {
	protected SelectItem crearSelectItem(int value, String label) {
		SelectItem item = new SelectItem(new Integer(value), label);	
		return item;
	}	
	
	protected int devolverIdElemento(Object objeto) {
		return 0;
	}
	
	protected String devolverNombreElemento(Object objeto) {
		return null;
	}
	
	public SelectItem devolverElemento(Object objeto) {
		return crearSelectItem(devolverIdElemento(objeto), devolverNombreElemento(objeto));
	}
	
	public SelectItem devolverElementoVacio() {
		return crearSelectItem(0, " -- ");
	}
}
