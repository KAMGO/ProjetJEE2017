package pojo;

import java.io.Serializable;
import java.sql.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;




public class Article implements Serializable {
	private static final long serialVersionUID = 1L;
	private int 			idArticle;
	private SousCategorie 	sousCategorie;
	private String 			titre;
	private int              etat;
	private Date 			dateArticle;
	private Utilisateur 	utilisateur;
	
	/**
	 * Getters et setters
	 */
	public int getID() {
		return idArticle;
	}
	public void setID(int idArticle) {
		this.idArticle = idArticle;
	}
	public SousCategorie getSousCategorie() {
		return sousCategorie;
	}
	public void setSousCategorie(SousCategorie sousCategorie) {
		this.sousCategorie = sousCategorie;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getEtat() {
		return this.etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	public Date getDateArticle() {
		return this.dateArticle;
	}
	public void setDateArticle(Date dateArticle) {
		this.dateArticle = dateArticle;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	/**
	 * Constructeur vide
	 */
	public Article() { }

	/**
	 * Constructeur
	 * @param idArticle
	 * @param sousCategorie
	 * @param titre
	 * @param dateSujet
	 * @param utilisateur
	 */
	public Article(int idArticle, SousCategorie sousCategorie, String titre,int etat, Date dateArticle,
			Utilisateur utilisateur) {
		this.setID(idArticle);
		this.setSousCategorie(sousCategorie);
		this.setTitre(titre);
		this.etat=etat;
		this.setDateArticle(dateArticle);
		this.setUtilisateur(utilisateur);
	}
	public Article(SousCategorie sousCategorie, String titre ,Utilisateur utilisateur) {
		this.setSousCategorie(sousCategorie);
		this.setTitre(titre);
		this.setUtilisateur(utilisateur);
	}
	@Override
	public boolean equals(Object obj) {
		Article article;
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		} else {
			article = (Article) obj;
			if (article.getTitre().equals(this.getTitre())
					&& article.getSousCategorie().equals(this.getSousCategorie())
					&& article.getDateArticle().equals(this.getDateArticle())
					&& article.getUtilisateur().equals(this.getUtilisateur())
					&& article.getEtat()==this.getEtat()) {
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public int hashCode() {
		return this.getTitre().hashCode() 
				+ this.getSousCategorie().hashCode() 
				+ this.getDateArticle().hashCode() 
				+ this.getUtilisateur().hashCode();
	}
}
