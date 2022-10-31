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
	
	/* Title Section Variables*/
	GUI_JPanel titlePanel;
	GUI_JLabel titleLabel;
		
	GUI_JPanel centerPanel;
	
	/* Item Checkout Section Variables*/
	GUI_JPanel itemCheckoutTitlePanel;
	GUI_JPanel itemCheckoutContentsPanel;
	GUI_JPanel itemCheckoutTotalPanel;
	GUI_JPanel itemCheckoutPanel;
	
	/* Current Item Section Variables*/
	GUI_JPanel currentItemCheckoutPanel;
	GUI_JPanel currentItemTitlePanel;
	GUI_JPanel currentItemPanel;
	GUI_JPanel currentItemButtonsPanel;
	
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
		itemOneLabel.setFont(GUI_Fonts.SUB_HEADER);
		itemOneLabel.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.LIGHT_BROWN, textMargins));
		
		/* Item one price and Label Setup*/
		GUI_JLabel itemOnePriceLabel =  new GUI_JLabel();
		itemOnePriceLabel.setText("$0");
		itemOnePriceLabel.setFont(GUI_Fonts.SUB_HEADER);
		itemOnePriceLabel.setHorizontalAlignment(JLabel.RIGHT);
		itemOnePriceLabel.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.LIGHT_BROWN, textMargins));
		
		/* Item one panel Setup*/
		GUI_JPanel itemOnePanel =  new GUI_JPanel();
		itemOnePanel.setBackground(GUI_Color_Palette.LIGHT_BROWN);
		itemOnePanel.setLayout(new GridLayout(0,2));
		itemOnePanel.setPreferredSize(new Dimension(0,itemHeight));
		itemOnePanel.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.DARK_BROWN, itemBorderSize));
		itemOnePanel.add(itemOneLabel);
		itemOnePanel.add(itemOnePriceLabel);
		
		
		
		
		
		/* Item two text and Label Setup*/
		GUI_JLabel itemTwoLabel = new GUI_JLabel();
		itemTwoLabel.setText("Item #2");
		itemTwoLabel.setFont(GUI_Fonts.SUB_HEADER);
		itemTwoLabel.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.LIGHT_BROWN, textMargins));
		
		/* Item two price and Label Setup*/
		GUI_JLabel itemtwoPriceLabel =  new GUI_JLabel();
		itemtwoPriceLabel.setText("$0");
		itemtwoPriceLabel.setFont(GUI_Fonts.SUB_HEADER);
		itemtwoPriceLabel.setHorizontalAlignment(JLabel.RIGHT);
		itemtwoPriceLabel.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.LIGHT_BROWN, textMargins));
		
		/* Item two panel Setup*/
		GUI_JPanel itemTwoPanel = new GUI_JPanel();
		itemTwoPanel.setBackground(GUI_Color_Palette.LIGHT_BROWN);
		itemTwoPanel.setLayout(new GridLayout(0,2));
		itemTwoPanel.setPreferredSize(new Dimension(0,itemHeight));
		itemTwoPanel.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.DARK_BROWN, itemBorderSize));
		itemTwoPanel.add(itemTwoLabel);
		itemTwoPanel.add(itemtwoPriceLabel);
		
		
	
		/* Item three text and Label Setup*/
		GUI_JLabel itemThreeLabel = new GUI_JLabel();
		itemThreeLabel.setText("Item #3");
		itemThreeLabel.setFont(GUI_Fonts.SUB_HEADER);
		itemThreeLabel.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.LIGHT_BROWN, textMargins));
		
		/* Item three price and Label Setup*/
		GUI_JLabel itemThreePriceLabel =  new GUI_JLabel();
		itemThreePriceLabel.setText("$0");
		itemThreePriceLabel.setFont(GUI_Fonts.SUB_HEADER);
		itemThreePriceLabel.setHorizontalAlignment(JLabel.RIGHT);
		itemThreePriceLabel.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.LIGHT_BROWN, textMargins));
		
		/* Item three panel Setup*/
		GUI_JPanel itemThreePanel = new GUI_JPanel();
		itemThreePanel.setBackground(GUI_Color_Palette.LIGHT_BROWN);
		itemThreePanel.setLayout(new GridLayout(0,2));
		itemThreePanel.setPreferredSize(new Dimension(0,itemHeight));
		itemThreePanel.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.DARK_BROWN, itemBorderSize));
		itemThreePanel.add(itemThreeLabel);
		itemThreePanel.add(itemThreePriceLabel);
		
		
		
		/* Item four text and Label Setup*/
		GUI_JLabel itemFourLabel = new GUI_JLabel();
		itemFourLabel.setText("Item #4");
		itemFourLabel.setFont(GUI_Fonts.SUB_HEADER);
		itemFourLabel.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.LIGHT_BROWN, textMargins));
		
		/* Item Four price and Label Setup*/
		GUI_JLabel itemFourPriceLabel =  new GUI_JLabel();
		itemFourPriceLabel.setText("$0");
		itemFourPriceLabel.setFont(GUI_Fonts.SUB_HEADER);
		itemFourPriceLabel.setHorizontalAlignment(JLabel.RIGHT);
		itemFourPriceLabel.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.LIGHT_BROWN, textMargins));
		
		/* Item four panel Setup*/
		GUI_JPanel itemFourPanel = new GUI_JPanel();
		itemFourPanel.setBackground(GUI_Color_Palette.LIGHT_BROWN);
		itemFourPanel.setLayout(new GridLayout(0,2));
		itemFourPanel.setPreferredSize(new Dimension(0,itemHeight));
		itemFourPanel.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.DARK_BROWN, itemBorderSize));
		itemFourPanel.add(itemFourLabel);
		itemFourPanel.add(itemFourPriceLabel);
		
		
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
		int centerTopAndBottomMargin = 20;
		int overallMargin = 20;
		
		initalizeItemCheckoutTitlePanel();
		initalizeItemCheckoutContentsPanel();
		initalizeitemCheckoutTotalPanel();
		
		itemCheckoutPanel = new GUI_JPanel();
		itemCheckoutPanel.setBackground(GUI_Color_Palette.DARK_BLUE);
		itemCheckoutPanel.setPreferredSize(new Dimension(0,0));
		
		itemCheckoutPanel.setLayout(new BorderLayout(0,centerTopAndBottomMargin));
		
		itemCheckoutPanel.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.DARK_BLUE, overallMargin));
		
		itemCheckoutPanel.add(itemCheckoutTitlePanel, BorderLayout.NORTH);
		itemCheckoutPanel.add(itemCheckoutContentsPanel, BorderLayout.CENTER);
		itemCheckoutPanel.add(itemCheckoutTotalPanel, BorderLayout.SOUTH);
	}
	
	
	private void initalizeCurrentItemCheckoutTitlePanel() 
	{
		int height = 60;
		String currentItemTitleText  = "Current Item"; 
		
		GUI_JLabel currentItemTitleLabel = new GUI_JLabel();
		
		currentItemTitleLabel.setText(currentItemTitleText.toUpperCase());
		currentItemTitleLabel.setFont(GUI_Fonts.TITLE);
		currentItemTitleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		
		currentItemTitlePanel = new GUI_JPanel();
		currentItemTitlePanel.setBackground(GUI_Color_Palette.DARK_BROWN);
		currentItemTitlePanel.setPreferredSize(new Dimension(0,height));
		
		currentItemTitlePanel.setLayout(new BorderLayout());
		currentItemTitlePanel.add(currentItemTitleLabel, BorderLayout.CENTER);
		
	}
	
	private void initalizeCurrentItemPanel() 
	{
		int textMargin = 20;
		
		String currentItemText  = "Item #5"; 
		GUI_JLabel currentItemLabel = new GUI_JLabel();
		currentItemLabel.setText(currentItemText.toUpperCase());
		currentItemLabel.setFont(GUI_Fonts.SUB_HEADER);
		currentItemLabel.setHorizontalAlignment(JLabel.LEFT);
		currentItemLabel.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.DARK_BROWN, textMargin));
		
		String currentItemPriceText  = "$0"; 
		GUI_JLabel currenttemPriceLabel =  new GUI_JLabel();
		currenttemPriceLabel.setText(currentItemPriceText);
		currenttemPriceLabel.setFont(GUI_Fonts.SUB_HEADER);
		currenttemPriceLabel.setHorizontalAlignment(JLabel.RIGHT);
		currenttemPriceLabel.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.DARK_BROWN, textMargin));
		
		
		currentItemPanel = new GUI_JPanel();
		currentItemPanel.setBackground(GUI_Color_Palette.DARK_BROWN);
		currentItemPanel.setPreferredSize(new Dimension(0,0));
		
		currentItemPanel.setLayout(new GridLayout(0,2));
		currentItemPanel.add(currentItemLabel);
		currentItemPanel.add(currenttemPriceLabel);
		
	}
	
	private void initalizeCurrentItemButtonPanel() 
	{
		int height = 250;
		int butttonMargin = 25;
		
		String addItemButtonText = "Add Item";
		GUI_JButton addItemButton = new GUI_JButton();
		addItemButton.setText(addItemButtonText.toUpperCase());
		addItemButton.setBorder(BorderFactory.createLineBorder(GUI_Color_Palette.DARK_BLUE,butttonMargin));
		
		String payByCreditButtonText = "Pay by Credit";
		GUI_JButton payByCreditButton = new GUI_JButton();
		payByCreditButton.setText(payByCreditButtonText.toUpperCase());
		payByCreditButton.setBorder(BorderFactory.createLineBorder(GUI_Color_Palette.DARK_BLUE,butttonMargin));
		
		currentItemButtonsPanel = new GUI_JPanel();
		currentItemButtonsPanel.setBackground(GUI_Color_Palette.DARK_BLUE);
		currentItemButtonsPanel.setPreferredSize(new Dimension(0,height));
		
		currentItemButtonsPanel.setLayout(new GridLayout(2,0));		
		
		currentItemButtonsPanel.add(addItemButton);
		currentItemButtonsPanel.add(payByCreditButton);
	}
	
	
	private void initalizeCurrentItemCheckoutPanel() 
	{
		int topBottomMargin = 20;
		
		initalizeCurrentItemCheckoutTitlePanel();
		initalizeCurrentItemPanel();
		initalizeCurrentItemButtonPanel();
		
		currentItemCheckoutPanel = new GUI_JPanel();
		currentItemCheckoutPanel.setBackground(GUI_Color_Palette.DARK_BLUE);
		
		currentItemCheckoutPanel.setPreferredSize(new Dimension(0,0));
		currentItemCheckoutPanel.setLayout(new BorderLayout(0,topBottomMargin));
		currentItemCheckoutPanel.setPreferredSize(new Dimension(0,0));
		
		currentItemCheckoutPanel.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.DARK_BLUE, 20));
		
		currentItemCheckoutPanel.add(currentItemTitlePanel, BorderLayout.NORTH);
		currentItemCheckoutPanel.add(currentItemPanel, BorderLayout.CENTER);
		currentItemCheckoutPanel.add(currentItemButtonsPanel, BorderLayout.SOUTH);
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
