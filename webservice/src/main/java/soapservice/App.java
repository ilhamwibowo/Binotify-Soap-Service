package soapservice;
import javax.xml.ws.Endpoint;

import soapservice.services.CheckStatusImpl;
import soapservice.services.SubscriptionServiceImpl;


public class App 
{
    public static void main(String[] args)
    {
        Endpoint.publish("http://localhost:9999/webservice/status", new CheckStatusImpl());

        Endpoint.publish("http://localhost:9999/webservice/subscription", new SubscriptionServiceImpl());
    }
}

