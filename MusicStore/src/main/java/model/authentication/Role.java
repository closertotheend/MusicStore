package model.authentication;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import model.abstractions.EntityInterface;

/**
 * Entity implementation class for Entity: Roles
 * 
 */
@Entity
public class Role implements Serializable, EntityInterface {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private String role;

	public Role() {
		super();
	}

	public Role(final String username, final RoleEnum role) {
		this.username = username;
		this.role = role.toString();
	}

	@Override
	public long getId() {
		return this.id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(final String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

}
