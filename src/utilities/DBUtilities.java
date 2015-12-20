package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtilities {
	private static Connection db_conn;
	
	public static Connection getConnection() {
        if( db_conn != null )
            return db_conn;
 
        InputStream inputStream = DBUtilities.class.getClassLoader().getResourceAsStream( "/db.properties" );
        Properties properties = new Properties();
        try {
            properties.load( inputStream );
            String driver = properties.getProperty( "driver" );
            String url = properties.getProperty( "url" );
            String user = properties.getProperty( "user" );
            String password = properties.getProperty( "password" );
            Class.forName( driver );
            db_conn = DriverManager.getConnection( url, user, password );
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return db_conn;
    }
}
