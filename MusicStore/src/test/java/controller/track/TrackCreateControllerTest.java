package controller.track;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import model.Artist;
import model.Track;

import org.junit.Before;
import org.junit.Test;

import service.TrackEJB;
import testutil.FakeFacesContext;
import testutil.fem.FakeEntityManager;
import controller.util.MessagesHelper;

public class TrackCreateControllerTest {

	static TrackCreateController trackCreateController;
	static TrackEJB trackEJB;
	static FakeEntityManager entityManager;

	@Before
	public void init() {
		trackCreateController = spy(new TrackCreateController());
		trackEJB = spy(new TrackEJB());
		entityManager = new FakeEntityManager();

		MessagesHelper.INSTANCE.setFacesContext(spy(new FakeFacesContext()));
		trackEJB.setEm(entityManager);
		trackCreateController.setTrackEJB(trackEJB);
	}

	@Test
	public void testSave() throws Exception {
		trackCreateController.save();
		verify(trackCreateController.getTrackEJB()).create((Track) any());
	}

	@Test
	public void testAddArtist() throws Exception {
		Artist artistOfAlbum = new Artist();
		trackCreateController.setArtistOfTrack(artistOfAlbum);
		trackCreateController.addArtist();
		assertTrue(trackCreateController.getTrack().getArtists()
				.contains(artistOfAlbum));
	}

	@Test
	public void testRemoveArtist() throws Exception {
		Artist artistOfAlbum = new Artist();
		trackCreateController.setArtistOfTrack(artistOfAlbum);
		trackCreateController.addArtist();
		assertTrue(trackCreateController.getTrack().getArtists()
				.contains(artistOfAlbum));
		trackCreateController.removeArtist(artistOfAlbum);
		assertFalse(trackCreateController.getTrack().getArtists()
				.contains(artistOfAlbum));
	}

	@Test
	public void testGetTrackEJB() throws Exception {
		assertNotNull(trackCreateController.getTrackEJB());
	}

	@Test
		public void testGetTrack() throws Exception {
			assertNotNull(trackCreateController.getTrack());
		}

	@Test
		public void testGetArtistOfTrack() throws Exception {
			assertNull(trackCreateController.getArtistOfTrack());
		}

}
