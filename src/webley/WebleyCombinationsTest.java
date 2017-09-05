package webley;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class WebleyCombinationsTest {

	@Test
	public final void testRetrieveData() throws WebleyException {
		String filepath = "/Users/Kaushik/Desktop/Webley/Sample.csv";
		List<List<Double>> targetCombinations = new ArrayList<>();
		CreateWebley createwebley = new CreateWebley();
		createwebley.readFile(filepath); // TODO
		WebleyData wb = createwebley.getWebleyData();
		WebleyCombinations wc = new WebleyCombinations();
		targetCombinations = wc.findCombinations(wb);
		assertEquals(targetCombinations.size(),1);
	}

	@Test
	public final void testCombination() {
		List<List<Double>> targetCombinations = new ArrayList<>();
		List<Double> prices = new ArrayList<>();
		prices.add(1.0);
		prices.add(2.0);
		WebleyCombinations wc = new WebleyCombinations();
		targetCombinations = wc.combination(prices, 2);
		assertEquals(targetCombinations.size(),3); 		//[[1.0],[2.0],[1.0,2.0]]
		
	}

}
