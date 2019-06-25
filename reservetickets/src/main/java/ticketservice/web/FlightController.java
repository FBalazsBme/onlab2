package ticketservice.web;

import org.springframework.web.bind.annotation.*;
import ticketservice.model.Flight;
import ticketservice.repository.FlightRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class FlightController {
	private FlightRepository repository;

	public FlightController(FlightRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/list-jaratok")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Flight> listOfFlights() {
		return repository.findAll();
	}

	@GetMapping("/find-jarat-szabadhelygte")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Flight> findByNumberOfFreeSeatsGreaterThanEqual(
			@RequestParam(required= true) Integer szabadHelyekSzama
	) {
		return repository.findByNumberOfFreeSeatsGreaterThanEqual(szabadHelyekSzama)
				.stream().collect(Collectors.toList());
	}

	@GetMapping("/find-jarat-krepid")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Flight> findByOriginAirportId(
			@RequestParam(required= true) Integer kiindulorepterId
	) {
		return repository.findByOriginAirportId(kiindulorepterId)
				.stream().collect(Collectors.toList());
	}

	@GetMapping("/find-jarat-crepid")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Flight> findByDestinationAirportId(
			@RequestParam(required= true) Integer celrepterId
	) {
		return repository.findByDestinationAirportId(celrepterId)
				.stream().collect(Collectors.toList());
	}

	@GetMapping("/find-jarat-datumutan")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Flight> findByStartDateGreaterThanEqual(
			@RequestParam(required= true) String startDatum
	) {
		try {
			return repository.findByStartDateGreaterThanEqual(
					new SimpleDateFormat("yyyy-MM-dd").parse(startDatum))
					.stream().collect(Collectors.toList());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	@GetMapping("/find-jarat-datumelott")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Flight> findByStartDateLessThanEqual(
			@RequestParam(required= true) String startDatum
	) {
		try {
			return repository.findByStartDateLessThanEqual(
					new SimpleDateFormat("yyyy-MM-dd").parse(startDatum))
					.stream().collect(Collectors.toList());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@DeleteMapping("/deleteflight")
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteById(
			@RequestParam(required= true) Integer flightId
	) {
		System.out.println("Delete pilot called");
		Flight p = repository.findById(flightId).get();
		repository.delete(p);
	}

	@PostMapping("/addflight")
	@CrossOrigin(origins = "http://localhost:4200")
	public Flight addFlight(
			@RequestBody Flight flight
	) {
		System.out.println("Add pilot called");
		repository.save(flight);
		return flight;
	}

}