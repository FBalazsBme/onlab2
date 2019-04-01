package ticketservice.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Jarat {

	@Id
	@GeneratedValue
	private Integer id;

	private Integer jaratSzam;
	private Integer utasokSzama;
	private Integer szabadHelyekSzama;
	private Integer kiindulorepterId;
	private Integer celrepterId;
	private Date startDatum;
	private Date vegDatum;
	private Integer jaratId;

	@ManyToOne
	private Gep gep;

	@ManyToOne
	private Pilota pilota;

	public Jarat() {
	}

	public Jarat(Integer utasokSzama, Integer szabadHelyekSzama, Integer kiindulorepterId, Integer celrepterId, Date startDatum, Date vegDatum, Integer jaratId, Gep gep, Pilota pilota) {
		this.utasokSzama = utasokSzama;
		this.szabadHelyekSzama = szabadHelyekSzama;
		this.kiindulorepterId = kiindulorepterId;
		this.celrepterId = celrepterId;
		this.startDatum = startDatum;
		this.vegDatum = vegDatum;
		this.jaratId = jaratId;
		this.gep = gep;
		this.pilota = pilota;
	}

	public Jarat(Integer utasokSzama, Integer szabadHelyekSzama, Integer kiindulorepterId, Integer celrepterId, Date startDatum, Date vegDatum,
				 Integer jaratId, Gep gep, String pilotaNev, Meret jogositvanyTipus) {
		this.utasokSzama = utasokSzama;
		this.szabadHelyekSzama = szabadHelyekSzama;
		this.kiindulorepterId = kiindulorepterId;
		this.celrepterId = celrepterId;
		this.startDatum = startDatum;
		this.vegDatum = vegDatum;
		this.jaratId = jaratId;
		this.gep = gep;
		this.pilota = new Pilota(pilotaNev, jogositvanyTipus, this);
	}
}
