package testutil.fakeentity;

import service.abstractions.AbstractFacade;

public class FakeEntityEJB extends AbstractFacade<FakeEntity> {

	public FakeEntityEJB() {
		super(FakeEntity.class);
	}

}