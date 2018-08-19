package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommentaireModele;
import pojo.Commentaire;

/**
 * Servlet implementation class ModifierCommentaireServlet
 */
@WebServlet("/ModifierCommentaireServlet")
public class ModifierCommentaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierCommentaireServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	try {// Récupère les données
		String idCommentaire = request.getParameter("id-commentaire-hidden");
		String texte = request.getParameter("form-modify");
		
		if (!texte.equals("")) {
			// Instancie un commentaireModele
			CommentaireModele commentaireModele = new CommentaireModele();
		
			// Modifie le commentaire via le nouveau texte et l'id du commentaire
			//Commentaire comm = new Commentaire((Integer.parseInt(idCommentaire), texte);
			//commentaireModele.modifier();
			
			// On récupère les données pour redidriger
			//Commentaire com = CommentaireModele.getCommentaire(Integer.parseInt(idCommentaire));
			//com.setTexte(texte);
			commentaireModele.modifier(Integer.parseInt(idCommentaire),texte);
			
			Commentaire comm = CommentaireModele.getCommentaire(Integer.parseInt(idCommentaire));
			
			// Construction de l'URL de retour
			String completeURL = request.getContextPath() + "/afficheCommentaire" + 
					"?&nomArticle=" + comm.getArticle().getTitre() +
					"&nomSousCategorie=" + comm.getArticle().getSousCategorie().getTitre() +
					"&pseudoDonateurr=" + comm.getUtilisateur().getPseudo() + 
					"&dateArticle=" + comm.getArticle().getDateArticle();
			
			// Redirige
			response.sendRedirect(completeURL);
		} else {
			request.setAttribute("error_message", "Le commentaire est vide.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/VUE/error.jsp");
			dispatcher.forward(request, response);
			response.setContentType("text/html");
		}
	} catch (Exception e) {
		e.getStackTrace();
		request.setAttribute("error_message", "Modification non effectuée.");
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
