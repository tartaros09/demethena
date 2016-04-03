package gui;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import util.GUIComponentFactory;

/**
 * @author sahil
 * This class describes the primary GUI used for the project.
 * The GUI contains various textfields for data entry of scores
 * and then calculates the averages over each category.
 */
public class MainGUI
{
	public JFrame mainFrame;
		
	/******************************  ******************************/
	
	/**
	 * constructor
	 */
	public MainGUI() {
		mainFrame = new JFrame("CTPR Score Tracker"); {
			JPanel wrapper = new JPanel();
			wrapper.setBorder(GUIComponentFactory.insideLineBorder);
			wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS)); {
				
				// Style attributes
				JPanel stylePanel = new JPanel();
				stylePanel.setBorder(GUIComponentFactory.insideLineBorder);
				stylePanel.setLayout(new GridLayout(3, 1)); {
					
				}
				wrapper.add(stylePanel);
				
				// Content attributes
				JPanel contentPanel = new JPanel();
				contentPanel.setBorder(GUIComponentFactory.insideLineBorder);
				contentPanel.setLayout(new GridLayout(3, 1)); {
					
				}
				wrapper.add(contentPanel);
				
				// Originality attributes
				JPanel originalityPanel = new JPanel();
				originalityPanel.setBorder(GUIComponentFactory.insideLineBorder);
				originalityPanel.setLayout(new GridLayout(3, 1)); {
					
				}
				wrapper.add(originalityPanel);
				
				// Reach attributes
				JPanel reachPanel = new JPanel();
				reachPanel.setBorder(GUIComponentFactory.insideLineBorder);
				reachPanel.setLayout(new GridLayout(2, 1)); {
					
				}
				wrapper.add(reachPanel);
				
				// Engagement attributes
				JPanel engagementPanel = new JPanel();
				engagementPanel.setBorder(GUIComponentFactory.insideLineBorder);
				engagementPanel.setLayout(new GridLayout(2, 1)); {
					
				}
				wrapper.add(engagementPanel);
			}
			mainFrame.add(wrapper);
		}
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}
	
	/******************************  ******************************/
	
	/**
	 * @description main function for local testing.
	 */
	public static void main(String[] args) {
		MainGUI gui = new MainGUI();
	}
}
