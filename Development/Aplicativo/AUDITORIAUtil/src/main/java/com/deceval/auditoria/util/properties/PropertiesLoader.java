/* @(#)PropertiesLoader.java 1.0 08/04/2007
 *
 * Copyright (c) Deceval S.A.
 * All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Deceval S.A.
 */

package com.deceval.auditoria.util.properties;

import java.util.Properties;
import java.io.*;

/**
 * A utilitary class which loads the aplication properties, and lets retrieve
 * a property by its name. It implements the singleton pattern.
 * 
 * The parameter auditoria.properties.file must be provided when the program starts,
 * using the syntax -Dauditoria.properties.file=Path to your properties
 * 
 * @version 1.0 08/04/2007
 * @author Johann Camilo Olarte Diaz
 */

public class PropertiesLoader {
	
	/**
	 * Variable to be loaded when the VM starts.
	 */
	public final static String PROPERTIES_FILE="auditoria.properties.file";
	
	/**
	 * Singleton instance of the class
	 */
    private static PropertiesLoader propsLoader = null;
    
    /**
     * Properties loaded
     */
    private Properties properties=null;
    
    /**
     * Creates a PropertiesLoader by loading a properties file. 
     */
    private PropertiesLoader() throws Exception{
    	loadPropertiesFile();    	
    }
    
    /**
     * Returns the singleton instance.
     * @return Singleton Instance
     */
    private static PropertiesLoader getInstance() throws Exception{

        if (propsLoader == null) {
            propsLoader = new PropertiesLoader();            
        }

        return propsLoader;
    }
    
    /**
     * Lets retrieve a property by its name.
     * @param key Key to retrieve
     * @return Key value as String 
     */
    public static String loadProperty(String key){
    	String value=null;
    	try{
    		value=getInstance().properties.getProperty(key);
    	}catch(Exception e){
    		e.printStackTrace();    		
    	}
    	return value;
    }

    /**
     * Loads the properties from the configuration file.
     */
    private void loadPropertiesFile() throws Exception{    	
        try {        	
        	Properties p = System.getProperties();
        	String filePath=(String)p.get(PROPERTIES_FILE);
        	if(filePath!=null){
        		Properties props = new Properties();
        		//InputStream instr = this.getClass().getResourceAsStream(filePath);
        		InputStream instr = new FileInputStream(filePath);
        		props.load(instr);
        		properties=props;
        	}else{
        		throw new Exception("The properties file is not configured yet, You must set "+PROPERTIES_FILE+" property with the syntax -D"+
        				PROPERTIES_FILE+"=Path to your properties.");
        	}       
        }catch (Exception e) {        	        
        	throw e;    
        }
    }
    /**
     * Forces the reloading of properties file by setting to null
     * the singleton instance.
     */
    public static void forcePropertiesFileReload(){
    	propsLoader=null;
    }

}

