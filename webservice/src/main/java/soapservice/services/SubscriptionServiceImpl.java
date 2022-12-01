package soapservice.services;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.spi.http.HttpExchange;
import javax.servlet.http.*;
import com.sun.xml.ws.developer.JAXWSProperties;

import soapservice.entities.Log;
import soapservice.entities.Subscription;
import soapservice.repositories.LogRepository;
import soapservice.repositories.SubscriptionRepository;
import soapservice.services.interfaces.SubscriptionService;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebMethod;

@WebService(endpointInterface = "soapservice.services.interfaces.SubscriptionService")
public class SubscriptionServiceImpl implements SubscriptionService {
    
    private SubscriptionRepository subscriptionRepositoryImpl = new SubscriptionRepository();
    private LogRepository logRepository = new LogRepository();
    @Resource
    private WebServiceContext wsContext; 

    @WebMethod
    public List<Subscription> getAllSubscription() {
        long currenttime = System.currentTimeMillis();
        add_log("Mengambil seluruh data subscription", "http://localhost:3000/9999/subscription", currenttime);
        return subscriptionRepositoryImpl.getAllSubscription();
    }

    @WebMethod
    public Subscription getSubscription(int creator_id, int subscriber_id) {
        long currenttime = System.currentTimeMillis();
        String desc = "Mengambil data subscription creator_id : " + creator_id + ", subscriber id : " +subscriber_id ;
        add_log(desc, "http://localhost:3000/9999/subscription", currenttime);
        return subscriptionRepositoryImpl.getSubscription(creator_id, subscriber_id);
    }
    
    @WebMethod
    public String updateSubscription(int creator_id, int subscriber_id, String status) {
        long currenttime = System.currentTimeMillis();
        String desc = "Mengubah status subscription creator_id : " + creator_id + ", subscriber id : " +subscriber_id + ", menjadi " + status;
        add_log(desc, "http://localhost:3000/9999/subscription", currenttime);
        Subscription sub = new Subscription(creator_id, subscriber_id, status);
        subscriptionRepositoryImpl.updateSubscription(sub);
        return "hore";
    }

    @WebMethod
    public boolean addSubscription(int creator_id, int subscriber_id, String status) {
        long currenttime = System.currentTimeMillis();
        String desc = "Menambah data subscription creator_id : " + creator_id + ", subscriber id : " +subscriber_id ;
        add_log(desc, "http://localhost:3000/9999/subscription", currenttime);
        Subscription sub = new Subscription(creator_id, subscriber_id, status);
        return subscriptionRepositoryImpl.addSubscription(sub);
    }

    private String get_client_ip() {
        // System.out.println("1");
        // MessageContext mc = wsContext.getMessageContext();
        // System.out.println("2");
        // HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST); 
        // System.out.println("3");
        // System.out.println("Client IP = " + req.getRemoteAddr()); 
        
        // return req.getRemoteAddr();
        
        return "0.0.0.0";
    }

    @WebMethod
    public String checkStatus(int creator_id, int subscriber_id) {
        return subscriptionRepositoryImpl.checkStatus(creator_id, subscriber_id);
    }
    // @WebMethod
    // private String get_client_ip() {
    //     System.out.println("1");
    //     MessageContext msgx = wsContext.getMessageContext();
    //     System.out.println(msgx.get("com.sun.xml.ws.http.exchange").toString());
    //     HttpExchange exchange = (HttpExchange)msgx.get("com.sun.xml.ws.http.exchange");
    //     System.out.println("3");
    //     InetSocketAddress remoteAddress = exchange.getRemoteAddress();
    //     System.out.println("4");
    //     String remoteHost = remoteAddress.getHostName();
    //     return remoteHost;
    // }

    // private String get_client_ip() {
    //     MessageContext msgCtx = wsContext.getMessageContext();
    //     HttpExchange req = (HttpExchange) msgCtx.get(JAXWSProperties.HTTP_EXCHANGE);
    //     return req.getRemoteAddress().toString();
    // }

    private void add_log(String desc, String endpoint, long time) {
        Log log = new Log(desc,  get_client_ip(), endpoint, new java.sql.Timestamp(time));

        logRepository.insert_log(log);
    }

}
