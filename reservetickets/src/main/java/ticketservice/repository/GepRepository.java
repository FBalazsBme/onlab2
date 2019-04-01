package ticketservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ticketservice.model.Gep;

import java.util.List;

public interface GepRepository extends JpaRepository<Gep, Integer>{

	List<Gep> findByMaxFerohelyek(Integer maxFerohelyek);
	
}
