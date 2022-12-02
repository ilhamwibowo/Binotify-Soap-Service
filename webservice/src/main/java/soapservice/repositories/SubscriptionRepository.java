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
            throw new RuntimeException("Subscription get all error", e);
        }
    }

    public List<Subscription> getSubscriptionBySubscriber(int subscriber_id) {
        String query = "SELECT * FROM subscription WHERE subscriber_id = ? AND status = 'ACCEPTED'";

        DBHandler database = new DBHandler();

        try (Connection conn = database.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, subscriber_id);

            ResultSet result = stmt.executeQuery();
            List<Subscription> subs = new ArrayList<>();

            while (result.next()) {
                Subscription subscription = new Subscription();

                subscription.setCreator_id(result.getInt("creator_id"));
                subscription.setSubscriber_id(result.getInt("Subscriber_id"));
                subscription.setStatus(result.getString("status"));

                subs.add(subscription);
            }

            return subs;

        } catch (SQLException e) {
            throw new RuntimeException("Subscription Get error", e);
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
            throw new RuntimeException("Subscription Update error", e);
        }
    }

    public boolean addSubscription(Subscription subscription) {
        String query = "INSERT INTO subscription(creator_id, subscriber_id) VALUES (?, ?)";

        DBHandler database = new DBHandler();

        try(Connection conn = database.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, subscription.getCreator_id());
            stmt.setInt(2, subscription.getSubscriber_id());

            stmt.execute();

        } catch (SQLException e) {
            System.out.println(query);
            return false;
        }
        return true;
    }


    public String checkStatus(int creator_id, int subscriber_id){
        String query = "SELECT status FROM subscription WHERE creator_id = ? AND subscriber_id = ?";

        DBHandler database = new DBHandler();

        try (Connection conn = database.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, creator_id);
            stmt.setInt(2, subscriber_id);

            ResultSet result = stmt.executeQuery();
            String status = null;

            if (result.next()) {
                status = result.getString("status");
            }

            if (status == null) {
                return "No Subscription made of this creator and subscriber";
            } else {
                if (status.equals("ACCEPTED")) {
                    return "Status Validated : (Subscribed)";
                } else {
                    return "Status Unvalid (Not subscribed) ";
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("[Repository] Subscription SQL get by id error", e);
        }
    }

    public List<Subscription> getSubscriptionByStatus(String status) {
        String query = "SELECT * FROM subscription WHERE status = ?";

        DBHandler database = new DBHandler();

        try (Connection conn = database.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, status);

            ResultSet result = stmt.executeQuery();
            List<Subscription> subs = new ArrayList<>();

            while (result.next()) {
                Subscription sub = new Subscription();

                sub.setCreator_id(result.getInt("creator_id"));
                sub.setSubscriber_id(result.getInt("Subscriber_id"));
                sub.setStatus(result.getString("status"));

                subs.add(sub);
            }

            return subs;

        } catch (SQLException e) {
            throw new RuntimeException("Subscription Get error", e);
        }
    }
}
