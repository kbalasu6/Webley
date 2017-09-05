package webley;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class CreateWebleyTest {

	@Test
	public final void testGetWebleyDataPriceList() throws WebleyException {
		String filepath = "/Users/Kaushik/Desktop/Webley/Sample.csv";
		Map<Integer,Double> priceList = new HashMap<Integer,Double>();
		CreateWebley createwebley = new CreateWebley();
		createwebley.readFile(filepath); // TODO
		WebleyData wb = createwebley.getWebleyData();
		priceList = wb.getPriceList();
		assertEquals(7,priceList.size());	//Number of prices in the given question = 7
	}
	
	@Test
	public final void testGetWebleyDataItemsList() throws WebleyException {
		String filepath = "/Users/Kaushik/Desktop/Webley/Sample.csv";
		Map<Integer,String> itemsList = new HashMap<Integer,String>();
		CreateWebley createwebley = new CreateWebley();
		createwebley.readFile(filepath); // TODO
		WebleyData wb = createwebley.getWebleyData();
		itemsList = wb.getItemsList();
		assertEquals(7,itemsList.size());		//Number of items in the given question = 7(incl. Target price)
	}

	@Test
	public final void testReadFile01() {
		String filepath = "abc";
		try{
			CreateWebley createwebley = new CreateWebley();
			createwebley.readFile(filepath); // TODO
		} catch(WebleyException we){
			assertEquals("ERR-001",we.getErrorCode());
		}
	}
	
	@Test
	public final void testReadFile02() {
		String filepath = "/Users/Kaushik/Desktop/Webley/Sample2.csv";
		try{
			CreateWebley createwebley = new CreateWebley();
			createwebley.readFile(filepath); // TODO
		} catch(WebleyException we){
			assertEquals("ERR-002",we.getErrorCode());
		}
	}
	
	@Test
	public final void testReadFile03() {
		String filepath = "/Users/Kaushik/Desktop/Webley/Sample3.csv";
		try{
			CreateWebley createwebley = new CreateWebley();
			createwebley.readFile(filepath); // TODO
		} catch(WebleyException we){
			assertEquals("ERR-003",we.getErrorCode());
		}
	}
	
	@Test
	public final void testReadFile04() {
		String filepath = "/Users/Kaushik/Desktop/Webley/Sample4.csv";
		try{
			CreateWebley createwebley = new CreateWebley();
			createwebley.readFile(filepath); // TODO
		} catch(WebleyException we){
			assertEquals("ERR-004",we.getErrorCode());
		}
	}
	
	@Test
	public final void testReadFile() {
		String filepath = "/Users/Kaushik/Desktop/Webley/Sample.csv";
		try{
			CreateWebley createwebley = new CreateWebley();
			createwebley.readFile(filepath); // TODO
		} catch(WebleyException we){
			assertEquals(0,we.getErrorCode().length());
		}
	}

}
