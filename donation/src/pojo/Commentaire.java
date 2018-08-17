package pojo;

import java.io.Serializable;
import java.sql.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Commentaire implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * Variables
	 */
	private int idCommentaire;
	private Article article;
	private Utilisateur utilisateur;
	private String texte;
	private Date dateCommentaire;

	/**
	 * GETTERS ET SETTERS
	 */
	@XmlAttribute
	public int getID() {
		return idCommentaire;
	}
	public void setID(int idCommentaire) {
		this.idCommentaire = idCommentaire;
	}
	@XmlElement
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	@XmlElement
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	@XmlElement
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	@XmlElement
	public Date getDateCommentaire() {
		return dateCommentaire;
	}
	public void setDateCommentaire(Date dateCommentaire) {
		this.dateCommentaire = dateCommentaire;
	}
	/**
	 * Constructeurs
	 */
		/**
		 * Constructeur vide
		 */
	public Commentaire() {
	}
	
		/**
		 * Constructeur
		 * @param idCommentaire
		 * @param Article
		 * @param texte
		 * @param dateCommentaire
		 * @param utilisateur
		 */
	public Commentaire(int idCommentaire, Article article, String texte, Date dateCommentaire, Utilisateur utilisateur) {
		this.setID(idCommentaire);
		this.setArticle(article);
		this.setUtilisateur(utilisateur);
		this.setTexte(texte);
		this.setDateCommentaire(dateCommentaire);
	}
	
	public Commentaire(Article article, String texte, Utilisateur utilisateur) {
		this.setArticle(article);
		this.setUtilisateur(utilisateur);
		this.setTexte(texte);
	}
}

