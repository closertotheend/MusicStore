package controller.store;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Store;
import service.StoreEJB;
import controller.util.AddressHelper;

/**
 * @author ilja
 * 
 */
@Named
@SessionScoped
public class StoreUpdateController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private StoreEJB storeEJB;

	private Store store;

	public void update() {
		getStoreEJB().update(getStore());
	}

	public String setStore(final Store store) {
		this.store = store;
		return AddressHelper.storeEditPage;
	}

	// getters setters

	public Store getStore() {
		return store;
	}

	public StoreEJB getStoreEJB() {
		return storeEJB;
	}

	public void setStoreEJB(StoreEJB storeEJB) {
		this.storeEJB = storeEJB;
	}

}
