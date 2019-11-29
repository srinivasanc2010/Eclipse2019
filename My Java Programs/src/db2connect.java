import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class db2connect {
 
    public static void main(String[] args) {
        String jdbcClassName="com.ibm.db2.jcc.DB2Driver";
        String url="jdbc:db2://localhost:50000/SAMPLE";
        String user="sriniintraining";
        String password="prime14773-";
 
        Connection connection = null;
        try {
            //Load class into memory
            Class.forName(jdbcClassName);
            //Establish connection
            connection = DriverManager.getConnection(url, user, password);
 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(connection!=null){
                System.out.println("Connected successfully.");
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
 
    }
 
}