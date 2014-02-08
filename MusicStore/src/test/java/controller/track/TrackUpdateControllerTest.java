package controller.track;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
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

public class TrackUpdateControllerTest {

	static TrackUpdateController trackUpdateController;
	static TrackEJB trackEJB;
	static FakeEntityManager entityManager;

	@Before
	public void init() {
		trackUpdateController = spy(new TrackUpdateController());
		trackEJB = spy(new TrackEJB());
		entityManager = new FakeEntityManager();

		MessagesHelper.INSTANCE.setFacesContext(spy(new FakeFacesContext()));
		trackEJB.setEm(entityManager);
		trackUpdateController.setTrackEJB(trackEJB);
	}

	@Test
		public void testUpdate() throws Exception {
			Track track = new Track();
			trackUpdateController.setTrack(track);
			trackUpdateController.update();
			verify(trackUpdateController.getTrackEJB()).update(track);
		}

	@Test
			public void testGetTrack() throws Exception {
				assertNull(trackUpdateController.getTrack());
			}

	@Test
	public void testRemoveArtistFromEditedTrack() throws Exception {
		trackUpdateController.setTrack(new Track());
		Artist artistOfAlbum = new Artist();
		trackUpdateController.setArtistOfTrack(artistOfAlbum);
		trackUpdateController.addArtistToEditedTrack();
		assertTrue(trackUpdateController.getTrack().getArtists()
				.contains(artistOfAlbum));
		trackUpdateController.removeArtistFromEditedTrack(artistOfAlbum);
		assertFalse(trackUpdateController.getTrack().getArtists()
				.contains(artistOfAlbum));
	}

	@Test
	public void testAddArtistToEditedTrack() throws Exception {
		trackUpdateController.setTrack(new Track());
		Artist artistOfAlbum = new Artist();
		trackUpdateController.setArtistOfTrack(artistOfAlbum);
		trackUpdateController.addArtistToEditedTrack();
		assertTrue(trackUpdateController.getTrack().getArtists()
				.contains(artistOfAlbum));
	}

	@Test
	public void testGetTrackEJB() throws Exception {
		assertNotNull(trackUpdateController.getTrackEJB());
	}

	@Test
		public void testGetArtistOfTrack() throws Exception {
			assertNull(trackUpdateController.getArtistOfTrack());
		}

}
