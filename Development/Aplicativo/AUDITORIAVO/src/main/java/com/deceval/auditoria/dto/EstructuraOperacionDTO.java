package com.deceval.auditoria.dto;

import com.deceval.auditoria.BaseDataDTO;
import com.deceval.auditoria.vo.OperacionVO;
import com.deceval.auditoria.vo.ModuloVO;
import com.deceval.auditoria.vo.AplicacionVO;
import com.deceval.auditoria.vo.AccionVO;

public class EstructuraOperacionDTO implements BaseDataDTO {
	
	private static final long serialVersionUID = 1L;
	
	private OperacionVO operacionVO;
	private ModuloVO moduloVO;
	private AplicacionVO aplicacionVO;
	private AccionVO accionVO;
	
	
	public OperacionVO getOperacionVO() {
		return operacionVO;
	}
	public void setOperacionVO(OperacionVO operacionVO) {
		this.operacionVO = operacionVO;
	}
	public ModuloVO getModuloVO() {
		return moduloVO;
	}
	public void setModuloVO(ModuloVO moduloVO) {
		this.moduloVO = moduloVO;
	}
	public AplicacionVO getAplicacionVO() {
		return aplicacionVO;
	}
	public void setAplicacionVO(AplicacionVO aplicacionVO) {
		this.aplicacionVO = aplicacionVO;
	}
	public AccionVO getAccionVO() {
		return accionVO;
	}
	public void setAccionVO(AccionVO accionVO) {
		this.accionVO = accionVO;
	}

}
