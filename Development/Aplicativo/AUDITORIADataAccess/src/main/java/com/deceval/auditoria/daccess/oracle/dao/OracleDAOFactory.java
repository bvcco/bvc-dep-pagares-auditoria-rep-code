/*
 * SybaseDAOFactory
 * Date 13/08/2008
 * Copyright (c) 2008
 * Company: Deceval S.A
 * All Rights Reserved.
 * This software is the confidential and proprietary information of Deceval S.A.
 */
package com.deceval.auditoria.daccess.oracle.dao;

import java.sql.Connection;

import com.deceval.auditoria.daccess.dao.DAOFactory;
import com.deceval.auditoria.daccess.dao.negocio.AccionDAO;
import com.deceval.auditoria.daccess.dao.negocio.AplicacionDAO;
import com.deceval.auditoria.daccess.dao.negocio.HomologacionDAO;
import com.deceval.auditoria.daccess.dao.negocio.LogDAO;
import com.deceval.auditoria.daccess.dao.negocio.LogHistorialDAO;
import com.deceval.auditoria.daccess.dao.negocio.ModuloDAO;
import com.deceval.auditoria.daccess.dao.negocio.ObjetoAtributoDAO;
import com.deceval.auditoria.daccess.dao.negocio.ObjetoDAO;
import com.deceval.auditoria.daccess.dao.negocio.OperacionDAO;
import com.deceval.auditoria.daccess.dao.negocio.OrigenDAO;
import com.deceval.auditoria.daccess.dao.negocio.TipoCampoDAO;
import com.deceval.auditoria.daccess.oracle.dao.negocio.OracleAccionDAO;
import com.deceval.auditoria.daccess.oracle.dao.negocio.OracleAplicacionDAO;
import com.deceval.auditoria.daccess.oracle.dao.negocio.OracleHomologacionDAO;
import com.deceval.auditoria.daccess.oracle.dao.negocio.OracleLogDAO;
import com.deceval.auditoria.daccess.oracle.dao.negocio.OracleLogHistorialDAO;
import com.deceval.auditoria.daccess.oracle.dao.negocio.OracleModuloDAO;
import com.deceval.auditoria.daccess.oracle.dao.negocio.OracleObjetoAtributoDAO;
import com.deceval.auditoria.daccess.oracle.dao.negocio.OracleObjetoDAO;
import com.deceval.auditoria.daccess.oracle.dao.negocio.OracleOperacionDAO;
import com.deceval.auditoria.daccess.oracle.dao.negocio.OracleOrigenDAO;
import com.deceval.auditoria.daccess.oracle.dao.negocio.OracleTipoCampoDAO;

/**
 * Clase especializada para el manejo de DAOS, de Oracle.
 * 
 * @version 1.0
 * @author ffonsacos.
 */
public class OracleDAOFactory extends DAOFactory {

	/**
	 * Conexion jdbc que usaran todos los DAOS retornados por esta Fabrica.
	 */
	private Connection connection = null;

	public OracleDAOFactory(Connection connection) {
		this.connection = connection;
	}

	
	public AccionDAO getAccionDAO() {
		return new OracleAccionDAO(connection);
	}
	
	
	public AplicacionDAO getAplicacionDAO() {
		return new OracleAplicacionDAO(connection);
	}
	
	
	public LogDAO getLogDAO() {
		return new OracleLogDAO(connection);
	}
	
	
	public ModuloDAO getModuloDAO() {
		return new OracleModuloDAO(connection);
	}
	
	
	public OperacionDAO getOperacionDAO() {
		return new OracleOperacionDAO(connection);
	}
	
	
	public OrigenDAO getOrigenDAO() {
		return new OracleOrigenDAO(connection);
	}
	
	public ObjetoDAO getObjetoDAO() {
		return new OracleObjetoDAO(connection);
	}
	
	public ObjetoAtributoDAO getObjetoAtributoDAO() {
		return new OracleObjetoAtributoDAO(connection);
	}
	
	public TipoCampoDAO getTipoCampoDAO() {
		return new OracleTipoCampoDAO(connection);
	}
	
	public LogHistorialDAO getLogHistorialDAO() {
		return new OracleLogHistorialDAO(connection);
	}
	
	public HomologacionDAO getHomologacionDAO() {
		return new OracleHomologacionDAO(connection);
	}
}
