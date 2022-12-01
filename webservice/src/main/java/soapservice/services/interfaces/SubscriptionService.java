package soapservice.services.interfaces;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import soapservice.entities.Subscription;

@WebService
public interface SubscriptionService {
    @WebMethod
    List<Subscription> getAllSubscription();

    @WebMethod
    Subscription getSubscription(int creator_id, int subscriber_id);
    
    @WebMethod
    String updateSubscription(int creator_id, int subscriber_id, String status);

    @WebMethod
    boolean addSubscription(Subscription subscription);

    @WebMethod
    List<Subscription> getSubscriptionByStatus(String status);

}
