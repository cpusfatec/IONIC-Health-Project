package fatec.projetoapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fatec.projetoapi.model.Block;

public interface BlockRepository extends JpaRepository<Block, String> {
	
	Optional<Block> findById(String id);
	 
}
