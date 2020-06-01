package com.deceval.auditoria.web.backingbean.consulta.manejodecombos;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import javax.faces.model.SelectItem;

import com.deceval.auditoria.exception.LogicException;
import com.deceval.auditoria.integration.NegocioDelegate;
import com.deceval.auditoria.vo.ModuloVO;

public class ManejoDeComboModulo extends ManejoDeCombos {
	/*  Corresponde al funcionamiento del combo box de Módulos */
	private boolean 						yaTraidoModulos 		= false;
	private int								anteriorIdAplicacion	= 0;	
	private LinkedList<SelectItem> 			iModulos;	
	
	private boolean 						iBorrarIdModulo 		= false;	
	
	protected int devolverIdElemento(Object objeto) {
		ModuloVO moduloVO = (ModuloVO) objeto;
		return moduloVO.getIdModulo().intValue();
	}
	
	protected String devolverNombreElemento(Object objeto) {
		ModuloVO moduloVO = (ModuloVO) objeto;
		return moduloVO.getNombreModulo();
	}
	
	/*  Corresponde al funcionamiento del combo box de Módulos */
	public LinkedList<SelectItem> getModulos(int pIdAplicacion) throws LogicException {
		boolean traerModulos = false;
		if(! yaTraidoModulos) {
			traerModulos = true;
		} else {
			if(anteriorIdAplicacion == pIdAplicacion) {
				traerModulos = false;
			} else {
				traerModulos = true;
			}
		}
		
		iBorrarIdModulo = false;
		if(! traerModulos) return iModulos;
		yaTraidoModulos = true;		
		iModulos = obtenerModulos(pIdAplicacion);
		iBorrarIdModulo = true;
		anteriorIdAplicacion = pIdAplicacion;
		return iModulos;
	}
	
	private LinkedList<SelectItem> obtenerModulos(int pIdAplicacion) throws LogicException {
		LinkedList<SelectItem> lModulos = new LinkedList<SelectItem>();		
		lModulos.add(devolverElementoVacio());				
		if(pIdAplicacion == 0) return lModulos;		
		agregarItemsModulo(lModulos, pIdAplicacion);		
		return lModulos;		
	}	
	
	private void agregarItemsModulo(LinkedList<SelectItem> l, int idAplicacion) throws LogicException {
		Collection<ModuloVO> 		bdListaModulo;	
		NegocioDelegate negocioDelegate = new NegocioDelegate();
		bdListaModulo 	= negocioDelegate.obtenerListaModuloPorIdAplicacion(idAplicacion);
		for (Iterator<ModuloVO> iterator = bdListaModulo.iterator(); iterator.hasNext();) {
			ModuloVO elemento = (ModuloVO) iterator.next();
			if(elemento.getIdAplicacion().intValue() == idAplicacion)
				l.add(devolverElemento(elemento));
		}		
	}
	
	public boolean getBorrarIdModulo () {
		return iBorrarIdModulo;
	}	
}
