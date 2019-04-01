package ticketservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ticketservice.model.Repter;

import java.util.List;

public interface RepterRepository extends JpaRepository<Repter, Integer>{

	List<Repter> findByNev(String nev);
	
}
