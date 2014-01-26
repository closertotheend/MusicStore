package model.authentication;

import java.io.Serializable;

/**
 * @author ilja Roles of the users
 */
public enum UserRole implements Serializable {
	USER, ADMIN, MODERATOR;
}
