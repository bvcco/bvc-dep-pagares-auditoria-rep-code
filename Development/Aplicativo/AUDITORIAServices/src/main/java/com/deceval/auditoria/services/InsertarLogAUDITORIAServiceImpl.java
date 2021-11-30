/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deceval.auditoria.services;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import com.deceval.auditoria.dto.EstructuraListaMsgDTO;
import com.deceval.auditoria.dto.RequestMsgInsertAudObjectDTO;
import com.deceval.auditoria.integration.NegocioDelegate;
import com.deceval.auditoria.util.log.AUDITORIALogger;
import com.deceval.auditoria.vo.LogHistorialVO;
import com.deceval.auditoria.vo.LogVO;
import com.deceval.auditoria.vo.ObjetoVO;
import javax.jws.HandlerChain;
/**
 *
 * @author Capacitación
 */
@WebService(endpointInterface = "com.deceval.auditoria.services.InsertarLogAUDITORIAPort", serviceName = "services/InsertarLogAUDITORIAService")

public class InsertarLogAUDITORIAServiceImpl implements InsertarLogAUDITORIAPort {

    @Override
    public InsertarLogResponseType insertarLog(InsertarLogRequestType request) throws FaultMsg {
        String resultado = "ERROR-000, General.";
        RequestMsgInsertAudObjectDTO reqMgsObj = new RequestMsgInsertAudObjectDTO();
        LogVO log = new LogVO();
        InsertarLogResponseType responseToSend = new InsertarLogResponseType();
        try {
            //Bloque para el mapeo de datos del LOG general
            reqMgsObj.setConstanteReferenciaOperacion(request.getConstanteReferenciaOperacion());
            reqMgsObj.setConstanteReferenciaOrigen(request.getConstanteReferenciaOrigen());
            log.setCodigoOrigen((request.getCodigoOrigen() != null && request.getCodigoOrigen() != null) ? request.getCodigoOrigen() : "");
            log.setIdUsuario(request.getIdUsuario());
            log.setUserName(request.getUserName());
            log.setIpUsuario(request.getIpUsuario());
            log.setIpServidor(request.getIpServidor());
            log.setDescripcionAnotacion(request.getDescripcionAnotacion());
            AUDITORIALogger.getInstance().infoMessage("descripcion en el request: OJO RAYAR DESCRIPCION" + request.getDescripcionAnotacion());
            System.out.println("descripcion en el request: OJO RAYAR DESCRIPCION" + request.getDescripcionAnotacion());


            //Bloque para el mapeo de datos del LOG HISTORICO
            List<EstructuraListaMsgDTO> listaEstructuraTablas = null;
            if (request.getListaEstructuras() != null && request.getListaEstructuras().getEstructuraTabla().size() > 0) {
                listaEstructuraTablas = new ArrayList<EstructuraListaMsgDTO>();
                int totalVOs = request.getListaEstructuras().getEstructuraTabla().size();
                for (int contadorVOs = 0; contadorVOs < totalVOs; contadorVOs++) {
                    EstructuraListaMsgDTO estructuraListaMsgDTO = new EstructuraListaMsgDTO();
                    List<LogHistorialVO> listaHistorial = new ArrayList<LogHistorialVO>();
                    ObjetoVO objVO = new ObjetoVO();
                    objVO.setNombreTabla(request.getListaEstructuras().getEstructuraTabla().get(contadorVOs).getNombreTabla());
                    int totalCampos = request.getListaEstructuras().getEstructuraTabla().get(contadorVOs).getNombreCampo().size();
                    for (int contadorCampos = 0; contadorCampos < totalCampos; contadorCampos++) {
                        LogHistorialVO registro = new LogHistorialVO();
                        registro.setNombreCampo(request.getListaEstructuras().getEstructuraTabla().get(contadorVOs).getNombreCampo().get(contadorCampos));
                        registro.setValorAtributo(request.getListaEstructuras().getEstructuraTabla().get(contadorVOs).getValorCampo().get(contadorCampos));
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
                AUDITORIALogger.getInstance().infoMessage("descripcion en el request: OJO RAYAR RESULTADO" + request.getDescripcionAnotacion());
                System.out.println("descripcion en el request: OJO RAYAR RESULTADO" + request.getDescripcionAnotacion());

                AUDITORIALogger.getInstance().infoMessage("descripcion en el request: DEL MENSAJE QUE SE ENVIA" + reqMgsObj.getLogVO().getDescripcionAnotacion());
                System.out.println("descripcion en el request: OJO RAYAR DESCRIPCION" + reqMgsObj.getLogVO().getDescripcionAnotacion());

            } catch (Exception e) {
                e.printStackTrace();
                resultado = "ERROR-001AUD, al enviar a cola JMS";
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultado = "ERROR-002, faltan datos para la anotaci�n en LOG";
        }
        //Envio de respuesta al WS
//        responseToSend.setInsertarLogResponse(new InsertarLogResponseType());
           responseToSend.setResultadoCreacion(resultado);
//        responseToSend.getInsertarLogResponse().getResultadoCreacion().setResultadoCreacionType(resultado);
        return responseToSend;

    }

}
