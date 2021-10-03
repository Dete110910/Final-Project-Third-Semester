package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import utilities.views.Utilities;

public class SettingsPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JButton changeUserNameButton, changePasswordButton, changeAddressButton;
	
	public SettingsPanel(ActionListener actionListener) {
		this.setBackground(new Color(47,47,47));
		this.initComponents(actionListener);
		this.setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		changeUserNameButton = new JButton("Change username");
		changePasswordButton = new JButton("Change password");
		changeAddressButton = new JButton("Change address");
		
		this.setFeaturesComponents();
		this.setCommandsAndListeners(actionListener);
		this.addComponents();
	}
	
	private void setFeaturesComponents() {
		Utilities.setBackgroundAndForeGround(changeUserNameButton, new Color(42,42,42), Color.white);
		Utilities.setBackgroundAndForeGround(changePasswordButton, new Color(42,42,42), Color.white);
		Utilities.setBackgroundAndForeGround(changeAddressButton, new Color(42,42,42), Color.white);
		changeUserNameButton.setBorderPainted(false);
		changePasswordButton.setBorderPainted(false);
		changeAddressButton.setBorderPainted(false);
	}
	
	private void setCommandsAndListeners(ActionListener actionListener) {
		changeUserNameButton.setActionCommand("changeUserName");
		changeUserNameButton.addActionListener(actionListener);
		
		changePasswordButton.setActionCommand("changePassword");
		changePasswordButton.addActionListener(actionListener);
		
		changeAddressButton.setActionCommand("changeAddress");
		changeAddressButton.addActionListener(actionListener);
	}
	
	private void addComponents() {
		GridLayout gridLayout = new GridLayout(10,1);
		this.setLayout(gridLayout);
		this.add(changeUserNameButton);
		this.add(changePasswordButton);
		this.add(changeAddressButton);
	}
	
}
