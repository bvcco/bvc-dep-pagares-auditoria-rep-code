package com.deceval.auditoria.dto;

import java.util.List;

import com.deceval.auditoria.BaseDataDTO;
import com.deceval.auditoria.vo.LogHistorialVO;
import com.deceval.auditoria.vo.ObjetoVO;

public class EstructuraListaMsgDTO  implements BaseDataDTO {
	
	private static final long serialVersionUID = 1L;
	
	private ObjetoVO objetoVO;
	private List<LogHistorialVO> listaLogHistorialVO;
	
	
	public ObjetoVO getObjetoVO() {
		return objetoVO;
	}
	public void setObjetoVO(ObjetoVO objetoVO) {
		this.objetoVO = objetoVO;
	}
	public List<LogHistorialVO> getListaLogHistorialVO() {
		return listaLogHistorialVO;
	}
	public void setListaLogHistorialVO(List<LogHistorialVO> listaLogHistorialVO) {
		this.listaLogHistorialVO = listaLogHistorialVO;
	}
	
}
