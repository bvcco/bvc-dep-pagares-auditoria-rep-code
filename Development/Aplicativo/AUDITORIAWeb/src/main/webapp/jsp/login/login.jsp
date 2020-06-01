<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<script type="text/javascript">
  function validar(){
      if (document.getElementById('j_username').value == "" || document.getElementById('j_username').value == null){
        alert("Debe escribir Nombres y Apellidos")
      }
      else {
        document.forms[0].submit();
      }
  }
  
  function revisarValidarTeclado(){
    
      window.status= "Verificando usuario";    
      validar();
    
  }
</script>
</head>

<body>
  <form id="login" name="login" method="post"
	action="<%=request.getContextPath()%>/faces/jsp/home/home.jsp">
	
		<table width="1024" border="0" align="center" cellpadding="0" cellspacing="0" class="abajo">
		  <tr>
		    <td><img src="<%=request.getContextPath()%>/images/logo.jpg" width="1024" height="388" /></td>
		  </tr>
		  <tr>
		    <td class="loginazul" style="background-image: url(<%=request.getContextPath()%>/images/loginbackazul.jpg);"><br />
		      <table width="465" border="0" align="center" cellpadding="0" cellspacing="0">
		      <tr>
		        <td width="44">&nbsp;</td>
		        <td width="95">&nbsp;</td>
		        <td width="154">&nbsp;</td>
		        <td width="172">&nbsp;</td>  
		        
		      </tr> 
		      <%--  <tr>
		        <td><div align="center"><img src="<%=request.getContextPath()%>/images/loginusuario.jpg" width="27" height="23" /></div></td>
		        <td>Usuario:</td>
		        <td><input name="j_username" id="j_username" type="text" size="50" class="generica" onblur="this.value=this.value.toLowerCase()" /></td>
		        <td>&nbsp;</td>
		      </tr>--%>
	      <tr>
	        <td class="txtloginerror" colspan="4">
			  <% 
				if (request.getSession().getAttribute("mensaje_error_logeo") != null ){
					out.println(request.getSession().getAttribute("mensaje_error_logeo"));
					request.getSession().removeAttribute("mensaje_error_logeo");
				}
				if (request.getSession().getAttribute("mensaje_autorizacion") != null ){
					out.println(request.getSession().getAttribute("mensaje_autorizacion"));
					request.getSession().removeAttribute("mensaje_autorizacion");
				}
			  %>	        
	         </td>
	       </tr>		      
		      <tr>
		        <td>&nbsp;</td>
		        <td>&nbsp;</td>
		        <td>&nbsp;</td>
		        <td>&nbsp;</td>
		      </tr>
		    </table></td>  
		  </tr>
		  <tr>
		    <td height="71">&nbsp;</td>
		  </tr>
		</table>			
	</form>

</body>

</html>
