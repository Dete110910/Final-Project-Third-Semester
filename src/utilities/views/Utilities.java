package utilities.views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Utilities {
	
	
	public static void setBackgroundAndForeGround(JComponent component, Color background, Color foreGround) {
		component.setBackground(background);
		component.setForeground(foreGround);
		
	}
	
	public static void setPositionInGridBagLayout(JPanel panel, JComponent component, int x, int y, int width, int height, int weightx, int weighty, String fill, int anchor, Insets insets) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height; 
		gbc.weightx = weightx;
		gbc.weighty= weighty;
		gbc.anchor = anchor;
		gbc.ipadx = 1;
		gbc.ipady = 1;
		
		
		switch(fill) {
		case "HORIZONTAL":
			gbc.fill = GridBagConstraints.HORIZONTAL;
			break;
		case "VERTICAL": 
			gbc.fill = GridBagConstraints.VERTICAL;
			break;
		case "BOTH":
			gbc.fill = GridBagConstraints.BOTH;
			break;
		case "RELATIVE":
			gbc.fill = GridBagConstraints.RELATIVE;
			break;
		default:
			gbc.fill = GridBagConstraints.NONE;
		}
		
		if(insets != null) {
			gbc.insets = insets;
			panel.add(component, gbc);			
		}
		else {
			panel.add(component, gbc);
			
		}
	}
	
	
	public static void setPositionInGridBagLayoutJDialog(JDialog dialog, JComponent component, int x, int y, int width, int height, int weightx, int weighty, String fill, int anchor ) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height; 
		gbc.weightx = weightx;
		gbc.weighty= weighty;
		gbc.anchor = anchor;
		gbc.ipadx = 1;
		gbc.ipady = 1;
		
		
		switch(fill) {
		case "HORIZONTAL":
			gbc.fill = GridBagConstraints.HORIZONTAL;
			break;
		case "VERTICAL": 
			gbc.fill = GridBagConstraints.VERTICAL;
			break;
		case "BOTH":
			gbc.fill = GridBagConstraints.BOTH;
			break;
		case "RELATIVE":
			gbc.fill = GridBagConstraints.RELATIVE;
			break;
		default:
			gbc.fill = GridBagConstraints.NONE;
		}
		
		dialog.add(component, gbc);
	}
	
	public static void setImageLabel(String image, JLabel label, int width, int height) {
		ImageIcon ic = new ImageIcon(image);
		label.setIcon(new ImageIcon(ic.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
		Utilities.setBackgroundAndForeGround(label, Color.BLACK, Color.WHITE);
	}
	
	public static void setImageButton(String image, JButton button, int width, int height) {
		ImageIcon ic = new ImageIcon(image);
		button.setIcon(new ImageIcon(ic.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
		Utilities.setBackgroundAndForeGround(button, Color.BLACK, Color.WHITE);
	}
}
