package service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import model.Store;
import service.abstractions.AbstractFacade;

/**
 * @author ilja
 * 
 */
@Stateless
@LocalBean
@Named
public class StoreEJB extends AbstractFacade<Store> {

	@Inject
	private ProductEJB productEJB;

	public StoreEJB() {
		super(Store.class);
	}


	public ProductEJB getProductEJB() {
		return productEJB;
	}

	public void setProductEJB(final ProductEJB productEJB) {
		this.productEJB = productEJB;
	}
}
