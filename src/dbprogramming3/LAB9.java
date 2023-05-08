
package dbprogramming3;
//insert
import java.sql.Connection; //connection
import java.sql.DriverManager;//connection
import java.sql.SQLException;
import java.sql.Statement; //statement
import java.sql.ResultSet; //result
import java.util.logging.Level;
import java.util.logging.Logger;

public class LAB9 {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/mydb3";
        String username = "root"; //in sql
        String password = "mysql@sit";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //load driver
            Connection con = DriverManager.getConnection(URL, username, password); //create obj connect database
            
            Statement statement= con.createStatement();
            
            String sql = "insert into student(studentID,firstName,lastName,email,deptID)"
                       + "values('086' , 'Hathaitat' , 'Yamchomchuen' , 'hathaitat88@gmail.com' , 'IT')"; //insert
//            statement.execute(sql); //boolean
            statement.executeUpdate(sql); //!!! use update for insert
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LAB9.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LAB9.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
}
