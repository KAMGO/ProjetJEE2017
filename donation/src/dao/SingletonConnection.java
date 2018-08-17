package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
	//En local
	/*private static final String DB_DRIVER 		= "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION 	= "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DB_USER 		= "forum";
	private static final String DB_PASSWORD 	= "pwd";
	///Sur le serveur de l'école
	private static final String DB_DRIVER 		= "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION 	= "jdbc:oracle:thin:@char-oracle11.condorcet.be:1521:xe";
	private static final String DB_USER 		= "ora38";
	private static final String DB_PASSWORD 	= "root123";
	private static Connection connect = getInstance();
	
	private SingletonConnection() {
		try {
			Class.forName(DB_DRIVER);
			//Class.forName(DB_DRIVER);
			connect = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
		} catch (SQLException ex) {
			System.out.println("Erreur JDBC: " + ex.getMessage());
		} catch (ClassNotFoundException ex) {
			//System.exit(0);
			System.out.println("Erreur JDBC: " + ex.getMessage());
		}
	}

	public static Connection getInstance() {
		if (connect == null)
			new SingletonConnection();
		return connect;
	}
}*/
public static Connection getConnec(){
		
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println ("driver etablie");
		} catch (ClassNotFoundException e) {
			System.out.println ("driver not found");
			e.printStackTrace();
		}			   
 
		String hote = "char-oracle11.condorcet.be";//localhost";//
	    String URL = "jdbc:oracle:thin:@"+hote+":1521:xe";
	    String USER = "ora38";//"facsys";// 
	    String PASSWD = "root1234"; 
 
	    try {
			con =DriverManager.getConnection(URL,USER, PASSWD);
			System.out.println ("connexion  base orcl etablie");
		} catch (SQLException e) {
			System.out.println ("pas de connexion");
			e.printStackTrace();
		}
	    if(con==null) {
	    	System.out.println ("pas de connexion");
	    	return con;
	    }
	    else {
	    	return con;
	    }
	}
}
