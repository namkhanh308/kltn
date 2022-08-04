package com.kltn.enttities;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "role_name")
	private String roleName;

	
	@OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
	private List<UserRole> userRole;
	
	public Role() {
	}
	public Role(int id, String roleName, List<UserRole> userRole) {
		this.id = id;
		this.roleName = roleName;
		this.userRole = userRole;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public List<UserRole> getUserRole() {
		return userRole;
	}
	public void setUserRole(List<UserRole> userRole) {
		this.userRole = userRole;
	}
	
	
	
}
