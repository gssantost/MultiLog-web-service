
package com;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com package. 
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

    private final static QName _PingResponse_QNAME = new QName("http://service.com/", "pingResponse");
    private final static QName _GetLogResponse_QNAME = new QName("http://service.com/", "getLogResponse");
    private final static QName _AddResponse_QNAME = new QName("http://service.com/", "addResponse");
    private final static QName _GetLog_QNAME = new QName("http://service.com/", "getLog");
    private final static QName _GetLogByRangeResponse_QNAME = new QName("http://service.com/", "getLogByRangeResponse");
    private final static QName _Ping_QNAME = new QName("http://service.com/", "ping");
    private final static QName _Add_QNAME = new QName("http://service.com/", "add");
    private final static QName _GetLogByRange_QNAME = new QName("http://service.com/", "getLogByRange");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Add }
     * 
     */
    public Add createAdd() {
        return new Add();
    }

    /**
     * Create an instance of {@link GetLogByRange }
     * 
     */
    public GetLogByRange createGetLogByRange() {
        return new GetLogByRange();
    }

    /**
     * Create an instance of {@link AddResponse }
     * 
     */
    public AddResponse createAddResponse() {
        return new AddResponse();
    }

    /**
     * Create an instance of {@link GetLog }
     * 
     */
    public GetLog createGetLog() {
        return new GetLog();
    }

    /**
     * Create an instance of {@link GetLogByRangeResponse }
     * 
     */
    public GetLogByRangeResponse createGetLogByRangeResponse() {
        return new GetLogByRangeResponse();
    }

    /**
     * Create an instance of {@link Ping }
     * 
     */
    public Ping createPing() {
        return new Ping();
    }

    /**
     * Create an instance of {@link GetLogResponse }
     * 
     */
    public GetLogResponse createGetLogResponse() {
        return new GetLogResponse();
    }

    /**
     * Create an instance of {@link PingResponse }
     * 
     */
    public PingResponse createPingResponse() {
        return new PingResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.com/", name = "pingResponse")
    public JAXBElement<PingResponse> createPingResponse(PingResponse value) {
        return new JAXBElement<PingResponse>(_PingResponse_QNAME, PingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLogResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.com/", name = "getLogResponse")
    public JAXBElement<GetLogResponse> createGetLogResponse(GetLogResponse value) {
        return new JAXBElement<GetLogResponse>(_GetLogResponse_QNAME, GetLogResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.com/", name = "addResponse")
    public JAXBElement<AddResponse> createAddResponse(AddResponse value) {
        return new JAXBElement<AddResponse>(_AddResponse_QNAME, AddResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLog }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.com/", name = "getLog")
    public JAXBElement<GetLog> createGetLog(GetLog value) {
        return new JAXBElement<GetLog>(_GetLog_QNAME, GetLog.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLogByRangeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.com/", name = "getLogByRangeResponse")
    public JAXBElement<GetLogByRangeResponse> createGetLogByRangeResponse(GetLogByRangeResponse value) {
        return new JAXBElement<GetLogByRangeResponse>(_GetLogByRangeResponse_QNAME, GetLogByRangeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ping }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.com/", name = "ping")
    public JAXBElement<Ping> createPing(Ping value) {
        return new JAXBElement<Ping>(_Ping_QNAME, Ping.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Add }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.com/", name = "add")
    public JAXBElement<Add> createAdd(Add value) {
        return new JAXBElement<Add>(_Add_QNAME, Add.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLogByRange }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.com/", name = "getLogByRange")
    public JAXBElement<GetLogByRange> createGetLogByRange(GetLogByRange value) {
        return new JAXBElement<GetLogByRange>(_GetLogByRange_QNAME, GetLogByRange.class, null, value);
    }

}
