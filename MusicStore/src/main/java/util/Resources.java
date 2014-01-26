package util;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class Resources implements Serializable {
	private static final long serialVersionUID = 1L;

	@Produces
	Logger getLogger(final InjectionPoint ip) {
		String category = ip.getMember().getDeclaringClass().getName();
		return Logger.getLogger(category);
	}

	@Produces
	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

}