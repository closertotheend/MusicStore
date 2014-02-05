package service.abstractions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import testutil.IntegrationTestBase;
import testutil.fakeentity.FakeEntity;

@RunWith(MockitoJUnitRunner.class)
public class AbstractFacadeIntegrationTest extends IntegrationTestBase {

	private final FakeEntity entity = new FakeEntity();
	private final FakeEntity entity2 = new FakeEntity();
	private final FakeEntity entity3 = new FakeEntity();

	@Test
	public void testGetEm() {
		assertNotNull(abstractFacade.getEm());
		assertFalse(abstractFacade.getEm().contains(entity));
	}

	@Test
	public void testCreate() {
		abstractFacade.create(entity);
		assertTrue(abstractFacade.getEm().contains(entity));
		assertEquals(1, abstractFacade.count());
	}

	@Test
	public void testDelete() {
		abstractFacade.create(entity);
		assertEquals(1, abstractFacade.count());
		abstractFacade.delete(entity);
		assertEquals(0, abstractFacade.count());
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
		assertEquals(3, abstractFacade.count());
		abstractFacade.flushEm();
		assertEquals(entity, abstractFacade.find(entity.getId()));
	}

	@Test
	public void testCount() {
		abstractFacade.create(entity);
		abstractFacade.create(entity2);
		assertEquals(2, abstractFacade.count());
	}

}
