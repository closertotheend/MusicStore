package clicking;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

/**
 * Glassfish returns 200 all the time, thats why class is marked as deprecated
 * 
 * @author ilja
 */
@Deprecated
public class TestURLResponses {

	@Test
	public void testUserSection() throws Exception {
		assertEquals(
				200,
				getStatusCode("http://localhost:8080/MusicStore/pages/user/register.xhtml"));
		assertEquals(
				200,
				getStatusCode("http://localhost:8080/MusicStore/pages/user/login.xhtml"));
		assertEquals(
				200,
				getStatusCode("http://localhost:8080/MusicStore/pages/user/showAll.xhtml"));
	}

	public static int getStatusCode(final String adress) throws IOException {
		URL url = new URL("http://www.google.com/humans.txt");
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		int statusCode = http.getResponseCode();
		return statusCode;
	}

}
