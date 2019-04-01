package ticketservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ticketservice.model.Pilota;

import java.util.List;

public interface PilotaRepository extends JpaRepository<Pilota, Integer>{

	List<Pilota> findByName(String name);
	
}
