import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Chris on 12/11/15.
 */
public class Lab13 {
    public static void main(String[] args){
        // Create a named constant for the URL.
        // NOTE: This value is specific for Java DB.
        final String DB_URL = "jdbc:derby:Lab13DB;create=true";
        try
        {
            // Create a connection to the database.
            Connection conn =
                    DriverManager.getConnection(DB_URL);


            Statement stmt  = conn.createStatement();
            try
            {
                // Drop the UnpaidOrder table.
                stmt.execute("DROP TABLE Media");
                stmt.execute("DROP TABLE Owners");
                //stmt.execute("SELECT * FROM Media");
                //System.out.println("Media table dropped.");
            }
            catch(SQLException ex) {
            }

            // If the DB already exists, drop the tables.
            dropTables(conn);

            // Build the Coffee table.
            //buildMediaTable(conn);

            //System.out.println("Tables Built");


            print(conn);
            conn.close();
        }  catch (Exception ex)
        {
            System.out.println("ERROR2: " + ex.getMessage());
        }
    }

    public static void dropTables(Connection conn)
    {
        System.out.println("Checking for existing tables.");

        try
        {
            // Get a Statement object.
            Statement stmt  = conn.createStatement();

            try
            {
                // Drop the UnpaidOrder table.
                //stmt.execute("DROP TABLE Media");
                stmt.execute("SELECT * FROM Media");
                //System.out.println("Media table dropped.");
            }
            catch(SQLException ex)
            {
                buildMediaTable(conn);
                // No need to report an error.
                // The table simply did not exist.
            }
            try
            {
                // Drop the UnpaidOrder table.
                //stmt.execute("DROP TABLE Media");
                stmt.execute("SELECT * FROM Owners");
                //System.out.println("Media table dropped.");
            }
            catch(SQLException ex)
            {
                buildOwnerTable(conn);
                // No need to report an error.
                // The table simply did not exist.
            }

        }
        catch(SQLException ex)
        {
            System.out.println("ERROR3: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    public static void buildOwnerTable(Connection conn ){
        try {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE Owners (" +
                    "FirstName VARCHAR(50),"+
                    "ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                    "LastName VARCHAR(50), "+
                    "phone CHAR (10) )"
            );
            stmt.execute("INSERT INTO Owners(FirstName,LastName,phone) VALUES (" +
                    "'Chris'," +
                    "'Grant'," +
                    "'3023447976')"
                    );
            //Only Edit below
            stmt.execute("INSERT INTO Owners(FirstName,LastName,phone) VALUES (" +
                            "'Christopher'," +
                            "'Grant'," +
                            "'3023447976')"
            );

            stmt.execute("INSERT INTO Owners(FirstName,LastName,phone) VALUES (" +
                            "'Chris'," +
                            "'Grant The Third '," +
                            "'3023447976')"
            );


            System.out.println("Owners table created & populated");

        }catch (SQLException ex)
        {
            System.out.println("ERROR4: " + ex.getMessage());
        }

    }
    public static void buildMediaTable(Connection conn)
    {
        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE Media (" +
                    "Title VARCHAR(50), " +
                    "ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                    "RDate CHAR(12)," +
                    "OwnerID INT, " +
                    "Format CHAR(15)," +
                    "Location CHAR(15)," +
                    "Ripped INT, " +
                    "PurchaseDate CHAR(12) " +
                    ")");

            //System.out.println("Where is the issue");
            stmt.execute("INSERT INTO Media(Title,RDate,OwnerID,Format,Location,Ripped,PurchaseDate) VALUES (" +
                    "'The Matrix'," +
                    "'3/31/1999'," +
                    "1," +
                    "'DVD'," +
                    "'DVDs'," +
                    "1," +
                    "'12/31/1999')");
            //Only Edit Below

            stmt.execute("INSERT INTO Media(Title,RDate,OwnerID,Format,Location,Ripped,PurchaseDate) VALUES (" +
                    "'The Matrix2'," +
                    "'3/31/1999'," +
                    "2," +
                    "'DVD'," +
                    "'DVDs'," +
                    "1," +
                    "'12/31/1999')");


            stmt.execute("INSERT INTO Media(Title,RDate,OwnerID,Format,Location,Ripped,PurchaseDate) VALUES (" +
                    "'The Matrix3'," +
                    "'3/31/1999'," +
                    "3," +
                    "'DVD'," +
                    "'DVDs'," +
                    "1," +
                    "'12/31/1999')");


            System.out.println("Media table created & populated");
        }
        catch (SQLException ex)
        {
            System.out.println("ERROR4: " + ex.getMessage());
        }
    }
    public static void print(Connection conn){
        //For you guys to do.
        try
        {
            Statement stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + "Owners");
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            ArrayList<String> fnameLname = new ArrayList<>();
            fnameLname.add("Null name");
            while(results.next())
            {
                String fname = results.getString(1);
                String lname = results.getString(3);
                fnameLname.add(fname + " " + lname);

            }

            results = stmt.executeQuery("select * from " + "Media");
            while(results.next())
            {
               String title = results.getString(1);
                int ownerID = results.getInt(4);
                String format = results.getString(5);
                String owner = fnameLname.get(ownerID);
                System.out.println(title + " " +format + " " + owner);

            }






            results.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }

        // Close the connection.

    }

}
