package model;

import java.io.Serializable;
import java.sql.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
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
	@XmlAttribute
	public int getID() {
		return idArticle;
	}
	public void setID(int idArticle) {
		this.idArticle = idArticle;
	}
	@XmlElement
	public SousCategorie getSousCategorie() {
		return sousCategorie;
	}
	public void setSousCategorie(SousCategorie sousCategorie) {
		this.sousCategorie = sousCategorie;
	}
	@XmlElement
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	@XmlElement
	public int getEtat() {
		return this.etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	@XmlElement
	public Date getDateArticle() {
		return this.dateArticle;
	}
	public void setDateArticle(Date dateArticle) {
		this.dateArticle = dateArticle;
	}
	@XmlElement
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
}
