package Hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hello")
public class hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public hello() {
        super();
    }
    //http://localhost:8080/Hello-world/teste.html
    //http://localhost:8080/Hello-world/hello
    //http://localhost:8080/Hello-world/hello.jsp
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Olá</title>");
		out.println("<body>");
		out.println("<h1>Teste servlet</h1>");
		out.println("</body>");
		out.println("<html>");
		
	}

}
