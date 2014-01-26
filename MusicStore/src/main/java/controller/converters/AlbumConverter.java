package controller.converters;

import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import model.Album;
import service.AlbumEJB;
import service.abstractions.AbstractFacade;

/**
 * @author ilja
 * 
 */
@FacesConverter("albumConverter")
public class AlbumConverter extends AbstractConverter<Album> {

	@Inject
	private AlbumEJB albumEJB;

	@Override
	protected AbstractFacade<Album> getCurrentEntityEJB() {
		return albumEJB;
	}

}