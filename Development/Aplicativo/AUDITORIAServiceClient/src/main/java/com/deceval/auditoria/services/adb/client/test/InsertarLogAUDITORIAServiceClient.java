package com.deceval.auditoria.services.adb.client.test;

import java.util.ArrayList;
import java.util.List;

import com.deceval.auditoria.util.constants.Constants;
import com.deceval.auditoria.util.properties.PropertiesLoader;

public class InsertarLogAUDITORIAServiceClient {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		OperacionVO operacion = new OperacionVO();
		operacion.setNumero_operacion(new Long("2008122300002"));
		operacion.setCodigo_operacion(new Long(13));
		operacion.setCodigo_estado(new Integer(12));
		operacion.setCodigo_fungible(new Integer(340));
		operacion.setNemonico("prueba4");
		operacion.setValor_nominal(new BigDecimal(60000000));
		
		*/
		List listaVOs = new ArrayList();
		//listaVOs.add(operacion);
		
		
		System.out.println(com.deceval.auditoria.services.adb.client.InsertarLogAUDITORIAServiceClient.insertarLogAuditoria("com.deceval.registro.web.backingbean.vendedor.negociacion.ModificarOperacionRechazadaJSFBean.GuardarModificacionOperacionRechazada",
																															"registro.origen.operacion", 
																															"2008122300002", 
																															6, 
																															"prueba1",
																															"172.31.85.195", 
																															"172.31.85.198", 
																															"Se modifica operacion", 
																															listaVOs, 
																															PropertiesLoader.loadProperty(Constants.CONSTANTE_END_POINT_INSERTAR_LOG_AUDITORIA)));
	}
}
