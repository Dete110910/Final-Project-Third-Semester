package models;

public class Product {
	
	private String type;
	private String name;
	private double price;
	private String filePathImage;
	
	
	public Product(String type, String name, double price, String filePathImage) {
		this.type = type;
		this.name = name;
		this.price = price;
		this.filePathImage = filePathImage;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public String getFilePathImage() {
		return filePathImage;
	}

	public void setFilePathImage(String filePathImage) {
		this.filePathImage = filePathImage;
	}

	@Override
	public String toString() {
		return "Product [type=" + type + ", name=" + name + ", price=" + price + ", filePathImage=" + filePathImage
				+ "]";
	}
	

}
