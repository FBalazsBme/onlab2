package ticketservice.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ticketservice.wrappers.BoolResponse;
import ticketservice.wrappers.StringResponse;
import ticketservice.model.User;
import ticketservice.repository.UserRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.Collection;

@RestController
//@Produces({"application/json"})
public class UserController {
	private UserRepository repository;
	private static boolean adminLoggedIn = false;
	private static boolean userLoggedIn = false;

	public UserController(UserRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/list-users")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<User> listOfUser() {
		return repository.findAll();
	}

	@GetMapping("/find-username")
	@CrossOrigin(origins = "http://localhost:4200")
	public User findByUsername(
			@RequestParam(required= true) String userName
	) {
		return repository.findByUsername(userName);
	}

	@PostMapping("/getuserbylogin")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<User> findByUsernameWithPassword(
			@RequestBody User user
	) {
		User userfound = repository.findByUsername(user.getUsername());
		System.out.println("checklogin called with " + userfound.getUsername());
		if(userfound == null){

			return new ResponseEntity<User>(new User(),
					HttpStatus.NO_CONTENT);
		}
		else {
			if(userfound.checkPassword(user.getPassword())){
				return new ResponseEntity<User>(userfound,
						HttpStatus.OK);
			}
			else {
				return new ResponseEntity<User>(new User(),
						HttpStatus.FORBIDDEN);
			}
		}
	}

	@GetMapping("/checklogin")
	@CrossOrigin(origins = "http://localhost:4200")
	@Produces({"application/json"})
	public ResponseEntity<BoolResponse>  getPassword(
			@RequestParam(required= true) String userName,
			@RequestParam(required= true) String password
	) {
		User user = repository.findByUsername(userName);
		System.out.println("checklogin called with " + userName);
		if(user == null){
			System.out.println("User does not exist");
			return new ResponseEntity<BoolResponse>(new BoolResponse(false),
			HttpStatus.BAD_REQUEST);

		}
		else {
			if(user.checkPassword(password)){
				return new ResponseEntity<BoolResponse>(new BoolResponse(true),
						HttpStatus.OK);
			}
			else {
				return new ResponseEntity<BoolResponse>(new BoolResponse(false),
						HttpStatus.FORBIDDEN);
			}
		}
	}

	@PostMapping("/adduser")
	@CrossOrigin(origins = "http://localhost:4200")
	public void addUser(
			@RequestBody User user
	) {
		System.out.println("Save user called");
		repository.save(user);
	}

	@DeleteMapping("/deleteuser")
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteById(
			@RequestParam(required= true) Integer userId
	) {
		System.out.println("Delete user called");
		User u = repository.findById(userId).get();
		repository.delete(u);
	}

	@GetMapping("/isadminloggedin")
	@CrossOrigin(origins = "http://localhost:4200")
	public BoolResponse isAdminLoggedIn(
	) {
		return new BoolResponse(adminLoggedIn);
	}

	@GetMapping("/isuserloggedin")
	@CrossOrigin(origins = "http://localhost:4200")
	public BoolResponse isUserLoggedIn(
	) {
		return new BoolResponse(userLoggedIn);
	}

	@GetMapping("/letadminloggedin")
	@CrossOrigin(origins = "http://localhost:4200")
	public BoolResponse isAdminLoggedIn(
			@RequestParam(required= true) Integer userId
	) {
		return new BoolResponse(adminLoggedIn);
	}

}