package controller.track;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TrackControllerTest.class, TrackCreateControllerTest.class,
		TrackUpdateControllerTest.class })
public class AllTests {

}
