package soapservice.services;
import javax.jws.WebService;
import soapservice.configs.*;
import java.sql.*;

@WebService(endpointInterface = "soapservice.services.CheckStatus")
public class CheckStatusImpl implements CheckStatus {

    @Override
    public String CheckStatusDB() {
        try{
            DBHandler handler = new DBHandler();
            Connection conn = handler.getConnection();
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM subcription;";
            // int count = statement.executeUpdate(sql);
            ResultSet res = statement.executeQuery(sql);
            res.next();
            return "Create table succcess with return value : " + res.getString("status");
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
