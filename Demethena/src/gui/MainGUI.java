package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	
	private JTextField styleScoreDisplayField;
	private JTextField contentScoreDisplayField;
	private JTextField originalityScoreDisplayField;
	private JTextField reachScoreDisplayField;
	private JTextField engagementScoreDisplayField;
	private JTextField globalScoreDisplayField;
	
	private JButton calculateButton;
	private JButton saveResultsButton;
	
	// Style rows
	private CTPRAttributeRow structureRow;
	private CTPRAttributeRow writingFlowRow;
	private CTPRAttributeRow languageRow;
	
	//Content rows
	private CTPRAttributeRow relevanceRow;
	private CTPRAttributeRow researchRow;
	private CTPRAttributeRow lngRow;
	
	// Originality rows
	private CTPRAttributeRow differenceRow;
	private CTPRAttributeRow creativityRow;
	private CTPRAttributeRow whyMeRow;
	
	// Reach rows
	private CTPRAttributeRow audienceRow;
	private CTPRAttributeRow qualityRow;
	
	// Engagement rows
	private CTPRAttributeRow mediaRow;
	private CTPRAttributeRow actionRow;
	
	private double styleScore;
	private double contentScore;
	private double originalityScore;
	private double reachScore;
	private double engagementScore;
	private double globalScore;
	
	/******************************  ******************************/
	
	/**
	 * constructor
	 */
	public MainGUI() {
		mainFrame = new JFrame("CTPR Score Tracker"); {
			
			JPanel wrapper = new JPanel();
			wrapper.setBorder(GUIComponentFactory.insideLineBorder);
			wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS)); {
				
				// Scoring panel
				JPanel inputPanel = buildInputPanel();
				wrapper.add(inputPanel);
				
				// Button Panel
				JPanel buttonPanel = buildButtonPanel();
				wrapper.add(buttonPanel);
				
				// Results display panel
				JPanel outputPanel = buildOutputPanel();
				wrapper.add(outputPanel);
			}
			mainFrame.add(wrapper);
		}
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setJMenuBar(buildMenuBar());
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}
	
	/******************************  ******************************/
	
	/**
	 * @description build the layout for the input panel.
	 * this function creates, initialises and add all the requisite
	 * elements to the input panels and returns it.
	 */
	private JPanel buildInputPanel() {
		JPanel ans = new JPanel();
		ans.setBorder(GUIComponentFactory.emptyBorder);
		ans.setLayout(new BoxLayout(ans, BoxLayout.Y_AXIS)); {
			
			// Style attributes
			JPanel stylePanel = new JPanel();
			stylePanel.setBorder(GUIComponentFactory.borderForStyle);
			stylePanel.setLayout(new GridLayout(3, 1)); {
				
				// Structure
				structureRow = new CTPRAttributeRow("Structure");
				stylePanel.add(structureRow);
				
				// Flow of writing
				writingFlowRow = new CTPRAttributeRow("Flow of writing");
				stylePanel.add(writingFlowRow);
				
				// Language
				languageRow = new CTPRAttributeRow("Language");
				stylePanel.add(languageRow);
			}
			ans.add(stylePanel);
			
			// Content attributes
			JPanel contentPanel = new JPanel();
			contentPanel.setBorder(GUIComponentFactory.borderForContent);
			contentPanel.setLayout(new GridLayout(3, 1)); {
				
				// Relevance
				relevanceRow = new CTPRAttributeRow("Relevance");
				contentPanel.add(relevanceRow);
				
				// Research
				researchRow = new CTPRAttributeRow("Research");
				contentPanel.add(researchRow);
				
				// Lede and Nut-Graf
				lngRow = new CTPRAttributeRow("Lede & Nut-Graf");
				contentPanel.add(lngRow);
			}
			ans.add(contentPanel);
			
			// Originality attributes
			JPanel originalityPanel = new JPanel();
			originalityPanel.setBorder(GUIComponentFactory.borderForOriginality);
			originalityPanel.setLayout(new GridLayout(3, 1)); {
				
				// Making a difference
				differenceRow = new CTPRAttributeRow("Making a difference");
				originalityPanel.add(differenceRow);
				
				// Creativity
				creativityRow = new CTPRAttributeRow("Creativity");
				originalityPanel.add(creativityRow);
				
				// Why me
				whyMeRow = new CTPRAttributeRow("Why me?");
				originalityPanel.add(whyMeRow);
			}
			ans.add(originalityPanel);
			
			// Reach attributes
			JPanel reachPanel = new JPanel();
			reachPanel.setBorder(GUIComponentFactory.borderForReach);
			reachPanel.setLayout(new GridLayout(2, 1)); {
				
				// Target audience
				audienceRow = new CTPRAttributeRow("Target Audience");
				reachPanel.add(audienceRow);
				
				// Quality of publication
				qualityRow = new CTPRAttributeRow("Quality of Publication");
				reachPanel.add(qualityRow);
			}
			ans.add(reachPanel);
			
			// Engagement attributes
			JPanel engagementPanel = new JPanel();
			engagementPanel.setBorder(GUIComponentFactory.borderForEngagement);
			engagementPanel.setLayout(new GridLayout(2, 1)); {
				
				// Use of media
				mediaRow = new CTPRAttributeRow("Use of Media");
				engagementPanel.add(mediaRow);
				
				// Call for action
				actionRow = new CTPRAttributeRow("Call for Action");
				engagementPanel.add(actionRow);
			}
			ans.add(engagementPanel);
		}
		return ans;
	}
	
	/******************************  ******************************/
	
	/**
	 * @description build the layout for the button panel.
	 * this function creates, initialises and add all the requisite
	 * elements to the button panels and returns it.
	 */
	private JPanel buildButtonPanel() {
		JPanel ans = new JPanel();
		ans.setLayout(new GridLayout(1, 2)); {
			calculateButton = new JButton("Calculate Scores");
			calculateButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					styleScore = (structureRow.getRating() + writingFlowRow.getRating() + languageRow.getRating())/3;
					styleScoreDisplayField.setText(String.valueOf(styleScore));
					
					contentScore = (relevanceRow.getRating() + researchRow.getRating() + lngRow.getRating())/3;
					contentScoreDisplayField.setText(String.valueOf(contentScore));
					
					originalityScore = (differenceRow.getRating() + creativityRow.getRating() + whyMeRow.getRating())/3;
					originalityScoreDisplayField.setText(String.valueOf(originalityScore));
					
					reachScore = (audienceRow.getRating() + qualityRow.getRating())/2;
					reachScoreDisplayField.setText(String.valueOf(reachScore));
					
					engagementScore = (mediaRow.getRating() + actionRow.getRating())/2;
					engagementScoreDisplayField.setText(String.valueOf(engagementScore));
					
					globalScore = (structureRow.getRating() + writingFlowRow.getRating() + languageRow.getRating() +
							relevanceRow.getRating() + researchRow.getRating() + lngRow.getRating() +
							differenceRow.getRating() + creativityRow.getRating() + whyMeRow.getRating() +
							audienceRow.getRating() + qualityRow.getRating() +
							mediaRow.getRating() + actionRow.getRating())/13;
					globalScoreDisplayField.setText(String.valueOf(globalScore));
				}
			});
			ans.add(calculateButton);
			
			saveResultsButton = new JButton("Save Results");
			saveResultsButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			ans.add(saveResultsButton);
		}
		return ans;
	}
	
	/******************************  ******************************/
	
	/**
	 * @description build the layout for the output panel.
	 * this function creates, initialises and add all the requisite
	 * elements to the output panels and returns it.
	 */
	private JPanel buildOutputPanel() {
		JPanel ans = new JPanel();
		ans.setBorder(GUIComponentFactory.emptyBorder);
		ans.setLayout(new BoxLayout(ans, BoxLayout.Y_AXIS)); {
			JPanel attributeAveragePanel = new JPanel();
			attributeAveragePanel.setBorder(GUIComponentFactory.emptyBorder);
			attributeAveragePanel.setLayout(new GridLayout(5, 1)); {
				
				// Style output panel
				JPanel styleOutputPanel = new JPanel();
				styleOutputPanel.setLayout(new BoxLayout(styleOutputPanel, BoxLayout.X_AXIS)); {
					styleOutputPanel.add(new JLabel("Style"));
					styleScoreDisplayField = new JTextField("0.0");
					styleScoreDisplayField.setEditable(false);
					styleOutputPanel.add(styleScoreDisplayField);
				}
				attributeAveragePanel.add(styleOutputPanel);
				
				// Content output panel
				JPanel contentOutputPanel = new JPanel();
				contentOutputPanel.setLayout(new BoxLayout(contentOutputPanel, BoxLayout.X_AXIS)); {
					contentOutputPanel.add(new JLabel("Content"));
					contentScoreDisplayField = new JTextField("0.0");
					contentScoreDisplayField.setEditable(false);
					contentOutputPanel.add(contentScoreDisplayField);
				}
				attributeAveragePanel.add(contentOutputPanel);
				
				// Originality output panel
				JPanel originalityOutputPanel = new JPanel();
				originalityOutputPanel.setLayout(new BoxLayout(originalityOutputPanel, BoxLayout.X_AXIS)); {
					originalityOutputPanel.add(new JLabel("Originality"));
					originalityScoreDisplayField = new JTextField("0.0");
					originalityScoreDisplayField.setEditable(false);
					originalityOutputPanel.add(originalityScoreDisplayField);
				}
				attributeAveragePanel.add(originalityOutputPanel);
				
				// Reach output panel
				JPanel reachOutputPanel = new JPanel();
				reachOutputPanel.setLayout(new BoxLayout(reachOutputPanel, BoxLayout.X_AXIS)); {
					reachOutputPanel.add(new JLabel("Reach"));
					reachScoreDisplayField = new JTextField("0.0");
					reachScoreDisplayField.setEditable(false);
					reachOutputPanel.add(reachScoreDisplayField);
				}
				attributeAveragePanel.add(reachOutputPanel);
				
				// Engagement output panel
				JPanel engagementOutputPanel = new JPanel();
				engagementOutputPanel.setLayout(new BoxLayout(engagementOutputPanel, BoxLayout.X_AXIS)); {
					engagementOutputPanel.add(new JLabel("Engagement"));
					engagementScoreDisplayField = new JTextField("0.0");
					engagementScoreDisplayField.setEditable(false);
					engagementOutputPanel.add(engagementScoreDisplayField);
				}
				attributeAveragePanel.add(engagementOutputPanel);
			}
			ans.add(attributeAveragePanel);
			
			// Global output panel
			JPanel globalAveragePanel = new JPanel();
			globalAveragePanel.setBorder(GUIComponentFactory.emptyBorder);
			globalAveragePanel.setLayout(new GridLayout(1, 1)); {
				JPanel globalOutputPanel = new JPanel();
				globalOutputPanel.setLayout(new BoxLayout(globalOutputPanel, BoxLayout.X_AXIS)); {
					globalOutputPanel.add(new JLabel("Total Score"));
					globalScoreDisplayField = new JTextField("0");
					globalScoreDisplayField.setEditable(false);
					globalOutputPanel.add(globalScoreDisplayField);
				}
				globalAveragePanel.add(globalOutputPanel);
			}
			ans.add(globalAveragePanel);
		}
		return ans;
	}
	
	/******************************  ******************************/
	
	/**
	 * @description build the menu bar for the application.
	 */
	private JMenuBar buildMenuBar() {
		JMenuBar ans = new JMenuBar(); {
			
			// File menu
			JMenu fileMenu = new JMenu("File"); {
				
			}
			ans.add(fileMenu);
			
			// Help menu
			JMenu helpMenu = new JMenu("Help"); {
				
			}
			ans.add(helpMenu);
		}
		return ans;
	}
	
	/******************************  ******************************/
	
	/**
	 * @description main function for local testing.
	 */
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		MainGUI gui = new MainGUI();
	}
}
