<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<f:subview id="OriginatorHeader">
<f:loadBundle basename="com.deceval.ttv.web.resources.messages.MessagesResources" var="msg"/>
<f:verbatim>
<h:form id="headerForm">
<tr>
	<td width="100%" height="19" valign="top">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tablanca">
			<tr>
				<td width="70%">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tablalogo">
						<tr>
						  <td height="136" valign="top" class="backarriba"><img src="<%=request.getContextPath()%>/images/log_ttv.jpg" width="372" height="94" /></td>
						</tr>
						<tr>					
							<td>
								<table width="98%" border="0" cellspacing="0" cellpadding="0" class="tablanca" align="right">
									<tr>
										<td><h:outputText value="#{msg.header_welcomeLabel}" /> <span class="txtgris"><h:outputText value="#{userInfo.nombre}" /> <h:outputText value="#{userInfo.apellido}" />  |</span> <h:outputText value="#{msg.header_currentDateLabel}" /> <span class="txtgris"><h:outputText value="#{userInfo.fechaActual.time}" ><f:convertDateTime type="date" pattern="yyyy-MM-dd hh:MM a"/></h:outputText> |</span> <h:outputText value="#{msg.header_lastLoginLabel}" /><span class="txtgris"><h:outputText value="#{userInfo.fechaUltimoIngreso.time}" ><f:convertDateTime type="date" pattern="yyyy-MM-dd hh:MM a"/></h:outputText></span></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
				<td width="30%" class="backarriba">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								<div align="right"><img src="<%=request.getContextPath()%>/images/log_deceval.jpg" width="235" height="94" /></div>
							</td>
						</tr>
						<tr>
							<td class="backbotones">					  
								<table width="100%" border="0" align="right" cellpadding="0" cellspacing="0">
									<tr>
										<td align="right"><a href="<%=request.getContextPath()%>/faces/jsp/originator/home/homeOriginator.jsp" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('originador','','<%=request.getContextPath()%>/images/boriginador_f2.jpg',1)"><img src="<%=request.getContextPath()%>/images/boriginador.jpg" name="originador" width="143" height="58" border="0" id="originador" /></a></td>
										<td><a href="<%=request.getContextPath()%>/faces/jsp/receptor/home/homeReceptor.jsp" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('receptor','','<%=request.getContextPath()%>/images/breceptor_f2.jpg',1)"><img src="<%=request.getContextPath()%>/images/breceptor.jpg" name="receptor" width="156" height="58" border="0" id="receptor" /></a></td>
									</tr>
								</table>					  
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</td>
</tr>
<tr>
	<td class="backbotonrecep">
		<table style="cursor:pointer" width="526" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td onClick="expandir('menu_0_block')" class="menu_header"><img src="<%=request.getContextPath()%>/images/BR<h:outputText value="#{originatorHeaderJSF.menu1}" />admonreg.jpg" width="220" height="42"></td>
				<td onClick="expandir('menu_1_block')"  class="menu_header"><img src="<%=request.getContextPath()%>/images/BR<h:outputText value="#{originatorHeaderJSF.menu2}" />admongaran.jpg" width="197" height="42"></td>
				<td onClick="expandir('menu_2_block')"  class="menu_header"><img src="<%=request.getContextPath()%>/images/BR<h:outputText value="#{originatorHeaderJSF.menu2}" />procesoscont.jpg" width="197" height="42"></td>
				<td onClick="expandir('menu_3_block')" class="menu_header"><img src="<%=request.getContextPath()%>/images/BR<h:outputText value="#{originatorHeaderJSF.menu3}" />consultas.jpg" width="109" height="42"></td>
			</tr>
		</table>
	</td>
</tr>
<tr>
	<td>	
	<div id="menu_0_block" class="menudiv" style="width:210px;left:9px;display:none;">
		<table border="0" cellpadding="0" cellspacing="0"  class="menu2" width="100%">
			<tr>
				<td><a href="<%=request.getContextPath()%>/faces/jsp/receptor/demand/registerDemand.jsp"><h:outputText value="#{msg.menu_registerDemandLabel}"/></a></td>
			</tr>
			<tr>
			    <td><a href="<%=request.getContextPath()%>/faces/jsp/receptor/demand/consultRegisterDemand.jsp">Consultar registros de demandas</a></td>
			</tr>
			<tr>
				<td><a href="<%=request.getContextPath()%>/faces/jsp/receptor/offer/consultOffer.jsp"><h:outputText value="#{msg.menu_consultOfferLabel}"></h:outputText></a></td>
			</tr>
			<tr>
			   <td><a href="<%=request.getContextPath()%>/faces/jsp/receptor/ttv/consultTtvRecep.jsp">Consultar TTV</a></td>
			</tr>
		</table>
	</div>
	<div id="menu_1_block" class="menudiv" style="width:188px;left:225px;display:none;">
			<table border="0" cellpadding="0" cellspacing="0"  class="menu2" width="100%">
				<tr>
					<td><a href="../admin_garantias/llamados_al_margen.html">Llamados al margen</a></td>
				</tr>
				<tr>
				    <td><a href="../admin_garantias/excedentes_garantias.html">Excedentes de garantias</a></td>
				</tr>				
			</table>
	</div>
	<div id="menu_2_block" class="menudiv" style="width:105px;left:422px;display:none;">
			<table border="0" cellpadding="0" cellspacing="0"  class="menu2" width="100%">
				<tr>				
					<td><a href="../consultas/consulta_ttvs_prorrogas.html">Prorrogas</a></td>
				</tr>
				<tr>
				    <td><a href="../admin_registros/consultar_eventos_corporativos.html">Eventos corporativos</a></td>
				</tr>
				<tr>
				   <td><a href="../admin_registros/consultar_derechos_patrimoniales.html">Derechos patrimoniales</td>
				</tr>
				<tr>
				   <td><a href="../admin_registros/consultar_venc_anticipado.html">Vencimiento anticipado</a></td>
				</tr>				
			</table>
	</div>
		<div id="menu_3_block" class="menudiv" style="width:105px;left:640px;display:none;">
			<table border="0" cellpadding="0" cellspacing="0"  class="menu2" width="100%">
				<tr>				
					<td><a href="../consultas/consultar_traspasos.html">Traspasos</a></td>
				</tr>
				<tr>
				    <td><a href="../consultas/consultar_primas.html">Primas</a></td>
				</tr>
				<tr>
				   <td><a href="../consultas/consultar_posiciones_valores.html">Posiciones de valores</a></td>
				</tr>
				<tr>
				   <td><a href="../consultas/consultar_especies_autorizadas.html">Especies Autorizadas</a></td>
				</tr>
				<tr>
				   <td><a href="../consultas/consultar_vencimientos.html">Vencimientos</a></td>
				</tr>
				<tr>
				   <td><a href="../consultas/consultar_req_garantias.html">Requerimientos de garant&iacute;as</a></td>
				</tr>
				<tr>
				   <td><a href="../consultas/consultar_fideicomisos.html">Fideicomisos</a></td>
				</tr>
				<tr>
				   <td><a href="../consultas/consultar_incumplimientos.html">Incumplimientos</a></td>
				</tr>
				<tr>
				   <td><a href="../consultas/consulta_ttv_historicos.html">Historicos TTVs</a></td>
				</tr>
			</table>
		</div>		
	&nbsp;
	</td>
</tr>
</h:form>
</f:verbatim>
</f:subview>