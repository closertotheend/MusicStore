package model.authentication;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import model.abstractions.EntityInterface;

/**
 * Entity implementation class for Entity: User
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = User.FIND_BY_USERNAME, query = "SELECT u FROM User u where u.username = :username") })
public class User implements Serializable, EntityInterface {
	private static final long serialVersionUID = 1L;

	public static final String FIND_BY_USERNAME = "User.findByUsername";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private String password;

	@OneToOne
	private Role userRole;

	public User() {
		super();
	}

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(final Role userRole) {
		this.userRole = userRole;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(final String name) {
		this.username = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", userRole=" + getUserRole() + "]";
	}

}
