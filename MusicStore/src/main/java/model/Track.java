package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import model.abstractions.EntityInterface;

/**
 * Entity implementation class for Entity: Track Track is a piece of art from
 * musicians. Each track can be in multiple albums
 */
@Entity
@NamedQueries({ @NamedQuery(name = Track.FIND_BY_ARTIST, query = "SELECT t FROM Track t WHERE :artist MEMBER OF t.artists") })
public class Track implements Serializable, EntityInterface {
	private static final long serialVersionUID = 1L;
	public static final String FIND_BY_ARTIST = "Track.findByArtist";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String lyrics;

	@ManyToMany(mappedBy = "tracks")
	private Set<Album> albums = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "ARTIST_TRACKS", joinColumns = { @JoinColumn(referencedColumnName = "ID") }, inverseJoinColumns = { @JoinColumn(referencedColumnName = "ID") })
	private Set<Artist> artists = new HashSet<>();

	public Track() {
		super();
	}

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

	public Set<Album> getAlbums() {
		return this.albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

	public Set<Artist> getArtists() {
		return this.artists;
	}

	public void setArtists(Set<Artist> artists) {
		this.artists = artists;
	}

	public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Track other = (Track) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Track [id=" + id + ", name=" + name + "]";
	}

}
