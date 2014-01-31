package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import model.abstractions.EntityInterface;
import model.product.Product;

/**
 * Entity implementation class for Entity: Store Store in which products lay
 */
@Entity
@NamedQueries({ @NamedQuery(name = Store.FIND_BY_NAME, query = "SELECT s FROM Store s where s.name = :storeName") })
public class Store implements Serializable, EntityInterface {
	private static final long serialVersionUID = 1L;
	public static final String FIND_BY_NAME = "Store.findByName";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	@OneToMany(mappedBy = "storeInWhichLocated", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<Product> products;

	public Store() {
		super();
	}

	@Override
	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(final List<Product> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + (int) (id ^ (id >>> 32));
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
		Store other = (Store) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Store [name=" + name + "]";
	}

}
