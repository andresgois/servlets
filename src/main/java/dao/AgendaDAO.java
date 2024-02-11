package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

import beans.ContatoBean;
import model.Contato;

public class AgendaDAO {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3309/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "root";
	
	private Connection conectar() {
		Connection con =null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Conectado");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println("Erro");
		}
	}
	
	public void inserir(Contato c) {
		String sql = "insert into contatos (nome, fone, email) values (?,?,?)";
		try {
			Connection con = conectar();
			// prepara a query para execuçã no banco
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, c.getNome());
			st.setString(2, c.getPhone());
			st.setString(3, c.getEmail());
			// Executar a query
			st.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println("Error na inserção: "+e);
		}
	}
	
	public ArrayList<Contato> listarContatos(){
		String sql = "select * from contatos";
		ArrayList<Contato> contatos = new ArrayList<Contato>();
		
		try {
			Connection con = conectar();
			// prepara a query para execuçã no banco
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String idCon = rs.getString(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);
				String fone = rs.getString(4);
				
				contatos.add(new Contato(idCon,nome, fone, email));
			}
			con.close();
		} catch (Exception e) {
			System.out.println("Error na listagem: "+e);
		}
		return contatos;
	}

	public Contato buscaPorId(String id) {
		String sql = "select * from contatos where idcon = ?";
		Contato c = new Contato();
		c.setIdCon(id);
		try {
			Connection con = conectar();
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, c.getIdCon());
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				c.setIdCon(rs.getString(1));
				c.setNome(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setPhone(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println("Error na listagem: "+e);
		}
		return c;
	}

	public void alteraContato(Contato c) {
		String sql = "update contatos set nome = ? ,fone = ?, email = ? where idcon = ?";
		
		try {
			Connection con = conectar();
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, c.getNome());
			st.setString(2, c.getPhone());
			st.setString(3, c.getEmail());
			st.setString(4, c.getIdCon());
			
			st.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println("Error na listagem: "+e);
		}
	}
}
