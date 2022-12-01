package soapservice.services;
import javax.jws.WebService;

import soapservice.entities.Subscription;
import soapservice.repositories.SubscriptionRepository;
import soapservice.services.interfaces.SubscriptionService;

import java.util.List;

import javax.jws.WebMethod;

@WebService(endpointInterface = "soapservice.services.interfaces.SubscriptionService")
public class SubscriptionServiceImpl implements SubscriptionService {
    
    private SubscriptionRepository subscriptionRepositoryImpl = new SubscriptionRepository();

    @WebMethod
    public List<Subscription> getAllSubscription() {
        return subscriptionRepositoryImpl.getAllSubscription();
    }

    @WebMethod
    public Subscription getSubscription(int creator_id, int subscriber_id) {
        return subscriptionRepositoryImpl.getSubscription(creator_id, subscriber_id);
    }
    
    @WebMethod
    public void updateSubscription(Subscription subscription) {
        subscriptionRepositoryImpl.updateSubscription(subscription);
    }

    @WebMethod
    public boolean addSubscription(Subscription subscription) {
        return subscriptionRepositoryImpl.addSubscription(subscription);
    }
}
