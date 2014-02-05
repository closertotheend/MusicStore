package testutil.fakesession;

import java.security.Principal;

public class FakePrincipal implements Principal {
	@Override
	public String getName() {
		return null;
	}
}