
package com;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.7-b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "LoggerService", targetNamespace = "http://service.com/", wsdlLocation = "http://localhost:8080/services/Logger?wsdl")
public class LoggerService
    extends Service
{

    private final static URL LOGGERSERVICE_WSDL_LOCATION;
    private final static WebServiceException LOGGERSERVICE_EXCEPTION;
    private final static QName LOGGERSERVICE_QNAME = new QName("http://service.com/", "LoggerService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/services/Logger?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        LOGGERSERVICE_WSDL_LOCATION = url;
        LOGGERSERVICE_EXCEPTION = e;
    }

    public LoggerService() {
        super(__getWsdlLocation(), LOGGERSERVICE_QNAME);
    }

    public LoggerService(WebServiceFeature... features) {
        super(__getWsdlLocation(), LOGGERSERVICE_QNAME, features);
    }

    public LoggerService(URL wsdlLocation) {
        super(wsdlLocation, LOGGERSERVICE_QNAME);
    }

    public LoggerService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, LOGGERSERVICE_QNAME, features);
    }

    public LoggerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public LoggerService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Logger
     */
    @WebEndpoint(name = "LoggerPort")
    public Logger getLoggerPort() {
        return super.getPort(new QName("http://service.com/", "LoggerPort"), Logger.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Logger
     */
    @WebEndpoint(name = "LoggerPort")
    public Logger getLoggerPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.com/", "LoggerPort"), Logger.class, features);
    }

    private static URL __getWsdlLocation() {
        if (LOGGERSERVICE_EXCEPTION!= null) {
            throw LOGGERSERVICE_EXCEPTION;
        }
        return LOGGERSERVICE_WSDL_LOCATION;
    }

}
