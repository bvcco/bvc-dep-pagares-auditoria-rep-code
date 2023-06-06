/*
 * BaseException
 * Date 13/08/2008
 * Copyright (c) 2008
 * Company: Deceval S.A
 * All Rights Reserved.
 * This software is the confidential and proprietary information of Deceval S.A.
 */
package com.deceval.auditoria.exception.base;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import com.deceval.auditoria.util.log.AUDITORIALogger;

/**
 * Clase base de las Excepciones del proyecto. Cada vez que se lanza una
 * excepción genera mensajes en el log de errores.

 * @version 1.0
 * @author Oscar Fernando Gil, Johann Camilo Olarte Díaz.
 */
public class BaseException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Codigo de error a almacenar.
	 */
	private String errorCode;

	/**
	 * Excepcion base generada
	 */
	private Exception exception;

	/**
	 * Constructor (No genera log si la excepción es de tipo BaseExcepcion)
	 * 
	 * @param codigoError
	 *            Codigo del error.
	 * @param msg
	 *            Mensaje de la excepción.
	 */
	public BaseException(String codigoError, String msg, Exception e) {
		super(codigoError + msg);
		this.errorCode = codigoError;
		this.exception = e;

		try {
			AUDITORIALogger.getInstance().errorMessage(
					"Exception:" + msg + ", trace: " + e.toString());
			if (!(e instanceof BaseException)) {
				AUDITORIALogger.getInstance().errorMessage(
						BaseException.getStackTrace(e));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		if (e != null) {
			e.printStackTrace();
		}
	}

	/**
	 * Obtiene el código de error de la Excepción
	 * 
	 * @return codigo de error con el que fue lanzada la excepción
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * Returns the excepcion.
	 * 
	 * @return Exception
	 */
	public Exception getException() {
		return exception;
	}

	/**
	 * Metodo utilitario que retorna un String del stacktrace generado por una
	 * excepción.
	 * 
	 * @param aThrowable
	 *            Excepción generada
	 * @return
	 */
	public static String getStackTrace(Throwable aThrowable) {
		final Writer result = new StringWriter();
		final PrintWriter printWriter = new PrintWriter(result);
		aThrowable.printStackTrace(printWriter);
		return result.toString();
	}
}
