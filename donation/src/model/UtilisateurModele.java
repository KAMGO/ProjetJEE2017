package model;

import java.util.ArrayList;

import dao.DAOFactory;
import pojo.Utilisateur;
import serviceWeb.ServiceWeb;

public class UtilisateurModele {
	
	
	public ArrayList<Utilisateur> getList(){
		return new DAOFactory().getUtilisateurDAO().getList();}
	
	public boolean ajouterUtilisateur(Utilisateur utilisateur) {	
		 String reponse = ServiceWeb.getService()
			   		.path("utilisateur/ajout")
			   		.queryParam("pseudo",utilisateur.getPseudo())
			   		.queryParam("motDePasse",utilisateur.getMotdepasse())
			   		.queryParam("nom",utilisateur.getNom())
			   		.queryParam("prenom",utilisateur.getPrenom())
			   		.queryParam("statut",utilisateur.getStatut())
			   		.queryParam("mail",utilisateur.getMail())
					.post(String.class);
		return reponse.compareTo("ok")==0;
	}
	public boolean modifierUtilisateur(Utilisateur utilisateur) {
		String reponse = ServiceWeb.getService()
		   		.path("utilisateur/modifier")
		   		.queryParam("id",utilisateur.getIdUtilisateur()+"")
		   		.queryParam("pseudo",utilisateur.getPseudo())
		   		.queryParam("motDePasse",utilisateur.getMotdepasse())
		   		.queryParam("nom",utilisateur.getNom())
		   		.queryParam("prenom",utilisateur.getPrenom())
		   		.queryParam("dateNaissance",utilisateur.getDateNaissance().toString())
		   		.queryParam("statut",utilisateur.getStatut())
		   		.queryParam("mail",utilisateur.getMail())
				.put(String.class);
		return reponse.compareTo("ok")==0;
	}
	public boolean supprimerrUtilisateur(Utilisateur utilisateur) {
		String reponse = ServiceWeb.getService()
		   		.path("utilisateur/supprimer")
		   		.queryParam("pseudo",utilisateur.getPseudo())
				.delete(String.class);
		return reponse.compareTo("ok")==0;
	}
	public Utilisateur getUtilisateur(String pseudo){
		return this.getList().stream()
				.filter(x -> x.getPseudo().equals(pseudo))
				.findAny()
				.orElse(null);
	}
	public Utilisateur connexion(String pseudo, String motdepasse){
		return this.getList()
				.stream()
				.filter(x -> x.getPseudo().equals(pseudo) 
						&& x.getMotdepasse().equals(motdepasse))
				.findAny()
				.orElse(null);
	}
	public boolean inscription(Utilisateur utilisateur){

		//Renvoie true si la condition est positive sinon false
		if(this.getList()
				.stream()
				.anyMatch(x -> x.getPseudo().equals(utilisateur.getPseudo()) 
						|| x.getMail().equals(utilisateur.getMail()))) {
			return false;
		} else {
			this.ajouterUtilisateur(utilisateur);
			return true;
		}
	}
}
