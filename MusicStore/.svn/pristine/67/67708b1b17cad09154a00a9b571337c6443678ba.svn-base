package controller.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import model.abstractions.EntityInterface;
import service.abstractions.AbstractFacade;

public abstract class AbstractConverter<T extends EntityInterface> implements
		Converter {

	protected abstract AbstractFacade<T> getCurrentEntityEJB();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		return getCurrentEntityEJB().find(Long.parseLong(value));
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		String val = null;
		try {
			T entity = (T) value;
			val = Long.toString(entity.getId());
		} catch (Throwable ex) {
			ex.printStackTrace();
		}
		return val;
	}
}