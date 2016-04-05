package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * @author sahil
 * This class describes a row corresponding to a single
 * attribute mentioned in the CTPR specifications article.
 * Each row has a descripton and a set of 5 ratings options.
 */
@SuppressWarnings("serial")
public class CTPRAttributeRow extends JPanel
{
	private JLabel infoLabel;
	
	private JRadioButton rating1;
	private JRadioButton rating2;
	private JRadioButton rating3;
	private JRadioButton rating4;
	private JRadioButton rating5;
	
	private ButtonGroup ratingGroup;
	
	private double rating = 0;
	
	public ActionListener updateRating = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			rating = Double.parseDouble(e.getActionCommand());
		}
	};
	
	/******************************  ******************************/
	
	/**
	 * constructor
	 */
	public CTPRAttributeRow(String labelText) {
		 this.setLayout(new GridLayout(1, 2)); {
			 
			 // Label panel
			 JPanel labelPanel = new JPanel();
			 labelPanel.setLayout(new GridLayout(1, 1)); {
				 infoLabel = new JLabel(labelText);
				 this.add(infoLabel);
			 }
			 this.add(labelPanel);
			 
			 // Radio button Panel
			 JPanel radioPanel = new JPanel();
			 radioPanel.setLayout(new GridLayout(1, 5)); {
				 // Set radio buttons
				 rating1 = new JRadioButton("1");
				 rating1.setActionCommand("1");
				 rating1.addActionListener(updateRating);
				 radioPanel.add(rating1);
				 
				 rating2 = new JRadioButton("2");
				 rating2.setActionCommand("2");
				 rating2.addActionListener(updateRating);
				 radioPanel.add(rating2);

				 rating3 = new JRadioButton("3");
				 rating3.setActionCommand("3");
				 rating3.addActionListener(updateRating);
				 radioPanel.add(rating3);
				 
				 rating4 = new JRadioButton("4");
				 rating4.setActionCommand("4");
				 rating4.addActionListener(updateRating);
				 radioPanel.add(rating4);
				 
				 rating5 = new JRadioButton("5");
				 rating5.setActionCommand("5");
				 rating5.addActionListener(updateRating);
				 radioPanel.add(rating5);
			 }
			 this.add(radioPanel);
			 
			 ratingGroup = new ButtonGroup();
			 ratingGroup.add(rating1);
			 ratingGroup.add(rating2);
			 ratingGroup.add(rating3);
			 ratingGroup.add(rating4);
			 ratingGroup.add(rating5);
		 }
	}
	
	/******************************  ******************************/
	
	/**
	 * @description clears any selection of buttons and resets the
	 * row to a clean state.
	 */
	public void clearRow() {
		ratingGroup.clearSelection();
	}
	
	/******************************  ******************************/
	
	/**
	 * @description getters
	 */
	public double getRating() { return this.rating; }
	
	/******************************  ******************************/
	
	/**
	 * @description setters
	 */
	public void setRating(double d) { this.rating = d; }
}
