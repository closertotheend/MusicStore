package service;

import java.security.Principal;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.authentication.Role;
import model.authentication.RoleEnum;
import model.authentication.User;
import service.abstractions.AbstractFacade;

@LocalBean
@Stateless
@Named
public class UserEJB extends AbstractFacade<User> {

	public UserEJB() {
		super(User.class);
	}

	@Resource
	SessionContext ctx;

	public User findByUsername(final String username) {
		try {
			TypedQuery<User> query = getEm().createNamedQuery(
					User.FIND_BY_USERNAME, User.class);
			query.setParameter("username", username);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void create(final User user) {
		Role userRole = new Role(user.getUsername(), RoleEnum.USER);
		getEm().persist(userRole);
		flushEm();
		user.setUserRole(userRole);
		super.create(user);
	}

	public void login() {
		Principal callerPrincipal = ctx.getCallerPrincipal();
		String callerKey = callerPrincipal.getName();
	}

}
