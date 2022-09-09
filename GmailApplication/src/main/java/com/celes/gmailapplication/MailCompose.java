package com.celes.gmailapplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MailCompose
 */
@WebServlet("/MailCompose")
public class MailCompose extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailCompose() {
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
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "Jdbc:mysql://localhost:3306/celes?autoReconnect=true&useSSl=false";
		 connection	=DriverManager.getConnection(dburl, "root", "Kavya@123");
		 String string2= "insert into inbox where messageid=? and message=?";
		 preparedStatement  = connection.prepareStatement(string2);
		 int i = Integer.parseInt(request.getParameter("messageid"));
			String string3=request.getParameter("messageid");
			String string4=request.getParameter("message");
			String string5=request.getParameter("userid");
			
		preparedStatement.setString(1,string2);
		preparedStatement.setString(2, string4);
		printWriter.print("shwo error");
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
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
