package com.deceval.auditoria.daccess.roe.negocio;

import java.util.Collection;

import com.deceval.auditoria.daccess.base.BaseROE;
import com.deceval.auditoria.dto.EstructuraConsultaDTO;
import com.deceval.auditoria.dto.EstructuraDetalleLogDTO;
import com.deceval.auditoria.exception.DAOException;

public interface LogHistorialROE extends BaseROE {

	/**
	 * Devuelve la lista de los detalles de los logs
	 * @param Long idTraza
	 * @return Collection de objetos EstructuraDetalleLogDTO
	 * @author gmarroquin
	 * @throws DAOException 
	 */
	public Collection<EstructuraDetalleLogDTO> obtenerListaDetalleLogs(Long idTraza) throws DAOException; 	
	
	/**
	 * Devuelve la lista de los detalles de los logs
	 * @param EstructuraDetalleLogDTO estructuraDetalleLogDTO
	 * @return Collection de objetos EstructuraDetalleLogDTO
	 * @author gmarroquin
	 * @throws DAOException 
	 */	
	public Collection<EstructuraDetalleLogDTO> obtenerListaDetalleLogsByEstructuraConsultaDTO(
			EstructuraConsultaDTO estructuraConsultaDTO) throws DAOException; 
	
}
