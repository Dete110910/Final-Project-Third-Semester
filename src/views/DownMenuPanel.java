package views;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import utilities.views.Utilities;

public class DownMenuPanel extends JPanel{

	private JButton homeButton, searchButton, billButton, profileButton;
	
	public DownMenuPanel(ActionListener actionListener) {
		this.setSize(310, 70);
		this.setBackground(new Color(20,20,20));
		this.setLayout(new GridBagLayout());
		this.initComponents(actionListener);
		this.setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		homeButton = new JButton();
		homeButton.addActionListener(actionListener);
		homeButton.setActionCommand("homeButton");
		
		
		searchButton = new JButton();
		searchButton.addActionListener(actionListener);
		searchButton.setActionCommand("searchButton");
		
		billButton = new JButton();
		billButton.addActionListener(actionListener);
		billButton.setActionCommand("billButton");
		
		profileButton = new JButton();
		profileButton.addActionListener(actionListener);
		profileButton.setActionCommand("profileButton");
		
		this.setImages();
		this.setPositions();
	}
	
	
	private void setImages() {
		this.setImageButton("data/icons/homeIconOn.png", homeButton);
		this.setImageButton("data/icons/searchIconOff.png", searchButton);
		this.setImageButton("data/icons/billsIconOff.png", billButton);
		this.setImageButton("data/icons/profileIconOff.png", profileButton);
	}
	
	private void setPositions() {
		Utilities.setPositionInGridBagLayout(this, homeButton, 0, 0, 1, 1, 1, 1, "BOTH", 10, null);
		Utilities.setPositionInGridBagLayout(this, searchButton, 1, 0, 1, 1, 1, 1, "BOTH", 10, null);
		Utilities.setPositionInGridBagLayout(this, billButton, 2, 0, 1, 1, 1, 1, "BOTH", 10, null);
		Utilities.setPositionInGridBagLayout(this, profileButton, 3, 0, 1, 1, 1, 1, "BOTH", 10, null);
	}
	
	
	private void setImageButton(String image, JButton button) {
		ImageIcon ic = new ImageIcon(image);
		button.setIcon(new ImageIcon(ic.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH)));
		button.setBorderPainted(false);
		Utilities.setBackgroundAndForeGround(button, new Color(20,20,20), Color.BLACK);
	}
	
	public void updateImageButton(String image, String button) {
		switch(button) {
			case "home":
				this.setImageButton(image, homeButton);
			break;	
			case "search":
				this.setImageButton(image, searchButton);
				break;	
			case "bill":
				this.setImageButton(image, billButton);
				break;	
			case "profile":
				this.setImageButton(image, profileButton);
				break;	
		}
	}
	
	
}
