package com.aditya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.aditya.dao.LoginDao;
import com.aditya.dao.UserDao;
import com.aditya.pojo.User;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User u = new User();
	UserDao ud = new UserDao();

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
	
		
		if (action != null && action.equals("loginuser")) {
			String uname = request.getParameter("uname");
			String pass = request.getParameter("pass");

			LoginDao dao = new LoginDao();

			if (dao.check(uname, pass)) {
				HttpSession session = request.getSession();
				session.setAttribute("username", uname);
				response.sendRedirect("HomePageDemo.jsp");
			} else {
				// response.sendRedirect("LoginPage.jsp");
				request.setAttribute("loginmsg", "Invalid Username or Password");
				RequestDispatcher rd = request.getRequestDispatcher("LoginPage.jsp");
				rd.include(request, response);
			}

		} else if (action != null && action.equals("createuser")) {
		
			String name = request.getParameter("uname");
			String num = request.getParameter("num");
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");

			u.setName(name);
			u.setNumber(num);
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
}

/*
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { // TODO Auto-generated
 * method stub doGet(request, response); }
 * 
 * }
 */