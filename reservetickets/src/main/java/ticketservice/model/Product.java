package ticketservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	private double price;
	
	public Product() {
	}

	public Product(Integer id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Product(Integer id, String name, double price, String catName) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
}
