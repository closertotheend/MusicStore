package service.abstractions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import testutil.FakeEntity;
import testutil.FakeEntityEJB;
import testutil.fem.FakeEntityManager;

@RunWith(MockitoJUnitRunner.class)
public class AbstractFacadeTest {

	private final AbstractFacade<FakeEntity> abstractFacade = spy(new FakeEntityEJB());
	private final FakeEntity entity = new FakeEntity(13);
	private final FakeEntity entity2 = new FakeEntity(14);
	private final FakeEntity entity3 = new FakeEntity(15);
	private EntityManager fakeEm;

	@Before
	public void init() {
		EntityManager fakeEm = spy(new FakeEntityManager());
		when(abstractFacade.getEm()).thenReturn(fakeEm);
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
		verify(abstractFacade.getEm()).persist(entity);
	}

	@Test
	public void testUpdate() {
		abstractFacade.update(entity);
		verify(abstractFacade.getEm()).merge(entity);
	}

	@Test
	public void testDelete() {
		abstractFacade.create(entity);
		assertTrue(abstractFacade.getEm().contains(entity));
		abstractFacade.delete(entity);
		assertFalse(abstractFacade.getEm().contains(entity));
		verify(abstractFacade.getEm()).remove(entity);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testFindAll() {
		abstractFacade.create(entity);
		abstractFacade.create(entity2);
		assertEquals(2, abstractFacade.findAll().size());
		verify(abstractFacade.getEm()).createQuery(anyString(),
				any(Class.class));
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
		verify(abstractFacade.getEm()).find(FakeEntity.class, 13l);
	}

	@Test
	public void testCount() {
		abstractFacade.create(entity);
		abstractFacade.create(entity2);
		assertEquals(2, abstractFacade.count());
		verify(abstractFacade.getEm()).createQuery(anyString());
	}

	@Test
	public void testFlushEm() {
		abstractFacade.flushEm();
		verify(abstractFacade.getEm()).flush();
	}
}
