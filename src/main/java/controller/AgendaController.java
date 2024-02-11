package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ContatoBean;
import model.Contato;

@WebServlet(urlPatterns = {"/Controller","/main", "/insert","/select","/update"})
public class AgendaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//AgendaDAO dao = new AgendaDAO();
    // http://localhost:8080/Hello-world/
    public AgendaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//dao.testeConexao();
		String action = request.getServletPath();
		System.out.println(action);
		if(action.equals("/main")) {
			contatos(request, response);
		}else if(action.equals("/insert")) {
			novoContato(request, response);
		} else if(action.equals("/select")) {
			editarContato(request, response);
		} else if(action.equals("/update")) {
			updateContato(request, response);
		}else {
			response.sendRedirect("index.html");
		}
	}

	private void updateContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContatoBean cb = new ContatoBean();
		String id = request.getParameter("idcon");
		System.out.println("idcon: "+id);
		cb.editarContato(
			id,
			request.getParameter("nome"),
			request.getParameter("fone"),
			request.getParameter("email")
		);
		response.sendRedirect("main");
	}

	private void editarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);
		ContatoBean cb = new ContatoBean();
		Contato contato = cb.buscarContatoPorId(id);
		request.setAttribute("contato", contato);
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	private void novoContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContatoBean cb = new ContatoBean();
		cb.criarContato(
			request.getParameter("nome"),
			request.getParameter("fone"),
			request.getParameter("email")
		);
		response.sendRedirect("main");
	}

	private void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("agenda.jsp");
		ContatoBean cb = new ContatoBean();
		ArrayList<Contato> contatos = cb.listarContatos();
		
		System.out.println(contatos.size());
		
		request.setAttribute("contatos", contatos);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}

	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}*/

}
