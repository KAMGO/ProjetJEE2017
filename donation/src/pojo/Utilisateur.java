package pojo;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Utilisateur implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * Variables
	 */
	private int 	idUtilisateur;
	private String 	pseudo;
	private String 	motdepasse;
	private String 	nom;
	private String 	prenom;
	private Date 	dateNaissance;
	private String 	mail;
	private String 	statut;
	
	/**
	 * Getters and setters
	 */
	@XmlAttribute
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	@XmlElement
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	@XmlElement
	public String getMotdepasse() {
		return motdepasse;
	}
	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
	@XmlElement
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@XmlElement
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	@XmlElement
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	@XmlElement
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@XmlElement
	public String getStatut() {
		return this.statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	
	/**
	 * Constructeur vide
	 */
	
	public Utilisateur(){}
	/**
	 * Constructeur de la classe User
	 * @param idUtilisateur
	 * @param pseudo
	 * @param motdepasse
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @param mail
	 * @param statut
	 */
	public Utilisateur(int idUtilisateur, String pseudo, String motdepasse, String nom, String prenom, Date dateNaissance, String mail, String statut) {
		this.idUtilisateur		= idUtilisateur;
		this.pseudo				= pseudo;
		this.motdepasse 		= motdepasse;
		this.nom 				= nom;
		this.prenom 			= prenom;
		this.dateNaissance 		= dateNaissance;
		this.statut				= statut;
		this.mail 				= mail;
	}
	public Utilisateur(String pseudo, String motdepasse, String nom, String prenom,String mail, String statut) {
		this.pseudo				= pseudo;
		this.motdepasse 		= motdepasse;
		this.nom 				= nom;
		this.prenom 			= prenom;
		this.statut				= statut;
		this.mail 				= mail;
	}
	@Override
	public boolean equals(Object obj) {
		Utilisateur utilisateur;
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		} else {
			utilisateur = (Utilisateur) obj;
			if (utilisateur.getPseudo().equals(this.getPseudo())
					&& utilisateur.getMotdepasse().equals(this.getMotdepasse())
					&& utilisateur.getNom().equals(this.getNom())
					&& utilisateur.getPrenom().equals(this.getPrenom())
					&& utilisateur.getMail().equals(this.getMail())
					&& utilisateur.getStatut().equals(this.getStatut())) {
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public int hashCode() {
		return this.getPseudo().hashCode() + this.getMotdepasse().hashCode() + this.getNom().hashCode()
				+ this.getPrenom().hashCode() + this.getMail().hashCode()
				+ this.getStatut().hashCode();
	}
}
