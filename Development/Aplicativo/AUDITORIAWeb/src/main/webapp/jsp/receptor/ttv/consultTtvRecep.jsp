	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=iso-8859-1" language="java" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<f:subview id="consultOffer">
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<script src="<%=request.getContextPath()%>/js/prototype.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/scriptaculous.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/functions_ttv.js" type="text/javascript"></script>
	<title><h:outputText value="#{msg.consultOffer_title}"></h:outputText></title>
	<script>
	function setIsinMainForm(isin,nombreIsin,codigoFungible){
				document.getElementById("consultOfferForm:isinEspecie").value=isin;
								
			}
	</script>
	<link href="<%=request.getContextPath()%>/css/estilos_ttv.css" rel="stylesheet" type="text/css" />
	</head>
	<body onclick="ocultarDivs()" onresize="setAlertspositions()"
		onload="MM_preloadImages('<%=request.getContextPath()%>/images/boriginador_f2.jpg','<%=request.getContextPath()%>/images/breceptor_f2.jpg')">
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="tablaexterna">
		<jsp:include page="/jsp/receptor/common/header.jsp" />
		
		<tr>
			<td>
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td>
					<table align="center" border="0" cellpadding="0" cellspacing="0" width="100%">
						<tbody>
							<tr>
								<td width="100%">
								<table align="center" border="0" cellpadding="0" cellspacing="0" width="95%">
									<tr>
											<td>
											<table border="0" cellpadding="0" cellspacing="0" width="193">
												<tr>
													<td width="42">
														<img width="42" height="34" src="<%=request.getContextPath()%>/images/pvinadmonregistros.jpg">
													</td>
													<td class="receptorpes">
														<h:outputText value="#{msg.menu_consultTtvRecepLabel}" />
													</td>
													<td width="31">
														<img width="16" height="34" src="<%=request.getContextPath()%>/images/pborderecho.jpg">
													</td>
												</tr>
											</table>
											</td>
										</tr>
										<tr>
											<td class="tablapesta">
											<table border="0" cellpadding="0" cellspacing="0" width="100%">
												<tbody>
													<tr>
														<td colspan="2" class="titablapesta">Administraci&oacute;n de registros | Consulta TTVs vigentes con originador</td>
													</tr>
													<tr>
														<td width="100%"><br>
														
														<table class="tablagenerica" align="center" border="0" cellpadding="0" cellspacing="0" width="90%">
															<tbody>
																<tr>
																	<td class="tittablagenerica">Consulta TTVs vigentes con originador</td>
																</tr>
																<tr>
																	<td align="center" height="99"><br>
																	<a4j:form id="consultOfferForm">
																	<table border="0" cellpadding="0" cellspacing="0" width="90%">
																		<tbody>
																			<tr>
																				<td>
																				
																				<table border="1" bordercolor="#D7ECFD" width="500">
																					<tr>
																						<td><br/>
																						
																							<table cellpadding="0" cellspacing="0">
																								<tbody>
																									<tr>
																										<td class="generica" width="100" align="right"><h:outputText
																											value="#{msg.consult_isinLabel}" /></td>
																										<td align="left" width="200px"><h:inputText styleClass="generica" id="isinEspecie" 
																										       value="#{ConsultTTVRecepJSF.codIsinUnido}" /><h:outputLink value="#" id="linkOpenSpecie">
																												<f:verbatim>
																													<img style="border: 0px solid;" src="<%=request.getContextPath()%>/images/detalle.gif" />
																												</f:verbatim>
																												<rich:componentControl for="isinHelpPanel" attachTo="linkOpenSpecie" operation="show" event="onclick" />
																											</h:outputLink></td>
																																																																												</tr>
																									<tr>
																										<td height="5"></td>
																									</tr>
																									<tr>
																										<td class="generica" width="100" align="right"><h:outputText
																											value="#{msg.consult_dateExpirationLabel}" /></td>
																										<td align="left" width="200px">
																											<rich:calendar id="fechaRegistroIni" value="#{ConsultTTVRecepJSF.fechaRegistroIni}" 
																														   datePattern="dd/MM/yyyy" />
																										</td>
																										<td align="left" width="200px">
																											<rich:calendar id="fechaRegistroFin" value="#{ConsultTTVRecepJSF.fechaRegistroFin}" 
																														   datePattern="dd/MM/yyyy" />
																										</td>
																									</tr>
																									<tr>
																										<td height="5"></td>
																									</tr>
																									<tr>
																									    <td class="generica" width="100" align="right"><h:outputText
																											value="#{msg.consult_timeLineLabel}" /></td>
																										<td align="left"><h:inputText styleClass="generica" size="8" id="plazo"
																										                    value="#{ConsultTTVRecepJSF.plazo}"/></td>
																									</tr>
																									<tr>
																										<td height="5"></td>
																									</tr>
																									<tr>
																										<td colspan="4" align="right"><a4j:commandButton type="submit" value="Consultar" 
																										    styleClass="button" id="consultarButton"
																											reRender="consultaPanel,pager" action="#{ConsultTTVRecepJSF.consultarTTVOri}" 
																											onclick="this.disabled=true" 
																			           						oncomplete="this.disabled=false"/></td>
																									</tr>
																								</tbody>
																							</table>
																							
																						 <br />
																						</td>
																					</tr>
																				</table>
																				
																				<br />
																				</td>
																			</tr>
																			<tr>
																				<td width="100%">
																				
																					 <rich:panel id="consultaPanel">
																					 <div scroll="yes" style="overflow: auto;width: 800px;">
																										
																										 <rich:dataTable  id="consultaTable" rendered="#{ConsultTTVRecepJSF.mostrarConsulta}"
																											value="#{ConsultTTVRecepJSF.TTVList}" var="row"
																											styleClass="tablagrilla" border="0" cellpadding="4"
																											cellspacing="1"
																											headerClass="headergrilla headergrilla headergrilla"
																											rowClasses="fila1grilla,fila2grilla"
																											columnClasses="col100,col200,col100">
																											<rich:column>
																												<f:facet name="header">
																													<h:outputText value="No. TTV" styleClass="headertext" />
																												</f:facet>
																												<h:outputText id="idTtv" value='#{row["id_ttv"]}'
																													styleClass="texto" />
																											</rich:column>
																											<rich:column>
																												<f:facet name="header">
																													<h:outputText value="ISIN ESPECIE" styleClass="headertext" />
																											</f:facet>
																											<h:outputText id="isinEspecie" value='#{row["codigo_isin_unido"]}'
																												styleClass="texto" />
																										</rich:column>
																										<rich:column>
																											<f:facet name="header">
																												<h:outputText value="Descripción especie" styleClass="headertext" />
																											</f:facet>
																										<h:outputText value='#{row["descripcion_especie"]}'
																											styleClass="texto" />
																									</rich:column>
																									<rich:column>
																										<f:facet name="header">
																											<h:outputText value="Fecha Registro" styleClass="headertext" />
																										</f:facet>
																										<h:outputText value='#{row["fecha_registro"]}'
																											styleClass="texto" />
																									</rich:column>
																									<rich:column>
																										<f:facet name="header">
																											<h:outputText value="Fecha Vencimiento" styleClass="headertext" />
																										</f:facet>
																										<h:outputText value='#{row["fecha_vencimiento"]}'
																											styleClass="texto" />
																									</rich:column>
																									<rich:column>
																										<f:facet name="header">
																											<h:outputText value="Cantidad" styleClass="headertext" />
																										</f:facet>
																										<h:outputText value='#{row["cantidad"]}'
																											styleClass="texto" />
																									</rich:column>
																									<rich:column>
																										<f:facet name="header">
																											<h:outputText value="Plazo" styleClass="headertext" />
																										</f:facet>
																										<h:outputText value='#{row["plazo"]}'
																											styleClass="texto" />
																									</rich:column>
																									<rich:column>
																										<f:facet name="header">
																											<h:outputText value="Tasa" styleClass="headertext" />
																										</f:facet>
																										<h:outputText value='#{row["tasa_prestamo"]}'
																											styleClass="texto" />
																									</rich:column>
																									<rich:column>
																										<f:facet name="header">
																											<h:outputText value="Detalle" styleClass="headertext" />
																										</f:facet>
																										<a4j:commandButton value="..." styleClass="button" id="selectButton"
																										                   onclick="detalle('#{row[\"id_ttv\"]}')" />
																									</rich:column>
																								</rich:dataTable>
																								
																								
																								
																								</div>
																								</rich:panel>	
																								
																								<rich:panel id="pager" >
																								
																									<div scroll="yes" style="overflow: auto;width: 800px;">
																									    
																									    
																									   	<a4j:commandLink  action="#{ConsultTTVRecepJSF.consultarTTVPrimeraPagina}" reRender="consultaPanel,pager" rendered="#{ConsultTTVRecepJSF.firstPage}">
																											<img style="border: 0px solid;" src="<%=request.getContextPath()%>/images/izqusola.gif" />
																										</a4j:commandLink> 
																										
																										<a4j:commandLink  action="#{ConsultTTVRecepJSF.consultarTTVAnteriorPagina}" reRender="consultaPanel,pager" rendered="#{ConsultTTVRecepJSF.before}">
																											<img style="border: 0px solid;" src="<%=request.getContextPath()%>/images/izqudoble.gif" />
																										</a4j:commandLink>																										
																										
																										<h:outputText value="#{msg.pager_page}" styleClass="linkazul" />
																										<h:outputText value="#{ConsultTTVRecepJSF.iniPagina}" styleClass="linkazul"/>
																										<h:outputText value="#{msg.pager_of}" styleClass="linkazul"/>
																										<h:outputText value="#{ConsultTTVRecepJSF.numPaginas}" styleClass="linkazul"/>
																										
																										<a4j:commandLink  action="#{ConsultTTVRecepJSF.consultarTTVSiguientePagina}" reRender="consultaPanel,pager" rendered="#{ConsultTTVRecepJSF.next}">
																											<img style="border: 0px solid;" src="<%=request.getContextPath()%>/images/deredoble.gif" />
																										</a4j:commandLink> 
																										<a4j:commandLink  action="#{ConsultTTVRecepJSF.consultarTTVUltimaPagina}" reRender="consultaPanel,pager" rendered="#{ConsultTTVRecepJSF.lastPage}">
																											<img style="border: 0px solid;" src="<%=request.getContextPath()%>/images/deresola.gif"/>
																										</a4j:commandLink> 
																										
																										<h:outputText value="#{msg.pager_total}" styleClass="linkazul" />
																										<h:outputText value="#{ConsultTTVRecepJSF.numRegistros}" styleClass="linkazul" />
																		
																										
																									</div>
																									<div style="display:none;" >
																										<h:inputText value="#{ConsultTTVRecepJSF.iniPagina}"/>
																										<h:inputText value="#{ConsultTTVRecepJSF.paginador}"/>
																									</div>
																								</rich:panel>
																															  

																																<br>
																																			</td>
																																		</tr>
																															
																													</table>
																											</a4j:form>
																												</td>
																											</tr>
																								</tbody>
																						</table>
																						<br>
																					</td>
					
					                                                         
					
					
					
					
					
					
																		</tr>
														</table>
														</td>
												</tr>
													
												<jsp:include page="/jsp/common/footer.jsp" />
									</table>
	<a4j:include id="helpSpecie" viewId="/jsp/common/isinHelp.jsp" />	
		</body>
	</html>
</f:subview>
