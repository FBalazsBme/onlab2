package ticketservice.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Luggage {

	@Id
	@GeneratedValue
	private Integer id;

	private Integer weight;

	@Setter
	@OneToOne(fetch=FetchType.LAZY)
	private Passenger passenger;

	public Luggage() {
		weight = 0;
		passenger = null;
	}

	public Luggage(Integer weight, Passenger passenger) {
		this.weight = weight;
		this.passenger = passenger;
	}

}
