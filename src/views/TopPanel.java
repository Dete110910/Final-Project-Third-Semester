package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import utilities.views.Utilities;

public class TopPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JLabel message, secondMessage;
	
	
	public TopPanel(String message, String secondMessage) {
		this.setPreferredSize(new Dimension(300, 35));
		this.setLayout(new GridBagLayout());
		this.setBackground(new Color(27,27,27));
		this.initComponents(message, secondMessage);
		this.setVisible(true);
	}
	
	
	private void initComponents(String message, String secondMessage) {
		this.message = new JLabel(message);
		this.secondMessage = new JLabel(secondMessage);
		
		this.setFeaturesComponents();
		this.addComponents();
	}
	
	public void setMessages(String firtsMessage, String secondMessage) {
		this.message.setText(firtsMessage);
		this.secondMessage.setText(secondMessage);
	}
	
	private void addComponents() {
		Utilities.setPositionInGridBagLayout(this, message, 0, 0, 1, 1, 1, 1, "NONE", 17, getInsets());
		Utilities.setPositionInGridBagLayout(this, secondMessage, 1, 0, 1, 1, 0, 1, "NONE", 17, getInsets());
		
	}
	private void setFeaturesComponents() {
		this.message.setFont(new Font("Cooper Black", 0, 18));
		this.secondMessage.setFont(new Font("Cooper Black", 0, 15));
		Utilities.setBackgroundAndForeGround(message, getBackground(), Color.white);
		Utilities.setBackgroundAndForeGround(secondMessage, getBackground(), Color.white);
	}
	
}
