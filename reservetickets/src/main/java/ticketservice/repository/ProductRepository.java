package ticketservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ticketservice.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findByName(String name);
	
}
