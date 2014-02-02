package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import model.abstractions.EntityInterface;

/**
 * Entity implementation class for Entity: Artist. Artist=Musician
 * 
 */
@Entity
@Cacheable(value = false)
@NamedQueries({ @NamedQuery(name = Artist.FIND_BY_NAME_PATTERN, query = "SELECT a FROM Artist a where a.name LIKE :pattern") })
public class Artist implements Serializable, EntityInterface {
	private static final long serialVersionUID = 1L;

	public static final String FIND_BY_NAME_PATTERN = "Artist.findByNamePattern";

	public Artist() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;

	@Column(columnDefinition = "TEXT")
	private String description;

	@ManyToMany(mappedBy = "artists")
	private Set<Album> albums = new HashSet<>();

	@ManyToMany(mappedBy = "artists")
	private Set<Track> tracks = new HashSet<>();

	@Override
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Album> getAlbums() {
		return this.albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

	public Set<Track> getTracks() {
		return tracks;
	}

	public void setTracks(Set<Track> tracks) {
		this.tracks = tracks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artist other = (Artist) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + ", description="
				+ description + ", albums=" + albums + ", tracks="
				+ getTracks() + "]";
	}

}
