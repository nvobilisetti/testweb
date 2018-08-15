package com.nareen.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestUri = request.getRequestURI();
		System.out.println(requestUri);
		RequestDispatcher rd =  request.getRequestDispatcher("http://localhost:9090/TestJSPWeb/index.jsp");
		if(requestUri.indexOf("/Login.do")>0)
		{
			rd = request.getRequestDispatcher("/Login");
		}
		else if(requestUri.indexOf("/Logout.do")>0)
		{
			rd = request.getRequestDispatcher("/LogoutServlet");
		}
		else if(requestUri.indexOf("/Summary.do")>0)
		{
			Car x = new Car();
			x.setMake("BMW");
			x.setYear("2017");
			x.setModel("A6");
			request.getSession().setAttribute("mycar2", x);
			
			rd = request.getRequestDispatcher("/index.jsp");
		}
		System.out.println("Dispatching request");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
