package views;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import utilities.views.Utilities;

public class ContainerBillPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private JLabel noBillFound, billGuidelines;
	
	private ArrayList<BillPanel> listOfBills;
	
	public ContainerBillPanel() {
		this.setSize(316,300);
		this.setLayout(new GridBagLayout());
		this.setBackground(new Color(47,47,47));
		this.initComponents();
		this.setVisible(true);
	}
	
	private void initComponents() {
		noBillFound = new JLabel("No bill's found", SwingConstants.CENTER);
		billGuidelines = new JLabel("Product    " + "   p/u    " + " Amount    " + "   Total Value", SwingConstants.CENTER);
		listOfBills = new ArrayList<BillPanel>();
		
		this.setFeaturesComponents();
		this.addComponents();
	}
	
	public void addBillPanel(ArrayList<ArrayList<String>> productsToGenerateBill) {
		if(productsToGenerateBill != null) {
			this.modifyVisibilityNoBillFound(false);
			listOfBills.add(new BillPanel(productsToGenerateBill));
		}
		this.showBillPanels();
	}
	
	public void showBillPanels() {
		int positionPanels = 1;
		for(int i = 0; i < listOfBills.size(); i++) {
			Utilities.setPositionInGridBagLayout(this, listOfBills.get(i), 0, positionPanels++, 1, 1, 1, 1, "HORIZONTAL", 11, getInsets());
		}
	}
	
	public void modifyVisibilityNoBillFound(boolean isVisible) {
		this.noBillFound.setVisible(isVisible);
	}
	
	public void modifyVisibilityBillGuidelines(boolean isVisible) {
		this.billGuidelines.setVisible(isVisible);
	}
	
	private void setFeaturesComponents() {
		noBillFound.setForeground(Color.white);
		billGuidelines.setForeground(Color.white);
		billGuidelines.setVisible(false);
	}
	
	private void addComponents() {
		Utilities.setPositionInGridBagLayout(this, noBillFound, 0, 0, 1, 1, 1, 1, "HORIZONTAL", 11, getInsets());
		Utilities.setPositionInGridBagLayout(this, billGuidelines, 0, 0, 1, 1, 1, 0, "HORIZONTAL", 11, getInsets());
		
	}
	
}
