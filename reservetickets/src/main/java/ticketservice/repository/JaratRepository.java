package ticketservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ticketservice.model.Jarat;

import java.util.List;

public interface JaratRepository extends JpaRepository<Jarat, Integer>{

	List<Jarat> findByJaratSzam(String name);
	
}
