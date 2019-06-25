package ticketservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import ticketservice.model.Airport;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
public interface AirportRepository extends JpaRepository<Airport, Integer>{

	List<Airport> findByName(String name);
	List<Airport> findByFreeSlotsSmallAircraftGreaterThanEqual(Integer szabadhelyekKisgep);
	List<Airport> findByFreeSlotsMediumAirCraftGreaterThanEqual(Integer szabadhelyekKozepesgep);
	List<Airport> findByFreeSlotsBig2EnginesGreaterThanEqual(Integer szabadhelyekNagy2Motoros);
	List<Airport> findByFreeSlotsBig4EnginesGreaterThanEqual(Integer szabadhelyekNagy4Motoros);



}
