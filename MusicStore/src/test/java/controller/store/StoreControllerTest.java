package controller.store;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import model.Store;

import org.junit.BeforeClass;
import org.junit.Test;

import service.StoreEJB;
import testutil.fem.FakeEntityManager;

public class StoreControllerTest {

	static StoreController storeController;
	static FakeEntityManager em;

	@BeforeClass
	public static void init() {
		storeController = spy(new StoreController());
		FakeEntityManager em = spy(new FakeEntityManager());
		StoreEJB storeEJB = spy(new StoreEJB());

		storeEJB.setEm(em);
		storeController.setStoreEJB(storeEJB);
	}

	@Test
	public void testDeleteStoreById() throws Exception {
		storeController.deleteStoreById(1);
		verify(storeController.getStoreEJB()).delete((Store) any());
	}

	@Test
	public void testGetAll() throws Exception {
		storeController.getAll();
		verify(storeController.getStoreEJB()).findAll();
	}

	@Test
	public void testGetStoreEJB() throws Exception {
		assertNotNull(storeController.getStoreEJB());
	}

}
