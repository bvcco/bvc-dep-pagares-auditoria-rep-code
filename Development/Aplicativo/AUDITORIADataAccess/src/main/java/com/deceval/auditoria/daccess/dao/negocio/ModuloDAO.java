package com.deceval.auditoria.daccess.dao.negocio;

import java.util.Collection;

import com.deceval.auditoria.daccess.base.BaseDAO;
import com.deceval.auditoria.exception.DAOException;
import com.deceval.auditoria.vo.ModuloVO;

public interface ModuloDAO extends BaseDAO<ModuloVO> {
	
	public Collection<ModuloVO> findByIdAplicacion(Integer idAplicacion) throws DAOException;
	
}