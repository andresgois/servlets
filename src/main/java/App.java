import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/App")
public class App extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		super.init();
		/*ServletConfig config = getServletConfig();
		String a = config.getInitParameter("nome");
		System.out.println(">>>>>>>>>>>>>>>>> load-on-startup: "+a);*/
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doGet(req, resp);
		String b = getInitParameter("nome");
		
		System.out.println("B2: "+b);
		
		ServletConfig sc = getServletConfig();
		Enumeration<String> e = sc.getInitParameterNames();
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
		resp.getWriter().append("B: ").append(b);
	}

}
