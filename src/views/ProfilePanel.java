package views;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import utilities.views.Utilities;

public class ProfilePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JButton settingsButton, suggestionsButton, helpButton;
	
	public ProfilePanel(ActionListener actionListener) {
		this.setSize(316,500);
		this.setLayout(new GridBagLayout());
		this.setBackground(new Color(47,47,47));
		this.initComponents(actionListener);
		this.setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		settingsButton = new JButton("Settings");
		suggestionsButton = new JButton("Suggestions");
		helpButton = new JButton("Help");
		
		this.setFeaturesComponents();
		this.setCommands(actionListener);
		this.addComponents();
	}
	
	private void setFeaturesComponents() {
		Utilities.setBackgroundAndForeGround(settingsButton, new Color(47,47,47), Color.white);
		Utilities.setBackgroundAndForeGround(suggestionsButton, new Color(47,47,47), Color.white);
		Utilities.setBackgroundAndForeGround(helpButton, new Color(47,47,47), Color.white);
	}
	
	private void setCommands(ActionListener actionListener) {
		settingsButton.setActionCommand("settings");
		settingsButton.addActionListener(actionListener);
		
		suggestionsButton.setActionCommand("suggestions");
		suggestionsButton.addActionListener(actionListener);
		
		helpButton.setActionCommand("help");
		helpButton.addActionListener(actionListener);
	}
	
	private void addComponents() {
		Utilities.setPositionInGridBagLayout(this, settingsButton, 0, 0, 1, 1, 1, 0, "HORIZONTAL", 18, getInsets());
		Utilities.setPositionInGridBagLayout(this, suggestionsButton, 0, 1, 1, 1, 1, 0, "HORIZONTAL", 18, getInsets());
		Utilities.setPositionInGridBagLayout(this, helpButton, 0, 2, 1, 1, 1, 0, "HORIZONTAL", 18, getInsets());
	}
	
}
