package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import utilities.views.TextPrompt;
import utilities.views.Utilities;


public class SingUpDialog extends JDialog{

	private static final long serialVersionUID = 1L;
	
	private JLabel errorMatchPassword, errorUserExist, userAdded;
	private JTextField newUser; 
	private JPasswordField newPassword, confirmNewPassword;
	private JButton doneButton;
	
	public SingUpDialog(ActionListener actionListener) {
		this.setSize(300, 350);
		this.setLayout(new GridBagLayout());
		this.setBackground(new Color(47,47,47));
		this.initComponents(actionListener);
		this.setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		newUser = new JTextField(15);
		newPassword = new JPasswordField(15);
		confirmNewPassword = new JPasswordField(15);
		errorMatchPassword = new JLabel("The password's don't match!");
		errorUserExist = new JLabel("This user is already exist!");
		userAdded = new JLabel("User added sucesfully!");
		doneButton = new JButton("Done!");
		doneButton.addActionListener(actionListener);
		doneButton.setActionCommand("done");
		
		this.setVisibilityAndSizeLabels();
		this.setFeaturesComponents();
		this.setAsTextPrompt();
		this.setBackgroundAndForeground();
		this.setPositionComponents();
	}
	
	private void setVisibilityAndSizeLabels() {
		newUser.setPreferredSize(new Dimension(90, 20));
		newPassword.setPreferredSize(new Dimension(90, 20));
		confirmNewPassword.setPreferredSize(new Dimension(90, 20));
		errorMatchPassword.setVisible(false);
		errorUserExist.setVisible(false);
		userAdded.setVisible(false);
	}
	
	private void setFeaturesComponents() {
		doneButton.setFont(new Font("Cooper Black", 0, 15));
		Utilities.setBackgroundAndForeGround(doneButton, new Color(47,47,47), Color.white);
		Utilities.setBackgroundAndForeGround(newUser, new Color(47,47,47), Color.white);
		Utilities.setBackgroundAndForeGround(newPassword, new Color(47,47,47), Color.white);
		Utilities.setBackgroundAndForeGround(confirmNewPassword, new Color(47,47,47), Color.white);
	}
	
	private void setPositionComponents() {
		Utilities.setPositionInGridBagLayoutJDialog(this, newUser, 1, 1, 1, 1, 1, 1, "NONE", 10);
		Utilities.setPositionInGridBagLayoutJDialog(this, newPassword, 1, 2, 1, 1, 1, 1, "NONE", 10);
		Utilities.setPositionInGridBagLayoutJDialog(this, confirmNewPassword, 1, 3, 1, 1, 1, 1, "NONE", 10);
		Utilities.setPositionInGridBagLayoutJDialog(this, errorMatchPassword, 1, 4, 1, 1, 1, 1, "NONE", 10);
		Utilities.setPositionInGridBagLayoutJDialog(this, errorUserExist, 1, 4, 1, 1, 1, 1, "NONE", 10);
		Utilities.setPositionInGridBagLayoutJDialog(this, userAdded, 1, 4, 1, 1, 1, 1, "NONE", 10);
		Utilities.setPositionInGridBagLayoutJDialog(this, doneButton, 1, 7, 1, 1, 1, 1, "NONE", 10);
	}
	
	private void setBackgroundAndForeground() {
		Utilities.setBackgroundAndForeGround(errorMatchPassword, new Color(47,47,47), Color.red);
		Utilities.setBackgroundAndForeGround(errorUserExist, new Color(47,47,47), Color.red);
		Utilities.setBackgroundAndForeGround(userAdded, new Color(47,47,47), Color.green);
	}
	
	private void setAsTextPrompt() {
		new TextPrompt("Password", newPassword);
		new TextPrompt("Username", newUser);
		new TextPrompt("Confirm Password", confirmNewPassword);
	}
	
	public String getNewUserName() {
		return newUser.getText();
	}
	
	public String getNewPassword() {
		return new String(newPassword.getPassword());
	}
	
	public String getConfirmNewPassword() {
		return new String(confirmNewPassword.getPassword());
	}
	
	public void modifyErrorMatchPasswordLabel(boolean isVisible) {
		errorMatchPassword.setVisible(isVisible);
	}
	
	public void modifyErrorUserExistLabel(boolean isVisible) {
		errorUserExist.setVisible(isVisible);
	}
	
	public void modifyUserAddedLabel(boolean isVisible) {
		userAdded.setVisible(isVisible);
	}
	
}
