package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.SousCategorie;
import pojo.Utilisateur;
import model.SousCategorieModele;

/**
 * Servlet implementation class AfficheListeSousCat
 */
@WebServlet("/AfficheListeSousCat")
public class AfficheListeSousCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficheListeSousCat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur utilisateur 	= (Utilisateur) session.getAttribute("utilisateur");
		String nomCategorie = request.getParameter("nomCategorie");
		SousCategorieModele categorie = new SousCategorieModele();
		ArrayList<SousCategorie> listSousCategorie = categorie.getList(nomCategorie);
		if (listSousCategorie.isEmpty()){
			if(utilisateur.getStatut().equals("Admin")) {
				request.setAttribute("listSousCategorie", listSousCategorie);
				request.setAttribute("nomCategorie", nomCategorie);
				request.setAttribute("statut", utilisateur.getStatut());
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/VUE/AfficheListSousCat.jsp");
		        dispatcher.forward(request, response); 
				response.setContentType("text/html");
			}
			else {
				request.setAttribute("error_message", "Element vide ou non trouvé.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/VUE/error.jsp");
				dispatcher.forward(request, response);
				response.setContentType("text/html");
			}
		} else {
			request.setAttribute("listSousCategorie", listSousCategorie);
			request.setAttribute("nomCategorie", nomCategorie);
			request.setAttribute("statut", utilisateur.getStatut());
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/VUE/AfficheListSousCat.jsp");
	        dispatcher.forward(request, response); 
			response.setContentType("text/html");
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
