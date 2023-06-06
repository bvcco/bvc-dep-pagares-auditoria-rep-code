/*
 * BaseDelegate
 * Date 24/04/2008
 * Copyright (c) 2008
 * Company: Deceval S.A
 * All Rights Reserved.
 * This software is the confidential and proprietary information of Deceval S.A.
 */
package com.deceval.auditoria.integration;


import com.deceval.auditoria.exception.LogicException;
import com.deceval.auditoria.integration.remote.DecevalRemote;
import com.deceval.auditoria.integration.services.location.ServiceLocator;

/**
 * Clase base para las clases delegate.
 * Permite obtener la interfaz remota.
 * 
 * @version 1.0
 * @author Johann Camilo Olarte Díaz
 */
public class BaseDelegate {

	/**
	 * Método encargado de obtener las referencias a las instancias de las clases que
	 * implementan la interfaz <code>DecevalRemote</code>.
	 * @param nombreReferencia
	 * @return
	 * @throws LogicException
	 */
	protected DecevalRemote getDecevalRemote(String nombreReferencia)
    throws LogicException {
	    try {
	        return (DecevalRemote) ServiceLocator.getInstance().getDecevalRemote(nombreReferencia);
	    } catch (Exception e) {
	        throw new LogicException("", "", e);
	    }
	}
}
