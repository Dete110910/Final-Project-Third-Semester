package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import utilities.views.Utilities;

public class ProfilePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JButton settingsButton, suggestionsButton, helpButton, exitButton;
	
	public ProfilePanel(ActionListener actionListener) {
		this.setSize(316,500);
		this.setLayout(new GridLayout(10,1));
		this.setBackground(new Color(47,47,47));
		this.initComponents(actionListener);
		this.setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		settingsButton = new JButton("Settings");
		suggestionsButton = new JButton("Suggestions");
		helpButton = new JButton("Help");
		exitButton = new JButton("Exit");
		
		this.setFeaturesComponents();
		this.setCommandsAndListeners(actionListener);
		this.addComponents();
	}
	
	private void setFeaturesComponents() {
		Utilities.setBackgroundAndForeGround(settingsButton, new Color(42,42,42), Color.white);
		Utilities.setBackgroundAndForeGround(suggestionsButton, new Color(42,42,42), Color.white);
		Utilities.setBackgroundAndForeGround(helpButton, new Color(42,42,42), Color.white);
		Utilities.setBackgroundAndForeGround(exitButton, getBackground(), Color.white);
		settingsButton.setBorderPainted(false);
		suggestionsButton.setBorderPainted(false);
		helpButton.setBorderPainted(false);
		exitButton.setBorderPainted(false);
	}
	
	private void setCommandsAndListeners(ActionListener actionListener) {
		settingsButton.setActionCommand("settings");
		settingsButton.addActionListener(actionListener);
		
		suggestionsButton.setActionCommand("suggestions");
		suggestionsButton.addActionListener(actionListener);
		
		helpButton.setActionCommand("help");
		helpButton.addActionListener(actionListener);
		
		exitButton.setActionCommand("exit");
		exitButton.addActionListener(actionListener);
	}
	
	private void addComponents() {
		this.add(settingsButton);
		this.add(suggestionsButton);
		this.add(helpButton);
		this.add(exitButton);
	}
	
}
