package fatec.projetoapi.model;

import javax.persistence.*;


@Entity
@Table(name = "clienteb2b")
public class ClienteB2B {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "categoria", nullable = false, length = 200)
	private String categoria;

	@Column(name = "razaosocial", nullable = false, length = 200)
	private String razaosocial;

	@Column(name = "cnpj", nullable = false, length = 200)
	private String cnpj;

	@Column(name = "endereco", nullable = false, length = 200)
	private String endereco;

	@Column(name = "contato", nullable = false, length = 200)
	private String contato;
	
	@Column(name = "email", nullable = false, length = 200)
	private String email;
	
	@Column(name = "produto", nullable = false, length = 200)
	private String produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getRazaosocial() {
		return razaosocial;
	}

	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}
	
	
}
