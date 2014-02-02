package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import model.Album;
import model.Artist;
import model.Track;

import org.junit.Test;

import testutil.IntegrationTestBase;

public class TrackEJBIntegrationTest extends IntegrationTestBase {

	Track theThinIce = new Track();
	Track brickInTheWall = new Track();
	Track doNotLeaveMeNow = new Track();
	Artist pinkFloyd = new Artist();
	Album theWall = new Album();

	@Override
	public void initBeforeEachTest() {
		HashSet<Artist> authors = new HashSet<>();
		authors.add(pinkFloyd);
		theThinIce.setName("The Thin Ice");
		theThinIce.setArtists(authors);
		brickInTheWall.setName("Another Brick in the Wall");
		brickInTheWall.setArtists(authors);
		doNotLeaveMeNow.setName("Dont Leave Me Now");
		doNotLeaveMeNow.setArtists(authors);
		Set<Track> tracks = new HashSet<>();
		tracks.add(brickInTheWall);
		tracks.add(theThinIce);
		tracks.add(doNotLeaveMeNow);
		theWall.setTracks(tracks);
		super.initBeforeEachTest();
	}

	@Test
	public void testGetTracksByArtists() throws Exception {
		artistEJB.create(pinkFloyd);
		albumEJB.create(theWall);
		trackEJB.create(theThinIce);
		trackEJB.create(brickInTheWall);
		trackEJB.create(doNotLeaveMeNow);
		assertEquals(3, trackEJB.count());
	}

	@Test
	public void testGetEm() {
		assertNotNull(trackEJB.getEm());
	}
}
