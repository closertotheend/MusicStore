package testutil;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;

public class IntegrationTestBase {

	protected static final EntityManager fakeEm = Persistence
			.createEntityManagerFactory("TEST").createEntityManager();

	public IntegrationTestBase() {
		super();
	}

	@Before
	public void init() {
		fakeEm.getTransaction().begin();
	}

	@After
	public void after() {
		fakeEm.getTransaction().rollback();
	}

}