package controller.track;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Track;
import service.AlbumEJB;
import service.TrackEJB;

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

	public Set<Track> getTracksByAlbumId(final long albumId) {
		Set<Track> tracks = new HashSet<>();
		try {
			tracks = getAlbumEJB().find(albumId).getTracks();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tracks;
	}

	public void deleteTrackById(final long id) {
		Track trackWithId = getTrackEJB().find(id);
		getTrackEJB().delete(trackWithId);
	}

	public List<Track> getAll() {
		return getTrackEJB().findAll();
	}

	// GETTERS SETTERS
	public TrackEJB getTrackEJB() {
		return trackEJB;
	}

	public void setTrackEJB(final TrackEJB trackEJB) {
		this.trackEJB = trackEJB;
	}

	public AlbumEJB getAlbumEJB() {
		return albumEJB;
	}

	public void setAlbumEJB(final AlbumEJB albumEJB) {
		this.albumEJB = albumEJB;
	}

}
