import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import service.abstractions.AbstractFacadeIntegrationTest;

@RunWith(Suite.class)
@SuiteClasses({ service.AllTests.class, AbstractFacadeIntegrationTest.class })
public class AllTests {

}
