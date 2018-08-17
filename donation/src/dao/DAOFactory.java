package dao;

import java.sql.Connection;

import pojo.Article;
import pojo.Categorie;
import pojo.Commentaire;
import pojo.SousCategorie;
import pojo.Utilisateur;

public class DAOFactory {
	protected static final Connection  conn = SingletonConnection.getConnec();
	public DAO<Utilisateur> 	getUtilisateurDAO(){ 	return new  UtilisateurDAO	(conn); }
	public DAO<Categorie> 		getCategorieDAO(){ 		return new CategorieDAO		(conn); }
	public DAO<Commentaire> 	getCommentaireDAO(){ 	return new CommentaireDAO	(conn); }
	//public DAO<Historique> 		getHistoriqueDAO(){ 	return new HistoriqueDAO	(conn); }
	public DAO<Article> 			getArticleDAO(){ 			return new ArticleDAO	 (conn); }
	public DAO<SousCategorie> 	getSousCategorieDAO(){ 	return new SousCategorieDAO	(conn); }
}