<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=iso-8859-1" language="java"
  errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html>
<head>
<script src="<%=request.getContextPath()%>/js/functions_registro.js"
  type="text/javascript"></script>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>:: Bienvenidos a SCA ::</title>
<link href="<%=request.getContextPath()%>/css/estilos_registro.css"
	rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
body {
	background-color: #D2DEEC;
	margin-top: 0px;
}
-->
</style>

<script language="JavaScript">
<!--
function abrirVentanaRegistro() {
  var nuevaVentana = new Object();
  var nombreVentana = 'auditoria';
  var anchoVentana = screen.availWidth;
  var altoVentana = screen.availHeight - 60;
  nuevaVentana = window.open('<%=request.getContextPath()%>/faces/jsp/home/home.jsp', nombreVentana, 
          'width=' + anchoVentana + ',height=' + altoVentana + ',resizable=no,' +
          'menubar=no,toolbar=no,directories=no,location=no,scrollbars=yes,' + 
          'status=yes');
  nuevaVentana.moveTo(0,0);
}

//-->
</script>

</head>

<body onload="abrirVentanaRegistro()">
<f:view>
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
	  <tr>
	    <td><div align="center"><img src="<%=request.getContextPath()%>/images/logo.jpg" width="1024" height="489" /></div></td>
	  </tr>
	  <tr>
	    <td align="center" valign="middle" class="backlinea">
	    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
	      <tr>
	        <td align="center">
	         <h:outputText value="#{msg.inicioAplicacion_SinPopupAutomatico}" styleClass="txtblanco"  
	          style="font-size:15px;"/>
	         <a href='#' onclick="abrirVentanaRegistro()">
	           <b><h:outputText value="#{msg.inicioAplicacion_abrir}"/></b>
	         </a>
	        </td>	        
	      </tr>	            
	    </table></td>
	  </tr>
	  <tr>
	    <td>&nbsp;</td>
	  </tr>
	</table>
</f:view>	
</body>
</html>
