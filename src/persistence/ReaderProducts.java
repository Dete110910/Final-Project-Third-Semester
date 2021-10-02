package persistence;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import models.Product;
import models.Warehouse;

public class ReaderProducts {
	
	private Warehouse warehouse;
	
	public ReaderProducts(String file) throws JsonParseException, IOException {
		this.initReading(file);
//		this.show();
	}
	
	private void initReading(String file) throws JsonParseException, IOException {
		
		JsonParser jsonParser = new JsonFactory().createParser(new File(file));
		
		warehouse = new Warehouse(this.readFile(jsonParser));
		jsonParser.close();
	}

	private ArrayList<Product> readFile(JsonParser jsonParser) throws JsonParseException, IOException{
		ArrayList<Product> listOfProducts = new ArrayList<Product>();
		String type = "";
		String name = "";
		double price = 0;
		
		while(jsonParser.nextToken() != JsonToken.END_ARRAY) {
			String auxString = jsonParser.getText();
			
			if(auxString.equals("type")) {
				jsonParser.nextToken();
				type = jsonParser.getText();
			}
			else if(auxString.equals("name")) {
				jsonParser.nextToken();
				name = jsonParser.getText();
			}
			else if(auxString.equals("price")) {
				jsonParser.nextToken();
				price = jsonParser.getDoubleValue();
				
				listOfProducts.add(new Product(type, name, price));
			}
		}
		
		return listOfProducts;
	}
	
	public Warehouse getWarehouse() {
		return warehouse;
	}
	
	public void show() {
		for(int i = 0; i < warehouse.getListOfProducts().size(); i++) {
			System.out.println(warehouse.getListOfProducts().get(i));
		}
	}
	
//	public static void main(String[] args) {
//		try {
//			ReaderProducts a = new ReaderProducts("data/files/products.json");
//			Warehouse n = a.getWarehouse();
//			
//			n.getListOfProducts().add(new Product("Food", "Doritos", 5000));
//			
//			WriterProducts b = new WriterProducts();
//			
//			b.saveProducts(n.getListOfProducts(), "data/products.json");
//			
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//	}
}
