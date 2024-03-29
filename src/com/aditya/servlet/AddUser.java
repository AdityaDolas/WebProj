package com.aditya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aditya.dao.UserDao;
import com.aditya.pojo.User;

@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User u = new User();
	UserDao ud = new UserDao();

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
		PrintWriter out = response.getWriter();
		String name = request.getParameter("uname");
		String contact = request.getParameter("contact");
		String email = request.getParameter("Email");
		String pass = request.getParameter("pass");

		u.setName(name);
		u.setNumber(contact);
		u.setEmail(email);
		u.setPassword(pass);

		boolean b = ud.addUser(u);

		if (b) {
			response.sendRedirect("LoginPage.jsp");
		} else {
			response.sendRedirect("CreateUser.jsp");
		}
	}

}