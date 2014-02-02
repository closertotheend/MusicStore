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
	private final Album theWall = new Album();

	@Test
	public void testDelete() throws Exception {
		assertEquals(0, albumEJB.count());
		theWall.setName("The Wall");
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
