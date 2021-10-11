package fatec.projetoapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fatec.projetoapi.model.Cliente;

@Repository
@Transactional
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	Cliente getOne(long id);
}
