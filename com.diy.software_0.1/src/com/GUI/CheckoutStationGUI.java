package com.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class CheckoutStationGUI 
{

	GUI_Jframe window;
	
	GUI_JPanel titlePanel;
	GUI_JLabel titleLabel;
		
	GUI_JPanel centerPanel;
	
	GUI_JPanel itemCheckoutTitlePanel;
	GUI_JPanel itemCheckoutContentsPanel;
	GUI_JPanel itemCheckoutTotalPanel;
	GUI_JPanel itemCheckoutPanel;
	
	GUI_JPanel currentItemCheckoutPanel;
	
	int TotalPrice = 0;
	
	
	public CheckoutStationGUI() 
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
		window = new GUI_Jframe();
		window.setLayout(new BorderLayout(0,topBottomMargin));		
	}
	
	/* Initialization of the title  */
	private void initalizeTitlePanel() 
	{
		/* Setup of the title's label */
		titleLabel = new GUI_JLabel();
		titleLabel.setText("SELF CHECKOUT STATION");
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
		int leftRightSpaceing = 50;
		int bottomSpaceing = 10;
		Color SpacerColor = GUI_Color_Palette.LIGHT_BLUE;
		
		GUI_JPanel LeftSpacerPanel;
		GUI_JPanel RightSpacerPanel;
		GUI_JPanel bottomSpacerPanel;
		
		LeftSpacerPanel = new GUI_JPanel();
		LeftSpacerPanel.setBackground(SpacerColor);
		LeftSpacerPanel.setPreferredSize(new Dimension(leftRightSpaceing,0));
		
		RightSpacerPanel = new GUI_JPanel();
		RightSpacerPanel.setBackground(SpacerColor);
		RightSpacerPanel.setPreferredSize(new Dimension(leftRightSpaceing,0));
		
		bottomSpacerPanel = new GUI_JPanel();
		bottomSpacerPanel.setBackground(SpacerColor);
		bottomSpacerPanel.setPreferredSize(new Dimension(bottomSpaceing,0));
		
		window.add(LeftSpacerPanel, BorderLayout.WEST);
		window.add(RightSpacerPanel, BorderLayout.EAST);
		window.add(bottomSpacerPanel, BorderLayout.SOUTH);
	}
	
	
	
	private void initalizeItemCheckoutTitlePanel() 
	{	
		int height = 60;
		String checkoutTitleText  = "Checkout"; 
		
		GUI_JLabel checkoutTitleLabel = new GUI_JLabel();
		
		checkoutTitleLabel.setText(checkoutTitleText.toUpperCase());
		checkoutTitleLabel.setFont(GUI_Fonts.TITLE);
		checkoutTitleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		
		itemCheckoutTitlePanel = new GUI_JPanel();
		itemCheckoutTitlePanel.setBackground(GUI_Color_Palette.DARK_BROWN);
		itemCheckoutTitlePanel.setPreferredSize(new Dimension(0,height));
		
		itemCheckoutTitlePanel.setLayout(new BorderLayout());
		itemCheckoutTitlePanel.add(checkoutTitleLabel, BorderLayout.CENTER); 
	}

	
	private void initalizeItemCheckoutContentsPanel() 
	{	
		
		int height = 60;
		
		int itemHeight = 20;
		int itemBorderSize = 5;
		
		/* Item Content grid values*/
		int gridLayoutRow = 4;
		int gridLayoutColumn = 0;
		int gridLayoutHorizontalSpacing = 0;
		int gridLayoutVerticalSpacing = 20;
		
		int textMargins = 20;
		
		
		/* Item one text and Label Setup*/
		GUI_JLabel itemOneLabel = new GUI_JLabel();
		itemOneLabel.setText("Item #1");
		itemOneLabel.setFont(GUI_Fonts.TITLE);
		itemOneLabel.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.LIGHT_BROWN, textMargins));
		
		/* Item one panel Setup*/
		GUI_JPanel itemOnePanel =  new GUI_JPanel();
		itemOnePanel.setBackground(GUI_Color_Palette.LIGHT_BROWN);
		itemOnePanel.setLayout(new GridLayout());
		itemOnePanel.setPreferredSize(new Dimension(0,itemHeight));
		itemOnePanel.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.DARK_BROWN, itemBorderSize));
		itemOnePanel.add(itemOneLabel);
		
		
		
		/* Item two text and Label Setup*/
		GUI_JLabel itemTwoLabel = new GUI_JLabel();
		itemTwoLabel.setText("Item #2");
		itemTwoLabel.setFont(GUI_Fonts.TITLE);
		itemTwoLabel.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.LIGHT_BROWN, textMargins));
		
		/* Item two panel Setup*/
		GUI_JPanel itemTwoPanel = new GUI_JPanel();
		itemTwoPanel.setBackground(GUI_Color_Palette.LIGHT_BROWN);
		itemTwoPanel.setLayout(new BorderLayout());
		itemTwoPanel.setPreferredSize(new Dimension(0,itemHeight));
		itemTwoPanel.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.DARK_BROWN, itemBorderSize));
		itemTwoPanel.add(itemTwoLabel);
		
		
		
		/* Item three text and Label Setup*/
		GUI_JLabel itemThreeLabel = new GUI_JLabel();
		itemThreeLabel.setText("Item #3");
		itemThreeLabel.setFont(GUI_Fonts.TITLE);
		itemThreeLabel.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.LIGHT_BROWN, textMargins));
		
		/* Item three panel Setup*/
		GUI_JPanel itemThreePanel = new GUI_JPanel();
		itemThreePanel.setBackground(GUI_Color_Palette.LIGHT_BROWN);
		itemThreePanel.setLayout(new BorderLayout());
		itemThreePanel.setPreferredSize(new Dimension(0,itemHeight));
		itemThreePanel.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.DARK_BROWN, itemBorderSize));
		itemThreePanel.add(itemThreeLabel);
		
		
		
		/* Item four text and Label Setup*/
		GUI_JLabel itemFourLabel = new GUI_JLabel();
		itemFourLabel.setText("Item #2");
		itemFourLabel.setFont(GUI_Fonts.TITLE);
		itemFourLabel.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.LIGHT_BROWN, textMargins));
		
		/* Item four panel Setup*/
		GUI_JPanel itemFourPanel = new GUI_JPanel();
		itemFourPanel.setBackground(GUI_Color_Palette.LIGHT_BROWN);
		itemFourPanel.setLayout(new BorderLayout());
		itemFourPanel.setPreferredSize(new Dimension(0,itemHeight));
		itemFourPanel.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.DARK_BROWN, itemBorderSize));
		itemFourPanel.add(itemFourLabel);
		
		
		/* Item Contents panel Setup*/
		itemCheckoutContentsPanel = new GUI_JPanel();
		itemCheckoutContentsPanel.setLayout(new GridLayout(gridLayoutRow,gridLayoutColumn, gridLayoutHorizontalSpacing, gridLayoutVerticalSpacing));
		itemCheckoutContentsPanel.setBackground(GUI_Color_Palette.DARK_BROWN);
		itemCheckoutContentsPanel.setPreferredSize(new Dimension(0,height));
		
		/* Adding the Item panels to the Contents panel*/
		itemCheckoutContentsPanel.add(itemOnePanel);
		itemCheckoutContentsPanel.add(itemTwoPanel);
		itemCheckoutContentsPanel.add(itemThreePanel);
		itemCheckoutContentsPanel.add(itemFourPanel);
	}
	
	private void initalizeitemCheckoutTotalPanel() 
	{	
		int height = 60;
		
		int gridLayoutRow = 0;
		int gridLayoutColumn = 2;
		int gridLayoutHorizontalSpacing = 200;
		int gridLayoutVerticalSpacing = 0;
		
		
		String checkoutTotalText  = "Total"; 
		
		GUI_JLabel checkoutTotalLabel = new GUI_JLabel();
		GUI_JLabel checkoutTotalPriceLabel = new GUI_JLabel();
		
		checkoutTotalLabel.setText(checkoutTotalText.toUpperCase());
		checkoutTotalLabel.setFont(GUI_Fonts.TITLE);
		checkoutTotalLabel.setHorizontalAlignment(JLabel.CENTER);
		
		checkoutTotalPriceLabel.setText("$" + String.valueOf(TotalPrice).toUpperCase());
		checkoutTotalPriceLabel.setFont(GUI_Fonts.TITLE);
		checkoutTotalPriceLabel.setHorizontalAlignment(JLabel.CENTER);
		
		itemCheckoutTotalPanel = new GUI_JPanel();
		itemCheckoutTotalPanel.setLayout(new GridLayout(gridLayoutRow,gridLayoutColumn, gridLayoutHorizontalSpacing, gridLayoutVerticalSpacing));
		itemCheckoutTotalPanel.setBackground(GUI_Color_Palette.DARK_BROWN);
		itemCheckoutTotalPanel.setPreferredSize(new Dimension(0,height));
		
		itemCheckoutTotalPanel.add(checkoutTotalLabel); 	
		itemCheckoutTotalPanel.add(checkoutTotalPriceLabel); 	
	}
	
	private void initalizeItemCheckoutPanel() 
	{
		int topBottomMargin = 20;
		
		initalizeItemCheckoutTitlePanel();
		initalizeItemCheckoutContentsPanel();
		initalizeitemCheckoutTotalPanel();
		
		itemCheckoutPanel = new GUI_JPanel();
		itemCheckoutPanel.setBackground(GUI_Color_Palette.DARK_BLUE);
		itemCheckoutPanel.setPreferredSize(new Dimension(0,0));
		
		itemCheckoutPanel.setLayout(new BorderLayout(0,topBottomMargin));
		
		itemCheckoutPanel.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.DARK_BLUE, 20));
		
		itemCheckoutPanel.add(itemCheckoutTitlePanel, BorderLayout.NORTH);
		itemCheckoutPanel.add(itemCheckoutContentsPanel, BorderLayout.CENTER);
		itemCheckoutPanel.add(itemCheckoutTotalPanel, BorderLayout.SOUTH);
	}
	
	private void initalizeCurrentItemCheckoutPanel() 
	{
		currentItemCheckoutPanel = new GUI_JPanel();
		currentItemCheckoutPanel.setBackground(GUI_Color_Palette.DARK_BLUE);
		currentItemCheckoutPanel.setPreferredSize(new Dimension(0,0));
	}
	
	private void initalizeCenterPanel() 
	{
		int gridLayoutRow = 0;
		int gridLayoutColumn = 2;
		int gridLayoutHorizontalSpacing = 50;
		int gridLayoutVerticallSpacing = 0;
		
		
		initalizeItemCheckoutPanel();
		initalizeCurrentItemCheckoutPanel();
		
		centerPanel = new GUI_JPanel();
		centerPanel.setBackground(GUI_Color_Palette.LIGHT_BLUE);
		centerPanel.setPreferredSize(new Dimension(100,75));
		centerPanel.setLayout(new GridLayout(gridLayoutRow,gridLayoutColumn,gridLayoutHorizontalSpacing,gridLayoutVerticallSpacing));	
		
		centerPanel.add(itemCheckoutPanel);
		centerPanel.add(currentItemCheckoutPanel);
		
		window.add(centerPanel, BorderLayout.CENTER);
	}
	
	
	
	public static void main(String[] args) 
	{
		new CheckoutStationGUI();
	}
	
	

}
