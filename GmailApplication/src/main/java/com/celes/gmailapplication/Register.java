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
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter	=response.getWriter();
		Connection connection=null;
		java.sql.PreparedStatement preparedStatement=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "Jdbc:mysql://localhost:3306/celes?autoReconnect=true&useSSl=false";
			 connection=DriverManager.getConnection(dburl, "root", "Kavya@123");
		 preparedStatement =connection.prepareStatement("insert into account values(?,?,?,?)");
			int userid=Integer.parseInt(request.getParameter("userid"));
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String email=request.getParameter("emailid");
			preparedStatement.setInt(1, userid);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, password);
			preparedStatement.setString(4, username);
			int result=preparedStatement.executeUpdate();
			printWriter.println(result);
			
			
		} catch (Exception e) {
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
