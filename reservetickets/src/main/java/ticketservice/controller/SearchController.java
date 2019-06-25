package ticketservice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;
import ticketservice.model.Flight;
import ticketservice.repository.FlightRepository;

@RestController
class SearchController {
	private FlightRepository repository;

	public SearchController(FlightRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/categories")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Flight> categories() {
		return repository.findAll().stream()
				.filter(this::filterCategory)
				.collect(Collectors.toList());
	}

	private boolean filterCategory(Flight flight) {
		return flight.getId() < 4;
	}
}

