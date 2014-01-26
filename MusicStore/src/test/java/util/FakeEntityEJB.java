package util;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import service.abstractions.AbstractFacade;

@RunWith(MockitoJUnitRunner.class)
public class FakeEntityEJB extends AbstractFacade<FakeEntity> {

	public FakeEntityEJB() {
		super(FakeEntity.class);
	}

}