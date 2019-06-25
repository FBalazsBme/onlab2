package ticketservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import ticketservice.model.Luggage;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
public interface LuggageRepository extends JpaRepository<Luggage, Integer>{

	
	List<Luggage> findByWeightGreaterThan(Integer tomeg);
	List<Luggage> findByWeightLessThan(Integer tomeg);


}
