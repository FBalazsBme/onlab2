package ticketservice.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Flight {

	@Id
	@GeneratedValue
	private Integer id;
	private Integer numberOfPassengers;
	private Integer numberOfFreeSeats;
	private Integer originAirportId;
	private Integer destinationAirportId;
	private Date startDate;
	private Date finishDate;
	private Integer flightId;

	@ManyToOne
	private Aircraft aircraft;

	@ManyToOne
	private Pilot pilot;

	public Flight() {
		numberOfPassengers = 0;
		numberOfFreeSeats = 0;
		originAirportId = 0;
		destinationAirportId = 0;
		startDate = new Date("01/01/1990");
		finishDate =  new Date("01/01/1990");
		flightId = 0;
	}

	public Flight(Integer numberOfPassengers, Integer numberOfFreeSeats,
				  Integer originAirportId, Integer destinationAirportId,
				  Date startDate, Date finishDate, Integer flightId) {
		this.numberOfPassengers = numberOfPassengers;
		this.numberOfFreeSeats = numberOfFreeSeats;
		this.originAirportId = originAirportId;
		this.destinationAirportId = destinationAirportId;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.flightId = flightId;
	}

	public Flight(Integer numberOfPassengers, Integer numberOfFreeSeats,
				  Integer originAirportId, Integer destinationAirportId,
				  Date startDate, Date finishDate, Integer flightId,
				  Aircraft aircraft, Pilot pilot) {
		this.numberOfPassengers = numberOfPassengers;
		this.numberOfFreeSeats = numberOfFreeSeats;
		this.originAirportId = originAirportId;
		this.destinationAirportId = destinationAirportId;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.flightId = flightId;
		this.aircraft = aircraft;
		this.pilot = pilot;
	}

	public Flight(Integer numberOfPassengers, Integer numberOfFreeSeats, Integer originAirportId, Integer destinationAirportId, Date startDate, Date finishDate,
				  Integer flightId, Aircraft aircraft, String pilotaNev, Size jogositvanyTipus) {
		this.numberOfPassengers = numberOfPassengers;
		this.numberOfFreeSeats = numberOfFreeSeats;
		this.originAirportId = originAirportId;
		this.destinationAirportId = destinationAirportId;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.flightId = flightId;
		this.aircraft = aircraft;
		this.pilot = new Pilot(pilotaNev, jogositvanyTipus, this);
	}
}
