/*
 * ROEFactory
 * Date 13/08/2008
 * Copyright (c) 2008
 * Company: Deceval S.A
 * All Rights Reserved.
 * This software is the confidential and proprietary information of Deceval S.A.
 */
package com.deceval.auditoria.daccess.roe;

import java.sql.Connection;

import com.deceval.auditoria.daccess.oracle.roe.OracleROEFactory;
import com.deceval.auditoria.daccess.roe.negocio.LogHistorialROE;
import com.deceval.auditoria.daccess.roe.negocio.LogROE;
import com.deceval.auditoria.daccess.roe.negocio.ObjetoROE;
import com.deceval.auditoria.daccess.roe.negocio.OperacionROE;
import com.deceval.auditoria.util.constants.Constants;

/**
 * Clase que permite obtener los ROES de la aplicación. Solo declara los métodos
 * que debe implementar una fábrica de ROES especializada.
 * 
 * @version 1.0
 * @author Johann Camilo Olarte Díaz.
 */
public abstract class ROEFactory {

	/**
	 * Metodo para obtener instancia de la ROEFactory
	 * 
	 * @param connection Conexion a base de datos que usarán los DAOS.
	 * @return ROEFactory
	 */
	public final static ROEFactory getROEFactory(Connection connection, String dataBaseProvider) throws Exception {
		if(dataBaseProvider.equals(Constants.DATA_BASE_PROVIDER_ORACLE))
			return new OracleROEFactory(connection);
		else
			return null;
	}
	
	/**
	 * Permite obtener una instancia de una clase que implemente la interfaz OperacionROE
	 * 
	 * @return {@link OperacionROE}
	 */
	public abstract OperacionROE getOperacionROE();

	/**
	 * Permite obtener una instancia de una clase que implemente la interfaz ObjetoROE
	 * 
	 * @return {@link ObjetoROE}
	 */
	public abstract ObjetoROE getObjetoROE();
	
	/**
	 * Permite obtener una instancia de una clase que implemente la interfaz LogROE
	 * 
	 * @return {@link LogROE}
	 */
	public abstract LogROE getLogROE();
	
	/**
	 * Permite obtener una instancia de una clase que implemente la interfaz LogHistorialROE
	 * 
	 * @return {@link LogHistorialROE}
	 */
	public abstract LogHistorialROE getLogHistorialROE();		
}
