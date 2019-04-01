package ticketservice.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Gep {

	@Id
	@GeneratedValue
	private Integer id;

	private Meret meret;
	private Integer maxFerohelyek;
	private Integer maxPoggyaszteher;


	@OneToMany(mappedBy="gep")
	private Set<Jarat> jaratok;

	public Gep(Meret meret, Integer maxFerohelyek, Integer maxPoggyaszteher) {
		this.jaratok = new LinkedHashSet<>();
		this.meret = meret;
		this.maxFerohelyek = maxFerohelyek;
		this.maxPoggyaszteher = maxPoggyaszteher;
	}

}
