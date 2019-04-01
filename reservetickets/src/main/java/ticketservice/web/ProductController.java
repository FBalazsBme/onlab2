package ticketservice.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ticketservice.model.Product;
import ticketservice.repository.ProductRepository;

@RestController
//@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/product")
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@GetMapping("/product/{id}")
	public List<Product> getProductById(@PathVariable int id) {
		Optional<Product> products = productRepository.findById(id);
		ArrayList<Product> result = new ArrayList<>();
		products.ifPresent(result::add);
		return result;
	}
	
	@PostMapping("/product")
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}

	@PostMapping("/product/{id}")
	public Product modifyProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
}
