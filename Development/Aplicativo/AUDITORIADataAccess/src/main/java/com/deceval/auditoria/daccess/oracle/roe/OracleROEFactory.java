
package com.deceval.auditoria.daccess.oracle.roe;

import java.sql.Connection;

import com.deceval.auditoria.daccess.oracle.roe.negocio.OracleLogHistorialROE;
import com.deceval.auditoria.daccess.oracle.roe.negocio.OracleLogROE;
import com.deceval.auditoria.daccess.oracle.roe.negocio.OracleObjetoROE;
import com.deceval.auditoria.daccess.oracle.roe.negocio.OracleOperacionROE;
import com.deceval.auditoria.daccess.roe.ROEFactory;
import com.deceval.auditoria.daccess.roe.negocio.LogHistorialROE;
import com.deceval.auditoria.daccess.roe.negocio.LogROE;
import com.deceval.auditoria.daccess.roe.negocio.ObjetoROE;
import com.deceval.auditoria.daccess.roe.negocio.OperacionROE;

/**
 * Clase que implementa la clase abstracta ROEFactory, que define los
 * ROEs de la aplicacion
 * 
 * @version 1.0
 * @author Fredy Fonseca.
 */
public class OracleROEFactory extends ROEFactory{

	private Connection connection = null;
	
	public OracleROEFactory(Connection connection){
		this.connection = connection;
	}

	@Override
	public OperacionROE getOperacionROE() {
		return new OracleOperacionROE(connection);
	}
	
	@Override
	public ObjetoROE getObjetoROE() {
		return new OracleObjetoROE(connection);
	}

	@Override
	public LogROE getLogROE() {
		return new OracleLogROE(connection);
	}
     
	@Override
	public LogHistorialROE getLogHistorialROE() {
		return new OracleLogHistorialROE(connection);
	}	
}
