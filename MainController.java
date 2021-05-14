package com.myapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myapp.beans.Product;
import com.myapp.services.ProductService;
//http://localhost:8298/MyApp/MainController?x=5&y=4
/**
 * Servlet implementation class MainController
 */
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }
ProductService productService;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//read the parameter page from url
		String page = request.getParameter("page"); //null: Product
		//first time when the controller is loaded, value of page is null.
		if(page==null) {
			//go to service and fetch the list
			productService=new ProductService();
			List<Product> list = productService.getList();
			request.setAttribute("list", list);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else
			if(page.equals("product")) {
				int id = Integer.parseInt(request.getParameter("id"));
				productService = new ProductService();
				Product p=null;
				try {
					p =productService.fetchProductInfoStream(id);
				}
				catch(RuntimeException ex) {
					ex.printStackTrace();
				}
				request.setAttribute("product", p);
				request.getRequestDispatcher("product.jsp").forward(request, response);
			}
			else
				doPost(request,response);
		//		int x= Integer.parseInt(request.getParameter("x"));
//		int y= Integer.parseInt(request.getParameter("y"));
//		System.out.println("x+y= "+(x+y));
		// TODO Auto-generated method stub
	//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page=request.getParameter("page");
		if(page.equals("search"));
		{
			String search =request.getParameter("search");
			productService=new ProductService();
			List<Product> list=productService.filterListBySearchQueryStream(search);
			request.setAttribute("list",list);
			request.getRequestDispatcher("index.jsp").forward(request,response);
		}
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}