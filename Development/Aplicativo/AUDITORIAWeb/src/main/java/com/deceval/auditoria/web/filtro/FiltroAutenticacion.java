package com.deceval.auditoria.web.filtro;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import sun.misc.BASE64Decoder;

import com.deceval.auditoria.util.log.AUDITORIALogger;
import com.deceval.seguridad.comunes.constantes.DatosConstantes;
import com.deceval.seguridad.comunes.servicios.configuracion.ConfiguracionGeneral;
import com.deceval.seguridad.comunes.vo.PerfilData;
import com.deceval.seguridad.comunes.vo.UsuarioData;
import com.deceval.seguridad.comunes.vo.ValidaSeguridadData;
import com.deceval.seguridad.logica.ServiciosSeguridad;
import com.deceval.seguridad.logica.ValidaSeguridad;
import com.deceval.seguridad.logica.excepciones.ExcepcionAcceso;

public class FiltroAutenticacion implements Filter
{
  private static String BUNDLEBASENAME 				= "com.deceval.auditoria.web.resources.messages.MessagesResources";
  private static String BUNDLEKEYFORMATOFECHAHORA 	= "formato_fecha_hora_encabezado";		
	
  private FilterConfig _filterConfig = null;
  
  private String PAGINA_LOGIN = 			"/faces/jsp/login/login.jsp";
  private String PAGINA_INICIO = 			"/faces/jsp/login/inicioAplicacion.jsp";
  //private String PAGINA_LOGIN_REQUERIDO = 	"/faces/jsp/login/login.jsp";
  private String PAGINA_INFORMATIVO = 		"/faces/jsp/login/informativo.jsp";
  
  private boolean subirUsuario = false;

  public void init(FilterConfig filterConfig) throws ServletException
  {
    _filterConfig = filterConfig;
  }

  public void destroy()
  {
    _filterConfig = null;
  }

  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException
  {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) resp;
    String url = null;
    String recurso = null;
    String nombreCompleto = "";
    Map<Integer,String> menusPer = null;
    Map<Integer,String> menusAp = null;
    Integer nuevoIdPerfil = null;
    subirUsuario = false;
    try
    {
    	/** Se obtiene del request la informacion de autenticacion con Entrust TruePass **/
    	String encodedClientHeader = request.getHeader("Entrust-Client");
    	
		UsuarioData usuarioVO = null;

        String ipUsuario =  ValidadorIp.obtenerIpDeHeader(request.getHeader("X-Forwarded-For")) ;
        String ipServidor = request.getLocalAddr();

		recurso = request.getRequestURI().toString();
		/** Se cortan los 11 primeros digitos para hacer forward (/auditoria/) **/
		recurso = recurso.substring(11, recurso.length());
      
		HttpSession session =  (request).getSession();
      
		if(session.getAttribute("mensaje_autorizacion") != null){
			session.removeAttribute("mensaje_autorizacion");
		}
     
		/*******************************************************************
		 * INICIO Obtener datos de autorizacion dentro de la aplicacion
		 *******************************************************************/
      
		if(session.getAttribute("usuarioAutenticado") == null)
		{
			ValidaSeguridad validar = new ValidaSeguridad();
			/** Validacion de autenticacion de EnTrust **/
			                 if (encodedClientHeader != null) {

                        /**
                         * Se obtiene el cn del usuario logeado *
                         */
                        encodedClientHeader = DecodeHeaderValue(encodedClientHeader);

                        try {
                            encodedClientHeader = validarDN(encodedClientHeader);

                            if (encodedClientHeader.substring(0, 12).equals("serialNumber")) {
                                /**
                                 * Se corta el nombre completo del usuario que
                                 * se encuentra en el cn *
                                 */
                                nombreCompleto = encodedClientHeader.substring(encodedClientHeader.indexOf("cn=") + 3, encodedClientHeader.indexOf(","));
                            } else {

                                /**
                                 * Se corta el nombre completo del usuario que
                                 * se encuentra en el cn *
                                 */
                                nombreCompleto = encodedClientHeader.substring(encodedClientHeader.indexOf("cn=") + 3, encodedClientHeader.indexOf("+"));
                            }
                        } catch (Exception e) {
                            url = PAGINA_LOGIN;
                            throw new ExcepcionAcceso("El DN del certificado no es válido.");
                        }

                        ServiciosSeguridad servicios = new ServiciosSeguridad();
                        usuarioVO = servicios.getUsuarioPorDistinguishedName(encodedClientHeader);

                        /**
                         * Se registra en BD el ingreso a la aplicacion *
                         */
                        if (usuarioVO != null) {
                            validar.actualizarAcceso(usuarioVO, true);
                            usuarioVO.setFechaIngreso(usuarioVO.getFechaIngreso());
                            AUDITORIALogger.getInstance().debugMessage("\n Usuario con Certificado Entrust PAG: |" + nombreCompleto + "|");
                        } else {
                            AUDITORIALogger.getInstance().debugMessage("No hubo resultado en BD PAG encodedClientHeader |" + nombreCompleto + "|");
                        }
                    }
                    else if (session.getAttribute("autenticadoOTP") != null && session.getAttribute("usuarioAutenticado") == null) {

                        // Si no viene el header de Entrust, intenta revisar si la autenticación se realizo por OTP                            
                        String numeroIdentificacion = (String) session.getAttribute("numeroIdentificacion");
                        ServiciosSeguridad servicios = new ServiciosSeguridad();
                        //AUDITORIALogger.getInstance().debugMessage("Numero de Identificacion***|" + numeroIdentificacion + "|");

                        usuarioVO = servicios
                                .getUsuarioPorIdentificacion(numeroIdentificacion.trim());

                        if (usuarioVO != null) {
                            validar.actualizarAcceso(usuarioVO, true);
                            usuarioVO.setFechaIngreso(usuarioVO
                                    .getFechaIngreso());
                            AUDITORIALogger.getInstance().debugMessage("\n Hubo Ingreso Completo por OTP: |"
                                    + usuarioVO.getNombreCompleto() + "|");

                            session.removeAttribute("autenticadoOTP");
                            session.removeAttribute("nombreCompleto");

                        } else {

                            AUDITORIALogger.getInstance().debugMessage("No hubo resultado en BD PAG OTP getUsuarioPorNombresApellidos |"
                                    + nombreCompleto + "|");
                        }

                    }
                    else {

                        session.setAttribute("mensaje_autorizacion", "No se encontró un certificado valido.");
                        url = PAGINA_LOGIN;
                        throw new ExcepcionAcceso("errorDeAcceso");

                        /**
                         * OJO BORRAR *
                         */
                        /*
                        if(request.getParameter("j_username") != null){
                         nombreCompleto = request.getParameter("j_username");
                         if (nombreCompleto!=null) System.out.println("nombreCompleto:"+nombreCompleto);
                         ServiciosSeguridad servicios = new ServiciosSeguridad();
                         System.out.println("Va a consultar");
                         usuarioVO = servicios.getUsuarioPorNombresApellidos( nombreCompleto.trim() );
                         if(usuarioVO!=null){
                         validar.actualizarAcceso(usuarioVO, true);
                         usuarioVO.setFechaIngreso(usuarioVO.getFechaIngreso());
                         AUDITORIALogger.getInstance().debugMessage("\n Hubo Ingreso Provisional AUD: |" + nombreCompleto+"|");
                         }else{
                         System.out.println("No hubo resultado en BD getUsuarioPorNombresApellidos |"+nombreCompleto+"|");
                         }
                         }
                         */
                        /**
                         * OJO BORRAR *
                         */
                    }
			
                if (usuarioVO != null) {
                if (usuarioVO.getUsuarioActivo() != null &&
                    usuarioVO.getUsuarioActivo() == 0)
                {
                    session.setAttribute("mensaje_error_logeo", "El usuario (" + nombreCompleto + ") está suspendido, pongase en contacto con el administrador del sistema.");
                    url = PAGINA_LOGIN;
                    throw new ExcepcionAcceso("errorDeAcceso");
                }
                else
                {  
            	    subirUsuario = true;
                    url = PAGINA_INICIO;        
          
                    
                    
				/** VALIDA QUE EL USUARIO LOGEADO TENGA PERFIL EN LA APLICACION Y CARGA EL MENU **/
                  try {
                	  usuarioVO.setIdAplicacionLogin(new Integer(ConfiguracionGeneral.getInstance().obtenerVariable(DatosConstantes.CODIGO_DE_APLICACION_AUDITORIA)));
                	  validar = new ValidaSeguridad();
                      ValidaSeguridadData validacionVO = validar.validarPerfilMenus(usuarioVO);
                      if (validacionVO != null){
                    	  session.setAttribute("menuAplicacion", validacionVO.getMenusAplicacionMap());
                    	  session.setAttribute("menuPerfil", validacionVO.getMenusPerfilMap());
                    	  session.setAttribute("menu", validacionVO.getMenusPerfilUser());
                      }
				} catch (ExcepcionAcceso e) {
					session.setAttribute("mensaje_error_logeo",
					"No tiene permiso para ingresar al aplicativo. Contacte al administrador del sistema si necesita autorización.");
					throw e;
				}				
				
				if (subirUsuario)
				{
              	    usuarioVO.setIpServidor(ipServidor);
            	    usuarioVO.setIpLocal(ipUsuario);
					session.setAttribute("usuarioAutenticado", usuarioVO);

					session.setAttribute("nombreUsuarioParaMostrarEnEncabezado", usuarioVO.getNombreApellido());
					
					ResourceBundle bundle 			= ResourceBundle.getBundle	(BUNDLEBASENAME);
					String formatoFechaHora			= bundle.getString			(BUNDLEKEYFORMATOFECHAHORA);		
					SimpleDateFormat 	formateador = new SimpleDateFormat(formatoFechaHora);
					String 				sFecha;
					java.util.Date 		dFecha;
					
					dFecha = new Date();
					sFecha = formateador.format(dFecha);
					sFecha = sFecha.toLowerCase();
					session.setAttribute("fechaParaMostrarEnEncabezado", sFecha);
					
					dFecha = usuarioVO.getFechaIngreso();
					sFecha = formateador.format(dFecha);
					sFecha = sFecha.toLowerCase();
					session.setAttribute("ultimoIngresoParaMostrarEnEncabezado", sFecha);
				}				  
              }
          }
          else
          {
        	  if (!nombreCompleto.equals("")) {
        		  session.setAttribute("mensaje_autorizacion", "El usuario (" + nombreCompleto + ") No se encontró en la Base de Datos.");
        	  }
        	  else{
        		  session.setAttribute("mensaje_autorizacion", "El usuario no se encontró en la Base de Datos.");
        	  }
              url = PAGINA_LOGIN;
              throw new ExcepcionAcceso("errorDeAcceso");
          }
		  
          if(session.getAttribute("intentosAcceso") != null){
              session.removeAttribute("intentosAcceso");
          }
      }
		/*******************************************************************
		 * FIN Obtener datos de autorizacion dentro de la aplicacion
		 *******************************************************************/
		

		/*******************************************************************
		 * INICIO Bloque Cambio de Perfil de Usuario
		 *******************************************************************/
		if( request.getParameter("newIdPer") != null && !subirUsuario ) 
		{
    	  nuevoIdPerfil = Integer.valueOf( (String)request.getParameter("newIdPer") );      
    	  boolean subirNuevoPerfil = false;
    	  
    	  usuarioVO = new UsuarioData();
    	  usuarioVO = (UsuarioData)session.getAttribute("usuarioAutenticado");
    	  PerfilData perfilVO = null;
    	  if (usuarioVO.getPerfilesUsuario() != null)
    	  {
	    	  for(Iterator<PerfilData> i = usuarioVO.getPerfilesUsuario().iterator();i.hasNext();)
	    	  {
	    		  perfilVO = new PerfilData();
	    		  perfilVO = i.next();
	    		  if ( perfilVO.getIdPerfil().compareTo(nuevoIdPerfil) == 0 ) 
	    		  {
	    			  subirNuevoPerfil = true;
	    			  break;
	    		  }
	    	  }
	    	  
	    	  if (subirNuevoPerfil)
	    	  {
	    		    usuarioVO.setIdAplicacionLogin( new Integer(ConfiguracionGeneral.getInstance().obtenerVariable(DatosConstantes.CODIGO_DE_APLICACION_REGISTRO)) );
				  	ValidaSeguridad validar = new ValidaSeguridad();
				  	ValidaSeguridadData validacionVO = validar.validarNuevoPerfilDeUsuario(null, usuarioVO, nuevoIdPerfil);
				  	
				  	if (validacionVO != null) 
				  	{
						session.setAttribute("menu", validacionVO.getMenusPerfilUser());
				  	}
				  	
				  	if (session.getAttribute("menuString") != null)
					  session.removeAttribute("menuString");
				  
				  	session.setAttribute("usuarioAutenticado", usuarioVO);
	    	  }
    	  }
    	  else
    		  AUDITORIALogger.getInstance().debugMessage("El usuario Logedo no tiene asociado el perfil ("+nuevoIdPerfil+")");
    	  
		}
		/*******************************************************************
		 * FIN Bloque Cambio de Perfil de Usuario
		 *******************************************************************/


		/*******************************************************************
		 * INICIO Validacion de recurso a acceder
		 *******************************************************************/
        menusAp = new HashMap<Integer,String>();
        menusPer = new HashMap<Integer,String>();

        if (session.getAttribute("menuAplicacion") != null) 
        {
            menusAp = (Map) session.getAttribute("menuAplicacion");
        }

        if (session.getAttribute("menuPerfil") != null) {
            menusPer = (Map) session.getAttribute("menuPerfil");
        }
		
        if (recurso != null)
        {
            if (!menusPer.containsValue(recurso)) 
            {
                if (menusAp.containsValue(recurso))
                {
                	AUDITORIALogger.getInstance().debugMessage("La aplicación sí tiene la opción: "+recurso);
                	request.setAttribute("mensaje_autorizacion", "No tiene permiso para el recurso que trata de acceder. Contacte al administrador.");
                    url = PAGINA_INFORMATIVO;
                }
            }
        }
		/*******************************************************************
		 * FIN Validacion de recurso a acceder
		 *******************************************************************/
       
        if(request.getParameter("logout") != null) 
      	  session.invalidate();      
      
        if (url != null) {
          RequestDispatcher rd = request.getRequestDispatcher(url);
          rd.forward(request, response);
        }
        
        
    } catch (ExcepcionAcceso e) {

        HttpSession session =  (request).getSession();
        if( session.getAttribute("mensaje_autorizacion") == null)
        {
        	session.setAttribute("mensaje_autorizacion", e.getMessage());
        }        
        if (e.getMessage().equals("Sin Perfil."))
        {
        	url = PAGINA_LOGIN;
        }        
        if (url != null)
        {        	
        	RequestDispatcher rd = request.getRequestDispatcher(url);
        	rd.forward(request, response);
        }        
        if (!nombreCompleto.equals(""))
        {
	        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
	        //AUDITORIALogger.getInstance().errorMessage(sdf.format(new Date())+" ExcepcionAcceso "+e.getMessage()+" ("+nombreCompleto+")");
        }
    } catch (Exception e) {
        throw new ServletException(e);
    } 
    
    if (url == null) {
    	chain.doFilter(request, response);
    }
    
  }


  /**
   * @param headerValue Value of Entrust header to decode
   * @exception IOException When writing the servlet info to the
   * browser page or getting the query string.
   */

  private String DecodeHeaderValue(String headerValue) throws IOException {
      BASE64Decoder base64 = new BASE64Decoder();

      if (headerValue == null) {
          return "null";
      } else {
          return new String(base64.decodeBuffer(headerValue));
      }
  }
  
  /**
   * Retorna el DN con el formato correcto.
   * @param DinstinguishedName
   */
  public String validarDN(String userDN){
		String dn = userDN.trim();
		String sn;
		String cn;
		String base = dn.substring(dn.indexOf(',')+1);

		base = StringUtils.replace(base, ", ", ",");
		
		if (dn.startsWith("serialNumber")) {
			sn = (dn.substring(0, dn.indexOf('+'))).trim();
			cn = (dn.substring(dn.indexOf('+')+1, dn.indexOf(','))).trim();
		} else {
			cn = (dn.substring(0, dn.indexOf('+'))).trim();
			sn = (dn.substring(dn.indexOf('+')+1, dn.indexOf(','))).trim();
		}
		
		if (sn.length() != 37) {
			String snTemp = StringUtils.deleteWhitespace(sn);
			int indice = 0;
			while (!StringUtils.isNumeric(snTemp.substring(indice))) {
				indice = indice + 1;
			}
			String pref = snTemp.substring(indice); 
			String suf = StringUtils.left(snTemp, indice);
			
			if (suf.length() != 16) {
				while (suf.length() < 16) {
					suf = suf + " ";
				}
			}

			if (pref.length() != 21) {
				String identificacion = StringUtils.left(pref, pref.length()-6);
				String consecutivo = StringUtils.right(pref, 6);
				while (identificacion.length() < 15) {
					identificacion = identificacion + " ";
				}
				pref = identificacion+consecutivo;
			}

			sn = suf+pref;

		}
		return (cn.trim()+"+"+sn.trim()+","+base.trim()).trim();
	}
  
/*	
	private FacesContext getFacesContext(HttpServletRequest request,
			HttpServletResponse response) {		
			FacesContext facesContext = FacesContext.getCurrentInstance();
			if (facesContext != null)
				return facesContext;
	
			FacesContextFactory contextFactory = (FacesContextFactory) FactoryFinder
					.getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
			LifecycleFactory lifecycleFactory = (LifecycleFactory) FactoryFinder
					.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
			Lifecycle lifecycle = lifecycleFactory
					.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);
	
			// Either set a private member servletContext =
			// filterConfig.getServletContext();
			// in you filter init() method or set it here like this:
			ServletContext servletContext = ((HttpServletRequest) request)
					.getSession().getServletContext();
			// Note that the above line would fail if you are using any other
			// protocol than http
	
			// Doesn't set this instance as the current instance of
			// FacesContext.getCurrentInstance
			facesContext = contextFactory.getFacesContext(servletContext,
					request, response, lifecycle);
	
			// Set using our inner class
			InnerFacesContext.setFacesContextAsCurrentInstance(facesContext);
	
			return facesContext;
	}

	private abstract static class InnerFacesContext extends FacesContext {
		protected static void setFacesContextAsCurrentInstance(
				FacesContext facesContext) {
			FacesContext.setCurrentInstance(facesContext);
		}
	}
*/
	/**
	 * Puts a new object in the current http session.
	 * @param key    Object name to be stored.
	 * @param object Object to be stored.
	 */
/*	protected void putSessionAttribute(HttpServletRequest request, HttpServletResponse response, String key, Object object) {
		
		HttpSession session = (HttpSession) getFacesContext(request, response).getCurrentInstance()
				.getExternalContext().getSession(false);
		if (session != null) {
			if (key != null)
				session.setAttribute(key, object);
		}
	}
*/
	/**
	 * Gets an object from the current http session
	 * @param key     Object name to be retrieved.
	 * @return Object stored in the current session if it doesn't exist null is returned.
	 */	
/*	protected Object getSessionAttribute(HttpServletRequest request, HttpServletResponse response, String key) {
		
		Object objeto = null;
		HttpSession session = (HttpSession) getFacesContext(request, response).getCurrentInstance()
				.getExternalContext().getSession(false);
		if (session != null) {
			if (key != null)
				objeto = session.getAttribute(key);
		}
		return objeto;
	}
*/

}
