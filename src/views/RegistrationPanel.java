package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import utilities.views.TextPrompt;
import utilities.views.Utilities;

public class RegistrationPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JTextField username;
	private JPasswordField password;
	private JLabel errorLabel;
	private JButton sendButton, singUpButton;
	
	public RegistrationPanel(ActionListener actionListener) {
		this.setSize(310, 550);
		this.setBackground(new Color(19,19,19));
		this.setLayout(new GridBagLayout());
		this.initComponents(actionListener);
		this.setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		username = new JTextField();
		password = new JPasswordField();
		sendButton = new JButton("Send");
		singUpButton = new JButton("Sing Up");
		errorLabel = new JLabel("Username Or Password Incorrect!");
		
		this.setCommands();
		this.setPreferedSizeComponents();
		this.setListenerComponents(actionListener);
		this.setFeaturesComponents();
		this.setBackgroundAndForeground();
		this.setPositions();
	}
	
	public String getUsername() {
		return username.getText();
	}
	
	public String getPassword() {
		return new String(password.getPassword());
	}
	
	public void modifyVisibilityErrorLabel(boolean isVisible) {
		errorLabel.setVisible(isVisible);
	}
	
	private void setCommands() {
		sendButton.setActionCommand("send");
		singUpButton.setActionCommand("singUp");
	}
	
	private void setPreferedSizeComponents() {
		username.setPreferredSize(new Dimension(100, 25));
		password.setPreferredSize(new Dimension(100, 25));
	}
	
	private void setListenerComponents(ActionListener actionListener) {
		sendButton.addActionListener(actionListener);
		singUpButton.addActionListener(actionListener);
	}
	
	private void setFeaturesComponents() {
		new TextPrompt("Username", username);
		new TextPrompt("Password", password);
		singUpButton.setBorderPainted(false);
		sendButton.setFont(new Font("Arial Rounded MT Bold", 0, 12));
		singUpButton.setFont(new Font("Forte", 0, 12));
		errorLabel.setVisible(false);
	}
	
	private void setPositions() {
		Utilities.setPositionInGridBagLayout(this, username, 1, 1, 1, 1, 1, 1, "NONE", 10, getInsets());
		Utilities.setPositionInGridBagLayout(this, password, 1, 3, 1, 1, 1, 1, "NONE", 10, getInsets());
		Utilities.setPositionInGridBagLayout(this, errorLabel, 1, 4, 1, 1, 1, 1, "NONE", 10, getInsets());
		Utilities.setPositionInGridBagLayout(this, sendButton, 1, 5, 1, 1, 1, 1, "NONE", 10, getInsets());
		Utilities.setPositionInGridBagLayout(this, singUpButton, 1, 6, 1, 1, 1, 1, "NONE", 10, getInsets());
	}
	
	private void setBackgroundAndForeground() {
		Utilities.setBackgroundAndForeGround(sendButton, new Color(19,19,19), Color.WHITE);
		Utilities.setBackgroundAndForeGround(singUpButton, new Color(19,19,19), Color.WHITE);
		Utilities.setBackgroundAndForeGround(errorLabel, new Color(19,19,19), Color.RED);
	}
}
