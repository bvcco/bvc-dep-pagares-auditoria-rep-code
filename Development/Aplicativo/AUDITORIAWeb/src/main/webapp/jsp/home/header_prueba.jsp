<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:subview id="header">
    <h:form id="headerForm">
        <tr>
            <td><img src="<%=request.getContextPath()%>/images/logo_auditoria.jpg" width="1024" height="93" />
            </td>
        </tr>
        <tr>
            <td>
                <table width="1000" border="0" cellspacing="0" cellpadding="0" class="tablanca">
                    <tr>
                        <td>
                            <h:outputText value="#{msg.header_bienvenido}"/>
                            <span class="txtgris">
                                <h:outputText value="#{nombreUsuarioParaMostrarEnEncabezado}"/>  |
                            </span> 

                            <h:outputText value="#{msg.header_fecha}"/>
                            <span class="txtgris">
                                <h:outputText value="#{fechaParaMostrarEnEncabezado}"/> |
                            </span> 

                            <h:outputText value="#{msg.header_ultimo_ingreso}" escape="false"/>
                            <span class="txtgris">
                                <h:outputText value="#{ultimoIngresoParaMostrarEnEncabezado}"/>
                            </span>
                        </td>
                        <td align="right" class="linkazul">

                            <h:commandLink value="#{msg.header_cerrar_sesion}" onclick="javascript:window.close();"/>

                        </td>
                    </tr>
                </table>
            </td>
        </tr>   
        <tr>
            <td class="backboton">
                <div id="Administrador" class="menu" style="top:126px; width: 1050px;">
                    <div style="width: 1024px; background:url('<%=request.getContextPath()%>/images/bblanco.jpg'); background-repeat: repeat-x;">
                        <div class="menu_header" id="menu_0_header" onclick="new Effect.toggle('menu_0_block', 'slide')"
                             style="width: 135px;">
                            <!--onClick="new Effect.toggle('menu_1_block', 'blind', {scaleX: 'true', scaleY: 'true;', scaleContent: true}); return false;"-->
                            <img src="<%=request.getContextPath()%>/images/bconsultas.jpg" width="125" height="41"/> 
                        </div></div>
                    <div id="menu_0_container" class="menu_block_container">
                        <div style="display:none;" id="menu_0_block"> 
                            <table width="163" border="0" cellpadding="0" cellspacing="0" class="tgabmenu">
                                <tr>
                                    <td width="159" height="20">
                                        <a href="<%=request.getContextPath()%>/faces/jsp/consulta/consulta.jsp" class="linkblanco">
                                            <h:outputText value="#{msg.header_menu_consulta_general}"/>
                                        </a>
                                    </td>
                                </tr>
                            </table> 
                        </div>
                    </div>     
                </div>
            </td>
        </tr>
        <tr>
            <td class="backboton">&nbsp;</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
        </tr>  
        <tr>
            <td>&nbsp;</td>
        </tr>  
    </h:form>
</f:subview>
