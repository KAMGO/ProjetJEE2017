package clientRest;


import java.io.IOException;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import serviceWeb.ServiceWeb;
//@XmlRootElement(name="article")
public class ArticleClient {
	//@XmlElement
	//public static void main(String[] args) {
		//int idsc=1,idu=1,etat=1;
		//String titre="costumes enfant";Date date= new Date();
		// try {
		  /* String reponse = ServiceWeb.getService()
			   		.path("article/ajout")
			   		.queryParam("idSousCategorie",1+"")
			   		.queryParam("titre","costume enfant")
			   		.queryParam("etat",1+"")
			   		.queryParam("dateArticle","10/09/2018")
			   		.queryParam("idUtilisateur",1+"")
					.post(String.class);
		   System.out.println(reponse.equals("ok"));*/
			
			 
			 
			 /*String reponse = ServiceWeb.getService()
				   		.path("article/modifier")
				   		.queryParam("id",21+"")
				   		.queryParam("idSousCategorie",1+"")
				   		.queryParam("titre","costume bebe")
				   		.queryParam("etat",0+"")
				   		.queryParam("dateArticle","10/09/2018")
				   		.queryParam("idUtilisateur",1+"")
						.put(String.class);
			   System.out.println(reponse.equals("ok"));*/

			/* String reponse = ServiceWeb.getService()
		   		.path("article/supprimer")
		   		.queryParam("titre","costume bebe")
		   		.queryParam("dateArticle","10/09/2018")
				.delete(String.class);
	   System.out.println(reponse.equals("ok"));*/
			 
			 /*String reponse = ServiceWeb.getService()
		   		.path("article/find")
		   		.queryParam("id", 10+"")
				.get(String.class);
		System.out.println(reponse);*/
			 
			 
			 /* String reponse = ServiceWeb.getService()
		   		.path("article/listArticle")
				.get(String.class);
	System.out.println(reponse);*/
			 		  /*}
		   catch(Exception e){System.out.println(e.getMessage());}
	}*/
}
