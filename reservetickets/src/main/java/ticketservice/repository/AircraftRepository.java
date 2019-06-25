package ticketservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import ticketservice.model.Aircraft;
import ticketservice.model.Size;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
public interface AircraftRepository extends JpaRepository<Aircraft, Integer>{

	List<Aircraft> findByMaxSeatsGreaterThanEqual(Integer maxFerohelyek);
	List<Aircraft> findByMaxLuggageSizeGreaterThanEqual(Integer maxPoggyaszteher);
	List<Aircraft> findBySizeGreaterThanEqual(Size size);
	List<Aircraft> findBySizeLessThanEqual(Size size);
}
