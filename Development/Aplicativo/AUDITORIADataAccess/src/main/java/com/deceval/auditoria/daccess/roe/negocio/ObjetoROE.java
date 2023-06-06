package com.deceval.auditoria.daccess.roe.negocio;

import com.deceval.auditoria.daccess.base.BaseROE;
import com.deceval.auditoria.dto.EstructuraTablaDTO;
import com.deceval.auditoria.exception.DAOException;


public interface ObjetoROE extends BaseROE{
	
	public EstructuraTablaDTO consultarEstructuraByIdAplicacionAndNombreTabla(EstructuraTablaDTO estructura) throws DAOException;
	
}
