package service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;

import model.Store;
import service.abstractions.AbstractFacade;

/**
 * @author ilja
 * 
 */
@Named
@Stateless
@LocalBean
public class StoreEJB extends AbstractFacade<Store> {

	public StoreEJB() {
		super(Store.class);
	}

	@Override
	public void create(final Store entity) {
		super.create(entity);
	}

}
