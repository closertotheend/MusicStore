package controller.album;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Album;
import model.Artist;
import model.Track;
import service.AlbumEJB;
import service.ArtistEJB;
import service.TrackEJB;

/**
 * Common functions which are used by all controllers. TODO: Think about
 * implementing save, update, delete operations here
 * 
 * @author ilja
 */
@Named
@SessionScoped
public class AlbumController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private ArtistEJB artistEJB;

	@Inject
	private AlbumEJB albumEJB;

	@Inject
	private TrackEJB trackEJB;

	private Album album;

	public List<Track> getTracksByArtists(final Collection<Artist> artists) {
		return new ArrayList<Track>(trackEJB.getTracksByArtists(artists));
	}

	public List<Album> getAlbumsByArtistId(final long artistId) {
		Set<Album> albums = new HashSet<>();
		try {
			albums = artistEJB.find(artistId).getAlbums();
		} catch (Exception e) {
		}
		return new ArrayList<Album>(albums);
	}

	public Album getAlbumById(final long id) {
		return albumEJB.find(id);
	}

	public void delete(final long id) {
		Album albumById = getAlbumById(id);
		albumEJB.delete(albumById);
	}

	public List<Album> getAll() {
		return albumEJB.findAll();
	}

	// Getters, Setters

	public AlbumEJB getAlbumEJB() {
		return albumEJB;
	}

	public void setAlbumEJB(final AlbumEJB albumEJB) {
		this.albumEJB = albumEJB;
	}

	public ArtistEJB getArtistEJB() {
		return artistEJB;
	}

	public void setArtistEJB(final ArtistEJB artistEJB) {
		this.artistEJB = artistEJB;
	}

	public TrackEJB getTrackEJB() {
		return trackEJB;
	}

	public void setTrackEJB(final TrackEJB trackEJB) {
		this.trackEJB = trackEJB;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(final Album album) {
		this.album = album;
	}

}
