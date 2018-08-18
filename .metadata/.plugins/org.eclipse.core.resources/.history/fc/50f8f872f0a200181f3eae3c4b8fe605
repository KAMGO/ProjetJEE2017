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
			System.out.println("je suis dans le if de article model "+article.getTitre()+"  taille  "+listArticle.size());
			if(article.getSousCategorie().getTitre().compareTo(maSousCategorie)==0) {
				listArticle1.add(article);
				}
		}
		return  listArticle1;
	}
	public Article getArticleComplet(SousCategorie souscat,String titre,Utilisateur user) {
		return this.getList()
				.stream()
				.filter(x -> x.getSousCategorie().getTitre().equals(souscat.getTitre()) 
						&& x.getTitre().equals(titre)&&x.getUtilisateur().getPseudo().equals(user.getPseudo()))
				.findAny()
				.orElse(null);
	}
}
