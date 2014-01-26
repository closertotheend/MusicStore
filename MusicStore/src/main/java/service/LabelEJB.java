package service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;

import model.product.Label;
import service.abstractions.AbstractFacade;

/**
 * @author ilja
 * 
 */
@Stateless
@LocalBean
@Named
public class LabelEJB extends AbstractFacade<Label> {

	public LabelEJB() {
		super(Label.class);
	}

}
