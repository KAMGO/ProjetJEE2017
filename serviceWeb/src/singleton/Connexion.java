package singleton;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	private static Connection instance = null;
	private Connexion(){
		try{
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@char-oracle11.condorcet.be:1521:xe";
			instance = DriverManager.getConnection(url,"ora38","root1234");
		}
		catch(ClassNotFoundException ex){
			System.out.println("Classe de driver introuvable : " + ex.getMessage());
		}
		catch (SQLException ex) {
			System.out.println("Erreur JDBC : " + ex.getMessage());
		}
		if (instance == null) {
			System.out.println("pas d acces a La base de donnees");
        }
	}
	public static Connection getInstance() {
		if(instance == null){
			new Connexion();
		}
		return instance;
	}
}