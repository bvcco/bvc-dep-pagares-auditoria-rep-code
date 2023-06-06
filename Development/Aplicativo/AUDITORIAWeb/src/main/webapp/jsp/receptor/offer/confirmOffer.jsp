<%@ page contentType="text/html; charset=iso-8859-1" language="java"
	errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<f:view id="modifyOffer">
	
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<script src="<%=request.getContextPath()%>/js/prototype.js"
		type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/scriptaculous.js"
		type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/functions_ttv.js"
		type="text/javascript"></script>
	<title><h:outputText value="#{msg.confirmOffer_title}"></h:outputText></title>
	<link href="<%=request.getContextPath()%>/css/estilos_ttv.css"
		rel="stylesheet" type="text/css" />
	<script>
			function setIsinMainForm(isin,nombreIsin,codigoFungible){
				document.getElementById("confirmOfferForm:isinEspecie").value=isin;
				document.getElementById("confirmOfferForm:codigoFungible").value=codigoFungible;
				document.getElementById("confirmOfferForm:isinEspecie").onchange();				
			}
			
			function setInvestorCodeMainForm(cuentaInversionista,nombreInversionista){
				document.getElementById("confirmOfferForm:cuentaInversionista").value=cuentaInversionista;
				document.getElementById("confirmOfferForm:cuentaInversionista").onchange();				
			}
			
			function setDCVAccountMainForm(cuentaDCV){
				document.getElementById("confirmOfferForm:cuentaDCV").value=cuentaDCV;							
			}
		</script>
	</head>
	<body onclick="ocultarDivs()" onresize="setAlertspositions()"
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
							<td>
							<table width="193" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="42"><img
										src="<%=request.getContextPath()%>/images/poamonregistros.jpg"
										width="42" height="34"></td>
									<td class="originadorpes"><h:outputText
										value="#{msg.menu_confirmOfferLabel}" /></td>
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
										value="#{msg.menu_confirmOfferLabel}" /></td>
								</tr>
								<tr>
									<td width="100%"><br />
									<table width="90%" border="0" align="center" cellpadding="0"
										cellspacing="0" class="tablagenerica">
										<tr>
											<td class="tittablagenerica"><h:outputText
												value="#{msg.menu_confirmOfferLabel}" />
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
											<a4j:keepAlive beanName="confirmOfferJSF" /> <a4j:form
												id="confirmOfferForm">
												<table width="100%">
													<tr>
														<td align="right" width="350px">&nbsp;</td>
														<td><rich:messages id="errorMessages" layout="table"
															showSummary="true" showDetail="true"
															styleClass="generica"
															passedLabel="msg.confirmOffer_passedLabel"
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
															value="#{msg.confirmOffer_ttvIdLabel}"
															styleClass="generica" /></td>
														<td width="30%"><h:outputText
															value="#{confirmOfferJSF.idTTV}" styleClass="negrita" /></td>
														<td align="right" width="15%"><h:outputText
															value="#{msg.confirmOffer_fungibleLabel}"
															styleClass="generica" /></td>
														<td width="30%" align="left"><h:outputText styleClass="generica"
															id="codigoFungible"
															value="#{confirmOfferJSF.codigoFungible}">
														</h:outputText></td>
													</tr>
													<tr>
														<td align="right" width="15%"><h:outputText
															value="#{msg.confirmOffer_isinLabel}"
															styleClass="generica" /></td>
														<td width="30%" align="left"><h:outputText id="isinEspecie" styleClass="negrita"
														value="#{confirmOfferJSF.isinEspecie}"></h:outputText></td>
														<td align="right" width="15%"><h:outputText
															value="#{msg.confirmOffer_specieNameLabel}"
															styleClass="generica" /></td>
														<td width="40%" align="left"><h:outputText id="nombreEspecie"
															value="#{confirmOfferJSF.nombreEspecie}"
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
																value="#{msg.confirmOffer_amountTTVLabel}"
																styleClass="generica" /></td>
															<td width="30%" align="left"><h:outputText styleClass="generica"
																id="cantidadPrestar"
																value="#{confirmOfferJSF.cantidadPrestar}">
															</h:outputText></td>
															<td align="right" width="15%"><h:outputText
																value="#{msg.confirmOffer_rateTTVLabel}"
																styleClass="generica" /></td>
															<td width="40%" align="left"><h:outputText styleClass="generica"
																id="tasaPrestamo" value="#{confirmOfferJSF.tasaPrestamo}">
															</h:outputText></td>
														</tr>
														<tr>
															<td align="right" width="15%"><h:outputText
																value="#{msg.confirmOffer_haircuteRateTTVLabel}"
																styleClass="generica" /></td>
															<td width="30%" align="left"><h:outputText id="tasaCobertura"
																value="#{confirmOfferJSF.tasaCobertura}"
																styleClass="generica">
																<f:convertNumber pattern="####.##" />
															</h:outputText></td>
															<td align="right" width="15%"><h:outputText
																value="#{msg.confirmOffer_profitTTVLabel}"
																styleClass="generica" /></td>
															<td width="40%" align="left"><h:outputText id="prima"
																value="#{confirmOfferJSF.prima}" styleClass="generica">
																<f:convertNumber pattern="###,###,###,###,###,###.##" />
															</h:outputText></td>
														</tr>
														<tr>
															<td align="right" width="15%"><h:outputText
																value="#{msg.confirmOffer_valueTVVLabel}"
																styleClass="generica" /></td>
															<td width="30%" align="left"><h:outputText id="valorizado"
																value="#{confirmOfferJSF.valorizado}"
																styleClass="generica">
																<f:convertNumber pattern="###,###,###,###,###,###.##" />
															</h:outputText></td>
															<td align="right" width="15%"><h:outputText
																value="#{msg.confirmOffer_daysBetweenDatesLabel}"
																styleClass="generica" /></td>
															<td width="30%" align="left"><h:outputText id="plazo"
																value="#{confirmOfferJSF.plazo}" styleClass="generica" /></td>
														</tr>
														<tr>
															<td align="right" width="15%"><h:outputText
																value="#{msg.confirmOffer_registerDateLabel}"
																styleClass="generica" /></td>
															<td width="30%" align="left"><h:outputText styleClass="generica" id="fechaRegistro" value="#{confirmOfferJSF.fechaRegistro}">
																<f:convertDateTime pattern="dd/MM/yyyy"/>
															</h:outputText></td>
															<td align="right" width="15%"><h:outputText
																value="#{msg.confirmOffer_modeProfitPaymentLabel}"
																styleClass="generica" /></td>
															<td width="40%" align="left"><h:selectOneRadio
																id="formaPagoComision" styleClass="generica"
																value="#{confirmOfferJSF.formaPagoComision}"
																onclick="if(this.value==0){showAccountDCV({duration:0.7});}else{hideAccountDCV({duration:0.7});}">
																<f:selectItem id="pagoDVP"
																	itemLabel="#{msg.confirmOffer_modeProfitPaymentDVPLabel}"
																	itemValue="0" />
																<f:selectItem id="pagoLP"
																	itemLabel="#{msg.confirmOffer_modeProfitPaymentLPLabel}"
																	itemValue="1" />
															</h:selectOneRadio> <rich:effect name="hideAccountDCV" for="cuentaDCVPanel"
																type="Fade" /> <rich:effect name="showAccountDCV"
																for="cuentaDCVPanel" type="Appear" /></td>
														</tr>
														<tr>
															<td align="right" width="15%"><h:outputText
																value="#{msg.confirmOffer_endDateLabel}"
																styleClass="generica" /></td>
															<td width="30%" align="left"><h:outputText styleClass="generica" id="fechaVencimiento" value="#{confirmOfferJSF.fechaVencimiento}">
																<f:convertDateTime pattern="dd/MM/yyyy"/>
															</h:outputText></td>
															<td align="left" colspan="2" width="50%"><a4j:outputPanel
																id="cuentaDCVPanel">
																<table width="100%" cellpadding="0" cellspacing="0"
																	border="0">
																	<tr>
																		<td align="right" width="27%"><h:outputText
																			id="cuentaDCVLabel"
																			value="#{msg.confirmOffer_DCVaccountNumberLabel}"
																			styleClass="generica" /></td>
																		<td width="1%">&nbsp;</td>
																		<td width="72%"><h:inputText 
																			styleClass="generica" id="cuentaDCV"
																			value="#{confirmOfferJSF.cuentaDCV}" /><h:outputLink
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
															value="#{msg.confirmOffer_investorAccountCodeLabel}"
															styleClass="generica" /></td>
															<td width="40%" align="left"><h:inputText styleClass="generica"
															id="cuentaInversionista" 
															value="#{confirmOfferJSF.cuentaInversionista}">
															<a4j:support event="onchange"
																reRender="nombreInversionista"
																 />
															</h:inputText> <h:outputLink value="#" id="linkOpenInvestorAccountHelp">
															<f:verbatim>
																<img style="border: 0px solid;"
																	src="<%=request.getContextPath()%>/images/detalle.gif" />
															</f:verbatim>
															<rich:componentControl for="investorAccountHelpPanel"
																attachTo="linkOpenInvestorAccountHelp" operation="show"
																event="onclick" />
															</h:outputLink></td>
															<td align="right" width="15%"><h:outputText
															value="#{msg.confirmOffer_investorAccountNameLabel}"
															styleClass="generica" /></td>
														<td width="40%"><h:outputText
															id="nombreInversionista"
															value="#{confirmOfferJSF.nombreInversionista}"
															styleClass="negrita" /></td>
														</tr>
													</table>
												</a4j:outputPanel>
												<table width="100%">
													<tr>
														<td align="right" width="60%"><h:commandButton
															styleClass="button" action="homeOriginator"
															onclick="if(!confirm('#{msg.confirmOffer_cancelButtonConfirmMessage}')){return false;};"
															value="#{msg.confirmOffer_cancelButtonText}"></h:commandButton></td>
														<td><h:commandButton styleClass="button"
															id="modificarOferta" type="submit"
															action="#{confirmOfferJSF.confirmarOferta}"
															onclick="if(!confirm('#{msg.confirmOffer_saveButtonConfirmMessage}')){return false;}"
															value="#{msg.confirmOffer_saveButtonText}"
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
