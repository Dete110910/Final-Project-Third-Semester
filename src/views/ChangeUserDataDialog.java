package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import utilities.views.TextPrompt;
import utilities.views.Utilities;

public class ChangeUserDataDialog extends JDialog{
	
	private static final long serialVersionUID = 1L;

	private JLabel errorMatchDataLabel, errorUserExistLabel, changeMadeSucesfullyLabel;
	private JTextField newData, confirmNewData;
	private JButton doneButton;
	
	public ChangeUserDataDialog(String newDataMessage, String confirmNewDataMessage, String typeData, ActionListener actionListener) {
		this.setSize(316, 300);
		this.setBackground(new Color(47,47,47));
		this.initComponents(newDataMessage, confirmNewDataMessage, typeData, actionListener);
		this.setVisible(true);
	}
	
	private void initComponents(String newDataMessage, String confirmNewDataMessage, String typeData, ActionListener actionListener) {
		newData = new JTextField(15);
		confirmNewData = new JTextField(15);
		doneButton = new JButton("Done!");
		
		errorMatchDataLabel = new JLabel("The data doesn't match!");
		errorUserExistLabel = new JLabel("The user already exist!");
		changeMadeSucesfullyLabel = new JLabel("The changes were made sucesfully");
		
		this.setFeaturesComponents(newDataMessage, confirmNewDataMessage);
		this.setCommandsAndListeners(typeData, actionListener);
		this.addComponents();
	}
	
	private void setFeaturesComponents(String newDataMessage, String confirmNewDataMessage) {
		new TextPrompt(newDataMessage, newData);
		new TextPrompt(confirmNewDataMessage, confirmNewData);
		doneButton.setFont(new Font("Cooper Black", 0, 15));
		Utilities.setBackgroundAndForeGround(errorMatchDataLabel, new Color(47,47,47), Color.red);
		Utilities.setBackgroundAndForeGround(errorUserExistLabel, new Color(47,47,47), Color.red);
		Utilities.setBackgroundAndForeGround(changeMadeSucesfullyLabel, new Color(47,47,47), Color.green);
		errorMatchDataLabel.setVisible(false);
		errorUserExistLabel.setVisible(false);
		changeMadeSucesfullyLabel.setVisible(false);
	}
	
	private void setCommandsAndListeners(String typeData, ActionListener actionListener) {
		doneButton.setActionCommand(typeData);
		doneButton.addActionListener(actionListener);
	}
	
	private void addComponents() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		this.setLayout(gridBagLayout);
		Utilities.setPositionInGridBagLayoutJDialog(this, newData, 1, 1, 1, 1, 1, 1, "NONE", 10);
		Utilities.setPositionInGridBagLayoutJDialog(this, confirmNewData, 1, 2, 1, 1, 1, 1, "NONE", 10);
		Utilities.setPositionInGridBagLayoutJDialog(this, errorMatchDataLabel, 1, 3, 1, 1, 1, 1, "NONE", 10);
		Utilities.setPositionInGridBagLayoutJDialog(this, errorUserExistLabel, 1, 3, 1, 1, 1, 1, "NONE", 10);
		Utilities.setPositionInGridBagLayoutJDialog(this, changeMadeSucesfullyLabel, 1, 3, 1, 1, 1, 1, "NONE", 10);
		Utilities.setPositionInGridBagLayoutJDialog(this, doneButton, 1, 4, 1, 1, 1, 1, "NONE", 10);
	}
	
	public void modifyErrorMatchDataLabel(boolean isVisible) {
		errorMatchDataLabel.setVisible(isVisible);
	}
	
	public void modifyErrorUserExistLabel(boolean isVisible) {
		errorUserExistLabel.setVisible(isVisible);
	}
	
	public void modifyUserAddedLabel(boolean isVisible) {
		changeMadeSucesfullyLabel.setVisible(isVisible);
	}
	
	public String getNewDataText() {
		return newData.getText();
	}
	
	public String getConfirmNewDataText() {
		return confirmNewData.getText();
	}
	
	public void closeDialog() {
		this.dispose();
	}
	
}
