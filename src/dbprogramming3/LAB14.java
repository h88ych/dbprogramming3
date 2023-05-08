package dbprogramming3;
//DATABASE METADATA
import java.sql.DatabaseMetaData; //meta
import java.sql.Connection; //connection
import java.sql.DriverManager;//connection
import java.sql.SQLException;
import java.sql.Statement; //statement
import java.sql.ResultSet; //result
import java.sql.PreparedStatement; //prepare
import java.util.logging.Level;
import java.util.logging.Logger;

public class LAB14 {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/mydb3";
        String username = "root"; //in sql
        String password = "mysql@sit";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL,username,password);
            DatabaseMetaData meta = con.getMetaData();
            System.out.println("Database URL: "+meta.getURL());
            System.out.println("Database product name: " + meta.getDatabaseProductName());
            System.out.println("Database product version: " + meta.getDatabaseProductVersion());
            System.out.println("Database driver name: " + meta.getDriverName());
            System.out.println("Database driver version: " + meta.getDriverVersion());
            System.out.println("Database driver major version : " + meta.getDatabaseMajorVersion());
            System.out.println("Database driver minor version : " + meta.getDatabaseMinorVersion());
            System.out.println("Max number connection: " + meta.getMaxConnections());
            System.out.println("MaxTableNameLength : " + meta.getMaxConnections());
            System.out.println("MaxColumnsInTable : " + meta.getMaxColumnsInTable());
            con.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LAB14.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LAB14.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
}
