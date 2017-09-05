package webley;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


//This is the main driver program.


public class Webley {

	public static void main(String[] args) {
		Map<Integer,Double> priceList = new HashMap<Integer,Double>();	//variable to store the prices
		Map<Integer,String> itemsList = new HashMap<Integer,String>();	//variable to store the items
		List<List<Double>> combinationOfPrices = new ArrayList<>();	//variable which will have the combination of prices
		
		List<List<String>> combinationOfDishes = new ArrayList<>();			//variable which will have the combination of dishes
		
		String filepath;							//user input for file path
		String printchoice;							//user input for viewing combination of items or combination of price
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Filepath : ");
		filepath = scanner.next();

		try{
			CreateWebley createwebley = new CreateWebley();	//new instance to read the file
			createwebley.readFile(filepath);				//reading the file
			WebleyData wb = createwebley.getWebleyData();	
			priceList = wb.getPriceList();					//retrieving the prices
			itemsList = wb.getItemsList();					//retrieving the items
			
			WebleyCombinations wc = new WebleyCombinations();	//instantiating new class to find the combinations
			combinationOfPrices = wc.findCombinations(wb);		//method call to find all combinations and store it in the variable "targetCombinations"
			
			if(combinationOfPrices.size()==0){		//if no combination found
				System.out.println("Sorry. There is no Combination of dishes that match the Target Price");
			}
			else{	//combinations found...find the keys to the values in the Map and print them
				WebleyOperations webleyOp = new WebleyOperations();
				combinationOfDishes = webleyOp.retrieveKeys(combinationOfPrices, priceList, itemsList);	//items and prices have same keys. So find keys of anyone
				
				System.out.println("Select 1 to view Prices.\nSelect 2 to view Items.\nSelect q to Quit.\n");	//pretty printing the result with choice given to User.
				printchoice = scanner.next();
				while(!printchoice.equalsIgnoreCase("q")){
					switch(printchoice){
					case "1": 	webleyOp.prettyPrintPrices(combinationOfPrices);
								break;
					case "2":	webleyOp.prettyPrintDishes(combinationOfDishes);
								break;
					default:	System.out.println("Enter 1 for Prices, 2 for Items, q to Quit.");
								break;
					}
					System.out.println("\n\nSelect 1 to view Prices.\nSelect 2 to view Items.\nSelect q to Quit.\n");
					printchoice = scanner.next();
				}
				scanner.close();		//stop accepting input and exit 
			}
		} catch(WebleyException we){
			System.out.println(we.getErrorCode());
			System.out.println(we.getErrorMessage());
		}
	}	

}
