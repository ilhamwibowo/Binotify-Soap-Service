package soapservice.services;
import javax.jws.WebMethod;
import javax.jws.WebService;
import soapservice.configs.*;
import soapservice.services.interfaces.CheckStatus;

import java.sql.*;

@WebService(endpointInterface = "soapservice.services.interfaces.CheckStatus")
public class CheckStatusImpl implements CheckStatus {

    @WebMethod
    public String CheckStatusDB() {
        try{
            DBHandler handler = new DBHandler();
            Connection conn = handler.getConnection();
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM subscription;";
            // int count = statement.executeUpdate(sql);
            ResultSet res = statement.executeQuery(sql);
            res.next();
            return "Create table succcess with return value : " + res.getString("status");
        }catch (Exception e){
            e.printStackTrace();
            return "Something went wrong while defining table " + e.getMessage();
        }
    }

    @WebMethod
    public String HelloWorld(String name) {
        return "Hello " + name;
    }
}
