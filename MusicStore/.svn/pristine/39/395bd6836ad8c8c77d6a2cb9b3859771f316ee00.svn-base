package util.fem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import util.FakeEntity;

public class FakeEntityManagerTest {
	private FakeEntityManager fem = new FakeEntityManager();
	private FakeEntity entity = new FakeEntity(1);
	private FakeEntity entity2 = new FakeEntity(2);;

	@Test
	public void testPersist() {
		fem.persist(entity);
		fem.persist(entity2);
		assertTrue(fem.contains(entity));
		assertTrue(fem.contains(entity2));
	}

	@Test
	public void testContains() {
		fem.persist(entity);
		fem.persist(entity2);
		assertTrue(fem.contains(entity));
		assertTrue(fem.contains(entity2));
	}

	@Test
	public void testRemove() {
		fem.persist(entity);
		fem.persist(entity2);
		fem.contains(entity);
		fem.contains(entity2);
		fem.remove(entity2);
		assertFalse(fem.contains(entity2));
	}

	@Test
	public void testFindClassOfTObject() {
		fem.persist(entity);
		fem.persist(entity2);
		assertEquals(entity, fem.find(FakeEntity.class, 1l));
	}

	@Test
	public void testCreateQueryStringClassOfT() {
		fem.persist(entity);
		fem.persist(entity2);
		List<FakeEntity> resultList = fem.createQuery(
				"SELECT e FROM " + FakeEntity.class.getName() + " e",
				FakeEntity.class).getResultList();
		assertTrue(resultList.size() == 2);
	}

	@Test
	public void testCreateQueryString() {
		fem.persist(entity);
		fem.persist(entity2);

		long numberOfEntities = ((Long) fem.createQuery(
				"select count(e) from " + FakeEntity.class.getName() + " as e")
				.getSingleResult()).longValue();

		assertEquals(2, numberOfEntities);
	}
}
