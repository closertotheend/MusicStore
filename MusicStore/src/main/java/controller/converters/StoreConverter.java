package controller.converters;

import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import model.Store;
import service.StoreEJB;
import service.abstractions.AbstractFacade;

/**
 * @author ilja
 * 
 */
@FacesConverter("storeConverter")
public class StoreConverter extends AbstractConverter<Store> {

	@Inject
	private StoreEJB storeEJB;

	@Override
	protected AbstractFacade<Store> getCurrentEntityEJB() {
		return storeEJB;
	}

}