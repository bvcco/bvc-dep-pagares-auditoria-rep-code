<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<f:subview id="accountDCVHelp">

<rich:modalPanel id="accountDCVHelpPanel" width="600" height="500">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{msg.accountDCVHelp_title}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>				
				<h:graphicImage value="/images/modal/close.png"
					style="cursor:pointer" id="hidelink" />
				<rich:componentControl for="accountDCVHelpPanel" attachTo="hidelink"
					operation="hide" event="onclick" />
			</h:panelGroup>
		</f:facet>		
		<a4j:form id="accountDCVHelpForm" ajaxSubmit="true">
			<rich:panel id="datosBancoPanel" bodyClass="inpanelBody"
				style="width:98%">
				<f:facet name="header">
					<h:panelGroup>
						<h:outputText value="#{msg.accountDCVHelp_title}"></h:outputText>
					</h:panelGroup>
				</f:facet>
				<table width="90%">
					<tr>
						<td align="right"><span class="generica"><h:outputText
							value="#{msg.accountDCVHelp_localBankLabel}" /></span></td>
						<td><rich:comboBox selectFirstOnUpdate="true"
							binding="#{accountDCVHelpJSF.bancosSelectOne}"
							defaultLabel="#{msg.accountDCVHelp_allBanks}" width="250px">
							<f:selectItem itemValue="#{msg.accountDCVHelp_allBanks}" />
							<f:selectItems value="#{accountDCVHelpJSF.bancosSelectOneList}" />
						</rich:comboBox></td>
					</tr>
					<tr>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td align="center"></td>
						<td>
						<table>
							<tr>
								<td><a4j:commandButton type="submit" value="#{msg.accountDCVHelp_searchButton}"
									styleClass="button" id="consultarCuentasButton"
									reRender="consultaDCVAccountPanel"
									action="#{accountDCVHelpJSF.searchBankAccounts}"
									onclick="this.disabled=true;showWaitingDCVSearch({duration:0.7})"
									oncomplete="this.disabled=false;hideWaitingDCVSearch({duration:0.7})" />
								<rich:effect name="hideWaitingDCVSearch"
									for="imgWaitingDCVHelpPanel" type="DropOut" /> <rich:effect
									name="showWaitingDCVSearch" for="imgWaitingDCVHelpPanel"
									type="Appear" /></td>
								<td>
								<div id="imgWaitingDCVHelpPanel" style="display: none"><img
									src="<%=request.getContextPath()%>/images/indicator.gif"
									width="16px" height="16px" alt="please wait..." /></div>
								</td>
								<td><a4j:commandButton type="button" value="#{msg.accountDCVHelp_cancelButton}"
									styleClass="button" id="cancelarButtonDCVAccountHelp" />
									<rich:componentControl
									for="accountDCVHelpPanel"
									attachTo="cancelarButtonDCVAccountHelp" operation="hide"
									event="onclick" /></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
			</rich:panel>
		</a4j:form>
		<br />
		<rich:panel id="consultaDCVAccountPanel" style="width:98%">
			<h:outputText value="#{msg.investorAccountHelp_nodataLabel}" rendered="#{accountDCVHelpJSF.cuentasConsultaList!=null && !accountDCVHelpJSF.existenDatos}"></h:outputText>
			<div scroll="yes"
				style="overflow: auto; width: 570px; height: 250px;"><a4j:form
				id="consultaCuentasDCVForm">
				<rich:dataTable rendered="#{accountDCVHelpJSF.existenDatos}"
					value="#{accountDCVHelpJSF.cuentasConsultaList}"
					var="row" styleClass="tablagrilla" border="0" cellpadding="4"
					cellspacing="1"
					headerClass="headergrilla headergrilla headergrilla headergrilla"
					rowClasses="fila1grilla,fila2grilla"
					columnClasses="col200,col50,col50,col50">
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#{msg.accountDCVHelp_col1HeaderLabel}"
								styleClass="headertext" />
						</f:facet>
						<h:outputText value='#{row["nombre_banco"]}'
							styleClass="texto" />
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#{msg.accountDCVHelp_col2HeaderLabel}"
								styleClass="headertext" />
						</f:facet>
						<h:outputText value='#{row["nro_cuenta_banco"]}'
							styleClass="texto" />
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#{msg.accountDCVHelp_col3HeaderLabel}"
								styleClass="headertext" />
						</f:facet>
						<h:outputText value='#{row["nro_cuenta_corriente"]}'
							styleClass="texto" />
					</rich:column>								
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#{msg.accountDCVHelp_col4HeaderLabel}"
								styleClass="headertext" />
						</f:facet>
						<a4j:commandButton value="..." styleClass="button"
							id="selectButton"
							onclick="setDCVAccountMainForm('#{row["nro_cuenta_banco"]}');" />
						<rich:componentControl for="accountDCVHelpPanel"
							attachTo="selectButton" operation="hide" event="onclick" />
					</rich:column>
				</rich:dataTable>
			</a4j:form></div>
		</rich:panel>		
	</rich:modalPanel>
</f:subview>