package clientRest;

import org.json.JSONObject;

import serviceWeb.ServiceWeb;

public class CommentaireClient {
	/*public static void main(String[] args) {
	  try {*/
		/* String reponse = ServiceWeb.getService()
			   		.path("commentaire/ajout")
			   		.queryParam("idArticle",2+"")
			   		.queryParam("idUtilisateur",22+"")
			   		.queryParam("texte","est t il deja user ")
			   		.queryParam("dateCommentaire","10/10/2017")
					.post(String.class);
		   System.out.println(reponse);*/
		  
		 /* String reponse = ServiceWeb.getService()
		   		.path("commentaire/modifier")
		   		.queryParam("id",21+"")
		   		.queryParam("texte","est t il deja user ? ")
		   		.queryParam("dateCommentaire","18/10/2017")
				.put(String.class);
		  System.out.println(reponse);*/
		  
		/* String reponse = ServiceWeb.getService()
			   		.path("commentaire/supprimer")
			   		.queryParam("texte","or ou diamant?")
			   		.queryParam("dateCommentaire","18/08/2018")
					.delete(String.class);
			  System.out.println(reponse);*/
		  
		//date en type long
		  /*String reponse = ServiceWeb.getService()
			   		.path("commentaire/find")
			   		.queryParam("id",2+"")
					.get(String.class);
			  System.out.println(reponse);*/
		  
		  //ici la date arrive en format court
		 /* String reponse = ServiceWeb.getService()
			   		.path("commentaire/listCommentaire")
					.get(String.class);
			  System.out.println(reponse);*/
		  
		/* }
		   catch(Exception e){System.out.println(e.getMessage());}
	}*/
}
