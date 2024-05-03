package model;


public class Contacto {
//	Atributos
	
	private int id;
	private String nome;
	private String contacto;
	private String email;
	
	public Contacto() {
	}

	public Contacto(int id, String nome, String contacto, String email) {
		super();
			this.id = id;
			this.nome = nome;
			this.contacto = contacto;
			this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getEmail() {
		return email.toLowerCase();
	}

	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}

	@Override
	public String toString() {
		return "Contacto [id=" + id + ", nome=" + nome + ", contacto=" + contacto + ", email=" + email + "]";
	}
	

}
