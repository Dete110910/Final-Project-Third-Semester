package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import utilities.views.Utilities;

public class SampleProductPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JButton typeProductButton;
	private ProductPanel firstProduct;
	private ProductPanel secondProduct;
	private ProductPanel thirdProduct;
	
	public SampleProductPanel(String[][] products, ActionListener actionListener) {
		this.setSize(300, 50);
		this.setLayout(new GridBagLayout());
		this.setBackground(new Color(27,27,27));
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		this.initComponents(products, actionListener);
		this.setVisible(true);
	}
	 
	private void initComponents(String[][] products, ActionListener actionListener) {
		typeProductButton = new JButton(products[0][0]);
		typeProductButton.setBorderPainted(false);
		typeProductButton.setActionCommand(products[0][0]);
		typeProductButton.addActionListener(actionListener);
		
		
		firstProduct = new ProductPanel(products[0][0], products[0][1], Double.parseDouble(products[0][2]), actionListener);
		secondProduct = new ProductPanel(products[1][0], products[1][1], Double.parseDouble(products[1][2]), actionListener);
		thirdProduct = new ProductPanel(products[2][0], products[2][1], Double.parseDouble(products[2][2]), actionListener);
		
		this.setFeatureOfComponents();
		this.modifyVisibilityComponents();
		this.addComponents();
	}
	
	private void setFeatureOfComponents() {
		Utilities.setBackgroundAndForeGround(typeProductButton, new Color(27,27,27), new Color(195,66,70));
		typeProductButton.setFont(new Font("Cooper Black", 0, 14));
		
	}
	
	private void modifyVisibilityComponents() {
		firstProduct.modifyVisibilityOfComboBox(false);
		secondProduct.modifyVisibilityOfComboBox(false);
		thirdProduct.modifyVisibilityOfComboBox(false);
	}
	
	private void addComponents() {
		Utilities.setPositionInGridBagLayout(this, typeProductButton, 0, 0, 1, 1, 1, 1, "NONE", 17, null);
		Utilities.setPositionInGridBagLayout(this, firstProduct, 0, 1, 1, 1, 1, 1, "HORIZONTAL", 10, null);
		Utilities.setPositionInGridBagLayout(this, secondProduct, 0, 2, 1, 1, 1, 1, "HORIZONTAL", 10, null);
		Utilities.setPositionInGridBagLayout(this, thirdProduct, 0, 3, 1, 1, 1, 1, "HORIZONTAL", 10, null);
	}
	
}
