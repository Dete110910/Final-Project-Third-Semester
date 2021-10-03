package models;

import java.util.ArrayList;

public class Warehouse {

	private ArrayList<Product> listOfProducts;
	
	public Warehouse(ArrayList<Product> newListOfProducts) {
		listOfProducts = newListOfProducts;
	}
	
	public String[][] getProductsAsArrayByType(String type){
		ArrayList<Product> listOfProductsByType = new ArrayList<Product>();
		for(int i = 0; i < listOfProducts.size(); i++) {
			if(listOfProducts.get(i).getType().equals(type)) {
				listOfProductsByType.add(listOfProducts.get(i));
			}
		}
		String[][] productsAsArray = this.converToArray(listOfProductsByType);
		
		return productsAsArray;
	}
	
	public String[] searchProduct(String productToSearch) {
		String[] product = new String[4];
		for(int i = 0; i < listOfProducts.size(); i++) {
			if(listOfProducts.get(i).getName().equals(productToSearch)) {
				product[0] = listOfProducts.get(i).getType();
				product[1] = listOfProducts.get(i).getName();
				product[2] = String.valueOf(listOfProducts.get(i).getPrice());
				product[3] = listOfProducts.get(i).getFilePathImage();
			}
		}
		return product;
	}
	
	public String[][] getThreeFirstItemsByType(){
		ArrayList<Product> listOfThreeFirstProducts = new ArrayList<Product>();
		ArrayList<String> listOfTypes = this.getTypesOfProducts();
		int counter = 0;
		int j = 0;
		for(int i = 0; i < listOfProducts.size() && j < listOfTypes.size(); i++) {
			if(listOfProducts.get(i).getType().equals(listOfTypes.get(j))) {
				listOfThreeFirstProducts.add(listOfProducts.get(i));
				counter++;
				if(counter > 2) {
					j++;
					counter = 0;
				}
			}
		}
		String[][] threeFirstProducts = this.converToArray(listOfThreeFirstProducts);
		return threeFirstProducts;
	}
	
	private ArrayList<String> getTypesOfProducts(){
		ArrayList<String> listOfTypes = new ArrayList<String>();
		listOfTypes.add(listOfProducts.get(0).getType());
		for(int i = 0, j = 0; i < listOfProducts.size(); i++) {
			if(!listOfProducts.get(i).getType().equals(listOfTypes.get(j))) {
				listOfTypes.add(listOfProducts.get(i).getType());
				j++;
			}
		}
		return listOfTypes;
	}

	private String[][] converToArray(ArrayList<Product> listOfProducts){
		
		String[][] productsAsArray = new String[listOfProducts.size()][4];
		for(int i = 0; i < listOfProducts.size(); i++) {
			productsAsArray[i][0] = listOfProducts.get(i).getType();
			productsAsArray[i][1] = listOfProducts.get(i).getName();
			productsAsArray[i][2] = String.valueOf(listOfProducts.get(i).getPrice());
			productsAsArray[i][3] = listOfProducts.get(i).getFilePathImage();
		}
		return productsAsArray;
		
	}
	
	public ArrayList<Product> getListOfProducts() {
		return listOfProducts;
	}

	public void setListOfProducts(ArrayList<Product> listOfProducts) {
		this.listOfProducts = listOfProducts;
	}
	
	
}
