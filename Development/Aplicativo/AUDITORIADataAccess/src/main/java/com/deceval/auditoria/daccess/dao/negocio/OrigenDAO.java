package com.deceval.auditoria.daccess.dao.negocio;

import java.util.Collection;

import com.deceval.auditoria.daccess.base.BaseDAO;
import com.deceval.auditoria.exception.DAOException;
import com.deceval.auditoria.vo.OrigenVO;

public interface OrigenDAO extends BaseDAO<OrigenVO> {
	
	public OrigenVO findByConstanteReferencia(OrigenVO llave) throws DAOException;
	
	public Collection<OrigenVO> findByIdAplicacion(Integer idAplicacion) throws DAOException;
	
}
