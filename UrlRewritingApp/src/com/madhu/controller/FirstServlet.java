package com.madhu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accno = request.getParameter("accno");
		String accname = request.getParameter("accname");
		HttpSession session = request.getSession();
		session.setAttribute("accno", accno);
		session.setAttribute("accname", accname);
		
		PrintWriter out = response.getWriter();
		System.out.println("in firstservlet");
		out.println("<html><head><title>Deposit Form</title></head>");
		out.println("<body bgcolor='cyan'>");
		out.println("<center>");
		out.println("<h1 style='color:red;'>Deposit Form....</h1>");
		out.println("<form method='post' action='"+response.encodeURL("./second")+"'>");
		out.println("<table border='1'>");
	     out.println("<center>");
	     out.println("<tr><th>Acc Type</th><td><input type='text' name='acctype'/></td></tr>");
	     
	     out.println("<tr><th>Acc Branch</th><td><input type='text' name='accbranch'/></td></tr>");
	     out.println("<tr><th></th><td><input type='submit' value='next'/></td></tr>");
		
	     out.println("</table></form>");
		
		
		
		out.println("</center>");
		out.println("</body></html>");
		out.close();
		
	}

}
