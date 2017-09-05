package webley;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WebleyOperations {
	//Method to retrieve the keys of values of successful combinations
	public List<List<String>> retrieveKeys(List<List<Double>> combinationOfPrices, Map<Integer, Double> priceList, Map<Integer, String> itemsList){
		List<List<Integer>> priceKeys = new ArrayList<>(); //variable to store all the keys of the Prices Map
		List<List<String>> itemKeys = new ArrayList<>();	//variable to store all keys of the Items Map
		
		for(List<Double> singlePrice : combinationOfPrices){	//loop through all the combinations whose sum = target price
			List<Integer> keyList = new ArrayList<>();			
			for(int i=0; i<singlePrice.size(); i++){
				keyList.add(getKeysPrices(priceList,singlePrice.get(i)));	//find the key of the specific price using the function
			}
			priceKeys.add(keyList);			//add the key to list of all the keys that are needed
		}
		
		
		for(List<Integer> singleKey : priceKeys){	//use the keys to the Price Map to find values of the Items Map
			List<String>  itemValues= new ArrayList<>();
			for(int i=0; i<singleKey.size(); i++){
				itemValues.add(itemsList.get(singleKey.get(i)));	//get the Values in the Items Map using the keys
			}
			itemKeys.add(itemValues);		//add all the dish names to a single list 
		}
		return itemKeys; 			//return the list that contains the name of the dishes
		
	}
	
	public int getKeysPrices(Map<Integer, Double> map, double value) {	//method to iterate over a keyset and find the key
		int keys = 0;
	    for (Entry<Integer, Double> entry : map.entrySet()) {	//entry set is faster than map.get(key)
	    	if(value == entry.getValue()){			//check if the dish name in the Items Map is the same dish as
	    											//the one we found in the list of correct combinations
	        	keys = entry.getKey();			//get the key of the particular dish 
	        }
	    }
	    return keys;		//return the key. this key will be used to find the name of the dish
	}
	
	//method to pretty print the dish names and the quantity
	public void prettyPrintDishes(List<List<String>> combinationOfDishes){
		List<String> uniqueItems = new ArrayList<>();
		for(List<String> singleDish : combinationOfDishes){	//iterate over the correct combination of dishes
			for(int i=0; i<singleDish.size(); i++){
				int x=1;
				String item = singleDish.get(i);
				if(uniqueItems.contains(item)){		//check if the dish is repeating or is unique
					x++;
					Print(x, item);				//same dish is used more than once
					uniqueItems.remove(item);	//print the number of times its used and name of the dish
				}
				else{
					uniqueItems.add(item);	//if used only once, add it to a temporary variable
				}
			}
		}
		
		for(int i=0; i<uniqueItems.size(); i++){		//all repeated dishes are printed. now print the dishes that are used just once
			Print(1,uniqueItems.get(i));
		}
	}
	
	//method to pretty print the prices and the quantity
	public void prettyPrintPrices(List<List<Double>> combinationOfPrices) {
		List<Double> uniqueItems = new ArrayList<>();
		for(List<Double> targetItem : combinationOfPrices){ //iterate over the correct combination of prices
			for(int i=0; i<targetItem.size(); i++){
				int x=1;
				Double price = targetItem.get(i);
				if(uniqueItems.contains(price)){	//check if the price is repeating or is unique
					x++;
					Print(x, price);				//same dish is used more than once
												//print the number of times its used and price of the dish
					uniqueItems.remove(price);		//no longer unique. so remove it from unique prices list
				}
				else{
					uniqueItems.add(price);		//used only once
				}
			}
		}
		
		for(int i=0; i<uniqueItems.size(); i++){
			Print(1,uniqueItems.get(i));		//all prices of repeated dishes are printed. now print the prices of dishes that are used just once
		}
	}
	
	//print method which accepts the quantity and the name of the dish
	public void Print(int count, String dish){
		System.out.println(count+" X "+dish);
	}
	
	//print method which accepts the quantity and the price of the dish
	public void Print(int count, Double price){
		System.out.println(count+" X "+price);
	}

}
