
/**
 * EstructuraTablaType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:25:17 EDT)
 */
            
                package com.deceval.auditoria.services.xsd;
            

            /**
            *  EstructuraTablaType bean class
            */
        
        public  class EstructuraTablaType
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = EstructuraTablaType
                Namespace URI = http://deceval.com/auditoria/services/xsd
                Namespace Prefix = ns1
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://deceval.com/auditoria/services/xsd")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for NombreTabla
                        */

                        
                                    protected com.deceval.auditoria.services.xsd.NombreTablaType localNombreTabla ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNombreTablaTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.deceval.auditoria.services.xsd.NombreTablaType
                           */
                           public  com.deceval.auditoria.services.xsd.NombreTablaType getNombreTabla(){
                               return localNombreTabla;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NombreTabla
                               */
                               public void setNombreTabla(com.deceval.auditoria.services.xsd.NombreTablaType param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localNombreTablaTracker = true;
                                       } else {
                                          localNombreTablaTracker = false;
                                              
                                       }
                                   
                                            this.localNombreTabla=param;
                                    

                               }
                            

                        /**
                        * field for NombreCampo
                        * This was an Array!
                        */

                        
                                    protected com.deceval.auditoria.services.xsd.NombreCampoType[] localNombreCampo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNombreCampoTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.deceval.auditoria.services.xsd.NombreCampoType[]
                           */
                           public  com.deceval.auditoria.services.xsd.NombreCampoType[] getNombreCampo(){
                               return localNombreCampo;
                           }

                           
                        


                               
                              /**
                               * validate the array for NombreCampo
                               */
                              protected void validateNombreCampo(com.deceval.auditoria.services.xsd.NombreCampoType[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param NombreCampo
                              */
                              public void setNombreCampo(com.deceval.auditoria.services.xsd.NombreCampoType[] param){
                              
                                   validateNombreCampo(param);

                               
                                          if (param != null){
                                             //update the setting tracker
                                             localNombreCampoTracker = true;
                                          } else {
                                             localNombreCampoTracker = false;
                                                 
                                          }
                                      
                                      this.localNombreCampo=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param com.deceval.auditoria.services.xsd.NombreCampoType
                             */
                             public void addNombreCampo(com.deceval.auditoria.services.xsd.NombreCampoType param){
                                   if (localNombreCampo == null){
                                   localNombreCampo = new com.deceval.auditoria.services.xsd.NombreCampoType[]{};
                                   }

                            
                                 //update the setting tracker
                                localNombreCampoTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localNombreCampo);
                               list.add(param);
                               this.localNombreCampo =
                             (com.deceval.auditoria.services.xsd.NombreCampoType[])list.toArray(
                            new com.deceval.auditoria.services.xsd.NombreCampoType[list.size()]);

                             }
                             

                        /**
                        * field for ValorCampo
                        * This was an Array!
                        */

                        
                                    protected com.deceval.auditoria.services.xsd.ValorCampoType[] localValorCampo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localValorCampoTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.deceval.auditoria.services.xsd.ValorCampoType[]
                           */
                           public  com.deceval.auditoria.services.xsd.ValorCampoType[] getValorCampo(){
                               return localValorCampo;
                           }

                           
                        


                               
                              /**
                               * validate the array for ValorCampo
                               */
                              protected void validateValorCampo(com.deceval.auditoria.services.xsd.ValorCampoType[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param ValorCampo
                              */
                              public void setValorCampo(com.deceval.auditoria.services.xsd.ValorCampoType[] param){
                              
                                   validateValorCampo(param);

                               
                                          if (param != null){
                                             //update the setting tracker
                                             localValorCampoTracker = true;
                                          } else {
                                             localValorCampoTracker = false;
                                                 
                                          }
                                      
                                      this.localValorCampo=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param com.deceval.auditoria.services.xsd.ValorCampoType
                             */
                             public void addValorCampo(com.deceval.auditoria.services.xsd.ValorCampoType param){
                                   if (localValorCampo == null){
                                   localValorCampo = new com.deceval.auditoria.services.xsd.ValorCampoType[]{};
                                   }

                            
                                 //update the setting tracker
                                localValorCampoTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localValorCampo);
                               list.add(param);
                               this.localValorCampo =
                             (com.deceval.auditoria.services.xsd.ValorCampoType[])list.toArray(
                            new com.deceval.auditoria.services.xsd.ValorCampoType[list.size()]);

                             }
                             

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
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
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       EstructuraTablaType.this.serialize(parentQName,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               parentQName,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


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
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://deceval.com/auditoria/services/xsd");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":EstructuraTablaType",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "EstructuraTablaType",
                           xmlWriter);
                   }

               
                   }
                if (localNombreTablaTracker){
                                            if (localNombreTabla==null){
                                                 throw new org.apache.axis2.databinding.ADBException("nombreTabla cannot be null!!");
                                            }
                                           localNombreTabla.serialize(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd","nombreTabla"),
                                               factory,xmlWriter);
                                        } if (localNombreCampoTracker){
                                       if (localNombreCampo!=null){
                                            for (int i = 0;i < localNombreCampo.length;i++){
                                                if (localNombreCampo[i] != null){
                                                 localNombreCampo[i].serialize(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd","nombreCampo"),
                                                           factory,xmlWriter);
                                                } else {
                                                   
                                                        // we don't have to do any thing since minOccures is zero
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("nombreCampo cannot be null!!");
                                        
                                    }
                                 } if (localValorCampoTracker){
                                       if (localValorCampo!=null){
                                            for (int i = 0;i < localValorCampo.length;i++){
                                                if (localValorCampo[i] != null){
                                                 localValorCampo[i].serialize(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd","valorCampo"),
                                                           factory,xmlWriter);
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
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
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
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
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
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
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
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localNombreTablaTracker){
                            elementList.add(new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd",
                                                                      "nombreTabla"));
                            
                            
                                    if (localNombreTabla==null){
                                         throw new org.apache.axis2.databinding.ADBException("nombreTabla cannot be null!!");
                                    }
                                    elementList.add(localNombreTabla);
                                } if (localNombreCampoTracker){
                             if (localNombreCampo!=null) {
                                 for (int i = 0;i < localNombreCampo.length;i++){

                                    if (localNombreCampo[i] != null){
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

                        } if (localValorCampoTracker){
                             if (localValorCampo!=null) {
                                 for (int i = 0;i < localValorCampo.length;i++){

                                    if (localValorCampo[i] != null){
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
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static EstructuraTablaType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            EstructuraTablaType object =
                new EstructuraTablaType();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"EstructuraTablaType".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (EstructuraTablaType)com.deceval.auditoria.services.xsd.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                        java.util.ArrayList list2 = new java.util.ArrayList();
                    
                        java.util.ArrayList list3 = new java.util.ArrayList();
                    
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd","nombreTabla").equals(reader.getName())){
                                
                                                object.setNombreTabla(com.deceval.auditoria.services.xsd.NombreTablaType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd","nombreCampo").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list2.add(com.deceval.auditoria.services.xsd.NombreCampoType.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone2 = false;
                                                        while(!loopDone2){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone2 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd","nombreCampo").equals(reader.getName())){
                                                                    list2.add(com.deceval.auditoria.services.xsd.NombreCampoType.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone2 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setNombreCampo((com.deceval.auditoria.services.xsd.NombreCampoType[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                com.deceval.auditoria.services.xsd.NombreCampoType.class,
                                                                list2));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd","valorCampo").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list3.add(com.deceval.auditoria.services.xsd.ValorCampoType.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone3 = false;
                                                        while(!loopDone3){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone3 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://deceval.com/auditoria/services/xsd","valorCampo").equals(reader.getName())){
                                                                    list3.add(com.deceval.auditoria.services.xsd.ValorCampoType.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone3 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setValorCampo((com.deceval.auditoria.services.xsd.ValorCampoType[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                com.deceval.auditoria.services.xsd.ValorCampoType.class,
                                                                list3));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                  
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          