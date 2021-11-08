package fatec.projetoapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fatec.projetoapi.model.Document;

public interface DocumentRepository extends JpaRepository<Document, String> {
	
	Optional<Document> findById(String id);
	
}