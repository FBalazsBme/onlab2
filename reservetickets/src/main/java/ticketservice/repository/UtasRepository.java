package ticketservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ticketservice.model.Utas;

import java.util.List;

public interface UtasRepository extends JpaRepository<Utas, Integer>{

	List<Utas> findByPontokGreaterThan(Integer Pontok);
	List<Utas> findByPontokLessThan(Integer Pontok);
}
