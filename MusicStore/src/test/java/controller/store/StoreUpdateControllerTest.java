package controller.store;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import model.Store;

import org.junit.BeforeClass;
import org.junit.Test;

import service.StoreEJB;
import testutil.FakeFacesContext;
import testutil.fem.FakeEntityManager;
import controller.util.MessagesHelper;

public class StoreUpdateControllerTest {
	static StoreUpdateController storeUpdateController;
	static FakeEntityManager em;
	static FakeFacesContext fakeFacesContext;
	static StoreEJB storeEJB;

	@BeforeClass
	public static void init() {
		storeUpdateController = spy(new StoreUpdateController());
		em = spy(new FakeEntityManager());
		fakeFacesContext = spy(new FakeFacesContext());
		storeEJB = spy(new StoreEJB());
		storeEJB.setEm(em);
		storeUpdateController.setStoreEJB(storeEJB);

		MessagesHelper.INSTANCE.setFacesContext(fakeFacesContext);
	}

	@Test
	public void testSetStore() throws Exception {
		Store store = new Store();
		String redirectAddress = storeUpdateController.setStore(store);
		assertNotNull(redirectAddress);
		assertEquals(store, storeUpdateController.getStore());
	}

	@Test
	public void testUpdate() throws Exception {
		Store store = new Store();
		storeUpdateController.setStore(store);
		storeUpdateController.update();
		verify(storeUpdateController.getStoreEJB()).update(store);
	}

	@Test
	public void testGetStore() throws Exception {
		assertNull(storeUpdateController.getStore());
	}

}
