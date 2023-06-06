/*
 * DAOFactory
 * Date 04/09/2008
 * Copyright (c) 2008
 * Company: Deceval S.A
 * All Rights Reserved.
 * This software is the confidential and proprietary information of Deceval S.A.
 */
package com.deceval.auditoria.daccess.dao;

import java.sql.Connection;

import com.deceval.auditoria.daccess.dao.negocio.AccionDAO;
import com.deceval.auditoria.daccess.dao.negocio.AplicacionDAO;
import com.deceval.auditoria.daccess.dao.negocio.HomologacionDAO;
import com.deceval.auditoria.daccess.dao.negocio.LogDAO;
import com.deceval.auditoria.daccess.dao.negocio.LogHistorialDAO;
import com.deceval.auditoria.daccess.dao.negocio.ModuloDAO;
import com.deceval.auditoria.daccess.dao.negocio.ObjetoAtributoDAO;
import com.deceval.auditoria.daccess.dao.negocio.ObjetoDAO;
import com.deceval.auditoria.daccess.dao.negocio.OperacionDAO;
import com.deceval.auditoria.daccess.dao.negocio.TipoCampoDAO;
import com.deceval.auditoria.daccess.dao.negocio.OrigenDAO;
import com.deceval.auditoria.daccess.oracle.dao.OracleDAOFactory;
import com.deceval.auditoria.util.constants.Constants;

/**
 * Clase que implementa el patron DAOFactory para obtener los DAOS de la aplicación. 
 * Solo declara los métodos que debe implementar una fábrica de DAOS especializada.
 * @version 1.0
 * @author Fredy Eduardo Fonseca.
 */
public abstract class DAOFactory {

	/**
	 * Metodo para obtener instancia DAO Factory
	 * 
	 * @param connection    Conexion a base de datos que usarán los DAOS.
	 * @return DAOFactory
	 */
	public final static DAOFactory getDAOFactory(Connection connection, String dataBaseProvider) throws Exception {
		if(dataBaseProvider.equals(Constants.DATA_BASE_PROVIDER_ORACLE)){
			return new OracleDAOFactory(connection);
		} else 
			return null;
	}
	
	/**
	 * Permite obtener una instancia de una clase que implemente AccionDAO
	 * 
	 * @return {@link AccionDAO}
	 */
	public abstract AccionDAO getAccionDAO();
	
	/**
	 * Permite obtener una instancia de una clase que implemente AplicacionDAO
	 * 
	 * @return {@link AplicacionDAO}
	 */
	public abstract AplicacionDAO getAplicacionDAO();
	
	/**
	 * Permite obtener una instancia de una clase que implemente LogDAO
	 * 
	 * @return {@link LogDAO}
	 */
	public abstract LogDAO getLogDAO();
	
	/**
	 * Permite obtener una instancia de una clase que implemente ModuloDAO
	 * 
	 * @return {@link ModuloDAO}
	 */
	public abstract ModuloDAO getModuloDAO();
	
	/**
	 * Permite obtener una instancia de una clase que implemente OperacionDAO
	 * 
	 * @return {@link OperacionDAO}
	 */
	public abstract OperacionDAO getOperacionDAO();
	
	/**
	 * Permite obtener una instancia de una clase que implemente OrigenDAO
	 * 
	 * @return {@link OrigenDAO}
	 */
	public abstract OrigenDAO getOrigenDAO();
	
	/**
	 * Permite obtener una instancia de una clase que implemente OrigenDAO
	 * 
	 * @return {@link OrigenDAO}
	 */
	public abstract ObjetoDAO getObjetoDAO();
	
	/**
	 * Permite obtener una instancia de una clase que implemente OrigenDAO
	 * 
	 * @return {@link OrigenDAO}
	 */
	public abstract ObjetoAtributoDAO getObjetoAtributoDAO();
	
	/**
	 * Permite obtener una instancia de una clase que implemente OrigenDAO
	 * 
	 * @return {@link OrigenDAO}
	 */
	public abstract LogHistorialDAO getLogHistorialDAO();
	
	/**
	 * Permite obtener una instancia de una clase que implemente OrigenDAO
	 * 
	 * @return {@link OrigenDAO}
	 */
	public abstract TipoCampoDAO getTipoCampoDAO();
	
	/**
	 * Permite obtener una instancia de una clase que implemente HomologacionDAO
	 * 
	 * @return {@link HomologacionDAO}
	 */
	public abstract HomologacionDAO getHomologacionDAO();
	

}
