package REST;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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

import model.Commentaire;
import oracle.jdbc.OracleTypes;
import singleton.Connexion;

@Path("commentaire")
public class CommentaireREST {
	/*Creation de la connexion DB*/
	Connection con = Connexion.getInstance();
	@POST
	@Path("ajout")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response ajoutCommentaire(@QueryParam("idArticle") int idArticle, @QueryParam("idUtilisateur") int idUtilisateur, @QueryParam("texte") String texte)throws SQLException, ParseException{
		String dateCommentaire=  LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));	
		CallableStatement cst =con.prepareCall("{CALL INSERTCOMMENTAIRE(?,?,?,?)}");
			cst.setInt		(1, idArticle);
			cst.setString	(2,texte);
			cst.setString	(3, dateCommentaire);
			cst.setInt		(4, idUtilisateur);
			cst.execute();
			cst.close();
			return Response.status(Status.OK).build();
	}
	@PUT
	@Path("modifier")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response updateCommentaire(@QueryParam("id") int id, @QueryParam("texte") String texte,
			@QueryParam("dateCommentaire") String dateCommentaire)throws SQLException, ParseException{
		CallableStatement cst = con.prepareCall("{CALL UPDATECOMMENTAIRE(?,?,?)}");
		cst.setString	(1, texte);
		cst.setString	(2, dateCommentaire);
		cst.setInt		(3, id);
		cst.execute();
		cst.close();
		return Response.status(Status.OK).build();
	}
	@DELETE
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("supprimer")
	public Response DeleteCommentaire( @QueryParam("texte") String texte,@QueryParam("dateCommentaire") String dateCommentaire) throws SQLException, ParseException{
		CallableStatement cst = con.prepareCall("{CALL DELETECOMMENTAIRE(?,?)}");
		cst.setString	(1, texte);
		cst.setString	(2, dateCommentaire);
		cst.execute();
		cst.close();
		return Response.status(Status.OK).build();
	}
	@GET
	@Path("find")
	@Produces(MediaType.TEXT_XML)
	public Response findCommentaire(@QueryParam("id") int id) throws Exception{
		Commentaire commentaire = null;
		CallableStatement cst = con.prepareCall("{CALL SELECTCOMMENTAIRE(?,?,?,?,?)}");
		//J'insère le paramètre entrant
		cst.setInt(1, id);
		//Je récupère les paramètres sortants de la procédures stockées
		cst.registerOutParameter(2, java.sql.Types.NUMERIC);
		cst.registerOutParameter(3, java.sql.Types.VARCHAR);
		cst.registerOutParameter(4, java.sql.Types.DATE);
		cst.registerOutParameter(5, java.sql.Types.NUMERIC);
		cst.executeQuery();

		cst.execute();
		commentaire = new Commentaire(
				id,
				ArticleREST.findArticle1(cst.getInt(2)),
				cst.getString		(3),
				cst.getDate			(4),
				UtilisateurREST.findUtilisateur1(cst.getInt(5))
		);
		return Response.status(Status.OK).entity(commentaire).build();
	}
	@GET
	@Path("listCommentaire")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listCommentaire() throws Exception{
		Commentaire commentaire = null;
		ResultSet rs = null;
		ArrayList<Commentaire> listCommentaire	= new ArrayList<Commentaire>();
		CallableStatement cst = con.prepareCall("{CALL GETLISTCOMMENTAIRE(?)}");
		cst.registerOutParameter(1, OracleTypes.CURSOR);
		cst.execute();
		// On récupère le curseur et on le cast à ResultSet
		rs = (ResultSet) cst.getObject(1);
		String reponse="{";
		while (rs.next()) {
			commentaire = new Commentaire(
							rs.getInt	("idCommentaire"),
							ArticleREST.findArticle1(rs.getInt("idArticle")),
							rs.getString		("texte"),
							rs.getDate			("dateCommentaire"),
							UtilisateurREST.findUtilisateur1(rs.getInt("idUser"))
						);
			listCommentaire.add(commentaire);
			reponse=reponse+" { \"idCommentaire\": " + rs.getInt	("idCommentaire")+", \"article\" : "+ ArticleREST.findArticle1(rs.getInt("idArticle"))+",  \"texte\" : "+
			rs.getString("texte")+" ,  \"utilisateur\" : "+UtilisateurREST.findUtilisateur1(rs.getInt("idUser"))+" },";
		}
		StringBuffer buffer = new StringBuffer(reponse);
		buffer.setCharAt(buffer.length()-1, '}');
		reponse=buffer.toString();
		return Response.status(Status.OK).entity(reponse).build();
	}
}
