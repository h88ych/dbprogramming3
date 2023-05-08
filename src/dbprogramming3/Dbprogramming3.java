
package dbprogramming3;
//select
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection; //connection
import java.sql.DriverManager;//connection
import java.sql.SQLException;
import java.sql.Statement; //statement
import java.sql.ResultSet; //result


public class Dbprogramming3 {

  
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
            
            while(result.next()){ //each column
                System.out.println(result.getString(1)+ " " + result.getString(2) + " " + result.getString(3) + " " + result.getString(4)); //column1
                
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dbprogramming3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Dbprogramming3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
