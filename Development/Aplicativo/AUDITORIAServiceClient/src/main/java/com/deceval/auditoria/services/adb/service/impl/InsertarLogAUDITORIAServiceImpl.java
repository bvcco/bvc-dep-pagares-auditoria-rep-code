package com.deceval.auditoria.services.adb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.deceval.auditoria.dto.EstructuraListaMsgDTO;
import com.deceval.auditoria.dto.RequestMsgInsertAudObjectDTO;
import com.deceval.auditoria.integration.NegocioDelegate;
import com.deceval.auditoria.services.adb.service.FaultMsg;
import com.deceval.auditoria.services.xsd.InsertarLogResponseType;
import com.deceval.auditoria.services.xsd.ResultadoCreacionType;
import com.deceval.auditoria.vo.LogHistorialVO;
import com.deceval.auditoria.vo.LogVO;
import com.deceval.auditoria.vo.ObjetoVO;

public class InsertarLogAUDITORIAServiceImpl {

	/**
	 * @param args
	 */
	public com.deceval.auditoria.services.xsd.InsertarLogResponse insertarLog( com.deceval.auditoria.services.xsd.InsertarLogRequest request) throws FaultMsg {
		String resultado = "ERROR-000, General.";
		RequestMsgInsertAudObjectDTO reqMgsObj = new RequestMsgInsertAudObjectDTO();
		LogVO log = new LogVO();
		com.deceval.auditoria.services.xsd.InsertarLogResponse responseToSend = new com.deceval.auditoria.services.xsd.InsertarLogResponse();
		try {
			//Bloque para el mapeo de datos del LOG general
			reqMgsObj.setConstanteReferenciaOperacion(request.getInsertarLogRequest().getConstanteReferenciaOperacion().getConstanteReferenciaOperacionType());
			reqMgsObj.setConstanteReferenciaOrigen(request.getInsertarLogRequest().getConstanteReferenciaOrigen().getConstanteReferenciaOrigenType());
			log.setCodigoOrigen((request.getInsertarLogRequest().getCodigoOrigen()!=null && request.getInsertarLogRequest().getCodigoOrigen().getCodigoOrigenType()!=null)?request.getInsertarLogRequest().getCodigoOrigen().getCodigoOrigenType():"");
			log.setIdUsuario(request.getInsertarLogRequest().getIdUsuario().getIdUsuarioType());
			log.setUserName(request.getInsertarLogRequest().getUserName().getUserNameType());
			log.setIpUsuario(request.getInsertarLogRequest().getIpUsuario().getIpUsuarioType());
			log.setIpServidor(request.getInsertarLogRequest().getIpServidor().getIpServidorType());
			log.setDescripcionAnotacion(request.getInsertarLogRequest().getDescripcionAnotacion().getDescripcionAnotacionType());
			
			//Bloque para el mapeo de datos del LOG HISTORICO
			List<EstructuraListaMsgDTO> listaEstructuraTablas = null;
			if(request.getInsertarLogRequest().getListaEstructuras() != null && request.getInsertarLogRequest().getListaEstructuras().getEstructuraTabla().length > 0){
				listaEstructuraTablas = new ArrayList<EstructuraListaMsgDTO>();
				int totalVOs = request.getInsertarLogRequest().getListaEstructuras().getEstructuraTabla().length;
				for (int contadorVOs = 0; contadorVOs < totalVOs; contadorVOs++){
					EstructuraListaMsgDTO estructuraListaMsgDTO = new EstructuraListaMsgDTO();
					List<LogHistorialVO> listaHistorial = new ArrayList<LogHistorialVO>();
					ObjetoVO objVO = new ObjetoVO();
					objVO.setNombreTabla(request.getInsertarLogRequest().getListaEstructuras().getEstructuraTabla()[contadorVOs].getNombreTabla().getNombreTablaType());
					int totalCampos = request.getInsertarLogRequest().getListaEstructuras().getEstructuraTabla()[contadorVOs].getNombreCampo().length;
					for (int contadorCampos = 0; contadorCampos < totalCampos ; contadorCampos++){
						LogHistorialVO registro = new LogHistorialVO();
						registro.setNombreCampo(request.getInsertarLogRequest().getListaEstructuras().getEstructuraTabla()[contadorVOs].getNombreCampo()[contadorCampos].getNombreCampoType());
						registro.setValorAtributo(request.getInsertarLogRequest().getListaEstructuras().getEstructuraTabla()[contadorVOs].getValorCampo()[contadorCampos].getValorCampoType());
						listaHistorial.add(registro);
					}
					estructuraListaMsgDTO.setObjetoVO(objVO);
					estructuraListaMsgDTO.setListaLogHistorialVO(listaHistorial);
					listaEstructuraTablas.add(estructuraListaMsgDTO);
				}
			}
			reqMgsObj.setLogVO(log);
			reqMgsObj.setListaEstructurasTablas(listaEstructuraTablas);
			
			//Envio a la cola de mensajeria
			try {
				NegocioDelegate delegate = new NegocioDelegate();
				resultado = delegate.sendAnotacionLog2Queue(reqMgsObj);
			} catch (Exception e) {
				e.printStackTrace();
				resultado = "ERROR-001AUD, al enviar a cola JMS";
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultado = "ERROR-002, faltan datos para la anotación en LOG";
		}
		//Envio de respuesta al WS
		responseToSend.setInsertarLogResponse(new InsertarLogResponseType());
		responseToSend.getInsertarLogResponse().setResultadoCreacion(new ResultadoCreacionType());
		responseToSend.getInsertarLogResponse().getResultadoCreacion().setResultadoCreacionType(resultado);
		return responseToSend;
	}
}
