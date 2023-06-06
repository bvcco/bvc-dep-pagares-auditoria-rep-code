<td width="30" align="right" valign="bottom">
	<div id="alertas" class="alertas" style="width: 427px;top:343px">
			<table width="418" height="225" border="0" cellpadding="0" cellspacing="0" class="tablalertas">
				<tr>
					<td width="420" height="222">
						<table width="400" border="0" align="center" cellpadding="0" cellspacing="0">
							<tr>
								<td width="381">&nbsp;</td>
								<td width="19"><a href="#"><img src="<%=request.getContextPath()%>/images/botcerrar.gif" width="19" height="17" border="0" onClick="MM_showHideLayers('alertas','','hide')"></a></td>
							</tr>
							<tr>
								<td colspan="2"><img src="<%=request.getContextPath()%>/images/pestalertas.jpg" width="87" height="25" /></td>
							</tr>
							<tr>
								<td height="160" colspan="2" class="tablablanca2">
									<table width="350" border="0" align="center" cellpadding="0" cellspacing="0">
										<tr>
											<td colspan="2" class="titrojoalertas">Usted Tiene (5) Alerta(s)</td>
										</tr>
										<tr>
											<td width="32"><img src="<%=request.getContextPath()%>/images/iconrojo.gif" width="32" height="41" /></td>
						                    <td class="backrojo"><a href="<%=request.getContextPath()%>/admin_garantias/llamados_al_margen.html" class="linkrojo">Tiene 4 TTVs con llamado al margen </a></td>
										</tr>
										<tr>
											<td><img src="<%=request.getContextPath()%>/images/iconazul.gif" width="32" height="41" /></td>
						                    <td class="backazul"><a href="<%=request.getContextPath()%>/admin_registros/consultar_ttv_orig.html" class="linkazul">Tiene 5 TTVs proximas a vencer </a></td>
						                </tr>
										<tr>
											<td><img src="<%=request.getContextPath()%>/images/icongris.gif" width="32" height="41" /></td>
											<td class="backgris"><a href="<%=request.getContextPath()%>/consultas/consulta_ttvs_prorrogas_originador.html" class="linkgris">Tiene 4 TTVs con solicitud de prorroga</a></td>
						                </tr>
										<tr>
											<td><img src="<%=request.getContextPath()%>/images/icongris.gif" width="32" height="41" /></td>
											<td class="backgris"><a href="<%=request.getContextPath()%>/eventos_corporativos/detalle_alerta_evento_corporativo_originador.html" class="linkgris">Evento corporativo para la TTV 123456</a></td>
						                </tr>
										<tr>
											<td><img src="<%=request.getContextPath()%>/images/icongris.gif" width="32" height="41" /></td>
											<td class="backgris"><a href="<%=request.getContextPath()%>/derechos_patrimoniales/detalle_derecho_patrimonial_originador.html" class="linkgris">La TTV 987654 tiene cobro de derechos patrimoniales</a></td>
						                </tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
	<div id="horarios" class="alertas" style="width: 427px;top:343px">
			<table width="418" height="225" border="0" cellpadding="0" cellspacing="0" class="tablalertas">
				<tr>
				    <td width="430" height="222">
						<table width="400" border="0" align="center" cellpadding="0" cellspacing="0">
							<tr>
								<td width="386"><a href="#"></a></td>
								<td width="14"><a href="#"><img src="<%=request.getContextPath()%>/images/botcerrar.gif" width="19" height="17" border="0" onClick="MM_showHideLayers('horarios','','hide')" /></a></td>
							</tr>
							<tr>
								<td colspan="2"><img src="<%=request.getContextPath()%>/images/pestahorario.jpg" width="87" height="25" /></td>
							</tr>
							<tr>
								<td colspan="2" class="titfechahorario">Marzo de 2008 </td>
							</tr>				
							<tr>
								<td height="160" colspan="2" class="tablablanca2">
									<table width="350" border="0" align="center" cellpadding="0" cellspacing="0">
										<tr>
											<td colspan="3" class="titcafehorario">Consulte el horario de sus actividades pendientes:</td>
										</tr>
										<tr>
											<td width="32"><img src="<%=request.getContextPath()%>/images/iconreloj.gif" width="32" height="41" /></td>
											<td width="141" class="backrojo">Llamado al margen: </td>
											<td width="177"  class="backamarillo">8:00 a.m. - 3:00 p.m. </td>
										</tr>
										<tr>
											<td><img src="<%=request.getContextPath()%>/images/iconreloj.gif" width="32" height="41" /></td>
											<td class="backazul">Excedente Garant&iacute;a: </td>
											<td class="backamarillo">10:00 a.m. </td>
							            </tr>
										<tr>
											<td><img src="<%=request.getContextPath()%>/images/iconreloj.gif" width="32" height="41" /></td>
							                <td class="backgris">Prorroga:</td>
							                <td class="backamarillo">2:00 p.m. </td>
							            </tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
	<table width="30" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td><div class="pestana" id="abreAlertas"><img src="<%=request.getContextPath()%>/images/palertas.jpg" width="27" height="88" border="0" onClick="MM_showHideLayers('horarios','','hide');abrirCapaAlerta('alertas','abreAlertas')" /></div></td>
		</tr>
		<tr>
			<td><div class="pestana" id="abreHorarios"><img src="<%=request.getContextPath()%>/images/phorario.jpg" width="27" height="88" border="0" onClick="MM_showHideLayers('alertas','','hide');abrirCapaAlerta('horarios','abreAlertas')"/></div></td>
		</tr>
	</table>
</td>
