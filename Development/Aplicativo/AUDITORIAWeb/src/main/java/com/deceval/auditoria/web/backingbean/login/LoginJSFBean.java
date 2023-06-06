package com.deceval.auditoria.web.backingbean.login;

import com.deceval.auditoria.web.backingbean.common.BaseJSFBean;

public class LoginJSFBean extends BaseJSFBean{
	
	public String login() {
		System.out.println("Entro al metodo login");
		return "home";
	}
	
}
