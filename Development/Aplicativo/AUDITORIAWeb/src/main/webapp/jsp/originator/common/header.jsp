<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<f:subview id="OriginatorHeader">

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
	<td class="backboton">
		<table style="cursor:pointer" width="526" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td onClick="expandir('menu_0_block')" class="menu_header"><img src="<%=request.getContextPath()%>/images/BO<h:outputText value="#{originatorHeaderJSF.menu1}" />admonreg.jpg" width="220" height="42"></td>
				<td onClick="expandir('menu_1_block')"  class="menu_header"><img src="<%=request.getContextPath()%>/images/BO<h:outputText value="#{originatorHeaderJSF.menu2}" />procontin.jpg" width="197" height="42"></td>
				<td  onClick="expandir('menu_2_block')" class="menu_header"><img src="<%=request.getContextPath()%>/images/BO<h:outputText value="#{originatorHeaderJSF.menu3}" />consultas.jpg" width="109" height="42"></td>
			</tr>
		</table>
	</td>
</tr>
<tr>
	<td>	
	<div id="menu_0_block" class="menudiv" style="width:210px;left:9px;display:none;">
		<table border="0" cellpadding="0" cellspacing="0"  class="menu" width="100%">
			<tr onclick="location.href='<%=request.getContextPath()%>/faces/jsp/originator/offer/registerOffer.jsp'">
				<td><h:outputText value="#{msg.menu_registerOfferLabel}"></h:outputText></td>
			</tr>
			<tr onclick="location.href='<%=request.getContextPath()%>/faces/jsp/originator/offer/consultRegisterOffer.jsp'">
				<td>Consultar registros de ofertas</td>
			</tr>
			<tr onclick="location.href='<%=request.getContextPath()%>/faces/jsp/originator/offer/consultDemand.jsp'">
			   <td>Consultar demandas</td>
			</tr>
			<tr onclick="location.href='<%=request.getContextPath()%>/faces/jsp/originator/ttv/consultTtvOrig.jsp'">
			   <td>Consultar TTV</td>
			</tr>
		</table>
	</div>
	<div id="menu_1_block" class="menudiv" style="width:188px;left:225px;display:none;">
		<table border="0" cellpadding="0" cellspacing="0"  class="menu" width="100%">
			<tr onclick="location.href='<%=request.getContextPath()%>/consultas/consulta_ttvs_prorrogas_originador.html'">
				<td>Prorrogas</td>
			</tr>
			<tr onclick="location.href='<%=request.getContextPath()%>/consultas/consultar_eventos_corporativos.html'">
				<td>Eventos corporativos</td>
			</tr>
			<tr onclick="location.href='<%=request.getContextPath()%>/consultas/consultar_derechos_patrimoniales.html'">
			   <td>Derechos patrimoniales</td>
			</tr>
			<tr onclick="location.href='<%=request.getContextPath()%>/consultas/consultar_venc_anticipado.html'">
			   <td>Consultar vencimiento anticipado</td>
			</tr>
		</table>
	</div>
	<div id="menu_2_block" class="menudiv" style="width:105px;left:422px;display:none;">
		<table border="0" cellpadding="0" cellspacing="0"  class="menu" width="100%">
			<tr onclick="location.href='<%=request.getContextPath()%>/consultas/consultar_traspasos.html'">				
				<td>Traspasos</td>
			</tr>
			<tr onclick="location.href='<%=request.getContextPath()%>/consultas/consultar_primas.html'">
				<td>Primas</td>
			</tr>
			<tr onclick="location.href='<%=request.getContextPath()%>/consultas/consultar_posiciones_valores.html'">
			   <td>Posiciones de valores</td>
			</tr>
			<tr onclick="location.href='<%=request.getContextPath()%>/consultas/consultar_especies_autorizadas.html'">
			   <td>Especies Autorizada</td>
			</tr>
			<tr onclick="location.href='<%=request.getContextPath()%>/consultas/consultar_vencimientos.html'">
			   <td>Vencimientos</td>
			</tr>
			<tr onclick="location.href='<%=request.getContextPath()%>/consultas/consultar_req_garantias.html'">
			   <td>Requerimientos de garant&iacute;as</td>
			</tr>
			<tr onclick="location.href='<%=request.getContextPath()%>//consultas/consultar_fideicomisos.html'">
			   <td>Fideicomisos</td>
			</tr>
			<tr onclick="location.href='<%=request.getContextPath()%>/consultas/consultar_incumplimientos.html'">
			   <td>Incumplimientos</td>
			</tr>
			<tr onclick="location.href='<%=request.getContextPath()%>/consultas/consulta_ttv_historicos.html'">
			   <td>Historicos TTVs</td>
			</tr>
		</table>
	</div>
	&nbsp;
	</td>
</tr>
</h:form>
</f:verbatim>
</f:subview>