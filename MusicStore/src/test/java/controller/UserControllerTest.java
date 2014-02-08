package controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import javax.faces.application.FacesMessage;

import model.authentication.User;

import org.junit.BeforeClass;
import org.junit.Test;

import service.UserEJB;
import testutil.FakeFacesContext;
import testutil.fem.FakeEntityManager;
import controller.util.MessagesHelper;

public class UserControllerTest {

	static UserController userController;
	static UserEJB userEJB;
	static FakeFacesContext facesContext;

	@BeforeClass
	public static void init() {
		userController = spy(new UserController());
		userEJB = spy(new UserEJB());
		facesContext = spy(new FakeFacesContext());

		userController.setUserEJB(userEJB);
		userEJB.setEm(new FakeEntityManager());
		MessagesHelper.INSTANCE.setFacesContext(facesContext);
	}

	@Test
	public void testSave() throws Exception {
		User user = new User();
		userController.save(user);
		verify(userController.getUserEJB()).create(user);
		verify(facesContext).addMessage(anyString(), (FacesMessage) any());
	}

	@Test
	public void testGetAllUsers() throws Exception {
		userController.getAllUsers();
		verify(userController.getUserEJB()).findAll();
	}

	@Test
	public void testGetUser() throws Exception {
		assertNotNull(userController.getUser());
	}

	@Test
	public void testGetUserEJB() throws Exception {
		assertNotNull(userController.getUserEJB());
	}

}
