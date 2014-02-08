package controller.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public enum MessagesHelper {
	INSTANCE;

	private FacesContext facesContext = FacesContext.getCurrentInstance();

	/**
	 * @param entityName
	 *            name of entity which was persisted
	 */
	public void showCreatedSuccessfullyMessage(final String entityName) {
		FacesMessage successMessage = new FacesMessage("The " + entityName
				+ " was succesfully created!");
		successMessage.setSeverity(FacesMessage.SEVERITY_INFO);
		getFacesContext().addMessage(null, successMessage);
	}

	public void showNotCreatedMessage(final String entityName) {
		FacesMessage failMessage = new FacesMessage("The " + entityName
				+ " was not succesfully created!");
		failMessage.setSeverity(FacesMessage.SEVERITY_WARN);
		getFacesContext().addMessage(null, failMessage);
	}

	public void showGeneralWarnMessage(final String message) {
		FacesMessage warnMessage = new FacesMessage(message);
		warnMessage.setSeverity(FacesMessage.SEVERITY_WARN);
		getFacesContext().addMessage(null, warnMessage);
	}

	public FacesContext getFacesContext() {
		return facesContext;
	}

	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

}
