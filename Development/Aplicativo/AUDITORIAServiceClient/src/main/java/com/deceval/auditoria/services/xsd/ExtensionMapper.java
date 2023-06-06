
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:25:17 EDT)
 */

            package com.deceval.auditoria.services.xsd;
            /**
            *  ExtensionMapper class
            */
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://deceval.com/auditoria/services/xsd".equals(namespaceURI) &&
                  "ConstanteReferenciaOrigenType".equals(typeName)){
                   
                            return  com.deceval.auditoria.services.xsd.ConstanteReferenciaOrigenType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://deceval.com/auditoria/services/xsd".equals(namespaceURI) &&
                  "CodigoOrigenType".equals(typeName)){
                   
                            return  com.deceval.auditoria.services.xsd.CodigoOrigenType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://deceval.com/auditoria/services/xsd".equals(namespaceURI) &&
                  "ResultadoCreacionType".equals(typeName)){
                   
                            return  com.deceval.auditoria.services.xsd.ResultadoCreacionType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://deceval.com/auditoria/services/xsd".equals(namespaceURI) &&
                  "ConstanteReferenciaOperacionType".equals(typeName)){
                   
                            return  com.deceval.auditoria.services.xsd.ConstanteReferenciaOperacionType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://deceval.com/auditoria/services/xsd".equals(namespaceURI) &&
                  "ValorCampoType".equals(typeName)){
                   
                            return  com.deceval.auditoria.services.xsd.ValorCampoType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://deceval.com/auditoria/services/xsd".equals(namespaceURI) &&
                  "ListaEstructurasType".equals(typeName)){
                   
                            return  com.deceval.auditoria.services.xsd.ListaEstructurasType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://deceval.com/auditoria/services/xsd".equals(namespaceURI) &&
                  "NombreCampoType".equals(typeName)){
                   
                            return  com.deceval.auditoria.services.xsd.NombreCampoType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://deceval.com/auditoria/services/xsd".equals(namespaceURI) &&
                  "InsertarLogRequestType".equals(typeName)){
                   
                            return  com.deceval.auditoria.services.xsd.InsertarLogRequestType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://deceval.com/auditoria/services/xsd".equals(namespaceURI) &&
                  "InsertarLogResponseType".equals(typeName)){
                   
                            return  com.deceval.auditoria.services.xsd.InsertarLogResponseType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://deceval.com/auditoria/services/xsd".equals(namespaceURI) &&
                  "NombreTablaType".equals(typeName)){
                   
                            return  com.deceval.auditoria.services.xsd.NombreTablaType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://deceval.com/auditoria/services/xsd".equals(namespaceURI) &&
                  "FaultType".equals(typeName)){
                   
                            return  com.deceval.auditoria.services.xsd.FaultType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://deceval.com/auditoria/services/xsd".equals(namespaceURI) &&
                  "EstructuraTablaType".equals(typeName)){
                   
                            return  com.deceval.auditoria.services.xsd.EstructuraTablaType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://deceval.com/auditoria/services/xsd".equals(namespaceURI) &&
                  "DescripcionAnotacionType".equals(typeName)){
                   
                            return  com.deceval.auditoria.services.xsd.DescripcionAnotacionType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://deceval.com/auditoria/services/xsd".equals(namespaceURI) &&
                  "IpUsuarioType".equals(typeName)){
                   
                            return  com.deceval.auditoria.services.xsd.IpUsuarioType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://deceval.com/auditoria/services/xsd".equals(namespaceURI) &&
                  "IpServidorType".equals(typeName)){
                   
                            return  com.deceval.auditoria.services.xsd.IpServidorType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://deceval.com/auditoria/services/xsd".equals(namespaceURI) &&
                  "IdUsuarioType".equals(typeName)){
                   
                            return  com.deceval.auditoria.services.xsd.IdUsuarioType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://deceval.com/auditoria/services/xsd".equals(namespaceURI) &&
                  "UserNameType".equals(typeName)){
                   
                            return  com.deceval.auditoria.services.xsd.UserNameType.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    