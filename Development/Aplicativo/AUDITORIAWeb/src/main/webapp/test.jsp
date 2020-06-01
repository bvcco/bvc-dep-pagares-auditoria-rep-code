<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test page</title>
</head>
<body>

<f:view>
	<f:loadBundle
		basename="com.deceval.ttv.web.resources.messages.MessagesResources"
		var="msg" />
	<h:form>
		<h:outputLabel value="#{msg.number1label}"></h:outputLabel>
		<h:inputText id="number1" value="#{testJSF.number1}"}>
			<f:validateLongRange minimum="0" maximum="15000"></f:validateLongRange>
			<f:validateLength minimum="0" maximum="5" />
		</h:inputText>
		<h:message for="number1" id="number1ErrorMessage" />
		<br />
		<h:outputLabel value="#{msg.number2label}"></h:outputLabel>
		<h:inputText id="number2" value="#{testJSF.number2}"}>
			<f:validateLongRange minimum="0" maximum="15000"></f:validateLongRange>
			<f:validateLength minimum="0" maximum="5" />
		</h:inputText>
		<h:message for="number2" id="number2ErrorMessage" />
		<br />
		<h:commandButton value="#{msg.addButton}" id="sumarButton"
			action="#{testJSF.addNumbers}"></h:commandButton>
		<h:commandButton value="#{msg.updatePropertiesButton}"
			id="updatePropertiesButton" action="#{testJSF.updateProperties}"></h:commandButton>
		<br />
		<h:outputLabel value="#{testJSF.resultLabel}" />
		<br />
		<h:messages id="globalMessages" layout="table" globalOnly="true"
			showDetail="true" showSummary="true"></h:messages>
	</h:form>
	<a4j:form>
		<rich:dataTable value="#{testJSF.listadoElementos}" var="row">
			<h:column>
				<f:facet name="header">
					<h:outputText value="Codigo isin unido" styleClass="headertext" />
				</f:facet>
				<h:inputText id="codigo_isin_unido" value='#{row.codigoIsinUnido}'
					styleClass="texto">
					<a4j:support action="#{testJSF.updateIdTTV}" event="onchange"
						reRender="idTTV" actionListener="#{testJSF.rowSelected}">
						<f:attribute name="codigo_isin_unido" value="#{row}" />
					</a4j:support>
				</h:inputText>
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Monto actual" styleClass="headertext" />
				</f:facet>
				<h:inputText id="monto_actual" value='#{row.montoActual}'
					styleClass="texto" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Id TTV asignado" styleClass="headertext" />
				</f:facet>
				<h:inputText id="idTTV" disabled="disabled" value='#{row.idTTV}'
					styleClass="texto" />
			</h:column>
			<h:column>
				<f:facet name="header">
					<h:outputText value="Boton Detalle" styleClass="headertext" />
				</f:facet>
				<a4j:commandButton action="#{testJSF.clickOnRow}" value="..."
					actionListener="#{testJSF.rowSelected}" reRender="dataText">
					<f:attribute name="codigo_isin_unido" value="#{row}" />
				</a4j:commandButton>
			</h:column>
		</rich:dataTable>
		<h:commandButton value="Print Data" action="#{testJSF.printTTVData}" />
		<br />
		<center><h:inputTextarea id="dataText"
			value="#{testJSF.dataTextFormat}" style="width: 700px; height: 88px" />
		</center>

		<h:inputText value="#{testJSF.idTTVTest}"/>
		<h:selectOneRadio id="tipoAccion" styleClass="generica"
			value="#{testJSF.tipoAccion}">
			<f:selectItem id="modificarOferta"
																	itemLabel="Modificar oferta"
																	itemValue="0" />
			<f:selectItem id="modificarDemanda"
																	itemLabel="Modificar demanda"
																	itemValue="1" />
		</h:selectOneRadio>
		<h:commandButton action="#{testJSF.irModificar}" value="Probar Modificar" />
	</a4j:form>
</f:view>
</body>
</html>