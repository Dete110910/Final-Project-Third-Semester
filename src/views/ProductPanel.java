package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import utilities.views.Utilities;

public class ProductPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JLabel productPicLabel, productNameLabel, productPriceLabel;
	private JComboBox quantityProductsComboBox;
	private String typeProduct;
	
	String[] numbers = {"0","1","2","3","4","5","6","7","8","9","10"};
	
	public ProductPanel(String type, String name, double price, String image, ActionListener actionListener){
		typeProduct = type;
		this.setLayout(new GridBagLayout());
		this.setBackground(new Color(20,20,20));
		this.setBorder(BorderFactory.createLineBorder(Color.gray));
		this.initComponents(name, price, image, actionListener);
		this.setVisible(true);
	}
	
	private void initComponents(String name, double price, String image,ActionListener actionListener) {
		productPicLabel = new JLabel();
		productNameLabel = new JLabel(name);
		productPriceLabel = new JLabel("$" + String.valueOf(price));
		
		quantityProductsComboBox = new JComboBox(numbers);
		quantityProductsComboBox.addActionListener(actionListener);
		quantityProductsComboBox.setActionCommand("isItemSelected");
		
		this.setImages(image);
		this.setFeaturesComponents();
		this.setPositions();
	}
	
	private void setImages(String image) {
		Utilities.setImageLabel(image, productPicLabel, 70, 75);
	}
	
	private void setFeaturesComponents() {
		productNameLabel.setFont(new Font("Franklin Gothic Demi", 0, 16));
		productPriceLabel.setFont(new Font("Franklin Gothic Demi", 0, 14));
		
		Utilities.setBackgroundAndForeGround(productNameLabel, getBackground(), Color.white);
		Utilities.setBackgroundAndForeGround(productPriceLabel, getBackground(), Color.white);
	}
	
	private void setPositions() {
		Utilities.setPositionInGridBagLayout(this, productPicLabel, 0, 0, 1, 1, 0, 0, "NONE", 15, getInsets());
		Utilities.setPositionInGridBagLayout(this, productNameLabel, 2, 0, 1, 1, 1, 0, "NONE", 10, getInsets());
		Utilities.setPositionInGridBagLayout(this, productPriceLabel, 2, 1, 1, 1, 1, 0, "NONE", 12, getInsets());
		Utilities.setPositionInGridBagLayout(this, quantityProductsComboBox, 4, 0, 1, 1, 1, 1, "NONE", 13, getInsets());
	}
	
	
	public String getTypeProduct() {
		return typeProduct;
	}
	
	public String getProductName() {
		return productNameLabel.getText();
	}
	
	public String getProductPrice() {
		return productPriceLabel.getText();
	}
	
	public String getQuantityOfItemSelected() {
		return (String)quantityProductsComboBox.getSelectedItem();
	}
	
	public void modifyVisibilityOfComboBox(boolean isVisible) {
		quantityProductsComboBox.setVisible(isVisible);
	}
}
