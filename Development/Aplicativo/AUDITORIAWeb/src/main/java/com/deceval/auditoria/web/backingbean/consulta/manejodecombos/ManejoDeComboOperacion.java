package com.deceval.auditoria.web.backingbean.consulta.manejodecombos;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import javax.faces.model.SelectItem;

import com.deceval.auditoria.exception.LogicException;
import com.deceval.auditoria.integration.NegocioDelegate;
import com.deceval.auditoria.vo.OperacionVO;

public class ManejoDeComboOperacion extends ManejoDeCombos {
	/*  Corresponde al funcionamiento del combo box de Operaciones */
	private boolean 						yaTraidoOperaciones 		= false;
	private int								anteriorIdModulo	= 0;	
	private LinkedList<SelectItem> 			iOperaciones;	
	
	private boolean 						iBorrarIdOperacion 		= false;	
	
	protected int devolverIdElemento(Object objeto) {
		OperacionVO operacionVO = (OperacionVO) objeto;
		return operacionVO.getIdOperacion().intValue();
	}
	
	protected String devolverNombreElemento(Object objeto) {
		OperacionVO operacionVO = (OperacionVO) objeto;
		return operacionVO.getDescripcionOperacion();
	}
	
	/*  Corresponde al funcionamiento del combo box de Operaciones */
	public LinkedList<SelectItem> getOperaciones(int pIdAplicacion, int pIdModulo) throws LogicException {
		boolean traerOperaciones = false;
		if(! yaTraidoOperaciones) {
			traerOperaciones = true;
		} else {
			if(anteriorIdModulo == pIdModulo) {
				traerOperaciones = false;
			} else {
				traerOperaciones = true;
			}
		}
		
		iBorrarIdOperacion = false;
		if(! traerOperaciones) return iOperaciones;
		yaTraidoOperaciones = true;		
		iOperaciones = obtenerOperaciones(pIdAplicacion, pIdModulo);
		iBorrarIdOperacion = true;
		anteriorIdModulo = pIdModulo;
		return iOperaciones;
	}
	
	private LinkedList<SelectItem> obtenerOperaciones(int pIdAplicacion, int pIdModulo) throws LogicException {
		LinkedList<SelectItem> lOperaciones = new LinkedList<SelectItem>();		
		lOperaciones.add(devolverElementoVacio());				
		if(pIdAplicacion == 0 || pIdModulo == 0) return lOperaciones;	
		agregarItemsOperacion(lOperaciones, pIdModulo);		
		return lOperaciones;		
	}	
	
	private void agregarItemsOperacion(LinkedList<SelectItem> l, int idModulo) throws LogicException {
		Collection<OperacionVO>		bdListaOperacion;
		NegocioDelegate negocioDelegate = new NegocioDelegate();
		bdListaOperacion 	= negocioDelegate.obtenerListaOperacionPorIdModulo(idModulo);
		for (Iterator<OperacionVO> iterator = bdListaOperacion.iterator(); iterator.hasNext();) {
			OperacionVO elemento = (OperacionVO) iterator.next();
			if(elemento.getIdModulo().intValue() == idModulo)
				l.add(devolverElemento(elemento));
		}		
	}
	
	public boolean getBorrarIdOperacion () {
		return iBorrarIdOperacion;
	}
}