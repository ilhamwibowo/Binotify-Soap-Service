package soapservice.services;
import java.sql.*;

public class DBHandler {
    private Connection connection; //masih ngikutin referensi
    private static String DB_URL = "mysql://localhost:3306/binotify"; // ini belum tau harusnya apa
    private static String DB_Username = "";
    private static String DB_Password = "";

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