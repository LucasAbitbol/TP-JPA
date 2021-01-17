package galerie.dao;

import galerie.entity.Exposition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpositionRepository extends JpaRepository<Exposition, Integer> {

}
