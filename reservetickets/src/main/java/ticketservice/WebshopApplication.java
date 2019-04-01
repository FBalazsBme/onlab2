package ticketservice;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import ticketservice.model.Jarat;
import ticketservice.model.Meret;
import ticketservice.model.Pilota;
import ticketservice.repository.JaratRepository;
import ticketservice.repository.PilotaRepository;

@SpringBootApplication
public class WebshopApplication {
	


	public static void main(String[] args) {
		SpringApplication.run(WebshopApplication.class, args);
	}

	@Bean
	ApplicationRunner init(PilotaRepository pilotaRepository) {
		return args -> {
/*			Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
					"AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV").forEach(name -> {
				Car car = new Car();
				car.setName(name);
				repository.save(car);
			});*/
			pilotaRepository.save(new Pilota("Mr. Smith", Meret.BIG_2_ENGINES));
		};
	}
	
}
