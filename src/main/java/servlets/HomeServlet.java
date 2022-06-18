package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Article;
import models.Category;
import models.Commande;
import models.Supplier;
import models.Vente;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet({"/home" }) 
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Category> allCategories = new ArrayList<Category>();
	private ArrayList<Article> allArticles = new ArrayList<Article>();
	private ArrayList<Commande> allCommandes = new ArrayList<Commande>();
	private ArrayList<Supplier> allSuppliers = new ArrayList<Supplier>();
	private ArrayList<Vente> allVentes = new ArrayList<Vente>();
	double somme_total_vente = 0 ;
    double somme_total_achat = 0 ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// System.out.println(request.getServletPath());
		HttpSession session = request.getSession() ;
		if (session.getAttribute("allCategories") != null && session.getAttribute("allSuppliers") != null) {
			allCategories = (ArrayList<Category>) session.getAttribute("allCategories") ;
			allArticles = (ArrayList<Article>) session.getAttribute("allArticles") ;
			allCommandes = (ArrayList<Commande>) session.getAttribute("allCommandes") ;
			allSuppliers = (ArrayList<Supplier>) session.getAttribute("allSuppliers") ;
			allVentes = (ArrayList<Vente>) session.getAttribute("allVentes") ;
		   
		    allVentes.forEach(vente -> {
		    	somme_total_vente += vente.getTotal_price() ;
		    }) ;
		    allCommandes.forEach(achat -> {
		    	somme_total_achat += achat.getTotal_price() ;
		    }) ;
		}
		request.setAttribute("allCategories", allCategories) ;
		request.setAttribute("allArticles", allArticles) ;
		request.setAttribute("allCommandes", allCommandes) ;
		request.setAttribute("allSuppliers", allSuppliers) ;
		request.setAttribute("allVentes", allVentes) ;
		request.setAttribute("total_somme_caisse", somme_total_vente - somme_total_achat) ;
		request.getRequestDispatcher("welcome.jsp").forward(request, response) ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
