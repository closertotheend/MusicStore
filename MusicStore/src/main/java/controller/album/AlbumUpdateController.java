package controller.album;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Album;
import model.Artist;
import model.Track;
import service.AlbumEJB;
import controller.util.AddressHelper;

/**
 * @author ilja
 * 
 */
@Named
@SessionScoped
public class AlbumUpdateController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private AlbumEJB albumEJB;

	private Album album;
	private Track trackThatIsAddedToTheAlbum;
	private Artist artistWhoWillBeAddedToTheAlbum;

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

	public void update() {
		albumEJB.update(album);
	}

	// Getters, Setters

	public AlbumEJB getAlbumEJB() {
		return albumEJB;
	}

	public void setAlbumEJB(final AlbumEJB albumEJB) {
		this.albumEJB = albumEJB;
	}

	public Album getAlbum() {
		return album;
	}

	public String setAlbum(final Album albumToBeEdited) {
		this.album = albumToBeEdited;
		return AddressHelper.albumEditPage;
	}

	public Artist getArtistWhoWillBeAddedToTheAlbum() {
		return artistWhoWillBeAddedToTheAlbum;
	}

	public void setArtistWhoWillBeAddedToTheAlbum(
			final Artist artistWhoWillBeAddedToTheAlbumToBeEdited) {
		this.artistWhoWillBeAddedToTheAlbum = artistWhoWillBeAddedToTheAlbumToBeEdited;
	}

	public Track getTrackThatIsAddedToTheAlbum() {
		return trackThatIsAddedToTheAlbum;
	}

	public void setTrackThatIsAddedToTheAlbum(
			final Track trackThatIsAddedToTheAlbumToBeEdited) {
		this.trackThatIsAddedToTheAlbum = trackThatIsAddedToTheAlbumToBeEdited;
	}

}
