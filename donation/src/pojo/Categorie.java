package pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Categorie implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * Variables
	 */
	private int idCategorie;
	private String titre;
	
	/**
	 * Getters & Setters
	 */
	@XmlAttribute
	public int getID() {
		return idCategorie;
	}
	public void setID(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	@XmlElement
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	/**
	 * Constructeurs
	 */
	public Categorie(){}
	/**
	 * 
	 * @param idCategorie
	 * @param titre
	 */
	public Categorie(int idCategorie, String titre){
		this.setID(idCategorie);
		this.setTitre(titre);
	}
	public Categorie(String titre){
		this.setTitre(titre);
	}
	
	@Override
	public boolean equals(Object obj) {
		Categorie categorie;
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		} else {
			categorie = (Categorie) obj;
			if (categorie.getTitre().equals(this.getTitre())) {
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public int hashCode() {
		return this.getTitre().hashCode();
	}
}

