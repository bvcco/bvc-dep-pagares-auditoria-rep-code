package com.deceval.auditoria.web.backingbean.login;


import com.deceval.auditoria.exception.base.BaseException;
import com.deceval.auditoria.util.constants.Constants;
import com.deceval.auditoria.util.properties.PropertiesLoader;
import com.deceval.seguridad.comunes.constantes.DatosConstantes;
import com.deceval.seguridad.comunes.dto.AutenticacionUsuarioDTO;
import com.deceval.seguridad.comunes.dto.RespuestaAutenticacionOTPDTO;
import com.deceval.seguridad.comunes.servicios.configuracion.ConfiguracionGeneral;
import com.deceval.seguridad.logica.AutenticacionOTP;
import com.deceval.seguridad.logica.excepciones.ExcepcionAcceso;
import com.deceval.auditoria.util.log.AUDITORIALogger;
import com.deceval.auditoria.web.backingbean.common.BaseJSFBean;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


/**
 *
 * @author lcastellanos
 */
public class LoginOTPJSFBean extends BaseJSFBean implements Serializable{
    
    private AutenticacionUsuarioDTO autenticacionUsuarioDTO = new AutenticacionUsuarioDTO();
    private String PAGINA_INICIO = "/faces/jsp/login/inicioAplicacion.jsp";
        
    private String mensajeDeError;
    private String tipoGeneracionOpt = "";

    public LoginOTPJSFBean() {                        
        this.autenticacionUsuarioDTO.setCodigoOtp("");
        this.autenticacionUsuarioDTO.setContrasena("");
        this.autenticacionUsuarioDTO.setIdentificacionUsuario("");

        this.autenticacionUsuarioDTO.setAplicationId(PropertiesLoader.loadProperty(Constants.TENANT_APLICATION_ID));
        this.autenticacionUsuarioDTO.setOrigen(PropertiesLoader.loadProperty(Constants.TENANT_ORIGEN));
        this.autenticacionUsuarioDTO.setUrlTentant(PropertiesLoader.loadProperty(Constants.TENANT_URL));

    }

    public String autenticarUsuario() throws Exception {
        FacesMessage message = new FacesMessage();
        AutenticacionOTP autenticacionOTP = new AutenticacionOTP();
        String resultado = "";
        Boolean datosCorrectosIngresoMail = true;

        try {
            if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey("authorizationToken")) {
                this.autenticacionUsuarioDTO.setAuthorizationToken(FacesContext.getCurrentInstance().getExternalContext()
                        .getSessionMap().get("authorizationToken").toString());
            }
            if (tipoGeneracionOpt != null && tipoGeneracionOpt.equals("1")) {
                this.autenticacionUsuarioDTO.setMetodoAutenticacion(ConfiguracionGeneral.getInstance()
                        .obtenerVariable(DatosConstantes.METODO_AUTENTICACION_LOGIN_TOKEN_APLICACION_MOVIL));
            } else if (tipoGeneracionOpt != null && tipoGeneracionOpt.equals("2")
                    && this.autenticacionUsuarioDTO.getAuthorizationToken() != null
                    && !this.autenticacionUsuarioDTO.getAuthorizationToken().isEmpty()) {
                datosCorrectosIngresoMail = validarDatosCorrestosIngresoMail();
                this.autenticacionUsuarioDTO.setMetodoAutenticacion(ConfiguracionGeneral.getInstance()
                        .obtenerVariable(DatosConstantes.METODO_AUTENTICACION_LOGIN_TOKEN_EMAIL));

            }/*
            else if (tipoGeneracionOpt != null && tipoGeneracionOpt.equals("3")) {
                this.autenticacionUsuarioDTO.setMetodoAutenticacion(ConfiguracionGeneral.getInstance()
                        .obtenerVariable(DatosConstantes.METODO_AUTENTICACION_LOGIN_TOKEN_FISICO));
            }*/


            if (this.autenticacionUsuarioDTO.getMetodoAutenticacion() != null && !this.autenticacionUsuarioDTO.getMetodoAutenticacion().isEmpty()) {
                if (datosCorrectosIngresoMail) {
                    RespuestaAutenticacionOTPDTO respuesta = autenticacionOTP.autenticarUsuario(this.autenticacionUsuarioDTO);
                    if (respuesta.getAutenticado()) {
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("autenticadoOTP", "true");
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("numeroIdentificacion", respuesta.getUsuario().getIdentificacion());
                        borrarVariablesSesion();
                        resultado = "IR_INICIO_APLICACION";

                    } else {
                    //mensajeDeError = respuesta.getMensaje();
                    AUDITORIALogger.getInstance().debugMessage("Mensaje de Ezio: **** |" + respuesta.getMensaje());
                    //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("mensaje_error_logeo", respuesta.getMensaje());
                    message.setSeverity(FacesMessage.SEVERITY_ERROR);
                    message.setSummary(respuesta.getMensaje());
                    message.setDetail(respuesta.getMensaje());
                    FacesContext.getCurrentInstance().addMessage("GLOBAL", message);
                    //this.addErrorMessage("Validacion", respuesta.getMensaje());


                  /*  LeafMessageVO message = new LeafMessageVO();
                    message.setDetail(respuesta.getMensaje());
                    message.setMessage("Validacion");
                    showConfirmation(message, null);*/
                        resultado = "ERROR";
                    }

                    AUDITORIALogger.getInstance().infoMessage("Resultado de login para: " + this.autenticacionUsuarioDTO.getIdentificacionUsuario() +
                            " Mensaje: " + respuesta.getAutenticado() + " - " + respuesta.getMensaje());
                } else {
                    this.addErrorMessage("Usuario o contrase\u00F1a no valida.","");
                    AUDITORIALogger.getInstance().debugMessage("Error contraseñas" + this.getAutenticacionUsuarioDTO().getIdentificacionUsuario()
                            + "\"Usuario o contrase\\u00F1a no valida\"");
                }
            } else {
                    this.addErrorMessage("Por favor solicitar OTP v\u00EDa Mail antes de ingresar.","");
                    AUDITORIALogger.getInstance().debugMessage("Error email" + this.getAutenticacionUsuarioDTO().getIdentificacionUsuario()
                    + "Por favor solicitar OTP v\u00EDa Mail antes de ingresar.");
            }
        } catch (ExcepcionAcceso ex) {
            AUDITORIALogger.getInstance().errorMessage("Resultado ERROR de login para: " + this.autenticacionUsuarioDTO.getIdentificacionUsuario() +
                    " Mensaje: " + ex.getMessage());
            AUDITORIALogger.getInstance().errorMessage(BaseException.getStackTrace(ex));
            System.out.println("Resultado ERROR de login para: " + this.autenticacionUsuarioDTO.getIdentificacionUsuario() +
                    " Mensaje: " + ex.getMessage());
            ex.printStackTrace();
            //showError(ex, null);
        }

        return resultado;
    }
      
    public void solicitarOtpMail() {
        FacesMessage message = new FacesMessage();
        try {
            borrarVariablesSesion();
            AutenticacionOTP autenticacionOTP = new AutenticacionOTP();
            if (tipoGeneracionOpt != null && tipoGeneracionOpt.equals("2")) {

                this.autenticacionUsuarioDTO.setMetodoAutenticacion(ConfiguracionGeneral.getInstance()
                        .obtenerVariable(DatosConstantes.METODO_AUTENTICACION_SOLICITAR_TOKEN_EMAIL));

                RespuestaAutenticacionOTPDTO respuesta = autenticacionOTP.autenticarUsuario(this.autenticacionUsuarioDTO);
                // si getAutenticado es true para este metodo significa que el OTP
                // se envio correctamente via email y podemos recuperar el
                // authorization de entrust
                if (respuesta.getAutenticado()) {

                    if (respuesta.getAuthorizationToken() != null && !respuesta.getAuthorizationToken().isEmpty()) {
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("authorizationToken",
                                respuesta.getAuthorizationToken());
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("identificacionCorrecta",
                                this.autenticacionUsuarioDTO.getIdentificacionUsuario());
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("contrasenaCorrecta",
                                this.autenticacionUsuarioDTO.getContrasena());

                        message.setSeverity(FacesMessage.SEVERITY_INFO);
                        message.setSummary(respuesta.getMensaje());
                        message.setDetail(respuesta.getMensaje());
                        FacesContext.getCurrentInstance().addMessage("GLOBAL", message);



                    } else {

                        message.setSeverity(FacesMessage.SEVERITY_ERROR);
                        message.setDetail("Ocurrio un problema inesperado, Contactea su administrador o intentelo de nuevo");
                        message.setSummary("Ocurrio un problema inesperado, Contactea su administrador o intentelo de nuevo");
                        FacesContext.getCurrentInstance().addMessage("GLOBAL", message);
                    }
                } else {
                    message.setSeverity(FacesMessage.SEVERITY_ERROR);
                    message.setDetail(respuesta.getMensaje());
                    message.setSummary(respuesta.getMensaje());
                    FacesContext.getCurrentInstance().addMessage("GLOBAL", message);
                }
            } else {
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                message.setDetail("Por favor seleccione la opci\u00F3n: Generar OTP por correo electr\u00F3nico");
                message.setSummary("Por favor seleccione la opci\u00F3n: Generar OTP por correo electr\u00F3nico");
                FacesContext.getCurrentInstance().addMessage("GLOBAL", message);

            }

        } catch (Exception ex) {
            try {
                AUDITORIALogger.getInstance().errorMessage("Resultado ERROR de login para: " + this.autenticacionUsuarioDTO.getIdentificacionUsuario() +
                        " Mensaje: " + ex.getMessage());
                AUDITORIALogger.getInstance().errorMessage(BaseException.getStackTrace(ex));
            } catch (Exception e) {
                e.printStackTrace();
            }
            message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            message.setSummary(" Mensaje de Validación ");
            message.setDetail(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage("",message);
        }
    }

    private void borrarVariablesSesion() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("authorizationToken");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("identificacionCorrecta");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("contrasenaCorrecta");
    }

    private Boolean validarDatosCorrestosIngresoMail() {
        if (this.autenticacionUsuarioDTO.getIdentificacionUsuario().equals(FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("identificacionCorrecta").toString()) &&
                this.autenticacionUsuarioDTO.getContrasena().equals(FacesContext.getCurrentInstance()
                        .getExternalContext().getSessionMap().get("contrasenaCorrecta").toString())) {
            return true;
        }
        else{
            return false;
        }
    }
	
    public AutenticacionUsuarioDTO getAutenticacionUsuarioDTO() {
        return autenticacionUsuarioDTO;
    }

    public void setAutenticacionUsuarioDTO(AutenticacionUsuarioDTO autenticacionUsuarioDTO) {
        this.autenticacionUsuarioDTO = autenticacionUsuarioDTO;
    }
    
    public String getTipoGeneracionOpt() {
        return tipoGeneracionOpt;
    }

    public void setTipoGeneracionOpt(String tipoGeneracionOpt) {
        this.tipoGeneracionOpt = tipoGeneracionOpt;
    }
}
