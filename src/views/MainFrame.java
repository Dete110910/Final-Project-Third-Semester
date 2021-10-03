package views;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private RegistrationPanel rp;
	private TopPanel tp;
	private DownMenuPanel dmp;
	
	private ContainerProductsPanel cpp;
	private HomePanel hp;
	private SearchProductPanel spp;
	private ConfirmPurchaseDialog cpd;
	private ContainerBillPanel cbp;
	private ProfilePanel pp;
	private SettingsPanel sp;
	private ChangeUserDataDialog cudd;
	private SuggestionsDialog sd;
	private HelpDialog helpDialog;
	
	private JScrollPane scroll;
	
	ArrayList<JComponent> listOfComponents;
	
	public MainFrame(String[][] products, ActionListener actionListener, WindowListener windowListener) {
		super("The MaxApp");
		this.setSize(310, 550); 
		
		
		this.initComponents(products, actionListener);
		this.initRegistrationPanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(windowListener);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private void initComponents(String[][] products, ActionListener actionListener) {
		listOfComponents = new ArrayList<JComponent>();
		rp = new RegistrationPanel(actionListener);
		tp = new TopPanel("Main menu", "");
		dmp = new DownMenuPanel(actionListener);
		hp = new HomePanel(products, actionListener);
		spp = new SearchProductPanel(actionListener);
		cbp = new ContainerBillPanel();
		cpd = new ConfirmPurchaseDialog(actionListener);
		pp = new ProfilePanel(actionListener);
		sp = new SettingsPanel(actionListener);
		
		this.addPanelsToList();
	}
	
	public String getUsername() {
		return rp.getUsername();
	}
	
	public String getPassword() {
		return rp.getPassword();
	}
	
	public String getProductToSearch() {
		return spp.getProductToSearch();
	}
	
	public void addProductPanel(JPanel panel, String typeProduct) {
		spp.addProductPanel(panel, typeProduct);
	}
	
	public void removeProductPanel() {
		spp.removeProductPanel();
	}
	
	public void showNotFoundProductLabel() {
		spp.showNotFoundProductLabel();
	}
	
	public boolean isSelectedItem() {
		return cpp.getIsItemSelected();
	}
	
	public ArrayList<ArrayList<String>> getSelectedItems(){
		return cpp.getSelectedItems();
	}
	
	public void setIsItemSelected(boolean isSelected) {
		cpp.setIsItemSelected(isSelected);
	}
	
	public boolean determinateItemsAreSelected() {
		return cpp.determinateItemsAreSelected();
	}
	
	public void modifyVisibilityConfirmPurchaseDialog(boolean isVisible) {
		cpd.modifyVisibilityConfirmPurchaseDialog(isVisible);
	}
	
	public void addBillPanel(ArrayList<ArrayList<String>> productsToGenerateBill) {
		if(cpp.determinateItemsAreSelected()) {
			cbp.addBillPanel(productsToGenerateBill);
		}
	}
	
	public void showBillPanels() {
		cbp.showBillPanels();
	}
	
	public void modifyVisibilityNoBillFound(boolean isVisible) {
		cbp.modifyVisibilityNoBillFound(isVisible);
	}
	
	public void modifyVisibilityBillGuidelines(boolean isVisible) {
		cbp.modifyVisibilityBillGuidelines(isVisible);
	}
	
	public void changeMainMenu() {
		this.removePanels();
		scroll = new JScrollPane(hp, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		listOfComponents.add(scroll);
		tp.setMessages("Main menu", "");
		this.add(tp, BorderLayout.NORTH);
		this.add(scroll, BorderLayout.CENTER);
		this.add(dmp, BorderLayout.SOUTH);
	}
	
	public void changeProductByTypeMenu(JPanel panel) {
		this.removePanels();
		cpp = (ContainerProductsPanel) panel;
		listOfComponents.add(cpp);
		scroll = new JScrollPane(cpp, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		listOfComponents.add(scroll);
		tp.setMessages("Choose your products", "");
		this.add(tp, BorderLayout.NORTH);
		this.add(scroll, BorderLayout.CENTER);
	}
	
	public void changeSearchMenu() {
		if(cpp == null || !this.isSelectedItem() || !cpp.determinateItemsAreSelected()) {
			this.removePanels();
			SwingUtilities.updateComponentTreeUI(this);
			tp.setMessages("Search your product", "");
			this.add(tp, BorderLayout.NORTH);
			this.add(spp, BorderLayout.CENTER);
		}
		else {
			cpd.modifyVisibilityConfirmPurchaseDialog(true);
		}
		
	}
	
	public void changeBillMenu() {
		if(cpp == null || !this.isSelectedItem() || !cpp.determinateItemsAreSelected()) {
			this.removePanels();
			tp.setMessages("My bills", "");
			scroll = new JScrollPane(cbp, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			listOfComponents.add(scroll);
			this.add(tp, BorderLayout.NORTH);
			this.add(scroll, BorderLayout.CENTER);
		}
		else {
			cpd.modifyVisibilityConfirmPurchaseDialog(true);
		}
	}
	
	public void changeProfileMenu(String user, String adress) {
		if(cpp == null || !this.isSelectedItem() || !cpp.determinateItemsAreSelected()) {
			this.removePanels();
			tp.setMessages(user, adress);
			this.add(tp, BorderLayout.NORTH);
			this.add(pp, BorderLayout.CENTER);
		}
		else {
			cpd.modifyVisibilityConfirmPurchaseDialog(true);
		}
	}
	
	public void changeSettinsMenu() {
		this.removePanels();
		tp.setMessages("Settings", "");
		this.add(tp, BorderLayout.NORTH);
		this.add(sp, BorderLayout.CENTER);
		
	}
	
	public void createCangeUserDatadialog(String newData, String confirmNewData, String typeData, ActionListener actionListener) {
		cudd = new ChangeUserDataDialog(newData, confirmNewData, typeData, actionListener);
	}
	
	public String getNewDataText() {
		return cudd.getNewDataText();
	}
	
	public String getConfirmNewDataText() {
		return cudd.getConfirmNewDataText();
	}
	
	public void closeChangeUserDataDialog() {
		cudd.closeDialog();
	}
	
	public void modifyErrorMatchDataLabel(boolean isVisible) {
		cudd.modifyErrorMatchDataLabel(isVisible);
	}
	
	public void modifyErrorUserExistLabel(boolean isVisible) {
		cudd.modifyErrorUserExistLabel(isVisible);
	}
	
	public void modifyUserAddedLabel(boolean isVisible){
		cudd.modifyUserAddedLabel(isVisible);
	}
	
	public void createSuggestionsDialog(ActionListener actionListener) {
		sd = new SuggestionsDialog(actionListener);
	}
	
	public void closeSuggestionsDialog() {
		sd.closeDialog();
	}
	
	public void createHelpDialog(ActionListener actionListener) {
		helpDialog = new HelpDialog(actionListener);
	}
	
	public void closeHelpDialog() {
		helpDialog.closeDialog();
	}
	
	public void modifyVisibilityLabel(boolean isVisible) {
		rp.modifyVisibilityErrorLabel(isVisible);
	}
	
	private void initRegistrationPanel() {
		this.add(rp);
	}
	
	public void updateImageIcon(String image, String button) {
		dmp.updateImageButton(image, button);
	}
	
	private void addPanelsToList() {
		listOfComponents.add(rp);
		listOfComponents.add(hp);
		listOfComponents.add(spp);
		listOfComponents.add(tp);
		listOfComponents.add(cbp);
		listOfComponents.add(pp);
		listOfComponents.add(sp);
	}
	
	private void removePanels() {
		SwingUtilities.updateComponentTreeUI(this);
		for(int i = 0; i < listOfComponents.size(); i++) {
			this.remove(listOfComponents.get(i));
			SwingUtilities.updateComponentTreeUI(this);
		}
		spp.resetTextFieldSearchProductPanel();
		spp.modifyVisibilityNotFoundLabel(false);
		spp.removeProductPanel();
	}
}
