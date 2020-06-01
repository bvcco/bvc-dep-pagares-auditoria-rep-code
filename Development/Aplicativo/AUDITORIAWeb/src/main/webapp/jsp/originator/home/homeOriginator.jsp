<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=iso-8859-1" language="java" errorPage="" %>    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<f:view id="homeOriginator">
<f:loadBundle basename="com.deceval.ttv.web.resources.messages.MessagesResources" var="msg"/>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<script src="<%=request.getContextPath()%>/js/prototype.js" type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/js/scriptaculous.js" type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/js/functions_ttv.js" type="text/javascript"></script>
		<title><h:outputText value="#{msg.homeOriginator_title}"></h:outputText></title>
		<link href="<%=request.getContextPath()%>/css/estilos_ttv.css" rel="stylesheet" type="text/css" />
	</head>
	<body onclick="ocultarDivs()" onresize="setAlertspositions()" onLoad="MM_preloadImages('<%=request.getContextPath()%>/images/boriginador_f2.jpg','<%=request.getContextPath()%>/images/breceptor_f2.jpg')">
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="tablaexterna">
			<jsp:include page="/jsp/originator/common/header.jsp"/>			
			<tr>
				<td>
					<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
						<tr>
							<td width="100%">
								<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
									<tr>
										<td></td>
									</tr>
									<tr>
										<td class="tablapesta">
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
												<tr>
													<td colspan="2" class="titablapesta">Inicio</td>
												</tr>
												<tr>
								                    <td width="100%" align="center">
								                       <img src="<%=request.getContextPath()%>/images/bienoriginador.jpg" alt="splash index originador" />
													</td>
													<jsp:include page="/jsp/common/alerts.jsp"/>
												</tr>
											</table>
										</td>
									</tr>
								</table>
								<p>&nbsp;</p>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<jsp:include page="/jsp/common/footer.jsp"/>			
		</table>				
	</body>
</html>
</f:view>