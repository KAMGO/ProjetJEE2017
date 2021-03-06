package REST;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import model.Categorie;
import oracle.jdbc.OracleTypes;
import singleton.Connexion;

@Path("categorie")
public class CategorieREST {
	/*Creation de la connexion DB*/
	Connection con = Connexion.getInstance();
	
	/*Cr�ation d'une categorie*/
	@POST
	@Path("ajout")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response ajoutCategorie(@QueryParam("titre") String titre)throws SQLException, ParseException {
		CallableStatement cst =con.prepareCall("{CALL INSERTCATEGORIE(?)}");
		cst.setString(1, titre);
		cst.execute();
		cst.close();
		return Response.status(Status.OK).build();
	}
	/*suprimer une categorie*/
	@DELETE
	@Path("supprimer")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response DeleteCategorie(@QueryParam("titre") String titre)throws SQLException, ParseException {
		CallableStatement cst =con.prepareCall("{CALL DELETECATEGORIE(?)}");
		cst.setString(1,titre);
		cst.execute();
		cst.close();
		return Response.status(Status.OK).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("modifier")
	public Response updateCategorie(@QueryParam("id") int id,@QueryParam("titre") String titre) throws SQLException, ParseException{
		CallableStatement cst =con.prepareCall("{CALL UPDATECATEGORIE(?,?)}");
		cst.setInt		(1, id);
		cst.setString	(2, titre);
		cst.execute();
		cst.close();
		return Response.status(Status.OK).build();
	}
	
	/*R�cup�re une categorie avec son ID pass� dans l' URL*/
	@GET
	@Path("{id}")
	@Produces(MediaType.TEXT_XML)
	public Response findCategorie(@PathParam("id") int id) throws SQLException {
		Categorie 		categorie 	= null;
		CallableStatement cst =con.prepareCall("{CALL SELECTCATEGORIE(?,?)}");
		//J'ins�re le param�tre entrant
		cst.setInt(1, id);
		//Je r�cup�re les param�tres sortants de la proc�dures stock�es
		cst.registerOutParameter(2, java.sql.Types.VARCHAR);
		cst.execute();
		categorie = new Categorie(id, cst.getString(2));
		return Response.status(Status.OK).entity(categorie).build();
	}
	@GET
	@Path("listCategorie")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listCategorie() throws SQLException, ParseException{
		Categorie categorie = null;
		ResultSet rs = null;
		ArrayList<Categorie> listCategorie	= new ArrayList<Categorie>();
		CallableStatement cst = con.prepareCall("{CALL GETLISTCATEGORIE(?)}");
		cst.registerOutParameter(1, OracleTypes.CURSOR);
		cst.execute();
		// On r�cup�re le curseur et on le cast � ResultSet
		rs = (ResultSet) cst.getObject(1);
		String reponse="{";
		while (rs.next()) {
			/*categorie = new Categorie(rs.getInt("idCategorie"), rs.getString("titre"));
			listCategorie.add(categorie);	*/
			reponse=reponse+"{\"idCategorie\":"+rs.getInt("idCategorie")+ ",\"titre\":"+ rs.getString("titre")+"},";
		}
		StringBuffer buffer = new StringBuffer(reponse);
		buffer.setCharAt(buffer.length()-1, '}');
		reponse=buffer.toString();
		return Response.status(Status.OK).entity(reponse).build();
	}
	public static Categorie findCategorie1(int id) throws SQLException {
		Connection con = Connexion.getInstance();
		Categorie 		categorie 	= null;
		CallableStatement cst =con.prepareCall("{CALL SELECTCATEGORIE(?,?)}");
		//J'ins�re le param�tre entrant
		cst.setInt(1, id);
		//Je r�cup�re les param�tres sortants de la proc�dures stock�es
		cst.registerOutParameter(2, java.sql.Types.VARCHAR);
		cst.execute();
		categorie = new Categorie(id, cst.getString(2));
		return categorie;
	}
}
