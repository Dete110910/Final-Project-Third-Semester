package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import utilities.views.Utilities;

public class SearchProductPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private SearchProductTopPanel sptp;
	private JPanel auxPanel;
	private JLabel notFoundProductLabel, foundProductInLabel;
	
	public SearchProductPanel(ActionListener actionListener) {
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(27,27,27));
		this.setSize(320, 500);
		this.initComponents(actionListener);
		this.setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		sptp = new SearchProductTopPanel(actionListener);
		
		auxPanel = new JPanel();
		
		foundProductInLabel = new JLabel();

		notFoundProductLabel = new JLabel("Product not Found!", SwingConstants.CENTER);
		
		this.setFeaturesComponents();
		
		this.add(sptp, BorderLayout.NORTH);
		this.add(auxPanel, BorderLayout.CENTER);
	}
	
	private void setFeaturesComponents() {
		notFoundProductLabel.setFont(new Font("Cooper Black", 0, 18));
		Utilities.setBackgroundAndForeGround(notFoundProductLabel, getBackground(), Color.RED);
		auxPanel.setBackground(new Color(27,27,27));
		foundProductInLabel.setForeground(Color.white);
	}

	public void addProductPanel(JPanel panel, String typeProduct) {
		auxPanel = panel;
		this.modifyVisibilityNotFoundLabel(false);
		SwingUtilities.updateComponentTreeUI(this);
		this.foundProductInLabel.setText("You can find the product in " +  typeProduct + " section");
		this.add(auxPanel, BorderLayout.CENTER);
		this.add(foundProductInLabel, BorderLayout.SOUTH);
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	public void removeProductPanel() {
		this.remove(auxPanel);
		this.remove(foundProductInLabel);
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	public void showNotFoundProductLabel() {
		this.removeProductPanel();
		SwingUtilities.updateComponentTreeUI(this);
		this.modifyVisibilityNotFoundLabel(true);
		this.add(notFoundProductLabel, BorderLayout.CENTER);
	}
	
	public void modifyVisibilityNotFoundLabel(boolean isVisible) {
		notFoundProductLabel.setVisible(isVisible);
	}
	
	public void resetTextFieldSearchProductPanel() {
		sptp.resetTextField();
	}
	
	public String getProductToSearch() {
		return sptp.getProductToSearch();
	}
	
}
