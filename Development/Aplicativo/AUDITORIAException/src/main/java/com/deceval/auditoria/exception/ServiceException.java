/*
 * ServiceException
 * Date 13/08/2008
 * Copyright (c) 2008
 * Company: Deceval S.A
 * All Rights Reserved.
 * This software is the confidential and proprietary information of Deceval S.A.
 */
package com.deceval.auditoria.exception;

import com.deceval.auditoria.exception.base.BaseException;

/**
 * Clase que permite hacer el manejo de las excepciones generadas en la capa de
 * negocio
 * 
 * @version 1.0
 * @author Johann Camilo Olarte Díaz, Oscar Fernando Gil.
 */
public class ServiceException extends BaseException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for ServiceException.
	 * 
	 * @param codigoError
	 *            Codigo de error de la excepcion
	 * @param msg
	 *            Mensaje detallado de la excepción.
	 * @param e
	 *            Excepción generada.
	 */
	public ServiceException(String codigoError, String msg, Exception e) {
		super(codigoError, msg, e);
	}

}
