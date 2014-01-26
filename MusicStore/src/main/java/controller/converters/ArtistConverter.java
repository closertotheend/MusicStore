package controller.converters;

import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import model.Artist;
import service.ArtistEJB;
import service.abstractions.AbstractFacade;

/**
 * @author ilja
 * 
 */
@FacesConverter("artistConverter")
public class ArtistConverter extends AbstractConverter<Artist> {

	@Inject
	private ArtistEJB artistEJB;

	@Override
	protected AbstractFacade<Artist> getCurrentEntityEJB() {
		return artistEJB;
	}

}