package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import model.abstractions.EntityInterface;
import model.product.Product;

/**
 * Entity implementation class for Entity: Album. Album is digital piece of
 * information. For physical look at Product
 * 
 */
@Entity
public class Album implements EntityInterface {
	private static final long serialVersionUID = 1L;

	public Album() {
		super();
	}

	public Album(final Long id, final String name, final Integer releaseYear,
			final String description) {
		this.id = id;
		this.name = name;
		this.releaseYear = releaseYear;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private Integer releaseYear;

	@Lob
	@Column(length = 50000)
	private String description;

	@OneToMany(mappedBy = "album", orphanRemoval = true, cascade = CascadeType.REMOVE)
	private Set<Product> products = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "ALBUM_TRACKS", joinColumns = { @JoinColumn(referencedColumnName = "ID") }, inverseJoinColumns = { @JoinColumn(referencedColumnName = "ID") })
	private Set<Track> tracks = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "ALBUM_ARTISTS", joinColumns = { @JoinColumn(referencedColumnName = "ID") }, inverseJoinColumns = { @JoinColumn(referencedColumnName = "ID") })
	private Set<Artist> artists = new HashSet<>();

	@Override
	public long getId() {
		return this.id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public Set<Artist> getArtists() {
		return this.artists;
	}

	public void setArtists(final Set<Artist> artists) {
		this.artists = artists;
	}

	public Integer getReleaseYear() {
		return this.releaseYear;
	}

	public void setReleaseYear(final Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(final Set<Product> products) {
		this.products = products;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Set<Track> getTracks() {
		return tracks;
	}

	public void setTracks(final Set<Track> tracks) {
		this.tracks = tracks;
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
		Album other = (Album) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", name=" + name + ", artists=" + artists
				+ ", releaseYear=" + releaseYear + ", description="
				+ description + ", products=" + products + "]";
	}

}
