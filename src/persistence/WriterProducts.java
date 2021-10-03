package persistence;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;

import models.Product;

public class WriterProducts {

	public static void saveProducts(ArrayList<Product> listOfProducts, String file) {
		JsonGenerator jsonGenerator;
		
		try {
			jsonGenerator = new JsonFactory().createGenerator(new FileOutputStream(file));
			jsonGenerator.setPrettyPrinter(new DefaultPrettyPrinter());
			
			jsonGenerator.writeStartArray();
			
			for(Product product : listOfProducts) {
				jsonGenerator.writeStartObject();
				
				jsonGenerator.writeStringField("type", product.getType());
				jsonGenerator.writeStringField("name", product.getName());
				jsonGenerator.writeNumberField("price", product.getPrice());
				jsonGenerator.writeStringField("filePathImage", product.getFilePathImage());
				
				jsonGenerator.writeEndObject();
			}
			
			jsonGenerator.writeEndArray();
			
			jsonGenerator.flush();
			jsonGenerator.close();	
		}
		catch(IOException e) {
			//CAMBIAR
			e.printStackTrace();
		}
	}
	
}
