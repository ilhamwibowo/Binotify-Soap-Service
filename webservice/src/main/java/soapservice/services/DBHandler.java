package soapservice.services;
import java.sql.*;

public class DBHandler {
    private Connection connection; //masih ngikutin referensi
    private static String DB_URL = "jdbc:mysql://localhost/test"; // ini belum tau harusnya apa
    private static String DB_Username = "root";
    private static String DB_Password = "bismillah99";

    public DBHandler(){ 
        try{
            System.out.println("Connecting to MYSQL DB");
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(DB_URL, DB_Username, DB_Password);
            System.out.println("Database Connected");
        }   catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on connecting to database");
        }
    
    }

    public Connection getConnection() {
        return this.connection;
    }
}