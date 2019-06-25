package ticketservice.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Aircraft {

	@Id
	@GeneratedValue
	private Integer id;

	private Size size;
	private Integer maxSeats;
	private Integer maxLuggageSize;


	@OneToMany(mappedBy="aircraft")
	private Set<Flight> flights;

	public Aircraft() {
		size = Size.MEDIUM;
		maxSeats = 0;
		maxLuggageSize = 0;
	}

	public Aircraft(Size size, Integer maxSeats, Integer maxLuggageSize) {
		this.flights = new LinkedHashSet<>();
		this.size = size;
		this.maxSeats = maxSeats;
		this.maxLuggageSize = maxLuggageSize;
	}

}
