package controller.store;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Store;
import service.StoreEJB;

/**
 * @author ilja
 * 
 */
@Named
@RequestScoped
public class StoreController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private StoreEJB storeEJB;

	public void deleteStoreById(final long id) {
		storeEJB.delete(storeEJB.find(id));
	}

	public List<Store> getAll() {
		return storeEJB.findAll();
	}

}
