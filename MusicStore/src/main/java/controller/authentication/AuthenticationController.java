package controller.authentication;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import service.authentication.AuthenticationEJB;

/**
 * @author ilja This class does not implemented
 */
@Named
@SessionScoped
public class AuthenticationController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private AuthenticationEJB authenticationEJB;

	private String userWhoWantsToLoginUsername;
	private String userWhoWantsToLoginPassword;
	private boolean userWhoWantsToLoginWantsToBeRemembered;

	public void loginWithRealm() {
		boolean loginWasSuccesful = authenticationEJB.loginWithRealm();
		FacesContext context = FacesContext.getCurrentInstance();
		if (loginWasSuccesful == false) {
			FacesMessage facesMessage = new FacesMessage(
					"There was problems with logging in!");
			context.addMessage("loginbutton:username", facesMessage);
			context.addMessage(null, facesMessage);
		}
	}

	public boolean loginWithUserNameAndPassword() {
		boolean loginSucceeded = authenticationEJB
				.loginWithUserNameAndPassword(userWhoWantsToLoginUsername,
						userWhoWantsToLoginPassword);
		return loginSucceeded;
	}

	public void logout() {
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
	}

	public AuthenticationEJB getAuthenticationEJB() {
		return authenticationEJB;
	}

	public void setAuthenticationEJB(
			final AuthenticationEJB userAuthenticationEJB) {
		this.authenticationEJB = userAuthenticationEJB;
	}

	public String getUserWhoWantsToLoginPassword() {
		return userWhoWantsToLoginPassword;
	}

	public void setUserWhoWantsToLoginPassword(
			final String userWhoWantsToLoginPassword) {
		this.userWhoWantsToLoginPassword = userWhoWantsToLoginPassword;
	}

	public String getUserWhoWantsToLoginUsername() {
		return userWhoWantsToLoginUsername;
	}

	public void setUserWhoWantsToLoginUsername(
			final String userWhoWantsToLoginUsername) {
		this.userWhoWantsToLoginUsername = userWhoWantsToLoginUsername;
	}

	public boolean isUserWhoWantsToLoginWantsToBeRemembered() {
		return userWhoWantsToLoginWantsToBeRemembered;
	}

	public void setUserWhoWantsToLoginWantsToBeRemembered(
			final boolean userWhoWantsToLoginWantsToBeRemembered) {
		this.userWhoWantsToLoginWantsToBeRemembered = userWhoWantsToLoginWantsToBeRemembered;
	}

}
