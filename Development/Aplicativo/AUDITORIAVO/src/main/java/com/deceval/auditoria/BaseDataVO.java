/*
 * BaseVO
 * Date 13/08/2008
 * Copyright (c) 2008
 * Company: Deceval S.A
 * All Rights Reserved.
 * This software is the confidential and proprietary information of Deceval S.A.
 */
package com.deceval.auditoria;

import java.io.Serializable;

/**
 * Interfaz de la que deben heredar todos los VOs de la aplicación.
 * 
 * @version 1.0
 * @author Fredy Fonseca.
 */
public abstract class BaseDataVO implements Serializable{
	
	/*Metodo auditoria, en la clase VO se implementa devolviendo 
	String con el nombre de la tabla representada por el VO*/
	public abstract String getNombreTablaVO();
	
}