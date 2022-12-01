package soapservice.services;
import javax.jws.WebMethod;
import javax.jws.WebService;

import soapservice.entities.Subscription;

@WebService
public interface SubscriptionService {
    @WebMethod
    Subscription getSubscription(int creator_id, int subscriber_id);
    
    @WebMethod
    Subscription updateSubscription(int creator_id, int subscriber_id, String status);

    @WebMethod
    boolean deleteSubscription(int creator_id, int subscriber_id);

    @WebMethod
    Subscription addSubscription(int creator_id, int subscriber_id, String status);
}
