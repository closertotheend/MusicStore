package controller.store;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import javax.faces.application.FacesMessage;

import model.Store;

import org.junit.BeforeClass;
import org.junit.Test;

import service.StoreEJB;
import testutil.FakeFacesContext;
import testutil.fem.FakeEntityManager;
import controller.util.MessagesHelper;

public class StoreCreateControllerTest {
	static StoreCreateController storeCreateController;
	static FakeEntityManager em;
	static FakeFacesContext fakeFacesContext;
	static StoreEJB storeEJB;

	@BeforeClass
	public static void init() {
		storeCreateController = spy(new StoreCreateController());
		em = spy(new FakeEntityManager());
		fakeFacesContext = spy(new FakeFacesContext());
		storeEJB = spy(new StoreEJB());
		storeEJB.setEm(em);
		storeCreateController.setStoreEJB(storeEJB);

		MessagesHelper.INSTANCE.setFacesContext(fakeFacesContext);
	}

	@Test
	public void testSave() throws Exception {
		Store store = new Store();
		storeCreateController.setStore(store);
		storeCreateController.save();
		verify(storeCreateController.getStoreEJB()).create(store);
		verify(fakeFacesContext).addMessage(anyString(), (FacesMessage) any());
	}

	@Test
	public void testGetStore() throws Exception {
		assertNotNull(storeCreateController.getStore());
	}

}
