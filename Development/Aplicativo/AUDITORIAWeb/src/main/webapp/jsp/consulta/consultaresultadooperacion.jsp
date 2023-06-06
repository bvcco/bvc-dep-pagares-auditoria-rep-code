<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=iso-8859-1" language="java" errorPage="" %>    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<f:view>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
                <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE8; IE=EmulateIE11"/>
		<title><h:outputText value="#{msg.titulo_pantallas}"/></title>
		<link href="<%=request.getContextPath()%>/css/estilos_auditoria.css" rel="stylesheet" type="text/css" />
	    <style type="text/css">
	        .ecol1 { vertical-align: top; padding-right : 25px }
	        .ecol2 { vertical-align: top; border-left: #ACBECE 1px solid; padding-left : 10px }
	        .rich-calendar-tool-btn{
	            font-family: Arial, Verdana;
	        } 
			.tittablainterna {
				border: none;
				font-family: Arial, Helvetica, sans-serif;
				font-size: 11px;
				font-style: normal;
				font-weight: bold;
				color: #0A6094;
				background-image: none;
				padding-left:15px;
				height: 16px;
			}		        
	    </style>		
	</head>
	<script src="<%=request.getContextPath()%>/js/prototype.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/scriptaculous.js" type="text/javascript"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/side-bar.js"></script>
	<script type="text/JavaScript">
		<!--
		function MM_preloadImages() { //v3.0
		  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
		    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
		    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
		}
		
		function MM_swapImgRestore() { //v3.0
		  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
		}
		
		function MM_swapImage() { //v3.0
		  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
		   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
		}
		
		function MM_findObj(n, d) { //v4.01
		  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
		    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
		  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
		  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
		  if(!x && d.getElementById) x=d.getElementById(n); return x;
		}
		
		function MM_showHideLayers() { //v6.0
		  var i,p,v,obj,args=MM_showHideLayers.arguments;
		  for (i=0; i<(args.length-2); i+=3) if ((obj=MM_findObj(args[i]))!=null) { v=args[i+2];
		    if (obj.style) { obj=obj.style; v=(v=='show')?'visible':(v=='hide')?'hidden':v; }
		    obj.visibility=v; } 
		} 
		//-->
	</script>		
	<body>
		<table width="1000" border="0" align="center" cellpadding="0"
			cellspacing="0" class="tablaexterna">
			<jsp:include page="/jsp/home/header.jsp"/>
			  <tr>   
			    <td>
			      <table width="900" border="0" align="center" cellpadding="0" cellspacing="0" class="tablapesta">
			        <tr>
			          <td width="21" class="tablatitulo"><img src="<%=request.getContextPath()%>/images/iconadmon.jpg" width="25" height="21" /></td>
			          <td width="877" class="tablatitulo"><h:outputText id="S1" value="#{msg.titulo_consulta}" styleClass="tablatitulo"/></td>
			        </tr>
			        <tr>
			          <td colspan="2" class="titablapesta"><h:outputText id="S2" value="#{msg.subtitulo_consulta_resultado}" styleClass="titablapesta"/></td>
			        </tr>
			        <tr>
			          <td height="11" colspan="2">&nbsp;</td>
			        </tr>		        
			        <tr>
			          <td colspan="2">
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td width="21">
									&nbsp;
								</td>
								<td>
									<h:form>		
										<h:panelGrid id="S3" columns="1" styleClass="tablagenerica" width="850">
											<h:outputText id="S4"	value="#{consultaJSFBean.resultadosConsulta.titulo}" 
															styleClass="tittablainterna"/>			
											<h:panelGrid id="S5" columns="1" style="background-color: #E5ECF3;" width="100%">
						                		<rich:dataTable id="S6" var="logs" 
						                		                value="#{consultaJSFBean.resultadosConsulta.filasResultadosConsulta}"
						                		                binding="#{consultaJSFBean.tabla}">
									        		<f:facet name="header">
									        			<rich:columnGroup id="S7">
									        				<rich:column id="S8"><h:outputText id="S9" value="#{msg.lb_usuario}"/></rich:column>
									        				<rich:column id="S10"><h:outputText id="S11" value="#{msg.lb_fecha}"/></rich:column>
									        				<rich:column id="S12"><h:outputText id="S13" value="#{msg.lb_ip}"/></rich:column>
									        				<rich:column id="S14"><h:outputText id="S15" value="#{msg.lb_origen}"/></rich:column>
									        				<rich:column id="S16"><h:outputText id="S17" value="#{msg.lb_codigoorigen}"/></rich:column>
									        				<rich:column id="S18"><h:outputText id="S19" value="#{msg.lb_descripcion}"/></rich:column>
									        				<rich:column id="S20"><h:outputText id="S21" value="#{msg.lb_accion}"/></rich:column>
									        			</rich:columnGroup>
									        		</f:facet>
									        		
									        		<rich:column id="S22"><h:outputText id="S23" value="#{logs.usuario}"/></rich:column>
									        		<rich:column id="S24"><h:outputText id="S25" value="#{logs.fecha}"/></rich:column>
									        		<rich:column id="S26"><h:outputText id="S27" value="#{logs.ip}"/></rich:column>
									        		<rich:column id="S28"><h:outputText id="S29" value="#{logs.origen}"/></rich:column>
									        		<rich:column id="S30"><h:outputText id="S31" value="#{logs.codigoOrigen}"/></rich:column>
									        		<rich:column id="S32"><h:outputText id="S33" value="#{logs.descripcion}"/></rich:column>
									        		<rich:column>
									        			<h:commandLink id="S34" action="#{consultaJSFBean.doVerOperacion}" 
									        						   value="#{msg.lb_vertraza}#{logs.traza}"></h:commandLink>
													</rich:column>
									        		
									        	</rich:dataTable>
									        	<table align="center" cellpadding="0" cellspacing="0" ><tr><td>
								                	<h:commandButton  id="S35" value="#{msg.btn_regresar}" styleClass="button" 
								                	                 action="#{consultaJSFBean.doRegresarAParametrosConsulta}"></h:commandButton>		
						                		</td></tr></table>
						                	</h:panelGrid>
										</h:panelGrid>
									</h:form>
								</td>
							</tr>
						</table>	 
					  </td>
					</tr>       
			      </table>
			    </td>
			  </tr> 
			<jsp:include page="/jsp/home/footer.jsp"/>
		</table>
	</body>
</html>
</f:view>
