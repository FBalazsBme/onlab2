package ticketservice.web;

import org.springframework.web.bind.annotation.*;
import ticketservice.model.Luggage;
import ticketservice.repository.LuggageRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class LuggageController {
	private LuggageRepository repository;

	public LuggageController(LuggageRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/list-poggyasz")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Luggage> listOfLuggage() {
		return repository.findAll();
	}

	@GetMapping("/find-poggyasz-tomeggt")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Luggage> findByWeightGreaterThan(
			@RequestParam(required= true) Integer tomeg
	) {
		return repository.findByWeightGreaterThan(tomeg)
				.stream().collect(Collectors.toList());
	}

	@GetMapping("/find-poggyasz-tomeglt")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Luggage> findByWeightLessThan(
			@RequestParam(required= true) Integer tomeg
	) {
		return repository.findByWeightLessThan(tomeg)
				.stream().collect(Collectors.toList());
	}

	@DeleteMapping("/deleteluggage")
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteById(
			@RequestParam(required= true) Integer luggageId
	) {
		Luggage p = repository.findById(luggageId).get();
		repository.delete(p);
	}

	@PostMapping("/addluggage")
	@CrossOrigin(origins = "http://localhost:4200")
	public Luggage add(
			@RequestBody Luggage luggage
	) {
		repository.save(luggage);
		return luggage;
	}
}
