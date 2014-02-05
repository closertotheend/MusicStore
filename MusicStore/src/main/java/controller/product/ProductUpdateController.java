package controller.product;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Artist;
import model.product.Product;
import service.ArtistEJB;
import service.ProductEJB;
import controller.util.AddressHelper;
import controller.util.MessagesHelper;

/**
 * @author ilja
 * 
 */
@Named
@SessionScoped
public class ProductUpdateController implements Serializable {
	private static final long serialVersionUID = 1L;

	private Product product;
	private Artist authorOfAlbum;

	@Inject
	private ProductEJB productEJB;

	public void update() {
		productEJB.update(getProduct());
	}


	public String setProduct(Product product) {
		this.product = product;
		return AddressHelper.productEditPage;
	}
	// Getters Setters

	public Artist getAuthorOfAlbum() {
		return authorOfAlbum;
	}

	public void setAuthorOfAlbum(final Artist authorOfAlbum) {
		this.authorOfAlbum = authorOfAlbum;
	}

	public Product getProduct() {
		return product;
	}

}
