<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=iso-8859-1" language="java" errorPage="" %>    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />		
		<title>::: Bienvenidos a SCA ::</title>
		
		

		<link href="<%=request.getContextPath()%>/css/estilos_auditoria.css" rel="stylesheet" type="text/css" />
	</head>
	<body onclick="ocultarDivs()" onresize="setAlertspositions()" onLoad="MM_preloadImages('<%=request.getContextPath()%>/images/bvendedor.jpg','<%=request.getContextPath()%>/images/bcomprador.jpg')">
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="tablaexterna">
			<jsp:include page="/jsp/home/header.jsp"/>			
			<tr>
				<td>
					<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
						<tr>
							<td width="100%">
								<p>&nbsp;</p>
							</td>
						</tr>
						<tr>
							<td class="tablapesta">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr class="backarriba">
										<td colspan="2" class="generica" align="center" valign="middle">Mensaje:</td>
									</tr>
									
								    <tr>
								        <td colspan="2" class="generica" align="center" height="40" valign="middle">
										  <%
										  	if (request.getAttribute("mensaje_autorizacion")!=null)
											{
												out.println(request.getAttribute("mensaje_autorizacion"));
											}
											else if (request.getSession().getAttribute("mensaje_autorizacion") != null ){
												out.println(request.getSession().getAttribute("mensaje_autorizacion"));
												request.getSession().removeAttribute("mensaje_autorizacion");
											}
										  %>	        
								        </td>
								    </tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<jsp:include page="/jsp/home/footer.jsp"/>			
		</table>
						
	</body>
</html>
