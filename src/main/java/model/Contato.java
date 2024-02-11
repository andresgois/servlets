package model;

public class Contato {

	private String idCon;
	private String nome;
	private String phone;
	private String email;
	
	public Contato() {}
	
	public Contato(String idCon, String nome, String phone, String email) {
		super();
		this.idCon = idCon;
		this.nome = nome;
		this.phone = phone;
		this.email = email;
	}

	public String getIdCon() {
		return idCon;
	}

	public void setIdCon(String idCon) {
		this.idCon = idCon;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
