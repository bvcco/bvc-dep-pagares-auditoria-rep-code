/*
 * Constants
 * Date 04/09/2008
 * Copyright (c) 2008
 * Company: Deceval S.A
 * All Rights Reserved.
 * This software is the confidential and proprietary information of Deceval S.A.
 */
package com.deceval.auditoria.util.constants;

/**
 * Clase que almacena los nombres de las constantes que se cargan del properties de la aplicacion.
 * @version 1.0
 * @author Fredy Eduardo Fonseca.
 */
public interface Constants {

	/**
	 * Nombre del datasource AUDITORIA.
	 */
	public static final String AUDITORIA_DATASOURCE_JNDI_NAME = "AUDITORIA_DATASOURCE_JNDI_NAME";

	/**
	 * Tipo de contexto a cargar (Delegados)
	 */
	public static final String CONTEXT_TYPE = "CONTEXT_TYPE";

	/**
	 * Parametro para obtener un contexto EJB.
	 */
	public static final String PROVIDER_URL = "PROVIDER_URL";

	/**
	 * Usuario contenedor.
	 */
	public static final String SECURITY_PRINCIPAL = "SECURITY_PRINCIPAL";

	/**
	 * Password usuario contenedor.
	 */
	public static final String SECURITY_CREDENTIALS = "SECURITY_CREDENTIALS";

	/**
	 * Nombre de la fabrica del contexto a cargar.
	 */
	public static final String INITIAL_CONTEXT_FACTORY = "INITIAL_CONTEXT_FACTORY";
	
	/**
	 * Propiedar para el proveedor de la base de datos oracle
	 */
	public static final String DATA_BASE_PROVIDER_ORACLE = "oracle";
	
	/**
	 * Constantes para colas de mensajeria
	 */
	public static final String CONNECTIONFACTORYJNDINAME = "CONNECTIONFACTORYJNDINAME";
	public static final String DESTINATIONNAME_QUEUE = "DESTINATIONNAME_QUEUE";
	public static final String QUEUENAME_ANOTACIONLOG = "QUEUENAME_ANOTACIONLOG";
	
	/**
	 * Constante END POINT insertar mensaje log
	 */
	public static final String CONSTANTE_END_POINT_INSERTAR_LOG_AUDITORIA = "CONSTANTE_END_POINT_INSERTAR_LOG_AUDITORIA";
	
	/**
	 * Constante registros eliminados o activos segun administracion en tablas basicas
	 */
	public static final String CONSTANTE_REGISTRO_ELIMINADO="CONSTANTE_REGISTRO_ELIMINADO";
	public static final String CONSTANTE_REGISTRO_NO_ELIMINADO="CONSTANTE_REGISTRO_NO_ELIMINADO";

	/**
	 * Constantes que hacen referencia a los identificadores para las tablas de la tabla Homologación
	 */
	public static final String CONSTANTE_APP_AUDITORIA_TABLA_APLICACIONES = "CONSTANTE_APP_AUDITORIA_TABLA_APLICACIONES";
	public static final String CONSTANTE_APP_SEGURIDAD_TABLA_APLICACIONES = "CONSTANTE_APP_SEGURIDAD_TABLA_APLICACIONES";

	public static final String TENANT_APLICATION_ID = "TENANT_APLICATION_ID";
	public static final String TENANT_URL = "TENANT_URL";
	public static final String TENANT_ORIGEN = "TENANT_ORIGEN";
}
