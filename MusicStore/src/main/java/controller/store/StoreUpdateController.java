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

	public String setStoreById(final long id) {
		this.setStore(storeEJB.find(id));
		return AddressHelper.storeEditPage;
	}

	public void update() {
		storeEJB.update(getStore());
	}

	// getters setters

	public Store getStore() {
		return store;
	}

	public void setStore(final Store store) {
		this.store = store;
	}

}
