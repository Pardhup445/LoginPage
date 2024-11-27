package com.Tap.acad;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	String fetch="select * from employee where email=?";
	
	private Connection con;

	private PreparedStatement pstmt;

	private ResultSet res;

	private HttpSession session;

	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","1234");
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			
			try {
				pstmt=con.prepareStatement(fetch);
				pstmt.setString(1, email);
				res=pstmt.executeQuery();
				
				if(res.next()) {
					if(res.getString("pswd").equals(password)) {
						
						String name=res.getString("empname");
						String salary=res.getString("salary");
						String desig=res.getString("desig");
//						email=res.getString("email");
//						password=res.getString("pswd");
						
						
					 session=req.getSession();
					 session.setAttribute("name", name);
					 session.setAttribute("salary", salary);
					 session.setAttribute("desig", desig);
					 session.setAttribute("email", email);
					 session.setAttribute("password", password);
					 
						//req.getRequestDispatcher("home.jsp").forward(req, resp);
						resp.sendRedirect("home.jsp");
					}
					else {
						resp.sendRedirect("faiilure.html");
					}
				}
				else {
					resp.sendRedirect("notfound.html");
				}
			}
			catch(Exception  e) {
				e.printStackTrace();
			}
}
}
