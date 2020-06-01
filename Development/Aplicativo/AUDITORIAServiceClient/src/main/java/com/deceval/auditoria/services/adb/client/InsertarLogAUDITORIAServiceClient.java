package com.deceval.auditoria.services.adb.client;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class InsertarLogAUDITORIAServiceClient {
	
	public static String insertarLogAuditoria(String constanteReferenciaOperacion, String constanteReferenciaOrigen, String codigoOrigen, Integer idUsuario, String userName, String ipUsuario, String ipServidor, String descripcionAnotacion, List listaVOs, String urlWS){
		String resultado = null;
		try {
			//Bloque de validacion basica de datos
			Boolean datos = Boolean.FALSE;
			if (constanteReferenciaOperacion != null && constanteReferenciaOperacion.length() > 0 &&
				constanteReferenciaOrigen != null && constanteReferenciaOrigen.length() > 0 &&
				codigoOrigen != null &&
				idUsuario != null &&
				userName != null && userName.length() > 0 &&
				ipUsuario != null && ipUsuario.length() > 0 &&
				ipServidor != null && ipServidor.length() > 0 &&
				descripcionAnotacion != null && descripcionAnotacion.length() > 0 &&
				urlWS != null && urlWS.length() > 0)
				datos = Boolean.TRUE;
			
			//Si pasa validacion se  setean objetois y se llama al WS
			if (datos){
				InsertarLogAUDITORIAServiceStub stub = new InsertarLogAUDITORIAServiceStub(urlWS);
				InsertarLogAUDITORIAServiceStub.InsertarLogRequest request = new InsertarLogAUDITORIAServiceStub.InsertarLogRequest();
				
				//Inicializacion de contenedores de las variables
				request.setInsertarLogRequest(new InsertarLogAUDITORIAServiceStub.InsertarLogRequestType());
				request.getInsertarLogRequest().setConstanteReferenciaOperacion(new InsertarLogAUDITORIAServiceStub.ConstanteReferenciaOperacionType());
				request.getInsertarLogRequest().setConstanteReferenciaOrigen(new InsertarLogAUDITORIAServiceStub.ConstanteReferenciaOrigenType());
				request.getInsertarLogRequest().setCodigoOrigen(new InsertarLogAUDITORIAServiceStub.CodigoOrigenType());
				request.getInsertarLogRequest().setIdUsuario(new InsertarLogAUDITORIAServiceStub.IdUsuarioType());
				request.getInsertarLogRequest().setUserName(new InsertarLogAUDITORIAServiceStub.UserNameType());
				request.getInsertarLogRequest().setIpUsuario(new InsertarLogAUDITORIAServiceStub.IpUsuarioType());
				request.getInsertarLogRequest().setIpServidor(new InsertarLogAUDITORIAServiceStub.IpServidorType());
				request.getInsertarLogRequest().setDescripcionAnotacion(new InsertarLogAUDITORIAServiceStub.DescripcionAnotacionType());
				
				//Asignacion de informacion a enviar en el WS
				request.getInsertarLogRequest().getConstanteReferenciaOperacion().setConstanteReferenciaOperacionType(constanteReferenciaOperacion);
				request.getInsertarLogRequest().getConstanteReferenciaOrigen().setConstanteReferenciaOrigenType(constanteReferenciaOrigen);
				request.getInsertarLogRequest().getCodigoOrigen().setCodigoOrigenType(codigoOrigen);
				request.getInsertarLogRequest().getIdUsuario().setIdUsuarioType(idUsuario);
				request.getInsertarLogRequest().getUserName().setUserNameType(userName);
				request.getInsertarLogRequest().getIpUsuario().setIpUsuarioType(ipUsuario);
				request.getInsertarLogRequest().getIpServidor().setIpServidorType(ipServidor);
				request.getInsertarLogRequest().getDescripcionAnotacion().setDescripcionAnotacionType(descripcionAnotacion);
				
				/*Si dentro de los parametros viene la lista de VOs; por introspeccion: 
				 * Se extrae el nombre de la tabla a auditar.
				 * Se extraen los nombres de campos y los valores de los mismos para setear el mensaje a enviar
				 */
				if (listaVOs != null && listaVOs.size() > 0){   
			        try {
			        	request.getInsertarLogRequest().setListaEstructuras(new InsertarLogAUDITORIAServiceStub.ListaEstructurasType());
			        	request.getInsertarLogRequest().getListaEstructuras().setEstructuraTabla(new InsertarLogAUDITORIAServiceStub.EstructuraTablaType[listaVOs.size()]);
			        	//Se recorre la lista para extraer cada una de las estructuras y empaquetarlas dentro del mensaje AXIS
			        	Object vo = null;
			        	for(int contadorVO = 0; contadorVO < listaVOs.size(); contadorVO++){
			        		vo = (Object)listaVOs.get(contadorVO);
			        		if (vo == null)
			        			return "ERROR-009, se detecto un VO NULL.";
			        		Class<?> cl = vo.getClass();
				        	/*Se obtiene el nombre de la tabla
				        	Se parte del hecho que un VO extiende de BaseData y siempre deberia tener el metodo getNombreTablaVO implementado*/
				        	Method metodo = cl.getMethod("getNombreTablaVO", null);
		                    Object dato = metodo.invoke(vo, null);
		                    request.getInsertarLogRequest().getListaEstructuras().getEstructuraTabla()[contadorVO] = new InsertarLogAUDITORIAServiceStub.EstructuraTablaType();
		                    request.getInsertarLogRequest().getListaEstructuras().getEstructuraTabla()[contadorVO].setNombreTabla(new InsertarLogAUDITORIAServiceStub.NombreTablaType()); 
		                    request.getInsertarLogRequest().getListaEstructuras().getEstructuraTabla()[contadorVO].getNombreTabla().setNombreTablaType(dato.toString());
		                    //Se obtienen campos y valores
				        	Field[] campos = cl.getDeclaredFields();
				            if(campos.length > 0){
				            	int contadorCampos = 0;
				                Map<String, String> mapCampos = new HashMap<String, String>(); 
				            	for (int i=0; i < campos.length; i++){
				                    Field campo = campos[i];
				                    String nombreCampo = campo.getName();
				                    String valorCampo = "NULL";
				                    String tipoCampo = campo.getType().getName();
				                    try {
				                    	metodo = cl.getMethod("get" + nombreCampo.substring(0,1).toUpperCase() + nombreCampo.substring(1,nombreCampo.length()), null);
					                    dato = metodo.invoke(vo, null);
					                    if(dato != null){
					                    	SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd HHmmss");
					                    	if (tipoCampo.toLowerCase().contains("date")){
						                    	Date fecha = (Date)dato;
						                    	valorCampo = formatoFecha.format(fecha.getTime()) + "";
						                    } else if (tipoCampo.toLowerCase().contains("timestamp")){
						                    	Timestamp fecha = (Timestamp)dato;
						                    	valorCampo = formatoFecha.format(fecha.getTime()) + "";
						                    } else if (tipoCampo.toLowerCase().contains("calendar")){
						                    	Calendar fecha = (Calendar)dato;
						                    	valorCampo = formatoFecha.format(fecha.getTimeInMillis()) + "";
						                    } else
						                    	valorCampo = dato.toString();
					                    }
					                    mapCampos.put(nombreCampo, valorCampo);
					                    contadorCampos++;
				                    } catch (Exception ex){}
				                }
				            	if (contadorCampos > 0){
				            		request.getInsertarLogRequest().getListaEstructuras().getEstructuraTabla()[contadorVO].setNombreCampo(new InsertarLogAUDITORIAServiceStub.NombreCampoType[contadorCampos]);
				            		request.getInsertarLogRequest().getListaEstructuras().getEstructuraTabla()[contadorVO].setValorCampo(new InsertarLogAUDITORIAServiceStub.ValorCampoType[contadorCampos]);
				            		Collection<String> keys = mapCampos.keySet();
					            	String nombre = null;
					            	int posicion = 0;
					            	for (Iterator<String> i = keys.iterator(); i.hasNext();){
					            		nombre = i.next();
					            		request.getInsertarLogRequest().getListaEstructuras().getEstructuraTabla()[contadorVO].getNombreCampo()[posicion] = new InsertarLogAUDITORIAServiceStub.NombreCampoType();
					            		request.getInsertarLogRequest().getListaEstructuras().getEstructuraTabla()[contadorVO].getNombreCampo()[posicion].setNombreCampoType(nombre.length()>50?nombre.substring(0,50):nombre);
					            		request.getInsertarLogRequest().getListaEstructuras().getEstructuraTabla()[contadorVO].getValorCampo()[posicion] = new InsertarLogAUDITORIAServiceStub.ValorCampoType();
					            		request.getInsertarLogRequest().getListaEstructuras().getEstructuraTabla()[contadorVO].getValorCampo()[posicion].setValorCampoType((mapCampos.get(nombre) != null && mapCampos.get(nombre).length()>255)?(mapCampos.get(nombre).substring(0,255)):mapCampos.get(nombre));                                                  
					            		posicion++;
					            	}
				            	}
				            }
		                }
			        } catch (Exception e){
			        	resultado = "ERROR-007, VO no cumple estructura requerida.";
			            e.printStackTrace();
			            return resultado;
			        }
			    }
				//Llamado al WS
				InsertarLogAUDITORIAServiceStub.InsertarLogResponse response = stub.insertarLog(request);
				resultado = response.getInsertarLogResponse().getResultadoCreacion().getResultadoCreacionType();
			}else
				resultado = "ERROR-004, datos no pasan la validación.";
		} catch (RemoteException e) {
			resultado = "ERROR-005, RemoteException.";
			e.printStackTrace();
		} catch (FaultMsg e) {
			resultado = "ERROR-006, FaultMsg; ver log de aplicacion.";
			e.printStackTrace();
			System.out.println("Error code: " + e.getFaultMessage().getFault().getErrorCode());
			System.out.println("Reason: " + e.getFaultMessage().getFault().getReason());
		} catch (Exception ex){
			resultado = "ERROR-008, Inesperado; ver log de aplicacion.";
			ex.printStackTrace();
		}
		return resultado;
	}

}
