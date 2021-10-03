package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import utilities.views.Utilities;

public class ConfirmPurchaseDialog extends JDialog{

	private static final long serialVersionUID = 1L;
	
		private JLabel confirmPurchase;
		private JButton doneButton;
		
		public ConfirmPurchaseDialog(ActionListener actionListener) {
			this.setSize(310, 200);
			this.setLayout(new GridBagLayout());
			this.setBackground(Color.black);
			this.initComponents(actionListener);
			this.setVisible(false);
		}
		
		private void initComponents(ActionListener actionListener) {
			confirmPurchase = new JLabel("Confirm your purchase before exit this menu!");
			
			doneButton = new JButton("Done");
			doneButton.setActionCommand("closeDialogConfirmPurchase");
			doneButton.addActionListener(actionListener);
			
			this.setFeaturesComponents();
			this.setPositions();
		}
		
		private void setFeaturesComponents() {
			confirmPurchase.setFont(new Font("Cooper Black", 0, 12));
			confirmPurchase.setForeground(Color.red);
			confirmPurchase.setBackground(Color.black);
			doneButton.setFont(new Font("Cooper Black", 0, 15));
		}
		
		private void setPositions() {
			Utilities.setPositionInGridBagLayoutJDialog(this, confirmPurchase, 0, 0, 1, 1, 1, 1, "NONE", 10);
			Utilities.setPositionInGridBagLayoutJDialog(this, doneButton, 0, 1, 1, 1, 1, 1, "NONE", 10);
		}
		
		public void modifyVisibilityConfirmPurchaseDialog(boolean isVisible) {
			this.setVisible(isVisible);
		}
		
		public void deleteConfirmPurchaseDialog() {
			this.dispose();
		}
	
}
