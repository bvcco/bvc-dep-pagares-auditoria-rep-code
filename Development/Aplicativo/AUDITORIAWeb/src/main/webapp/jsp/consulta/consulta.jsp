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
                .errores { 
                    font-family: Arial, Helvetica, sans-serif;
                    font-size: 10px;
                    font-style: normal;
                    font-weight: normal;	        
                    color: red 
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
                                <td width="21" 
                                    class="tablatitulo"><img src="<%=request.getContextPath()%>/images/iconadmon.jpg" width="25" height="21" /></td>
                                <td width="877" class="tablatitulo"><h:outputText value="#{msg.titulo_consulta}" styleClass="tablatitulo"/></td>
                            </tr>
                            <tr>
                                <td colspan="2" class="titablapesta"><h:outputText value="#{msg.subtitulo_consulta}" styleClass="titablapesta"/></td>
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
                                                    <h:panelGrid id="a1" columns="1" styleClass="tablagenerica" width="850">
                                                        <h:outputText id="a2" value="#{msg.subsubtitulo_inicial}" styleClass="tittablainterna"/>
                                                        <h:panelGrid  id="a3" columns="4" style="background-color: #E5ECF3;" width="100%">
                                                            <h:outputText id="a4" value="#{msg.lb_aplicacion}" styleClass="generica" />
                                                            <h:selectOneMenu id="selectAplicacion" 
                                                                             styleClass="generica" disabled="#{consultaJSFBean.readOnlyAplicacion}"
                                                                             value="#{consultaJSFBean.parametrosConsulta.idAplicacion}">
                                                                <f:selectItems  id="a5" value="#{consultaJSFBean.aplicaciones}"/>
                                                                <a4j:support event="onchange" reRender="panelSelectMod, panelSelectOrigen, panelSelectOperacion" id="ajaxaplicacion" />
                                                            </h:selectOneMenu>
                                                            <h:outputText id="a7" value="#{msg.lb_modulo}" styleClass="generica"/>
                                                            <a4j:outputPanel id="panelSelectMod">
                                                                <h:selectOneMenu id="selectModulo" styleClass="generica" 
                                                                                 value="#{consultaJSFBean.parametrosConsulta.idModulo}">
                                                                    <f:selectItems id="a8" value="#{consultaJSFBean.modulos}"/>
                                                                    <a4j:support event="onchange" 
                                                                                 reRender="panelSelectOperacion" 
                                                                                 id="ajaxmodulo" />
                                                                </h:selectOneMenu>
                                                            </a4j:outputPanel>
                                                            <h:outputText id="a9" value="" styleClass="generica"/>
                                                            &nbsp;									                
                                                            <h:outputText id="a10" value="" styleClass="generica"/>
                                                            &nbsp;									                
                                                            <h:outputText id="a11" value="#{msg.lb_tipofiltro}" styleClass="generica"/>
                                                            <h:selectOneMenu id="selectTipoFiltro" styleClass="generica" 
                                                                             value="#{consultaJSFBean.parametrosConsulta.idTipoFiltro}">
                                                                <f:selectItems id="a12" value="#{consultaJSFBean.tiposFiltro}"/>
                                                                <a4j:support event="onchange" 
                                                                             reRender=" panelLabelSelectOperacion, panelSelectOperacion, panelLabelSelectOrigen, panelSelectOrigen, panelLabelCodigoOrigen, panelCodigoOrigen" 
                                                                             id="ajaxtipofiltro" />
                                                            </h:selectOneMenu>			
                                                            <h:outputText id="a13" value="" styleClass="generica"/>
                                                            &nbsp;					
                                                            <a4j:outputPanel id="panelLabelSelectOperacion">
                                                                <h:outputText id="a14" value="#{msg.lb_operacion}" 
                                                                              styleClass="generica"
                                                                              rendered="#{consultaJSFBean.parametrosConsulta.renderedOperacion}"/>
                                                            </a4j:outputPanel>
                                                            <a4j:outputPanel id="panelSelectOperacion">
                                                                <h:selectOneMenu id="selectOperacion" styleClass="generica" 
                                                                                 value="#{consultaJSFBean.parametrosConsulta.idOperacion}"
                                                                                 rendered="#{consultaJSFBean.parametrosConsulta.renderedOperacion}">
                                                                    <f:selectItems value="#{consultaJSFBean.operaciones}"/>
                                                                </h:selectOneMenu>
                                                            </a4j:outputPanel>		
                                                            <h:outputText id="a15" value="" styleClass="generica"/>
                                                            &nbsp;									                																															                																               
                                                            <a4j:outputPanel id="panelLabelSelectOrigen">
                                                                <h:outputText id="a16" value="#{msg.lb_origen}" styleClass="generica"
                                                                              rendered="#{consultaJSFBean.parametrosConsulta.renderedOrigen}"/>
                                                            </a4j:outputPanel>
                                                            <a4j:outputPanel id="panelSelectOrigen">
                                                                <h:selectOneMenu id="selectOrigen" styleClass="generica" 
                                                                                 value="#{consultaJSFBean.parametrosConsulta.idOrigen}"
                                                                                 rendered="#{consultaJSFBean.parametrosConsulta.renderedOrigen}">
                                                                    <f:selectItems value="#{consultaJSFBean.origenes}"/>
                                                                </h:selectOneMenu>
                                                            </a4j:outputPanel>		
                                                            <a4j:outputPanel id="panelLabelCodigoOrigen">								                
                                                                <h:outputText id="a17" value="#{msg.lb_codigoorigen}" styleClass="generica"
                                                                              rendered="#{consultaJSFBean.parametrosConsulta.renderedOrigen}"/>
                                                            </a4j:outputPanel>
                                                            <a4j:outputPanel id="panelCodigoOrigen">
                                                                <h:inputText id="a18" value="#{consultaJSFBean.parametrosConsulta.codigoOrigen}" 
                                                                             styleClass="generica"
                                                                             rendered="#{consultaJSFBean.parametrosConsulta.renderedOrigen}"/>		
                                                            </a4j:outputPanel>				                    						                    
                                                            <h:outputText id="a19" value="" styleClass="generica"/>
                                                            &nbsp;									                
                                                            <h:outputText id="a20" value="" styleClass="generica"/>
                                                            &nbsp;									                
                                                            <h:outputText id="a21" value="#{msg.lb_fechadesde}" styleClass="generica"/>
                                                            <rich:calendar id="a22"	value="#{consultaJSFBean.parametrosConsulta.fechaDesde}" 
                                                                           locale="es"
                                                                           popup="true"
                                                                           datePattern="dd/MM/yyyy"
                                                                           showApplyButton="false" 
                                                                           cellWidth="24px" cellHeight="22px" 
                                                                           style="width:200px" inputClass="generica" showFooter="false"/>							                    							                   
                                                            <h:outputText id="a23"  value="#{msg.lb_fechahasta}" styleClass="generica"/>
                                                            <rich:calendar  id="a24"	value="#{consultaJSFBean.parametrosConsulta.fechaHasta}"
                                                                            locale="es"
                                                                            popup="true"
                                                                            datePattern="dd/MM/yyyy"
                                                                            showApplyButton="false" 
                                                                            cellWidth="24px" cellHeight="22px" 
                                                                            style="width:200px" inputClass="generica" showFooter="false"/>		
                                                            <h:outputText id="a25" value="#{msg.lb_usuario}" styleClass="generica"/>
                                                            <h:inputText id="a26" value="#{consultaJSFBean.parametrosConsulta.usuario}" styleClass="generica"/>							                    
                                                        </h:panelGrid>
                                                        <h:panelGrid  id="a27" columns="1" style="background-color: #E5ECF3;" width="100%">	
                                                            <table align="center" cellpadding="0" cellspacing="0" ><tr><td>
                                                                        <h:panelGrid id="a28" columns="2">
                                                                            <h:commandButton id="a29" value="#{msg.btn_consultar}" styleClass="button" 
                                                                                             action="#{consultaJSFBean.doConsultar}"></h:commandButton>
                                                                            <h:commandButton id="a30" value="#{msg.btn_limpiar}" styleClass="button" 
                                                                                             action="#{consultaJSFBean.doLimpiar}"></h:commandButton>
                                                                        </h:panelGrid>
                                                                    </td></tr></table>
                                                            <table align="center" cellpadding="0" cellspacing="0" ><tr><td>
                                                                        <h:outputText id="a31" value="#{consultaJSFBean.mensajeDeError}" styleClass="errores"/>
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
