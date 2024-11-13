package seminario;

import java.sql.*;

public class Database {
    static String url="jdbc:mysql://localhost:3306/bdGimnasio";
    static String user="root";
    static String pass="Kio12345";
    
    public static Connection conectar() {
        
        Connection con=null;
        try {
          con=DriverManager.getConnection(url, user, pass);
          System.out.println("conexión exitosa");
        } catch(SQLException e) {
            
            e.printStackTrace();
        } return con;
    } 
}