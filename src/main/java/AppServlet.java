import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/AppServlet", // loadOnStartup = 2,
		initParams = {
				@WebInitParam(name = "numero", value = "3", description = "valor numerico") }

)
public class AppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// http://localhost:8080/Hello-world/teste2
	public AppServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println(">>>>>>>>>>>>>>>>> load-on-startup: ");
		ServletConfig num = getServletConfig();
		String a = num.getInitParameter("numero");
		System.out.println("A: " + a);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num = getInitParameter("numero");
		Integer numero = Integer.valueOf(num);

		System.out.println("doGet: " + numero);
		PrintWriter out = null;
		response.setContentType("text/html");
		try {
			out = response.getWriter();

			out.print("<html>");
			out.print("<head>");
			out.print("<meta http-equiv=\"Content-Type\" "+
			"content=\"text/html; chaset=ISO-8859-1\" />");
			out.print("<title>Teste</title>");
			out.print("</head>");
			out.print("<body>");
			out.print("<h2>");
			out.print(num);
			out.print("</h2>");
			out.print("</body>");
			out.print("</html>");

		} catch (Exception e) {
			out.print("<html>null</html>");
		} finally {
			if(out != null) {
				out.close();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
