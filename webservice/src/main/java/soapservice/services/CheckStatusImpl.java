package soapservice.services;
import javax.jws.WebService;
import java.sql.*;

@WebService(endpointInterface = "soapservice.services.CheckStatus")
public class CheckStatusImpl implements CheckStatus {
    @Override
    public String CheckStatus(String status) {
        try{
            DBHandler handler = new DBHandler();
            Connection conn = handler.getConnection();
            Statement statement = conn.createStatement();
            String sql = "SELECT * from subscription where status = 'PENDING'";
            int count = statement. executeUpdate(sql);
            return "Create table succcess with return value " + count;
        }catch (Exception e){
            e.printStackTrace();
            return "Something went wrontg while defining table " + e.getMessage();
        }

    }
}
