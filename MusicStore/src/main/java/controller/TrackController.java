package controller;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Artist;
import model.Track;
import service.AlbumEJB;
import service.TrackEJB;
import controller.util.MessagesHelper;

/**
 * @author ilja
 * 
 */
@Named
@SessionScoped
public class TrackController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private TrackEJB trackEJB;

	@Inject
	private AlbumEJB albumEJB;

	private Track trackToBeCreated;
	private Artist artistOfAlbumWhoWillBeAdded;

	/**
	 * Persists track and shows success message
	 */
	public void save() {
		trackEJB.create(trackToBeCreated);
		MessagesHelper.INSTANCE.showCreatedSuccessfullyMessage("track");
	}

	public Set<Track> getTracksByAlbumId(final long albumId) {
		Set<Track> tracks = new HashSet<>();
		try {
			tracks = albumEJB.find(albumId).getTracks();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tracks;
	}

	public void addArtist() {
		getTrackToBeCreated().getArtists().add(artistOfAlbumWhoWillBeAdded);
	}

	public void removeArtist(final Artist a) {
		getTrackToBeCreated().getArtists().remove(a);
	}

	// GETTERS SETTERS
	public TrackEJB getTrackEJB() {
		return trackEJB;
	}

	public void setTrackEJB(final TrackEJB trackEJB) {
		this.trackEJB = trackEJB;
	}

	public Track getTrackToBeCreated() {
		if (trackToBeCreated == null) {
			trackToBeCreated = new Track();

		}
		return trackToBeCreated;
	}

	public void setTrackToBeCreated(final Track trackToBeCreated) {
		this.trackToBeCreated = trackToBeCreated;
	}

	public Artist getArtistOfAlbumWhoWillBeAdded() {
		return artistOfAlbumWhoWillBeAdded;
	}

	public void setArtistOfAlbumWhoWillBeAdded(final Artist artistOfAlbum) {
		this.artistOfAlbumWhoWillBeAdded = artistOfAlbum;
	}

	public AlbumEJB getAlbumEJB() {
		return albumEJB;
	}

	public void setAlbumEJB(final AlbumEJB albumEJB) {
		this.albumEJB = albumEJB;
	}

}
