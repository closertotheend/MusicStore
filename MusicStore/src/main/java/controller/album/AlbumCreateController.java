package controller.album;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Album;
import model.Artist;
import model.Track;
import service.AlbumEJB;
import controller.util.MessagesHelper;

/**
 * @author ilja
 * 
 */
@Named
@SessionScoped
public class AlbumCreateController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private AlbumEJB albumEJB;

	private Album album;
	private Artist artistWhoWillBeAddedToTheAlbum;
	private Track trackThatIsAddedToTheAlbum;

	public void save() {
		getAlbumEJB().create(getAlbum());
		MessagesHelper.INSTANCE.showCreatedSuccessfullyMessage("album");
		setAlbum(null);
	}

	public void addArtistToAlbum() {
		getAlbum().getArtists().add(artistWhoWillBeAddedToTheAlbum);
	}

	public void removeArtistFromAlbum(final Artist a) {
		getAlbum().getArtists().remove(a);
	}

	public void addTrackToAlbum() {
		getAlbum().getTracks().add(trackThatIsAddedToTheAlbum);
	}

	public void removeTrackFromAlbum(final Track track) {
		getAlbum().getTracks().remove(track);
	}

	// Getters, Setters

	public Album getAlbum() {
		if (album == null) {
			album = new Album();
		}
		return album;
	}

	public void setAlbum(final Album albumToBeCreated) {
		this.album = albumToBeCreated;
	}

	public Artist getArtistWhoWillBeAddedToTheAlbum() {
		return artistWhoWillBeAddedToTheAlbum;
	}

	public void setArtistWhoWillBeAddedToTheAlbum(
			final Artist artistToBeAddedToTheAlbumToBeCreated) {
		this.artistWhoWillBeAddedToTheAlbum = artistToBeAddedToTheAlbumToBeCreated;
	}

	public Track getTrackThatIsAddedToTheAlbum() {
		return trackThatIsAddedToTheAlbum;
	}

	public void setTrackThatIsAddedToTheAlbum(
			final Track trackWhoWillBeAddedToTheAlbumToBeCreated) {
		this.trackThatIsAddedToTheAlbum = trackWhoWillBeAddedToTheAlbumToBeCreated;
	}

	public AlbumEJB getAlbumEJB() {
		return albumEJB;
	}

	public void setAlbumEJB(final AlbumEJB albumEJB) {
		this.albumEJB = albumEJB;
	}

}
