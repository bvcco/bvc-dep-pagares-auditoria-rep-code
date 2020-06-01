package com.deceval.auditoria.dto;

import java.util.Collection;

import com.deceval.auditoria.BaseDataDTO;
import com.deceval.auditoria.vo.LogHistorialVO;
import com.deceval.auditoria.vo.LogVO;
import com.deceval.auditoria.vo.ObjetoAtributoVO;

public class EstructuraDetalleDetalleLogDTO implements BaseDataDTO {
	
	private static final long serialVersionUID = 1L;
	
	private ObjetoAtributoVO objetoAtributoVO;
	private Collection<LogHistorialVO> coleccionLogHistorial;
	private Collection<LogVO> coleccionLogVO;
		
	/**
	 * @return the objetoAtributoVO
	 */
	public ObjetoAtributoVO getObjetoAtributoVO() {
		return objetoAtributoVO;
	}
	/**
	 * @param objetoAtributoVO the objetoAtributoVO to set
	 */
	public void setObjetoAtributoVO(ObjetoAtributoVO objetoAtributoVO) {
		this.objetoAtributoVO = objetoAtributoVO;
	}
	/**
	 * @return the coleccionLogHistorial
	 */
	public Collection<LogHistorialVO> getColeccionLogHistorial() {
		return coleccionLogHistorial;
	}
	/**
	 * @param coleccionLogHistorial the coleccionLogHistorial to set
	 */
	public void setColeccionLogHistorial(
			Collection<LogHistorialVO> coleccionLogHistorial) {
		this.coleccionLogHistorial = coleccionLogHistorial;
	}
	/**
	 * @return the coleccionLogVO
	 */
	public Collection<LogVO> getColeccionLogVO() {
		return coleccionLogVO;
	}
	/**
	 * @param coleccionLogVO the coleccionLogVO to set
	 */
	public void setColeccionLogVO(Collection<LogVO> coleccionLogVO) {
		this.coleccionLogVO = coleccionLogVO;
	}

}
