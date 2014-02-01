package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import model.Album;
import model.product.Product;
import service.abstractions.AbstractFacade;

/**
 * @author ilja
 * 
 */
@Stateless
@LocalBean
@Named
public class AlbumEJB extends AbstractFacade<Album> {

	public AlbumEJB() {
		super(Album.class);
	}

	@Inject
	private ProductEJB productEJB;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * service.abstractions.AbstractFacade#delete(model.abstractions.EntityInterface
	 * ) FIXME: This is bullshit!!!! Possibly eclipselink is buggy (JPA is
	 * configurred correctly)
	 */
	@Override
	public void delete(final Album album) {
		Long id = album.getId();
		List<Product> products = getProductEJB().getProductsByAlbumId(id);
		for (Product product : products) {
			getProductEJB().delete(product);
		}
		super.delete(album);
	}

	public ProductEJB getProductEJB() {
		return productEJB;
	}

}
