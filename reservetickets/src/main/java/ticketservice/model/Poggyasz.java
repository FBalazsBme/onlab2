package ticketservice.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Poggyasz {

	@Id
	@GeneratedValue
	private Integer id;

	private Integer tomeg;

	@Setter
	@OneToOne
	private Utas utas;

	public Poggyasz(Integer tomeg, Utas utas) {
		this.tomeg = tomeg;
		this.utas = utas;
	}

}
