package com.kltn.enttities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user",catalog = "dmloc")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<UserRole> userRole = new ArrayList<>();
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int id, String userName, String password, String email, List<UserRole> userRole) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.userRole = userRole;
	}

	public User(String userName, String password, String email) {
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public List<UserRole> getUserRole() {
		return userRole;
	}



	public void setUserRole(List<UserRole> userRole) {
		this.userRole = userRole;
	}



	@Transient
	public List<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (UserRole ur : userRole) {
			authorities.add(new SimpleGrantedAuthority(ur.getRole().getRoleName()));
		}
		return authorities;
	}
}
