package com.deceval.auditoria.daccess.roe.negocio;

import com.deceval.auditoria.daccess.base.BaseROE;
import com.deceval.auditoria.dto.EstructuraOperacionDTO;
import com.deceval.auditoria.exception.DAOException;

public interface OperacionROE extends BaseROE{
	
	public EstructuraOperacionDTO consultarEstructuraByIdOperacion(EstructuraOperacionDTO estructura) throws DAOException; 

}
