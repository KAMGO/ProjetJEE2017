package servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

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
 * Servlet implementation class inscriptionServlet
 */
@WebServlet("/inscriptionServlet")
public class inscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo 		= request.getParameter("form-username");
		String motdepasse 	= request.getParameter("form-password-register");
		String nom 			= request.getParameter("form-last-name");
		String prenom 		= request.getParameter("form-first-name");
		String mail 		= request.getParameter("form-email");
		UtilisateurModele utilisateurM = new UtilisateurModele();
		Utilisateur utilisateur1 = new Utilisateur(pseudo.toString(),motdepasse.toString(), nom.toString(), prenom.toString(),mail.toString(),"user"); 

		if(utilisateurM.inscription(utilisateur1)) {
			HttpSession session = request.getSession();
			// si pas de session, destruction et création d’une nouvelle
			if (!session.isNew()) {
				session.invalidate();
				session = request.getSession();
			}
			
			Utilisateur utilisateurC;
			utilisateurC= utilisateurM.getUtilisateur(pseudo);
			
			
			session.setAttribute("utilisateur", utilisateurC);
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/VUE/Accueil.jsp");
		    dispatcher.forward(request, response); 
			response.setContentType("text/html"); 
		} else{
			request.setAttribute("error_message", "Le pseudo saisi existe déjà.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/VUE/erreur.jsp");
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
