package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Supplier;

/**
 * Servlet implementation class SupplierServlet
 */
@WebServlet({ "/ajouter-fournisseur", "/liste-fournisseur", "/enregistrer-fournisseur", "/supprimer-fournisseur", "/detail-fournisseur", "/modifier-fournisseur", "/update-fournisseur" })
public class SupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Supplier> allSuppliers = new ArrayList<Supplier>();
	private Supplier supplierDetail ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// System.out.println(request.getServletPath());
		if (request.getServletPath().contains("liste")) {
			request.setAttribute("allSuppliers", allSuppliers) ;
			request.getRequestDispatcher("WEB-INF/supplier/supplier-list.jsp").forward(request, response);
		} else if (request.getServletPath().contains("ajouter")) {
			request.getRequestDispatcher("WEB-INF/supplier/supplier-add.jsp").forward(request, response);
		} else if (request.getServletPath().contains("modifier")) {
			request.setAttribute("supplierDetail", supplierDetail) ;
			request.getRequestDispatcher("WEB-INF/supplier/supplier-edit.jsp").forward(request, response);
		} else if (request.getServletPath().contains("detail")) {
			allSuppliers.forEach(supplier -> {
				if (supplier.getId() == Integer.parseInt(request.getParameter("id")) ) {
					supplierDetail = supplier ;
				}
			}) ;
			request.setAttribute("supplierDetail", supplierDetail) ;
			request.getRequestDispatcher("WEB-INF/supplier/supplier-detail.jsp").forward(request, response);
		}  else if (request.getServletPath().contains("supprimer")) {
			allSuppliers.remove(supplierDetail) ;
			request.setAttribute("allSuppliers", allSuppliers) ;
			request.getRequestDispatcher("WEB-INF/supplier/supplier-list.jsp").forward(request, response);
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getServletPath().contains("enregistrer")) {
			// TODO Auto-generated method stub
			Supplier newSupplier = new Supplier() ;
			newSupplier.setName(request.getParameter("name")) ;
			newSupplier.setEmail(request.getParameter("email")) ;
			newSupplier.setTel(request.getParameter("tel")) ;
			newSupplier.setAddress(request.getParameter("address")) ;
			allSuppliers.add(newSupplier) ;
			HttpSession session = request.getSession() ;
			session.setAttribute("allSuppliers", allSuppliers) ;
			request.setAttribute("allSuppliers", allSuppliers);
			request.getRequestDispatcher("WEB-INF/supplier/supplier-list.jsp").forward(request, response);
		} else if (request.getServletPath().contains("update")) {
			supplierDetail.setName(request.getParameter("name")) ;
			supplierDetail.setEmail(request.getParameter("email")) ;
			supplierDetail.setTel(request.getParameter("tel")) ;
			supplierDetail.setAddress(request.getParameter("address")) ;
			allSuppliers.forEach(supplier -> {
				if (supplier.getId() == Integer.parseInt(request.getParameter("id")) ) {
					supplier = supplierDetail ;
				}
			}) ;
			HttpSession session = request.getSession() ;
			session.setAttribute("allSuppliers", allSuppliers) ;
			request.setAttribute("allSuppliers", allSuppliers);
			request.getRequestDispatcher("WEB-INF/supplier/supplier-list.jsp").forward(request, response);
		}
	}

}
