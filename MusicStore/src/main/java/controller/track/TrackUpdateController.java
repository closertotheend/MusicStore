package controller.track;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Artist;
import model.Track;
import service.TrackEJB;
import controller.util.AddressHelper;

@Named
@SessionScoped
public class TrackUpdateController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private TrackEJB trackEJB;

	private Track track;
	private Artist artistOfTrack;

	public void update() {
		getTrackEJB().update(track);
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(final Track editedTrack) {
		this.track = editedTrack;
	}

	public String setEditedTrackById(final long id) {
		Track trackWithId = getTrackEJB().find(id);
		setTrack(trackWithId);
		return AddressHelper.trackEditPage;
	}

	public void removeArtistFromEditedTrack(final Artist a) {
		getTrack().getArtists().remove(a);
	}

	public void addArtistToEditedTrack() {
		getTrack().getArtists().add(getArtistOfTrack());
	}

	// GETTERS SETTERS
	public TrackEJB getTrackEJB() {
		return trackEJB;
	}

	public void setTrackEJB(TrackEJB trackEJB) {
		this.trackEJB = trackEJB;
	}

	public Artist getArtistOfTrack() {
		return artistOfTrack;
	}

	public void setArtistOfTrack(
			Artist artistOfAlbumWhoWillBeAdded) {
		this.artistOfTrack = artistOfAlbumWhoWillBeAdded;
	}
}