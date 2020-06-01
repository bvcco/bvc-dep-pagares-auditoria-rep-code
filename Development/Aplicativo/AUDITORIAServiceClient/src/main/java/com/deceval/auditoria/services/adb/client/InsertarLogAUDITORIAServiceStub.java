/**
 * InsertarLogAUDITORIAServiceStub.java
 *
 * This file was auto-generated from WSDL by the Apache Axis2 version: 1.4 Built
 * on : Apr 26, 2008 (06:24:30 EDT)
 */
package com.deceval.auditoria.services.adb.client;

/*
 *  InsertarLogAUDITORIAServiceStub java implementation
 */
public class InsertarLogAUDITORIAServiceStub extends org.apache.axis2.client.Stub {

    protected org.apache.axis2.description.AxisOperation[] _operations;

    //hashmaps to keep the fault mapping
    private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
    private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
    private java.util.HashMap faultMessageMap = new java.util.HashMap();

    private static int counter = 0;

    private static synchronized String getUniqueSuffix() {
        // reset the counter if it is greater than 99999
        if (counter > 99999) {
            counter = 0;
        }
        counter = counter + 1;
        return Long.toString(System.currentTimeMillis()) + "_" + counter;
    }

    private void populateAxisService() throws org.apache.axis2.AxisFault {

        //creating the Service with a unique name
        _service = new org.apache.axis2.description.AxisService("InsertarLogAUDITORIAService" + getUniqueSuffix());
        addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[1];

        __operation = new org.apache.axis2.description.OutInAxisOperation();

        __operation.setName(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/", "insertarLog"));
        _service.addOperation(__operation);

        _operations[0] = __operation;

    }

    //populates the faults
    private void populateFaults() {

        faultExceptionNameMap.put(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "Fault"), "com.deceval.auditoria.services.adb.client.FaultMsg");
        faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "Fault"), "com.deceval.auditoria.services.adb.client.FaultMsg");
        faultMessageMap.put(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "Fault"), "com.deceval.auditoria.services.adb.client.InsertarLogAUDITORIAServiceStub$Fault");

    }

    /**
     * Constructor that takes in a configContext
     */
    public InsertarLogAUDITORIAServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
            java.lang.String targetEndpoint)
            throws org.apache.axis2.AxisFault {
        this(configurationContext, targetEndpoint, false);
    }

    /**
     * Constructor that takes in a configContext and useseperate listner
     */
    public InsertarLogAUDITORIAServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
            java.lang.String targetEndpoint, boolean useSeparateListener)
            throws org.apache.axis2.AxisFault {
        //To populate AxisService
        populateAxisService();
        populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext, _service);

        configurationContext = _serviceClient.getServiceContext().getConfigurationContext();

        _serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(
                targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);

    }

    /**
     * Default Constructor
     */
    public InsertarLogAUDITORIAServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {

        this(configurationContext, "http://localhost:7050/auditoriaservices/services/insertarLogAUDITORIAService");

    }

    /**
     * Default Constructor
     */
    public InsertarLogAUDITORIAServiceStub() throws org.apache.axis2.AxisFault {

        this("http://localhost:7050/auditoriaservices/services/insertarLogAUDITORIAService");

    }

    /**
     * Constructor taking the target endpoint
     */
    public InsertarLogAUDITORIAServiceStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null, targetEndpoint);
    }

    /**
     * Auto generated method signature
     *
     * @see
     * com.deceval.auditoria.services.adb.client.InsertarLogAUDITORIAService#insertarLog
     * @param insertarLogRequest
     *
     * @throws com.deceval.auditoria.services.adb.client.FaultMsg :
     */
    public com.deceval.auditoria.services.adb.client.InsertarLogAUDITORIAServiceStub.InsertarLogResponse insertarLog(
            com.deceval.auditoria.services.adb.client.InsertarLogAUDITORIAServiceStub.InsertarLogRequest insertarLogRequest)
            throws java.rmi.RemoteException, com.deceval.auditoria.services.adb.client.FaultMsg {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
            _operationClient.getOptions().setAction("insertarLog");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");

            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();

            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                    insertarLogRequest,
                    optimizeContent(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/",
                                    "insertarLog")));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);

            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                    org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            java.lang.Object object = fromOM(
                    _returnEnv.getBody().getFirstElement(),
                    com.deceval.auditoria.services.adb.client.InsertarLogAUDITORIAServiceStub.InsertarLogResponse.class,
                    getEnvelopeNamespaces(_returnEnv));

            return (com.deceval.auditoria.services.adb.client.InsertarLogAUDITORIAServiceStub.InsertarLogResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(faultElt.getQName())) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex
                                = (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new java.lang.Class[]{messageClass});
                        m.invoke(ex, new java.lang.Object[]{messageObject});

                        if (ex instanceof com.deceval.auditoria.services.adb.client.FaultMsg) {
                            throw (com.deceval.auditoria.services.adb.client.FaultMsg) ex;
                        }

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }
    }

    /**
     * A utility method that copies the namepaces from the SOAPEnvelope
     */
    private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env) {
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
            org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
            returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
        }
        return returnMap;
    }

    private javax.xml.namespace.QName[] opNameArray = null;

    private boolean optimizeContent(javax.xml.namespace.QName opName) {

        if (opNameArray == null) {
            return false;
        }
        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;
            }
        }
        return false;
    }

    //http://localhost:7011/auditoriaservices/services/insertarLogAUDITORIAService
    public static class ConstanteReferenciaOrigenType
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://deceval.com/auditoria/services/xsd",
                "ConstanteReferenciaOrigenType",
                "ns1");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://deceval.com/auditoria/services/xsd")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * field for ConstanteReferenciaOrigenType
         */
        protected java.lang.String localConstanteReferenciaOrigenType;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getConstanteReferenciaOrigenType() {
            return localConstanteReferenciaOrigenType;
        }

        /**
         * Auto generated setter method
         *
         * @param param ConstanteReferenciaOrigenType
         */
        public void setConstanteReferenciaOrigenType(java.lang.String param) {

            if ((0 <= java.lang.String.valueOf(param).length()) && (java.lang.String.valueOf(param).length() <= 150)) {
                this.localConstanteReferenciaOrigenType = param;
            } else {
                throw new java.lang.RuntimeException();
            }

        }

        public java.lang.String toString() {

            return localConstanteReferenciaOrigenType.toString();

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource
                    = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

                        public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                            ConstanteReferenciaOrigenType.this.serialize(MY_QNAME, factory, xmlWriter);
                        }
                    };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String localName = parentQName.getLocalPart();

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://deceval.com/auditoria/services/xsd");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":ConstanteReferenciaOrigenType",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "ConstanteReferenciaOrigenType",
                            xmlWriter);
                }
            }

            if (localConstanteReferenciaOrigenType == null) {

                throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");

            } else {

                xmlWriter.writeCharacters(localConstanteReferenciaOrigenType);

            }

            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                    new java.lang.Object[]{
                        org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localConstanteReferenciaOrigenType)
                    },
                    null);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            public static ConstanteReferenciaOrigenType fromString(java.lang.String value,
                    java.lang.String namespaceURI) {
                ConstanteReferenciaOrigenType returnValue = new ConstanteReferenciaOrigenType();

                returnValue.setConstanteReferenciaOrigenType(
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));

                return returnValue;
            }

            public static ConstanteReferenciaOrigenType fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                    java.lang.String content) {
                if (content.indexOf(":") > -1) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                    return ConstanteReferenciaOrigenType.Factory.fromString(content, namespaceUri);
                } else {
                    return ConstanteReferenciaOrigenType.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static ConstanteReferenciaOrigenType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                ConstanteReferenciaOrigenType object
                        = new ConstanteReferenciaOrigenType();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {

                            if (reader.isStartElement() || reader.hasText()) {

                                java.lang.String content = reader.getElementText();

                                object.setConstanteReferenciaOrigenType(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class CodigoOrigenType
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://deceval.com/auditoria/services/xsd",
                "CodigoOrigenType",
                "ns1");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://deceval.com/auditoria/services/xsd")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * field for CodigoOrigenType
         */
        protected java.lang.String localCodigoOrigenType;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getCodigoOrigenType() {
            return localCodigoOrigenType;
        }

        /**
         * Auto generated setter method
         *
         * @param param CodigoOrigenType
         */
        public void setCodigoOrigenType(java.lang.String param) {

            if ((0 <= java.lang.String.valueOf(param).length()) && (java.lang.String.valueOf(param).length() <= 20)) {
                this.localCodigoOrigenType = param;
            } else {
                throw new java.lang.RuntimeException();
            }

        }

        public java.lang.String toString() {

            return localCodigoOrigenType.toString();

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource
                    = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

                        public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                            CodigoOrigenType.this.serialize(MY_QNAME, factory, xmlWriter);
                        }
                    };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String localName = parentQName.getLocalPart();

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://deceval.com/auditoria/services/xsd");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":CodigoOrigenType",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "CodigoOrigenType",
                            xmlWriter);
                }
            }

            if (localCodigoOrigenType == null) {

                throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");

            } else {

                xmlWriter.writeCharacters(localCodigoOrigenType);

            }

            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                    new java.lang.Object[]{
                        org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCodigoOrigenType)
                    },
                    null);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            public static CodigoOrigenType fromString(java.lang.String value,
                    java.lang.String namespaceURI) {
                CodigoOrigenType returnValue = new CodigoOrigenType();

                returnValue.setCodigoOrigenType(
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));

                return returnValue;
            }

            public static CodigoOrigenType fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                    java.lang.String content) {
                if (content.indexOf(":") > -1) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                    return CodigoOrigenType.Factory.fromString(content, namespaceUri);
                } else {
                    return CodigoOrigenType.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static CodigoOrigenType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                CodigoOrigenType object
                        = new CodigoOrigenType();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {

                            if (reader.isStartElement() || reader.hasText()) {

                                java.lang.String content = reader.getElementText();

                                object.setCodigoOrigenType(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class ResultadoCreacionType
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://deceval.com/auditoria/services/xsd",
                "ResultadoCreacionType",
                "ns1");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://deceval.com/auditoria/services/xsd")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * field for ResultadoCreacionType
         */
        protected java.lang.String localResultadoCreacionType;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getResultadoCreacionType() {
            return localResultadoCreacionType;
        }

        /**
         * Auto generated setter method
         *
         * @param param ResultadoCreacionType
         */
        public void setResultadoCreacionType(java.lang.String param) {

            if ((0 <= java.lang.String.valueOf(param).length()) && (java.lang.String.valueOf(param).length() <= 255)) {
                this.localResultadoCreacionType = param;
            } else {
                throw new java.lang.RuntimeException();
            }

        }

        public java.lang.String toString() {

            return localResultadoCreacionType.toString();

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource
                    = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

                        public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                            ResultadoCreacionType.this.serialize(MY_QNAME, factory, xmlWriter);
                        }
                    };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String localName = parentQName.getLocalPart();

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://deceval.com/auditoria/services/xsd");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":ResultadoCreacionType",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "ResultadoCreacionType",
                            xmlWriter);
                }
            }

            if (localResultadoCreacionType == null) {

                throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");

            } else {

                xmlWriter.writeCharacters(localResultadoCreacionType);

            }

            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                    new java.lang.Object[]{
                        org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localResultadoCreacionType)
                    },
                    null);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            public static ResultadoCreacionType fromString(java.lang.String value,
                    java.lang.String namespaceURI) {
                ResultadoCreacionType returnValue = new ResultadoCreacionType();

                returnValue.setResultadoCreacionType(
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));

                return returnValue;
            }

            public static ResultadoCreacionType fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                    java.lang.String content) {
                if (content.indexOf(":") > -1) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                    return ResultadoCreacionType.Factory.fromString(content, namespaceUri);
                } else {
                    return ResultadoCreacionType.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static ResultadoCreacionType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                ResultadoCreacionType object
                        = new ResultadoCreacionType();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {

                            if (reader.isStartElement() || reader.hasText()) {

                                java.lang.String content = reader.getElementText();

                                object.setResultadoCreacionType(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class ConstanteReferenciaOperacionType
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://deceval.com/auditoria/services/xsd",
                "ConstanteReferenciaOperacionType",
                "ns1");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://deceval.com/auditoria/services/xsd")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * field for ConstanteReferenciaOperacionType
         */
        protected java.lang.String localConstanteReferenciaOperacionType;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getConstanteReferenciaOperacionType() {
            return localConstanteReferenciaOperacionType;
        }

        /**
         * Auto generated setter method
         *
         * @param param ConstanteReferenciaOperacionType
         */
        public void setConstanteReferenciaOperacionType(java.lang.String param) {

            if ((0 <= java.lang.String.valueOf(param).length()) && (java.lang.String.valueOf(param).length() <= 150)) {
                this.localConstanteReferenciaOperacionType = param;
            } else {
                throw new java.lang.RuntimeException();
            }

        }

        public java.lang.String toString() {

            return localConstanteReferenciaOperacionType.toString();

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource
                    = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

                        public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                            ConstanteReferenciaOperacionType.this.serialize(MY_QNAME, factory, xmlWriter);
                        }
                    };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String localName = parentQName.getLocalPart();

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://deceval.com/auditoria/services/xsd");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":ConstanteReferenciaOperacionType",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "ConstanteReferenciaOperacionType",
                            xmlWriter);
                }
            }

            if (localConstanteReferenciaOperacionType == null) {

                throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");

            } else {

                xmlWriter.writeCharacters(localConstanteReferenciaOperacionType);

            }

            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                    new java.lang.Object[]{
                        org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localConstanteReferenciaOperacionType)
                    },
                    null);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            public static ConstanteReferenciaOperacionType fromString(java.lang.String value,
                    java.lang.String namespaceURI) {
                ConstanteReferenciaOperacionType returnValue = new ConstanteReferenciaOperacionType();

                returnValue.setConstanteReferenciaOperacionType(
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));

                return returnValue;
            }

            public static ConstanteReferenciaOperacionType fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                    java.lang.String content) {
                if (content.indexOf(":") > -1) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                    return ConstanteReferenciaOperacionType.Factory.fromString(content, namespaceUri);
                } else {
                    return ConstanteReferenciaOperacionType.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static ConstanteReferenciaOperacionType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                ConstanteReferenciaOperacionType object
                        = new ConstanteReferenciaOperacionType();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {

                            if (reader.isStartElement() || reader.hasText()) {

                                java.lang.String content = reader.getElementText();

                                object.setConstanteReferenciaOperacionType(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class ValorCampoType
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://deceval.com/auditoria/services/xsd",
                "ValorCampoType",
                "ns1");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://deceval.com/auditoria/services/xsd")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * field for ValorCampoType
         */
        protected java.lang.String localValorCampoType;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getValorCampoType() {
            return localValorCampoType;
        }

        /**
         * Auto generated setter method
         *
         * @param param ValorCampoType
         */
        public void setValorCampoType(java.lang.String param) {

            if ((0 <= java.lang.String.valueOf(param).length()) && (java.lang.String.valueOf(param).length() <= 255)) {
                this.localValorCampoType = param;
            } else {
                throw new java.lang.RuntimeException();
            }

        }

        public java.lang.String toString() {

            return localValorCampoType.toString();

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource
                    = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

                        public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                            ValorCampoType.this.serialize(MY_QNAME, factory, xmlWriter);
                        }
                    };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String localName = parentQName.getLocalPart();

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://deceval.com/auditoria/services/xsd");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":ValorCampoType",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "ValorCampoType",
                            xmlWriter);
                }
            }

            if (localValorCampoType == null) {

                throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");

            } else {

                xmlWriter.writeCharacters(localValorCampoType);

            }

            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                    new java.lang.Object[]{
                        org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localValorCampoType)
                    },
                    null);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            public static ValorCampoType fromString(java.lang.String value,
                    java.lang.String namespaceURI) {
                ValorCampoType returnValue = new ValorCampoType();

                returnValue.setValorCampoType(
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));

                return returnValue;
            }

            public static ValorCampoType fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                    java.lang.String content) {
                if (content.indexOf(":") > -1) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                    return ValorCampoType.Factory.fromString(content, namespaceUri);
                } else {
                    return ValorCampoType.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static ValorCampoType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                ValorCampoType object
                        = new ValorCampoType();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {

                            if (reader.isStartElement() || reader.hasText()) {

                                java.lang.String content = reader.getElementText();

                                object.setValorCampoType(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class InsertarLogResponse
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://deceval.com/auditoria/services/xsd",
                "InsertarLogResponse",
                "ns1");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://deceval.com/auditoria/services/xsd")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * field for InsertarLogResponse
         */
        protected InsertarLogResponseType localInsertarLogResponse;

        /**
         * Auto generated getter method
         *
         * @return InsertarLogResponseType
         */
        public InsertarLogResponseType getInsertarLogResponse() {
            return localInsertarLogResponse;
        }

        /**
         * Auto generated setter method
         *
         * @param param InsertarLogResponse
         */
        public void setInsertarLogResponse(InsertarLogResponseType param) {

            this.localInsertarLogResponse = param;

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource
                    = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

                        public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                            InsertarLogResponse.this.serialize(MY_QNAME, factory, xmlWriter);
                        }
                    };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            if (localInsertarLogResponse == null) {
                throw new org.apache.axis2.databinding.ADBException("Property cannot be null!");
            }
            localInsertarLogResponse.serialize(MY_QNAME, factory, xmlWriter);

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return localInsertarLogResponse.getPullParser(MY_QNAME);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static InsertarLogResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                InsertarLogResponse object
                        = new InsertarLogResponse();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "InsertarLogResponse").equals(reader.getName())) {

                                object.setInsertarLogResponse(InsertarLogResponseType.Factory.parse(reader));

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class InsertarLogRequest
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://deceval.com/auditoria/services/xsd",
                "InsertarLogRequest",
                "ns1");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://deceval.com/auditoria/services/xsd")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * field for InsertarLogRequest
         */
        protected InsertarLogRequestType localInsertarLogRequest;

        /**
         * Auto generated getter method
         *
         * @return InsertarLogRequestType
         */
        public InsertarLogRequestType getInsertarLogRequest() {
            return localInsertarLogRequest;
        }

        /**
         * Auto generated setter method
         *
         * @param param InsertarLogRequest
         */
        public void setInsertarLogRequest(InsertarLogRequestType param) {

            this.localInsertarLogRequest = param;

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource
                    = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

                        public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                            InsertarLogRequest.this.serialize(MY_QNAME, factory, xmlWriter);
                        }
                    };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            if (localInsertarLogRequest == null) {
                throw new org.apache.axis2.databinding.ADBException("Property cannot be null!");
            }
            localInsertarLogRequest.serialize(MY_QNAME, factory, xmlWriter);

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return localInsertarLogRequest.getPullParser(MY_QNAME);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static InsertarLogRequest parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                InsertarLogRequest object
                        = new InsertarLogRequest();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "InsertarLogRequest").equals(reader.getName())) {

                                object.setInsertarLogRequest(InsertarLogRequestType.Factory.parse(reader));

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class ListaEstructurasType
            implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
         name = ListaEstructurasType
         Namespace URI = http://deceval.com/auditoria/services/xsd
         Namespace Prefix = ns1
         */

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://deceval.com/auditoria/services/xsd")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * field for EstructuraTabla This was an Array!
         */
        protected EstructuraTablaType[] localEstructuraTabla;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localEstructuraTablaTracker = false;

        /**
         * Auto generated getter method
         *
         * @return EstructuraTablaType[]
         */
        public EstructuraTablaType[] getEstructuraTabla() {
            return localEstructuraTabla;
        }

        /**
         * validate the array for EstructuraTabla
         */
        protected void validateEstructuraTabla(EstructuraTablaType[] param) {

        }

        /**
         * Auto generated setter method
         *
         * @param param EstructuraTabla
         */
        public void setEstructuraTabla(EstructuraTablaType[] param) {

            validateEstructuraTabla(param);

            if (param != null) {
                //update the setting tracker
                localEstructuraTablaTracker = true;
            } else {
                localEstructuraTablaTracker = false;

            }

            this.localEstructuraTabla = param;
        }

        /**
         * Auto generated add method for the array for convenience
         *
         * @param param EstructuraTablaType
         */
        public void addEstructuraTabla(EstructuraTablaType param) {
            if (localEstructuraTabla == null) {
                localEstructuraTabla = new EstructuraTablaType[]{};
            }

            //update the setting tracker
            localEstructuraTablaTracker = true;

            java.util.List list
                    = org.apache.axis2.databinding.utils.ConverterUtil.toList(localEstructuraTabla);
            list.add(param);
            this.localEstructuraTabla
                    = (EstructuraTablaType[]) list.toArray(
                            new EstructuraTablaType[list.size()]);

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource
                    = new org.apache.axis2.databinding.ADBDataSource(this, parentQName) {

                        public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                            ListaEstructurasType.this.serialize(parentQName, factory, xmlWriter);
                        }
                    };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    parentQName, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://deceval.com/auditoria/services/xsd");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":ListaEstructurasType",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "ListaEstructurasType",
                            xmlWriter);
                }

            }
            if (localEstructuraTablaTracker) {
                if (localEstructuraTabla != null) {
                    for (int i = 0; i < localEstructuraTabla.length; i++) {
                        if (localEstructuraTabla[i] != null) {
                            localEstructuraTabla[i].serialize(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "estructuraTabla"),
                                    factory, xmlWriter);
                        } else {

                            // we don't have to do any thing since minOccures is zero
                        }

                    }
                } else {

                    throw new org.apache.axis2.databinding.ADBException("estructuraTabla cannot be null!!");

                }
            }
            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if (localEstructuraTablaTracker) {
                if (localEstructuraTabla != null) {
                    for (int i = 0; i < localEstructuraTabla.length; i++) {

                        if (localEstructuraTabla[i] != null) {
                            elementList.add(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd",
                                    "estructuraTabla"));
                            elementList.add(localEstructuraTabla[i]);
                        } else {

                            // nothing to do
                        }

                    }
                } else {

                    throw new org.apache.axis2.databinding.ADBException("estructuraTabla cannot be null!!");

                }

            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static ListaEstructurasType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                ListaEstructurasType object
                        = new ListaEstructurasType();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"ListaEstructurasType".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ListaEstructurasType) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    java.util.ArrayList list1 = new java.util.ArrayList();

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "estructuraTabla").equals(reader.getName())) {

                        // Process the array and step past its final element's end.
                        list1.add(EstructuraTablaType.Factory.parse(reader));

                        //loop until we find a start element that is not part of this array
                        boolean loopDone1 = false;
                        while (!loopDone1) {
                            // We should be at the end element, but make sure
                            while (!reader.isEndElement()) {
                                reader.next();
                            }
                            // Step out of this element
                            reader.next();
                            // Step to next element event.
                            while (!reader.isStartElement() && !reader.isEndElement()) {
                                reader.next();
                            }
                            if (reader.isEndElement()) {
                                //two continuous end elements means we are exiting the xml structure
                                loopDone1 = true;
                            } else {
                                if (new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "estructuraTabla").equals(reader.getName())) {
                                    list1.add(EstructuraTablaType.Factory.parse(reader));

                                } else {
                                    loopDone1 = true;
                                }
                            }
                        }
                        // call the converter utility  to convert and set the array

                        object.setEstructuraTabla((EstructuraTablaType[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                EstructuraTablaType.class,
                                list1));

                    } // End of if for expected property start element
                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement()) // A start element we are not expecting indicates a trailing invalid property
                    {
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                    }

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class NombreCampoType
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://deceval.com/auditoria/services/xsd",
                "NombreCampoType",
                "ns1");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://deceval.com/auditoria/services/xsd")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * field for NombreCampoType
         */
        protected java.lang.String localNombreCampoType;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getNombreCampoType() {
            return localNombreCampoType;
        }

        /**
         * Auto generated setter method
         *
         * @param param NombreCampoType
         */
        public void setNombreCampoType(java.lang.String param) {

            if ((0 <= java.lang.String.valueOf(param).length()) && (java.lang.String.valueOf(param).length() <= 50)) {
                this.localNombreCampoType = param;
            } else {
                throw new java.lang.RuntimeException();
            }

        }

        public java.lang.String toString() {

            return localNombreCampoType.toString();

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource
                    = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

                        public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                            NombreCampoType.this.serialize(MY_QNAME, factory, xmlWriter);
                        }
                    };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String localName = parentQName.getLocalPart();

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://deceval.com/auditoria/services/xsd");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":NombreCampoType",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "NombreCampoType",
                            xmlWriter);
                }
            }

            if (localNombreCampoType == null) {

                throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");

            } else {

                xmlWriter.writeCharacters(localNombreCampoType);

            }

            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                    new java.lang.Object[]{
                        org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNombreCampoType)
                    },
                    null);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            public static NombreCampoType fromString(java.lang.String value,
                    java.lang.String namespaceURI) {
                NombreCampoType returnValue = new NombreCampoType();

                returnValue.setNombreCampoType(
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));

                return returnValue;
            }

            public static NombreCampoType fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                    java.lang.String content) {
                if (content.indexOf(":") > -1) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                    return NombreCampoType.Factory.fromString(content, namespaceUri);
                } else {
                    return NombreCampoType.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static NombreCampoType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                NombreCampoType object
                        = new NombreCampoType();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {

                            if (reader.isStartElement() || reader.hasText()) {

                                java.lang.String content = reader.getElementText();

                                object.setNombreCampoType(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class InsertarLogRequestType
            implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
         name = InsertarLogRequestType
         Namespace URI = http://deceval.com/auditoria/services/xsd
         Namespace Prefix = ns1
         */

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://deceval.com/auditoria/services/xsd")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * field for ConstanteReferenciaOperacion
         */
        protected ConstanteReferenciaOperacionType localConstanteReferenciaOperacion;

        /**
         * Auto generated getter method
         *
         * @return ConstanteReferenciaOperacionType
         */
        public ConstanteReferenciaOperacionType getConstanteReferenciaOperacion() {
            return localConstanteReferenciaOperacion;
        }

        /**
         * Auto generated setter method
         *
         * @param param ConstanteReferenciaOperacion
         */
        public void setConstanteReferenciaOperacion(ConstanteReferenciaOperacionType param) {

            this.localConstanteReferenciaOperacion = param;

        }

        /**
         * field for ConstanteReferenciaOrigen
         */
        protected ConstanteReferenciaOrigenType localConstanteReferenciaOrigen;

        /**
         * Auto generated getter method
         *
         * @return ConstanteReferenciaOrigenType
         */
        public ConstanteReferenciaOrigenType getConstanteReferenciaOrigen() {
            return localConstanteReferenciaOrigen;
        }

        /**
         * Auto generated setter method
         *
         * @param param ConstanteReferenciaOrigen
         */
        public void setConstanteReferenciaOrigen(ConstanteReferenciaOrigenType param) {

            this.localConstanteReferenciaOrigen = param;

        }

        /**
         * field for CodigoOrigen
         */
        protected CodigoOrigenType localCodigoOrigen;

        /**
         * Auto generated getter method
         *
         * @return CodigoOrigenType
         */
        public CodigoOrigenType getCodigoOrigen() {
            return localCodigoOrigen;
        }

        /**
         * Auto generated setter method
         *
         * @param param CodigoOrigen
         */
        public void setCodigoOrigen(CodigoOrigenType param) {

            this.localCodigoOrigen = param;

        }

        /**
         * field for IdUsuario
         */
        protected IdUsuarioType localIdUsuario;

        /**
         * Auto generated getter method
         *
         * @return IdUsuarioType
         */
        public IdUsuarioType getIdUsuario() {
            return localIdUsuario;
        }

        /**
         * Auto generated setter method
         *
         * @param param IdUsuario
         */
        public void setIdUsuario(IdUsuarioType param) {

            this.localIdUsuario = param;

        }

        /**
         * field for UserName
         */
        protected UserNameType localUserName;

        /**
         * Auto generated getter method
         *
         * @return UserNameType
         */
        public UserNameType getUserName() {
            return localUserName;
        }

        /**
         * Auto generated setter method
         *
         * @param param UserName
         */
        public void setUserName(UserNameType param) {

            this.localUserName = param;

        }

        /**
         * field for IpUsuario
         */
        protected IpUsuarioType localIpUsuario;

        /**
         * Auto generated getter method
         *
         * @return IpUsuarioType
         */
        public IpUsuarioType getIpUsuario() {
            return localIpUsuario;
        }

        /**
         * Auto generated setter method
         *
         * @param param IpUsuario
         */
        public void setIpUsuario(IpUsuarioType param) {

            this.localIpUsuario = param;

        }

        /**
         * field for IpServidor
         */
        protected IpServidorType localIpServidor;

        /**
         * Auto generated getter method
         *
         * @return IpServidorType
         */
        public IpServidorType getIpServidor() {
            return localIpServidor;
        }

        /**
         * Auto generated setter method
         *
         * @param param IpServidor
         */
        public void setIpServidor(IpServidorType param) {

            this.localIpServidor = param;

        }

        /**
         * field for DescripcionAnotacion
         */
        protected DescripcionAnotacionType localDescripcionAnotacion;

        /**
         * Auto generated getter method
         *
         * @return DescripcionAnotacionType
         */
        public DescripcionAnotacionType getDescripcionAnotacion() {
            return localDescripcionAnotacion;
        }

        /**
         * Auto generated setter method
         *
         * @param param DescripcionAnotacion
         */
        public void setDescripcionAnotacion(DescripcionAnotacionType param) {

            this.localDescripcionAnotacion = param;

        }

        /**
         * field for ListaEstructuras
         */
        protected ListaEstructurasType localListaEstructuras;

        /**
         * Auto generated getter method
         *
         * @return ListaEstructurasType
         */
        public ListaEstructurasType getListaEstructuras() {
            return localListaEstructuras;
        }

        /**
         * Auto generated setter method
         *
         * @param param ListaEstructuras
         */
        public void setListaEstructuras(ListaEstructurasType param) {

            this.localListaEstructuras = param;

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource
                    = new org.apache.axis2.databinding.ADBDataSource(this, parentQName) {

                        public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                            InsertarLogRequestType.this.serialize(parentQName, factory, xmlWriter);
                        }
                    };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    parentQName, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://deceval.com/auditoria/services/xsd");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":InsertarLogRequestType",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "InsertarLogRequestType",
                            xmlWriter);
                }

            }

            if (localConstanteReferenciaOperacion == null) {
                throw new org.apache.axis2.databinding.ADBException("constanteReferenciaOperacion cannot be null!!");
            }
            localConstanteReferenciaOperacion.serialize(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "constanteReferenciaOperacion"),
                    factory, xmlWriter);

            if (localConstanteReferenciaOrigen == null) {
                throw new org.apache.axis2.databinding.ADBException("constanteReferenciaOrigen cannot be null!!");
            }
            localConstanteReferenciaOrigen.serialize(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "constanteReferenciaOrigen"),
                    factory, xmlWriter);

            if (localCodigoOrigen == null) {
                throw new org.apache.axis2.databinding.ADBException("codigoOrigen cannot be null!!");
            }
            localCodigoOrigen.serialize(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "codigoOrigen"),
                    factory, xmlWriter);

            if (localIdUsuario == null) {
                throw new org.apache.axis2.databinding.ADBException("idUsuario cannot be null!!");
            }
            localIdUsuario.serialize(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "idUsuario"),
                    factory, xmlWriter);

            if (localUserName == null) {
                throw new org.apache.axis2.databinding.ADBException("userName cannot be null!!");
            }
            localUserName.serialize(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "userName"),
                    factory, xmlWriter);

            if (localIpUsuario == null) {
                throw new org.apache.axis2.databinding.ADBException("ipUsuario cannot be null!!");
            }
            localIpUsuario.serialize(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "ipUsuario"),
                    factory, xmlWriter);

            if (localIpServidor == null) {
                throw new org.apache.axis2.databinding.ADBException("ipServidor cannot be null!!");
            }
            localIpServidor.serialize(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "ipServidor"),
                    factory, xmlWriter);

            if (localDescripcionAnotacion == null) {
                throw new org.apache.axis2.databinding.ADBException("descripcionAnotacion cannot be null!!");
            }
            localDescripcionAnotacion.serialize(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "descripcionAnotacion"),
                    factory, xmlWriter);

            if (localListaEstructuras == null) {

                java.lang.String namespace2 = "http://deceval.com/auditoria/services/xsd";

                if (!namespace2.equals("")) {
                    java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                    if (prefix2 == null) {
                        prefix2 = generatePrefix(namespace2);

                        xmlWriter.writeStartElement(prefix2, "listaEstructuras", namespace2);
                        xmlWriter.writeNamespace(prefix2, namespace2);
                        xmlWriter.setPrefix(prefix2, namespace2);

                    } else {
                        xmlWriter.writeStartElement(namespace2, "listaEstructuras");
                    }

                } else {
                    xmlWriter.writeStartElement("listaEstructuras");
                }

                // write the nil attribute
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                xmlWriter.writeEndElement();
            } else {
                localListaEstructuras.serialize(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "listaEstructuras"),
                        factory, xmlWriter);
            }

            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd",
                    "constanteReferenciaOperacion"));

            if (localConstanteReferenciaOperacion == null) {
                throw new org.apache.axis2.databinding.ADBException("constanteReferenciaOperacion cannot be null!!");
            }
            elementList.add(localConstanteReferenciaOperacion);

            elementList.add(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd",
                    "constanteReferenciaOrigen"));

            if (localConstanteReferenciaOrigen == null) {
                throw new org.apache.axis2.databinding.ADBException("constanteReferenciaOrigen cannot be null!!");
            }
            elementList.add(localConstanteReferenciaOrigen);

            elementList.add(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd",
                    "codigoOrigen"));

            if (localCodigoOrigen == null) {
                throw new org.apache.axis2.databinding.ADBException("codigoOrigen cannot be null!!");
            }
            elementList.add(localCodigoOrigen);

            elementList.add(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd",
                    "idUsuario"));

            if (localIdUsuario == null) {
                throw new org.apache.axis2.databinding.ADBException("idUsuario cannot be null!!");
            }
            elementList.add(localIdUsuario);

            elementList.add(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd",
                    "userName"));

            if (localUserName == null) {
                throw new org.apache.axis2.databinding.ADBException("userName cannot be null!!");
            }
            elementList.add(localUserName);

            elementList.add(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd",
                    "ipUsuario"));

            if (localIpUsuario == null) {
                throw new org.apache.axis2.databinding.ADBException("ipUsuario cannot be null!!");
            }
            elementList.add(localIpUsuario);

            elementList.add(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd",
                    "ipServidor"));

            if (localIpServidor == null) {
                throw new org.apache.axis2.databinding.ADBException("ipServidor cannot be null!!");
            }
            elementList.add(localIpServidor);

            elementList.add(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd",
                    "descripcionAnotacion"));

            if (localDescripcionAnotacion == null) {
                throw new org.apache.axis2.databinding.ADBException("descripcionAnotacion cannot be null!!");
            }
            elementList.add(localDescripcionAnotacion);

            elementList.add(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd",
                    "listaEstructuras"));

            elementList.add(localListaEstructuras == null ? null
                    : localListaEstructuras);

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static InsertarLogRequestType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                InsertarLogRequestType object
                        = new InsertarLogRequestType();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"InsertarLogRequestType".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (InsertarLogRequestType) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "constanteReferenciaOperacion").equals(reader.getName())) {

                        object.setConstanteReferenciaOperacion(ConstanteReferenciaOperacionType.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element
                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "constanteReferenciaOrigen").equals(reader.getName())) {

                        object.setConstanteReferenciaOrigen(ConstanteReferenciaOrigenType.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element
                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "codigoOrigen").equals(reader.getName())) {

                        object.setCodigoOrigen(CodigoOrigenType.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element
                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "idUsuario").equals(reader.getName())) {

                        object.setIdUsuario(IdUsuarioType.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element
                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "userName").equals(reader.getName())) {

                        object.setUserName(UserNameType.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element
                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "ipUsuario").equals(reader.getName())) {

                        object.setIpUsuario(IpUsuarioType.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element
                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "ipServidor").equals(reader.getName())) {

                        object.setIpServidor(IpServidorType.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element
                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "descripcionAnotacion").equals(reader.getName())) {

                        object.setDescripcionAnotacion(DescripcionAnotacionType.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element
                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "listaEstructuras").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            object.setListaEstructuras(null);
                            reader.next();

                            reader.next();

                        } else {

                            object.setListaEstructuras(ListaEstructurasType.Factory.parse(reader));

                            reader.next();
                        }
                    } // End of if for expected property start element
                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement()) // A start element we are not expecting indicates a trailing invalid property
                    {
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                    }

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class Fault
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://deceval.com/auditoria/services/xsd",
                "Fault",
                "ns1");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://deceval.com/auditoria/services/xsd")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * field for Fault
         */
        protected FaultType localFault;

        /**
         * Auto generated getter method
         *
         * @return FaultType
         */
        public FaultType getFault() {
            return localFault;
        }

        /**
         * Auto generated setter method
         *
         * @param param Fault
         */
        public void setFault(FaultType param) {

            this.localFault = param;

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource
                    = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

                        public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                            Fault.this.serialize(MY_QNAME, factory, xmlWriter);
                        }
                    };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            if (localFault == null) {
                throw new org.apache.axis2.databinding.ADBException("Property cannot be null!");
            }
            localFault.serialize(MY_QNAME, factory, xmlWriter);

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return localFault.getPullParser(MY_QNAME);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static Fault parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                Fault object
                        = new Fault();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "Fault").equals(reader.getName())) {

                                object.setFault(FaultType.Factory.parse(reader));

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class InsertarLogResponseType
            implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
         name = InsertarLogResponseType
         Namespace URI = http://deceval.com/auditoria/services/xsd
         Namespace Prefix = ns1
         */

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://deceval.com/auditoria/services/xsd")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * field for ResultadoCreacion
         */
        protected ResultadoCreacionType localResultadoCreacion;

        /**
         * Auto generated getter method
         *
         * @return ResultadoCreacionType
         */
        public ResultadoCreacionType getResultadoCreacion() {
            return localResultadoCreacion;
        }

        /**
         * Auto generated setter method
         *
         * @param param ResultadoCreacion
         */
        public void setResultadoCreacion(ResultadoCreacionType param) {

            this.localResultadoCreacion = param;

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource
                    = new org.apache.axis2.databinding.ADBDataSource(this, parentQName) {

                        public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                            InsertarLogResponseType.this.serialize(parentQName, factory, xmlWriter);
                        }
                    };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    parentQName, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://deceval.com/auditoria/services/xsd");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":InsertarLogResponseType",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "InsertarLogResponseType",
                            xmlWriter);
                }

            }

            if (localResultadoCreacion == null) {
                throw new org.apache.axis2.databinding.ADBException("resultadoCreacion cannot be null!!");
            }
            localResultadoCreacion.serialize(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "resultadoCreacion"),
                    factory, xmlWriter);

            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            elementList.add(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd",
                    "resultadoCreacion"));

            if (localResultadoCreacion == null) {
                throw new org.apache.axis2.databinding.ADBException("resultadoCreacion cannot be null!!");
            }
            elementList.add(localResultadoCreacion);

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static InsertarLogResponseType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                InsertarLogResponseType object
                        = new InsertarLogResponseType();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"InsertarLogResponseType".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (InsertarLogResponseType) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "resultadoCreacion").equals(reader.getName())) {

                        object.setResultadoCreacion(ResultadoCreacionType.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element
                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement()) // A start element we are not expecting indicates a trailing invalid property
                    {
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                    }

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class ExtensionMapper {

        public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                java.lang.String typeName,
                javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {

            if ("http://deceval.com/auditoria/services/xsd".equals(namespaceURI)
                    && "ConstanteReferenciaOrigenType".equals(typeName)) {

                return ConstanteReferenciaOrigenType.Factory.parse(reader);

            }

            if ("http://deceval.com/auditoria/services/xsd".equals(namespaceURI)
                    && "CodigoOrigenType".equals(typeName)) {

                return CodigoOrigenType.Factory.parse(reader);

            }

            if ("http://deceval.com/auditoria/services/xsd".equals(namespaceURI)
                    && "ResultadoCreacionType".equals(typeName)) {

                return ResultadoCreacionType.Factory.parse(reader);

            }

            if ("http://deceval.com/auditoria/services/xsd".equals(namespaceURI)
                    && "ConstanteReferenciaOperacionType".equals(typeName)) {

                return ConstanteReferenciaOperacionType.Factory.parse(reader);

            }

            if ("http://deceval.com/auditoria/services/xsd".equals(namespaceURI)
                    && "ValorCampoType".equals(typeName)) {

                return ValorCampoType.Factory.parse(reader);

            }

            if ("http://deceval.com/auditoria/services/xsd".equals(namespaceURI)
                    && "ListaEstructurasType".equals(typeName)) {

                return ListaEstructurasType.Factory.parse(reader);

            }

            if ("http://deceval.com/auditoria/services/xsd".equals(namespaceURI)
                    && "NombreCampoType".equals(typeName)) {

                return NombreCampoType.Factory.parse(reader);

            }

            if ("http://deceval.com/auditoria/services/xsd".equals(namespaceURI)
                    && "InsertarLogRequestType".equals(typeName)) {

                return InsertarLogRequestType.Factory.parse(reader);

            }

            if ("http://deceval.com/auditoria/services/xsd".equals(namespaceURI)
                    && "InsertarLogResponseType".equals(typeName)) {

                return InsertarLogResponseType.Factory.parse(reader);

            }

            if ("http://deceval.com/auditoria/services/xsd".equals(namespaceURI)
                    && "NombreTablaType".equals(typeName)) {

                return NombreTablaType.Factory.parse(reader);

            }

            if ("http://deceval.com/auditoria/services/xsd".equals(namespaceURI)
                    && "FaultType".equals(typeName)) {

                return FaultType.Factory.parse(reader);

            }

            if ("http://deceval.com/auditoria/services/xsd".equals(namespaceURI)
                    && "EstructuraTablaType".equals(typeName)) {

                return EstructuraTablaType.Factory.parse(reader);

            }

            if ("http://deceval.com/auditoria/services/xsd".equals(namespaceURI)
                    && "DescripcionAnotacionType".equals(typeName)) {

                return DescripcionAnotacionType.Factory.parse(reader);

            }

            if ("http://deceval.com/auditoria/services/xsd".equals(namespaceURI)
                    && "IpUsuarioType".equals(typeName)) {

                return IpUsuarioType.Factory.parse(reader);

            }

            if ("http://deceval.com/auditoria/services/xsd".equals(namespaceURI)
                    && "IpServidorType".equals(typeName)) {

                return IpServidorType.Factory.parse(reader);

            }

            if ("http://deceval.com/auditoria/services/xsd".equals(namespaceURI)
                    && "IdUsuarioType".equals(typeName)) {

                return IdUsuarioType.Factory.parse(reader);

            }

            if ("http://deceval.com/auditoria/services/xsd".equals(namespaceURI)
                    && "UserNameType".equals(typeName)) {

                return UserNameType.Factory.parse(reader);

            }

            throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
        }

    }

    public static class NombreTablaType
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://deceval.com/auditoria/services/xsd",
                "NombreTablaType",
                "ns1");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://deceval.com/auditoria/services/xsd")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * field for NombreTablaType
         */
        protected java.lang.String localNombreTablaType;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getNombreTablaType() {
            return localNombreTablaType;
        }

        /**
         * Auto generated setter method
         *
         * @param param NombreTablaType
         */
        public void setNombreTablaType(java.lang.String param) {

            if ((0 <= java.lang.String.valueOf(param).length()) && (java.lang.String.valueOf(param).length() <= 50)) {
                this.localNombreTablaType = param;
            } else {
                throw new java.lang.RuntimeException();
            }

        }

        public java.lang.String toString() {

            return localNombreTablaType.toString();

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource
                    = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

                        public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                            NombreTablaType.this.serialize(MY_QNAME, factory, xmlWriter);
                        }
                    };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String localName = parentQName.getLocalPart();

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://deceval.com/auditoria/services/xsd");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":NombreTablaType",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "NombreTablaType",
                            xmlWriter);
                }
            }

            if (localNombreTablaType == null) {

                throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");

            } else {

                xmlWriter.writeCharacters(localNombreTablaType);

            }

            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                    new java.lang.Object[]{
                        org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNombreTablaType)
                    },
                    null);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            public static NombreTablaType fromString(java.lang.String value,
                    java.lang.String namespaceURI) {
                NombreTablaType returnValue = new NombreTablaType();

                returnValue.setNombreTablaType(
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));

                return returnValue;
            }

            public static NombreTablaType fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                    java.lang.String content) {
                if (content.indexOf(":") > -1) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                    return NombreTablaType.Factory.fromString(content, namespaceUri);
                } else {
                    return NombreTablaType.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static NombreTablaType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                NombreTablaType object
                        = new NombreTablaType();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {

                            if (reader.isStartElement() || reader.hasText()) {

                                java.lang.String content = reader.getElementText();

                                object.setNombreTablaType(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class EstructuraTablaType
            implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
         name = EstructuraTablaType
         Namespace URI = http://deceval.com/auditoria/services/xsd
         Namespace Prefix = ns1
         */

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://deceval.com/auditoria/services/xsd")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * field for NombreTabla
         */
        protected NombreTablaType localNombreTabla;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localNombreTablaTracker = false;

        /**
         * Auto generated getter method
         *
         * @return NombreTablaType
         */
        public NombreTablaType getNombreTabla() {
            return localNombreTabla;
        }

        /**
         * Auto generated setter method
         *
         * @param param NombreTabla
         */
        public void setNombreTabla(NombreTablaType param) {

            if (param != null) {
                //update the setting tracker
                localNombreTablaTracker = true;
            } else {
                localNombreTablaTracker = false;

            }

            this.localNombreTabla = param;

        }

        /**
         * field for NombreCampo This was an Array!
         */
        protected NombreCampoType[] localNombreCampo;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localNombreCampoTracker = false;

        /**
         * Auto generated getter method
         *
         * @return NombreCampoType[]
         */
        public NombreCampoType[] getNombreCampo() {
            return localNombreCampo;
        }

        /**
         * validate the array for NombreCampo
         */
        protected void validateNombreCampo(NombreCampoType[] param) {

        }

        /**
         * Auto generated setter method
         *
         * @param param NombreCampo
         */
        public void setNombreCampo(NombreCampoType[] param) {

            validateNombreCampo(param);

            if (param != null) {
                //update the setting tracker
                localNombreCampoTracker = true;
            } else {
                localNombreCampoTracker = false;

            }

            this.localNombreCampo = param;
        }

        /**
         * Auto generated add method for the array for convenience
         *
         * @param param NombreCampoType
         */
        public void addNombreCampo(NombreCampoType param) {
            if (localNombreCampo == null) {
                localNombreCampo = new NombreCampoType[]{};
            }

            //update the setting tracker
            localNombreCampoTracker = true;

            java.util.List list
                    = org.apache.axis2.databinding.utils.ConverterUtil.toList(localNombreCampo);
            list.add(param);
            this.localNombreCampo
                    = (NombreCampoType[]) list.toArray(
                            new NombreCampoType[list.size()]);

        }

        /**
         * field for ValorCampo This was an Array!
         */
        protected ValorCampoType[] localValorCampo;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localValorCampoTracker = false;

        /**
         * Auto generated getter method
         *
         * @return ValorCampoType[]
         */
        public ValorCampoType[] getValorCampo() {
            return localValorCampo;
        }

        /**
         * validate the array for ValorCampo
         */
        protected void validateValorCampo(ValorCampoType[] param) {

        }

        /**
         * Auto generated setter method
         *
         * @param param ValorCampo
         */
        public void setValorCampo(ValorCampoType[] param) {

            validateValorCampo(param);

            if (param != null) {
                //update the setting tracker
                localValorCampoTracker = true;
            } else {
                localValorCampoTracker = false;

            }

            this.localValorCampo = param;
        }

        /**
         * Auto generated add method for the array for convenience
         *
         * @param param ValorCampoType
         */
        public void addValorCampo(ValorCampoType param) {
            if (localValorCampo == null) {
                localValorCampo = new ValorCampoType[]{};
            }

            //update the setting tracker
            localValorCampoTracker = true;

            java.util.List list
                    = org.apache.axis2.databinding.utils.ConverterUtil.toList(localValorCampo);
            list.add(param);
            this.localValorCampo
                    = (ValorCampoType[]) list.toArray(
                            new ValorCampoType[list.size()]);

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource
                    = new org.apache.axis2.databinding.ADBDataSource(this, parentQName) {

                        public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                            EstructuraTablaType.this.serialize(parentQName, factory, xmlWriter);
                        }
                    };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    parentQName, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://deceval.com/auditoria/services/xsd");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":EstructuraTablaType",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "EstructuraTablaType",
                            xmlWriter);
                }

            }
            if (localNombreTablaTracker) {
                if (localNombreTabla == null) {
                    throw new org.apache.axis2.databinding.ADBException("nombreTabla cannot be null!!");
                }
                localNombreTabla.serialize(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "nombreTabla"),
                        factory, xmlWriter);
            }
            if (localNombreCampoTracker) {
                if (localNombreCampo != null) {
                    for (int i = 0; i < localNombreCampo.length; i++) {
                        if (localNombreCampo[i] != null) {
                            localNombreCampo[i].serialize(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "nombreCampo"),
                                    factory, xmlWriter);
                        } else {

                            // we don't have to do any thing since minOccures is zero
                        }

                    }
                } else {

                    throw new org.apache.axis2.databinding.ADBException("nombreCampo cannot be null!!");

                }
            }
            if (localValorCampoTracker) {
                if (localValorCampo != null) {
                    for (int i = 0; i < localValorCampo.length; i++) {
                        if (localValorCampo[i] != null) {
                            localValorCampo[i].serialize(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "valorCampo"),
                                    factory, xmlWriter);
                        } else {

                            // we don't have to do any thing since minOccures is zero
                        }

                    }
                } else {

                    throw new org.apache.axis2.databinding.ADBException("valorCampo cannot be null!!");

                }
            }
            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if (localNombreTablaTracker) {
                elementList.add(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd",
                        "nombreTabla"));

                if (localNombreTabla == null) {
                    throw new org.apache.axis2.databinding.ADBException("nombreTabla cannot be null!!");
                }
                elementList.add(localNombreTabla);
            }
            if (localNombreCampoTracker) {
                if (localNombreCampo != null) {
                    for (int i = 0; i < localNombreCampo.length; i++) {

                        if (localNombreCampo[i] != null) {
                            elementList.add(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd",
                                    "nombreCampo"));
                            elementList.add(localNombreCampo[i]);
                        } else {

                            // nothing to do
                        }

                    }
                } else {

                    throw new org.apache.axis2.databinding.ADBException("nombreCampo cannot be null!!");

                }

            }
            if (localValorCampoTracker) {
                if (localValorCampo != null) {
                    for (int i = 0; i < localValorCampo.length; i++) {

                        if (localValorCampo[i] != null) {
                            elementList.add(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd",
                                    "valorCampo"));
                            elementList.add(localValorCampo[i]);
                        } else {

                            // nothing to do
                        }

                    }
                } else {

                    throw new org.apache.axis2.databinding.ADBException("valorCampo cannot be null!!");

                }

            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static EstructuraTablaType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                EstructuraTablaType object
                        = new EstructuraTablaType();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"EstructuraTablaType".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (EstructuraTablaType) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    java.util.ArrayList list2 = new java.util.ArrayList();

                    java.util.ArrayList list3 = new java.util.ArrayList();

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "nombreTabla").equals(reader.getName())) {

                        object.setNombreTabla(NombreTablaType.Factory.parse(reader));

                        reader.next();

                    } // End of if for expected property start element
                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "nombreCampo").equals(reader.getName())) {

                        // Process the array and step past its final element's end.
                        list2.add(NombreCampoType.Factory.parse(reader));

                        //loop until we find a start element that is not part of this array
                        boolean loopDone2 = false;
                        while (!loopDone2) {
                            // We should be at the end element, but make sure
                            while (!reader.isEndElement()) {
                                reader.next();
                            }
                            // Step out of this element
                            reader.next();
                            // Step to next element event.
                            while (!reader.isStartElement() && !reader.isEndElement()) {
                                reader.next();
                            }
                            if (reader.isEndElement()) {
                                //two continuous end elements means we are exiting the xml structure
                                loopDone2 = true;
                            } else {
                                if (new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "nombreCampo").equals(reader.getName())) {
                                    list2.add(NombreCampoType.Factory.parse(reader));

                                } else {
                                    loopDone2 = true;
                                }
                            }
                        }
                        // call the converter utility  to convert and set the array

                        object.setNombreCampo((NombreCampoType[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                NombreCampoType.class,
                                list2));

                    } // End of if for expected property start element
                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "valorCampo").equals(reader.getName())) {

                        // Process the array and step past its final element's end.
                        list3.add(ValorCampoType.Factory.parse(reader));

                        //loop until we find a start element that is not part of this array
                        boolean loopDone3 = false;
                        while (!loopDone3) {
                            // We should be at the end element, but make sure
                            while (!reader.isEndElement()) {
                                reader.next();
                            }
                            // Step out of this element
                            reader.next();
                            // Step to next element event.
                            while (!reader.isStartElement() && !reader.isEndElement()) {
                                reader.next();
                            }
                            if (reader.isEndElement()) {
                                //two continuous end elements means we are exiting the xml structure
                                loopDone3 = true;
                            } else {
                                if (new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "valorCampo").equals(reader.getName())) {
                                    list3.add(ValorCampoType.Factory.parse(reader));

                                } else {
                                    loopDone3 = true;
                                }
                            }
                        }
                        // call the converter utility  to convert and set the array

                        object.setValorCampo((ValorCampoType[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                ValorCampoType.class,
                                list3));

                    } // End of if for expected property start element
                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement()) // A start element we are not expecting indicates a trailing invalid property
                    {
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                    }

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class FaultType
            implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
         name = FaultType
         Namespace URI = http://deceval.com/auditoria/services/xsd
         Namespace Prefix = ns1
         */

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://deceval.com/auditoria/services/xsd")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * field for ErrorCode
         */
        protected java.lang.String localErrorCode;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localErrorCodeTracker = false;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getErrorCode() {
            return localErrorCode;
        }

        /**
         * Auto generated setter method
         *
         * @param param ErrorCode
         */
        public void setErrorCode(java.lang.String param) {

            if (param != null) {
                //update the setting tracker
                localErrorCodeTracker = true;
            } else {
                localErrorCodeTracker = false;

            }

            this.localErrorCode = param;

        }

        /**
         * field for Reason
         */
        protected java.lang.String localReason;

        /*  This tracker boolean wil be used to detect whether the user called the set method
         *   for this attribute. It will be used to determine whether to include this field
         *   in the serialized XML
         */
        protected boolean localReasonTracker = false;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getReason() {
            return localReason;
        }

        /**
         * Auto generated setter method
         *
         * @param param Reason
         */
        public void setReason(java.lang.String param) {

            if (param != null) {
                //update the setting tracker
                localReasonTracker = true;
            } else {
                localReasonTracker = false;

            }

            this.localReason = param;

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource
                    = new org.apache.axis2.databinding.ADBDataSource(this, parentQName) {

                        public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                            FaultType.this.serialize(parentQName, factory, xmlWriter);
                        }
                    };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    parentQName, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

            java.lang.String prefix = null;
            java.lang.String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();

            if ((namespace != null) && (namespace.trim().length() > 0)) {
                java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                if (writerPrefix != null) {
                    xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                } else {
                    if (prefix == null) {
                        prefix = generatePrefix(namespace);
                    }

                    xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }
            } else {
                xmlWriter.writeStartElement(parentQName.getLocalPart());
            }

            if (serializeType) {

                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://deceval.com/auditoria/services/xsd");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":FaultType",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "FaultType",
                            xmlWriter);
                }

            }
            if (localErrorCodeTracker) {
                namespace = "http://deceval.com/auditoria/services/xsd";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "errorCode", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "errorCode");
                    }

                } else {
                    xmlWriter.writeStartElement("errorCode");
                }

                if (localErrorCode == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("errorCode cannot be null!!");

                } else {

                    xmlWriter.writeCharacters(localErrorCode);

                }

                xmlWriter.writeEndElement();
            }
            if (localReasonTracker) {
                namespace = "http://deceval.com/auditoria/services/xsd";
                if (!namespace.equals("")) {
                    prefix = xmlWriter.getPrefix(namespace);

                    if (prefix == null) {
                        prefix = generatePrefix(namespace);

                        xmlWriter.writeStartElement(prefix, "reason", namespace);
                        xmlWriter.writeNamespace(prefix, namespace);
                        xmlWriter.setPrefix(prefix, namespace);

                    } else {
                        xmlWriter.writeStartElement(namespace, "reason");
                    }

                } else {
                    xmlWriter.writeStartElement("reason");
                }

                if (localReason == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("reason cannot be null!!");

                } else {

                    xmlWriter.writeCharacters(localReason);

                }

                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if (localErrorCodeTracker) {
                elementList.add(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd",
                        "errorCode"));

                if (localErrorCode != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localErrorCode));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("errorCode cannot be null!!");
                }
            }
            if (localReasonTracker) {
                elementList.add(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd",
                        "reason"));

                if (localReason != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localReason));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("reason cannot be null!!");
                }
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static FaultType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                FaultType object
                        = new FaultType();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"FaultType".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (FaultType) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }

                        }

                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    reader.next();

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "errorCode").equals(reader.getName())) {

                        java.lang.String content = reader.getElementText();

                        object.setErrorCode(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    } // End of if for expected property start element
                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd", "reason").equals(reader.getName())) {

                        java.lang.String content = reader.getElementText();

                        object.setReason(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    } // End of if for expected property start element
                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    if (reader.isStartElement()) // A start element we are not expecting indicates a trailing invalid property
                    {
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                    }

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class DescripcionAnotacionType
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://deceval.com/auditoria/services/xsd",
                "DescripcionAnotacionType",
                "ns1");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://deceval.com/auditoria/services/xsd")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * field for DescripcionAnotacionType
         */
        protected java.lang.String localDescripcionAnotacionType;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getDescripcionAnotacionType() {
            return localDescripcionAnotacionType;
        }

        /**
         * Auto generated setter method
         *
         * @param param DescripcionAnotacionType
         */
        public void setDescripcionAnotacionType(java.lang.String param) {

            if ((0 <= java.lang.String.valueOf(param).length()) && (java.lang.String.valueOf(param).length() <= 255)) {
                this.localDescripcionAnotacionType = param;
            } else {
                throw new java.lang.RuntimeException();
            }

        }

        public java.lang.String toString() {

            return localDescripcionAnotacionType.toString();

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource
                    = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

                        public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                            DescripcionAnotacionType.this.serialize(MY_QNAME, factory, xmlWriter);
                        }
                    };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String localName = parentQName.getLocalPart();

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://deceval.com/auditoria/services/xsd");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":DescripcionAnotacionType",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "DescripcionAnotacionType",
                            xmlWriter);
                }
            }

            if (localDescripcionAnotacionType == null) {

                throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");

            } else {

                xmlWriter.writeCharacters(localDescripcionAnotacionType);

            }

            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                    new java.lang.Object[]{
                        org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDescripcionAnotacionType)
                    },
                    null);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            public static DescripcionAnotacionType fromString(java.lang.String value,
                    java.lang.String namespaceURI) {
                DescripcionAnotacionType returnValue = new DescripcionAnotacionType();

                returnValue.setDescripcionAnotacionType(
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));

                return returnValue;
            }

            public static DescripcionAnotacionType fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                    java.lang.String content) {
                if (content.indexOf(":") > -1) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                    return DescripcionAnotacionType.Factory.fromString(content, namespaceUri);
                } else {
                    return DescripcionAnotacionType.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static DescripcionAnotacionType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                DescripcionAnotacionType object
                        = new DescripcionAnotacionType();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {

                            if (reader.isStartElement() || reader.hasText()) {

                                java.lang.String content = reader.getElementText();

                                object.setDescripcionAnotacionType(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class IpUsuarioType
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://deceval.com/auditoria/services/xsd",
                "IpUsuarioType",
                "ns1");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://deceval.com/auditoria/services/xsd")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * field for IpUsuarioType
         */
        protected java.lang.String localIpUsuarioType;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getIpUsuarioType() {
            return localIpUsuarioType;
        }

        /**
         * Auto generated setter method
         *
         * @param param IpUsuarioType
         */
        public void setIpUsuarioType(java.lang.String param) {

            if ((0 <= java.lang.String.valueOf(param).length()) && (java.lang.String.valueOf(param).length() <= 20)) {
                this.localIpUsuarioType = param;
            } else {
                throw new java.lang.RuntimeException();
            }

        }

        public java.lang.String toString() {

            return localIpUsuarioType.toString();

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource
                    = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

                        public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                            IpUsuarioType.this.serialize(MY_QNAME, factory, xmlWriter);
                        }
                    };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String localName = parentQName.getLocalPart();

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://deceval.com/auditoria/services/xsd");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":IpUsuarioType",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "IpUsuarioType",
                            xmlWriter);
                }
            }

            if (localIpUsuarioType == null) {

                throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");

            } else {

                xmlWriter.writeCharacters(localIpUsuarioType);

            }

            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                    new java.lang.Object[]{
                        org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIpUsuarioType)
                    },
                    null);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            public static IpUsuarioType fromString(java.lang.String value,
                    java.lang.String namespaceURI) {
                IpUsuarioType returnValue = new IpUsuarioType();

                returnValue.setIpUsuarioType(
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));

                return returnValue;
            }

            public static IpUsuarioType fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                    java.lang.String content) {
                if (content.indexOf(":") > -1) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                    return IpUsuarioType.Factory.fromString(content, namespaceUri);
                } else {
                    return IpUsuarioType.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static IpUsuarioType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                IpUsuarioType object
                        = new IpUsuarioType();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {

                            if (reader.isStartElement() || reader.hasText()) {

                                java.lang.String content = reader.getElementText();

                                object.setIpUsuarioType(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class IpServidorType
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://deceval.com/auditoria/services/xsd",
                "IpServidorType",
                "ns1");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://deceval.com/auditoria/services/xsd")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * field for IpServidorType
         */
        protected java.lang.String localIpServidorType;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getIpServidorType() {
            return localIpServidorType;
        }

        /**
         * Auto generated setter method
         *
         * @param param IpServidorType
         */
        public void setIpServidorType(java.lang.String param) {

            if ((0 <= java.lang.String.valueOf(param).length()) && (java.lang.String.valueOf(param).length() <= 20)) {
                this.localIpServidorType = param;
            } else {
                throw new java.lang.RuntimeException();
            }

        }

        public java.lang.String toString() {

            return localIpServidorType.toString();

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource
                    = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

                        public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                            IpServidorType.this.serialize(MY_QNAME, factory, xmlWriter);
                        }
                    };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String localName = parentQName.getLocalPart();

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://deceval.com/auditoria/services/xsd");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":IpServidorType",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "IpServidorType",
                            xmlWriter);
                }
            }

            if (localIpServidorType == null) {

                throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");

            } else {

                xmlWriter.writeCharacters(localIpServidorType);

            }

            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                    new java.lang.Object[]{
                        org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIpServidorType)
                    },
                    null);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            public static IpServidorType fromString(java.lang.String value,
                    java.lang.String namespaceURI) {
                IpServidorType returnValue = new IpServidorType();

                returnValue.setIpServidorType(
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));

                return returnValue;
            }

            public static IpServidorType fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                    java.lang.String content) {
                if (content.indexOf(":") > -1) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                    return IpServidorType.Factory.fromString(content, namespaceUri);
                } else {
                    return IpServidorType.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static IpServidorType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                IpServidorType object
                        = new IpServidorType();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {

                            if (reader.isStartElement() || reader.hasText()) {

                                java.lang.String content = reader.getElementText();

                                object.setIpServidorType(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class IdUsuarioType
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://deceval.com/auditoria/services/xsd",
                "IdUsuarioType",
                "ns1");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://deceval.com/auditoria/services/xsd")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * field for IdUsuarioType
         */
        protected int localIdUsuarioType;

        /**
         * Auto generated getter method
         *
         * @return int
         */
        public int getIdUsuarioType() {
            return localIdUsuarioType;
        }

        /**
         * Auto generated setter method
         *
         * @param param IdUsuarioType
         */
        public void setIdUsuarioType(int param) {

            this.localIdUsuarioType = param;

        }

        public java.lang.String toString() {

            return localIdUsuarioType + "";

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource
                    = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

                        public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                            IdUsuarioType.this.serialize(MY_QNAME, factory, xmlWriter);
                        }
                    };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String localName = parentQName.getLocalPart();

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://deceval.com/auditoria/services/xsd");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":IdUsuarioType",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "IdUsuarioType",
                            xmlWriter);
                }
            }

            if (localIdUsuarioType == java.lang.Integer.MIN_VALUE) {

                throw new org.apache.axis2.databinding.ADBException("property value cannot be null!!");

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIdUsuarioType));
            }

            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                    new java.lang.Object[]{
                        org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIdUsuarioType)
                    },
                    null);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            public static IdUsuarioType fromString(java.lang.String value,
                    java.lang.String namespaceURI) {
                IdUsuarioType returnValue = new IdUsuarioType();

                returnValue.setIdUsuarioType(
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(value));

                return returnValue;
            }

            public static IdUsuarioType fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                    java.lang.String content) {
                if (content.indexOf(":") > -1) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                    return IdUsuarioType.Factory.fromString(content, namespaceUri);
                } else {
                    return IdUsuarioType.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static IdUsuarioType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                IdUsuarioType object
                        = new IdUsuarioType();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {

                            if (reader.isStartElement() || reader.hasText()) {

                                java.lang.String content = reader.getElementText();

                                object.setIdUsuarioType(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    public static class UserNameType
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://deceval.com/auditoria/services/xsd",
                "UserNameType",
                "ns1");

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://deceval.com/auditoria/services/xsd")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * field for UserNameType
         */
        protected java.lang.String localUserNameType;

        /**
         * Auto generated getter method
         *
         * @return java.lang.String
         */
        public java.lang.String getUserNameType() {
            return localUserNameType;
        }

        /**
         * Auto generated setter method
         *
         * @param param UserNameType
         */
        public void setUserNameType(java.lang.String param) {

            if ((0 <= java.lang.String.valueOf(param).length()) && (java.lang.String.valueOf(param).length() <= 20)) {
                this.localUserNameType = param;
            } else {
                throw new java.lang.RuntimeException();
            }

        }

        public java.lang.String toString() {

            return localUserNameType.toString();

        }

        /**
         * isReaderMTOMAware
         *
         * @return true if the reader supports MTOM
         */
        public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
            boolean isReaderMTOMAware = false;

            try {
                isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
            } catch (java.lang.IllegalArgumentException e) {
                isReaderMTOMAware = false;
            }
            return isReaderMTOMAware;
        }

        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {

            org.apache.axiom.om.OMDataSource dataSource
                    = new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME) {

                        public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                            UserNameType.this.serialize(MY_QNAME, factory, xmlWriter);
                        }
                    };
            return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
                    MY_QNAME, factory, dataSource);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, factory, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory,
                org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String localName = parentQName.getLocalPart();

            if (!namespace.equals("")) {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    xmlWriter.writeStartElement(prefix, localName, namespace);
                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);

                } else {
                    xmlWriter.writeStartElement(namespace, localName);
                }

            } else {
                xmlWriter.writeStartElement(localName);
            }

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://deceval.com/auditoria/services/xsd");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":UserNameType",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "UserNameType",
                            xmlWriter);
                }
            }

            if (localUserNameType == null) {

                throw new org.apache.axis2.databinding.ADBException("Value cannot be null !!");

            } else {

                xmlWriter.writeCharacters(localUserNameType);

            }

            xmlWriter.writeEndElement();

        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);

            }

            xmlWriter.writeAttribute(namespace, attName, attValue);

        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         * method to handle Qnames
         */
        private void writeQName(javax.xml.namespace.QName qname,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }

        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);

            if (prefix == null) {
                prefix = generatePrefix(namespace);

                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }

                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }

            return prefix;
        }

        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {

            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                    new java.lang.Object[]{
                        org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localUserNameType)
                    },
                    null);

        }

        /**
         * Factory class that keeps the parse method
         */
        public static class Factory {

            public static UserNameType fromString(java.lang.String value,
                    java.lang.String namespaceURI) {
                UserNameType returnValue = new UserNameType();

                returnValue.setUserNameType(
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));

                return returnValue;
            }

            public static UserNameType fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                    java.lang.String content) {
                if (content.indexOf(":") > -1) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                    return UserNameType.Factory.fromString(content, namespaceUri);
                } else {
                    return UserNameType.Factory.fromString(content, "");
                }
            }

            /**
             * static method to create the object Precondition: If this object
             * is an element, the current or next start element starts this
             * object and any intervening reader events are ignorable If this
             * object is not an element, it is a complex type and the reader is
             * at the event just after the outer start element Postcondition: If
             * this object is an element, the reader is positioned at its end
             * element If this object is a complex type, the reader is
             * positioned at the end element of its outer element
             */
            public static UserNameType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                UserNameType object
                        = new UserNameType();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement()) {
                        reader.next();
                    }

                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {

                            if (reader.isStartElement() || reader.hasText()) {

                                java.lang.String content = reader.getElementText();

                                object.setUserNameType(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                            } // End of if for expected property start element
                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop

                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class

    }

    private org.apache.axiom.om.OMElement toOM(com.deceval.auditoria.services.adb.client.InsertarLogAUDITORIAServiceStub.InsertarLogRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(com.deceval.auditoria.services.adb.client.InsertarLogAUDITORIAServiceStub.InsertarLogRequest.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM(com.deceval.auditoria.services.adb.client.InsertarLogAUDITORIAServiceStub.InsertarLogResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(com.deceval.auditoria.services.adb.client.InsertarLogAUDITORIAServiceStub.InsertarLogResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.om.OMElement toOM(com.deceval.auditoria.services.adb.client.InsertarLogAUDITORIAServiceStub.Fault param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

        try {
            return param.getOMElement(com.deceval.auditoria.services.adb.client.InsertarLogAUDITORIAServiceStub.Fault.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.deceval.auditoria.services.adb.client.InsertarLogAUDITORIAServiceStub.InsertarLogRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(com.deceval.auditoria.services.adb.client.InsertarLogAUDITORIAServiceStub.InsertarLogRequest.MY_QNAME, factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }

    }

    /* methods to provide back word compatibility */
    /**
     * get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }

    private java.lang.Object fromOM(
            org.apache.axiom.om.OMElement param,
            java.lang.Class type,
            java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault {

        try {

            if (com.deceval.auditoria.services.adb.client.InsertarLogAUDITORIAServiceStub.InsertarLogRequest.class.equals(type)) {

                return com.deceval.auditoria.services.adb.client.InsertarLogAUDITORIAServiceStub.InsertarLogRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if (com.deceval.auditoria.services.adb.client.InsertarLogAUDITORIAServiceStub.InsertarLogResponse.class.equals(type)) {

                return com.deceval.auditoria.services.adb.client.InsertarLogAUDITORIAServiceStub.InsertarLogResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

            if (com.deceval.auditoria.services.adb.client.InsertarLogAUDITORIAServiceStub.Fault.class.equals(type)) {

                return com.deceval.auditoria.services.adb.client.InsertarLogAUDITORIAServiceStub.Fault.Factory.parse(param.getXMLStreamReaderWithoutCaching());

            }

        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
        return null;
    }

}
