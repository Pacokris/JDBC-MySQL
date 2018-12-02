package com.sw.bdd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LeilaServlet")
public class LeilaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LeilaServlet() {
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dark tableNoms = new Dark();
        request.setAttribute("Vador", tableNoms.recupererVadors());
        this.getServletContext().getRequestDispatcher("/Vador.jsp").forward(request, response);
	}
}
