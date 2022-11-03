package com.GUI;

import java.awt.*;
import javax.swing.*;

import com.diy.software.Attendant;

public class AttendantCheckoutStationGUI 
{
	GUI_JFrame window;
	
	/* Title Section Variables*/
	GUI_JPanel titlePanel;
	GUI_JLabel titleLabel;
	
	/* Center Section Variables*/
	GUI_JPanel centerPanel;
	Attendant attendant;
	GUI_JPanel weightDiscrepancyPanel;
	
	public AttendantCheckoutStationGUI() 
	{
		/* Initialization of the GUI */
		initalizeWindow();
		initalizeTitlePanel();
		initalizeSpacerPanels();
		initalizeCenterPanel();
		window.setVisible(true);

	}
	
	/* Initialization of the GUI window*/
	private void initalizeWindow() 
	{
		int topBottomMargin = 20;
		window = new GUI_JFrame("Attendant Self Checkout Window");
		window.setLayout(new BorderLayout(0,topBottomMargin));	
	}
	
	/* Initialization of the title  panel*/
	private void initalizeTitlePanel() 
	{
		/* Setup of the title's label */
		titleLabel = new GUI_JLabel();
		titleLabel.setText("ATTENDANT WINDOW");
		titleLabel.setFont(GUI_Fonts.TITLE);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		/* Setup of the title's panel */
		titlePanel = new GUI_JPanel();
		titlePanel.setBackground(Color.decode("#223240"));
		titlePanel.setPreferredSize(new Dimension(1280,75));
		titlePanel.setLayout(new BorderLayout());
		
		/* Adding the label to the panel */
		titlePanel.add(titleLabel, BorderLayout.CENTER); 
		
		/* Adding the panel to the window */
		window.add(titlePanel, BorderLayout.NORTH);
	}
	
	
	/* Initialization of Spacers panels:
	 * 		Creates the margin effect of the window
	 *  */
	private void initalizeSpacerPanels() 
	{
		// Setting for the spacer panels 
		int leftRightSpaceing = 50;
		int bottomSpaceing = 10;
		Color SpacerColor = GUI_Color_Palette.LIGHT_BLUE;
		
		//Spacer panels
		GUI_JPanel LeftSpacerPanel;
		GUI_JPanel RightSpacerPanel;
		GUI_JPanel bottomSpacerPanel;
		
		//Setting up the left spacer panel
		LeftSpacerPanel = new GUI_JPanel();
		LeftSpacerPanel.setBackground(SpacerColor);
		LeftSpacerPanel.setPreferredSize(new Dimension(leftRightSpaceing,0));
		
		//Setting up the right spacer panel
		RightSpacerPanel = new GUI_JPanel();
		RightSpacerPanel.setBackground(SpacerColor);
		RightSpacerPanel.setPreferredSize(new Dimension(leftRightSpaceing,0));
		
		//Setting up the bottom spacer panel
		bottomSpacerPanel = new GUI_JPanel();
		bottomSpacerPanel.setBackground(SpacerColor);
		bottomSpacerPanel.setPreferredSize(new Dimension(bottomSpaceing,0));
		
		//Adding the spacer panels to the window 
		window.add(LeftSpacerPanel, BorderLayout.WEST);
		window.add(RightSpacerPanel, BorderLayout.EAST);
		window.add(bottomSpacerPanel, BorderLayout.SOUTH);
	}
	
	/* Initialization of Center  panel which hold most of the content*/
	private void initalizeCenterPanel() 
	{
		//Settings 

		//Setting up the center panel
		centerPanel = new GUI_JPanel();
		centerPanel.setBackground(GUI_Color_Palette.LIGHT_BLUE);
		centerPanel.setPreferredSize(new Dimension(100,75));
		centerPanel.setLayout(new BorderLayout());
		
		
		//Setting up the weight discrepancy label
		int border = 10;
		GUI_JLabel weightDiscrepancyLabel = new GUI_JLabel();
		weightDiscrepancyLabel.setText("Weight Discrepancy Alert".toUpperCase());
		weightDiscrepancyLabel.setFont(GUI_Fonts.TITLE);
		weightDiscrepancyLabel.setHorizontalAlignment(JLabel.CENTER);
		weightDiscrepancyLabel.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.DARK_BROWN, border));
		
		//Weight discrepancy panel
		int panelMargin = 210;
		weightDiscrepancyPanel = new GUI_JPanel();
		weightDiscrepancyPanel.setLayout(new BorderLayout());
		weightDiscrepancyPanel.setBackground(GUI_Color_Palette.DARK_BLUE);
		weightDiscrepancyPanel.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.LIGHT_BLUE, panelMargin));
		weightDiscrepancyPanel.setVisible(false);
		
		//Adding weight discrepancy label to panel
		weightDiscrepancyPanel.add(weightDiscrepancyLabel, BorderLayout.CENTER);
		
		//Adding weight discrepancy panel to centerPanel
		centerPanel.add(weightDiscrepancyPanel, BorderLayout.CENTER);
		
		//Adding the center panel to the window
		window.add(centerPanel, BorderLayout.CENTER);
	}
	
	/*shows the Weight Discrepancy  warning panel*/
	public void displayWeightDiscrepancy()
	{
		weightDiscrepancyPanel.setVisible(true);
	}
	
	
	/*Only for testing the class*/
	public static void main(String[] args) 
	{
		AttendantCheckoutStationGUI GUI = new AttendantCheckoutStationGUI();
		Attendant attendant = new Attendant(GUI);
		attendant.signalWeightDisc();
	}
}
