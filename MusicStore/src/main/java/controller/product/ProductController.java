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
import controller.util.MessagesHelper;

/**
 * @author ilja
 * 
 */
@Named
@SessionScoped
public class ProductController implements Serializable {
	private static final long serialVersionUID = 1L;

	private Product productToBeCreated;
	private Artist authorOfAlbum;

	@Inject
	private ProductEJB productEJB;

	@Inject
	private ArtistEJB artistEJB;

	/**
	 * Persists product and shows success message
	 */
	public void save() {
		productEJB.create(productToBeCreated);
		MessagesHelper.INSTANCE.showCreatedSuccessfullyMessage("product");
	}

	public List<Product> getProductsByAlbumId(final long id) {
		return productEJB.getProductsByAlbumId(id);
	}

	public List<Product> getAll() {
		return productEJB.findAll();
	}

	public void delete(final long id) {
		productEJB.delete(productEJB.find(id));
	}

	// Getters Setters

	public Product getProductToBeCreated() {
		if (productToBeCreated == null) {
			productToBeCreated = new Product();

		}
		return productToBeCreated;
	}

	public void setProductToBeCreated(final Product storeToBeCreated) {
		this.productToBeCreated = storeToBeCreated;
	}

	public ArtistEJB getArtistEJB() {
		return artistEJB;
	}

	public void setArtistEJB(final ArtistEJB artistEJB) {
		this.artistEJB = artistEJB;
	}

	public Artist getAuthorOfAlbum() {
		return authorOfAlbum;
	}

	public void setAuthorOfAlbum(final Artist authorOfAlbum) {
		this.authorOfAlbum = authorOfAlbum;
	}

}
