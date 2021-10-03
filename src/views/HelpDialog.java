package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextArea;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import utilities.views.Utilities;

public class HelpDialog extends JDialog{

	private static final long serialVersionUID = 1L;
	
	private JButton doneButton;
	private TextArea helpTextArea;
	
	public HelpDialog(ActionListener actionListener) {
		this.setSize(310, 300);
		this.setLayout(new GridBagLayout());
		this.initComponents(actionListener);
		this.setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		doneButton = new JButton("Done!");
		helpTextArea = new TextArea("This is an application developed by Daniel Sánchez to finish his third semester at university. "
				+ "This is the first version of it, but if he's interested in contributing to it, he can head over to his Github profile:"
				+ " https://github.com/Dete110910", 15, 35, TextArea.SCROLLBARS_VERTICAL_ONLY);
		
		doneButton.addActionListener(actionListener);
		doneButton.setActionCommand("doneHelpButton");
		this.setFeaturesComponents();
		this.addComponents();
	}
	
	private void setFeaturesComponents(){
		helpTextArea.setFont(new Font("Cooper Black", 0, 10));
		helpTextArea.setEditable(false);
		Utilities.setBackgroundAndForeGround(doneButton, getBackground(), Color.black);
		doneButton.setFont(new Font("Cooper Black", 0, 15));
	}
	
	private void addComponents() {
		this.setPositionTextArea();
		Utilities.setPositionInGridBagLayoutJDialog(this, doneButton, 0, 3, 1, 1, 1, 1, "NONE", 10);
	}
	private void setPositionTextArea() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy = 1;
		gbc.weighty = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(helpTextArea, gbc);
	}
	
	public void closeDialog() {
		this.dispose();
	}
	
}
