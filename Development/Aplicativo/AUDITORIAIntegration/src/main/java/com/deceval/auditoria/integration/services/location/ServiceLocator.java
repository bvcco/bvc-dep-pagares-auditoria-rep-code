/*
 * ServiceLocator
 * Date 13/08/2008
 * Copyright (c) 2008
 * Company: Deceval S.A
 * All Rights Reserved.
 * This software is the confidential and proprietary information of Deceval S.A.
 */
package com.deceval.auditoria.integration.services.location;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.deceval.auditoria.exception.DAOException;
import com.deceval.auditoria.exception.ServiceException;
import com.deceval.auditoria.integration.remote.DecevalRemote;
import com.deceval.auditoria.util.constants.Constants;
import com.deceval.auditoria.util.properties.PropertiesLoader;

/**
 * Clase que permite ubicar las conexiones a base de datos y las instancias de
 * EJBs por JNDI dentro de un contenedor.
 * 
 * @version 1.0
 * @author Oscar Fernando Gil, Johann Camilo Olarte Diaz
 */
public class ServiceLocator {

	private static ServiceLocator instance;    
    private Context ctx;
	
	private static final String LOCAL = "LOCAL"; 
    
	/**
	 * Construtor de la clase <code>ServiceLocator</code>.
	 * @throws ServiceException
	 */
    private ServiceLocator() throws ServiceException {        

        try {
            if(PropertiesLoader.loadProperty(Constants.CONTEXT_TYPE).equalsIgnoreCase(LOCAL)){
        		ctx = new InitialContext();
        	}else{
        		ctx = getInitialContext(
        				PropertiesLoader.loadProperty(Constants.PROVIDER_URL),
        				PropertiesLoader.loadProperty(Constants.SECURITY_PRINCIPAL), 
        				PropertiesLoader.loadProperty(Constants.SECURITY_CREDENTIALS));
        	}
        } catch (NamingException e) {
            throw new ServiceException("LSRV01","No se ha podido generar el contexto inicial", e);
        }
    }
    
    /**
     * Método que recupera la instancia del <code>ServiceLocator</code>.
     * @return
     * @throws ServiceException
     */
    static public ServiceLocator getInstance()
    throws ServiceException {
	    if (instance == null) 
	    	instance = new ServiceLocator();
	    return instance;
    }
    
    
    /**
     * Método que recupera <code>DataSource</code> del contexto.
     * @param nombreDataSource
     * @return
     * @throws ServiceException
     */
    public DataSource getDataSource(String nombreDataSource)
    throws ServiceException {
	    try {
	        DataSource ds;
	        Object o = ctx.lookup(nombreDataSource);
	        ds = (DataSource) o;
	        return ds;
	    } catch (Exception e) {
	        throw new ServiceException("LSRV02", "No se ha encontrado la fuente de datos", e);
	    }
    }

    /**
     * 
     * @param tipoArchivo
     * @return
     * @throws ServiceException
     */
    public Connection getConnection() throws ServiceException {
	    try {
	        Connection conn = null;
		    String nombreDataSource = PropertiesLoader.loadProperty(Constants.AUDITORIA_DATASOURCE_JNDI_NAME);
		    DataSource ds = getDataSource(nombreDataSource);
	        conn = ds.getConnection();	            
	        return conn;
	    } catch (Exception e) {
	        throw new ServiceException("LSRV02","No se ha establecido la conexion con el Datasource: "+Constants.AUDITORIA_DATASOURCE_JNDI_NAME, e);
	    }
    }    
    
    
    /**
     * Metodo que obtiene de un contenedor EJBs que implementan
     * la interfaz <code>DecevalRemote</code>
     * @param nameReference
     * @return
     * @throws Exception
     */
    public DecevalRemote getDecevalRemote(String nameReference)
	throws Exception {	    
	        try {
	        	InitialContext context = new InitialContext();
	            DecevalRemote remoteHome = (DecevalRemote) context.lookup(nameReference);	            	
	            return remoteHome;
	        } catch (Exception e) {
	            throw new Exception(e.toString());
	        }	    
    }
    /**
	 * Metodo que cierra la conexión a la base de datos
	 * @param connection Define la conexión que debe cerrarse
	 * @throws DAOException
	 */
    public void closeConnection(Connection connection)throws DAOException{
		try {
            if (connection != null) {
            	connection.close();
            }
        } catch (SQLException sqle) {
           String mensajeError = "\nClase   : " + this.getClass().getName() +
                  "\nMétodo  : cerrarConexion(ResultSet rs, Statement ps, Connection con) " +
                  "\nMensaje Unico  :Imposible cerrar la conexión";
            throw new DAOException("ACTE08", mensajeError, sqle);
        }
	}
    /**
     * Método que permite recuperar un contexto remoto.
     * @param url
     * @param username
     * @param password
     * @return
     * @throws NamingException
     */
    private static InitialContext getInitialContext(String url, String username, String password) throws NamingException {

		 Hashtable<String, String> env = new Hashtable<String, String>();

		 env.put(Context.INITIAL_CONTEXT_FACTORY, 
				 PropertiesLoader.loadProperty(Constants.INITIAL_CONTEXT_FACTORY));

		 env.put(Context.PROVIDER_URL, url) ;

		 env.put(Context.SECURITY_PRINCIPAL, username);

		 env.put(Context.SECURITY_CREDENTIALS, password);

		 return new InitialContext(env);

	}
}
