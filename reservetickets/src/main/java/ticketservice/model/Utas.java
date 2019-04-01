package ticketservice.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class Utas {
	@Id
	@GeneratedValue
	private Integer id;

	private Integer pontok;
	private String lakhelyRepter;
	private String bankkartyaszam;
	private String szuletesiIdo;

	@OneToMany
	private Set<Jarat> jaratok;

	public Utas(Integer pontok, String lakhelyRepter, String bankkartyaszam, String szuletesiIdo, Set<Jarat> jaratok) {
		this.pontok = pontok;
		this.lakhelyRepter = lakhelyRepter;
		this.bankkartyaszam = bankkartyaszam;
		this.szuletesiIdo = szuletesiIdo;
		this.jaratok = jaratok;
	}

}
