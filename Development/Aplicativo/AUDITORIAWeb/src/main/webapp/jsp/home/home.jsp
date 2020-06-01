<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=iso-8859-1" language="java" errorPage="" %>    
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<f:view>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title>:: Bienvenidos a SCA ::</title>
		<link href="<%=request.getContextPath()%>/css/estilos_auditoria.css" rel="stylesheet" type="text/css" />
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
					<table width="719" border="0" align="center" cellpadding="0" cellspacing="0">
				        <tr>
				          <td width="719" height="341">
				          
					          <div align="center">
					          	<img src="<%=request.getContextPath()%>/images/bienvenida.jpg" width="529" height="282" />
					          </div>
				          
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