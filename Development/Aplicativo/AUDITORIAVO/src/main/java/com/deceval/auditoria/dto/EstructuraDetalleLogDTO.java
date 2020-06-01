package com.deceval.auditoria.dto;

import java.util.Collection;

import com.deceval.auditoria.BaseDataDTO;
import com.deceval.auditoria.vo.ObjetoVO;

public class EstructuraDetalleLogDTO implements BaseDataDTO {

	private static final long serialVersionUID = 1L;
	
	private Collection<EstructuraDetalleDetalleLogDTO> detalle;
	private ObjetoVO objetoVO;

	/**
	 * @return the detalle
	 */
	public Collection<EstructuraDetalleDetalleLogDTO> getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(Collection<EstructuraDetalleDetalleLogDTO> detalle) {
		this.detalle = detalle;
	}

	/**
	 * @return the objetoVO
	 */
	public ObjetoVO getObjetoVO() {
		return objetoVO;
	}

	/**
	 * @param objetoVO the objetoVO to set
	 */
	public void setObjetoVO(ObjetoVO objetoVO) {
		this.objetoVO = objetoVO;
	}
}
