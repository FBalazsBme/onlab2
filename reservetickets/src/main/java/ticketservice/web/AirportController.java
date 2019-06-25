package ticketservice.web;

import org.springframework.web.bind.annotation.*;
import ticketservice.model.Airport;
import ticketservice.repository.AirportRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class AirportController {
	private AirportRepository repository;

	public AirportController(AirportRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/list-repterek")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Airport> listOfRepter() {
		return repository.findAll();
	}

	@GetMapping("/find-repter-szhkisgte")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Airport> findByFreeSlotsSmallAircraftGreaterThanEqual(
			@RequestParam(required= true) Integer szabadhelyekKisgep
	) {
		return repository.findByFreeSlotsSmallAircraftGreaterThanEqual(szabadhelyekKisgep)
				.stream().collect(Collectors.toList());
	}


	@GetMapping("/find-repter-szhkozgte")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Airport> findByFreeSlotsMediumAirCraftGreaterThanEqual(
			@RequestParam(required= true) Integer szabadhelyekKozepesgep
	) {
		return repository.findByFreeSlotsMediumAirCraftGreaterThanEqual(szabadhelyekKozepesgep)
				.stream().collect(Collectors.toList());
	}

	@GetMapping("/find-repter-szhnagy2gte")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Airport> findByFreeSlotsBig2EnginesGreaterThanEqual(
			@RequestParam(required= true) Integer szabadhelyekNagy2Motoros
	) {
		return repository.findByFreeSlotsBig2EnginesGreaterThanEqual(szabadhelyekNagy2Motoros)
				.stream().collect(Collectors.toList());
	}

	@GetMapping("/find-repter-szhnagy4gte")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Airport> findByFreeSlotsBig4EnginesGreaterThanEqual(
			@RequestParam(required= true) Integer szabadhelyekNagy4Motoros
	) {
		return repository.findByFreeSlotsBig4EnginesGreaterThanEqual(szabadhelyekNagy4Motoros)
				.stream().collect(Collectors.toList());
	}

	@DeleteMapping("/deleteairport")
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteById(
			@RequestParam(required= true) Integer airportId
	) {
		Airport p = repository.findById(airportId).get();
		repository.delete(p);
	}

	@PostMapping("/addairport")
	@CrossOrigin(origins = "http://localhost:4200")
	public Airport addAirport(
			@RequestBody Airport airport
	) {
		System.out.println("Add pilot called");
		repository.save(airport);
		return airport;
	}
}
