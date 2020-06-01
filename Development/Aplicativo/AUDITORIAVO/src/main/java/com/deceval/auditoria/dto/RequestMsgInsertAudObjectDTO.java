package com.deceval.auditoria.dto;

import java.util.List;

import com.deceval.auditoria.BaseDataDTO;
import com.deceval.auditoria.vo.LogVO;

public class RequestMsgInsertAudObjectDTO implements BaseDataDTO {
	
	private static final long serialVersionUID = 1L;
	
	private String constanteReferenciaOperacion;
	private String constanteReferenciaOrigen;
	private LogVO logVO;
	private List<EstructuraListaMsgDTO> listaEstructurasTablas;
	
	
	public LogVO getLogVO() {
		return logVO;
	}
	public void setLogVO(LogVO logVO) {
		this.logVO = logVO;
	}
	public String getConstanteReferenciaOperacion() {
		return constanteReferenciaOperacion;
	}
	public void setConstanteReferenciaOperacion(String constanteReferenciaOperacion) {
		this.constanteReferenciaOperacion = constanteReferenciaOperacion;
	}
	public String getConstanteReferenciaOrigen() {
		return constanteReferenciaOrigen;
	}
	public void setConstanteReferenciaOrigen(String constanteReferenciaOrigen) {
		this.constanteReferenciaOrigen = constanteReferenciaOrigen;
	}
	public List<EstructuraListaMsgDTO> getListaEstructurasTablas() {
		return listaEstructurasTablas;
	}
	public void setListaEstructurasTablas(
			List<EstructuraListaMsgDTO> listaEstructurasTablas) {
		this.listaEstructurasTablas = listaEstructurasTablas;
	}

}
