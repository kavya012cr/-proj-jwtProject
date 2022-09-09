package com.celes.gmailapplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Account
 */
@WebServlet("/Account")
public class Account extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Account() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter	=response.getWriter();
		Connection connection = null;
		java.sql.PreparedStatement preparedStatement= null;
		String string=null;
		ResultSet resultSet=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "Jdbc:mysql://localhost:3306/celes?autoReconnect=true&useSSl=false";
		 connection	=DriverManager.getConnection(dburl, "root", "Kavya@123");
		 String string2= "select * from account where username=? and password=?";
		 ServletContext context=getServletContext();
		 preparedStatement  = connection.prepareStatement(string2);
		String string3=request.getParameter("username");
		String string4=request.getParameter("password");
	preparedStatement.setString(1,string2);
	preparedStatement.setString(2, string4);
	printWriter.print("bfjsdjf");

	/*
	 * resultSet = preparedStatement.executeQuery(string); Boolean r= false;
	 * resultSet.next(); if(r==true) { r=resultSet.next();
	 * context.setAttribute("username", string);
	 * response.sendRedirect("Compose.html");
	 * 
	 * } else { printWriter.println("not valid!!"); }
	 */
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
