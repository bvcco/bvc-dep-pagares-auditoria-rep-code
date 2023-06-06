package com.deceval.auditoria.web.backingbean.consulta.manejodecombos;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import javax.faces.model.SelectItem;

import com.deceval.auditoria.exception.LogicException;
import com.deceval.auditoria.integration.NegocioDelegate;
import com.deceval.auditoria.vo.OrigenVO;

public class ManejoDeComboOrigen extends ManejoDeCombos {
	/*  Corresponde al funcionamiento del combo box de Orígenes */
	private boolean 						yaTraidoOrigenes		= false;
	private int								anteriorIdAplicacion	= 0;	
	private LinkedList<SelectItem> 			iOrigenes;	
	
	private boolean 						iBorrarIdOrigen 		= false;	
	
	protected int devolverIdElemento(Object objeto) {
		OrigenVO origenVO = (OrigenVO) objeto;
		return origenVO.getIdOrigen().intValue();
	}
	
	protected String devolverNombreElemento(Object objeto) {
		OrigenVO origenVO = (OrigenVO) objeto;
		return origenVO.getDescripcionOrigen();
	}
	
	/*  Corresponde al funcionamiento del combo box de Orígenes */
	public LinkedList<SelectItem> getOrigenes(int pIdAplicacion) throws LogicException {
		boolean traerOrigenes = false;
		if(! yaTraidoOrigenes) {
			traerOrigenes = true;
		} else {
			if(anteriorIdAplicacion == pIdAplicacion) {
				traerOrigenes = false;
			} else {
				traerOrigenes = true;
			}
		}
		
		iBorrarIdOrigen = false;		
		if(! traerOrigenes) return iOrigenes;
		yaTraidoOrigenes = true;		
		iOrigenes = obtenerOrigenes(pIdAplicacion);
		iBorrarIdOrigen = true;
		anteriorIdAplicacion = pIdAplicacion;
		return iOrigenes;
	}
	
	private LinkedList<SelectItem> obtenerOrigenes(int pIdAplicacion) throws LogicException {
		LinkedList<SelectItem> lOrigenes = new LinkedList<SelectItem>();		
		lOrigenes.add(devolverElementoVacio());				
		if(pIdAplicacion == 0) return lOrigenes;		
		agregarItemsOrigen(lOrigenes, pIdAplicacion);		
		return lOrigenes;		
	}	
	
	private void agregarItemsOrigen(LinkedList<SelectItem> l, int idAplicacion) throws LogicException {
		Collection<OrigenVO> 		bdListaOrigen;	
		NegocioDelegate negocioDelegate = new NegocioDelegate();
		bdListaOrigen 	= negocioDelegate.obtenerListaOrigenPorIdAplicacion(idAplicacion);
		for (Iterator<OrigenVO> iterator = bdListaOrigen.iterator(); iterator.hasNext();) {
			OrigenVO elemento = (OrigenVO) iterator.next();
			if(elemento.getIdAplicacion().intValue() == idAplicacion)
				l.add(devolverElemento(elemento));
		}		
	}
	
	public boolean getBorrarIdOrigen () {
		return iBorrarIdOrigen;
	}	
}
