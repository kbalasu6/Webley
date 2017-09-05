package webley;

import java.util.HashMap;
import java.util.Map;

public class WebleyData {
	private Map<Integer,Double> priceList = new HashMap<Integer,Double>();
	private Map<Integer,String> itemsList = new HashMap<Integer,String>();
	
	private String targetName;
	private double targetPrice;
	
	public String getTargetName() {
		return targetName;
	}
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}
	public double getTargetPrice() {
		return targetPrice;
	}
	public void setTargetPrice(double targetPrice) {
		this.targetPrice = targetPrice;
	}
	public Map<Integer, Double> getPriceList() {
		return priceList;
	}
	public void setPriceList(Map<Integer, Double> priceList) {
		this.priceList = priceList;
	}
	public Map<Integer, String> getItemsList() {
		return itemsList;
	}
	public void setItemsList(Map<Integer, String> itemsList) {
		this.itemsList = itemsList;
	}
	
	

}
