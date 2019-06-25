package ticketservice.web;

import org.springframework.web.bind.annotation.*;
import ticketservice.model.Passenger;
import ticketservice.repository.PassengerRepository;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
public class PassengerController {
	private PassengerRepository repository;

	public PassengerController(PassengerRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/list-utasok")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Passenger> listOfPassengers() {
		return repository.findAll();
	}

	@GetMapping("/find-utas-pontokgt")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Passenger> findByPointsGreaterThan(
			@RequestParam(required= true) Integer Pontok
	) {
		return repository.findByPointsGreaterThan(Pontok)
				.stream().collect(Collectors.toList());
	}

	@GetMapping("/find-utas-pontoklt")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Passenger> findByPointsLessThan(
			@RequestParam(required= true) Integer Pontok
	) {
		return repository.findByPointsLessThan(Pontok)
				.stream().collect(Collectors.toList());
	}

	@GetMapping("/find-utas-szuletafter")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Passenger> findByBirthDateAfter(
			@RequestParam(required= true) Date szuletesiIdo
	) {
		return repository.findByBirthDateAfter(szuletesiIdo)
				.stream().collect(Collectors.toList());
	}

	@GetMapping("/find-utas-szuletbefore")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Passenger> findByBirthDateBefore(
			@RequestParam(required= true) Date szuletesiIdo
	) {
		return repository.findByBirthDateBefore(szuletesiIdo)
				.stream().collect(Collectors.toList());
	}

	@GetMapping("/find-utas-lakhely")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Passenger> findByHomeAirport(
			@RequestParam(required= true) String lakhelyRepter
	) {
		return repository.findByHomeAirport(lakhelyRepter)
				.stream().collect(Collectors.toList());
	}

	@GetMapping("/find-utas-bkartyaszam")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Passenger> findByCreditCardNumber(
			@RequestParam(required= true) String bankkartyaszam
	) {
		return repository.findByCreditCardNumber(bankkartyaszam)
				.stream().collect(Collectors.toList());
	}

	@DeleteMapping("/deletepassenger")
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteById(
			@RequestParam(required= true) Integer passengerId
	) {
		Passenger p = repository.findById(passengerId).get();
		repository.delete(p);
	}

	@PostMapping("/addpassenger")
	@CrossOrigin(origins = "http://localhost:4200")
	public Passenger add(
			@RequestBody Passenger passenger
	) {
		repository.save(passenger);
		return passenger;
	}
}