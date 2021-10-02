package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import utilities.views.Utilities;

public class ContainerProductsPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private boolean isItemSelected;
	ArrayList<ProductPanel> listOfProductsPanel;
	private JButton generateBillButton;
	
	public ContainerProductsPanel(String[][] products, ActionListener actionListener) {
		this.setLayout(new GridBagLayout());
		this.setBackground(new Color(27,27,27));
		this.initPanels(products, actionListener); 
		this.setVisible(true);
	}
	
	private void initPanels(String[][] products, ActionListener actionListener) {
		isItemSelected = false;
		listOfProductsPanel = new ArrayList<ProductPanel>();
		int yPosition = 0;
		for(int i = 0; i < products.length; i++) {
			listOfProductsPanel.add(new ProductPanel(products[i][0], products[i][1], Double.parseDouble(products[i][2]), actionListener));
			Utilities.setBackgroundAndForeGround(listOfProductsPanel.get(i), new Color(30,30,30), Color.white);
			Utilities.setPositionInGridBagLayout(this, listOfProductsPanel.get(i), 0, yPosition++, 1, 1, 1, 1, "HORIZONTAL", 10, getInsets());
		}
		
		generateBillButton = new JButton("Generate Bill");
		
		this.setFeaturesComponents(actionListener, yPosition);
	}
	
	public ArrayList<ArrayList<String>> getSelectedItems() {
		ArrayList<ArrayList<String>> listOfProductsToBuy = new ArrayList<ArrayList<String>>();
		ArrayList<String> oneProduct;
		for(int i = 0; i < listOfProductsPanel.size(); i++) {
			if(Integer.parseInt(listOfProductsPanel.get(i).getQuantityOfItemSelected()) != 0) {
				oneProduct = new ArrayList<String>();
				oneProduct.add(listOfProductsPanel.get(i).getProductName());
				oneProduct.add(listOfProductsPanel.get(i).getProductPrice());
				oneProduct.add(listOfProductsPanel.get(i).getQuantityOfItemSelected());
				
				listOfProductsToBuy.add(oneProduct);
			}
		}
		
		return listOfProductsToBuy;
	}
	
	public boolean determinateItemsAreSelected() {
		for(int i = 0; i < listOfProductsPanel.size(); i++) {
			if(Integer.parseInt(listOfProductsPanel.get(i).getQuantityOfItemSelected()) != 0) {
				return true;
			}
		}
		return false;
	}
	
	private void setFeaturesComponents(ActionListener actionListener, int yPositionButton) {
		generateBillButton.addActionListener(actionListener);
		generateBillButton.setActionCommand("generateBill");
		generateBillButton.setFont(new Font("Cooper Black", 0, 15));
		generateBillButton.setBorderPainted(false);
		Utilities.setBackgroundAndForeGround(generateBillButton, new Color(41,41,41), new Color(163,23,34));
		Utilities.setPositionInGridBagLayout(this, generateBillButton, 0, yPositionButton++, 1, 1, 1, 1, "NONE", 10, new Insets(30, 50, 2, 45));
	}
	
	public void setIsItemSelected(boolean isSelected) {
		isItemSelected = isSelected;
	}
	
	public boolean getIsItemSelected() {
		return isItemSelected;
	}
	
	

}
