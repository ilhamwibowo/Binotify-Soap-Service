package soapservice.entities;
import java.sql.Timestamp;

public class Log {
    private String description;
    private String ip;
    private String endpoint;
    private Timestamp requested_at;

    //constructors
    public Log(){}

    public Log(String description, String ip, String endpoint, Timestamp requested_at) {
        this.description = description;
        this.ip = ip;
        this.endpoint = endpoint;
        this.requested_at = requested_at;
    }

    //getter
    public String get_description() {
        return this.description;
    }

    public String get_ip() {
        return this.ip;
    }

    public String get_endpoint() {
        return this.endpoint;
    }

    public Timestamp get_requesttime() {
        return this.requested_at;
    }

    //setter
    public void set_description(String description) {
        this.description = description;
    }

    public void set_ip(String ip) {
        this.ip = ip;
    }

    public void set_endpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public void set_timestamp(Timestamp requested_at) {
        this.requested_at = requested_at;
    }

}
