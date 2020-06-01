<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=iso-8859-1" language="java"
	errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<f:view id="homeOriginator">
	<f:loadBundle
		basename="com.deceval.ttv.web.resources.messages.MessagesResources"
		var="msg" />
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<script src="<%=request.getContextPath()%>/js/prototype.js"
		type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/scriptaculous.js"
		type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/functions_ttv.js"
		type="text/javascript"></script>
	<title><h:outputText value="#{msg.detailOffer_title}"></h:outputText></title>
	<link href="<%=request.getContextPath()%>/css/estilos_ttv.css"
		rel="stylesheet" type="text/css" />
	</head>
	<body onclick="ocultarDivs();" onresize="setAlertspositions()"
		onLoad="MM_preloadImages('<%=request.getContextPath()%>/images/boriginador_f2.jpg','<%=request.getContextPath()%>/images/breceptor_f2.jpg')">
	<table width="100%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="tablaexterna">
		<jsp:include page="/jsp/receptor/common/header.jsp" />
		<tr>
			<td>
			<table width="100%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td width="100%">
					<table width="95%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td></td>
						</tr>
						<tr>
							<td class="tablapesta">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td colspan="2" class="titablapesta">Administraci&oacute;n
									de registros | <h:outputText
										value="#{msg.menu_DetailDemandLabel}" /></td>
								</tr>
								<tr>
									<td width="100%"><br />
									<table width="90%" border="0" align="center" cellpadding="0"
										cellspacing="0" class="tablagenerica">
										<tr>
											<td class="tittablagenerica"><h:outputText
										value="#{msg.menu_DetailDemandLabel}" /><h:outputText value=" - " />
										<h:outputText value="#{detailDemandJSF.ttvVo.id_ttv}" /></td>
										</tr>
										<tr>
											<td height="99"><br />
											<h:form id="detailDemandForm" >
												<table width="100%">
													<tr>
														<td align="right" width="350px">&nbsp;</td>
														<td><a4j:outputPanel
															id="messagesPanel">
															<rich:messages layout="table" showSummary="true"
																showDetail="true" style="height:15px;"styleClass="generica"
																passedLabel="msg.registerDemand_passedLabel">
																<f:facet name="passedMarker">
																	<h:graphicImage value="/images/passed.gif" />																	
																</f:facet>
																<f:facet name="errorMarker">
																	<h:graphicImage value="/images/error.gif" />																	
																</f:facet>
															</rich:messages>
														</a4j:outputPanel>
														</td>
													</tr>
												</table>
												<table width="100%">
													<tr>	
										
														<td align="right"><span class="generica"><h:outputText
															value="#{msg.detailDemand_depositorCodeLabel}" /></span></td>
														<td align="left"><span class="negrita"><h:outputText id="codigoDepositante" value="#{userInfo.codigoDepositante}"></h:outputText></span></td>
														<td align="right"><span class="generica"><h:outputText
															value="#{msg.detailDemand_depositorNameLabel}"/></span></td>
														<td align="left"><span class="negrita"><h:outputText id="nombreDepositante" value="#{userInfo.nombreDepositante}"></h:outputText></span></td>
													</tr>
													<tr>
														<td align="right"><span class="generica"><h:outputText
															value="#{msg.detailDemand_isinLabel}" /></span></td>
														<td align="left"><span class="negrita"><h:outputText id="isinEspecie" value="#{detailDemandJSF.ttvVo.codigo_isin_unido}"></h:outputText></span></td>
														<td align="right"><span class="generica"><h:outputText
															value="#{msg.detailDemand_specieNameLabel}" /></span></td>
														<td align="left"><span class="negrita"><h:outputText id="nombreEspecie" value="#{detailDemandJSF.ttvVo.especieFungible.especie.descripcion_especie}"></h:outputText></span></td>
													</tr>
													<tr>
														<td align="right"><span class="generica"><h:outputText
															value="#{msg.detailDemand_fungibleLabel}" /></span>
														</td>
														<td align="left"><span class="negrita"><h:outputText id="codigoFungible" value="#{detailDemandJSF.ttvVo.codigo_fungible}"></h:outputText></span></td>
														<td align="right"><span class="generica"><h:outputText
															value="#{msg.detailDemand_investorAccountCodeLabel}" /></span></td>
														<td align="left"><span class="negrita"><h:outputText id="cuentaInversionista" value="#{detailDemandJSF.ttvVo.cuenta_inversionista_origen}"></h:outputText></span></td>	
													</tr>
													<tr>
														<td align="right"><span class="generica"><h:outputText
															value="#{msg.detailDemand_balanceLabel}" /></span></td>
														<td align="left"><span class="negrita"><h:outputText id="saldoIsin"
															value="#{detailDemandJSF.saldoIsin}" /></span></td>
														<td align="right"><span class="generica"><h:outputText
															value="#{msg.detailDemand_investorAccountNameLabel}" /></span></td>
														<td align="left"><span class="negrita"><h:outputText id="nombreInversionista"
															value="#{detailDemandJSF.ttvVo.inversionista.nombre_inversionista}" /></span></td>
													</tr>
													<tr>
														<td colspan="4">&nbsp;</td>
													</tr>
													<tr>
														
																<td align="right"><span class="generica"><h:outputText
															value="#{msg.detailDemand_amountTTVLabel}" /></span>
																</td>
																<td align="left"><span class="negrita"><h:outputText id="cantidadPrestar" value="#{detailDemandJSF.ttvVo.cantidad}"></h:outputText></span></td>
																<td align="right" width="15%"><h:outputText
																value="#{msg.detailDemand_rateTTVLabel}"
																styleClass="generica" /></td>
															<td width="40%"><span class="negrita"><h:outputText id="tasaPrestamo" value="#{detailDemandJSF.ttvVo.tasa_prestamo}"></h:outputText></span></td>
															</tr>															
															<tr>
																<td align="right"><span class="generica"><h:outputText
															value="#{msg.detailDemand_haircuteRateTTVLabel}" /></span></td>
																<td align="left"><span class="negrita"><h:outputText id="tasaCobertura"
															value="#{detailDemandJSF.ttvVo.tasa_cobertura}" /></span></td>
																<td align="right"><span class="generica"><h:outputText
															value="#{msg.detailDemand_profitTTVLabel}" /></span>
																</td>
																<td align="left"><span class="negrita"><h:outputText id="prima"
															value="#{detailDemandJSF.ttvVo.prima}" /></span></td>
															</tr>
															<tr>
																<td align="right"><span class="generica"><h:outputText
															value="#{msg.detailDemand_valueTVVLabel}" /></span>
																</td>
																<td align="left"><span class="negrita"><h:outputText id="valorizado"
																value="#{detailDemandJSF.ttvVo.valorizado}" /></span></td>
																
																<td align="right"><span class="generica"><h:outputText
															value="#{msg.detailDemand_daysBetweenDatesLabel}" /></span>
																</td>
																<td align="left"><span class="negrita"><h:outputText id="plazo" value="#{detailDemandJSF.ttvVo.plazo}" /> 
																</span></td>
																
															</tr>
															<tr>
																<td align="right"><span class="generica"><h:outputText
															value="#{msg.detailDemand_registerDateLabel}" /></span></td>
															<td align="left"><span class="negrita">
															<h:outputText id="fechaRegistro" value="#{detailDemandJSF.ttvVo.fecha_registro}">
																<f:convertDateTime pattern="dd/MM/yyyy"/>
															</h:outputText></span></td>
																<td align="right"><span class="generica"><h:outputText
															value="#{msg.detailDemand_modeProfitPaymentLabel}" /></span></td>
																<td align="left"><span class="generica">
																<h:selectOneRadio id="formaPagoComision" styleClass="radioBox" value="#{detailDemandJSF.ttvVo.pago_comision_dvp}">
																	<f:selectItem id="pagoDVP" itemLabel="#{msg.detailDemand_modeProfitPaymentDVPLabel}" itemValue="1" />
																	<f:selectItem id="pagoLP" itemLabel="#{msg.detailDemand_modeProfitPaymentLPLabel}" itemValue="0" />  
																</h:selectOneRadio>	
																</span></td>
															</tr>
															<tr>
																<td align="right"><span class="generica"><h:outputText
															value="#{msg.detailDemand_endDateLabel}" /></span></td>
															<td align="left"><span class="negrita"><h:outputText id="fechaVencimiento" value="#{detailDemandJSF.ttvVo.fecha_vencimiento}">
															 <f:convertDateTime pattern="dd/MM/yyyy"/>
															</h:outputText></span></td>
																
																<td align="right"><span class="generica"><h:outputText
															value="#{msg.detailDemand_DCVaccountNumberLabel}" /></span></td>
															<td align="left"><span class="negrita"><h:outputText id="cuentaDVC" value="#{detailDemandJSF.ttvVo.cuenta_sebra_originador}"></h:outputText></span></td>
															</tr>
															
														
													<tr>
														<td colspan="4" align="right">
														    <h:commandButton styleClass="button" value="Regresar" action="#{detailDemandJSF.regresarTtv}"/>
														    
														    <h:commandButton styleClass="button" value="Modificar" onclick="if(!confirm('#{msg.detailDemand_ButtonModifyMessage}')) return false;" action="#{detailDemandJSF.modificarTtv}"/>
														    
														    <h:commandButton styleClass="button" value="Eliminar" onclick="if(!confirm('#{msg.detailDemand_ButtonDeleteMessage}')) return false;" action="#{detailDemandJSF.eliminarTtv}"/>
															
															<a4j:commandButton styleClass="button" value="Publicar" onclick="if(!confirm('#{msg.detailDemand_ButtonPublishMessage}')) return false;"    action="#{detailDemandJSF.publicarTtv}" />
														</td>
													</tr>
												</table>
												
												<h:inputHidden id="idTTV"   value="#{detailDemandJSF.id_TTV}" /> 
												<h:messages styleClass="messages" id="GLOBAL" />
												<rich:messages id="globalMessages" layout="table" globalOnly="true" showDetail="true" showSummary="true"></rich:messages>
											</h:form></td>
										</tr>
									</table>
									<br />
									</td>
									<jsp:include page="/jsp/common/alerts.jsp" />
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
		<jsp:include page="/jsp/common/footer.jsp" />		
	</table>
	</body>
	</html>
</f:view>
