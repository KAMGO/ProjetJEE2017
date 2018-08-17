package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import pojo.Utilisateur;
import procedureStocke.ProcedureStocke;

public class UtilisateurDAO extends DAO<Utilisateur> {
	
	public UtilisateurDAO(Connection conn) {super(conn);}

	@Override
	public void create(Utilisateur user) {
		CallableStatement cst = null;
		try {
			//Appel de la procédure stockée pour ajouter un utilisateur
			cst = connect.prepareCall(ProcedureStocke.INSERTUSER);
			
			cst.setString	(1, user.getPseudo());
			cst.setString	(2, user.getMotdepasse());
			cst.setString	(3, user.getNom());
			cst.setString	(4, user.getPrenom());
			cst.setDate		(5, (Date) user.getDateNaissance());
			cst.setString	(6, user.getStatut());
			cst.setString	(7, user.getMail());
			
			cst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (cst != null) {
				try {
					cst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void delete(Utilisateur user) {
		CallableStatement cst = null;
		try {
			//Appel de la procédure stockée pour supprimer un utilisateur
			cst = connect.prepareCall(ProcedureStocke.DELETEUSER);
			cst.setString(1, user.getPseudo());	
			cst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (cst != null) {
				try {
					cst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void update(Utilisateur user) {
		CallableStatement cst = null;
		try {
			//Appel de la procédure stockée pour modifier un utilisateur
			cst = connect.prepareCall(ProcedureStocke.UPDATEUSER);
			
			cst.setString	(1, user.getPseudo());
			cst.setString	(2, user.getMotdepasse());
			cst.setString	(3, user.getNom());
			cst.setString	(4, user.getPrenom());
			cst.setDate		(5, (Date) user.getDateNaissance());
			cst.setString	(6, user.getStatut());
			cst.setString	(7, user.getMail());
			cst.setInt		(8, user.getIdUtilisateur());
			
			cst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (cst != null) {
				try {
					cst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Utilisateur find(int idUser){
		Utilisateur	user = null;
		CallableStatement 	cst = null;
		try {
			//Appel de la procédure stockée pour sélectionner un utilisateur
			cst = connect.prepareCall(ProcedureStocke.SELECTUSER);
			
			//J'insère le paramètre entrant
			cst.setInt(1, idUser);
			//Je récupère les paramètres sortants de la procédures stockées
			cst.registerOutParameter(2, java.sql.Types.VARCHAR);
			cst.registerOutParameter(3, java.sql.Types.VARCHAR);
			cst.registerOutParameter(4, java.sql.Types.VARCHAR);
			cst.registerOutParameter(5, java.sql.Types.VARCHAR);
			cst.registerOutParameter(6, java.sql.Types.DATE);
			cst.registerOutParameter(7, java.sql.Types.VARCHAR);
			cst.registerOutParameter(8, java.sql.Types.VARCHAR);

			cst.executeUpdate();
			
			user = new Utilisateur(
					idUser, 
					cst.getString	(2),
					cst.getString	(3), 
					cst.getString	(4), 
					cst.getString	(5),
					cst.getDate		(6), 
					cst.getString	(8), 
					cst.getString	(7)
				);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (cst != null) {
				try {
					cst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;
	}

	/**
	 * Récupère la liste des utilisateurs présents dans la base de données
	 * 
	 * @return listUtilisateur : liste des utilisateurs
	 */
	@Override
	public ArrayList<Utilisateur> getList() {
		Utilisateur			user = null;
		ArrayList<Utilisateur> 	listUser = new ArrayList<Utilisateur>();
		CallableStatement			cst				= null;
		ResultSet 					rs 				= null;
		try {
			cst = connect.prepareCall(ProcedureStocke.GETLISTUSER);

			cst.registerOutParameter(1, OracleTypes.CURSOR);
			cst.executeUpdate();

			// On récupère le curseur et on le cast à ResultSet
			rs = (ResultSet) cst.getObject(1);
			while (rs.next()) {
				user = new Utilisateur(
							rs.getInt	("idUser"), 
							rs.getString("pseudo"),
							rs.getString("motdepasse"), 
							rs.getString("nom"), 
							rs.getString("prenom"),
							rs.getDate	("dateNaissance"), 
							rs.getString("mail"),
							rs.getString("statut")
						);
				listUser.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (cst != null) {
				try {
					cst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return listUser;
	}
}

