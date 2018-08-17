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
import model.SousCategorie;
import oracle.jdbc.OracleTypes;
import singleton.Connexion;

@Path("sousCategorie")
public class SousCategorieREST {
	/*Creation de la connexion DB*/
	Connection con = Connexion.getInstance();
	/*Cr�ation d'une souscategorie*/
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("ajout")
	public Response ajoutsousCategorie(@QueryParam("idCategorie") int idCategorie,@QueryParam("titre") String titre)throws SQLException, ParseException {
		CallableStatement cst =con.prepareCall("{CALL INSERTSOUSCATEGORIE(?,?)}");
		cst.setInt		(1, idCategorie);
		cst.setString	(2, titre);
		cst.execute();	
		cst.close();
		return Response.status(Status.OK).build();
	}
	/*suprimer une souscategorie*/
	@DELETE
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("supprimer")
	public Response DeleteSousCategorie(@QueryParam("titre") String titre)throws SQLException, ParseException {
		CallableStatement cst =con.prepareCall("{CALL DELETESOUSCATEGORIE(?)}");
		cst.setString(1,titre);
		cst.execute();
		cst.close();
		return Response.status(Status.OK).build();
	}
	/*modifier une souscategorie*/
	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("modifier")
	public Response updateCategorie(@QueryParam("id") int id,@QueryParam("idCategorie") int idCategorie,@QueryParam("titre") String titre) throws SQLException, ParseException{
		CallableStatement cst =con.prepareCall("{CALL UPDATESOUSCATEGORIE(?,?,?)}");
		cst.setInt		(1, id);
		cst.setInt  	(2, idCategorie);
		cst.setString	(3, titre);
		cst.execute();
		cst.close();
		return Response.status(Status.OK).build();
	}
	/*R�cup�re une souscategorie avec son ID pass� dans l' URL*/
	@GET
	@Path("{id}")
	@Produces(MediaType.TEXT_XML)
	public Response findSousCategorie(@PathParam("id") int id) throws SQLException {
		SousCategorie 		sousCategorie 	= null;
		CallableStatement cst =con.prepareCall("{CALL SELECTSOUSCATEGORIE(?,?,?)}");
		//J'ins�re le param�tre entrant
		cst.setInt(1, id);
		//Je r�cup�re les param�tres sortants de la proc�dures stock�es
		cst.registerOutParameter(2, java.sql.Types.NUMERIC);
		cst.registerOutParameter(3, java.sql.Types.VARCHAR);
		cst.executeQuery();
		sousCategorie = new SousCategorie(
				id,
				CategorieREST.findCategorie1(cst.getInt(2)),
				cst.getString		(3)
			);
		return Response.status(Status.OK).entity(sousCategorie).build();
	}
	@GET
	@Path("listSousCategorie")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listSousCategorie() throws SQLException, ParseException{
		SousCategorie sousCategorie = null;
		ResultSet rs = null;
		ArrayList<SousCategorie> listSousCategorie	= new ArrayList<SousCategorie>();
		CallableStatement cst = con.prepareCall("{CALL GETLISTSOUSCATEGORIE(?)}");
		cst.registerOutParameter(1, OracleTypes.CURSOR);
		cst.execute();
		// On r�cup�re le curseur et on le cast � ResultSet
		rs = (ResultSet) cst.getObject(1);
		while (rs.next()) {
			sousCategorie = new SousCategorie(rs.getInt("idSousCategorie"),CategorieREST.findCategorie1(rs.getInt("idCategorie")),rs.getString("titre"));
			listSousCategorie.add(sousCategorie);	
		}
		return Response.status(Status.OK).entity(listSousCategorie).build();
	}
	public static SousCategorie findSousCategorie1(int id) throws SQLException {
		Connection con = Connexion.getInstance();
		SousCategorie 		sousCategorie 	= null;
		CallableStatement cst =con.prepareCall("{CALL SELECTSOUSCATEGORIE(?,?,?)}");
		//J'ins�re le param�tre entrant
		cst.setInt(1, id);
		//Je r�cup�re les param�tres sortants de la proc�dures stock�es
		cst.registerOutParameter(2, java.sql.Types.NUMERIC);
		cst.registerOutParameter(3, java.sql.Types.VARCHAR);
		cst.executeQuery();
		sousCategorie = new SousCategorie(
				id,
				CategorieREST.findCategorie1(cst.getInt(2)),
				cst.getString		(3)
			);
		return sousCategorie;
	}
}