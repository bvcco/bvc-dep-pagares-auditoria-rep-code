package com.deceval.auditoria.util.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Clase que contiene métodos de utilidad con fechas.
 * @version 1.0
 * @author ELTV
 */
public class DateUtil {

	/**
	 * Método que retorna la fecha del sistema
	 * @return La fecha del sistema java.util.Date
	 * @author Fredy Fonseca
	 */
	public static Date getFechaSistemaDate() {
	    Date currentTime = new Date();
	    return currentTime;
	}
	
	/**
	 * Método que retorna la fecha del sistema
	 * @return La fecha del sistema java.util.Calendar
	 * @author Fredy Fonseca
	 */
	public static Calendar getFechaSistemaCalendar() {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(getFechaSistemaDate());
	    return cal;
	}

	/**
	 * Método que retorna la fecha dada con las horas, minutos, segundos y milisegundos en su valor inicial
	 * @return La fecha dada con las horas, minutos, segundos y milisegundos en su valor inicial
	 * @param calendar
	 * @author ELTV
	 */	
	public static Calendar getFechaInicialHMS(Calendar calendar) {
	  calendar.set(Calendar.HOUR_OF_DAY, 0);
	  calendar.set(Calendar.MINUTE, 0);
	  calendar.set(Calendar.SECOND, 0);
	  calendar.set(Calendar.MILLISECOND, 0);
	  return calendar;
	}	
	
	/**
	 * Recibe el objeto Date y lo asigna a un objeto Calendar para llamar al método getFechaFinalHMS(Calendar calendar)
	 * @return 
	 * @param fecha
	 * @author Fredy Fonseca
	 */
	public static Calendar getFechaInicialHMS(Date fecha) {
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(fecha);
	    return getFechaInicialHMS(calendar);
	}
	
	
	/**
	 * Método que retorna la fecha dada con las horas, minutos, segundos y milisegundos en su valor final
	 * @return La fecha dada con las horas, minutos, segundos y milisegundos en su valor final
	 * @param calendar
	 * @author ELTV
	 */	
	public static Calendar getFechaFinalHMS(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar;
	}	
	
	/**
	 * Recibe el objeto Date y lo asigna a un objeto Calendar para llamar al método getFechaFinalHMS(Calendar calendar)
	 * @return 
	 * @param fecha
	 * @author Fredy Fonseca
	 */
	public static Calendar getFechaFinalHMS(Date fecha) {
		Calendar calendar = Calendar.getInstance();
	  calendar.setTime(fecha);
	  return getFechaFinalHMS(calendar);
	}

	/**
	 * Devuelve en string la fecha pasada con el formato especificado
	 * @param fecha
	 * @param formato
	 * @return String
	 * @author ffonsacos
	 */
	public static String getStringFromCalendar(Calendar fecha, String formato){
		return DateUtil.getStringFromDate(fecha.getTime(),formato);
	}

	/**
	 * Devuelve en string la fecha pasada con el formato especificado
	 * @param fecha
	 * @param formato
	 * @return String
	 * @author ffonsacos
	 */
	public static String getStringFromDate(Date fecha, String formato){
		SimpleDateFormat format = new SimpleDateFormat(formato);
		return format.format(fecha);
	}
	
}
