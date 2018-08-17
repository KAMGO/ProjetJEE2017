package model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SousCategorie implements Serializable {
	private static final long serialVersionUID = 1L;
	private int 		idSousCategorie;
	private Categorie 	categorie;
	private String 		titre;
	
	/**
	 * Getters et setters
	 */
	@XmlAttribute
	public int getID() {
		return idSousCategorie;
	}
	public void setID(int idSousCategorie) {
		this.idSousCategorie = idSousCategorie;
	}
	@XmlElement
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	@XmlElement
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	/**
	 * Constructeur vide
	 */
	public SousCategorie() { }

	/**
	 * Constructeur
	 * @param idSousCategorie
	 * @param categorie
	 * @param titre
	 * @param icone
	 */
	public SousCategorie(int idSousCategorie, Categorie categorie, String titre) {
		this.setID(idSousCategorie);
		this.setCategorie(categorie);
		this.setTitre(titre);
	}
}

