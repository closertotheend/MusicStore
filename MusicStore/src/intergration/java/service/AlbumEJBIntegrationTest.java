package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.Album;
import model.product.Product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import testutil.IntegrationTestBase;

@RunWith(MockitoJUnitRunner.class)
public class AlbumEJBIntegrationTest extends IntegrationTestBase {
	private Album theWall;

	@Override
	public void initBeforeEachTest() {
		theWall = new Album();
		theWall.setName("The Wall");
		theWall.setDescription("The Wall is the eleventh studio album by the English progressive rock group Pink Floyd. Released as a double album on 30 November 1979, it was subsequently performed live with elaborate theatrical effects, and adapted into a feature film, Pink Floyd – The Wall.");
		super.initBeforeEachTest();
	}

	@Test
	public void testDelete() throws Exception {
		assertEquals(0, albumEJB.count());

		Product product = new Product();
		product.setAlbum(theWall);
		productEJB.create(product);

		albumEJB.create(theWall);
		assertEquals(1, albumEJB.count());
		assertEquals(1, productEJB.count());

		albumEJB.delete(theWall);
		assertEquals(0, albumEJB.count());
		assertEquals(0, productEJB.count());
	}

	@Test
	public void testGetEm() {
		assertNotNull(albumEJB.getEm());
	}

	@Test
	public void testGetProductEJB() throws Exception {
		assertEquals(productEJB, albumEJB.getProductEJB());
	}

}
