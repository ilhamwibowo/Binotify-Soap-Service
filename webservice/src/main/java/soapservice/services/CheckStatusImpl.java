package soapservice.services;
import javax.jws.WebService;
import java.sql.*;

@WebService(endpointInterface = "soapservice.services.CheckStatus")
public class CheckStatusImpl implements CheckStatus {
    @Override
    public String CheckStatus() {
        try{
            DBHandler handler = new DBHandler();
            Connection conn = handler.getConnection();
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM status";
            int count = statement.executeUpdate(sql);
            return "Create table succcess with return value : " + count;
        }catch (Exception e){
            e.printStackTrace();
            return "Something went wrong while defining table " + e.getMessage();
        }
    }

    @Override
    public String HelloWorld(String name) {
        return "Hello " + name;
    }
}
