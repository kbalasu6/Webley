package webley;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class WebleyCombinations {
	public List<List<Double>> findCombinations(WebleyData webleydata){
		
		List<List<Double>> combinations = new ArrayList<List<Double>>();	//variable to store all possible combinations
		List<Double> prices = new ArrayList<Double>();	//variable to store the prices as a list
		List<List<Double>> combinationOfPrices = new ArrayList<>();	//variable to store specific combinations that equal the target
		
		Map<Integer,Double> priceList = webleydata.getPriceList();	//retrieving prices to convert to list
		double target = webleydata.getTargetPrice();		//retrieving target price to check if sum of combination = target price
		
		
		for(int i=2; i<=priceList.size(); i++){		//creating a new list that has all prices
			prices.add(priceList.get(i));			//i=1 has target price...so exclude that
		}
		
		for(int i=1; i<=prices.size(); i++){			
			combinations.addAll(combination(prices,i));			//call the recursive function that finds all combinations
		}
		
		
		for(List<Double> singleCombination : combinations){		//iterate through all combinations
			double sum = 0;			
			for(int i=0; i<singleCombination.size(); i++){
				sum = sum + singleCombination.get(i);
			}
			if(sum==target)	combinationOfPrices.add(singleCombination);	//find the combination whose sum equals the target price	
		}
		return combinationOfPrices;			//return the list of all correct combinations whose sum equals target
		
	}
	
	public List<List<Double>> combination(List<Double> prices, int size){
		List<List<Double>> Allcombinations = new ArrayList<List<Double>>();	//variable that stores all combinations and sends it to the calling method
		List<Double> remaining = new ArrayList<Double>(prices);		//variable that will store all remaining prices during each recursion
		
		if (size == 0) {		//when all elements are combined and the there is no element left, return a singleton list
			return Arrays.asList(Collections.<Double> emptyList());
	    }

	    if (prices.isEmpty()) {		//when one recursion is over, return an empty list and move to the next recursion
	    	return Collections.emptyList();
	    }
	    
		double next = prices.iterator().next();		//select the next element. If new list, first element is selected
		
		List<List<Double>> combinations = combination(remaining,size-1);	//call recursion of same method on the remaining elements
		
		for(List<Double> combo : combinations){
			List<Double> recursiveCombo = new ArrayList<Double>(combo);		//variable that stores the combination for each recursion
			recursiveCombo.add(0,next);									//add duplicates to the list of combinations
			Allcombinations.add(recursiveCombo);						//add list of combinations to the list of all combinations
		}
		remaining.remove(next);									//remove the selected "next" element. removal of the "next" element 
																//here makes the program add duplicates to the combination  
		
		Allcombinations.addAll(combination(remaining,size));	//call the same method recursively with n-1 elements and repeat till size is 0.
		
		return Allcombinations;
		
	}

}
