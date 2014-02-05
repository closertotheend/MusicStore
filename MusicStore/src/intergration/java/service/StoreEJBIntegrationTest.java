package service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import model.Store;
import model.product.Product;

import org.junit.Test;

import testutil.IntegrationTestBase;

public class StoreEJBIntegrationTest extends IntegrationTestBase {

	@Test
	public void testDelete() {
		Product product = new Product();
		productEJB.create(product);

		Product product2 = new Product();
		productEJB.create(product2);

		assertEquals(2, productEJB.count());

		List<Product> products = new ArrayList<>();
		products.add(product);
		products.add(product2);

		Store store = new Store();
		store.setProducts(products);
		storeEJB.create(store);
		assertEquals(1, storeEJB.count());
		productEJB.flushEm();

		storeEJB.delete(store);
		assertEquals(0, storeEJB.count());

		assertEquals(0, productEJB.count());

	}
}
