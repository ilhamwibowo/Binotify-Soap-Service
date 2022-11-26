package soapservice.services;
import javax.xml.ws.Endpoint;

public class App 
{
    public static void main( String[] args )
    {
        Endpoint.publish("http://localhost:8080/status", new CheckStatusImpl());
    }
}
