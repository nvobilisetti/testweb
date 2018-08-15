package com.nareen.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class HelloWorld
 */
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String title = "XYZ";
	private String address = "";

    /**
     * Default constructor. 
     */
    public HelloWorld() {
        // TODO Auto-generated constructor stub
    }
    
    
    public void init(ServletConfig config)
    {
    	title = config.getInitParameter("title");
    	address = config.getInitParameter("address");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Theater : " ).append(title).append("\n");
		
		response.getWriter().append("Served at: ").append(request.getContextPath()).append("\n");
		
		response.getWriter().append(address).append("\n");
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(5); // IN Seconds
		
		
		Car mycar = new Car();
		mycar.setMake("Audi");
		mycar.setModel("A4");
		mycar.setYear("2015");
		
		session.setAttribute("mycar2", mycar);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
