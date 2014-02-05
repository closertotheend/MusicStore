package controller.store;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Store;
import service.StoreEJB;
import controller.util.MessagesHelper;

/**
 * @author ilja
 * 
 */
@Named
@RequestScoped
public class StoreCreateController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private StoreEJB storeEJB;

	private Store store;

	public void save() {
		storeEJB.create(store);
		MessagesHelper.INSTANCE.showCreatedSuccessfullyMessage("store");
	}

	public Store getStore() {
		if (store == null) {
			store = new Store();

		}
		return store;
	}

	public void setStore(final Store storeToBeCreated) {
		this.store = storeToBeCreated;
	}

}
