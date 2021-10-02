package views;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utilities.views.TextPrompt;
import utilities.views.Utilities;

public class SearchProductTopPanel extends JPanel{

	
	private static final long serialVersionUID = 1L;
	
	private JTextField searchTextField;
	private JButton buttonSearch;
	
	public SearchProductTopPanel(ActionListener actionListener) {
		this.setBorder(BorderFactory.createLineBorder(Color.gray));
		this.setBackground(new Color(47,47,47));
		this.initComponents(actionListener);
		this.setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		searchTextField = new JTextField(20);
		
		buttonSearch = new JButton();
		buttonSearch.setActionCommand("searchProduct");
		buttonSearch.addActionListener(actionListener);
		
		this.setFeaturesComponents();
		this.addComponents();
	}
	
	private void setFeaturesComponents() {
		new TextPrompt("Search product...", searchTextField);
		Utilities.setImageButton("data/icons/searchIcon.png", buttonSearch, 20, 20);
	}
	
	private void addComponents() {
		this.add(searchTextField);
		this.add(buttonSearch);
	}
	
	public String getProductToSearch() {
		return searchTextField.getText();
	}
	
	public void resetTextField() {
		searchTextField.setText("");
	}
}
