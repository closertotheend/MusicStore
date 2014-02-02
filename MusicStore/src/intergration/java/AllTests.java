import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import service.AlbumEJBIntegrationTest;
import service.ArtistEJBIntegrationTest;
import service.ProductEJBIntegrationTest;
import service.TrackEJBIntegrationTest;
import service.UserEJBIntegrationTest;
import service.abstractions.AbstractFacadeIntegrationTest;
import service.authentication.AuthenticationEJBIntegrationTest;

@RunWith(Suite.class)
@SuiteClasses({ AlbumEJBIntegrationTest.class, ArtistEJBIntegrationTest.class,
		ProductEJBIntegrationTest.class, TrackEJBIntegrationTest.class,
		UserEJBIntegrationTest.class, AbstractFacadeIntegrationTest.class,
		AuthenticationEJBIntegrationTest.class })
public class AllTests {

}
