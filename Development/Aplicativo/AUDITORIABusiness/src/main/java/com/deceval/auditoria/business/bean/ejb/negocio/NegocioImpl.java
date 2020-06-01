package com.deceval.auditoria.business.bean.ejb.negocio;

import java.util.Collection;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import com.deceval.auditoria.business.bean.pojo.negocio.NegocioPOJO;
import com.deceval.auditoria.dto.EstructuraConsultaDTO;
import com.deceval.auditoria.dto.EstructuraDetalleLogDTO;
import com.deceval.auditoria.dto.EstructuraLogDTO;
import com.deceval.auditoria.dto.RequestMsgInsertAudObjectDTO;
import com.deceval.auditoria.exception.DAOException;
import com.deceval.auditoria.exception.LogicException;
import com.deceval.auditoria.exception.ServiceException;
import com.deceval.auditoria.integration.remote.NegocioRemote;
import com.deceval.auditoria.vo.AplicacionVO;
import com.deceval.auditoria.vo.HomologacionVO;
import com.deceval.auditoria.vo.ModuloVO;
import com.deceval.auditoria.vo.OperacionVO;
import com.deceval.auditoria.vo.OrigenVO;

	
/**
 * EJB Stateless que declara implementa todos los metodos definidos por el modulo de negocio
 * @author ffonsacos
 */
@Stateless(name="NegocioService", mappedName="ejb/NegocioService")
@Remote ({NegocioRemote.class})
public class NegocioImpl implements NegocioRemote{

	private NegocioPOJO negocioPOJO;

	/**
	 * Permite inicio de POJO para anotacion en LOG
	 * @author ffonsacos
	 */
	public void crearAnotacionLog(RequestMsgInsertAudObjectDTO reqMsgObj) throws ServiceException{
		negocioPOJO = new NegocioPOJO();
		negocioPOJO.crearAnotacionLog(reqMsgObj);
		negocioPOJO=null;
	}
	
	/**
	 * LLamado para envio a cola de mensajeria de la anotacion en LOG
	 * @param log
	 * @return
	 */
	public String sendAnotacionLog2Queue(RequestMsgInsertAudObjectDTO reqMsgObj) {
		negocioPOJO = new NegocioPOJO();
		String proceso = negocioPOJO.sendAnotacionLog2Queue(reqMsgObj);
		negocioPOJO=null;
		return proceso;
	}
	
	/**
	 * Devuelve la lista de las aplicaciones
	 * @param 
	 * @return Collection de objetos AplicacionVO
	 * @author gmarroquin
	 */
	public Collection<AplicacionVO> obtenerListaAplicacion() {
		negocioPOJO = new NegocioPOJO();
		Collection<AplicacionVO> coleccionARetornar = negocioPOJO.obtenerListaAplicacion();
		negocioPOJO=null;
		return coleccionARetornar;		
	}
	
	/**
	 * Devuelve la lista de los modulos
	 * @param 
	 * @return Collection de objetos ModuloVO
	 * @author gmarroquin
	 */
	public Collection<ModuloVO> obtenerListaModulo() {
		negocioPOJO = new NegocioPOJO();
		Collection<ModuloVO> coleccionARetornar = negocioPOJO.obtenerListaModulo();
		negocioPOJO=null;
		return coleccionARetornar;	
	}	
	
	/**
	 * Devuelve la lista de las operaciones
	 * @param 
	 * @return Collection de objetos OperacionVO
	 * @author gmarroquin
	 */
	public Collection<OperacionVO> obtenerListaOperacion() {
		negocioPOJO = new NegocioPOJO();
		Collection<OperacionVO> coleccionARetornar = negocioPOJO.obtenerListaOperacion();
		negocioPOJO=null;
		return coleccionARetornar;	
	}		
	
	/**
	 * Devuelve la lista de los origenes
	 * @param 
	 * @return Collection de objetos OrigenVO
	 * @author gmarroquin
	 */
	public Collection<OrigenVO> obtenerListaOrigen() {
		negocioPOJO = new NegocioPOJO();
		Collection<OrigenVO> coleccionARetornar = negocioPOJO.obtenerListaOrigen();
		negocioPOJO=null;
		return coleccionARetornar;	
	}	
	
	/**
	 * Devuelve la lista de los logs
	 * @param EstructuraConsultaDTO estructuraConsultaDTO
	 * @return Collection de objetos EstructuraLogDTO
	 * @author gmarroquin
	 * @throws LogicException 
	 */
	public Collection<EstructuraLogDTO> obtenerListaLogs(EstructuraConsultaDTO estructuraConsultaDTO) {
		negocioPOJO = new NegocioPOJO();
		Collection<EstructuraLogDTO> coleccionARetornar = negocioPOJO.obtenerListaLogs(estructuraConsultaDTO);
		negocioPOJO=null;
		return coleccionARetornar;
	}		
	
	/**
	 * Devuelve la lista de códigos de origen
	 * @param EstructuraConsultaDTO estructuraConsultaDTO
	 * @return Collection de objetos String
	 * @author gmarroquin
	 * @throws LogicException 
	 */
	public Collection<String> obtenerListaCodigoOrigen(EstructuraConsultaDTO estructuraConsultaDTO) {
		negocioPOJO = new NegocioPOJO();
		Collection<String> coleccionARetornar = negocioPOJO.obtenerListaCodigoOrigen(estructuraConsultaDTO);
		negocioPOJO=null;
		return coleccionARetornar;
	}		
	
	/**
	 * Devuelve la lista de los detalles de los logs
	 * @param Long idTraza
	 * @return Collection de objetos EstructuraDetalleLogDTO
	 * @author gmarroquin
	 * @throws LogicException 
	 */
	public Collection<EstructuraDetalleLogDTO> obtenerListaDetalleLogs(Long idTraza) {
		negocioPOJO = new NegocioPOJO();
		Collection<EstructuraDetalleLogDTO> coleccionARetornar = negocioPOJO.obtenerListaDetalleLogs(idTraza);
		negocioPOJO=null;
		return coleccionARetornar;
	}		
	
	/**
	 * Devuelve la lista de los detalles de los logs
	 * @param EstructuraDetalleLogDTO estructuraDetalleLogDTO
	 * @return Collection de objetos EstructuraDetalleLogDTO
	 * @author gmarroquin
	 * @throws LogicException 
	 */	
	public Collection<EstructuraDetalleLogDTO> obtenerListaDetalleLogsByEstructuraConsultaDTO(
			EstructuraConsultaDTO estructuraConsultaDTO) {
		negocioPOJO = new NegocioPOJO();
		Collection<EstructuraDetalleLogDTO> coleccionARetornar = 
			negocioPOJO.obtenerListaDetalleLogsByEstructuraConsultaDTO(estructuraConsultaDTO);
		negocioPOJO=null;
		return coleccionARetornar;
	}	
	
	/**
	 * Devuelve el objeto a partir de su clave principal
	 * @param ModuloVO llave
	 * @return objeto ModuloVO
	 * @author gmarroquin
	 */	
	public OrigenVO findOrigenVOByPrimaryKey(OrigenVO llave) {
		negocioPOJO = new NegocioPOJO();
		OrigenVO elementoARetornar = negocioPOJO.findOrigenVOByPrimaryKey(llave);
		negocioPOJO=null;
		return elementoARetornar;	
	}	
	
	/**
	 * Devuelve el objeto a partir de su clave principal
	 * @param AplicacionVO llave
	 * @return objeto AplicacionVO
	 * @exception DAOException
	 * @author gmarroquin
	 */	
	public AplicacionVO findAplicacionVOByPrimaryKey(AplicacionVO llave) {
		negocioPOJO = new NegocioPOJO();
		AplicacionVO elementoARetornar = negocioPOJO.findAplicacionVOByPrimaryKey(llave);
		negocioPOJO=null;
		return elementoARetornar;	
	}	
	
	/**
	 * Devuelve el objeto a partir de su clave principal
	 * @param OperacionVO llave
	 * @return objeto OperacionVO
	 * @author gmarroquin
	 */	
	public OperacionVO findOperacionVOByPrimaryKey(OperacionVO llave) {
		negocioPOJO = new NegocioPOJO();
		OperacionVO elementoARetornar = negocioPOJO.findOperacionVOByPrimaryKey(llave);
		negocioPOJO=null;
		return elementoARetornar;	
	}	
	
	/**
	 * Devuelve el objeto a partir de su clave principal
	 * @param ModuloVO llave
	 * @return objeto ModuloVO
	 * @author gmarroquin
	 */	
	public ModuloVO findModuloVOByPrimaryKey(ModuloVO llave) {
		negocioPOJO = new NegocioPOJO();
		ModuloVO elementoARetornar = negocioPOJO.findModuloVOByPrimaryKey(llave);
		negocioPOJO=null;
		return elementoARetornar;	
	}
	
	/**
	 * Devuelve la lista de los modulos por IdAplicacion
	 * @param Integer idAplicacion
	 * @return Collection de objetos ModuloVO
	 * @author gmarroquin
	 */
	public Collection<ModuloVO> obtenerListaModuloPorIdAplicacion(Integer idAplicacion) {
		negocioPOJO = new NegocioPOJO();
		Collection<ModuloVO> coleccionARetornar = negocioPOJO.obtenerListaModuloPorIdAplicacion(idAplicacion);
		negocioPOJO=null;
		return coleccionARetornar;	
	}	
	
	/**
	 * Devuelve la lista de las operaciones por IdModulo
	 * @param Integer idModulo
	 * @return Collection de objetos OperacionVO
	 * @author gmarroquin
	 */
	public Collection<OperacionVO> obtenerListaOperacionPorIdModulo(Integer idModulo) {
		negocioPOJO = new NegocioPOJO();
		Collection<OperacionVO> coleccionARetornar = negocioPOJO.obtenerListaOperacionPorIdModulo(idModulo);
		negocioPOJO=null;
		return coleccionARetornar;	
	}		
	
	/**
	 * Devuelve la lista de los origenes por IdAplicacion
	 * @param Integer idAplicacion
	 * @return Collection de objetos OrigenVO
	 * @author gmarroquin
	 */
	public Collection<OrigenVO> obtenerListaOrigenPorIdAplicacion(Integer idAplicacion) {
		negocioPOJO = new NegocioPOJO();
		Collection<OrigenVO> coleccionARetornar = negocioPOJO.obtenerListaOrigenPorIdAplicacion(idAplicacion);
		negocioPOJO=null;
		return coleccionARetornar;	
	}	
	
	/**
	 * Devuelve el objeto a partir de su idTablaAuditoria, valorAuditoria y idTablaReferencia
	 * @param HomologacionVO llave
	 * @return objeto HomologacionVO
	 * @author gmarroquin
	 */	
	public HomologacionVO obtenerHomologacionVOPorIdTblAuditYValAuditYIdTblRef(HomologacionVO llave) {
		negocioPOJO = new NegocioPOJO();
		HomologacionVO objetoARetornar = 
			negocioPOJO.obtenerHomologacionVOPorIdTblAuditYValAuditYIdTblRef(llave);
		negocioPOJO=null;
		return objetoARetornar;	
	}	
}
