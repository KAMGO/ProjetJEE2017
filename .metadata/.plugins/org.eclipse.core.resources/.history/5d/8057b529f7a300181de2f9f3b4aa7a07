package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ArticleModele;
import model.SousCategorieModele;
import pojo.Article;
import pojo.SousCategorie;

/**
 * Servlet implementation class SauvegarderArticleServlet
 */
@WebServlet("/SauvegarderArticleServlet")
public class SauvegarderArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SauvegarderArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String nomArticle 	= request.getParameter("nomArticle");
		String souscategorie 	= request.getParameter("nomSousCategorie");
		SousCategorieModele sousCatM       = new SousCategorieModele();
		SousCategorie cat = sousCatM.getSousCat(souscategorie);
		ArticleModele articleM = new ArticleModele();
		Article article = articleM.getArticleComplet1(cat, nomArticle);
		if(article!=null) {
			article.setEtat(0);
			if(!articleM.modifierArticle(article)) {
				request.setAttribute("info_message", "contacter le donateur<h2>  "+article.getUtilisateur().getPrenom()+ " </h2>  Via son addresse mail :<h2> "+article.getUtilisateur().getMail()+" </h2> afin d'entre en possesion de l article");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/VUE/error.jsp");
				dispatcher.forward(request, response);
				response.setContentType("text/html");
			}
			else {
				request.setAttribute("error_message", " probleme de connexion pendant la modification de l'etat.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/VUE/error.jsp");
				dispatcher.forward(request, response);
				response.setContentType("text/html");
				}
		}
		else {
			request.setAttribute("error_message", "L'article n'existe pas.");
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
