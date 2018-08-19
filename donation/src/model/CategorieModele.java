package model;

import java.util.ArrayList;

import dao.DAOFactory;
import serviceWeb.ServiceWeb;
import pojo.Categorie;

public class CategorieModele {
	
	/**
	 * Récupère la liste des catégories
	 * @return liste des catégories
	 */
	public ArrayList<Categorie> getList(){
		return new DAOFactory().getCategorieDAO().getList();
	}
	
	public boolean ajouterCat(Categorie cat) {
		String reponse = ServiceWeb.getService()
		   		.path("categorie/ajout")
		   		.queryParam("titre",cat.getTitre())
				.post(String.class);
	   System.out.println(reponse);
	   return reponse.compareTo("OK")==0;
   }
	public boolean modifierCat(Categorie cat) {
		String reponse = ServiceWeb.getService()
		   		.path("categorie/modifier")
		   		.queryParam("id",cat.getID()+"")
		   		.queryParam("titre",cat.getTitre())
				.put(String.class);
		return reponse.compareTo("OK")==0;
	}
	public boolean supprimerCat(Categorie cat) {
		String reponse = ServiceWeb.getService()
		   		.path("categorie/supprimer")
		   		.queryParam("titre",cat.getTitre())
				.delete(String.class);
		return reponse.compareTo("OK")==0;
	}
	public Categorie getCategorie(String nomCat) {
		Categorie cat1=null;
		for(Categorie cat : this.getList()) {
			System.out.println("nom Categ  "+cat.getTitre()+"  "+ nomCat);
			if(cat.getTitre().equals(nomCat))
				cat1=cat;
		}
		return cat1;
	}
}
