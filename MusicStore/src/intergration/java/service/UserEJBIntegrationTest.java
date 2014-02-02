package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.authentication.RoleEnum;
import model.authentication.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import testutil.IntegrationTestBase;

@RunWith(MockitoJUnitRunner.class)
public class UserEJBIntegrationTest extends IntegrationTestBase {

	static User user = new User();

	static {
		user.setUsername("ilja");
	}

	@Test
	public void testFindByUsername() throws Exception {
		assertEquals(0l, userEJB.count());
		userEJB.create(user);
		assertEquals(1, userEJB.count());
		assertEquals(user, userEJB.findByUsername("ilja"));
	}

	@Test
	public void testCreate() throws Exception {
		assertEquals(0l, userEJB.count());
		userEJB.create(user);
		assertEquals(1, userEJB.count());
		assertEquals("ilja", user.getUsername());
		assertEquals(RoleEnum.USER.toString(), user.getUserRole().getRole());
	}

	@Test
	public void testGetEm() throws Exception {
		assertNotNull(userEJB.getEm());
	}

}
