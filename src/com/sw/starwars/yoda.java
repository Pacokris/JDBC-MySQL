package com.sw.starwars;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

@WebServlet("/")
public class yoda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/starwars","Utilisateur","mdp");


			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT name, surname FROM jedi_masters");
			
			response.setContentType("text/html");
			java.io.PrintWriter out = response.getWriter();
			
			out.println("<html>"
					+ "<head>"
					+ "<title>JDBC & MySQL</title>"
					+ "</head>"
					+ "<body>"
					+ "<h1>Maitres Jedi</h1>"
					+ "<br/>"
					+ "<ul>");
			
			while(rs.next()) out.println("<li>" + rs.getString(1) + " " + rs.getString(2) + "</li>");
			
			out.println("</ul></body></html>");




		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}