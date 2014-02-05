package service.authentication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.security.Principal;

import javax.ejb.SessionContext;

import model.authentication.Role;
import model.authentication.RoleEnum;
import model.authentication.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import service.UserEJB;
import testutil.JUnitTestBase;
import testutil.fakesession.FakeSessionContext;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationEJBTest extends JUnitTestBase {
	protected static SessionContext fakeSessionContext;
	protected static AuthenticationEJB authenticationEJB;
	protected static UserEJB userEJB;

	@Before
	public void init() {
		fakeSessionContext = spy(new FakeSessionContext());
		authenticationEJB = spy(new AuthenticationEJB());
		userEJB = spy(new UserEJB());
		when(authenticationEJB.getCtx()).thenReturn(fakeSessionContext);
		when(authenticationEJB.getUserEJB()).thenReturn(userEJB);
	}

	@Test
	public void testIsUserAuthenticated() {
		assertFalse(authenticationEJB.isUserAuthenticated());
		assertNotNull(authenticationEJB.getCtx());
		Principal callerPrincipal = authenticationEJB.getCtx()
				.getCallerPrincipal();
		assertNotNull(callerPrincipal);
		when(callerPrincipal.getName()).thenReturn("ilja");
		assertTrue(authenticationEJB.isUserAuthenticated());
	}

	@Test
	public void testGetRealmUsername() {
		assertNull(authenticationEJB.getRealmUsername());
		when(fakeSessionContext.getCallerPrincipal().getName()).thenReturn(
				"ilja");
		assertEquals("ilja", authenticationEJB.getRealmUsername());
	}

	@Test
	public void testGetRealmGroup() {
		assertNull(authenticationEJB.getCurrentUser());
		User ilja = new User();
		ilja.setUsername("ilja");
		ilja.setUserRole(new Role(ilja.getUsername(), RoleEnum.ADMIN));
		when(authenticationEJB.getCurrentUser()).thenReturn(ilja);
		assertNotNull(authenticationEJB.getCurrentUser());
		assertEquals("ADMIN", authenticationEJB.getRealmGroup());
	}

	public void testLogin() {
		// Not testable??
	}

	@Test
	public void testGetCtx() {
		assertNotNull(authenticationEJB.getCtx());
	}

	@Test
	public void testGetUserEJB() {
		assertNotNull(authenticationEJB.getUserEJB());
	}
}
