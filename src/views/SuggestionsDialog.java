package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextArea;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import utilities.views.TextPrompt;
import utilities.views.Utilities;

public class SuggestionsDialog extends JDialog{

	private static final long serialVersionUID = 1L;
	
	private JLabel writeSuggestionsLabel;
	private TextArea writeSuggestionsTextArea;
	private JButton doneButton;
	
	public SuggestionsDialog(ActionListener actionListener) {
		this.setSize(300, 350);
		this.setLayout(new GridBagLayout());
		this.setBackground(new Color(47,47,47));
		this.initComponents(actionListener);
		this.setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		writeSuggestionsLabel = new JLabel("Write here your suggestions for our application");
		writeSuggestionsTextArea = new TextArea(20,20);
		doneButton = new JButton("Done!");
		doneButton.addActionListener(actionListener);
		doneButton.setActionCommand("doneSuggestion");
		
		this.setFeaturesComponents();
		this.setPositions();
	}
	
	private void setFeaturesComponents() {
		Utilities.setBackgroundAndForeGround(writeSuggestionsLabel, new Color(47,47,47), Color.white);
		Utilities.setBackgroundAndForeGround(doneButton, new Color(47,47,47), Color.white);
		doneButton.setFont(new Font("Cooper Black", 0, 15));
		writeSuggestionsTextArea.setBackground(new Color(47,47,47));
	}
	
	private void setPositions() {
		Utilities.setPositionInGridBagLayoutJDialog(this, writeSuggestionsLabel, 0, 0, 1, 1, 1, 1, "NONE", 10);
		this.setPositionTextArea();
		Utilities.setPositionInGridBagLayoutJDialog(this, doneButton, 0, 2, 1, 1, 1, 1, "NONE", 10);
	}
	
	private void setPositionTextArea() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy = 2;
		gbc.weighty = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(writeSuggestionsTextArea, gbc);
	}
}
