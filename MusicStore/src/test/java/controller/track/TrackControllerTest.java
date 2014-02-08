package controller.track;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import model.Album;
import model.Artist;
import model.Track;

import org.junit.Before;
import org.junit.Test;

import service.AlbumEJB;
import service.TrackEJB;
import testutil.FakeFacesContext;
import testutil.fem.FakeEntityManager;
import controller.track.TrackController;
import controller.util.MessagesHelper;

public class TrackControllerTest {

	static TrackController trackController;
	static AlbumEJB albumEJB;
	static TrackEJB trackEJB;
	static FakeEntityManager entityManager;

	@Before
	public void init() {
		trackController = spy(new TrackController());
		albumEJB = spy(new AlbumEJB());
		trackEJB = spy(new TrackEJB());
		entityManager = new FakeEntityManager();

		MessagesHelper.INSTANCE.setFacesContext(spy(new FakeFacesContext()));
		albumEJB.setEm(entityManager);
		trackEJB.setEm(entityManager);
		trackController.setTrackEJB(trackEJB);
		trackController.setAlbumEJB(albumEJB);
	}

	@Test
	public void testSave() throws Exception {
		trackController.save();
		verify(trackController.getTrackEJB()).create((Track) any());
	}

	@Test
	public void testGetTracksByAlbumId() throws Exception {
		Album album = spy(new Album());
		when(trackController.getAlbumEJB().find(1)).thenReturn(album);
		trackController.getTracksByAlbumId(1);
		verify(trackController.getAlbumEJB().find(1)).getTracks();
	}

	@Test
	public void testAddArtist() throws Exception {
		Artist artistOfAlbum = new Artist();
		trackController.setArtistOfAlbumWhoWillBeAdded(artistOfAlbum);
		trackController.addArtist();
		assertTrue(trackController.getTrackToBeCreated().getArtists()
				.contains(artistOfAlbum));
	}

	@Test
	public void testRemoveArtist() throws Exception {
		Artist artistOfAlbum = new Artist();
		trackController.setArtistOfAlbumWhoWillBeAdded(artistOfAlbum);
		trackController.addArtist();
		assertTrue(trackController.getTrackToBeCreated().getArtists()
				.contains(artistOfAlbum));
		trackController.removeArtist(artistOfAlbum);
		assertFalse(trackController.getTrackToBeCreated().getArtists()
				.contains(artistOfAlbum));
	}

	@Test
	public void testDeleteTrackById() throws Exception {
		trackController.deleteTrackById(1);
		verify(trackController.getTrackEJB()).find(1);
		verify(trackController.getTrackEJB()).delete((Track) any());
	}

	@Test
	public void testGetAll() throws Exception {
		trackController.getAll();
		verify(trackController.getTrackEJB()).findAll();
	}

	@Test
	public void testRemoveArtistFromEditedTrack() throws Exception {
		trackController.setEditedTrack(new Track());
		Artist artistOfAlbum = new Artist();
		trackController.setArtistOfAlbumWhoWillBeAdded(artistOfAlbum);
		trackController.addArtistToEditedTrack();
		assertTrue(trackController.getEditedTrack().getArtists()
				.contains(artistOfAlbum));
		trackController.removeArtistFromEditedTrack(artistOfAlbum);
		assertFalse(trackController.getEditedTrack().getArtists()
				.contains(artistOfAlbum));
	}

	@Test
	public void testSaveEditedTrack() throws Exception {
		Track track = new Track();
		trackController.setEditedTrack(track);
		trackController.saveEditedTrack();
		verify(trackController.getTrackEJB()).update(track);
	}

	@Test
	public void testAddArtistToEditedTrack() throws Exception {
		trackController.setEditedTrack(new Track());
		Artist artistOfAlbum = new Artist();
		trackController.setArtistOfAlbumWhoWillBeAdded(artistOfAlbum);
		trackController.addArtistToEditedTrack();
		assertTrue(trackController.getEditedTrack().getArtists()
				.contains(artistOfAlbum));
	}

	@Test
	public void testGetTrackEJB() throws Exception {
		assertNotNull(trackController.getTrackEJB());
	}

	@Test
	public void testGetTrackToBeCreated() throws Exception {
		assertNotNull(trackController.getTrackToBeCreated());
	}

	@Test
	public void testGetArtistOfAlbumWhoWillBeAdded() throws Exception {
		assertNull(trackController.getArtistOfAlbumWhoWillBeAdded());
	}

	@Test
	public void testGetAlbumEJB() throws Exception {
		assertNotNull(trackController.getAlbumEJB());
	}

	@Test
	public void testGetEditedTrack() throws Exception {
		assertNull(trackController.getEditedTrack());
	}

}
