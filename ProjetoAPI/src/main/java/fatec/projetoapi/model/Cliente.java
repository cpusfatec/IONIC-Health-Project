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

	@Column(name = "sobrenome", nullable = false, length = 20)
	private String sobrenome;

	@Column(name = "cpf", nullable = false, length = 12)
	private double cpf;

	@Column(name = "telefone", nullable = false, length = 20)
	private String telefone;
	
	@Column(name = "descricao", nullable = false, length = 200)
	private String descricao;

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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
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
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
