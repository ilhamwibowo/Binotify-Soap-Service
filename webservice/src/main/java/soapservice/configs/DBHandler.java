package soapservice.configs;
import java.sql.*;
import io.github.cdimascio.dotenv.Dotenv;

public class DBHandler {
    private Connection connection; //masih ngikutin referensi
    static Dotenv dotenv = Dotenv.load();

    private static String DB_URL = "jdbc:mysql://localhost/soapdb"; // ini belum tau harusnya apa
    private static String DB_Username = dotenv.get("DB_USER");
    private static String DB_Password = dotenv.get("DB_PASS");

    public DBHandler(){ 
        try{
            System.out.println(dotenv.get("DB_USER"));
            System.out.println(dotenv.get("DB_PASS"));
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