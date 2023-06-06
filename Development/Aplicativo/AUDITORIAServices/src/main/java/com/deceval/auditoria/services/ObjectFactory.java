
package com.deceval.auditoria.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.deceval.auditoria.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _InsertarLogRequest_QNAME = new QName("http://deceval.com/auditoria/services/xsd", "InsertarLogRequest");
    private final static QName _InsertarLogResponse_QNAME = new QName("http://deceval.com/auditoria/services/xsd", "InsertarLogResponse");
    private final static QName _Fault_QNAME = new QName("http://deceval.com/auditoria/services/xsd", "Fault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.deceval.auditoria.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InsertarLogResponseType }
     * 
     */
    public InsertarLogResponseType createInsertarLogResponseType() {
        return new InsertarLogResponseType();
    }

    /**
     * Create an instance of {@link InsertarLogRequestType }
     * 
     */
    public InsertarLogRequestType createInsertarLogRequestType() {
        return new InsertarLogRequestType();
    }

    /**
     * Create an instance of {@link FaultType }
     * 
     */
    public FaultType createFaultType() {
        return new FaultType();
    }

    /**
     * Create an instance of {@link EstructuraTablaType }
     * 
     */
    public EstructuraTablaType createEstructuraTablaType() {
        return new EstructuraTablaType();
    }

    /**
     * Create an instance of {@link ListaEstructurasType }
     * 
     */
    public ListaEstructurasType createListaEstructurasType() {
        return new ListaEstructurasType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarLogRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://deceval.com/auditoria/services/xsd", name = "InsertarLogRequest")
    public JAXBElement<InsertarLogRequestType> createInsertarLogRequest(InsertarLogRequestType value) {
        return new JAXBElement<InsertarLogRequestType>(_InsertarLogRequest_QNAME, InsertarLogRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarLogResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://deceval.com/auditoria/services/xsd", name = "InsertarLogResponse")
    public JAXBElement<InsertarLogResponseType> createInsertarLogResponse(InsertarLogResponseType value) {
        return new JAXBElement<InsertarLogResponseType>(_InsertarLogResponse_QNAME, InsertarLogResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://deceval.com/auditoria/services/xsd", name = "Fault")
    public JAXBElement<FaultType> createFault(FaultType value) {
        return new JAXBElement<FaultType>(_Fault_QNAME, FaultType.class, null, value);
    }

}
