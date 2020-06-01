package com.deceval.auditoria.dto;

import com.deceval.auditoria.BaseDataDTO;
import com.deceval.auditoria.vo.LogVO;
import com.deceval.auditoria.vo.OperacionVO;
import com.deceval.auditoria.vo.OrigenVO;

public class EstructuraLogDTO implements BaseDataDTO {

	private static final long serialVersionUID = 1L;
	
	private LogVO logVO;
	private OperacionVO operacionVO;
	private OrigenVO origenVO;
	
	/**
	 * @return the logVO
	 */
	public LogVO getLogVO() {
		return logVO;
	}
	/**
	 * @param logVO the logVO to set
	 */
	public void setLogVO(LogVO logVO) {
		this.logVO = logVO;
	}
	/**
	 * @return the operacionVO
	 */
	public OperacionVO getOperacionVO() {
		return operacionVO;
	}
	/**
	 * @param operacionVO the operacionVO to set
	 */
	public void setOperacionVO(OperacionVO operacionVO) {
		this.operacionVO = operacionVO;
	}
	/**
	 * @return the origenVO
	 */
	public OrigenVO getOrigenVO() {
		return origenVO;
	}
	/**
	 * @param origenVO the origenVO to set
	 */
	public void setOrigenVO(OrigenVO origenVO) {
		this.origenVO = origenVO;
	}
}
