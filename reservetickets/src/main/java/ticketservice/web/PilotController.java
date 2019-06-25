package ticketservice.web;

import org.springframework.web.bind.annotation.*;
import ticketservice.model.Pilot;
import ticketservice.model.Size;
import ticketservice.repository.PilotRepository;

import java.util.Collection;
import java.util.List;

@RestController
class PilotController {
	private PilotRepository repository;

	public PilotController(PilotRepository repository) {

		this.repository = repository;
	}

	@GetMapping("/list-pilots")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Pilot> listOfPilots() {
		return repository.findAll();
	}

	@GetMapping("/findpilot")
	@CrossOrigin(origins = "http://localhost:4200")
	public Pilot findById(
			@RequestParam(required= true) Integer pilotId
	) {
		return repository.findById(pilotId).get();
	}

	@DeleteMapping("/deletepilot")
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteById(
			@RequestParam(required= true) Integer pilotId
	) {
		System.out.println("Delete pilot called");
		Pilot p = repository.findById(pilotId).get();
		repository.delete(p);
	}

	@PostMapping("/addpilot")
	@CrossOrigin(origins = "http://localhost:4200")
	public Pilot addPilot(
			@RequestBody Pilot pilot
	) {
		System.out.println("Add pilot called");
		repository.save(pilot);
		return pilot;
	}
}
