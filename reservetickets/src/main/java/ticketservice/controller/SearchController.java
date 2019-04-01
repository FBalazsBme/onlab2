package ticketservice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;
import ticketservice.model.Jarat;
import ticketservice.repository.JaratRepository;

@RestController
class SearchController {
	private JaratRepository repository;

	public SearchController(JaratRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/categories")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Jarat> categories() {
		return repository.findAll().stream()
				.filter(this::filterCategory)
				.collect(Collectors.toList());
	}

	private boolean filterCategory(Jarat jarat) {
		return jarat.getId() < 4;
	}
}

