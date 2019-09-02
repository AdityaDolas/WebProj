package com.aditya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
/*	LoginPage u=new 
	UserDao ud=new UserDao();*/


	public AddUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String contact = request.getParameter("no");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String cpass = request.getParameter("confirm");

		if (pass != null && pass.equals(cpass)) {
			u.setName(name);
			u.setContact(contact);
			u.setEmailid(email);
			u.setPass(pass);

			boolean b = ud.addUser(u);

			if (b) {
				response.sendRedirect("Success.jsp");
			} else {
				response.sendRedirect("Error.jsp");
			}
		}

	}
*/
}
}
