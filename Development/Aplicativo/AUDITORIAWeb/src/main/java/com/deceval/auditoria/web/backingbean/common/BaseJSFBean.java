/*
 * BaseJSFBean
 * Version 1.0
 * Date 21/07/2008
 * Copyright (c) 2008
 * Company: Deceval S.A
 */
package com.deceval.auditoria.web.backingbean.common;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.deceval.auditoria.web.userinfo.UserInfo;

/**
 * Backing bean base que comparte metodos utiles para un backing bean
 * 
 * @author Johann Camilo Olarte Diaz
 */
public abstract class BaseJSFBean {

	/**
	 * Retorna la informacion almacenada en la instacia del bean de sesion
	 * infoUsuario.
	 * 
	 * @return Bean del usuario actual autenticado
	 */
	protected UserInfo getInfoUsuario() {
		return (UserInfo) evaluateELExpression("#{userInfo}", UserInfo.class);
	}

	/**
	 * Evalua una expresion en lenguaje EL.
	 * 
	 * @param elExpression
	 *            Expresion a evaluar
	 * @param classExpected
	 *            Clase que debe retornar
	 * @return Objecto evaluado.
	 */
	protected Object evaluateELExpression(String elExpression,
			Class classExpected) {
		ValueExpression obj = getContext().getApplication()
				.getExpressionFactory().createValueExpression(
						getContext().getELContext(), elExpression,
						classExpected);
		return obj.getValue(getContext().getELContext());
	}

	/**
	 * Gets an object from the current http session
	 * 
	 * @param key
	 *            Object name to be retrieved.
	 * @return Object stored in the current session if it doesn't exist null is
	 *         returned.
	 */
	protected Object getSessionAttribute(String key) {
		Object objeto = null;
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		if (session != null) {
			if (key != null)
				objeto = session.getAttribute(key);
		}
		return objeto;
	}

	/**
	 * Puts a new object in the current http session.
	 * 
	 * @param key
	 *            Object name to be stored.
	 * @param object
	 *            Object to be stored.
	 */
	protected void putSessionAttribute(String key, Object object) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		if (session != null) {
			if (key != null)
				session.setAttribute(key, object);
		}
	}

	/**
	 * Removes an object from the current http session.
	 * 
	 * @param key
	 *            Object key to be removed.
	 */
	protected void removeSessionAttribute(String key) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		if (session != null) {
			session.removeAttribute(key);
		}
	}

	/**
	 * Gets an attribute from the current request.
	 * 
	 * @param key
	 *            Attribute name to be retrieved.
	 * @return Object stored in the current request if it doesn't exist null is
	 *         returned.
	 */
	protected Object getRequestAttribute(String key) {
		Object objeto = null;
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		if (request != null) {
			if (key != null)
				objeto = request.getAttribute(key);
		}
		return objeto;
	}

	/**
	 * Gets an attribute from the current request.
	 * 
	 * @param key
	 *            Attribute name to be retrieved.
	 * @return Object stored in the current request if it doesn't exist null is
	 *         returned.
	 */
	protected FacesContext getContext() {
		return FacesContext.getCurrentInstance();
	}

	/**
	 * Sets a new attribute for the current request.
	 * 
	 * @param key
	 *            Attribute name to the new attribute.
	 * @param object
	 *            Object to be set in the current request.
	 */
	protected void setRequestAttribute(String key, Object object) {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		if (request != null) {
			if (key != null)
				request.setAttribute(key, object);
		}
	}

	/**
	 * Gets a parameter for the current request.
	 * 
	 * @param key
	 *            name to the parameter
	 * @param object
	 *            Object to be set in the current request.
	 */
	protected String getRequestParameter(String key) {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		if (request != null) {
			if (key != null)
				// request.(key, object);
				return request.getParameter(key);
		}
		return null;
	}

	/**
	 * Adds a new error message to the faces context
	 * 
	 * @param e
	 *            Exception to be added to the current context.
	 */
	protected void addErrorMessage(Exception e) {
		if (e == null) {
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_FATAL);
			message.setSummary("Excepción no controlada.");
			message
					.setDetail("Por favor informe al administrador del sistema.");
			FacesContext.getCurrentInstance().addMessage("GLOBAL", message);
			return;
		}

		String resumen = e.getMessage();
		if (resumen == null) {
			resumen = e.toString();
		} else {
			int ind = 0;
			if ((ind = resumen.lastIndexOf(':')) != -1) {
				resumen = resumen.substring(ind);
			}
		}

		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_FATAL);
		message.setSummary(resumen);
		String detail = "";

		message.setDetail(detail);

		FacesContext.getCurrentInstance().addMessage("GLOBAL", message);

	}

	/**
	 * Adds a new Error message to the faces context
	 * 
	 * @param messageError
	 *            Short error description
	 * @param detail
	 *            Error detailed.
	 */
	protected void addErrorMessage(String messageError, String detail) {
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_ERROR);
		message.setSummary(messageError);
		message.setDetail(detail);
		FacesContext.getCurrentInstance().addMessage("GLOBAL", message);
	}

	/**
	 * Adds a new info message to the faces context.
	 * 
	 * @param infoMessage
	 *            Information message to be added.
	 */
	protected void addInfoMessage(String infoMessage) {
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		message.setSummary("");
		message.setDetail(infoMessage);
		FacesContext.getCurrentInstance().addMessage("GLOBAL", message);
	}

	/**
	 * Redirects the current page using navigation rules defined in
	 * faces-config.xml file.
	 * 
	 * @param startRule
	 *            Starting point of the navigation rule.
	 * @param endRule
	 *            End point of the navigation rule.
	 */
	protected static void redirectPage(String fromAction, String outCome) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getApplication().getNavigationHandler().handleNavigation(
				context, fromAction, outCome);
	}

	/**
	 * Closes the session.
	 * 
	 * @return Return the navigation rule which should be used to come back to
	 *         the login page.
	 */
	protected String invalidateSession() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(
				false);
		session.invalidate();
		return "autenticar";
	}

	/**
	 * Obtiene el actual classLoader
	 * 
	 * @param defaultObject
	 * @return
	 */
	private static ClassLoader getCurrentClassLoader(Object defaultObject) {

		ClassLoader loader = Thread.currentThread().getContextClassLoader();

		if (loader == null) {
			loader = defaultObject.getClass().getClassLoader();
		}

		return loader;
	}

	/**
	 * Obtiene un mensaje del bundle de mensajes de la aplicación.
	 * 
	 * @param key
	 *            (Nombre del key del mensaje)
	 * @param params
	 *            (Parametros a establecer en el mensaje.
	 * @return Cadena con el valor del mensaje
	 */
	public String getMessageResourceString(String key, Object params[]) {

		String text = null;

		ResourceBundle bundle = ResourceBundle.getBundle(getContext()
				.getApplication().getMessageBundle(), getContext()
				.getViewRoot().getLocale(), getCurrentClassLoader(params));

		try {
			text = bundle.getString(key);
		} catch (MissingResourceException e) {
			text = "?? key " + key + " not found ??";
		}

		if (params != null) {
			MessageFormat mf = new MessageFormat(text, getContext()
					.getViewRoot().getLocale());
			text = mf.format(params, new StringBuffer(), null).toString();
		}

		return text;
	}
}
