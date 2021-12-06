package com.obiokolie;


import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CreditShop")
public class ClientDefault extends HttpServlet {

	  @Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws IOException {
	    response.setContentType("text/html;");
	    response.getWriter().println("<h1>Hello world!</h1>");
	  }
	
}
