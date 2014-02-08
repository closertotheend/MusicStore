package controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.authentication.User;
import service.UserEJB;
import controller.util.MessagesHelper;

/**
 * @author ilja
 * 
 */
@Named
@SessionScoped
public class UserController implements Serializable {
	private static final long serialVersionUID = 1L;
	private User user;

	@Inject
	private UserEJB userEJB;

	/**
	 * Persists user and shows success message
	 */
	public void save(final User user) {
		getUserEJB().create(user);
		MessagesHelper.INSTANCE.showCreatedSuccessfullyMessage("user");
	}

	public List<User> getAllUsers() {
		return getUserEJB().findAll();
	}

	// GETTERS SETTERS
	public User getUser() {
		if (user == null) {
			user = new User();
		}
		return user;
	}

	public void setUser(final User user) {
		this.user = user;
	}

	public UserEJB getUserEJB() {
		return userEJB;
	}

	public void setUserEJB(UserEJB userEJB) {
		this.userEJB = userEJB;
	}
}
