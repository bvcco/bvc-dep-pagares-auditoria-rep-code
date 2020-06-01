package com.deceval.auditoria.dto;

import java.util.Collection;

import com.deceval.auditoria.BaseDataDTO;
import com.deceval.auditoria.vo.ObjetoAtributoVO;
import com.deceval.auditoria.vo.ObjetoVO;

public class EstructuraTablaDTO implements BaseDataDTO {
	
	private static final long serialVersionUID = 1L;
	
	private ObjetoVO tabla;
	private Collection<ObjetoAtributoVO> atributos;
	
	
	public ObjetoVO getTabla() {
		return tabla;
	}
	public void setTabla(ObjetoVO tabla) {
		this.tabla = tabla;
	}
	public Collection<ObjetoAtributoVO> getAtributos() {
		return atributos;
	}
	public void setAtributos(Collection<ObjetoAtributoVO> atributos) {
		this.atributos = atributos;
	}

}
