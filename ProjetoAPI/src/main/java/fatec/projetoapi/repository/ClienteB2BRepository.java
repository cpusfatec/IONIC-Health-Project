package fatec.projetoapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fatec.projetoapi.model.ClienteB2B;

@Repository
@Transactional
public interface ClienteB2BRepository extends CrudRepository<ClienteB2B, Long> {
	ClienteB2B getOne(long id);
}
