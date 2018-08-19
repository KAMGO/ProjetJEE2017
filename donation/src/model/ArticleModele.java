package model;

import java.util.ArrayList;
import java.util.stream.Collectors;

import dao.DAOFactory;
import serviceWeb.ServiceWeb;
import pojo.Article;
import pojo.SousCategorie;
import pojo.Utilisateur;
public class ArticleModele {
	
	public ArrayList<Article> getList(){
		return new DAOFactory().getArticleDAO().getList();
	}
	public boolean  ajouterArticle(Article article) {
		String reponse = ServiceWeb.getService()
		   		.path("article/ajout")
		   		.queryParam("idSousCategorie",article.getSousCategorie().getID()+"")
		   		.queryParam("titre",article.getTitre())
		   		.queryParam("etat",1+"")
		   		//.queryParam("dateArticle",article.getDateArticle().toString())
		   		.queryParam("idUtilisateur",article.getUtilisateur().getIdUtilisateur()+"")
				.post(String.class);
		return reponse.compareTo("ok")==0;
	}
	public boolean  modifierArticle(Article article) {
		String reponse = ServiceWeb.getService()
		   		.path("article/modifier")
		   		.queryParam("id",article.getID()+"")
		   		.queryParam("idSousCategorie",article.getSousCategorie().getID()+"")
		   		.queryParam("titre",article.getTitre())
		   		.queryParam("etat",article.getEtat()+"")
		   		.queryParam("dateArticle",article.getDateArticle().toString())
		   		.queryParam("idUtilisateur",article.getUtilisateur().getIdUtilisateur()+"")
				.put(String.class);
		return reponse.compareTo("ok")==0;
	}
	public boolean  supprimerArticle(Article article) {
		String reponse = ServiceWeb.getService()
		   		.path("article/supprimer")
		   		.queryParam("titre",article.getTitre())
		   		.queryParam("dateArticle",article.getDateArticle().toString())
				.delete(String.class);
		return reponse.compareTo("ok")==0;
	}
	public ArrayList<Article> getListArticlesSousCategorie( String maSousCategorie){
		ArrayList<Article> listArticle = this.getList();
		ArrayList<Article> listArticle1 =new  ArrayList<Article>();
		for(Article article : listArticle) {
			if(article.getSousCategorie().getTitre().compareTo(maSousCategorie)==0&&article.getEtat()==1) {
				listArticle1.add(article);
				}
		}
		return  listArticle1;
	}
	public Article getArticleComplet(SousCategorie souscat,String titre,Utilisateur user) {
		System.out.println("je suis dans get articlecomplet"+ souscat.getTitre()+"  "+titre+"  "+user.getPrenom());
		 Article  article = null;
		 for(Article article1 : this.getList()) {
			 if(article1.getSousCategorie().getTitre().equals(souscat.getTitre()) 
						&& article1.getTitre().equals(titre)&&article1.getUtilisateur().getPseudo().equals(user.getPseudo()))
					article=article1;
			 System.out.println("je suis dans get articlecomplet"+ article1.getTitre()+"  "+titre+"  "+user.getPrenom());
		 }

			 return article;
	}
	public Article getArticleComplet1(SousCategorie souscat,String titre) {
		 Article  article = null;
		 int i = 0;
		 for(Article article1 : this.getList()) {
			 if(article1.getSousCategorie().getTitre().equals(souscat.getTitre()) 
						&& article1.getTitre().equals(titre))
			 {	article=article1;i++;}
			 System.out.println("je suis dans get articlecomplet"+ article1.getTitre()+"  "+titre+"  "); 
		 }
		 if(i!=1)
			 article=null;

			 return article;
	}
}
