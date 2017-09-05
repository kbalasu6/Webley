package webley;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CreateWebley {
	private BufferedReader buffer;				//Buffer object to read the File
	private FileReader file;					//File object
	WebleyData webleydata = new WebleyData();	//Class that contains all the data read from the File
	
	public WebleyData getWebleyData(){			//Getter method to securely retrieve data later
		return this.webleydata;
	}
	
	public void readFile(String filename) throws WebleyException {
		
		Map<Integer,Double> priceList = new HashMap<Integer,Double>();//Variable that maps integer with the Price
		Map<Integer,String> itemsList = new HashMap<Integer,String>();//Variable that maps integer with the Item
		
		String[] data = new String[]{};			//Variable to temporarily store a single line
		int i=1;								//Variable to track the lines
		double price;							//Temporary variable that holds the Price
		String items;							//Temporary variable that holds the Item
		try {
			file = new FileReader(filename);
			buffer = new BufferedReader(file);
			String line;
			while( (line= buffer.readLine()) != null){
				if(line.length()>0){
					if(!line.contains("$")){	//Prices in the CSV file must contain $ as a prefix
						throw new WebleyException("ERR-003","Prices contain a special character other than '$'.");
					}
					data = line.split(",");		//Splitting the line into comma separated values(csv)
					data[1] = data[1].replaceAll("\\$","");	//replacing the $ sign with an empty character
					price = Double.parseDouble(data[1]);	//parsing the replaced string into a double
					items = data[0];							
					priceList.put(i, price);				//adding the prices one by one
					itemsList.put(i, items);				//adding the items one by one
					i++;									//next line
				}
			}
			buffer.close();
			webleydata.setItemsList(itemsList);			//storing the list of items
			webleydata.setPriceList(priceList);			//storing the list of prices
			webleydata.setTargetName(itemsList.get(1));	//storing the target item separately
			if(priceList.get(1).equals(0.0)){			//storing target price separately, which can not be Zero
				throw new WebleyException("ERR-004","Target Price is set to zero");
			}
			webleydata.setTargetPrice(priceList.get(1));
		}catch (FileNotFoundException fnf) {	//Handling various exceptions through a new Custome exception class called WebleyException
			WebleyException we = new WebleyException("ERR-001","Invalid Filepath. Please enter absolute filepath of the file and try again.");
			throw we;
		}catch (NumberFormatException nff) {
			WebleyException we = new WebleyException("ERR-002","Prices are not in the correct format. Make sure all the Prices are entered in the right format."
					+ "\nHint : Remove Inverted Comma or Comma");
			throw we;
		} catch (WebleyException we) {
			throw we;
		}catch (IOException e){
			WebleyException we = new WebleyException("ERR-999","Something went wrong! Try again.");
			throw we;
		} 
	}
}
