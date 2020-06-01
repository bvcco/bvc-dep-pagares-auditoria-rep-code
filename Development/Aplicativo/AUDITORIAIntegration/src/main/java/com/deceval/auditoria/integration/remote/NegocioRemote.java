package com.deceval.auditoria.integration.remote;

import java.util.Collection;

import com.deceval.auditoria.dto.EstructuraConsultaDTO;
import com.deceval.auditoria.dto.EstructuraDetalleLogDTO;
import com.deceval.auditoria.dto.EstructuraLogDTO;
import com.deceval.auditoria.dto.RequestMsgInsertAudObjectDTO;
import com.deceval.auditoria.exception.LogicException;
import com.deceval.auditoria.exception.ServiceException;
import com.deceval.auditoria.vo.AplicacionVO;
import com.deceval.auditoria.vo.HomologacionVO;
import com.deceval.auditoria.vo.ModuloVO;
import com.deceval.auditoria.vo.OperacionVO;
import com.deceval.auditoria.vo.OrigenVO;

public interface NegocioRemote extends DecevalRemote {
	
	/**
	 * Hace llamado a EJB para inicio del proceso de registro de anotacion en LOG
	 * @throws ServiceException
	 * @author ffonsacos
	 */
	public void crearAnotacionLog(RequestMsgInsertAudObjectDTO reqMsgObj) throws ServiceException;
	
	/**
	 * LLamado para envio a cola de mensajeria de la anotacion en LOG
	 * @param log
	 * @return
	 */
	public String sendAnotacionLog2Queue(RequestMsgInsertAudObjectDTO reqMsgObj);
	
	/**
	 * Devuelve la lista de las aplicaciones
	 * @param 
	 * @return Collection de objetos AplicacionVO
	 * @author gmarroquin
	 */
	public Collection<AplicacionVO> obtenerListaAplicacion();
	
	/**
	 * Devuelve la lista de los modulos
	 * @param 
	 * @return Collection de objetos ModuloVO
	 * @author gmarroquin
	 */
	public Collection<ModuloVO> obtenerListaModulo();
	
	/**
	 * Devuelve la lista de las operaciones
	 * @param 
	 * @return Collection de objetos OperacionVO
	 * @author gmarroquin
	 */
	public Collection<OperacionVO> obtenerListaOperacion();	

	/**
	 * Devuelve la lista de los origenes
	 * @param 
	 * @return Collection de objetos OrigenVO
	 * @author gmarroquin
	 */
	public Collection<OrigenVO> obtenerListaOrigen();	
	
	/**
	 * Devuelve la lista de los logs
	 * @param EstructuraConsultaDTO estructuraConsultaDTO
	 * @return Collection de objetos EstructuraLogDTO
	 * @author gmarroquin
	 * @throws LogicException 
	 */
	public Collection<EstructuraLogDTO> obtenerListaLogs(EstructuraConsultaDTO estructuraConsultaDTO);	
	
	/**
	 * Devuelve la lista de códigos de origen
	 * @param EstructuraConsultaDTO estructuraConsultaDTO
	 * @return Collection de objetos String
	 * @author gmarroquin
	 * @throws LogicException 
	 */
	public Collection<String> obtenerListaCodigoOrigen(EstructuraConsultaDTO estructuraConsultaDTO);	
	
	/**
	 * Devuelve la lista de los detalles de los logs
	 * @param Long idTraza
	 * @return Collection de objetos EstructuraDetalleLogDTO
	 * @author gmarroquin
	 * @throws LogicException 
	 */
	public Collection<EstructuraDetalleLogDTO> obtenerListaDetalleLogs(Long idTraza);	
	
	/**
	 * Devuelve la lista de los detalles de los logs
	 * @param EstructuraDetalleLogDTO estructuraDetalleLogDTO
	 * @return Collection de objetos EstructuraDetalleLogDTO
	 * @author gmarroquin
	 * @throws LogicException 
	 */	
	public Collection<EstructuraDetalleLogDTO> obtenerListaDetalleLogsByEstructuraConsultaDTO(
			EstructuraConsultaDTO estructuraConsultaDTO);
	
	/**
	 * Devuelve el objeto a partir de su clave principal
	 * @param ModuloVO llave
	 * @return objeto ModuloVO
	 * @author gmarroquin
	 * @throws LogicException 
	 */	
	public OrigenVO findOrigenVOByPrimaryKey(OrigenVO llave);
	
	/**
	 * Devuelve el objeto a partir de su clave principal
	 * @param AplicacionVO llave
	 * @return objeto AplicacionVO
	 * @author gmarroquin
	 * @throws LogicException 
	 */	
	public AplicacionVO findAplicacionVOByPrimaryKey(AplicacionVO llave);
	
	/**
	 * Devuelve el objeto a partir de su clave principal
	 * @param OperacionVO llave
	 * @return objeto OperacionVO
	 * @author gmarroquin
	 * @throws LogicException 
	 */	
	public OperacionVO findOperacionVOByPrimaryKey(OperacionVO llave);
	
	/**
	 * Devuelve el objeto a partir de su clave principal
	 * @param ModuloVO llave
	 * @return objeto ModuloVO
	 * @author gmarroquin
	 * @throws LogicException 
	 */	
	public ModuloVO findModuloVOByPrimaryKey(ModuloVO llave);
	
	/**
	 * Devuelve la lista de los modulos por IdAplicacion
	 * @param Integer idAplicacion
	 * @return Collection de objetos ModuloVO
	 * @author gmarroquin
	 */
	public Collection<ModuloVO> obtenerListaModuloPorIdAplicacion(Integer idAplicacion);
	
	/**
	 * Devuelve la lista de las operaciones por IdModulo
	 * @param Integer idModulo
	 * @return Collection de objetos OperacionVO
	 * @author gmarroquin
	 */
	public Collection<OperacionVO> obtenerListaOperacionPorIdModulo(Integer idModulo);	

	/**
	 * Devuelve la lista de los origenes por IdAplicacion
	 * @param Integer idAplicacion
	 * @return Collection de objetos OrigenVO
	 * @author gmarroquin
	 */
	public Collection<OrigenVO> obtenerListaOrigenPorIdAplicacion(Integer idAplicacion);	
	
	/**
	 * Devuelve el objeto a partir de su idTablaAuditoria, valorAuditoria y idTablaReferencia
	 * @param HomologacionVO llave
	 * @return objeto HomologacionVO
	 * @author gmarroquin
	 */
	public HomologacionVO obtenerHomologacionVOPorIdTblAuditYValAuditYIdTblRef(HomologacionVO llave);
}
