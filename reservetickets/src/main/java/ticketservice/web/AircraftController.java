package ticketservice.web;

import org.springframework.web.bind.annotation.*;
import ticketservice.model.Aircraft;
import ticketservice.model.Pilot;
import ticketservice.model.Size;
import ticketservice.repository.AircraftRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class AircraftController {
	private AircraftRepository repository;

	public AircraftController(AircraftRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/list-gepek")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Aircraft> listOfGepek() {
		return repository.findAll();
	}

	@GetMapping("/find-gepek-ferohelynagyobb")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Aircraft> findByMaxSeatsGreaterThanEqual(
			@RequestParam(required= true) Integer maxFerohelyek
	) {
		return repository.findByMaxSeatsGreaterThanEqual(maxFerohelyek)
				.stream().collect(Collectors.toList());
	}

	@GetMapping("/find-gepek-tehernagyobb")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Aircraft> findByMaxPoggyaszteherGreaterThanEqual(
			@RequestParam(required= true) Integer maxPoggyaszteher
	) {
		return repository.findByMaxLuggageSizeGreaterThanEqual(maxPoggyaszteher)
				.stream().collect(Collectors.toList());
	}

	@GetMapping("/find-gepek-meretnagyobb")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Aircraft> findBySizeGreaterThanEqual(
			@RequestParam(required= true) Integer meret
	) {
		return repository.findBySizeGreaterThanEqual(Size.values()[meret])
				.stream().collect(Collectors.toList());
	}

	@GetMapping("/find-gepek-meretkisebb")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Aircraft> findBySizeLessThanEqual(
			@RequestParam(required= true) Integer meret
	) {
		return repository.findBySizeLessThanEqual(Size.values()[meret])
				.stream().collect(Collectors.toList());
	}

	@DeleteMapping("/deleteaircraft")
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteById(
			@RequestParam(required= true) Integer aircraftId
	) {
		System.out.println("Delete aircraft called");
		Aircraft a = repository.findById(aircraftId).get();
		repository.delete(a);
	}


	@PostMapping("/addaircraft")
	@CrossOrigin(origins = "http://localhost:4200")
	public Aircraft addAircraft(
			@RequestBody Aircraft aircraft
	) {
		System.out.println("Add aircraft called");
		repository.save(aircraft);
		return aircraft;
	}

}
