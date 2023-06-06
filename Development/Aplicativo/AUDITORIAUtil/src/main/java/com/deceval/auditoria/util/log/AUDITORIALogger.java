/*
 * AUDITORIALogger
 * Date 04/09/2008
 * Copyright (c) 2008
 * Company: Deceval S.A
 * All Rights Reserved.
 * This software is the confidential and proprietary information of Deceval S.A.
 */
package com.deceval.auditoria.util.log;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.deceval.auditoria.util.properties.PropertiesLoader;

/**
 * Clase que realiza las tareas de logging de la aplicación, Utiliza el API De
 * log4j y un archivo de configuracion personalizado.
 * 
 * @version 1.0
 * @author Johann Camilo Olarte Díaz.
 */
public class AUDITORIALogger {	

	/** Unica instancia del log */
	private static AUDITORIALogger log;

	/** Categoria del log */
	private static Logger cat = Logger.getLogger(AUDITORIALogger.class);

	/**
	 * Nombre de la propiedad que contiene la ruta del archivo de configuración
	 * del log.
	 */
	private static final String LOG_PROPERTIES_AUDITORIA = "LOG_PROPERTIES_AUDITORIA";

	/**
	 * Realiza la construcción del Log basado en su archivo de configuración XML
	 */
	private AUDITORIALogger() throws Exception {
		DOMConfigurator.configure(PropertiesLoader
				.loadProperty(LOG_PROPERTIES_AUDITORIA));
	}

	/** Se obtiene la instancia del log */
	public static AUDITORIALogger getInstance() throws Exception {
		if (log == null) {
			log = new AUDITORIALogger();
		}
		return log;
	}

	/**
	 * Agrega un nuevo mensaje tipo DEBUG
	 * 
	 * @param message
	 *            Mensaje a ser agregado (DEBUG)
	 */
	public void debugMessage(String message) {
		cat.debug(message);
	}

	/**
	 * Agrega un nuevo mensaje tipo WARNING
	 * 
	 * @param message
	 *            Mensaje a ser agregado (WARNING)
	 */
	public void warnMessage(String message) {
		cat.warn(message);
	}

	/**
	 * Agrega un nuevo mensaje tipo ERROR
	 * 
	 * @param message
	 *            Mensaje a ser agregado (ERROR)
	 */
	public void errorMessage(String message) {
		cat.error(message);
	}

	/**
	 * Agrega un nuevo mensaje tipo INFO
	 * 
	 * @param message
	 *            Mensaje a ser agregado (INFO)
	 */
	public void infoMessage(String message) {
		cat.info(message);
	}

	public static void main(String[] args) {
		try {
			AUDITORIALogger log = AUDITORIALogger.getInstance();
			log.warnMessage("Warning Message");
			log.infoMessage("Info message");
			log.errorMessage("Error message");
			log.debugMessage("Debug message");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
