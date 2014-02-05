package service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AlbumEJBIntegrationTest.class, ArtistEJBIntegrationTest.class,
		ProductEJBIntegrationTest.class, TrackEJBIntegrationTest.class,
		UserEJBIntegrationTest.class })
public class AllTests {

}
