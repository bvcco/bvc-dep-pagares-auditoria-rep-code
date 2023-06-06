package com.deceval.auditoria.daccess.dao.negocio;

import com.deceval.auditoria.daccess.base.BaseDAO;
import com.deceval.auditoria.exception.DAOException;
import com.deceval.auditoria.vo.HomologacionVO;

public interface HomologacionDAO extends BaseDAO<HomologacionVO> {
	public HomologacionVO findByIdTblAuditAndValAuditAndIdTblRef(
			HomologacionVO llave) throws DAOException; 	
}
