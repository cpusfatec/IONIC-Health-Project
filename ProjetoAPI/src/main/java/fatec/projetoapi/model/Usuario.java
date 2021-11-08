package fatec.projetoapi.model;

import javax.persistence.*;


@Entity
@Table(name = "usuario")
public class Usuario {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false, length = 20)
	private String nome;
	
	@Column(name = "senha")
    private String senha;
	
	public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }
    public Usuario() {
    	
    }


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
