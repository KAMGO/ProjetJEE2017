package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CategorieModele;
import model.SousCategorieModele;
import pojo.Categorie;
import pojo.Utilisateur;

/**
 * Servlet implementation class AjouterSousCategorieServlet
 */
@WebServlet("/AjouterSousCategorieServlet")
public class AjouterSousCategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterSousCategorieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur utilisateur 	= (Utilisateur) session.getAttribute("utilisateur");
		String nomCategorie = request.getParameter("form-hidden-cat");
		String titreSousCategorie = request.getParameter("form-SousCategorie");
		CategorieModele catM = new CategorieModele();
		System.out.println("nom Categ  "+nomCategorie);
		SousCategorieModele souscatM = new SousCategorieModele();
		Categorie cat=catM.getCategorie(nomCategorie);
		if(titreSousCategorie.equals("")) {
			request.setAttribute("error_message", " le champs titre Categorie est vide ");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/VUE/error.jsp");
			dispatcher.forward(request, response);
			response.setContentType("text/html");	
		}
		else {
			if(cat!=null) {
				souscatM.ajouterSousCat(cat.getID(),titreSousCategorie);
				String completeURL = request.getContextPath() + "/AfficheListeSousCat" 
						+ "?&nomCategorie=" + nomCategorie+ "&statut="+utilisateur.getStatut();
				response.sendRedirect(completeURL);
			}
			else {
				request.setAttribute("error_message", "probleme avec la base de donnee.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/VUE/error.jsp");
				dispatcher.forward(request, response);
				response.setContentType("text/html");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
