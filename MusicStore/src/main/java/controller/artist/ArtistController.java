package controller.artist;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Artist;
import service.ArtistEJB;
import controller.util.AddressHelper;
import controller.util.MessagesHelper;

/**
 * @author ilja
 * 
 */
@Named
@SessionScoped
public class ArtistController implements Serializable {
	private static final long serialVersionUID = 1L;

	private Artist artistToBeCreated;
	private Artist editedArtist;
	private Artist artist;

	@Inject
	private ArtistEJB artistEJB;

	public void save() {
		getArtistEJB().create(getArtistToBeCreated());
		MessagesHelper.INSTANCE.showCreatedSuccessfullyMessage("artist");
	}

	public List<Artist> getAll() {
		return getArtistEJB().findAll();
	}

	public Artist getArtistById(final long id) {
		return artistEJB.find(id);
	}

	public void deleteArtistById(final long id) {
		Artist artistWithId = artistEJB.find(id);
		artistEJB.delete(artistWithId);
	}

	public String setEditedArtistById(final long id) {
		Artist artistWithId = artistEJB.find(id);
		editedArtist = artistWithId;
		return AddressHelper.artistEditPage;
	}

	public void saveEditedArtist() {
		artistEJB.update(editedArtist);
	}

	// GETTERS SETTERS

	public Artist getArtistToBeCreated() {
		if (artistToBeCreated == null) {
			artistToBeCreated = new Artist();

		}
		return artistToBeCreated;
	}

	public void setArtistToBeCreated(final Artist artistToBeCreated) {
		this.artistToBeCreated = artistToBeCreated;
	}

	public ArtistEJB getArtistEJB() {
		return artistEJB;
	}

	public void setArtistEJB(final ArtistEJB artistEJB) {
		this.artistEJB = artistEJB;
	}

	public Artist getEditedArtist() {
		return editedArtist;
	}

	public void setEditedArtist(final Artist editedArtist) {
		this.editedArtist = editedArtist;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

}
