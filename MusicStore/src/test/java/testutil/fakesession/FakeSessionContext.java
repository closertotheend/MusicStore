package testutil.fakesession;

import static org.mockito.Mockito.spy;

import java.security.Identity;
import java.security.Principal;
import java.util.Map;
import java.util.Properties;

import javax.ejb.EJBHome;
import javax.ejb.EJBLocalHome;
import javax.ejb.EJBLocalObject;
import javax.ejb.EJBObject;
import javax.ejb.SessionContext;
import javax.ejb.TimerService;
import javax.transaction.UserTransaction;
import javax.xml.rpc.handler.MessageContext;

public class FakeSessionContext implements SessionContext {

	private Principal fakePrincipal = spy(new FakePrincipal());

	@Override
	public Identity getCallerIdentity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Principal getCallerPrincipal() {
		return fakePrincipal;
	}

	@Override
	public Map<String, Object> getContextData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EJBHome getEJBHome() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EJBLocalHome getEJBLocalHome() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Properties getEnvironment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getRollbackOnly() throws IllegalStateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TimerService getTimerService() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserTransaction getUserTransaction() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCallerInRole(final Identity role) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCallerInRole(final String roleName)
			throws IllegalStateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object lookup(final String name) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRollbackOnly() throws IllegalStateException {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> T getBusinessObject(final Class<T> businessInterface)
			throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EJBLocalObject getEJBLocalObject() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EJBObject getEJBObject() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class getInvokedBusinessInterface() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageContext getMessageContext() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean wasCancelCalled() throws IllegalStateException {
		// TODO Auto-generated method stub
		return false;
	}

}
