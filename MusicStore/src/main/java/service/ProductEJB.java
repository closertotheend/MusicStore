package service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;

import model.product.Product;
import service.abstractions.AbstractFacade;

/**
 * @author ilja
 * 
 */
@Stateless
@LocalBean
@Named
public class ProductEJB extends AbstractFacade<Product> {

	public ProductEJB() {
		super(Product.class);
	}

	/**
	 * TODO: use database query
	 * 
	 * @param id
	 *            of an album
	 * @return List of products which contain album
	 */
	public List<Product> getProductsByAlbumId(final long id) {
		List<Product> all = findAll();
		List<Product> productsWithAlbumId = new ArrayList<>();
		for (Product product : all) {
			if (product.getAlbum().getId() == id) {
				productsWithAlbumId.add(product);
			}
		}
		return productsWithAlbumId;
	}

}
