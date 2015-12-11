import java.sql.*;   // Needed for JDBC classes

/**
  This program demonstrates how to connect to
  a Java DB database using JDBC.
*/

public class TestConnection
{
   public static void main(String[] args)
   {
      // Create a named constant for the URL.
      // NOTE: This value is specific for Java DB.
      final String DB_URL = "jdbc:derby:Lab13DB";
      
      try
      {
         // Create a connection to the database.
         Connection conn = DriverManager.getConnection(DB_URL);
         System.out.println("Connection to CoffeeDB created.");

          Statement stmt = conn.createStatement();
          ResultSet results = stmt.executeQuery("select * from " + "Media");
          ResultSetMetaData rsmd = results.getMetaData();
          int numberCols = rsmd.getColumnCount();
          for (int i=1; i<=numberCols; i++)
          {
              //print Column Names
              System.out.print(rsmd.getColumnLabel(i)+"\t\t");
          }
         
         // Close the connection.
         conn.close();
         System.out.println("Connection closed.");
      }
      catch(Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }
}
