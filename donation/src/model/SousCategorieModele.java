package model;

import java.util.ArrayList;
import java.util.stream.Collectors;

import dao.DAOFactory;
import serviceWeb.ServiceWeb;
import pojo.SousCategorie;
public class SousCategorieModele {
	
	
	
	public ArrayList<SousCategorie> getList(){
		return new DAOFactory().getSousCategorieDAO().getList();
	}
	public boolean ajouterSousCat(int idCat,String titre) {
		 String reponse = ServiceWeb.getService()
			   		.path("sousCategorie/ajout")
			   		.queryParam("idCategorie",idCat+"")
			   		.queryParam("titre",titre)
					.post(String.class);
		return reponse.compareTo("ok")==0;
	}
	public boolean modifierSousCat(SousCategorie sousCat) {
		 String reponse = ServiceWeb.getService()
			   		.path("sousCategorie/modifier")
			   		.queryParam("id",sousCat.getID()+"")
			   		.queryParam("idCategorie",sousCat.getCategorie().getID()+"")
			   		.queryParam("titre",sousCat.getTitre())
					.put(String.class);
		   System.out.println(reponse);
		return reponse.compareTo("ok")==0;
	}
	public boolean supprimerSousCat(SousCategorie sousCat) {
		String reponse = ServiceWeb.getService()
		   		.path("sousCategorie/supprimer")
		   		.queryParam("titre",sousCat.getTitre())
				.delete(String.class);
		return reponse.compareTo("ok")==0;
	}
	public SousCategorie getSousCat(String titreSousCat){
		// Récupère le dernier élément correspondant au filter
		return this.getList()
				.stream()
				.filter(x -> x.getTitre().equals(titreSousCat))
				.reduce((first, second) -> second).get();
	}
	public ArrayList<SousCategorie> getList(String titreCat){
		return this.getList()
				.stream()
				.filter(x -> x.getCategorie().getTitre().equals(titreCat))
				.collect(Collectors.toCollection(ArrayList::new));
	}
}
