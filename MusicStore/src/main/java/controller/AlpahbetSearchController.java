package controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Artist;
import service.ArtistEJB;

/**
 * @author ilja
 * 
 */
@Named
@RequestScoped
public class AlpahbetSearchController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private ArtistEJB artistEJB;

	/**
	 * @param c
	 * @return All artists whose name start with c
	 */
	public List<Artist> searchByLetter(final char c) {
		return artistEJB.findByFirstLetter(c);
	}

	public ArtistEJB getArtistEJB() {
		return artistEJB;
	}

	public void setArtistEJB(final ArtistEJB artistEJB) {
		this.artistEJB = artistEJB;
	}

}
