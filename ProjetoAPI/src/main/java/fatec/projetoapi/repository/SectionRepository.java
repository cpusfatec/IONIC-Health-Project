package fatec.projetoapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fatec.projetoapi.model.Section;

public interface SectionRepository extends JpaRepository<Section, String> {

	Optional<Section> findById(String id);
}
