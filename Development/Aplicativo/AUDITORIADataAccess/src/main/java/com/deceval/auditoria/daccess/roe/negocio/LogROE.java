package com.deceval.auditoria.daccess.roe.negocio;

import java.util.Collection;

import com.deceval.auditoria.daccess.base.BaseROE;
import com.deceval.auditoria.dto.EstructuraConsultaDTO;
import com.deceval.auditoria.dto.EstructuraLogDTO;
import com.deceval.auditoria.exception.DAOException;

public interface LogROE extends BaseROE {
	public Collection<EstructuraLogDTO> obtenerListaLogs(EstructuraConsultaDTO estructuraConsultaDTO) throws DAOException; 
	
	public Collection<String> obtenerListaCodigoOrigen(
			EstructuraConsultaDTO estructuraConsultaDTO) throws DAOException;	
}
