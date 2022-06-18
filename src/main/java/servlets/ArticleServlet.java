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

/**
 * Servlet implementation class ArticleServlet
 */
@WebServlet({ "/ajouter-article", "/liste-article", "/enregistrer-article", "/supprimer-article", "/detail-article", "/modifier-article", "/update-article" })
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Article> allArticles = new ArrayList<Article>();
	private Article articleDetail ;
	private ArrayList<Category> allCategories = new ArrayList<Category>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleServlet() {
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
			request.setAttribute("allArticles", allArticles) ;
			request.getRequestDispatcher("WEB-INF/article/article-list.jsp").forward(request, response);
			
		} else if (request.getServletPath().contains("ajouter")) {
			request.setAttribute("allCategories", allCategories) ;
			request.getRequestDispatcher("WEB-INF/article/article-add.jsp").forward(request, response);
			
		} else if (request.getServletPath().contains("modifier")) {
			request.setAttribute("allCategories", allCategories) ;
			request.setAttribute("articleDetail", articleDetail) ;
			request.getRequestDispatcher("WEB-INF/article/article-edit.jsp").forward(request, response);
			
		} else if (request.getServletPath().contains("detail")) {
			allArticles.forEach(article -> {
				if (article.getId() == Integer.parseInt(request.getParameter("id")) ) {
					articleDetail = article ;
				}
			}) ;
			request.setAttribute("articleDetail", articleDetail) ;
			request.getRequestDispatcher("WEB-INF/article/article-detail.jsp").forward(request, response);
		}  else if (request.getServletPath().contains("supprimer")) {
			allArticles.remove(articleDetail) ;
			request.setAttribute("allArticles", allArticles) ;
			request.getRequestDispatcher("WEB-INF/article/article-list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getServletPath().contains("enregistrer")) {
			Article newArticle = new Article() ;
			newArticle.setName(request.getParameter("name")) ;
			newArticle.setDescription(request.getParameter("description")) ;
			newArticle.setPrice(Double.parseDouble(request.getParameter("price"))) ;
			newArticle.setQuantity( Integer.parseInt( request.getParameter("quantity") ) ) ;
			newArticle.setCategory_id(Integer.parseInt( request.getParameter("category_id") )) ;
			allCategories.forEach(category -> {
				if (category.getId() == newArticle.getCategory_id()) {
					newArticle.setCategory_name(category.getName());
					category.setNumber_of_article(category.getNumber_of_article() + 1);
				}
			}) ;
			allArticles.add(newArticle) ;
			HttpSession session = request.getSession() ;
			session.setAttribute("allArticles", allArticles) ;
			request.setAttribute("allArticles", allArticles) ;
			request.getRequestDispatcher("WEB-INF/article/article-list.jsp").forward(request, response);
		} else if (request.getServletPath().contains("update")) {
			articleDetail.setName(request.getParameter("name")) ;
			articleDetail.setDescription(request.getParameter("description")) ;
			articleDetail.setPrice(Double.parseDouble(request.getParameter("price"))) ;
			articleDetail.setQuantity( Integer.parseInt( request.getParameter("quantity") ) ) ;
			articleDetail.setCategory_id(Integer.parseInt( request.getParameter("category_id") )) ;
			allCategories.forEach(category -> {
				if (category.getId() == articleDetail.getCategory_id()) {
					articleDetail.setCategory_name(category.getName());
					category.setNumber_of_article(category.getNumber_of_article() + 1);
				}
			}) ;
			allArticles.forEach(article -> {
				if (article.getId() == Integer.parseInt(request.getParameter("id")) ) {
					article = articleDetail ;
				}
			}) ;
			HttpSession session = request.getSession() ;
			session.setAttribute("allArticles", allArticles) ;
			request.setAttribute("allArticles", allArticles) ;
			request.getRequestDispatcher("WEB-INF/article/article-list.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("allArticles", allArticles) ;
		request.getRequestDispatcher("WEB-INF/article/article-list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("allArticles", allArticles) ;
		request.getRequestDispatcher("WEB-INF/article/article-list.jsp").forward(request, response);
	}

}
