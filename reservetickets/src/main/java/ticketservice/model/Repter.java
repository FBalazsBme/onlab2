package ticketservice.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Repter {

	@Id
	@GeneratedValue
	private Integer id;

	private String nev;
	private Integer tartozkodoRepulokSzama;
	private Integer szabadhelyekKisgep;
	private Integer szabadhelyekKozepesgep;
	private Integer szabadhelyekNagy2Motoros;
	private Integer szabadhelyekNagy4Motoros;

	public Repter(String nev, Integer tartozkodoRepulokSzama, Integer szabadhelyekKisgep, Integer szabadhelyekKozepesgep, Integer szabadhelyekNagy2Motoros, Integer szabadhelyekNagy4Motoros) {
		this.nev = nev;
		this.tartozkodoRepulokSzama = tartozkodoRepulokSzama;
		this.szabadhelyekKisgep = szabadhelyekKisgep;
		this.szabadhelyekKozepesgep = szabadhelyekKozepesgep;
		this.szabadhelyekNagy2Motoros = szabadhelyekNagy2Motoros;
		this.szabadhelyekNagy4Motoros = szabadhelyekNagy4Motoros;
	}

}
