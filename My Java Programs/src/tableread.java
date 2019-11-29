import java.sql.*;

public class tableread {
   public static void main(String[] args) {
      try {
         Class.forName("com.ibm.db2.jcc.DB2Driver");
      } catch(ClassNotFoundException e) {
         System.out.println("Class not found "+ e);
      }
      try {
         Connection con = DriverManager.getConnection(
            "jdbc:db2://localhost:50000/SAMPLE","sriniintraining", "prime14773-");
         
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");
         
         String heading1="EMPNO";
         String heading2="FIRST NAME";
         String heading3="MIDDLE INTIALS";
         String heading4="LAST NAME";
                      
         System.out.printf("%-6s %-12s %-1s %-15s%n",heading1,heading2,heading3,heading4);
         
         while (rs.next()) {
            int empno = rs.getInt("EMPNO");
            String firstname = rs.getString("FIRSTNME");
            String midinit = rs.getString("MIDINIT");
            String lastname = rs.getString("LASTNAME");
            System.out.printf("%06d %-12s %-1s              %-15s%n",empno,firstname,midinit,lastname);
         }
      } catch(SQLException e) {
         System.out.println("SQL exception occured" + e);
      }
   }
}