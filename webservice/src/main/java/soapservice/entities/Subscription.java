package soapservice.entities;

public class Subscription {
    private int creator_id;
    private int subscriber_id;
    private String status;

    public Subscription(int creator_id, int subscriber_id, String status) {
        this.creator_id = creator_id;
        this. subscriber_id = subscriber_id;
        this.status = status;
    }

    void setCreatorId(int creator_id) {
        this.creator_id = creator_id;
    }

    void setSubscriberId(int subscriber_id) {
        this.subscriber_id = subscriber_id;
    }

    void setStatus(String status) {
        this.status = status;
    }

    int getCreatorId() {
        return this.creator_id;
    }

    int getSubscriberId() {
        return this.subscriber_id;
    }

    String getStatus() {
        return this.status;
    }
}
