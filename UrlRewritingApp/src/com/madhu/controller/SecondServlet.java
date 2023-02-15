package com.madhu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acctype = request.getParameter("acctype");
		String accbranch = request.getParameter("accbranch");
		HttpSession session = request.getSession(false);
		session.setAttribute("acctype", acctype);
		session.setAttribute("accbranch", accbranch);
		
		PrintWriter out = response.getWriter();
		System.out.println("in secondservlet");
		out.println("<html><head><title>Deposit Form2</title></head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1 style='color:red;'>Deposit Form2....</h1>");
		out.println("<form method='post' action='"+response.encodeURL("./third")+"'>");
		out.println("<table border='1'>");
	     out.println("<center>");
	     out.println("<tr><th>Dep name</th><td><input type='text' name='depname'/></td></tr>");
	     
	     out.println("<tr><th>Dep amount</th><td><input type='text' name='depamount'/></td></tr>");
	     out.println("<tr><th></th><td><input type='submit' value='next'/></td></tr>");
	     out.println("</table></form>");
		
	    
		
		out.println("</center>");
		out.println("</body></html>");
		out.close();
		
	}

}
