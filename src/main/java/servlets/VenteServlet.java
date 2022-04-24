package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Vente;

/**
 * Servlet implementation class VenteServlet
 */
@WebServlet({"/liste-vente", "/enregistrer-vente", "/supprimer-vente" })
public class VenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Vente> allVentes = new ArrayList<Vente>();
	private Vente venteToDelete = new Vente() ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VenteServlet() {
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
			allVentes.forEach(vente -> {
				if (vente.getId() == Integer.parseInt(request.getParameter("id"))) {
					venteToDelete = vente ;
				}
			}) ;
			allVentes.remove(venteToDelete) ;
		} 
		request.setAttribute("venteDetail", new Vente()) ;
		request.setAttribute("allVentes", allVentes) ;
		request.getRequestDispatcher("WEB-INF/vente/vente-list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Vente newVente = new Vente() ;
		newVente.setDate(request.getParameter("date")) ;
		newVente.setClient_name(request.getParameter("client_name")) ;
		newVente.setArticle_name(request.getParameter("article_name")) ;
		newVente.setQuantity_choiced(Integer.parseInt(request.getParameter("quantity_choiced"))) ;
		newVente.setTotal_price(Double.parseDouble( request.getParameter("total_price")) );
		allVentes.add(newVente) ;
		request.setAttribute("allVentes", allVentes) ;
		request.getRequestDispatcher("WEB-INF/vente/vente-list.jsp").forward(request, response);
	}


}
