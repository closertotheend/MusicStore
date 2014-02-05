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
	private SessionContext ctx;

	@Inject
	private UserEJB userEJB;

	@Inject
	private Logger logger;

	private User currentUser;

	public boolean isUserAuthenticated() {
		try {
			return !getCtx().getCallerPrincipal().getName().equals("ANONYMOUS");
		} catch (Exception e) {
			return false;
		}
	}

	public String getRealmUsername() {
		return getCtx().getCallerPrincipal().getName();
	}

	public String getRealmGroup() {
		try {
			return getCurrentUser().getUserRole().getRole();
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

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(final User currentUser) {
		this.currentUser = currentUser;
	}

	public SessionContext getCtx() {
		return ctx;
	}

	public UserEJB getUserEJB() {
		return userEJB;
	}

}
