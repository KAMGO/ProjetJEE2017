package REST;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import model.Utilisateur;
import oracle.jdbc.OracleTypes;
import singleton.Connexion;
@Path("utilisateur")
public class UtilisateurREST {
	/*Creation de la connexion DB*/
	Connection con = Connexion.getInstance();
	/*Création de l' utilisateur*/
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("ajout")
	public Response CreateUtulisateur(@QueryParam("pseudo") String pseudo,@QueryParam("motDePasse") String motDePasse,@QueryParam("nom") String nom,@QueryParam("prenom") String prenom,
			@QueryParam("statut") String statut,
			@QueryParam("mail") String mail) throws SQLException, ParseException {
	       //	Date date = new Date();

		String  dateNaissance =  LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		CallableStatement cst =con.prepareCall("{CALL INSERTUSER(?,?,?,?,?,?,?)}");
		cst.setString	(1, pseudo);
		cst.setString	(2, motDePasse);
		cst.setString	(3, nom);
		cst.setString	(4, prenom);
		cst.setString	(5, dateNaissance);
		cst.setString	(6, statut);
		cst.setString	(7, mail);
		cst.execute();
		cst.close();
		return Response.status(Status.OK).build();
	}
	@DELETE
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("supprimer")
	public Response DeleteUtilisateur(@QueryParam("pseudo") String pseudo) throws SQLException, ParseException{
		CallableStatement cst =con.prepareCall("{CALL DELETEUSER(?)}");	
		cst.setString(1, pseudo);	
		cst.execute();
		cst.close();
		return Response.status(Status.OK).build();
	}
	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("modifier")
	public Response updateUtilisateur(@QueryParam("id") int id,@QueryParam("pseudo") String pseudo,@QueryParam("motDePasse") String motDePasse,@QueryParam("nom") String nom,@QueryParam("prenom") String prenom,
			@QueryParam("dateNaissance") String dateNaissance,@QueryParam("statut") String statut,
			@QueryParam("mail") String mail) throws SQLException, ParseException {
		CallableStatement cst =con.prepareCall("{CALL UPDATEUSER(?,?,?,?,?,?,?)}");
		cst.setString	(7, pseudo);
		cst.setString	(1, motDePasse);
		cst.setString	(2, nom);
		cst.setString	(3, prenom);
		cst.setString	(4, dateNaissance);
		cst.setString	(5, statut);
		cst.setString	(6, mail);
		//cst.setInt		(8, id);
		cst.execute();
		cst.close();
		  System.out.println(pseudo);
		return Response.status(Status.OK).build();
	}
	@GET
	@Path("find")
	@Produces(MediaType.TEXT_XML)
	public Response findUtilisateur(@QueryParam(value="id") int id) throws Exception{
		Utilisateur	utilisateur = null;
		CallableStatement cst =con.prepareCall("{CALL SELECTUSER(?,?,?,?,?,?,?,?)}");
		//cst.registerOutParameter(1, OracleTypes.CURSOR);
		//J'insère le paramètre entrant
		cst.setInt(1, id);
		cst.registerOutParameter(2, java.sql.Types.VARCHAR);
		cst.registerOutParameter(3, java.sql.Types.VARCHAR);
		cst.registerOutParameter(4, java.sql.Types.VARCHAR);
		cst.registerOutParameter(5, java.sql.Types.VARCHAR);
		cst.registerOutParameter(6, java.sql.Types.DATE);
		cst.registerOutParameter(7, java.sql.Types.VARCHAR);
		cst.registerOutParameter(8, java.sql.Types.VARCHAR);
		cst.executeUpdate();
		//ResultSet rs = (ResultSet) cst.getObject(1);
		//String JsonReturn="{\n \"pseudo\" : \""+cst.getString(2)+"\" , \n \"mot de passe\" :\""+ cst.getString(3)+"\"\n }";
		//JsonReturn= convertToJSON(rs);
		utilisateur = new Utilisateur(
				id, 
				cst.getString	(2),
				cst.getString	(3), 
				cst.getString	(4), 
				cst.getString	(5),
				cst.getDate		(6), 
				cst.getString	(8), 
				cst.getString	(7)
			);
		cst.close();
		//rs.close();
		return Response.status(Status.OK).entity(utilisateur).build();
	}
	
	@GET
	@Path("listUtilisateur")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listUtilisateur() throws SQLException, ParseException{
		Utilisateur utilisateur = null;
		ResultSet rs = null;
		ArrayList<Utilisateur> listUtilisateur	= new ArrayList<Utilisateur>();
		CallableStatement cst = con.prepareCall("{CALL GETLISTUSER(?)}");
		cst.registerOutParameter(1, OracleTypes.CURSOR);
		cst.executeUpdate();
		// On récupère le curseur et on le cast à ResultSet
		rs = (ResultSet) cst.getObject(1);
		while (rs.next()) {
			utilisateur = new Utilisateur(
						rs.getInt	("idUser"), 
						rs.getString("pseudo"),
						rs.getString("motdepasse"), 
						rs.getString("nom"), 
						rs.getString("prenom"),
						rs.getDate	("dateNaissance"), 
						rs.getString("mail"),
						rs.getString("statut")
					);
			listUtilisateur.add(utilisateur);
		}
		return Response.status(Status.OK).entity(listUtilisateur).build();
	}
	
	
	/*Methode qui permet de generer un script JSON*/
	public static String convertToJSON(ResultSet resultSet) throws Exception {

		String res = "{\n";

		if (resultSet.next()) {
			int total_rows = resultSet.getMetaData().getColumnCount();
			for (int i = 0; i < total_rows; i++) {

				res += "\t\"" + resultSet.getMetaData().getColumnLabel(i + 1).toLowerCase() + "\""; // TODO +1 ?
				res += ": \"" + resultSet.getObject(i + 1) + "\",\n";
			}
		} else
			return null;

		res = res.substring(0, res.length() - 2) + "\n}";

		return res;
	}
	public static Utilisateur findUtilisateur1(int id) throws Exception{
		Utilisateur	utilisateur = null;
		Connection con = Connexion.getInstance();
		CallableStatement cst =con.prepareCall("{CALL SELECTUSER(?,?,?,?,?,?,?,?)}");
		//J'insère le paramètre entrant
		cst.setInt(1, id);
		cst.registerOutParameter(2, java.sql.Types.VARCHAR);
		cst.registerOutParameter(3, java.sql.Types.VARCHAR);
		cst.registerOutParameter(4, java.sql.Types.VARCHAR);
		cst.registerOutParameter(5, java.sql.Types.VARCHAR);
		cst.registerOutParameter(6, java.sql.Types.DATE);
		cst.registerOutParameter(7, java.sql.Types.VARCHAR);
		cst.registerOutParameter(8, java.sql.Types.VARCHAR);
		cst.execute();
		utilisateur = new Utilisateur(
				id, 
				cst.getString	(2),
				cst.getString	(3), 
				cst.getString	(4), 
				cst.getString	(5),
				cst.getDate		(6), 
				cst.getString	(8), 
				cst.getString	(7)
			);
		return utilisateur;
	}

}
