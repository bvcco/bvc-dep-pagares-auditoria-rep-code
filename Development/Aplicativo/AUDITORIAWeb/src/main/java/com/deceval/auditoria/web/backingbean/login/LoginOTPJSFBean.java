package com.deceval.auditoria.web.backingbean.login;


import com.deceval.seguridad.comunes.dto.AutenticacionUsuarioDTO;
import com.deceval.seguridad.comunes.dto.RespuestaAutenticacionOTPDTO;
import com.deceval.seguridad.logica.AutenticacionOTP;
import com.deceval.seguridad.logica.excepciones.ExcepcionAcceso;
import com.deceval.auditoria.util.log.AUDITORIALogger;
import com.deceval.auditoria.web.backingbean.common.BaseJSFBean;

import java.io.Serializable;
import javax.faces.context.FacesContext;


/**
 *
 * @author lcastellanos
 */
public class LoginOTPJSFBean extends BaseJSFBean implements Serializable{
    
    private AutenticacionUsuarioDTO autenticacionUsuarioDTO = new AutenticacionUsuarioDTO();
    private String PAGINA_INICIO = "/faces/jsp/login/inicioAplicacion.jsp";
        
    private String mensajeDeError;

    public LoginOTPJSFBean() {                        
        this.autenticacionUsuarioDTO.setCodigoOtp("");
        this.autenticacionUsuarioDTO.setContrasena("");
        this.autenticacionUsuarioDTO.setIdentificacionUsuario("");

    }

    
    public String autenticarUsuario() throws Exception {
        AutenticacionOTP autenticacionOTP = new AutenticacionOTP();
        String resultado = null;

        try {

            RespuestaAutenticacionOTPDTO respuesta = autenticacionOTP.autenticarUsuario(this.autenticacionUsuarioDTO);
            if (respuesta.getAutenticado()) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("autenticadoOTP", "true");
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("numeroIdentificacion", respuesta.getUsuario().getIdentificacion());

                resultado = "IR_INICIO_APLICACION";

            } else {
               
			mensajeDeError = respuesta.getMensaje();
                        AUDITORIALogger.getInstance().debugMessage("Mensaje de Ezio: **** |"+mensajeDeError);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("mensaje_error_logeo", mensajeDeError);
                                //this.addErrorMessage("Validacion", respuesta.getMensaje());
                
		
              /*  LeafMessageVO message = new LeafMessageVO();
                message.setDetail(respuesta.getMensaje());
                message.setMessage("Validacion");
                showConfirmation(message, null);*/
                resultado = "ERROR";

            }

        } catch (ExcepcionAcceso ex) {
            ex.printStackTrace();
            //showError(ex, null);
        }
        return resultado;
    }
      
	
    public AutenticacionUsuarioDTO getAutenticacionUsuarioDTO() {
        return autenticacionUsuarioDTO;
    }

    public void setAutenticacionUsuarioDTO(AutenticacionUsuarioDTO autenticacionUsuarioDTO) {
        this.autenticacionUsuarioDTO = autenticacionUsuarioDTO;
    }
    
}
