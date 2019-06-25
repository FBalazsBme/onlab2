package ticketservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import ticketservice.model.User;


@CrossOrigin(origins = "http://localhost:4200")
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);
}
