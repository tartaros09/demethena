package gui;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
				JPanel inputPanel = new JPanel();
				inputPanel.setBorder(GUIComponentFactory.insideLineBorder);
				inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS)); {
					
					// Style attributes
					JPanel stylePanel = new JPanel();
					stylePanel.setBorder(GUIComponentFactory.borderForStyle);
					stylePanel.setLayout(new GridLayout(3, 1)); {
						
						// Structure
						CTPRAttributeRow structureRow = new CTPRAttributeRow("Structure");
						stylePanel.add(structureRow);
						
						// Flow of writing
						CTPRAttributeRow writingFlowRow = new CTPRAttributeRow("Flow of writing");
						stylePanel.add(writingFlowRow);
						
						// Language
						CTPRAttributeRow languageRow = new CTPRAttributeRow("Language");
						stylePanel.add(languageRow);
					}
					inputPanel.add(stylePanel);
					
					// Content attributes
					JPanel contentPanel = new JPanel();
					contentPanel.setBorder(GUIComponentFactory.borderForContent);
					contentPanel.setLayout(new GridLayout(3, 1)); {
						
						// Relevance
						CTPRAttributeRow relevanceRow = new CTPRAttributeRow("Relevance");
						contentPanel.add(relevanceRow);
						
						// Research
						CTPRAttributeRow researchRow = new CTPRAttributeRow("Research");
						contentPanel.add(researchRow);
						
						// Lede and Nut-Graf
						CTPRAttributeRow lngRow = new CTPRAttributeRow("Lede & Nut-Graf");
						contentPanel.add(lngRow);
					}
					inputPanel.add(contentPanel);
					
					// Originality attributes
					JPanel originalityPanel = new JPanel();
					originalityPanel.setBorder(GUIComponentFactory.borderForOriginality);
					originalityPanel.setLayout(new GridLayout(3, 1)); {
						
						// Making a difference
						CTPRAttributeRow differenceRow = new CTPRAttributeRow("Making a difference");
						originalityPanel.add(differenceRow);
						
						// Creativity
						CTPRAttributeRow creativityRow = new CTPRAttributeRow("Creativity");
						originalityPanel.add(creativityRow);
						
						// Why me
						CTPRAttributeRow whyMeRow = new CTPRAttributeRow("Why me?");
						originalityPanel.add(whyMeRow);
					}
					inputPanel.add(originalityPanel);
					
					// Reach attributes
					JPanel reachPanel = new JPanel();
					reachPanel.setBorder(GUIComponentFactory.borderForReach);
					reachPanel.setLayout(new GridLayout(2, 1)); {
						
						// Target audience
						CTPRAttributeRow audienceRow = new CTPRAttributeRow("Target Audience");
						reachPanel.add(audienceRow);
						
						// Quality of publication
						CTPRAttributeRow qualityRow = new CTPRAttributeRow("Quality of Publication");
						reachPanel.add(qualityRow);
					}
					inputPanel.add(reachPanel);
					
					// Engagement attributes
					JPanel engagementPanel = new JPanel();
					engagementPanel.setBorder(GUIComponentFactory.borderForEngagement);
					engagementPanel.setLayout(new GridLayout(2, 1)); {
						
						// Use of media
						CTPRAttributeRow mediaRow = new CTPRAttributeRow("Use of Media");
						engagementPanel.add(mediaRow);
						
						// Call for action
						CTPRAttributeRow actionRow = new CTPRAttributeRow("Call for Action");
						engagementPanel.add(actionRow);
					}
					inputPanel.add(engagementPanel);
				}
				wrapper.add(inputPanel);
				
				// Results display panel
				JPanel outputPanel = new JPanel();
				outputPanel.setBorder(GUIComponentFactory.insideLineBorder);
				outputPanel.setLayout(new BoxLayout(outputPanel, BoxLayout.Y_AXIS)); {
					JPanel attributeAveragePanel = new JPanel();
					attributeAveragePanel.setBorder(GUIComponentFactory.insideLineBorder);
					attributeAveragePanel.setLayout(new GridLayout(5, 1)); {
						
						// Style output panel
						JPanel styleOutputPanel = new JPanel();
						styleOutputPanel.setLayout(new BoxLayout(styleOutputPanel, BoxLayout.X_AXIS)); {
							styleOutputPanel.add(new JLabel("Style"));
							styleScoreDisplayField = new JTextField("0");
							styleScoreDisplayField.setEditable(false);
							styleOutputPanel.add(styleScoreDisplayField);
						}
						attributeAveragePanel.add(styleOutputPanel);
						
						// Content output panel
						JPanel contentOutputPanel = new JPanel();
						contentOutputPanel.setLayout(new BoxLayout(contentOutputPanel, BoxLayout.X_AXIS)); {
							contentOutputPanel.add(new JLabel("Content"));
							contentScoreDisplayField = new JTextField("0");
							contentScoreDisplayField.setEditable(false);
							contentOutputPanel.add(contentScoreDisplayField);
						}
						attributeAveragePanel.add(contentOutputPanel);
						
						// Originality output panel
						JPanel originalityOutputPanel = new JPanel();
						originalityOutputPanel.setLayout(new BoxLayout(originalityOutputPanel, BoxLayout.X_AXIS)); {
							originalityOutputPanel.add(new JLabel("Originality"));
							originalityScoreDisplayField = new JTextField("0");
							originalityScoreDisplayField.setEditable(false);
							originalityOutputPanel.add(originalityScoreDisplayField);
						}
						attributeAveragePanel.add(originalityOutputPanel);
						
						// Reach output panel
						JPanel reachOutputPanel = new JPanel();
						reachOutputPanel.setLayout(new BoxLayout(reachOutputPanel, BoxLayout.X_AXIS)); {
							reachOutputPanel.add(new JLabel("Reach"));
							reachScoreDisplayField = new JTextField("0");
							reachScoreDisplayField.setEditable(false);
							reachOutputPanel.add(reachScoreDisplayField);
						}
						attributeAveragePanel.add(reachOutputPanel);
						
						// Engagement output panel
						JPanel engagementOutputPanel = new JPanel();
						engagementOutputPanel.setLayout(new BoxLayout(engagementOutputPanel, BoxLayout.X_AXIS)); {
							engagementOutputPanel.add(new JLabel("Engagement"));
							engagementScoreDisplayField = new JTextField("0");
							engagementScoreDisplayField.setEditable(false);
							engagementOutputPanel.add(engagementScoreDisplayField);
						}
						attributeAveragePanel.add(engagementOutputPanel);
					}
					outputPanel.add(attributeAveragePanel);
					
					JPanel globalAveragePanel = new JPanel();
					globalAveragePanel.setBorder(GUIComponentFactory.insideLineBorder);
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
					outputPanel.add(globalAveragePanel);
				}
				wrapper.add(outputPanel);
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
		@SuppressWarnings("unused")
		MainGUI gui = new MainGUI();
	}
}
