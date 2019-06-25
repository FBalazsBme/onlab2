package ticketservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import ticketservice.model.Passenger;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
public interface PassengerRepository extends JpaRepository<Passenger, Integer>{

	List<Passenger> findByPointsGreaterThan(Integer Pontok);
	List<Passenger> findByPointsLessThan(Integer Pontok);
	List<Passenger> findByBirthDateAfter(Date szuletesiIdo);
	List<Passenger> findByBirthDateBefore(Date szuletesiIdo);
	List<Passenger> findByHomeAirport(String lakhelyRepter);
	List<Passenger> findByCreditCardNumber(String bankkartyaszam);

}
