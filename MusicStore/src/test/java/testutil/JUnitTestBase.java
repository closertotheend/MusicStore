package testutil;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import javax.ejb.SessionContext;

import org.junit.BeforeClass;

import service.UserEJB;
import service.authentication.AuthenticationEJB;
import testutil.fakesession.FakeSessionContext;

public class JUnitTestBase {
	protected static SessionContext fakeSessionContext = spy(new FakeSessionContext());
	protected static AuthenticationEJB authenticationEJB = spy(new AuthenticationEJB());
	protected static UserEJB userEJB = spy(new UserEJB());

	@BeforeClass
	public static void initOnce() {
		when(authenticationEJB.getCtx()).thenReturn(fakeSessionContext);
		when(authenticationEJB.getUserEJB()).thenReturn(userEJB);
	}
}
