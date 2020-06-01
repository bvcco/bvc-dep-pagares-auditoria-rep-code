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
        .tabdet {
			-webkit-border-horizontal-spacing: 0px;
			-webkit-border-vertical-spacing: 0px;
			background-color: white;
			border-bottom-color: rgb(128, 128, 128);
			border-bottom-width: 0px;
			border-collapse: collapse;
			border-left-color: rgb(192, 192, 192);
			border-left-style: solid;
			border-left-width: 1px;
			border-right-color: rgb(128, 128, 128);
			border-right-width: 0px;
			border-top-color: rgb(192, 192, 192);
			border-top-style: solid;
			border-top-width: 1px;
			display: table;
			empty-cells: show;
			width: 824px;
			border-width: 0px;
			border-spacing: 0px 0px;
			border-left: 1px solid rgb(192, 192, 192);
			border-top: 1px solid rgb(192, 192, 192);
			border-right-color: gray;
			border-bottom-color: gray;      
        }
        .tabdetthead {
            border-bottom-color: rgb(192, 192, 192);
			border-bottom-style: solid;
			border-bottom-width: 1px;
			display: table-header-group;
			height: 22px;
			vertical-align: middle;
			width: 583px;
			border-bottom: 1px solid rgb(192, 192, 192);
			border-color: inherit;
        }     
        .tabdettr {
			background-color: rgb(190, 214, 248);
			background-image: url(../../images/fondotit.gif);
			background-repeat: repeat-x;
			display: table-row;
			height: 23px;
			vertical-align: middle;
			width: 583px;
	        background-position-x: 0%;
			background-position-y: 0%;
			border-color: inherit;
			vertical-align: inherit;
        }        
        .tabdetth {
			border-bottom-color: rgb(192, 192, 192);
			border-bottom-style: solid;
			border-bottom-width: 1px;
			border-right-color: rgb(192, 192, 192);
			border-right-style: solid;
			border-right-width: 1px;
			color: black;
			display: table-cell;
			font-family: Arial;
			font-size: 11px;
			font-weight: bold;
			height: 14px;
			padding-bottom: 4px;
			padding-left: 4px;
			padding-right: 4px;
			padding-top: 4px;
			text-align: center;
			vertical-align: middle;
			width: 56px;
	        border-bottom: 1px solid rgb(192, 192, 192);
			border-right: 1px solid rgb(192, 192, 192);
			font-family: Arial, Verdana, sans-serif;
			padding: 4px 4px 4px 4px;
			vertical-align: inherit;
        }            
        .tabdettbody {  
	        display: table-row-group;
			vertical-align: middle;
			width: 583px;
			border-color: inherit;
        }          
        .tabdettrbody {    
	        display: table-row;
			height: 23px;
			vertical-align: middle;
			width: 583px;
			border-color: inherit;
			vertical-align: inherit;
        }  
        .tabdettdbody {  
			border-bottom-color: rgb(192, 192, 192);
			border-bottom-style: solid;
			border-bottom-width: 1px;
			border-right-color: rgb(192, 192, 192);
			border-right-style: solid;
			border-right-width: 1px;
			color: black;
			display: table-cell;
			font-family: Arial;
			font-size: 11px;
			height: 14px;
			padding-bottom: 4px;
			padding-left: 4px;
			padding-right: 4px;
			padding-top: 4px;
			vertical-align: middle;
			width: 56px;
			border-bottom: 1px solid rgb(192, 192, 192);
			border-right: 1px solid rgb(192, 192, 192);
			font-family: Arial, Verdana, sans-serif;
			padding: 4px 4px 4px 4px;
			vertical-align: inherit;
        }
        .tabdettdbodyresalt {  
			border-bottom-color: rgb(192, 192, 192);
			border-bottom-style: solid;
			border-bottom-width: 1px;
			border-right-color: rgb(192, 192, 192);
			border-right-style: solid;
			border-right-width: 1px;
			color: black;
			display: table-cell;
			font-family: Arial;
			font-size: 11px;
			height: 14px;
			padding-bottom: 4px;
			padding-left: 4px;
			padding-right: 4px;
			padding-top: 4px;
			vertical-align: middle;
			width: 56px;
			border-bottom: 1px solid rgb(192, 192, 192);
			border-right: 1px solid rgb(192, 192, 192);
			font-family: Arial, Verdana, sans-serif;
			padding: 4px 4px 4px 4px;
			vertical-align: inherit;
			background-color: rgb(219,219,219);
			font-weight: bold;
        }        
        .tabdetthtitsup {
			border-bottom-color: rgb(192, 192, 192);
			border-bottom-style: solid;
			border-bottom-width: 1px;
			border-right-color: rgb(192, 192, 192);
			border-right-style: solid;
			border-right-width: 1px;
			color: black;
			display: table-cell;
			font-family: Arial;
			font-size: 11px;
			font-weight: bold;
			height: 14px;
			padding-bottom: 4px;
			padding-left: 4px;
			padding-right: 4px;
			padding-top: 4px;
			text-align: center;
			vertical-align: middle;
	        border-bottom: 1px solid rgb(192, 192, 192);
			border-right: 1px solid rgb(192, 192, 192);
			font-family: Arial, Verdana, sans-serif;
			padding: 4px 4px 4px 4px;
			vertical-align: inherit;
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
			          <td width="877" class="tablatitulo"><h:outputText id="L1" value="#{msg.titulo_consulta}" styleClass="tablatitulo"/></td>
			        </tr>
			        <tr>
			          <td colspan="2" class="titablapesta"><h:outputText id="L2" value="#{msg.subtitulo_consulta_resultado_detalle}" styleClass="titablapesta"/></td>
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
										<h:panelGrid id="L3" columns="1" styleClass="tablagenerica" width="850">
											<h:outputText id="L4"	value="#{msg.subsubtitulo_consulta_resultado_detalle}" 
															styleClass="tittablainterna"/>			
											<h:panelGrid id="L5" columns="4" style="background-color: #E5ECF3;" width="100%">	
												<h:outputText id="L6" value="#{msg.lb_usuario}" styleClass="generica" />
												<h:outputText id="L7"
													value="#{consultaJSFBean.detalleResultadoConsulta.parametrosConsulta.usuario}" 
													styleClass="generica" />
												<h:outputText id="L8" value="#{msg.lb_fechadesde}" styleClass="generica" />
												<h:outputText id="L9"
													value="#{consultaJSFBean.detalleResultadoConsulta.parametrosConsulta.fechaDesdeFormateada}" 
													styleClass="generica" />			
												<h:outputText id="L10" value="#{msg.lb_fechahasta}" styleClass="generica" />
												<h:outputText id="L11"
													value="#{consultaJSFBean.detalleResultadoConsulta.parametrosConsulta.fechaHastaFormateada}" 
													styleClass="generica" />																							
												<h:outputText id="L12" value="#{msg.lb_origen}" styleClass="generica" />
												<h:outputText id="L13"
													value="#{consultaJSFBean.nombreOrigen}" 
													styleClass="generica" />			
												<h:outputText id="L14" value="#{msg.lb_codigoorigen}" styleClass="generica" />
												<h:outputText id="L15"
													value="#{consultaJSFBean.detalleResultadoConsulta.parametrosConsulta.codigoOrigen}" 
													styleClass="generica" />																							
												<h:outputText id="L16" value="#{msg.lb_aplicacion}" styleClass="generica" />
												<h:outputText id="L17"
													value="#{consultaJSFBean.nombreAplicacion}" 
													styleClass="generica" />			
												<h:outputText id="L18" value="#{msg.lb_modulo}" styleClass="generica" />
												<h:outputText id="L19"
													value="#{consultaJSFBean.nombreModulo}" 
													styleClass="generica" />	
											</h:panelGrid>
											<h:outputText id="L20" value="#{msg.no_hay_resultados_en_detalle_resultado_origen}" 
														  styleClass="tittablainterna" 
							                              rendered="#{consultaJSFBean.renderedNoHayDatosDetalleResultado}"/>		
											<h:outputText id="L21" value="#{msg.subsubsubtitulo_consulta_resultado_detalle}" 
														  styleClass="tittablainterna" 
							                              rendered="#{consultaJSFBean.renderedTituloTablas}"/>	
											<a4j:repeat id="L22" value="#{consultaJSFBean.detalleResultadoConsulta.tablas}" var="tabla">
												<h:panelGrid id="L23" columns="1" style="background-color: #E5ECF3;" width="100%">			
													<h:panelGrid id="L24" columns="1" style="background-color: #E5ECF3;" width="100%">
														<h:outputText id="L25" value="#{msg.antes_de_nombre_tabla_en_titulo}#{tabla.tituloTabla}" 
																  	  styleClass="tittablagenerica"/>													
														<h:outputText id="L26" value="#{tabla.codigoHtml}"
																	  escape="false"/>
													</h:panelGrid>
												</h:panelGrid>
											</a4j:repeat>
											<table align="center" cellpadding="0" cellspacing="0" ><tr><td>
												<h:panelGrid id="L27" columns="1" style="background-color: #E5ECF3;" width="100%">
									                	<h:commandButton id="L26" value="#{msg.btn_regresar}" styleClass="button" 
									                	                 action="#{consultaJSFBean.doRegresarAResultadosConsultaOrigen}"></h:commandButton>			
							                	</h:panelGrid>
						                	</td></tr></table>
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
