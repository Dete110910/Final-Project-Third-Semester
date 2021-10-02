package persistence;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;

import models.User;

public class FileManagerUser {
	
	public ArrayList<User> initReading(String file) throws JsonParseException, IOException {
		JsonParser jsonParser = new JsonFactory().createParser(new File(file));
		
		return this.readFile(jsonParser);
		

	}

	private ArrayList<User> readFile(JsonParser jsonParser) throws JsonParseException, IOException {
		ArrayList<User> listOfUsers = new ArrayList<User>();
		String username = "";
		String password = "";
		String address = "";
		
		
		while(jsonParser.nextToken() != JsonToken.END_ARRAY) {
			String auxString = jsonParser.getText();
			
			if(auxString.equals("username")) {
				jsonParser.nextToken();
				username = jsonParser.getText();
			}
			else if(auxString.equals("password")) {
				jsonParser.nextToken();
				password = jsonParser.getText();
			}
			else if(auxString.equals("address")) {
				jsonParser.nextToken();
				address = jsonParser.getText();
				
				listOfUsers.add(new User(username, password, address));
			}
		}
		
		jsonParser.close();
		return listOfUsers;
	}
	
	public void saveUsers(ArrayList<User> listOfUsers, String file) {
		JsonGenerator jsonGenerator;
		
		try {
			jsonGenerator = new JsonFactory().createGenerator(new FileOutputStream(file));
			jsonGenerator.setPrettyPrinter(new DefaultPrettyPrinter());
			
			jsonGenerator.writeStartArray();
			
			for(User user : listOfUsers) {
				jsonGenerator.writeStartObject();
				
				jsonGenerator.writeStringField("username", user.getUsername());
				jsonGenerator.writeStringField("password", user.getPassword());
				jsonGenerator.writeStringField("address", user.getAddress());
				
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
