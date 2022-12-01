package soapservice.repositories;

import soapservice.entities.Subscription;
import soapservice.configs.DBHandler;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class SubscriptionRepository {
    
    public List<Subscription> getAllSubscription() {
        String query = "SELECT * FROM subscription";

        DBHandler database = new DBHandler();

        try (Connection conn = database.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
             ResultSet result = stmt.executeQuery();

             List<Subscription> subs = new ArrayList<>();

             while (result.next()) {
                Subscription sub = new Subscription();

                sub.setCreator_id(result.getInt("creator_id"));
                sub.setSubscriber_id(result.getInt("subscriber_id"));
                sub.setStatus(result.getString("status"));
                
                subs.add(sub);
             }

             return subs;

        } catch (SQLException e) {
            throw new RuntimeException("[Repository] Subscription SQL get all error, e");
        }
    }

    public Subscription getSubscription(int creator_id, int subscriber_id) {
        String query = "SELECT * FROM subscription WHERE creator_id = ? AND subscriber_id = ?";

        DBHandler database = new DBHandler();

        try (Connection conn = database.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, creator_id);
            stmt.setInt(2, creator_id);

            ResultSet result = stmt.executeQuery();
            Subscription subscription = null;

            if (result.next()) {
                subscription = new Subscription();

                subscription.setCreator_id(result.getInt("creator_id"));
                subscription.setSubscriber_id(result.getInt("Subscriber_id"));
                subscription.setStatus(result.getString("status"));
            }

            return subscription;

        } catch (SQLException e) {
            throw new RuntimeException("[Repository] Subscription SQL get by id error", e);
        }
    }
    
    public void updateSubscription(Subscription subscription) {
        String query = "UPDATE subscription SET status = ? WHERE creator_id = ? AND subscriber_id = ?";

        DBHandler database = new DBHandler();

        try(Connection conn = database.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, subscription.getStatus());
            stmt.setInt(2, subscription.getCreator_id());
            stmt.setInt(3, subscription.getSubscriber_id());

            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("[Repository] Subscription SQL update error", e);
        }
    }

    public boolean addSubscription(Subscription subscription) {
        String query = "INSERT INTO subscription(creator_id, subscriber_id) VALUES (?, ?, ?)";

        DBHandler database = new DBHandler();

        try(Connection conn = database.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, subscription.getCreator_id());
            stmt.setInt(2, subscription.getSubscriber_id());
            stmt.setString(3, subscription.getStatus());

            stmt.execute();

        } catch (SQLException e) {
            return false;
        }

        return true;
    }
}
