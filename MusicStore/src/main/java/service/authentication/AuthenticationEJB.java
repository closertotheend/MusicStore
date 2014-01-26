package service.authentication;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.authentication.User;
import service.UserEJB;

@Stateful
@LocalBean
@Named
public class AuthenticationEJB {

	private User currentSessionUser = new User(0, "ANONYMOUS", null, null);
	private boolean isAuthenitcated = false;

	@Resource
	SessionContext ctx;

	@PersistenceContext(unitName = "MusicStore")
	private EntityManager em;

	@Inject
	private UserEJB userEJB;

	public boolean loginWithRealm() {
		String glassfishRealmUsername = ctx.getCallerPrincipal().getName();
		User user = userEJB.findByUsername(glassfishRealmUsername);
		if (user != null) {
			isAuthenitcated = true;
			setCurrentSessionUser(user);
			return true;
		} else {
			// getCurrentSessionUser().setUsername(callerKey
			// + " !! not syncronized with db");
			return false;
		}
	}

	public boolean loginWithUserNameAndPassword(final String username,
			final String password) {
		User user = userEJB.findByUsername(username);
		if ((user != null) && user.getPassword().equals(password)) {
			isAuthenitcated = true;
			setCurrentSessionUser(user);
			return true;
		} else {
			return false;
		}
	}

	public boolean isUserAuthenticated() {
		return isAuthenitcated;
	}

	public User getCurrentSessionUser() {
		return currentSessionUser;
	}

	public void setCurrentSessionUser(final User currentSessionUser) {
		this.currentSessionUser = currentSessionUser;
	}

}
