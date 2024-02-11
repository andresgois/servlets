package beans;

import java.util.ArrayList;
import java.util.List;

import dao.AgendaDAO;
import model.Contato;

public class ContatoBean {
	
	AgendaDAO dao = new AgendaDAO();
	
	public ContatoBean() {}
	
	public void criarContato(String nome,String fone,String email) {
		Contato c = new Contato();
		c.setNome(nome);
		c.setPhone(fone);
		c.setEmail(email);
		dao.inserir(c);
	}

	public ArrayList<Contato> listarContatos() {
		ArrayList<Contato> lista = dao.listarContatos();
		return lista;
	}

	public Contato buscarContatoPorId(String id) {
		return dao.buscaPorId(id);
	}

	public void editarContato(String id,String nome, String fone, String email) {
		Contato c = new Contato();
		c.setIdCon(id);
		c.setNome(nome);
		c.setPhone(fone);
		c.setEmail(email);
		dao.alteraContato(c);
	}

}
