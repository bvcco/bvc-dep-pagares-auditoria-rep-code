<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<f:subview id="investorAccountHelp">
	
	<rich:modalPanel id="investorAccountHelpPanel" width="600" height="500">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{msg.investorAccountHelp_title}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>				
				<h:graphicImage value="/images/modal/close.png"
					style="cursor:pointer" id="hidelink" />
				<rich:componentControl for="investorAccountHelpPanel"
					attachTo="hidelink" operation="hide" event="onclick" />
			</h:panelGroup>
		</f:facet>
		<a4j:form id="investorAccountHelpForm" ajaxSubmit="true">
			<rich:panel id="datosInversionistaPanel" bodyClass="inpanelBody"
				style="width:98%">
				<f:facet name="header">
					<h:panelGroup>
						<h:outputText value="#{msg.investorAccountHelp_investorSectionLabel}"></h:outputText>
					</h:panelGroup>
				</f:facet>
				<table width="90%">
					<tr>
						<td align="right"><span class="generica"><h:outputText
							value="#{msg.investorAccountHelp_investorCodeLabel}" /></span></td>
						<td><h:inputText id="cuentaInversionista"
							value="#{investorAccountHelpJSF.cuentaInversionista}">
						</h:inputText></td>
					</tr>
					<tr>
						<td align="right"><span class="generica"><h:outputText
							value="#{msg.investorAccountHelp_investorNameLabel}" /></span></td>
						<td><h:inputText id="nombreInversionista"
							value="#{investorAccountHelpJSF.nombreInversionista}">
						</h:inputText></td>
					</tr>
					<tr>
						<td align="right"><span class="generica"><h:outputText
							value="#{msg.investorAccountHelp_documentTypeLabel}" /></span></td>
						<td><h:selectOneMenu id="claseDocumento"
							binding="#{investorAccountHelpJSF.claseDocumentoSelectOne}"
							styleClass="generica">
							<f:selectItem itemValue="-1"
								itemLabel="#{msg.investorAccountHelp_defaultValue}" />
							<f:selectItems
								value="#{investorAccountHelpJSF.claseDocumentoSelectOneList}" />
						</h:selectOneMenu></td>
					</tr>
					<tr>
						<td align="right"><span class="generica"><h:outputText
							value="#{msg.investorAccountHelp_idNumberLabel}" /></span></td>
						<td><h:inputText id="numeroIdentificacion"
							value="#{investorAccountHelpJSF.numeroIdentificacion}">
						</h:inputText></td>
					</tr>
					<tr>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td align="center"></td>
						<td>
						<table>
							<tr>
								<td><a4j:commandButton type="submit" value="#{msg.investorAccountHelp_searchButton}"
									styleClass="button" id="consultarInversionistaButton"
									reRender="consultaInvestorAccountPanel"
									action="#{investorAccountHelpJSF.searchInvestorAccounts}"
									onclick="this.disabled=true;showWaitingInvestorSearch({duration:0.7})"
									oncomplete="this.disabled=false;hideWaitingInvestorSearch({duration:0.7})" />
								<rich:effect name="hideWaitingInvestorSearch"
									for="imgWaitingInvestorHelpPanel" type="DropOut" /> <rich:effect
									name="showWaitingInvestorSearch"
									for="imgWaitingInvestorHelpPanel" type="Appear" /></td>
								<td>
								<div id="imgWaitingInvestorHelpPanel" style="display: none"><img
									src="<%=request.getContextPath()%>/images/indicator.gif"
									width="16px" height="16px" alt="please wait..." /></div>
								</td>
								<td><a4j:commandButton type="button" value="#{msg.investorAccountHelp_cancelButton}"
									styleClass="button" id="cancelarButtonInvestorAccountHelp" /><rich:componentControl
									for="investorAccountHelpPanel"
									attachTo="cancelarButtonInvestorAccountHelp" operation="hide"
									event="onclick" /></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
			</rich:panel>
		</a4j:form>
		<br />
		<rich:panel id="consultaInvestorAccountPanel" style="width:98%">
			<h:outputText value="#{msg.investorAccountHelp_nodataLabel}" rendered="#{(investorAccountHelpJSF.inversionistasConsultaList!=null)&& (!investorAccountHelpJSF.existenDatos)}"></h:outputText>
			<div scroll="yes"
				style="overflow: auto; width: 570px; height: 250px;"><a4j:form
				id="consultaCuentaInversionistaForm">
				<rich:dataTable rendered="#{investorAccountHelpJSF.existenDatos}"
					value="#{investorAccountHelpJSF.inversionistasConsultaList}"
					var="row" styleClass="tablagrilla" border="0" cellpadding="4"
					cellspacing="1"
					headerClass="headergrilla headergrilla headergrilla headergrilla headergrilla headergrilla"
					rowClasses="fila1grilla,fila2grilla"
					columnClasses="col50,col50,col50,col100,col200,col50">
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#{msg.investorAccountHelp_col1HeaderLabel}"
								styleClass="headertext" />
						</f:facet>
						<h:outputText value='#{row["cuenta_inversionista"]}'
							styleClass="texto" />
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#{msg.investorAccountHelp_col2HeaderLabel}"
								styleClass="headertext" />
						</f:facet>
						<h:outputText value='#{row["tipo_relacion_dueno"]}'
							styleClass="texto" />
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#{msg.investorAccountHelp_col3HeaderLabel}"
								styleClass="headertext" />
						</f:facet>
						<h:outputText value='#{row["clase_documento"]}'
							styleClass="texto" />
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#{msg.investorAccountHelp_col4HeaderLabel}"
								styleClass="headertext" />
						</f:facet>
						<h:outputText value='#{row["identificacion"]}'
							styleClass="texto" />
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#{msg.investorAccountHelp_col5HeaderLabel}"
								styleClass="headertext" />
						</f:facet>
						<h:outputText value='#{row["nombre_inversionista"]}'
							styleClass="texto" />
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#{msg.investorAccountHelp_col6HeaderLabel}"
								styleClass="headertext" />
						</f:facet>
						<a4j:commandButton value="..." styleClass="button"
							id="selectButton"
							onclick="setInvestorCodeMainForm('#{row["cuenta_inversionista"]}','#{row["nombre_inversionista"]}')" />
						<rich:componentControl for="investorAccountHelpPanel"
							attachTo="selectButton" operation="hide" event="onclick" />
					</rich:column>
				</rich:dataTable>
			</a4j:form></div>
		</rich:panel>

	</rich:modalPanel>
</f:subview>