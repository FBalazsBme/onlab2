package ticketservice;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import ticketservice.model.*;
import ticketservice.repository.*;

import java.util.Date;

@SpringBootApplication
public class TicketApplication {
	


	public static void main(String[] args) {

		SpringApplication.run(TicketApplication.class, args);
	}

	@Bean
	ApplicationRunner init(AircraftRepository aircraftRepository,
						   AirportRepository airportrepository,
						   FlightRepository flightRepository,
						   LuggageRepository luggageRepository,
						   PassengerRepository passengerRepository,
						   PilotRepository pilotRepository,
						   UserRepository userRepository) {
		return args -> {
/*			Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
					"AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV").forEach(name -> {
				Car car = new Car();
				car.setName(name);
				repository.save(car);
			});*/

			aircraftRepository.deleteAll();
			Aircraft a1 = new Aircraft(Size.MEDIUM, 120, 110);
			Aircraft a2 = new Aircraft(Size.BIG_2_ENGINES, 180, 160);
			aircraftRepository.save(a1);
			aircraftRepository.save(a2);

			airportrepository.deleteAll();
			Airport ai1 = new Airport("Budapest", 10, 10, 10, 10, 10);
			Airport ai2 = new Airport("Debrecen", 2, 10, 10, 0, 0);
			airportrepository.save(ai1);
			airportrepository.save(ai2);

			flightRepository.deleteAll();
			Flight fl1 = new Flight(10, 120, 100, 100, new Date("01/01/2010"),
					new Date("01/01/2011"), 10);
			Flight fl2 = new Flight();
			flightRepository.save(fl1);
			flightRepository.save(fl2);

			passengerRepository.deleteAll();
			Passenger pas1 = new Passenger(10,"Budapest", "45421215", new Date ("01/01/1990"));
			Passenger pas2 = new Passenger(10,"Debrecen", "45889215", new Date ("01/01/2010"));
			passengerRepository.save(pas1);
			passengerRepository.save(pas2);

			luggageRepository.deleteAll();
			Luggage l1 = new Luggage();
			Luggage l2 = new Luggage(20, pas1);
			luggageRepository.save(l1);
			luggageRepository.save(l2);

			pilotRepository.deleteAll();
			Pilot p1 = new Pilot("Mr. Fast", Size.MEDIUM);
			Pilot p2 = new Pilot("Dr. Strange", Size.BIG_4_ENGINES);
			pilotRepository.save(p1);
			pilotRepository.save(p2);

			userRepository.deleteAll();
			User u1 = new User(true, false, "userteszt", "userteszt");
			User u2 = new User(false, false, "felhasznalo", "felhasznalo");
			User u3 = new User(false, true, "adminadmin", "adminadmin");
			User u4 = new User(true, false, "peldabbb", "jelszo");
			userRepository.save(u1);
			userRepository.save(u2);
			userRepository.save(u3);
			userRepository.save(u4);
		};
	}
	
}
