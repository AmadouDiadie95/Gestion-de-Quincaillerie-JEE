package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Category;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet({ "/ajouter-categorie", "/liste-categorie", "/enregistrer-categorie", "/supprimer-categorie", "/detail-categorie", "/modifier-categorie", "/update-categorie" })
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Category> allCategories = new ArrayList<Category>();
	private Category categoryDetail ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
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
			request.setAttribute("allCategories", allCategories) ;
			request.getRequestDispatcher("WEB-INF/category/category-list.jsp").forward(request, response);
		} else if (request.getServletPath().contains("ajouter")) {
			request.getRequestDispatcher("WEB-INF/category/category-add.jsp").forward(request, response);
		} else if (request.getServletPath().contains("modifier")) {
			request.setAttribute("categoryDetail", categoryDetail) ;
			request.getRequestDispatcher("WEB-INF/category/category-edit.jsp").forward(request, response);
		} else if (request.getServletPath().contains("detail")) {
			allCategories.forEach(categorie -> {
				if (categorie.getId() == Integer.parseInt(request.getParameter("id")) ) {
					categoryDetail = categorie ;
				}
			}) ;
			request.setAttribute("categoryDetail", categoryDetail) ;
			request.getRequestDispatcher("WEB-INF/category/category-detail.jsp").forward(request, response);
		} else if (request.getServletPath().contains("supprimer")) {
			allCategories.remove(categoryDetail) ;
			request.setAttribute("allCategories", allCategories) ;
			request.getRequestDispatcher("WEB-INF/category/category-list.jsp").forward(request, response);
		}  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getServletPath().contains("enregistrer")) {
			// TODO Auto-generated method stub
			Category newCategory = new Category();
			newCategory.setName(request.getParameter("name"));
			newCategory.setDescription(request.getParameter("description"));
			newCategory.setNumber_of_article(0);
			allCategories.add(newCategory);
			// System.out.println(allCategories.toString()) ;
			request.setAttribute("allCategories", allCategories);
			request.getRequestDispatcher("WEB-INF/category/category-list.jsp").forward(request, response);
			
		} else if (request.getServletPath().contains("update")) {
			
			categoryDetail.setName(request.getParameter("name")) ;
			categoryDetail.setDescription(request.getParameter("description")) ;
			allCategories.forEach(categorie -> {
				if (categorie.getId() == categoryDetail.getId() ) {
					categorie = categoryDetail ;
				}
			}) ;
			request.setAttribute("allCategories", allCategories) ;
			request.getRequestDispatcher("WEB-INF/category/category-list.jsp").forward(request, response);
			
		}
	}

}
