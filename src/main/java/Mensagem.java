

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(value = "/Mensagem", initParams = { @WebInitParam(name = "valor", value = "50")})
public class Mensagem extends HttpServlet {
	private static final long serialVersionUID = 1L;
// http://localhost:8080/Hello-world/Mensagem
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String valor = getInitParameter("valor");
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.append("Valor => ");
			out.append(valor);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(out != null) {
				out.close();
			}
		}
	}

}
