package com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.comportamiento.producirdetalleresultadoconsulta.pororigen.convestructdelogdtoentabla;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.deceval.auditoria.dto.EstructuraDetalleDetalleLogDTO;
import com.deceval.auditoria.dto.EstructuraDetalleLogDTO;
import com.deceval.auditoria.vo.LogHistorialVO;

public class ObtenerTrazasOrigen {
	public Set<Long> trazas(EstructuraDetalleLogDTO entrada) {
		//Toca contar cuantos IdTraza hay (contándolos de forma única)
		Set<Long> conjunto = new HashSet<Long>();		 
		
		Collection<LogHistorialVO> coleccionLogHistorial;
		
		for (Iterator<EstructuraDetalleDetalleLogDTO> iterator = entrada.getDetalle().iterator(); iterator.hasNext();) {
			EstructuraDetalleDetalleLogDTO estructuraDetalleDetalleLogDTO = 
				(EstructuraDetalleDetalleLogDTO) iterator.next();
			coleccionLogHistorial = estructuraDetalleDetalleLogDTO.getColeccionLogHistorial();
			for (Iterator<LogHistorialVO> iterator2 = coleccionLogHistorial.iterator(); 
				 iterator2.hasNext();) {
				LogHistorialVO logHistorialVO = (LogHistorialVO) iterator2.next();
				conjunto.add(logHistorialVO.getIdTraza());				
			}
		}		
		
		return conjunto;
	}
}
