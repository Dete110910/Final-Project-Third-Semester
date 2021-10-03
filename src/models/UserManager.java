package models;

import java.util.ArrayList;

public class UserManager {
	
	ArrayList<User> listOfUsers;
	
	public UserManager(ArrayList<User> newListOfUsers) {
		listOfUsers = newListOfUsers;
	}
	
	public boolean determineUserExistence(String user) {
		for(int i = 0; i < listOfUsers.size(); i++) {
			if(listOfUsers.get(i).getUsername().equals(user)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean determinateUserAndPasswordExistence(String user, String password) {
		for(int i = 0; i < listOfUsers.size(); i++) {
			if(listOfUsers.get(i).getUsername().equals(user) && listOfUsers.get(i).getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public String searchAdressByUser(String user) {
		for(int i = 0; i < listOfUsers.size(); i++) {
			if(listOfUsers.get(i).getUsername().equals(user)) {
				return listOfUsers.get(i).getAddress();
			}
		}
		return "";
	}
	
	public void addUser(String username, String password, String address) {
		listOfUsers.add(new User(username, password, address));
	}
	
	public void changeUsername(String oldUsername, String newUsername) {
		for(int i = 0; i < listOfUsers.size(); i++) {
			if(listOfUsers.get(i).getUsername().equals(oldUsername)) {
				listOfUsers.get(i).setUsername(newUsername);
			}
		}
	}
	
	public void changePassword(String username, String newPassword) {
		for(int i = 0; i < listOfUsers.size(); i++) {
			if(listOfUsers.get(i).getUsername().equals(username)) {
				listOfUsers.get(i).setPassword(newPassword);
			}
		}
	}
	
	public void changeAddress(String username, String newAddress) {
		for(int i = 0; i < listOfUsers.size(); i++) {
			if(listOfUsers.get(i).getUsername().equals(username)) {
				listOfUsers.get(i).setAddress(newAddress);
			}
		}
	}
	
	public ArrayList<User> getListOfUsers(){
		return this.listOfUsers;
	}

}
