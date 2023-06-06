package com.deceval.auditoria.web.backingbean.consulta;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import com.deceval.auditoria.exception.LogicException;
import com.deceval.auditoria.integration.NegocioDelegate;
import com.deceval.auditoria.util.date.DateUtil;
import com.deceval.auditoria.vo.AplicacionVO;
import com.deceval.auditoria.vo.ModuloVO;
import com.deceval.auditoria.vo.OperacionVO;
import com.deceval.auditoria.vo.OrigenVO;
import com.deceval.auditoria.web.backingbean.common.BaseJSFBean;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.comportamiento.producirdetalleresultadoconsulta.poroperacion.ProducirDetalleResultadoConsulta;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.comportamiento.producirdetalleresultadoconsulta.pororigen.ProducirDetalleResultadoConsultaOrigen;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.comportamiento.producirresultadosconsulta.poroperacion.ProducirResultadosConsulta;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.comportamiento.producirresultadosconsulta.pororigen.ProducirResultadosConsultaOrigen;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.detalleresultadoconsulta.DetalleResultadoConsulta;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.parametrosconsulta.ParametrosConsulta;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.resultadosconsulta.FilaResultadosConsulta;
import com.deceval.auditoria.web.backingbean.consulta.datosinterfaceusuario.informacion.resultadosconsulta.ResultadosConsulta;
import com.deceval.auditoria.web.backingbean.consulta.manejodecombos.ManejoDeComboAplicacion;
import com.deceval.auditoria.web.backingbean.consulta.manejodecombos.ManejoDeComboModulo;
import com.deceval.auditoria.web.backingbean.consulta.manejodecombos.ManejoDeComboOperacion;
import com.deceval.auditoria.web.backingbean.consulta.manejodecombos.ManejoDeComboOrigen;
import com.deceval.auditoria.web.backingbean.consulta.manejodecombos.ManejoDeComboTipoFiltro;

public class ConsultaJSFBean extends BaseJSFBean{
	private final static String OUTCOME_FROM_PARCONS_TO_RESCONSOPER			= "resultadoConsultaOperacion";

	private final static String OUTCOME_FROM_RESCONSOPER_TO_PARCONS			= "parametrosConsulta";
	private final static String OUTCOME_FROM_RESCONSOPER_TO_DETRESCONSOPER	= "detalleResultadoConsultaOperacion";

	private final static String OUTCOME_FROM_DETRESCONSOPER_TO_RESCONSOPER	= "resultadoConsultaOperacion";

	//-------------------------------------
	
	private final static String OUTCOME_FROM_PARCONS_TO_RESCONSORIG			= "resultadoConsultaOrigen";
	private final static String OUTCOME_FROM_PARCONS_TO_DETRESCONSORIG		= "detalleResultadoConsultaOrigen";

	private final static String OUTCOME_FROM_RESCONSORIG_TO_DETRESCONSORIG	= "detalleResultadoConsultaOrigen";

	private final static String OUTCOME_FROM_DETRESCONSORIG_TO_PARCONS		= "parametrosConsulta";
	private final static String OUTCOME_FROM_DETRESCONSORIG_TO_RESCONSORIG	= "resultadoConsultaOrigen";	

	/*  Corresponde a lo que ha sido seleccionado en los combo box y controles */
	private ParametrosConsulta 				parametrosConsulta 				= new ParametrosConsulta();
	private ResultadosConsulta 				resultadosConsulta 				= new ResultadosConsulta();	
	private DetalleResultadoConsulta 		detalleResultadoConsulta 		= new DetalleResultadoConsulta();
	
	private boolean 						irADetalleConsultaOrigen 		= false;
	private boolean 						soloHayUnaAplicacion	 		= false;
	
	private UIData 							tabla;						
	
	private ManejoDeComboAplicacion			manejoDeComboAplicacion			= new ManejoDeComboAplicacion();
	private ManejoDeComboModulo				manejoDeComboModulo				= new ManejoDeComboModulo();
	private ManejoDeComboTipoFiltro			manejoDeComboTipoFiltro			= new ManejoDeComboTipoFiltro();	
	private ManejoDeComboOperacion			manejoDeComboOperacion			= new ManejoDeComboOperacion();
	private ManejoDeComboOrigen				manejoDeComboOrigen				= new ManejoDeComboOrigen();		
	
	private String							mensajeDeError					= "";
	
	private static String BUNDLEBASENAME 				= "com.deceval.auditoria.web.resources.messages.MessagesResources";
	private static String BUNDLEKEYFECHASINVALIDAS 		= "msg_fechas_invalidas";
	private static String BUNDLEKEYFALTAAPLICACION 		= "msg_falta_aplicacion";	
	private static String BUNDLEKEYFALTAMODULO 			= "msg_falta_modulo";
	private static String BUNDLEKEYFALTAORIGEN	 		= "msg_falta_origen";	
	private static String BUNDLEKEYFALTAOPERACION 		= "msg_falta_operacion";		
	
	/**
	 * @return the mensajeDeError
	 */
	public String getMensajeDeError() {
		return mensajeDeError;
	}

	/**
	 * @param mensajeDeError the mensajeDeError to set
	 */
	public void setMensajeDeError(String mensajeDeError) {
		this.mensajeDeError = mensajeDeError;
	}

	public String doRegresarAParametrosConsulta() {
		return OUTCOME_FROM_RESCONSOPER_TO_PARCONS;
	}
	
	public String doRegresarAResultadosConsultaOperacion() {
		return OUTCOME_FROM_DETRESCONSOPER_TO_RESCONSOPER;
	}	
	
	public String doRegresarAResultadosConsultaOrigen() {
		if(irADetalleConsultaOrigen) {
			return OUTCOME_FROM_DETRESCONSORIG_TO_PARCONS;
		} else {
			return OUTCOME_FROM_DETRESCONSORIG_TO_RESCONSORIG;
		}
	}
	
	public String doLimpiar() {
		parametrosConsulta.setFechaDesde		(new java.util.Date());
		parametrosConsulta.setFechaHasta		(new java.util.Date());
		parametrosConsulta.setUsuario			("");
		parametrosConsulta.setIdTipoFiltro		(ParametrosConsulta.TIPO_FILTRO_POR_OPERACION);
		parametrosConsulta.setCodigoOrigen		("");
		parametrosConsulta.setIdOperacion		(new Integer(0));
		if(soloHayUnaAplicacion) {
			parametrosConsulta.setIdModulo		(new Integer(0));
			parametrosConsulta.setIdOrigen		(new Integer(0));			
		} else {
			parametrosConsulta.setIdAplicacion	(new Integer(0));
			parametrosConsulta.setIdModulo		(new Integer(0));
			parametrosConsulta.setIdOrigen		(new Integer(0));
		}
		mensajeDeError = "";
		return "";
	}
	
	public String doConsultar() throws LogicException {
		ResourceBundle bundle = ResourceBundle.getBundle(BUNDLEBASENAME);
		
		/*FEFA - se pone fecha inicial a ceros y fecha final al fina del día*/
		parametrosConsulta.setFechaDesde(DateUtil.getFechaInicialHMS(parametrosConsulta.getFechaDesde()).getTime());
		parametrosConsulta.setFechaHasta(DateUtil.getFechaFinalHMS(parametrosConsulta.getFechaHasta()).getTime());
		/*Fin FEFA*/
		
		if(parametrosConsulta.getIdAplicacion() == 0) {		
			mensajeDeError = bundle.getString(BUNDLEKEYFALTAAPLICACION);	
			return "";
		}		
		
		if(parametrosConsulta.getIdModulo() == 0) {		
			mensajeDeError = bundle.getString(BUNDLEKEYFALTAMODULO);
			return "";
		}
		
		if(parametrosConsulta.getIdTipoFiltro().intValue() == ParametrosConsulta.TIPO_FILTRO_POR_ORIGEN) {
			if(parametrosConsulta.getIdOrigen() == 0) {		
				mensajeDeError = bundle.getString(BUNDLEKEYFALTAORIGEN);	
				return "";
			}	
		} else {
			if(parametrosConsulta.getIdOperacion() == 0) {		
				mensajeDeError = bundle.getString(BUNDLEKEYFALTAOPERACION);	
				return "";
			}
		}
		
		if(parametrosConsulta.getFechaDesde().after(parametrosConsulta.getFechaHasta())) {			
			mensajeDeError = bundle.getString(BUNDLEKEYFECHASINVALIDAS);
			return "";
		}
		
		mensajeDeError = "";
		
		if(parametrosConsulta.getIdTipoFiltro().intValue() == ParametrosConsulta.TIPO_FILTRO_POR_OPERACION) {
			ProducirResultadosConsulta producirResultadosConsulta = new ProducirResultadosConsulta();
			producirResultadosConsulta.setEntrada	(parametrosConsulta);
			producirResultadosConsulta.setUtil		(this);
			producirResultadosConsulta.producir		();
			resultadosConsulta = producirResultadosConsulta.getSalida();			
			return OUTCOME_FROM_PARCONS_TO_RESCONSOPER;
		} else {
			if(parametrosConsulta.getCodigoOrigen().trim().length() == 0) {		
				irADetalleConsultaOrigen = false;
				ProducirResultadosConsultaOrigen producirResultadosConsulta = new ProducirResultadosConsultaOrigen();
				producirResultadosConsulta.setEntrada	(parametrosConsulta);
				producirResultadosConsulta.setUtil		(this);
				producirResultadosConsulta.producir		();
				resultadosConsulta = producirResultadosConsulta.getSalida();			
				return OUTCOME_FROM_PARCONS_TO_RESCONSORIG;
			} else {
				irADetalleConsultaOrigen = true;
				ProducirDetalleResultadoConsultaOrigen producirDetalleResultadoConsultaOrigen = 
					new ProducirDetalleResultadoConsultaOrigen();
				producirDetalleResultadoConsultaOrigen.setEntrada	(parametrosConsulta);
				producirDetalleResultadoConsultaOrigen.producir		();
				detalleResultadoConsulta = producirDetalleResultadoConsultaOrigen.getSalida();			
				return OUTCOME_FROM_PARCONS_TO_DETRESCONSORIG;
			}						
		}
	}
	
	public String doVerOrigen() throws LogicException {
		FilaResultadosConsulta filaResultadosConsulta;
		FilaResultadosConsulta filaResultadosConsultaDeseada = null;
		int i = 0;
		for (Iterator<FilaResultadosConsulta> iterator = 
			resultadosConsulta.getFilasResultadosConsulta().iterator(); iterator.hasNext();) {
			
			filaResultadosConsulta = (FilaResultadosConsulta) iterator.next();
			if(i == tabla.getRowIndex()) {
				filaResultadosConsultaDeseada = filaResultadosConsulta;
				break;
			}
			i ++;			
		}

		parametrosConsulta.setCodigoOrigen(filaResultadosConsultaDeseada.getCodigoOrigen());
				
		ProducirDetalleResultadoConsultaOrigen producirDetalleResultadoConsultaOrigen = 
			new ProducirDetalleResultadoConsultaOrigen();
		producirDetalleResultadoConsultaOrigen.setEntrada	(parametrosConsulta);
		producirDetalleResultadoConsultaOrigen.producir		();
		detalleResultadoConsulta = producirDetalleResultadoConsultaOrigen.getSalida();			
		return OUTCOME_FROM_RESCONSORIG_TO_DETRESCONSORIG;		
	}
	
	public String doVerOperacion() throws LogicException {
		ProducirDetalleResultadoConsulta producirDetalleResultadoConsulta = new ProducirDetalleResultadoConsulta();
		
		FilaResultadosConsulta filaResultadosConsulta;
		FilaResultadosConsulta filaResultadosConsultaDeseada = null;
		int i = 0;
		for (Iterator<FilaResultadosConsulta> iterator = 
			resultadosConsulta.getFilasResultadosConsulta().iterator(); iterator.hasNext();) {
			
			filaResultadosConsulta = (FilaResultadosConsulta) iterator.next();
			if(i == tabla.getRowIndex()) {
				filaResultadosConsultaDeseada = filaResultadosConsulta;
				break;
			}
			i ++;			
		}
		
		producirDetalleResultadoConsulta.setEntrada	(filaResultadosConsultaDeseada);
		producirDetalleResultadoConsulta.producir	();
		detalleResultadoConsulta = producirDetalleResultadoConsulta.getSalida();
		return OUTCOME_FROM_RESCONSOPER_TO_DETRESCONSOPER;
	}	
	
	/*  Corresponde al funcionamiento del combo box de Aplicaciones */
	/**
	 * @return the aplicaciones
	 * @throws Exception 
	 */
	public LinkedList<SelectItem> getAplicaciones() throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession iSession = (HttpSession) context.getExternalContext().getSession(false);
		manejoDeComboAplicacion.crear(iSession);
		return manejoDeComboAplicacion.getAplicaciones();
	}
	/**
	 * @param aplicaciones the aplicaciones to set
	 */
	public void setAplicaciones(LinkedList<SelectItem> aplicaciones) {
		// No se puede setear
	}
	
	/*  Corresponde al funcionamiento del combo box de Módulos */
	/**
	 * @return the modulos
	 * @throws LogicException 
	 */
	public LinkedList<SelectItem> getModulos() throws LogicException { 
		LinkedList<SelectItem> resultado = manejoDeComboModulo.getModulos(devolverInt(parametrosConsulta.getIdAplicacion()));
		if(manejoDeComboModulo.getBorrarIdModulo()) parametrosConsulta.setIdModulo(new Integer(0));
		return resultado;
	}
	/**
	 * @param modulos the modulos to set
	 */
	public void setModulos(LinkedList<SelectItem> modulos) {
		// No se puede setear
	}
	
	/*  Corresponde al funcionamiento del combo box de Tipo Filtro */
	/**
	 * @return the Tipos de Filtro
	 * @throws LogicException 
	 */
	public LinkedList<SelectItem> getTiposFiltro() throws LogicException {
		return manejoDeComboTipoFiltro.getTiposFiltro();
	}	
	
	/*  Corresponde al funcionamiento del combo box de Operaciones */
	/**
	 * @return the operaciones
	 * @throws LogicException 
	 */
	public LinkedList<SelectItem> getOperaciones() throws LogicException { 			
		LinkedList<SelectItem> resultado = manejoDeComboOperacion.getOperaciones(
				devolverInt(parametrosConsulta.getIdAplicacion()), devolverInt(parametrosConsulta.getIdModulo()));	
		if(manejoDeComboOperacion.getBorrarIdOperacion()) parametrosConsulta.setIdOperacion(new Integer(0));
		return resultado;			
	}
	/**
	 * @param operaciones the operaciones to set
	 */
	public void setOperaciones(LinkedList<SelectItem> operaciones) { 
		// No se puede setear
	}
	
	/*  Corresponde al funcionamiento del combo box de Origenes */
	/**
	 * @return the origenes
	 * @throws LogicException 
	 */
	public LinkedList<SelectItem> getOrigenes() throws LogicException {			
		LinkedList<SelectItem> resultado = manejoDeComboOrigen.getOrigenes(devolverInt(parametrosConsulta.getIdAplicacion()));	
		if(manejoDeComboOrigen.getBorrarIdOrigen()) parametrosConsulta.setIdOrigen(new Integer(0));
		return resultado;		
	}
	/**
	 * @param origenes the origenes to set
	 */
	public void setOrigenes(LinkedList<SelectItem> origenes) {
		// No se puede setear
	}	

	/**
	 * @return the resultadosConsulta
	 */
	public ResultadosConsulta getResultadosConsulta() {
		return resultadosConsulta;
	}

	/**
	 * @param resultadosConsulta the resultadosConsulta to set
	 */
	public void setResultadosConsulta(ResultadosConsulta resultadosConsulta) {
		this.resultadosConsulta = resultadosConsulta;
	}

	/**
	 * @return the tabla
	 */
	public UIData getTabla() {
		return tabla;
	}

	/**
	 * @param tabla the tabla to set
	 */
	public void setTabla(UIData tabla) {
		this.tabla = tabla;
	}

	/**
	 * @return the detalleResultadoConsulta
	 */
	public DetalleResultadoConsulta getDetalleResultadoConsulta() {
		return detalleResultadoConsulta;
	}

	/**
	 * @param detalleResultadoConsulta the detalleResultadoConsulta to set
	 */
	public void setDetalleResultadoConsulta(
			DetalleResultadoConsulta detalleResultadoConsulta) {
		this.detalleResultadoConsulta = detalleResultadoConsulta;
	}
	
	/**
	 * @return the nombreOrigen
	 * @throws LogicException 
	 */
	public String getNombreOrigen() throws LogicException {
		NegocioDelegate negocioDelegate = new NegocioDelegate();
		OrigenVO llave = new OrigenVO();
		llave.setIdOrigen(parametrosConsulta.getIdOrigen());
		return negocioDelegate.findOrigenVOByPrimaryKey(llave).getDescripcionOrigen();	
	}
	
	/**
	 * @return the nombreAplicacion
	 * @throws LogicException 
	 */
	public String getNombreAplicacion() throws LogicException {
		NegocioDelegate negocioDelegate = new NegocioDelegate();
		AplicacionVO llave = new AplicacionVO();
		llave.setIdAplicacion(parametrosConsulta.getIdAplicacion());
		return negocioDelegate.findAplicacionVOByPrimaryKey(llave).getNombreAplicacion();		
	}
	
	/**
	 * @return the nombreModulo
	 * @throws LogicException 
	 */
	public String getNombreModulo() throws LogicException {
		NegocioDelegate negocioDelegate = new NegocioDelegate();
		ModuloVO llave = new ModuloVO();
		llave.setIdModulo(parametrosConsulta.getIdModulo());
		return negocioDelegate.findModuloVOByPrimaryKey(llave).getNombreModulo();			
	}	
	
	/**
	 * @return the nombreOperacion
	 * @throws LogicException 
	 */
	public String getNombreOperacion() throws LogicException {
		NegocioDelegate negocioDelegate = new NegocioDelegate();
		OperacionVO llave = new OperacionVO();
		llave.setIdOperacion(parametrosConsulta.getIdOperacion());
		return negocioDelegate.findOperacionVOByPrimaryKey(llave).getDescripcionOperacion();			
	}
	
	/**
	 * @return the parametrosConsulta
	 */
	public ParametrosConsulta getParametrosConsulta() {
		return parametrosConsulta;
	}

	/**
	 * @return the renderedTituloTablas
	 */
	public Boolean getRenderedTituloTablas() {
		if(detalleResultadoConsulta.getTablas().size() == 0) {
			return false;
		} else {
			return true;
		}
	}	
	
	public Boolean getRenderedNoHayDatosDetalleResultado() {
		if(detalleResultadoConsulta.getTablas().size() == 0) {
			return true;
		} else {
			return false;
		}
	}	
	
	/**
	 * @param parametrosConsulta the parametrosConsulta to set
	 */
	public void setParametrosConsulta(ParametrosConsulta parametrosConsulta) {
		this.parametrosConsulta = parametrosConsulta;
	}

	private int devolverInt(Integer entrada) {
		int intEntrada = 0;
		if(entrada != null) {
			intEntrada = entrada.intValue();
		}
		
		return intEntrada;
	}	
	
	public Boolean getReadOnlyAplicacion() throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession iSession = (HttpSession) context.getExternalContext().getSession(false);
		manejoDeComboAplicacion.crear(iSession);
		LinkedList<SelectItem> aplicaciones = manejoDeComboAplicacion.getAplicaciones();	
		Integer idAplicacion;
		Iterator<SelectItem> iterator = aplicaciones.iterator();
		if(aplicaciones.size() == 2) {
			soloHayUnaAplicacion = true;
			iterator.next();
			idAplicacion = (Integer) iterator.next().getValue();
			parametrosConsulta.setIdAplicacion(idAplicacion);
			return true;
		}
		return false;
	}
}
