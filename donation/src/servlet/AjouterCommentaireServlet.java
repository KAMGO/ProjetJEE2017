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
			// R�cuperer les donn�es de session
			HttpSession session = request.getSession();
			System.out.println(" debut  "); 
			// r�cup�ration du commentaire dans la requ�te
			String textComm = request.getParameter("form-commentaire");
			String dateArticle =request.getParameter("date-article-hidden");
			String nomArticle 	= request.getParameter("nom-article-hidden");
			String souscategorie 	= request.getParameter("nomSouscategorie-hidden");
			System.out.println(" apres les get "+ textComm+"  "+dateArticle+ "  "+ souscategorie); 
			ArticleModele articleM = new ArticleModele();
			CommentaireModele comModele = new CommentaireModele();
			// Il faut changer le format de la date re�ue en param car celui-ci
			// est incorrect
			// 1992-12-17
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//java.util.Date d = sdf.parse(request.getParameter("date-article-hidden"));
			// 17/12/92
			//sdf.applyPattern("dd/MM/yy");
			//String nouveauFormatStringUtil = sdf.format(d);

			// Ensuite on parse cette date en date.sql
			//SimpleDateFormat formatter 	= new SimpleDateFormat("dd/MM/yy");
			//java.util.Date parsedDate = formatter.parse(dateArticle);
			//java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
			//utilisateur
			Utilisateur utilisateur 	= (Utilisateur) session.getAttribute("utilisateur");
			SousCategorieModele sousCatM       = new SousCategorieModele();
			SousCategorie cat = sousCatM.getSousCat(souscategorie);
			System.out.println(" apres  apres"+utilisateur.getNom() +" sous "+cat.getCategorie().getTitre()+ nomArticle); 
			//on recuperer l article 
			Article article = articleM.getArticleComplet(cat, nomArticle, utilisateur);
			System.out.println("bravo  titre article  "+article.getTitre()); 
			if (!session.isNew()) {
				if (!textComm.equals("")) {
					Commentaire comm = new Commentaire(article, textComm, utilisateur);
					comModele.ajouterComm(comm);
					System.out.println("bravo  comm ajouter "+textComm); 
					//http://localhost:9090/ProjetJEE-Forum/displaycomments?nomSujet=Marseille%20nul&nomSousCategorie=Football&pseudoAuteur=Adista&dateSujet=2016-12-15
					String completeURL = request.getContextPath() + "/afficheCommentaireServlet" + 
							"?&nomArticle=" + article.getTitre() +
							"&nomSousCategorie=" + article.getSousCategorie().getTitre() +
							"&pseudodonateur=" + utilisateur.getPseudo() + 
							"&dateArticle=" + dateArticle;
					out.println(completeURL);
					response.sendRedirect(completeURL);
				} else {
					request.setAttribute("error_message", "Le commentaire est vide.");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/VUE/erreur.jsp");
					dispatcher.forward(request, response);
					response.setContentType("text/html");
				}
			} else {
				request.setAttribute("error_message", "Connectez-vous.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/VUE/erreur.jsp");
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
