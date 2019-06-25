package ticketservice.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
public class Passenger {
	@Id
	@GeneratedValue
	private Integer id;

	private Integer points;
	private String homeAirport;
	private String creditCardNumber;
	private Date birthDate;


	@OneToMany
	private Set<Flight> jaratok;

	public Passenger(){
		points = 0;
		homeAirport = "";
		creditCardNumber = "";
		birthDate = new Date ("01/01/1990");
	}

	public Passenger(Integer points, String homeAirport, String creditCardNumber, Date birthDate) {
		this.points = points;
		this.homeAirport = homeAirport;
		this.creditCardNumber = creditCardNumber;
		this.birthDate = birthDate;
	}

	public Passenger(Integer points, String homeAirport, String creditCardNumber, Date birthDate, Set<Flight> jaratok) {
		this.points = points;
		this.homeAirport = homeAirport;
		this.creditCardNumber = creditCardNumber;
		this.birthDate = birthDate;
		this.jaratok = jaratok;
	}

}
