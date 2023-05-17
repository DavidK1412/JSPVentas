package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.*;
import org.json.simple.parser.*;

public class Connector {
    
    private static Connector instance;
    private Connection cnn;
    
    private Connector() {
        JSONParser parser = new JSONParser();
        try{
            String credentialsPath = "C:\\Users\\USUARIO\\OneDrive - Universidad Distrital Francisco José de Caldas\\Documentos\\JSPVentas\\src\\java\\utils\\credentials.json";
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(credentialsPath));
            String host = (String)jsonObject.get("db_ip");
            String port = (String)jsonObject.get("db_port");
            String username = (String)jsonObject.get("db_user");
            String password = (String)jsonObject.get("db_password");
            String name = (String)jsonObject.get("db_name");
            String dbURL = "jdbc:mysql://"+host+":"+port+"/" + name;
            System.out.println("dbURL = " + dbURL);
            System.out.println("username + password = " + username + password);
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnn = DriverManager.getConnection(dbURL, username, password);
        } catch( SQLException | FileNotFoundException ex ) {
            ex.printStackTrace();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("error en driver bd " + ex.getMessage());
        }
    }
    
    public static synchronized Connector getInstance() {
        instance = instance == null ? new Connector() : instance;
        return instance;
    }
    
    public void closeConnection() {
        instance = null;
    }
    
    public Connection getConn() {
        return cnn;
    }
    
    public void setCnn(Connection cnn){
        this.cnn = cnn;
    }
    
}
