package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ArticleModele;
import pojo.Article;
import pojo.SousCategorie;

/**
 * Servlet implementation class AfficleArticles
 */
@WebServlet("/AfficleArticles")
public class AfficleArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficleArticles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String maSousCategorie = request.getParameter("maSousCategorie");

		ArticleModele articleM = new ArticleModele();
		ArrayList<Article> listeArticles = articleM.getListArticlesSousCategorie(maSousCategorie);
		//ArrayList<Article> listeArticles = articleM.getList();
		System.out.println(maSousCategorie+"taille de la liste : "+ listeArticles.size());
		
		request.setAttribute("listeArticles", listeArticles);
		request.setAttribute("maSousCategorie", maSousCategorie);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/VUE/AfficleListArticle.jsp");
        dispatcher.forward(request, response); 
		response.setContentType("text/html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
