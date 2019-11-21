package com.techelevator.npgeek;

import javax.validation.constraints.AssertTrue;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Login {

	@NotBlank(message="Please enter a username")
	private String username;
	
	@NotBlank(message="Please enter an email address")
	@Email(message="Please enter a valid email address")
	private String email;
	private String verifyEmail;
	
	@NotBlank(message="Please enter a password")
	private String password;
	private String verifyPassword;
	
	@AssertTrue(message="Passwords must match")
	public boolean isPasswordMatching() {
		if (password != null) {
			return password.equals(verifyPassword);
		}
		return true;
	}
	
	@AssertTrue(message="Email addresses must match")
	public boolean isEmailMatching() {
		if (email != null) {
			return email.equals(verifyEmail);
		}
		return true;
	}
	
	public Login() {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVerifyEmail() {
		return verifyEmail;
	}

	public void setVerifyEmail(String verifyEmail) {
		this.verifyEmail = verifyEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	
	
}
