package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.LoginDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		HttpSession session = request.getSession();
		
		LoginDao loginDao = new LoginDao();
		
		if(loginDao.checkCreds(uname, pass)) {
			session.setAttribute("uname", uname);
			response.sendRedirect("welcome.jsp");
		} else {
			response.getWriter().print("Login failed");
			response.sendRedirect("login.jsp");
		}
		
	}

}
