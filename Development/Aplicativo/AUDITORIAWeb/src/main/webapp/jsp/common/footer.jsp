<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<f:subview id="footer">
<f:loadBundle basename="com.deceval.ttv.web.resources.messages.MessagesResources" var="msg"/>
<f:verbatim>
<h:form id="footerForm">
<tr>
	<td class="backabajo"><h:outputText value="#{msg.footer_copyrightLabel}" /></td>
</tr>
</h:form>
</f:verbatim>
</f:subview>