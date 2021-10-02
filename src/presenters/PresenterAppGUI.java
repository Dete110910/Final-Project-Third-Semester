package presenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParseException;

import models.UserManager;
import models.Warehouse;
import persistence.FileManagerUser;
import persistence.ReaderProducts;
import persistence.WriterProducts;
import views.ContainerProductsPanel;
import views.MainFrame;
import views.ProductPanel;
import views.SingUpDialog;

public class PresenterAppGUI implements ActionListener, WindowListener{
	
	private Warehouse wh;
	private UserManager um;

	private MainFrame mf;
	private SingUpDialog sud;
	
	private ReaderProducts rp;
	private FileManagerUser fmu;
	
	private String user;
	
	public PresenterAppGUI() throws JsonParseException, IOException {
		fmu = new FileManagerUser();
		um = new UserManager(fmu.initReading("data/files/users.json"));
		rp = new ReaderProducts("data/files/products.json");
		wh = rp.getWarehouse();
		mf = new MainFrame(wh.getThreeFirstItemsByType() ,this, this);
	}
	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		switch(actionEvent.getActionCommand()) {
				case "send":
					this.actionSendButton();
				break;
				
				case "singUp":
					this.actionSingUpButton();
				break;
				
				case "done":
					this.actionDoneRegister();
				break;
				
				case "homeButton":
					this.actionHomeButton();
				break;
					
				case "searchButton":
					this.actionSearchButton();
				break;
				
				case "billButton":
					this.actionBillButton();
				break;
				
				case "profileButton":
					this.actionProfileButton();
				break;
				
				case "searchProduct":
					this.searchProduct();
				break;
				
				case "Food":
					this.actionChangeProductsByType("Food");
				break;
				
				case "Drinks":
					this.actionChangeProductsByType("Drinks");
				break;
					
				case "Cleaning products":
					this.actionChangeProductsByType("Cleaning products");
				break;
				
				case "isItemSelected":
					this.actionIsItemSelected();
				break;
				
				case "generateBill":
					this.actionGenerateBill();
				break;
				
				case "closeDialogConfirmPurchase":
					this.actionCloseDialogConfirmPurchase();
				break;
				
				case "settings":
				break;
				
				case "suggestions":
				break;
				
				case "help":
				break;
		}
	}
	
	private void actionSendButton() {
		boolean existUserAndPassword = um.determinateUserAndPasswordExistence(mf.getUsername(), mf.getPassword());
		if(existUserAndPassword) {
			user = mf.getUsername();
			mf.modifyVisibilityLabel(false);
			mf.changeMainMenu();
		}
		else {
			mf.modifyVisibilityLabel(true);
		}
	}
	
	private void actionSingUpButton() {
		sud = new SingUpDialog(this);
	}
	
	private void actionDoneRegister() {
		String newUserName = sud.getNewUserName();
		String password = sud.getNewPassword();
		String confirmPassword = sud.getConfirmNewPassword();
		
		if(um.determineUserExistence(newUserName) || newUserName.equals("") || newUserName.equals(" ")) {
			sud.modifyErrorMatchPasswordLabel(false);
			sud.modifyErrorUserExistLabel(true);
		}
		else if(password.equals(confirmPassword) && !um.determineUserExistence(newUserName)){
			sud.modifyErrorUserExistLabel(false);
			sud.modifyErrorMatchPasswordLabel(false);
			um.addUser(newUserName, password, "");
			sud.modifyUserAddedLabel(true);
		}
		else {
			sud.modifyErrorUserExistLabel(false);
			sud.modifyErrorMatchPasswordLabel(true);
		}
	}
	
	private void actionHomeButton() {
		this.updateIcons("data/icons/homeIconOn.png", "home");
		mf.changeMainMenu();
	}
	
	private void actionSearchButton() {
		this.updateIcons("data/icons/searchIconOn.png", "search");
		mf.changeSearchMenu();
	}
	
	private void searchProduct() {
		String[] product = wh.searchProduct(mf.getProductToSearch());
		if(product[0] != null) {
			mf.removeProductPanel();
			ProductPanel pp = new ProductPanel(product[0], product[1], Double.parseDouble(product[2]), this);
			pp.modifyVisibilityOfComboBox(false);
			mf.addProductPanel(pp, product[0]);
		}
		else {
			mf.showNotFoundProductLabel();
		}
	}
	
	private void actionChangeProductsByType(String typeProduct) {
		ContainerProductsPanel cpp = new ContainerProductsPanel(wh.getProductsAsArrayByType(typeProduct), this);
		mf.changeProductByTypeMenu(cpp);
	}
	
	private void actionIsItemSelected() {
		mf.setIsItemSelected(true);
	}
	
	private void actionGenerateBill() {
		if(mf.determinateItemsAreSelected()) {
			mf.setIsItemSelected(false);
			mf.modifyVisibilityNoBillFound(false);
			mf.modifyVisibilityBillGuidelines(true);
			ArrayList<ArrayList<String>> productsToGenerateBill = mf.getSelectedItems();
			mf.addBillPanel(productsToGenerateBill);
			
		}
	}
	
	private void actionCloseDialogConfirmPurchase() {
		mf.modifyVisibilityConfirmPurchaseDialog(false);
	}
	
	
	private void actionBillButton() {
		this.updateIcons("data/icons/billsIconOn.png", "bill");
		mf.changeBillMenu();
		
	}
	
	private void actionProfileButton() {
		this.updateIcons("data/icons/profileIconOn.png", "profile");
		mf.changeProfileMenu(user, um.searchAdressByUser(user));
	}
	
	private void updateIcons(String image,String button) {
		switch(button) {
				case "home":
					mf.updateImageIcon(image, "home");
					mf.updateImageIcon("data/icons/searchIconOff.png", "search");
					mf.updateImageIcon("data/icons/billsIconOff.png", "bill");
					mf.updateImageIcon("data/icons/profileIconOff.png", "profile");
				break;
				
				case "search":
					mf.updateImageIcon("data/icons/homeIconOff.png", "home");
					mf.updateImageIcon(image, "search");
					mf.updateImageIcon("data/icons/billsIconOff.png", "bill");
					mf.updateImageIcon("data/icons/profileIconOff.png", "profile");
				break;
				
				case "bill":
					mf.updateImageIcon("data/icons/homeIconOff.png", "home");
					mf.updateImageIcon("data/icons/searchIconOff.png", "search");
					mf.updateImageIcon(image, "bill");
					mf.updateImageIcon("data/icons/profileIconOff.png", "profile");
				break;
				
				case "profile":
					mf.updateImageIcon("data/icons/homeIconOff.png", "home");
					mf.updateImageIcon("data/icons/searchIconOff.png", "search");
					mf.updateImageIcon("data/icons/billsIconOff.png", "bill");
					mf.updateImageIcon(image, "profile");
				break;
		}
	}
	
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		WriterProducts.saveProducts(wh.getListOfProducts(), "data/files/products.json");
		fmu.saveUsers(um.getListOfUsers(), "data/files/users.json");
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	public static void main(String[] args) {
		try {
			new PresenterAppGUI();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
