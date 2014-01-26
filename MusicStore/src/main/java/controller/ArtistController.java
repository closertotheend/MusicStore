package controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Artist;
import service.ArtistEJB;
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

	@Inject
	private ArtistEJB artistEJB;

	/**
	 * Saves artist and shows message
	 */
	public void save() {
		getArtistEJB().create(getArtistToBeCreated());
		MessagesHelper.INSTANCE.showCreatedSuccessfullyMessage("artist");
	}

	/**
	 * @return all Artists from database
	 */
	public List<Artist> getAll() {
		return getArtistEJB().findAll();
	}

	public Artist getArtistById(long id) {
		return artistEJB.find(id);
	}

	public Artist getArtistToBeCreated() {
		if (artistToBeCreated == null) {
			artistToBeCreated = new Artist();

		}
		return artistToBeCreated;
	}

	public void setArtistToBeCreated(Artist artistToBeCreated) {
		this.artistToBeCreated = artistToBeCreated;
	}

	public ArtistEJB getArtistEJB() {
		return artistEJB;
	}

	public void setArtistEJB(ArtistEJB artistEJB) {
		this.artistEJB = artistEJB;
	}

}
