package controller.converters;

import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import model.Track;
import service.TrackEJB;
import service.abstractions.AbstractFacade;

/**
 * @author ilja
 * 
 */
@FacesConverter("trackConverter")
public class TrackConverter extends AbstractConverter<Track> {

	@Inject
	TrackEJB trackEJB;

	@Override
	protected AbstractFacade<Track> getCurrentEntityEJB() {
		return trackEJB;
	}

}