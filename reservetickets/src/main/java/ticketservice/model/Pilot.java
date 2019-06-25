package ticketservice.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Pilot {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(name="name", unique=true)
	private String name;
	private Size licenseType;

	@Setter
	@OneToMany
	private List<Flight> flights;

	@OneToOne
	private Flight actualFlight;

	public Pilot(){
		this.name = "default";
		this.licenseType = Size.SMALL;
		flights = new ArrayList<>();
		actualFlight = null;
	}

	public Pilot(String name, Size licenseType) {
		this.name = name;
		this.licenseType = licenseType;
		flights = new ArrayList<>();
		actualFlight = null;
	}

	public Pilot(String name, Size licenseType, Flight actualFlight) {
		this.name = name;
		flights = new ArrayList<>();
		this.licenseType = licenseType;
		this.actualFlight = actualFlight;
		flights.add(actualFlight);
	}


}
