package service.authentication;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import model.authentication.User;
import service.UserEJB;

@Stateful
@LocalBean
@Named
@DeclareRoles({ "ADMIN", "MODERATOR", "USER" })
public class AuthenticationEJB {

	@Resource
	SessionContext ctx;

	@PersistenceContext(unitName = "MusicStore")
	private EntityManager em;

	@Inject
	private UserEJB userEJB;

	@Inject
	private Logger logger;

	private User currentUser;

	public boolean isUserAuthenticated() {
		return !ctx.getCallerPrincipal().getName().equals("ANONYMOUS");
	}

	public String getRealmUsername() {
		return ctx.getCallerPrincipal().getName();
	}

	public String getRealmGroup() {
		try {
			return currentUser.getUserRole().getRole();
		} catch (Exception e) {
			return "Undefined group";
		}
	}

	public void login(final String username, final String password) {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		try {
			request.login(username, password);
			User user = userEJB.findByUsername(username);
			setCurrentUser(user);
			logger.log(Level.FINE, "User " + user.getUsername()
					+ " has logged in!");
		} catch (ServletException e) {
			e.printStackTrace();
		}

	}

	public UserEJB getUserEJB() {
		return userEJB;
	}

	public void setUserEJB(final UserEJB userEJB) {
		this.userEJB = userEJB;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(final User currentUser) {
		this.currentUser = currentUser;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(final Logger logger) {
		this.logger = logger;
	}

}
