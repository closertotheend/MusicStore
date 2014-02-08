package controller.track;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Artist;
import model.Track;
import service.TrackEJB;
import controller.util.MessagesHelper;

/**
 * @author ilja
 * 
 */
@Named
@SessionScoped
public class TrackCreateController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private TrackEJB trackEJB;

	private Track track;
	private Artist artistOfTrack;

	public void save() {
		getTrackEJB().create(track);
		MessagesHelper.INSTANCE.showCreatedSuccessfullyMessage("track");
	}

	public void addArtist() {
		getTrack().getArtists().add(artistOfTrack);
	}

	public void removeArtist(final Artist a) {
		getTrack().getArtists().remove(a);
	}

	// GETTERS SETTERS
	public TrackEJB getTrackEJB() {
		return trackEJB;
	}

	public void setTrackEJB(final TrackEJB trackEJB) {
		this.trackEJB = trackEJB;
	}

	public Track getTrack() {
		if (track == null) {
			track = new Track();

		}
		return track;
	}

	public void setTrack(final Track trackToBeCreated) {
		this.track = trackToBeCreated;
	}

	public Artist getArtistOfTrack() {
		return artistOfTrack;
	}

	public void setArtistOfTrack(final Artist artistOfAlbum) {
		this.artistOfTrack = artistOfAlbum;
	}

}
