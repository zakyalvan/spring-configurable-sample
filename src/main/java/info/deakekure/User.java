package info.deakekure;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable {
	private String fullname;
	private String username;
	private String password;
	
	public User(String fullname, String username, String password) {
		this.fullname = fullname;
		this.username = username;
		this.password = password;
	}
	
	public String getFullname() {
		return fullname;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
}
