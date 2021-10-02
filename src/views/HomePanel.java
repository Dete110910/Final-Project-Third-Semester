package views;

import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import utilities.views.Utilities;

public class HomePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private ArrayList<SampleProductPanel> listOfSampleProducPanel;
	
	public HomePanel(String[][] products, ActionListener actionListener) {
		listOfSampleProducPanel = new ArrayList<SampleProductPanel>();
		this.setLayout(new GridBagLayout());
		this.setSize(310, 500);
		this.initComponents(products, actionListener);
		this.setVisible(true);
	}
	
	private void initComponents(String[][] products, ActionListener actionListener) {
		for(int i = 0; i < products.length - 2; i += 3) {
			listOfSampleProducPanel.add(new SampleProductPanel(this.copySubMatrix(products, i), actionListener));
		}
		this.addComponents();
	}
	
	private void addComponents() {
		for(int i = 0; i < listOfSampleProducPanel.size(); i++) {
			Utilities.setPositionInGridBagLayout(this,listOfSampleProducPanel.get(i), 0, i, 1, 1, 1, 1, "BOTH", 10, null);
		}
	}
	
	private String[][] copySubMatrix(String[][] mainMatrix, int valueI){
		String[][] matrixThreeProducts = new String[3][3];
		for(int i = 0; i < matrixThreeProducts.length; i++) {
			for(int j = 0; j < matrixThreeProducts.length; j++) {
				matrixThreeProducts[i][j] = mainMatrix[valueI][j];
			}
			valueI++;
		}
		return matrixThreeProducts;
	}
	
}
