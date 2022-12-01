package soapservice.repositories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import soapservice.entities.Log;
import soapservice.configs.DBHandler;

public class LogRepository {
    public void insert_log(Log log) {
        String query = "INSERT INTO logging (description, IP, endpoint, requested_at) values (?, ?, ?, ?)";

        DBHandler database = new DBHandler();

        try (Connection conn = database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, log.get_description());
            System.out.print(log.get_ip());
            stmt.setString(2, log.get_ip());
            stmt.setString(3, log.get_endpoint());
            stmt.setTimestamp(4, log.get_requesttime());

            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting log into database : ", e);
        }
    }
}
