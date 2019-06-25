package ticketservice.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Airport {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name="name", unique=true)
	private String name;
	private Integer numberOfCurrentAircraft;
	private Integer freeSlotsSmallAircraft;
	private Integer freeSlotsMediumAirCraft;
	private Integer freeSlotsBig2Engines;
	private Integer freeSlotsBig4Engines;

	public Airport() {
		name = "";
		numberOfCurrentAircraft = 0;
		freeSlotsSmallAircraft = 0;
		freeSlotsMediumAirCraft = 0;
		freeSlotsBig2Engines = 0;
		freeSlotsBig4Engines = 0;
	}

	public Airport(String name, Integer numberOfCurrentAircraft, Integer freeSlotsSmallAircraft, Integer freeSlotsMediumAirCraft, Integer freeSlotsBig2Engines, Integer freeSlotsBig4Engines) {
		this.name = name;
		this.numberOfCurrentAircraft = numberOfCurrentAircraft;
		this.freeSlotsSmallAircraft = freeSlotsSmallAircraft;
		this.freeSlotsMediumAirCraft = freeSlotsMediumAirCraft;
		this.freeSlotsBig2Engines = freeSlotsBig2Engines;
		this.freeSlotsBig4Engines = freeSlotsBig4Engines;
	}

}
