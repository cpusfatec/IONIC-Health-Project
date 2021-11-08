package fatec.projetoapi.repository;

import org.springframework.data.repository.CrudRepository;

import fatec.projetoapi.model.Usuario;

public interface UsuarioRepository extends CrudRepository <Usuario, Long>{
	Usuario findByNome(String nome);
}
