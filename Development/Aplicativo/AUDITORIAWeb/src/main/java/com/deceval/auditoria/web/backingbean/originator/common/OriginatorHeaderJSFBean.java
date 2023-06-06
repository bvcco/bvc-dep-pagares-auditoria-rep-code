/*
 * OriginatorHeaderJSFBean
 * Version 1.0
 * Date 07/07/2008
 * Copyright (c) 2008
 * Company: Deceval S.A
 */
package com.deceval.auditoria.web.backingbean.originator.common;

import java.util.HashSet;

import com.deceval.auditoria.web.backingbean.common.BaseJSFBean;

/**
 * Backing bean del header de las páginas del originador.
 * Se encarga de comportamientos del Header.
 * @author Johann Camilo Olarte Díaz.
 */
public class OriginatorHeaderJSFBean extends BaseJSFBean{	
	
	HashSet<String> opcionesMenu1;
	HashSet<String> opcionesMenu2;
	HashSet<String> opcionesMenu3;
	
	String menu1="2";
	String menu2="2";
	String menu3="2";
	
	public OriginatorHeaderJSFBean(){
		opcionesMenu1=new HashSet<String>();
		opcionesMenu2=new HashSet<String>();
		opcionesMenu3=new HashSet<String>();
		opcionesMenu1.add("/jsp/originator/offer/registerOffer.jsp");
		opcionesMenu1.add("/jsp/originator/offer/modifyOffer.jsp");
		opcionesMenu1.add("/jsp/originator/offer/detailOffer.jsp");		
		opcionesMenu1.add("/jsp/originator/auditoria/consultAuditoriaOrig.jsp");		
	}

	public String getHomeOriginador(){
		return "homeOriginator";
	}
	
	public String getMenu1() {
		String viewId=getContext().getCurrentInstance().getViewRoot().getViewId();
		if(opcionesMenu1.contains(viewId)){
			menu1="1";
		}else{
			menu1="2";			
		}
		return menu1;
	}

	public void setMenu1(String menu1) {		
		this.menu1 = menu1;
	}

	public String getMenu2() {
		String viewId=getContext().getCurrentInstance().getViewRoot().getViewId();
		if(opcionesMenu2.contains(viewId)){
			menu2="1";
		}else{
			menu2="2";			
		}
		return menu2;
	}

	public void setMenu2(String menu2) {
		this.menu2 = menu2;
	}

	public String getMenu3() {
		String viewId=getContext().getCurrentInstance().getViewRoot().getViewId();
		if(opcionesMenu3.contains(viewId)){
			menu3="1";
		}else{
			menu3="2";			
		}
		return menu3;
	}

	public void setMenu3(String menu3) {
		this.menu3 = menu3;
	}
	
}
