<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<f:subview id="isinHelp">
	
	<rich:modalPanel id="isinHelpPanel" width="750" height="600">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{msg.isinHelp_title}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>				
				<h:graphicImage value="/images/modal/close.png"
					style="cursor:pointer" id="hidelink" />
				<rich:componentControl for="isinHelpPanel" attachTo="hidelink"
					operation="hide" event="onclick" />
			</h:panelGroup>
		</f:facet>
		<a4j:form id="isinHelpForm" ajaxSubmit="true">
			<rich:panel id="datosEspeciePanel" bodyClass="inpanelBody" style="width:98%">
				<f:facet name="header">
					<h:panelGroup>
						<h:outputText value="#{msg.isinHelp_isinSectionLabel}"></h:outputText>
					</h:panelGroup>
				</f:facet>
				<table width="100%">
					<tr>
						<td align="right"><span class="generica"><h:outputText
							value="#{msg.isinHelp_issuerLabel}" /></span></td>
						<td>
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td><rich:comboBox selectFirstOnUpdate="true"
									binding="#{isinHelpJSF.emisoresSelectOne}"
									defaultLabel="#{msg.isinHelp_defaultValue}" width="350px">
									<a4j:support event="onselect"
										reRender="isinHelpForm:clasesTituloEmisor"
										onsubmit="showWaitingEmisor({duration:0.7})"
										oncomplete="hideWaitingEmisor({duration:0.7})" />
									<f:selectItems value="#{isinHelpJSF.emisoresSelectOneList}" />
								</rich:comboBox> <rich:effect name="hideWaitingEmisor" for="imgWaitingEmisor"
									type="DropOut" /> <rich:effect name="showWaitingEmisor"
									for="imgWaitingEmisor" type="Appear" /></td>
								<td>								
								<span>&nbsp;</span>
								<div id="imgWaitingEmisor" style="display:none"><img
									src="<%=request.getContextPath()%>/images/indicator.gif"
									width="16px" height="16px" alt="please wait..." /></div>
								</td>
							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td align="right"><span class="generica"><h:outputText
							value="#{msg.isinHelp_claseTituloLabel}" /></span></td>
						<td><h:selectOneMenu id="clasesTituloEmisor"
							binding="#{isinHelpJSF.claseTituloSelectOne}"
							styleClass="generica">
							<f:selectItem itemValue="-1" itemLabel="#{msg.isinHelp_defaultValue}" />
							<f:selectItems value="#{isinHelpJSF.claseTituloSelectOneList}" />
						</h:selectOneMenu></td>
					</tr>
				</table>
			</rich:panel>
			<rich:panel id="condicionesFungibilidadPanel" bodyClass="inpanelBody" style="width:98%">
				<f:facet name="header">
					<h:panelGroup>
						<h:outputText value="#{msg.isinHelp_fungibleSectionLabel}"></h:outputText>
					</h:panelGroup>
				</f:facet>
				<table width="100%">
					<tr>
						<td align="right"><span class="generica"><h:outputText
							value="#{msg.isinHelp_expeditionDateLabel}" /></span></td>
						<td>						
						<rich:calendar value="#{isinHelpJSF.fechaExpedicion}" popup="true"
                        datePattern="dd/MM/yyyy"
                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:200px"/>                        		
						</td>
						<td align="right"><span class="generica"><h:outputText
							value="#{msg.isinHelp_dueDateLabel}" /></span></td>
						<td>
						<rich:calendar value="#{isinHelpJSF.fechaVencimiento}" popup="true"
                        datePattern="dd/MM/yyyy"
                        showApplyButton="false" cellWidth="24px" cellHeight="22px" style="width:200px"/>   
						</td>
					</tr>
					<tr>
						<td align="right"><span class="generica"><h:outputText
							value="#{msg.isinHelp_modalityLabel}" /></span></td>
						<td>
						<h:selectOneMenu id="modalidadFungible"
							binding="#{isinHelpJSF.modalidadSelectOne}"
							styleClass="generica">
							<f:selectItem itemValue="-1" itemLabel="#{msg.isinHelp_defaultValue}" />
							<f:selectItem itemValue="1" itemLabel="#{msg.isinHelp_modalityOpt1}" />
							<f:selectItem itemValue="2" itemLabel="#{msg.isinHelp_modalityOpt2}" />
						</h:selectOneMenu>
						</td>
						<td align="right"><span class="generica"><h:outputText
							value="#{msg.isinHelp_rateTypeLabel}" /></span></td>
						<td>
						<h:selectOneMenu id="tipoTasa"
							binding="#{isinHelpJSF.tipoTasaSelectOne}"
							styleClass="generica">
							<f:selectItem itemValue="-1" itemLabel="#{msg.isinHelp_defaultValue}" />
							<f:selectItems value="#{isinHelpJSF.tipoTasaSelectOneList}" />						
						</h:selectOneMenu>
						</td>
					</tr>
					<tr>
						<td align="right"><span class="generica"><h:outputText
							value="#{msg.isinHelp_regularityLabel}" /></span></td>
						<td>
						<h:selectOneMenu id="periodicidad"
							binding="#{isinHelpJSF.periodicidadSelectOne}"
							styleClass="generica">
							<f:selectItem itemValue="-1" itemLabel="#{msg.isinHelp_defaultValue}" />
							<f:selectItems value="#{isinHelpJSF.periodicidadSelectOneList}" />						
						</h:selectOneMenu></td>
						<td align="right"><span class="generica"><h:outputText
							value="#{msg.isinHelp_fixedNounRateLabel}" /></span></td>
						<td><h:inputText id="tasaNominal"
							value="#{isinHelpJSF.tasaNominal}">
						</h:inputText></td>
					</tr>
					<tr>
						<td align="right"><span class="generica"><h:outputText
							value="#{msg.isinHelp_spreadLabel}" /></span></td>
						<td colspan="3"><h:inputText id="spread"
							value="#{isinHelpJSF.spread}">
						</h:inputText></td>
					</tr>
				</table>
				<table width="100%">
					<tr>
						<td align="center">
						<table>
							<tr>
								<td><a4j:commandButton type="submit" value="#{msg.isinHelp_searchButton}"
									styleClass="button" id="consultarIsinButton"
									reRender="consultaIsinPanel"
									action="#{isinHelpJSF.searchByFilter}"
									onclick="this.disabled=true;showWaitingIsinPanel({duration:0.7})"
									oncomplete="this.disabled=false;hideWaitingIsinPanel({duration:0.7})" />									
								<rich:effect name="hideWaitingIsinPanel" for="imgWaitingIsinPanel"
									type="DropOut" /> <rich:effect name="showWaitingIsinPanel"
									for="imgWaitingIsinPanel" type="Appear" /></td>
								<td>
								<div id="imgWaitingIsinPanel" style="display: none"><img
									src="<%=request.getContextPath()%>/images/indicator.gif"
									width="16px" height="16px" alt="please wait..." /></div>
								</td>
								<td><a4j:commandButton type="button" value="#{msg.isinHelp_cancelButton}"
									styleClass="button" id="cancelarButtonIsinHelp" /> <rich:componentControl
									for="isinHelpPanel" attachTo="cancelarButtonIsinHelp" operation="hide"
									event="onclick" /></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
			</rich:panel>
		</a4j:form>
		<rich:panel id="consultaIsinPanel" style="width:98%">
			<center>
			<h:outputText value="#{msg.isinHelp_nodataLabel}" rendered="#{isinHelpJSF.especiesConsultaList!=null && (!isinHelpJSF.existenDatos) }"></h:outputText>
			</center>
			<div scroll="yes"
				style="overflow: auto; width: 720px; height: 260px;"><a4j:form
				id="consultaIsinForm">
				<rich:dataTable id="consultaTable"
					rendered="#{isinHelpJSF.existenDatos}"
					value="#{isinHelpJSF.especiesConsultaList}" var="row"
					styleClass="tablagrilla" border="0" cellpadding="4" cellspacing="1"
					headerClass="headergrilla headergrilla headergrilla headergrilla headergrilla headergrilla headergrilla headergrilla headergrilla"
					rowClasses="fila1grilla,fila2grilla"
					columnClasses="col100,col100,col100,col100,col100,col100,col100,col100,col100">
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#{msg.isinHelp_col1HeaderLabel}"
								styleClass="headertext" />
						</f:facet>
						<h:outputText id="isinHelpISIN"
							value='#{row["especie"].codigo_isin_unido}' styleClass="texto" />
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#{msg.isinHelp_col2HeaderLabel}"
								styleClass="headertext" />
						</f:facet>
						<h:outputText value='#{row["fungible"].codigo_fungible}'
							styleClass="texto" />
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#{msg.isinHelp_col3HeaderLabel}"
								styleClass="headertext" />
						</f:facet>
						<h:outputText value='#{row["especie"].descripcion_especie}'
							styleClass="texto" />
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#{msg.isinHelp_col4HeaderLabel}"
								styleClass="headertext" />
						</f:facet>
						<h:outputText value='#{row["fungible"].fecha_expedicion}'
							styleClass="texto" >
							<f:convertDateTime pattern="dd/MM/yyyy"/>
						</h:outputText>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#{msg.isinHelp_col5HeaderLabel}"
								styleClass="headertext" />
						</f:facet>
						<h:outputText value='#{row["fungible"].fecha_vencimiento}'
							styleClass="texto" >
						<f:convertDateTime pattern="dd/MM/yyyy"/>	
						</h:outputText>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#{msg.isinHelp_col6HeaderLabel}"
								styleClass="headertext" />
						</f:facet>
						<h:outputText value='#{row["nombreTipoTasa"]}'
							styleClass="texto" />
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#{msg.isinHelp_col7HeaderLabel}"
								styleClass="headertext" />
						</f:facet>
						<h:outputText value='#{row["nombrePeriodicidad"]}'
							styleClass="texto" />
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#{msg.isinHelp_col8HeaderLabel}"
								styleClass="headertext" />
						</f:facet>
						<h:outputText value='#{row["fungible"].modalidad==1?(msg.isinHelp_modalityOpt1):(msg.isinHelp_modalityOpt2)}'
							styleClass="texto" >
							</h:outputText>
					</rich:column>
					<rich:column>
						<f:facet name="header">
							<h:outputText value="#{msg.isinHelp_col9HeaderLabel}"
								styleClass="headertext" />
						</f:facet>
						<a4j:commandButton value="..." styleClass="button"
							id="selectButton"
							onclick="setIsinMainForm('#{row["especie"].codigo_isin_unido}','#{row["especie"].descripcion_especie}','#{row["fungible"].codigo_fungible}')" />
						<rich:componentControl for="isinHelpPanel" attachTo="selectButton"
							operation="hide" event="onclick" />
					</rich:column>
				</rich:dataTable>
			</a4j:form></div>
		</rich:panel>
	</rich:modalPanel>	
</f:subview>
