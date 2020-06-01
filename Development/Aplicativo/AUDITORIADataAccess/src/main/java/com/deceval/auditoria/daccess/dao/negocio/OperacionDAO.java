package com.deceval.auditoria.daccess.dao.negocio;

import java.util.Collection;

import com.deceval.auditoria.daccess.base.BaseDAO;
import com.deceval.auditoria.exception.DAOException;
import com.deceval.auditoria.vo.OperacionVO;

public interface OperacionDAO extends BaseDAO<OperacionVO> {
	
	public OperacionVO findByConstanteReferencia(OperacionVO llave) throws DAOException;
	
	public Collection<OperacionVO> findByIdModulo(Integer idModulo) throws DAOException;	
	
}
