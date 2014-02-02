package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import model.Artist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import testutil.IntegrationTestBase;

@RunWith(MockitoJUnitRunner.class)
public class ArtistEJBIntegrationTest extends IntegrationTestBase {
	private final Artist cure = new Artist();
	private final Artist papaRoach = new Artist();
	private final Artist pinkFloyd = new Artist();
	private final Artist pink = new Artist();

	@Test
	public void testFindByFirstLetter() throws Exception {
		assertEquals(0, artistEJB.count());
		cure.setName("The Cure");
		papaRoach.setName("Papa Roach");
		pinkFloyd.setName("Pink Floyd");
		pink.setName("pink");
		artistEJB.create(cure);
		artistEJB.create(papaRoach);
		artistEJB.create(pinkFloyd);
		artistEJB.create(pink);
		assertEquals(4, artistEJB.count());
		List<Artist> listOfArtistWhoStartWithP = artistEJB
				.findByFirstLetter('p');
		assertEquals(3, listOfArtistWhoStartWithP.size());
		assertTrue(listOfArtistWhoStartWithP.contains(papaRoach));
		assertTrue(listOfArtistWhoStartWithP.contains(pinkFloyd));
		assertTrue(listOfArtistWhoStartWithP.contains(pink));
	}

	@Test
	public void testGetEm() {
		assertNotNull(artistEJB.getEm());
	}

}
