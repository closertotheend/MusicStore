package model.product;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import model.Album;
import model.Artist;
import model.Store;
import model.abstractions.EntityInterface;

/**
 * @author ilja Product is physical album (CD LP EP)
 */
@Entity
@NamedQueries({ @NamedQuery(name = Product.GET_PRODUCTS_BY_STORE_ID, query = "SELECT p FROM Product p where p.storeInWhichLocated.id = :id") })
public class Product implements Serializable, EntityInterface {
	private static final long serialVersionUID = 1L;
	public final  static String GET_PRODUCTS_BY_STORE_ID= "Store.getProductsByStoreId";
	public Product() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int quantity;

	@ManyToOne
	// @JoinColumn(name = "ALBUM_ID")
	private Album album;

	@Enumerated(EnumType.STRING)
	private ProductType albumType;

	@ManyToOne
	// @JoinColumn(name = "STORE_ID")
	private Store storeInWhichLocated;

	@Override
	public long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Album getAlbum() {
		return this.album;
	}

	public void setAlbum(final Album album) {
		this.album = album;
	}

	public ProductType getAlbumType() {
		return albumType;
	}

	public void setAlbumType(final ProductType albumType) {
		this.albumType = albumType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(final int quantity) {
		this.quantity = quantity;
	}

	public Store getStoreInWhichLocated() {
		return storeInWhichLocated;
	}

	public void setStoreInWhichLocated(final Store storeInWhichLocated) {
		this.storeInWhichLocated = storeInWhichLocated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((album == null) ? 0 : album.hashCode());
		result = (prime * result)
				+ ((albumType == null) ? 0 : albumType.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Product other = (Product) obj;
		if (album == null) {
			if (other.album != null) {
				return false;
			}
		} else if (!album.equals(other.album)) {
			return false;
		}
		if (albumType != other.albumType) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", quantity=" + quantity + ", album="
				+ album + ", albumType=" + albumType + ", storeInWhichLocated="
				+ storeInWhichLocated + "]";
	}

}
