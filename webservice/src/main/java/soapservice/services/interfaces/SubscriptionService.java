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
    List<Subscription> getSubscriptionBySubscriber(int subscriber_id);
    
    @WebMethod
    String updateSubscription(int creator_id, int subscriber_id, String status);

    @WebMethod
    boolean addSubscription(int creator_id, int subscriber_id, String status);

    @WebMethod
    List<Subscription> getSubscriptionByStatus(String status);

}
