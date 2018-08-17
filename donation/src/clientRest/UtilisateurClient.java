package clientRest;

import serviceWeb.ServiceWeb;

public class UtilisateurClient {
	/*public static void main(String[] args) {
		  try {*/
			 /* String reponse = ServiceWeb.getService()
				   		.path("utilisateur/ajout")
				   		.queryParam("pseudo","lavoisier")
				   		.queryParam("motDePasse","pass")
				   		.queryParam("nom","ktmj")
				   		.queryParam("prenom","joel")
				   		.queryParam("dateNaissance","10/02/2000")
				   		.queryParam("statut","user")
				   		.queryParam("mail","ktmj@yahoo.fr")
						.post(String.class);
			   System.out.println(reponse);*/
			  
				 /* String reponse = ServiceWeb.getService()
					   		.path("utilisateur/supprimer")
					   		.queryParam("pseudo","lavoisier")
							.delete(String.class);
				   System.out.println(reponse);*/
			  
				 /* String reponse = ServiceWeb.getService()
					   		.path("utilisateur/modifier")
					   		.queryParam("id",22+"")
					   		.queryParam("pseudo","lavoisier")
					   		.queryParam("motDePasse","pass")
					   		.queryParam("nom","ktmj")
					   		.queryParam("prenom","joel")
					   		.queryParam("dateNaissance","10/02/2002")
					   		.queryParam("statut","user")
					   		.queryParam("mail","ktmj@yahoo.fr")
							.put(String.class);
				   System.out.println(reponse);*/
			  
			  //la date arrive en format long 
			/*  String reponse = ServiceWeb.getService()
				   		.path("utilisateur/find")
				   		.queryParam("id",22+"")
						.get(String.class);
			   System.out.println(reponse);*/
			  
			  //ici la date arrive en format court
			/*  String reponse = ServiceWeb.getService()
				   		.path("utilisateur/listUtilisateur")
						.get(String.class);
			   System.out.println(reponse);*/
			  
			 /* }
			   catch(Exception e){System.out.println(e.getMessage());}
	}*/
}
