package ticketservice.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Pilota {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Meret jogositvanyTipus;

	@Setter
	@OneToMany
	private List<Jarat> jaratok;

	@OneToOne
	private Jarat aktualisJarat;

	public Pilota(String name, Meret jogositvanyTipus) {
		this.name = name;
		this.jogositvanyTipus = jogositvanyTipus;
		jaratok = new ArrayList<>();
		aktualisJarat = null;
	}

	public Pilota(String name, Meret jogositvanyTipus, Jarat aktualisJarat) {
		this.name = name;
		jaratok = new ArrayList<>();
		this.jogositvanyTipus = jogositvanyTipus;
		this.aktualisJarat = aktualisJarat;
		jaratok.add(aktualisJarat);
	}


}
