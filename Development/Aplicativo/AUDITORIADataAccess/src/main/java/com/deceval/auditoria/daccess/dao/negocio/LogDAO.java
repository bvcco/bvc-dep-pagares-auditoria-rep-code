package com.deceval.auditoria.daccess.dao.negocio;

import com.deceval.auditoria.daccess.base.BaseDAO;
import com.deceval.auditoria.exception.DAOException;
import com.deceval.auditoria.vo.LogVO;

public interface LogDAO extends BaseDAO<LogVO> {
	
	public Long findMaxIdTraza() throws DAOException; 
	
}


