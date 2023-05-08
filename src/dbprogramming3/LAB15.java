
package dbprogramming3;

import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LAB15{
public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/mydb3";
        String username = "root"; //in sql
        String password = "mysql@sit";
            
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");
            Connection con = DriverManager.getConnection(URL, username, password); //create obj connect database
            System.out.println("Database Connected");
            Statement statement= con.createStatement();
            String sql = "select * from Student"; //select
            statement.executeQuery(sql); //pull data / select
            ResultSet result = statement.executeQuery(sql);
            
            ResultSetMetaData reMetaData = result.getMetaData();
            System.out.println(reMetaData.getColumnCount());
            for (int i = 1; i < 6; i++) { //i<reMetaData.getColumnCount
                System.out.println(reMetaData.getColumnName(i));
        }
            while(result.next()){
                for (int i = 1; i < reMetaData.getColumnCount(); i++) {
                    System.out.printf("%-12s\t", result.getObject(i));
                    System.out.println();
                }
            } 
            
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(LAB15.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(LAB15.class.getName()).log(Level.SEVERE, null, ex);
    }
            
            
    }        
}