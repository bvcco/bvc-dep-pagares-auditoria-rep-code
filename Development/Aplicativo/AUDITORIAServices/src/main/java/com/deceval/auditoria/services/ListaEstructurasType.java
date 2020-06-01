
package com.deceval.auditoria.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Lista que contiene x numero de estructuras de tablas
 * 
 * <p>Clase Java para ListaEstructurasType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ListaEstructurasType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="estructuraTabla" type="{http://deceval.com/auditoria/services/xsd}EstructuraTablaType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListaEstructurasType", propOrder = {
    "estructuraTabla"
})
public class ListaEstructurasType {

    protected List<EstructuraTablaType> estructuraTabla;

    /**
     * Gets the value of the estructuraTabla property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the estructuraTabla property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEstructuraTabla().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EstructuraTablaType }
     * 
     * 
     */
    public List<EstructuraTablaType> getEstructuraTabla() {
        if (estructuraTabla == null) {
            estructuraTabla = new ArrayList<EstructuraTablaType>();
        }
        return this.estructuraTabla;
    }

}
