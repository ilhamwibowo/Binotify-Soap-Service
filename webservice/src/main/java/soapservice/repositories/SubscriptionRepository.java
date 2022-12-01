package soapservice.repositories;
import soapservice.entities.Subscription;
import java.util.List;



public interface SubscriptionRepository {
    
    List<Subscription> getAllSubscription();

    Subscription getSubscription(int creator_id, int subscriber_id);
    
    Subscription updateSubscription(int creator_id, int subscriber_id, String status);

    boolean deleteSubscription(int creator_id, int subscriber_id);

    Subscription addSubscription(int creator_id, int subscriber_id, String status);
}
