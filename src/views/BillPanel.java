package views;

import java.awt.GridBagLayout;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utilities.views.Utilities;

public class BillPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<JLabel> listOfProducts;
	private JLabel totalValueLabel;
	
	public BillPanel(ArrayList<ArrayList<String>> productsToGenerateBill) {
		this.setSize(316, 300);
		this.setLayout(new GridBagLayout());
		this.setBorder(BorderFactory.createTitledBorder("Date: " + LocalDate.now()));
		this.initComponents(productsToGenerateBill);
		this.setVisible(true);
	}
	
	private void initComponents(ArrayList<ArrayList<String>> productsToGenerateBill) {
		double totalValue = 0;
		listOfProducts = new ArrayList<JLabel>();
		totalValueLabel = new JLabel();
		
		this.addPanels(productsToGenerateBill, totalValue);
	}
	
	private void addPanels(ArrayList<ArrayList<String>> productsToGenerateBill, double totalValue) {
		for(int i = 0; i < productsToGenerateBill.size(); i++) {
			double valueTotalProduct = this.valueTotalProduct(productsToGenerateBill.get(i).get(2), productsToGenerateBill.get(i).get(1));
			totalValue += valueTotalProduct;
			listOfProducts.add(new JLabel("     " + productsToGenerateBill.get(i).get(0) + "   " + "   " + productsToGenerateBill.get(i).get(1) + "   " + productsToGenerateBill.get(i).get(2) + "            " + valueTotalProduct));
			Utilities.setPositionInGridBagLayout(this, listOfProducts.get(i), 0, i, 1, 1, 1, 1, "HORIZONTAL", 10, getInsets());
		}
		
		totalValueLabel.setText("$ " + String.valueOf(totalValue));
		Utilities.setPositionInGridBagLayout(this, totalValueLabel, 0, productsToGenerateBill.size(), 1, 1, 1, 1, "NONE", 13, getInsets());
	}
	
	private double valueTotalProduct(String amount, String value) {
		double doubleValue = Double.parseDouble(value.substring(1, value.length()));
		double doubleAmount = Double.parseDouble(amount);
		return doubleValue * doubleAmount;
	}
	
}
