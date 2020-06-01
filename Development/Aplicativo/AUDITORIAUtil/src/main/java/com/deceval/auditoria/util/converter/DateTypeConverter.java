/*
 * DateTypeConverter
 * Date 13/08/2008
 * Copyright (c) 2008
 * Company: Deceval S.A
 * All Rights Reserved.
 * This software is the confidential and proprietary information of Deceval S.A.
 */
package com.deceval.auditoria.util.converter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Clase que realiza tareas de conversion entre fechas.
 * 
 * @version 1.0
 * @author Johann Camilo Olarte Díaz.
 */
public class DateTypeConverter {

	/**
	 * Simple Date formatter para formatear fechas de Calendar a numericco
	 */
	private static SimpleDateFormat dateConverter = new SimpleDateFormat(
			"yyyyMMdd");
	
	
	/**
	 * Simple Date formatter para formatear fechas de Calendar a numericco
	 */
	private static SimpleDateFormat hourConverter = new SimpleDateFormat(
			"HH:mm:ss");

	/**
	 * Obtiene una fecha de tipo numerico a partir de un Calendar.
	 * 
	 * @param dateToConvert
	 *            Calendar a convertir.
	 * @return
	 */
	public static BigDecimal getNumberFromDate(Calendar dateToConvert) {
		return new BigDecimal(dateConverter.format(dateToConvert.getTime()));
	}

	/**
	 * Obtiene una fecha de tipo entero a partir de un Calendar.
	 * 
	 * @param dateToConvert
	 *            Calendar a convertir.
	 * @return
	 */
	public static Integer getIntegerFromDate(Calendar dateToConvert) {
		return new Integer(dateConverter.format(dateToConvert.getTime()));
	}
	
	/**
	 * Obtiene una fecha en formato Calendar a partir de un numero.
	 * 
	 * @param numberToConvert
	 *            Numero a convertir en formato yyyyMMdd
	 * @return
	 * @throws ParseException
	 */
	public static Calendar getDateFromNumber(BigDecimal numberToConvert)
			throws ParseException {
		Calendar dateToReturn = Calendar.getInstance();
		dateToReturn.setTime(dateConverter.parse(numberToConvert.toString()));
		return dateToReturn;
	}
	
	/**
	 * Obtiene una fecha en formato Calendar a partir de un numero.
	 * 
	 * @param numberToConvert
	 *            Numero a convertir en formato yyyyMMdd
	 * @return
	 * @throws ParseException
	 */
	public static Calendar getDateFromNumber(Integer numberToConvert)
			throws ParseException {
		Calendar dateToReturn = Calendar.getInstance();
		dateToReturn.setTime(dateConverter.parse(numberToConvert.toString()));
		return dateToReturn;
	}

	/**
	 * Retorna una fecha en formato TimeStamp a partir de un Calendar.
	 * 
	 * @param dateToConvert
	 *            Fecha a convertir
	 * @return
	 * @throws ParseException
	 */
	public static Timestamp getTimestampFromCalendar(Calendar dateToConvert)
			throws ParseException {
		return new Timestamp(dateToConvert.getTimeInMillis());
	}
	
	/**
	 * Retorna una fecha en formato java.sql.TimeStamp SQL TimeStamp a partir de un Calendar.
	 * 
	 * @param dateToConvert
	 *            Fecha a convertir
	 * @return
	 * @throws ParseException
	 */
	public static java.sql.Timestamp getSQLTimestampFromCalendar(Calendar dateToConvert)
			throws ParseException {
		return new java.sql.Timestamp(dateToConvert.getTimeInMillis());
	}

	/**
	 * Obtiene un objeto de tipo Calendar desde un TimeStamp.
	 * 
	 * @param timestampToConvert
	 * @return
	 * @throws ParseException
	 */
	public static Calendar getCalendarFromTimestamp(Timestamp timestampToConvert)
			throws ParseException {
		Calendar dateToReturn = Calendar.getInstance();
		dateToReturn.setTimeInMillis(timestampToConvert.getTime());
		return dateToReturn;
	}
	
	/**
	 * Permite obtener la hora de un Calendar en formato HH:mm:ss.
	 * @param fecha
	 * @return
	 */
	public static String obtenerHoraDeCalendar(Calendar fecha){
		return hourConverter.format(fecha.getTime());
	}
	  
}
