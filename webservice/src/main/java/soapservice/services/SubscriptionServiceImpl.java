package soapservice.services;
import javax.jws.WebService;

import soapservice.entities.Subscription;
import soapservice.repositories.SubscriptionRepository;

import javax.jws.WebMethod;

@WebService(endpointInterface = "soapservice.services.SubscriptionService")
public class SubscriptionServiceImpl implements SubscriptionService {
    
    private SubscriptionRepository subscriptionRepositoryImpl;

    @WebMethod
    public Subscription getSubscription(int creator_id, int subscriber_id) {
        return subscriptionRepositoryImpl.getSubscription(creator_id, subscriber_id);
    }
    
    @WebMethod
    public Subscription updateSubscription(int creator_id, int subscriber_id, String status) {
        return subscriptionRepositoryImpl.updateSubscription(creator_id, subscriber_id, status);
    }

    @WebMethod
    public boolean deleteSubscription(int creator_id, int subscriber_id) {
        return subscriptionRepositoryImpl.deleteSubscription(creator_id, subscriber_id);
    }

    @WebMethod
    public Subscription addSubscription(int creator_id, int subscriber_id, String status) {
        return subscriptionRepositoryImpl.addSubscription(creator_id, subscriber_id, status);
    }
}
