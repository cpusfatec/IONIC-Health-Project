package fatec.projetoapi.model;

import javax.persistence.*;


@Entity
@Table(name = "cliente")
public class Cliente {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "email", nullable = false, length = 45)
	private String email;

	@Column(name = "nome", nullable = false, length = 20)
	private String nome;

	@Column(name = "crm", nullable = false, length = 20)
	private String crm;

	@Column(name = "cpf", nullable = false, length = 12)
	private double cpf;

	@Column(name = "telefone", nullable = false, length = 20)
	private String telefone;
	
	@Column(name = "especialidade", nullable = false, length = 200)
	private String especialidade;
	
	@Column(name = "produto", nullable = false, length = 200)
	private String produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public double getCpf() {
		return cpf;
	}

	public void setCpf(Double cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}
	
	
}
