package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InputFieldsServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("servlet 3 init invoked by: "+Thread.currentThread());
	}
	
	@Override
	public void destroy() {
		System.out.println("servlet 3 destroy invoked by: "+Thread.currentThread());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		try(PrintWriter pw = resp.getWriter()){
			pw.print("<h3>Student Data: </h3>");
			pw.print("<p>Name: "+req.getParameter("name")+"</p>");
			pw.print("<p>Number: "+req.getParameter("number")+"</p>");
			pw.print("<p>City: "+req.getParameter("city")+"</p>");
			pw.print("<p>Subjects: "+Arrays.toString(req.getParameterValues("subjects"))+"</p>");
			
			pw.print("<a href=\"index.html\">Back</a>");
		}
	}
}
