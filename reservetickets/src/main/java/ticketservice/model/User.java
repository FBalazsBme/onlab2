package ticketservice.model;

import javax.persistence.*;
import javax.xml.bind.DatatypeConverter;

import lombok.Getter;
import lombok.Setter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Getter
@Setter
@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer id;

	private Boolean staff;
	private Boolean admin;
	private String firstName;
	private String lastName;
	@Column(name="username", unique=true)
	private String username;
	private String password;



	public User(){
		this.staff = false;
		this.admin = false;
		this.username = "username";
		this.password = "password";
	}

	public User(Boolean staff, Boolean admin,
				String username, String password) {
		this.staff = staff;
		this.admin = admin;
		this.username = username;
		this.password = password;
		this.firstName = "Pelda";
		this.lastName = "Elek";
	}

	public User(Boolean staff, Boolean admin,
				String firstName, String lastName,
				String username, String password) {
		this.staff = staff;
		this.admin = admin;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	public boolean checkPassword(String password){
		return this.password.equals(password);
	}

	public String generatePassword(){
		MessageDigest messageDigest;
		String stringForHashCode = "message";
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(this.password.getBytes());
			byte[] digest = messageDigest.digest();
			stringForHashCode = DatatypeConverter
					.printHexBinary(digest).toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return stringForHashCode;
	}

}
