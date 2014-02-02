package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import model.Album;
import model.product.Product;
import model.product.ProductType;

import org.junit.Test;

import testutil.IntegrationTestBase;

public class ProductEJBIntegrationTest extends IntegrationTestBase {
	private final Album theWall = new Album();

	@Test
	public void testGetProductsByAlbumId() throws Exception {
		assertEquals(0, albumEJB.count());
		assertEquals(0, productEJB.count());
		Product cd = new Product();
		cd.setAlbumType(ProductType.CD);
		productEJB.create(cd);
		cd.setAlbum(theWall);

		Product lp = new Product();
		lp.setAlbumType(ProductType.LP);
		productEJB.create(lp);
		lp.setAlbum(theWall);

		albumEJB.create(theWall);
		assertEquals(1, albumEJB.count());
		assertEquals(2, productEJB.count());

		assertEquals(2, productEJB.getProductsByAlbumId(theWall.getId()).size());
		assertTrue(productEJB.getProductsByAlbumId(theWall.getId())
				.contains(cd));
		assertTrue(productEJB.getProductsByAlbumId(theWall.getId())
				.contains(lp));
	}

	@Test
	public void testGetEm() {
		assertNotNull(productEJB.getEm());
	}
}
