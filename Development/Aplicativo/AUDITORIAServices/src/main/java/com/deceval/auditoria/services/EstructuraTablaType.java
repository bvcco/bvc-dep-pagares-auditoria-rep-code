
package com.deceval.auditoria.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Estructura de campos que componen la descripcion de una tabla
 * 
 * <p>Clase Java para EstructuraTablaType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="EstructuraTablaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombreTabla" type="{http://deceval.com/auditoria/services/xsd}NombreTablaType" minOccurs="0"/>
 *         &lt;element name="nombreCampo" type="{http://deceval.com/auditoria/services/xsd}NombreCampoType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="valorCampo" type="{http://deceval.com/auditoria/services/xsd}ValorCampoType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EstructuraTablaType", propOrder = {
    "nombreTabla",
    "nombreCampo",
    "valorCampo"
})
public class EstructuraTablaType {

    protected String nombreTabla;
    protected List<String> nombreCampo;
    protected List<String> valorCampo;

    /**
     * Obtiene el valor de la propiedad nombreTabla.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreTabla() {
        return nombreTabla;
    }

    /**
     * Define el valor de la propiedad nombreTabla.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreTabla(String value) {
        this.nombreTabla = value;
    }

    /**
     * Gets the value of the nombreCampo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nombreCampo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNombreCampo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNombreCampo() {
        if (nombreCampo == null) {
            nombreCampo = new ArrayList<String>();
        }
        return this.nombreCampo;
    }

    /**
     * Gets the value of the valorCampo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the valorCampo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValorCampo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getValorCampo() {
        if (valorCampo == null) {
            valorCampo = new ArrayList<String>();
        }
        return this.valorCampo;
    }

}
