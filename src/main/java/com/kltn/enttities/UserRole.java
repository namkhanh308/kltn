package com.kltn.enttities;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private int id;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	@ManyToOne
	@JoinColumn(name = "roleId")
	private Role role;
	
	public UserRole() {
	}
	
	public UserRole(int id, User user, Role role) {
		super();
		this.id = id;
		this.user = user;
		this.role = role;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
