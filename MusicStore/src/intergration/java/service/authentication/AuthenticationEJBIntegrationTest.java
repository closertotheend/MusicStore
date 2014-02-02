package service.authentication;

import java.util.logging.Level;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import model.authentication.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import service.UserEJB;
import testutil.IntegrationTestBase;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationEJBIntegrationTest extends IntegrationTestBase {
	public boolean testIsUserAuthenticated() {
		return !ctx.getCallerPrincipal().getName().equals("ANONYMOUS");
	}

	public String testGetRealmUsername() {
		return ctx.getCallerPrincipal().getName();
	}

	public String testGetRealmGroup() {
		try {
			return currentUser.getUserRole().getRole();
		} catch (Exception e) {
			return "Undefined group";
		}
	}

	public void testLogin(final String username, final String password) {
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

	@Test
	public UserEJB testGetUserEJB() {
		return userEJB;
	}
}
