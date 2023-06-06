/*
 * LogicException
 * Date 13/08/2008
 * Copyright (c) 2008
 * Company: Deceval S.A
 * All Rights Reserved.
 * This software is the confidential and proprietary information of Deceval S.A.
 */
package com.deceval.auditoria.exception;

import com.deceval.auditoria.exception.base.BaseException;

/**
 * Clase que permite hacer el manejo de las excepciones
 * generadas en la capa de Presentación y delegados.
 * 
 * @version 1.0
 * @author Oscar Fernando Gil, Johann Camilo Olarte Díaz.
 */
public class LogicException extends BaseException{

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for LogicException. 
	 * @param codigoError
	 * @param msg
	 * @param e
	 */
	public LogicException(String codigoError, String msg, Exception e) {
        super(codigoError, msg, e);
    }
}
