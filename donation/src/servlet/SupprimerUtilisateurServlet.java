package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UtilisateurModele;
import pojo.Utilisateur;

/**
 * Servlet implementation class SupprimerUtilisateurServlet
 */
@WebServlet("/SupprimerUtilisateurServlet")
public class SupprimerUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerUtilisateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pseudo = request.getParameter("form-pseudo");
		String nomCategorie = request.getParameter("form-hidden-cat1");
		UtilisateurModele utilisateurModele = new UtilisateurModele();
		// Je récupère l'utilisateur grâce à son pseudo
		Utilisateur utilisateurSup = new Utilisateur();
		utilisateurSup = utilisateurModele.getUtilisateur(pseudo);
		if(utilisateurSup!=null) {
			//Récupère la session
			HttpSession session = request.getSession();
			if(!session.isNew()){
				Utilisateur utilisateurC = (Utilisateur) session.getAttribute("utilisateur");
				//Si le type de l'utilisateur est admin et que son pseudo n'est pas lui-même
				if(utilisateurC.getStatut().equals("Admin") 
						&& !(utilisateurC.getPseudo().equals(utilisateurSup.getPseudo()))){
					utilisateurModele.supprimerrUtilisateur(utilisateurSup);
					String completeURL = request.getContextPath() + "/AfficheListeSousCat" 
							+ "?&nomCategorie=" + nomCategorie+ "&statut="+utilisateurC.getStatut();
					response.sendRedirect(completeURL);
					}
				else { 
					request.setAttribute("error_message", "Vous n'avez pas les droits pour supprimer une personne.");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/VUE/error.jsp");
					dispatcher.forward(request, response);
					response.setContentType("text/html");
				}
			}
			else{
				request.setAttribute("error_message", "Vous n'êtes pas connecté.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/VUE/error.jsp");
				dispatcher.forward(request, response);
				response.setContentType("text/html");
				}
			}
		else{
			request.setAttribute("error_message", "verifier l'orthographe du pseudo ou alors cette utilisateur n existe");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/VUE/error.jsp");
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
