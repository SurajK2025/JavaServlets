package pages;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletConfig();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		PrintWriter pw = resp.getWriter();
		
		if(username.equals("admin") && password.equals("admin")) {
			pw.print("Login success");
			resp.sendRedirect("loginSuccess.html");
		}
		else {
			pw.print("Login failed");
			resp.sendRedirect("loginFailed.html");
		}
		pw.close();
	}

	@Override
	public void destroy() {
		System.out.println("LoginServlet destroyed...");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("LoginServlet initialized...");
	}
	
}