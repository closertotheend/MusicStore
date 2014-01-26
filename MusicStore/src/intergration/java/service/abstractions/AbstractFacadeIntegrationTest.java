package service.abstractions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import service.abstractions.AbstractFacade;
import util.FakeEntity;
import util.FakeEntityEJB;

@RunWith(MockitoJUnitRunner.class)
public class AbstractFacadeIntegrationTest {

	private static final AbstractFacade<FakeEntity> abstractFacade = spy(new FakeEntityEJB());
	private final FakeEntity entity = new FakeEntity(13);
	private final FakeEntity entity2 = new FakeEntity(14);
	private final FakeEntity entity3 = new FakeEntity(15);
	private static final EntityManager fakeEm = Persistence
			.createEntityManagerFactory("TEST").createEntityManager();

	@BeforeClass
	public static void initBehaviour() {
		when(abstractFacade.getEm()).thenReturn(fakeEm);
	}

	@Before
	public void init() {
		abstractFacade.getEm().getTransaction().begin();
	}

	@After
	public void after() {
		abstractFacade.getEm().getTransaction().rollback();
	}

	@Test
	public void testGetEm() {
		assertNotNull(abstractFacade.getEm());
		assertFalse(abstractFacade.getEm().contains(entity));
	}

	@Test
	public void testCreate() {
		abstractFacade.create(entity);
		assertTrue(abstractFacade.getEm().contains(entity));
	}

	@Test
	public void testDelete() {
		abstractFacade.create(entity);
		assertTrue(abstractFacade.getEm().contains(entity));
		abstractFacade.delete(entity);
		assertFalse(abstractFacade.getEm().contains(entity));
	}

	@Test
	public void testFindAll() {
		abstractFacade.create(entity);
		abstractFacade.create(entity2);
		assertEquals(2, abstractFacade.findAll().size());
	}

	@Test
	public void testFind() {
		assertFalse(abstractFacade.getEm().contains(entity));
		abstractFacade.create(entity);
		abstractFacade.create(entity2);
		abstractFacade.create(entity3);
		assertTrue(abstractFacade.getEm().contains(entity));
		assertTrue(abstractFacade.getEm().contains(entity2));
		assertTrue(abstractFacade.getEm().contains(entity3));
		assertEquals("entity id is 13", entity, abstractFacade.find(13));
	}

	@Test
	public void testCount() {
		abstractFacade.create(entity);
		abstractFacade.create(entity2);
		assertEquals(2, abstractFacade.count());
	}

}
