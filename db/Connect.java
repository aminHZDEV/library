package db;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;



public class Connect {
     /**
     * Connect to a sample database
     */

    public static void connect(String myScript) {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        Connection conn = null;
        Statement stmt = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:"+s+"/lib.db";
            System.out.println(url);
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
            System.out.println("Connection to SQLite has been established."+ s+"/mydb.sql");
            stmt.executeUpdate(myScript);
            System.out.println("Execute : "+myScript);
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void read(String myScript) {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        Connection conn = null;
        Statement stmt = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:"+s+"/lib.db";
            System.out.println(url);
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
            System.out.println("Connection to SQLite has been established."+ s+"/mydb.sql");
            ResultSet rs = stmt.executeQuery(myScript);
            int i =0;
            System.out.println("  ID\t USERNAME\t FIRSTNAME\t LASTNAME\t");
            while ( rs.next() ) {
                i++;
                System.out.println(i+":"+rs.getInt("manager_id")+"\t\t "+rs.getString("username")+"\t\t "+rs.getString("firstname")+" \t\t "+rs.getString("lastname")+"\t\t ");
            }
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
