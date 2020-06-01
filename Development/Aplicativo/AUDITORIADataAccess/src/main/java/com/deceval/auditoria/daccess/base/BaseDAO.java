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
 * Interfaz que define las firmas de los metodos básicos para los DAOs(insert,
 * delete, update, findByPrimaryKey, findByFilter, getAll)
 * 
 * @version 1.0
 * @author Johann Camilo Olarte Díaz.
 */
public interface BaseDAO<B extends BaseDataVO> {

	/**
	 * Método que permite crear un registro en una base de datos
	 * 
	 * @param data
	 *            Objeto con la información del registro que se va a crear
	 * @return Objeto con la información actualizada del registro creado
	 * @throws DAOException
	 *             En caso de que exista algún problema con la conexión o el
	 *             script de creación
	 */
	public B insert(B data) throws DAOException;

	/**
	 * Método encargado de eliminar un registro de una base de datos
	 * 
	 * @param llave
	 *            Llave del registro a eliminar
	 * @throws DAOException
	 */
	public void delete(B llave) throws DAOException;

	/**
	 * Método que permite obtener un registro de acuerdo a su llave primaria
	 * 
	 * @param llave
	 *            Objeto llave primaria
	 * @return Objeto con la información del registro encontrado
	 * @throws DAOException
	 */
	public B findByPrimaryKey(B llave) throws DAOException;

	/**
	 * Método que permite actualizar un registro en una base de datos
	 * 
	 * @param data
	 *            Objeto con la información de actualización del registro
	 * @return Objeto con la información despues de la actualización
	 * @throws DAOException
	 */
	public B update(B data, String[] updateFields) throws DAOException;

	/**
	 * Método que permite obtener todos los registros en la tabla
	 * 
	 * @return Colección de registros
	 * @throws DAOException
	 */
	public Collection<B> getAll() throws DAOException;

	/**
	 * Método que permite obtener todos los registros en la tabla
	 * 
	 * @return Colección de registros
	 * @throws DAOException
	 */
	public Collection<B> findByFilter(B filter) throws DAOException;

}
