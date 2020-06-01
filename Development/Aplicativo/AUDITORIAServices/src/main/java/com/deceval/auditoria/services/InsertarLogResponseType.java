
package com.deceval.auditoria.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Tipo del elemento de salida contiene los datos de respuesta de una registro de log
 * 
 * <p>Clase Java para InsertarLogResponseType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="InsertarLogResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="resultadoCreacion" type="{http://deceval.com/auditoria/services/xsd}ResultadoCreacionType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsertarLogResponseType", propOrder = {
    "resultadoCreacion"
})
public class InsertarLogResponseType {

    @XmlElement(required = true)
    protected String resultadoCreacion;

    /**
     * Obtiene el valor de la propiedad resultadoCreacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultadoCreacion() {
        return resultadoCreacion;
    }

    /**
     * Define el valor de la propiedad resultadoCreacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultadoCreacion(String value) {
        this.resultadoCreacion = value;
    }

}
