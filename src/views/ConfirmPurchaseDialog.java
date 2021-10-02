package views;

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
			this.setSize(250, 200);
			this.setLayout(new GridBagLayout());
			this.initComponents(actionListener);
			this.setVisible(false);
		}
		
		private void initComponents(ActionListener actionListener) {
			confirmPurchase = new JLabel("Confirm your purchase before exit this menu!");
			
			doneButton = new JButton("Done");
			doneButton.setActionCommand("closeDialogConfirmPurchase");
			doneButton.addActionListener(actionListener);
			
			this.setPositions();
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
