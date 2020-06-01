
package com.deceval.auditoria.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Tipo del elemento de entrada que contiene los datos
 *                                           necesarios para registrar una accion auditable
 * 
 * <p>Clase Java para InsertarLogRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="InsertarLogRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="constanteReferenciaOperacion" type="{http://deceval.com/auditoria/services/xsd}ConstanteReferenciaOperacionType"/>
 *         &lt;element name="constanteReferenciaOrigen" type="{http://deceval.com/auditoria/services/xsd}ConstanteReferenciaOrigenType"/>
 *         &lt;element name="codigoOrigen" type="{http://deceval.com/auditoria/services/xsd}CodigoOrigenType"/>
 *         &lt;element name="idUsuario" type="{http://deceval.com/auditoria/services/xsd}IdUsuarioType"/>
 *         &lt;element name="userName" type="{http://deceval.com/auditoria/services/xsd}UserNameType"/>
 *         &lt;element name="ipUsuario" type="{http://deceval.com/auditoria/services/xsd}IpUsuarioType"/>
 *         &lt;element name="ipServidor" type="{http://deceval.com/auditoria/services/xsd}IpServidorType"/>
 *         &lt;element name="descripcionAnotacion" type="{http://deceval.com/auditoria/services/xsd}DescripcionAnotacionType"/>
 *         &lt;element name="listaEstructuras" type="{http://deceval.com/auditoria/services/xsd}ListaEstructurasType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsertarLogRequestType", propOrder = {
    "constanteReferenciaOperacion",
    "constanteReferenciaOrigen",
    "codigoOrigen",
    "idUsuario",
    "userName",
    "ipUsuario",
    "ipServidor",
    "descripcionAnotacion",
    "listaEstructuras"
})
public class InsertarLogRequestType {

    @XmlElement(required = true)
    protected String constanteReferenciaOperacion;
    @XmlElement(required = true)
    protected String constanteReferenciaOrigen;
    @XmlElement(required = true)
    protected String codigoOrigen;
    protected int idUsuario;
    @XmlElement(required = true)
    protected String userName;
    @XmlElement(required = true)
    protected String ipUsuario;
    @XmlElement(required = true)
    protected String ipServidor;
    @XmlElement(required = true)
    protected String descripcionAnotacion;
    @XmlElement(required = true, nillable = true)
    protected ListaEstructurasType listaEstructuras;

    /**
     * Obtiene el valor de la propiedad constanteReferenciaOperacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConstanteReferenciaOperacion() {
        return constanteReferenciaOperacion;
    }

    /**
     * Define el valor de la propiedad constanteReferenciaOperacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConstanteReferenciaOperacion(String value) {
        this.constanteReferenciaOperacion = value;
    }

    /**
     * Obtiene el valor de la propiedad constanteReferenciaOrigen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConstanteReferenciaOrigen() {
        return constanteReferenciaOrigen;
    }

    /**
     * Define el valor de la propiedad constanteReferenciaOrigen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConstanteReferenciaOrigen(String value) {
        this.constanteReferenciaOrigen = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoOrigen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoOrigen() {
        return codigoOrigen;
    }

    /**
     * Define el valor de la propiedad codigoOrigen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoOrigen(String value) {
        this.codigoOrigen = value;
    }

    /**
     * Obtiene el valor de la propiedad idUsuario.
     * 
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Define el valor de la propiedad idUsuario.
     * 
     */
    public void setIdUsuario(int value) {
        this.idUsuario = value;
    }

    /**
     * Obtiene el valor de la propiedad userName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Define el valor de la propiedad userName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Obtiene el valor de la propiedad ipUsuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpUsuario() {
        return ipUsuario;
    }

    /**
     * Define el valor de la propiedad ipUsuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpUsuario(String value) {
        this.ipUsuario = value;
    }

    /**
     * Obtiene el valor de la propiedad ipServidor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpServidor() {
        return ipServidor;
    }

    /**
     * Define el valor de la propiedad ipServidor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpServidor(String value) {
        this.ipServidor = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcionAnotacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionAnotacion() {
        return descripcionAnotacion;
    }

    /**
     * Define el valor de la propiedad descripcionAnotacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionAnotacion(String value) {
        this.descripcionAnotacion = value;
    }

    /**
     * Obtiene el valor de la propiedad listaEstructuras.
     * 
     * @return
     *     possible object is
     *     {@link ListaEstructurasType }
     *     
     */
    public ListaEstructurasType getListaEstructuras() {
        return listaEstructuras;
    }

    /**
     * Define el valor de la propiedad listaEstructuras.
     * 
     * @param value
     *     allowed object is
     *     {@link ListaEstructurasType }
     *     
     */
    public void setListaEstructuras(ListaEstructurasType value) {
        this.listaEstructuras = value;
    }

}
