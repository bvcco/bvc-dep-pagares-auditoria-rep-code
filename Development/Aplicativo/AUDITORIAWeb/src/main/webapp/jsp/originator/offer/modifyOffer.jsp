<%@ page contentType="text/html; charset=iso-8859-1" language="java"
	errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<f:view id="modifyOffer">
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
	<title><h:outputText value="#{msg.modifyOffer_title}"></h:outputText></title>
	<link href="<%=request.getContextPath()%>/css/estilos_ttv.css"
		rel="stylesheet" type="text/css" />
	<script>
			function setIsinMainForm(isin,nombreIsin,codigoFungible){
				document.getElementById("modifyOfferForm:isinEspecie").value=isin;
				document.getElementById("modifyOfferForm:codigoFungible").value=codigoFungible;
				document.getElementById("modifyOfferForm:isinEspecie").onchange();				
			}
			
			function setInvestorCodeMainForm(cuentaInversionista,nombreInversionista){
				document.getElementById("modifyOfferForm:cuentaInversionista").value=cuentaInversionista;
				document.getElementById("modifyOfferForm:cuentaInversionista").onchange();				
			}
			
			function setDCVAccountMainForm(cuentaDCV){
				document.getElementById("modifyOfferForm:cuentaDCV").value=cuentaDCV;							
			}
		</script>
	</head>
	<body onclick="ocultarDivs()" onresize="setAlertspositions()"
		onLoad="MM_preloadImages('<%=request.getContextPath()%>/images/boriginador_f2.jpg','<%=request.getContextPath()%>/images/breceptor_f2.jpg')">
	<table width="100%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="tablaexterna">
		<jsp:include page="/jsp/originator/common/header.jsp" />
		<tr>
			<td>
			<table width="100%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td width="100%">
					<table width="95%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td>
							<table width="193" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="42"><img
										src="<%=request.getContextPath()%>/images/poamonregistros.jpg"
										width="42" height="34"></td>
									<td class="originadorpes"><h:outputText
										value="#{msg.menu_modifyOfferLabel}" /></td>
									<td width="31"><img
										src="<%=request.getContextPath()%>/images/pborderechorigi.jpg"
										width="16" height="34"></td>
								</tr>
							</table>
							</td>
						</tr>
						<tr>
							<td class="tablapesta">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td colspan="2" class="titablapesta">Administraci&oacute;n
									de registros | <h:outputText
										value="#{msg.menu_modifyOfferLabel}" /></td>
								</tr>
								<tr>
									<td width="100%"><br />
									<table width="90%" border="0" align="center" cellpadding="0"
										cellspacing="0" class="tablagenerica">
										<tr>
											<td class="tittablagenerica"><h:outputText
												value="#{msg.menu_modifyOfferLabel}" />
											&nbsp;
												<a4j:status id="statusRegisterOffer">									
													<f:facet name="start">
														<h:graphicImage  value="/images/indicator.gif" width="14px" height="14px"/>
													</f:facet>							                            						
												</a4j:status>	
											</td>
										</tr>
										<tr>
											<td><br />
											<a4j:keepAlive beanName="modifyOfferJSF" /> <a4j:form
												id="modifyOfferForm">
												<table width="100%">
													<tr>
														<td align="right" width="350px">&nbsp;</td>
														<td><rich:messages id="errorMessages" layout="table"
															showSummary="true" showDetail="true"
															styleClass="generica"
															passedLabel="msg.modifyOffer_passedLabel"
															ajaxRendered="true">
															<f:facet name="passedMarker">
																<h:graphicImage value="/images/passed.gif" />
															</f:facet>
															<f:facet name="errorMarker">
																<h:graphicImage value="/images/error.gif" />
															</f:facet>
															<f:facet name="fatalMarker">
																<h:graphicImage value="/images/error.gif" />
															</f:facet>
														</rich:messages></td>
													</tr>
												</table>
												<table width="100%">
													<tr>
														<td align="right" width="15%"><h:outputText
															value="#{msg.modifyOffer_ttvIdLabel}"
															styleClass="generica" /></td>
														<td width="30%"><h:outputText
															value="#{modifyOfferJSF.idTTV}" styleClass="negrita" /></td>
														<td colspan="2" width="50%"></td>
													</tr>
													<tr>
														<td align="right" width="15%"><h:outputText
															value="#{msg.modifyOffer_isinLabel}"
															styleClass="generica" /></td>
														<td width="30%" align="left"><h:inputText
															styleClass="generica" id="isinEspecie"
															value="#{modifyOfferJSF.isinEspecie}">
															<a4j:support event="onchange"
																reRender="nombreEspecie,saldoIsin,panelDetalleTTV"
																action="#{modifyOfferJSF.clearDetailFields}" />
														</h:inputText><h:outputLink value="#" id="linkOpenSpecie">
															<f:verbatim>
																<img style="border: 0px solid;"
																	src="<%=request.getContextPath()%>/images/detalle.gif" />
															</f:verbatim>
															<rich:componentControl for="isinHelpPanel"
																attachTo="linkOpenSpecie" operation="show"
																event="onclick" />
														</h:outputLink></td>
														<td align="right" width="15%"><h:outputText
															value="#{msg.modifyOffer_specieNameLabel}"
															styleClass="generica" /></td>
														<td width="40%"><h:outputText id="nombreEspecie"
															value="#{modifyOfferJSF.nombreEspecie}"
															styleClass="negrita" /></td>
													</tr>
													<tr>
														<td align="right" width="15%"><h:outputText
															value="#{msg.modifyOffer_fungibleLabel}"
															styleClass="generica" /></td>
														<td width="30%"><h:inputText styleClass="generica"
															id="codigoFungible"
															value="#{modifyOfferJSF.codigoFungible}">
															<a4j:support event="onchange"
																reRender="nombreEspecie,saldoIsin,panelDetalleTTV" />
														</h:inputText></td>
														<td align="right" width="15%"><h:outputText
															value="#{msg.modifyOffer_investorAccountCodeLabel}"
															styleClass="generica" /></td>
														<td width="40%"><h:inputText styleClass="generica"
															id="cuentaInversionista"
															value="#{modifyOfferJSF.cuentaInversionista}">
															<a4j:support event="onchange"
																reRender="nombreInversionista,saldoIsin,panelDetalleTTV"
																action="#{modifyOfferJSF.clearDetailFields}" />
														</h:inputText> <h:outputLink value="#" id="linkOpenInvestorAccountHelp">
															<f:verbatim>
																<img style="border: 0px solid;"
																	src="<%=request.getContextPath()%>/images/detalle.gif" />
															</f:verbatim>
															<rich:componentControl for="investorAccountHelpPanel"
																attachTo="linkOpenInvestorAccountHelp" operation="show"
																event="onclick" />
														</h:outputLink></td>
													</tr>
													<tr>
														<td align="right" width="15%"><h:outputText
															value="#{msg.modifyOffer_balanceLabel}"
															styleClass="generica" /></td>
														<td width="30%"><h:outputText id="saldoIsin"
															value="#{modifyOfferJSF.saldoIsin}" styleClass="negrita">
															<f:convertNumber
																pattern="###,###,###,###,###,###,###,###,###.##" />
														</h:outputText></td>
														<td align="right" width="15%"><h:outputText
															value="#{msg.modifyOffer_investorAccountNameLabel}"
															styleClass="generica" /></td>
														<td width="40%"><h:outputText
															id="nombreInversionista"
															value="#{modifyOfferJSF.nombreInversionista}"
															styleClass="negrita" /></td>
													</tr>
													<tr>
														<td colspan="4" width="100%">&nbsp;</td>
													</tr>
												</table>
												<a4j:outputPanel id="panelDetalleTTV">
													<table width="100%">
														<tr>
															<td align="right" width="15%"><h:outputText
																value="#{msg.modifyOffer_amountTTVLabel}"
																styleClass="generica" /></td>
															<td width="30%"><h:inputText styleClass="generica"
																id="cantidadPrestar"
																value="#{modifyOfferJSF.cantidadPrestar}">
																<a4j:support event="onchange"
																	reRender="valorizado,prima" />
															</h:inputText></td>
															<td align="right" width="15%"><h:outputText
																value="#{msg.modifyOffer_rateTTVLabel}"
																styleClass="generica" /></td>
															<td width="40%"><h:inputText styleClass="generica"
																id="tasaPrestamo" value="#{modifyOfferJSF.tasaPrestamo}">
																<a4j:support event="onchange" reRender="prima" />
															</h:inputText></td>
														</tr>
														<tr>
															<td align="right" width="15%"><h:outputText
																value="#{msg.modifyOffer_haircuteRateTTVLabel}"
																styleClass="generica" /></td>
															<td width="30%"><h:outputText id="tasaCobertura"
																value="#{modifyOfferJSF.tasaCobertura}"
																styleClass="generica">
																<f:convertNumber pattern="####.##" />
															</h:outputText></td>
															<td align="right" width="15%"><h:outputText
																value="#{msg.modifyOffer_profitTTVLabel}"
																styleClass="generica" /></td>
															<td width="40%"><h:outputText id="prima"
																value="#{modifyOfferJSF.prima}" styleClass="generica">
																<f:convertNumber pattern="###,###,###,###,###,###.##" />
															</h:outputText></td>
														</tr>
														<tr>
															<td align="right" width="15%"><h:outputText
																value="#{msg.modifyOffer_valueTVVLabel}"
																styleClass="generica" /></td>
															<td width="30%"><h:outputText id="valorizado"
																value="#{modifyOfferJSF.valorizado}"
																styleClass="generica">
																<f:convertNumber
																	pattern="###,###,###,###,###,###,###,###,###.##" />
															</h:outputText></td>
															<td colspan="2" width="100%">&nbsp;</td>
														</tr>
														<tr>
															<td align="right" width="15%"><h:outputText
																value="#{msg.modifyOffer_registerDateLabel}"
																styleClass="generica" /></td>
															<td width="30%"><rich:calendar id="fechaRegistro"
																value="#{modifyOfferJSF.fechaRegistro}" popup="true"
																datePattern="dd/MM/yyyy" showApplyButton="false"
																enableManualInput="true" cellWidth="24px"
																cellHeight="22px" style="width:25%"
																ondateselect="setTimeout('$(\"modifyOfferForm:fechaRegistroInputDate\").onchange()',10);">
																<a4j:support event="oninputchange" reRender="plazo" />
															</rich:calendar></td>
															<td align="right" width="15%"><h:outputText
																value="#{msg.modifyOffer_modeProfitPaymentLabel}"
																styleClass="generica" /></td>
															<td width="40%"><h:selectOneRadio
																id="formaPagoComision" styleClass="generica"
																value="#{modifyOfferJSF.formaPagoComision}"
																onclick="if(this.value==0){showAccountDCV({duration:0.7});}else{hideAccountDCV({duration:0.7});}">
																<f:selectItem id="pagoDVP"
																	itemLabel="#{msg.modifyOffer_modeProfitPaymentDVPLabel}"
																	itemValue="0" />
																<f:selectItem id="pagoLP"
																	itemLabel="#{msg.modifyOffer_modeProfitPaymentLPLabel}"
																	itemValue="1" />
															</h:selectOneRadio> <rich:effect name="hideAccountDCV" for="cuentaDCVPanel"
																type="Fade" /> <rich:effect name="showAccountDCV"
																for="cuentaDCVPanel" type="Appear" /></td>
														</tr>
														<tr>
															<td align="right" width="15%"><h:outputText
																value="#{msg.modifyOffer_endDateLabel}"
																styleClass="generica" /></td>
															<td width="30%"><rich:calendar id="fechaVencimiento"
																value="#{modifyOfferJSF.fechaVencimiento}" popup="true"
																datePattern="dd/MM/yyyy" enableManualInput="true"
																showApplyButton="false" cellWidth="24px"
																cellHeight="22px" style="width:25%"
																ondateselect="setTimeout('$(\"modifyOfferForm:fechaVencimientoInputDate\").onchange()',10);">
																<a4j:support event="oninputchange" reRender="plazo" />
															</rich:calendar></td>
															<td align="left" colspan="2" width="50%"><a4j:outputPanel
																id="cuentaDCVPanel">
																<table width="100%" cellpadding="0" cellspacing="0"
																	border="0">
																	<tr>
																		<td align="right" width="27%"><h:outputText
																			id="cuentaDCVLabel"
																			value="#{msg.modifyOffer_DCVaccountNumberLabel}"
																			styleClass="generica" /></td>
																		<td width="1%">&nbsp;</td>
																		<td width="72%"><h:inputText
																			styleClass="generica" id="cuentaDCV"
																			value="#{modifyOfferJSF.cuentaDCV}" /><h:outputLink
																			value="#" id="linkOpenDCVHelp">
																			<f:verbatim>
																				<img style="border: 0px solid;"
																					src="<%=request.getContextPath()%>/images/detalle.gif" />
																			</f:verbatim>
																			<rich:componentControl for="helpDCVAccount"
																				attachTo="linkOpenDCVHelp" operation="show"
																				event="onclick" />
																		</h:outputLink></td>
																	</tr>
																</table>
															</a4j:outputPanel></td>
														</tr>
														<tr>
															<td align="right" width="15%"><h:outputText
																value="#{msg.modifyOffer_daysBetweenDatesLabel}"
																styleClass="generica" /></td>
															<td width="30%"><h:outputText id="plazo"
																value="#{modifyOfferJSF.plazo}" styleClass="generica" /></td>
															<td colspan="2" width="55%">&nbsp;</td>
														</tr>
													</table>
												</a4j:outputPanel>
												<table width="100%">
													<tr>
														<td align="right" width="60%"><h:commandButton
															styleClass="button" action="homeOriginator"
															onclick="if(!confirm('#{msg.modifyOffer_cancelButtonConfirmMessage}')){return false;};"
															value="#{msg.modifyOffer_cancelButtonText}"></h:commandButton></td>
														<td><h:commandButton styleClass="button"
															id="modificarOferta" type="submit"
															action="#{modifyOfferJSF.modificarOferta}"
															onclick="if(!confirm('#{msg.modifyOffer_saveButtonConfirmMessage}')){return false;}"
															value="#{msg.modifyOffer_saveButtonText}"
															/></td>
													</tr>
												</table>
											</a4j:form></td>
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
	<a4j:include id="helpSpecie" viewId="/jsp/common/isinHelp.jsp" />
	<a4j:include id="helpInvestorAccount"
		viewId="/jsp/common/investorAccountHelp.jsp" />
	<a4j:include id="helpAccountDCV"
		viewId="/jsp/common/accountDCVHelp.jsp" />
	</body>
	</html>
</f:view>