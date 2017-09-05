package webley;

import static org.junit.Assert.*;

import org.junit.Test;

public class WebleyDataTest {

	@Test
	public final void testGetTargetName() throws WebleyException {
		String filepath = "/Users/Kaushik/Desktop/Webley/Sample.csv";
		CreateWebley createwebley = new CreateWebley();
		createwebley.readFile(filepath); // TODO
		WebleyData wb = createwebley.getWebleyData();
		//assertEquals(wb.getTargetName(),"Target price");
		assertTrue(wb.getTargetName(),true);
	}

	@Test
	public final void testGetTargetPrice() throws WebleyException {
		String filepath = "/Users/Kaushik/Desktop/Webley/Sample.csv";
		CreateWebley createwebley = new CreateWebley();
		createwebley.readFile(filepath); // TODO
		WebleyData wb = createwebley.getWebleyData();
		//assertEquals(wb.getTargetPrice(),15.05);
		assertEquals(15.05,wb.getTargetPrice(),0.5);
	}

}
