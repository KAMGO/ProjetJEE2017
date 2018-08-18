package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommentaireModele;
import pojo.Commentaire;

/**
 * Servlet implementation class afficheCommentaireServlet
 */
@WebServlet("/afficheCommentaireServlet")
public class afficheCommentaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public afficheCommentaireServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	SimpleDateFormat formatter 	= new SimpleDateFormat("dd/MM/yy");
	String nomArticle 			= request.getParameter("nomArticle");
	String nomSousCategorie 	= request.getParameter("nomSousCategorie");
	String dateArticle			= request.getParameter("dateArticle");

	CommentaireModele commentaireM 	= new CommentaireModele();
	try {
		// Il faut changer le format de la date re�ue en param car celui-ci est incorrect
		//1982-12-17
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = sdf.parse(dateArticle);
		//17/12/92
		sdf.applyPattern("dd/MM/yy");
		String nouveauFormatStringUtil = sdf.format(d);
		
		// Ensuite on parse cette date en date.sql
		java.util.Date parsedDate = formatter.parse(nouveauFormatStringUtil);
        java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
        // On r�cup�re la liste de commentaire filtr�
        ArrayList<Commentaire> listCommentaire =  commentaireM.getListCommentaire(nomArticle, nomSousCategorie, sqlDate);

		int nbrCommentaire = listCommentaire.size();

		if (listCommentaire.isEmpty() || nbrCommentaire == 0) {
			request.setAttribute("error_message", "Il n'y a pas de commentaire pour cet Article.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/VUE/erreur.jsp");
			dispatcher.forward(request, response);
			response.setContentType("text/html");
		} else {
			request.setAttribute("listeCommentaire", listCommentaire);
			request.setAttribute("nomSousCategorie", nomSousCategorie);
			request.setAttribute("dateArticle", dateArticle);
			request.setAttribute("nomArticle", nomArticle);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/VUE/AfficheListCommentaire.jsp");
			dispatcher.forward(request, response);
			response.setContentType("text/html");
		}
	} catch (ParseException e) {
		e.printStackTrace();
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
