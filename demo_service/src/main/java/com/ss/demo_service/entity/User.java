package com.ss.demo_service.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
//@Table(name="user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private Integer id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id", referencedColumnName = "id")
	private UserRole role;

	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	private int active;

	private String roles = "";

	public User() {
	};

	public User(Integer id, String username, String password, int active, String roles) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.active = active;
		this.roles = roles;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the roleId
	 */
	public UserRole getRole() {
		return role;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRole(UserRole role) {
		this.role = role;
	}
	
	/**
	 * @return the active
	 */
	public int getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(int active) {
		this.active = active;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getRoleList() {

		if (this.roles.length() > 0) {

			return Arrays.asList(this.roles.split(","));
		}

		return new ArrayList<String>();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

}
