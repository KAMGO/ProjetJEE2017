package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CategorieModele;
import pojo.Categorie;

/**
 * Servlet implementation class AfficheListeCatServlet
 */
//@WebServlet("/AfficherCategorieServlet")
public class AfficheListeCatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficheListeCatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategorieModele catModel = new CategorieModele();
		ArrayList<Categorie> listCategorie = catModel.getList();
		
		if (listCategorie.isEmpty()){
			request.setAttribute("error_message", "aucune categorie .");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/VUE/error.jsp");
			dispatcher.forward(request, response);
			response.setContentType("text/html");
		} else {
			request.setAttribute("listCategorie", listCategorie);
	        RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath() + "/ListCategorie.jsp");
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
