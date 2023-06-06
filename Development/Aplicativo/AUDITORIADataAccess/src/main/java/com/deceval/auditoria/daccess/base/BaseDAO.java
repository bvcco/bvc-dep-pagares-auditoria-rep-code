/*
 * BaseDAO
 * Date 13/08/2008
 * Copyright (c) 2008
 * Company: Deceval S.A
 * All Rights Reserved.
 * This software is the confidential and proprietary information of Deceval S.A.
 */

package com.deceval.auditoria.daccess.base;

import java.util.Collection;

import com.deceval.auditoria.exception.DAOException;
import com.deceval.auditoria.BaseDataVO;

/**
 * Interfaz que define las firmas de los metodos b�sicos para los DAOs(insert,
 * delete, update, findByPrimaryKey, findByFilter, getAll)
 * 
 * @version 1.0
 * @author Johann Camilo Olarte D�az.
 */
public interface BaseDAO<B extends BaseDataVO> {

	/**
	 * M�todo que permite crear un registro en una base de datos
	 * 
	 * @param data
	 *            Objeto con la informaci�n del registro que se va a crear
	 * @return Objeto con la informaci�n actualizada del registro creado
	 * @throws DAOException
	 *             En caso de que exista alg�n problema con la conexi�n o el
	 *             script de creaci�n
	 */
	public B insert(B data) throws DAOException;

	/**
	 * M�todo encargado de eliminar un registro de una base de datos
	 * 
	 * @param llave
	 *            Llave del registro a eliminar
	 * @throws DAOException
	 */
	public void delete(B llave) throws DAOException;

	/**
	 * M�todo que permite obtener un registro de acuerdo a su llave primaria
	 * 
	 * @param llave
	 *            Objeto llave primaria
	 * @return Objeto con la informaci�n del registro encontrado
	 * @throws DAOException
	 */
	public B findByPrimaryKey(B llave) throws DAOException;

	/**
	 * M�todo que permite actualizar un registro en una base de datos
	 * 
	 * @param data
	 *            Objeto con la informaci�n de actualizaci�n del registro
	 * @return Objeto con la informaci�n despues de la actualizaci�n
	 * @throws DAOException
	 */
	public B update(B data, String[] updateFields) throws DAOException;

	/**
	 * M�todo que permite obtener todos los registros en la tabla
	 * 
	 * @return Colecci�n de registros
	 * @throws DAOException
	 */
	public Collection<B> getAll() throws DAOException;

	/**
	 * M�todo que permite obtener todos los registros en la tabla
	 * 
	 * @return Colecci�n de registros
	 * @throws DAOException
	 */
	public Collection<B> findByFilter(B filter) throws DAOException;

}
