package ticketservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import ticketservice.model.Pilot;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
public interface PilotRepository extends JpaRepository<Pilot, Integer>{

	List<Pilot> findByName(String name);
	List<Pilot> findByLicenseTypeGreaterThan(String name);

}
