package fatec.projetoapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fatec.projetoapi.model.Usuario;

@Repository
@Transactional
public interface UsuarioRepository extends CrudRepository <Usuario, Long>{
	Usuario findByNome(String nome);

	Usuario getOne(long id);
}
