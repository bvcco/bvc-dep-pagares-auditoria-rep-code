package com.deceval.auditoria.web.backingbean.consulta.manejodecombos;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import com.deceval.auditoria.exception.LogicException;
import com.deceval.auditoria.integration.NegocioDelegate;
import com.deceval.auditoria.util.constants.Constants;
import com.deceval.auditoria.util.properties.PropertiesLoader;
import com.deceval.auditoria.vo.AplicacionVO;
import com.deceval.auditoria.vo.HomologacionVO;
import com.deceval.seguridad.comunes.vo.PerfilData;
import com.deceval.seguridad.comunes.vo.UsuarioData;
import com.deceval.seguridad.logica.ServiciosSeguridad;

public class ManejoDeComboAplicacion extends ManejoDeCombos {
	
	private HttpSession session = null;
	
	public void crear(HttpSession iSession) {
		session = iSession;
	}
	
	protected int devolverIdElemento(Object objeto) {
		AplicacionVO aplicacionVO = (AplicacionVO) objeto;
		return aplicacionVO.getIdAplicacion().intValue();
	}
	
	protected String devolverNombreElemento(Object objeto) {
		AplicacionVO aplicacionVO = (AplicacionVO) objeto;
		return aplicacionVO.getNombreAplicacion();
	}
	
	/*  Corresponde al funcionamiento del combo box de Aplicaciones */
	public LinkedList<SelectItem> getAplicaciones() throws Exception {
		LinkedList<SelectItem> lAplicaciones = new LinkedList<SelectItem>();		
		lAplicaciones.add(devolverElementoVacio());
		agregarItemsAplicacion(lAplicaciones);			
		return lAplicaciones;	
	}	
	
	private void agregarItemsAplicacion(LinkedList<SelectItem> l) throws Exception {
		Collection<AplicacionVO>	bdListaAplicacion;	
		NegocioDelegate negocioDelegate = new NegocioDelegate();
		bdListaAplicacion 	= negocioDelegate.obtenerListaAplicacion();		
		for (Iterator<AplicacionVO> iterator = bdListaAplicacion.iterator(); iterator.hasNext();) {
			AplicacionVO elemento = (AplicacionVO) iterator.next();
			if(aplicacionCorrespondeAlUsuario(elemento)) { 
				l.add(devolverElemento(elemento));
			}			
		}
	}
	
	private boolean aplicacionCorrespondeAlUsuario(AplicacionVO elemento) throws Exception {	
		Integer iIdAplicacionEnLaTablaHomologacion = IdAplicacionEnLaTablaHomologacion(elemento);
		if(iIdAplicacionEnLaTablaHomologacion == null) return false;
		return puedeElUsuarioAccederAAplicacion(iIdAplicacionEnLaTablaHomologacion);
	}
	
	private Integer IdAplicacionEnLaTablaHomologacion(AplicacionVO elemento) throws LogicException {		
		NegocioDelegate negocioDelegate = new NegocioDelegate();
		
		String sIdTablaAuditoria	= PropertiesLoader.loadProperty(Constants.CONSTANTE_APP_AUDITORIA_TABLA_APLICACIONES);
		String sIdTablaReferencia	= PropertiesLoader.loadProperty(Constants.CONSTANTE_APP_SEGURIDAD_TABLA_APLICACIONES);
		
		int iIdTablaAuditoria		= Integer.parseInt(sIdTablaAuditoria);
		int iIdTablaReferencia		= Integer.parseInt(sIdTablaReferencia);
		
		Integer idTablaAuditoria	= new Integer(iIdTablaAuditoria); 
		Integer valorAuditoria		= elemento.getIdAplicacion().intValue();
		Integer valorExterno;	
		Integer idTablaReferencia	= new Integer(iIdTablaReferencia); 	

		HomologacionVO llave = new HomologacionVO();
		llave.setIdTablaAuditoria(idTablaAuditoria);
		llave.setValorAuditoria(valorAuditoria);
		llave.setIdTablaReferencia(idTablaReferencia);
				
		HomologacionVO homologacionVO = negocioDelegate.obtenerHomologacionVOPorIdTblAuditYValAuditYIdTblRef(llave);
		if(homologacionVO == null) return null;
		valorExterno = homologacionVO.getValorExterno();

		return valorExterno;
	}	
	
	private boolean puedeElUsuarioAccederAAplicacion(Integer iIdAplicacionEnLaTablaHomologacion) throws Exception {
		UsuarioData usuarioAutenticacionVO = 
			(UsuarioData) session.getAttribute("usuarioAutenticado");
		ServiciosSeguridad servicios = new ServiciosSeguridad();		          
		List<PerfilData> perfilesUsuario = (List)servicios.getListaPerfilesPorUsuario(usuarioAutenticacionVO.getIdUsuario(), null, null);
		
		PerfilData perfilVO = null;
  	  	if (perfilesUsuario != null) {
  	  		for(Iterator<PerfilData> i = perfilesUsuario.iterator();i.hasNext();)
  	  		{
  	  			perfilVO = i.next();
  	  			if (perfilVO.getIdAplicacion().getIdAplicacion().intValue() == iIdAplicacionEnLaTablaHomologacion.intValue()) 
  	  			{
  	  				return true;
  	  			}
  	  		}
  	  	}
  	  	return false;
	}
}
