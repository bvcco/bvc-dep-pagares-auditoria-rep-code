<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=iso-8859-1" language="java" errorPage="" %>    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<f:view>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>:: Bienvenidos a SCA ::</title>
<link href="<%=request.getContextPath()%>/css/estilos_auditoria.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.txtloginerror {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	font-weight: bold;
	color: #FFFFFF;
	font-style: italic;
	text-align: center;
}
-->
</style>

</head>

<body>
        <h:form id="loginUsuarios">
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="abajo">
		  <tr>
		    <td><img src="<%=request.getContextPath()%>/images/logo.jpg" width="1024" height="388" /></td>
		  </tr>
		  <tr>
		    <td class="loginazul" style="background-image: url(<%=request.getContextPath()%>/images/loginbackazul.jpg);"><br />
		      <table width="465" border="0" align="center" cellpadding="0" cellspacing="0">
                 
                          <tr>
                              <td width="20%"></td>
                              <td align="center" width="60%" colspan="2">
                                  <h:panelGrid columns="1" width="100%">
                                      <rich:messages id="errorMessages" layout="table" showSummary="true" showDetail="false" styleClass="txtMsgInfo" 
                                                     passedLabel="msg.modifyDemand_passedLabel" errorClass="txtMsgError" infoClass="txtMsgError">
                                          <f:facet name="errorMarker">
                                              <h:graphicImage value="/images/error.gif"/>
                                          </f:facet>
                                      </rich:messages>
                                  </h:panelGrid>
                              </td>
                              <td width="20%"></td>			
                          </tr> 
                          
                          <tr>
                              <td class="txtloginerror" colspan="4">
                                  <%
                                      if (request.getSession().getAttribute("mensaje_error_logeo") != null) {
                                          out.println(request.getSession().getAttribute("mensaje_error_logeo"));
                                          request.getSession().removeAttribute("mensaje_error_logeo");
                                      }
                                  %>	        
                              </td>
                          </tr>	
                      <tr>
                          <td width="25%" align="right">&nbsp;</td>
                          <td width="25%" class="txtlogin">&nbsp;&nbsp;&nbsp;Identificacion::</td>
                          <td width="25%">	        	
                              <h:inputText autocomplete="off" id="numeroIdentificacion" size="50" label="Numero de Identificacion" required="true" styleClass="generica" value="#{loginOTPJSFBean.autenticacionUsuarioDTO.identificacionUsuario}"/>
                          </td>
                          <td width="25%">&nbsp;</td>
                      </tr>
                      <tr>
                          <td width="25%" align="right">&nbsp;</td>
                          <td width="25%" class="txtlogin">&nbsp;&nbsp;&nbsp;Contrase�a::</td>
                          <td width="25%">	        	
                              <h:inputSecret autocomplete="off" id="passwordUsuario" size="50" label="Contrase�a" required="true" styleClass="generica" value="#{loginOTPJSFBean.autenticacionUsuarioDTO.contrasena}"/>
                          </td>
                          <td width="25%">&nbsp;</td>
                      </tr>
                      <tr>
                          <td width="25%" align="right">&nbsp;</td>
                          <td width="25%" class="txtlogin">&nbsp;&nbsp;&nbsp;OTP::</td>
                          <td width="25%">	        	
                              <h:inputText autocomplete="off" id="otp"  styleClass="generica" label="OTP" required="true" size="50" value="#{loginOTPJSFBean.autenticacionUsuarioDTO.codigoOtp}"/>
                          </td>
                          <td width="25%">&nbsp;</td>
                      </tr>
                      
                      <tr>
                          <td colspan="4" align="center">
                              <h:commandButton value="Ingresar" id="btnIngreso" 
                                               action="#{loginOTPJSFBean.autenticarUsuario}" 
                                               styleClass="button"></h:commandButton>
                          </td>
                      </tr>
		    </table></td>  
		  </tr>
		  <tr>
		    <td height="71">&nbsp;</td>
		  </tr>
		</table>			
	  </h:form>

</body>

</html>
</f:view>
