package ticketservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import ticketservice.model.Flight;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
public interface FlightRepository extends JpaRepository<Flight, Integer>{

	List<Flight> findByNumberOfFreeSeatsGreaterThanEqual(Integer szabadHelyekSzama);
	List<Flight> findByOriginAirportId(Integer kiindulorepterId);
	List<Flight> findByDestinationAirportId(Integer celrepterId);
	List<Flight> findByStartDateGreaterThanEqual(Date startDatum);
	List<Flight> findByStartDateLessThanEqual(Date startDatum);



}
