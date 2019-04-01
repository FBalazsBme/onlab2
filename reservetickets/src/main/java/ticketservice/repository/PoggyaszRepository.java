package ticketservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ticketservice.model.Poggyasz;

import java.util.List;

public interface PoggyaszRepository extends JpaRepository<Poggyasz, Integer>{

	List<Poggyasz> findByTomegGreaterThan(Integer tomeg);
	List<Poggyasz> findByTomegLessThan(Integer tomeg);


}
