package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//loadOnStartup changes the default behavior (lazy loading) of servlets to eager loading.
@WebServlet(urlPatterns = "/first", loadOnStartup = 1)
public class FirstServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("do-get invoked by: "+Thread.currentThread());
		
		resp.setContentType("text/html");
		try(PrintWriter pr = resp.getWriter()) {
			pr.print("<h5>Time-stamp: "+LocalDateTime.now()+"</h5>");
		}
	}

	@Override
	public void destroy() {
		System.out.println("servlet 1 destroy invoked by: "+Thread.currentThread());
	}

	@Override
	public void init() throws ServletException {
		System.out.println("servlet 1 init invoked by: "+Thread.currentThread());
	}
	
}
