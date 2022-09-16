/**
 * 
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import weather.StevensonReading;

/**
 * @author mtowya
 *
 */
public class StevensonReadingTest {
	
    private StevensonReading myStevensonReading;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.myStevensonReading = new StevensonReading(40.157599, 23.301219, 21.642746, 58);
	}

	@Test
	public void test() {
		assertEquals(this.myStevensonReading.getDewPoint(), 23);
	}

}
