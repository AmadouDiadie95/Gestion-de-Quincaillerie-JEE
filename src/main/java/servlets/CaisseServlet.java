package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Commande;

/**
 * Servlet implementation class CommandeServlet
 */
@WebServlet({"/etat-caisse", "/enregistrer-commande", "/supprimer-commande" })
public class CaisseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Commande> allCommandes = new ArrayList<Commande>();
	Commande commandeToDelete = new Commande() ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CaisseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// System.out.println(request.getServletPath());
		
		if (request.getServletPath().contains("supprimer")) {
			allCommandes.forEach(commande -> {
				if (commande.getId() == Integer.parseInt(request.getParameter("id"))) {
					commandeToDelete = commande ;
				}
			}) ;
			allCommandes.remove(commandeToDelete) ;
			
		} 
			request.setAttribute("achatDetail", new Commande()) ;
			request.setAttribute("allAchats", allCommandes) ;
			request.getRequestDispatcher("WEB-INF/caisse/etat-caisse.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Commande newCommande = new Commande() ;
		newCommande.setDate(request.getParameter("date")) ;
		newCommande.setSupplier(request.getParameter("supplier")) ;
		newCommande.setArticle_name(request.getParameter("article_name")) ;
		newCommande.setArticle_price(request.getParameter("article_price")) ;
		newCommande.setQuantity_choiced(Integer.parseInt( request.getParameter("quantity_choiced")) ) ;
		newCommande.setTotal_price(Double.parseDouble( request.getParameter("total_price")) );
		allCommandes.add(newCommande) ;
		request.setAttribute("allAchats", allCommandes) ;
		request.getRequestDispatcher("WEB-INF/caisse/etat-caisse.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("allAchats", allCommandes) ;
		request.getRequestDispatcher("WEB-INF/caisse/etat-caisse.jsp").forward(request, response);
	}

}
