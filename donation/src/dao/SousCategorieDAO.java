package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;
import pojo.Categorie;
import pojo.SousCategorie;
import procedureStocke.ProcedureStocke;

public class SousCategorieDAO extends DAO<SousCategorie>{

	public SousCategorieDAO(Connection conn) { super(conn); }

	@Override
	public void create(SousCategorie sousCategorie) {
		CallableStatement cst = null;
		try {
			//Appel de la proc�dure stock�e pour cr�er une actualit�
			cst = connect.prepareCall(ProcedureStocke.INSERTSOUSCATEGORIE);

			cst.setInt		(1, sousCategorie.getCategorie().getID());
			cst.setString	(2, sousCategorie.getTitre());
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
	public void delete(SousCategorie sousCategorie) {
		CallableStatement cst = null;
		try {
			//Appel de la proc�dure stock�e pour supprimer une sous cat�gorie
			cst = connect.prepareCall(ProcedureStocke.DELETESOUSCATEGORIE);
			cst.setString(1, sousCategorie.getTitre());
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
	public void update(SousCategorie sousCategorie) {
		CallableStatement cst = null;
		try {
			//Appel de la proc�dure stock�e pour modifier une sous cat�gorie
			cst = connect.prepareCall(ProcedureStocke.UPDATESOUSCATEGORIE);
			
			cst.setInt		(1, sousCategorie.getID());
			cst.setInt		(2, sousCategorie.getCategorie().getID());
			cst.setString	(3, sousCategorie.getTitre());
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
	public SousCategorie find(int id) {
		SousCategorie 	sousCategorie 	= null;
		CallableStatement 	cst = null;
		DAO<Categorie> 	categorieDAO	 	= new DAOFactory().getCategorieDAO();
		
		try {
			//Appel de la proc�dure stock�e pour trouver une sous cat�gorie
			cst = connect.prepareCall(ProcedureStocke.SELECTSOUSCATEGORIE);
			//J'ins�re le param�tre entrant
			cst.setInt(1, id);
			//Je r�cup�re les param�tres sortants de la proc�dures stock�es
			cst.registerOutParameter(2, java.sql.Types.NUMERIC);
			cst.registerOutParameter(3, java.sql.Types.VARCHAR);
			cst.executeQuery();
			
			sousCategorie = new SousCategorie(
				id,
				categorieDAO.find	(cst.getInt(2)),
				cst.getString		(3)
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
		return sousCategorie;
	}

	@Override
	public ArrayList<SousCategorie> getList() {
		SousCategorie 				sousCategorie 	= null;
		CallableStatement 				cst 				= null;
		ResultSet 						rs 					= null;
		ArrayList<SousCategorie> 	listSousCategorie 	= new ArrayList<SousCategorie>();
		DAO<Categorie> 	 			categorieDAO 		= new DAOFactory().getCategorieDAO();
		try {
			cst = connect.prepareCall(ProcedureStocke.GETLISTSOUSCATEGORIE);

			cst.registerOutParameter(1, OracleTypes.CURSOR);
			cst.executeUpdate();

			// On r�cup�re le curseur et on le cast � ResultSet
			rs = (ResultSet) cst.getObject(1);
			while (rs.next()) {
				sousCategorie = new SousCategorie(
							rs.getInt			("idSousCategorie"), 
							categorieDAO.find	(rs.getInt("idCategorie")),
							rs.getString		("titre")
						);
				listSousCategorie.add(sousCategorie);
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
		return listSousCategorie;
	}
}
