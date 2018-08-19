package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ArticleModele;
import model.CommentaireModele;
import model.SousCategorieModele;
import pojo.Article;
import pojo.Commentaire;
import pojo.SousCategorie;
import pojo.Utilisateur;

/**
 * Servlet implementation class AjouterCommentaireServlet
 */
@WebServlet("/AjouterCommentaireServlet")
public class AjouterCommentaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterCommentaireServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			// Récuperer les données de session
			HttpSession session = request.getSession();
			System.out.println(" debut  "); 
			// récupération du commentaire dans la requête
			String textComm = request.getParameter("form-commentaire");
			String dateArticle =request.getParameter("date-article-hidden");
			String nomArticle 	= request.getParameter("nom-article-hidden");
			String souscategorie 	= request.getParameter("nomSouscategorie-hidden");
			System.out.println(" apres les get "+ textComm+"  "+dateArticle+ "  "+ souscategorie); 
			ArticleModele articleM = new ArticleModele();
			CommentaireModele comModele = new CommentaireModele();
			Utilisateur utilisateur 	= (Utilisateur) session.getAttribute("utilisateur");
			SousCategorieModele sousCatM       = new SousCategorieModele();
			SousCategorie cat = sousCatM.getSousCat(souscategorie);
			System.out.println(" apres  apres"+utilisateur.getNom() +" sous "+cat.getCategorie().getTitre()+ nomArticle); 
			//on recuperer l article 
			Article article = articleM.getArticleComplet1(cat, nomArticle);
			System.out.println("bravo  titre article  "+article.getTitre()); 
			if (!session.isNew()) {
				if (!textComm.equals("")) {
					Commentaire comm = new Commentaire(article, textComm, utilisateur);
					comModele.ajouterComm(comm);
					System.out.println("bravo  comm ajouter "+textComm); 
					String completeURL = request.getContextPath() + "/afficheCommentaireServlet" + 
							"?&nomArticle=" + article.getTitre() +
							"&nomSousCategorie=" + article.getSousCategorie().getTitre() +
							"&pseudodonateur=" + utilisateur.getPseudo() + 
							"&dateArticle=" + dateArticle;
					out.println(completeURL);
					response.sendRedirect(completeURL);
				} else {
					request.setAttribute("error_message", "Le commentaire est vide.");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/VUE/error.jsp");
					dispatcher.forward(request, response);
					response.setContentType("text/html");
				}
			} else {
				request.setAttribute("error_message", "Connectez-vous.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/VUE/error.jsp");
				dispatcher.forward(request, response);
				response.setContentType("text/html");
			}
		} catch (Exception e) {
			e.getStackTrace();
			out.println(e.getMessage());
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
