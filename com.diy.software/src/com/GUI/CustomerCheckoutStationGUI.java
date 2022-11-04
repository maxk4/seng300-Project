package com.GUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import com.diy.hardware.BarcodedProduct;
import com.diy.hardware.DoItYourselfStation;
import com.diy.hardware.external.ProductDatabases;
import com.diy.simulation.Customer;
import com.diy.software.Attendant;
import com.diy.software.ScanItem;
import com.jimmyselectronics.necchi.Barcode;
import com.jimmyselectronics.necchi.BarcodedItem;
import com.jimmyselectronics.necchi.Numeral;
public class CustomerCheckoutStationGUI 
{

	GUI_JFrame window;
	
	/* Title Section Variables*/
	private GUI_JPanel titlePanel;
	private GUI_JLabel titleLabel;
	
	/* Center Section Variables*/
	private GUI_JPanel centerPanel;
	
	/* Item Checkout Section Variables*/
	private GUI_JPanel itemCheckoutTitlePanel;
	private GUI_JPanel itemCheckoutContentsPanel;
	private GUI_JPanel itemCheckoutTotalPanel;
	private GUI_JPanel itemCheckoutPanel;
	private GUI_JLabel checkoutTotalPriceLabel;
	
	/* Current Item Section Variables*/
	private GUI_JPanel currentItemCheckoutPanel;
	private GUI_JPanel currentItemTitlePanel;
	private GUI_JPanel currentItemPanel;
	private GUI_JPanel currentItemButtonsPanel;
	private GUI_JLabel currentItemLabel;
	private GUI_JLabel currenttemPriceLabel;
	private GUI_JButton addItemButton;
	
	private Customer customer;
	private List<String> checkOut = new ArrayList<>();
	
	private int currentItemIndex = 0;
	
	private int total;
	
	private ScanItem scanItem;
		
	
	public CustomerCheckoutStationGUI(Customer customer, ScanItem scanItem) 
	{
		this.customer = customer;
		this.scanItem = scanItem;
		
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
		window = new GUI_JFrame("Customer Self Checkout Window");
		window.setLayout(new BorderLayout(0,topBottomMargin));		
	}
	
	/* Initialization of the title  panel*/
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
	
	
	/* Initialization of the title panel for the item checkout Section*/
	private void initalizeItemCheckoutTitlePanel() 
	{
		int height = 60;
		String checkoutTitleText  = "Checkout"; 
		
		GUI_JLabel checkoutTitleLabel = new GUI_JLabel();
		
		//Setting up the title label
		checkoutTitleLabel.setText(checkoutTitleText.toUpperCase());
		checkoutTitleLabel.setFont(GUI_Fonts.TITLE);
		checkoutTitleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		
		//Setting up the title panel 
		itemCheckoutTitlePanel = new GUI_JPanel();
		itemCheckoutTitlePanel.setBackground(GUI_Color_Palette.DARK_BROWN);
		itemCheckoutTitlePanel.setPreferredSize(new Dimension(0,height));
		itemCheckoutTitlePanel.setLayout(new BorderLayout());
		
		//Adding the title label to the title panel
		itemCheckoutTitlePanel.add(checkoutTitleLabel, BorderLayout.CENTER);
	}


	/* Initialization of the each item content panel for the item checkout Section*/
	private void initalizeItemCheckoutContentsPanel() 
	{
		int height = 60;

		/* Item Contents panel Setup*/
		itemCheckoutContentsPanel = new GUI_JPanel();
		itemCheckoutContentsPanel.setLayout(new BorderLayout());
		itemCheckoutContentsPanel.setBackground(GUI_Color_Palette.DARK_BROWN);
		itemCheckoutContentsPanel.setPreferredSize(new Dimension(0,height));
		
		
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
		checkoutTotalPriceLabel = new GUI_JLabel();
		
		checkoutTotalLabel.setText(checkoutTotalText.toUpperCase());
		checkoutTotalLabel.setFont(GUI_Fonts.TITLE);
		checkoutTotalLabel.setHorizontalAlignment(JLabel.CENTER);
		
		checkoutTotalPriceLabel.setText("$0");
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
		
		currentItemLabel = new GUI_JLabel();
		currentItemLabel.setText("");
		currentItemLabel.setFont(GUI_Fonts.SUB_HEADER);
		currentItemLabel.setHorizontalAlignment(JLabel.LEFT);
		currentItemLabel.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.DARK_BROWN, textMargin));
		
		currenttemPriceLabel =  new GUI_JLabel();
		currenttemPriceLabel.setText("");
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
		
		String addItemButtonText = "Start Scaning";
		addItemButton = new GUI_JButton();
		addItemButton.setText(addItemButtonText.toUpperCase());
		addItemButton.setBorder(BorderFactory.createLineBorder(GUI_Color_Palette.DARK_BLUE,butttonMargin));
		addItemButton.addActionListener(e -> addItemButtonAction());
		
		String payByCreditButtonText = "Pay by Credit";
		GUI_JButton payByCreditButton = new GUI_JButton();
		payByCreditButton.setText(payByCreditButtonText.toUpperCase());
		payByCreditButton.setBorder(BorderFactory.createLineBorder(GUI_Color_Palette.DARK_BLUE,butttonMargin));
		payByCreditButton.addActionListener(e -> payByCreditButtonAction());
		
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
	
	/* Initialization of Center  panel which hold most of the content*/
	private void initalizeCenterPanel() 
	{
		//Settings
		int gridLayoutRow = 0;
		int gridLayoutColumn = 2;
		int gridLayoutHorizontalSpacing = 50;
		int gridLayoutVerticallSpacing = 0;
		
		//Initializing the item checkout Panel and current item/ payment panel
		initalizeItemCheckoutPanel();
		initalizeCurrentItemCheckoutPanel();
		
		//Setting up the center panel
		centerPanel = new GUI_JPanel();
		centerPanel.setBackground(GUI_Color_Palette.LIGHT_BLUE);
		centerPanel.setPreferredSize(new Dimension(100,75));
		centerPanel.setLayout(new GridLayout(gridLayoutRow,gridLayoutColumn,gridLayoutHorizontalSpacing,gridLayoutVerticallSpacing));	
		
		//Adding the item checkout Panel and current item/ payment panel to the center panel
		centerPanel.add(itemCheckoutPanel);
		centerPanel.add(currentItemCheckoutPanel);
		
		//Adding the center panel to the window
		window.add(centerPanel, BorderLayout.CENTER);
	}
	
	/*The action performed when addItemButton is pressed*/
	private void addItemButtonAction()
	{	
		if (currentItemIndex >=  customer.shoppingCart.size()) 
		{
			currentItemLabel.setText("");
			currenttemPriceLabel.setText("");
			return;
		}
		
		if(currentItemIndex < customer.shoppingCart.size()) 
		{
			checkOut.add(getCurrentProduct().getDescription());
			scanItem.scanItems(getCurrentItem());
			
			total += getCurrentProduct().getPrice();
			
			updateCurrentItemGUI();
			updateTotalGUI();
			updateItemCheckOutGUI();
			
			currentItemIndex ++;
		}
				
	}
	
	/*The action performed when addItemButton is pressed*/
	private void payByCreditButtonAction()
	{
		
	}
	
	private void updateItemCheckOutGUI()
	{
		JList list = new JList(checkOut.toArray());
		
		list.setVisibleRowCount(4);
		list.setFont(GUI_Fonts.SUB_HEADER);
		list.setBackground(GUI_Color_Palette.DARK_BROWN);
		list.setForeground(GUI_Color_Palette.WHITE);
		list.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.DARK_BROWN, 20));
		list.setFixedCellHeight(50);
		list.setFixedCellWidth(100);
		 
		itemCheckoutContentsPanel.add(list,BorderLayout.CENTER);
	}
	
	
	private void updateCurrentItemGUI()
	{
		BarcodedProduct currentProduct = getCurrentProduct();
		
		currentItemLabel.setText(currentProduct.getDescription());
		currenttemPriceLabel.setText("$" + String.valueOf(currentProduct.getPrice()));
		
		addItemButton.setText("Scan Next Item".toUpperCase());
	}
	
	private void updateTotalGUI()
	{		
		checkoutTotalPriceLabel.setText("$" + total);
	}
	
	private BarcodedItem getCurrentItem()
	{
		return (BarcodedItem) customer.shoppingCart.get(currentItemIndex);
	}
	
	private BarcodedProduct getCurrentProduct()
	{
		return ProductDatabases.BARCODED_PRODUCT_DATABASE.get(getCurrentItem().getBarcode());
	}
	
	/*Only for testing the class*/
	public static void main(String[] args) 
	{
		DoItYourselfStation DIY_Station = new DoItYourselfStation();
		DIY_Station.plugIn();	
		DIY_Station.turnOn();
				
		Customer customer = new Customer();
		
		Barcode barcodeOne = new Barcode(new Numeral[] { Numeral.one, Numeral.two, Numeral.three, Numeral.four }); // 1234
		BarcodedItem itemOne = new BarcodedItem(barcodeOne,10);
		BarcodedProduct itemOneProduct = new BarcodedProduct(barcodeOne,"ITEM 1",5,11);
		
		Barcode barcodeTwo = new Barcode(new Numeral[] { Numeral.one, Numeral.one, Numeral.three, Numeral.four }); // 1134
		BarcodedItem itemTwo  = new BarcodedItem(barcodeTwo,10);
		BarcodedProduct itemTwoProduct = new BarcodedProduct(barcodeTwo,"ITEM 2",15,12);
		
		
		Barcode barcodeThree = new Barcode(new Numeral[] { Numeral.one, Numeral.two, Numeral.three, Numeral.one }); // 1231
		BarcodedItem itemThree  = new BarcodedItem(barcodeThree,10);
		BarcodedProduct itemThreeProduct = new BarcodedProduct(barcodeThree,"ITEM 3",25,13);
		
		customer.shoppingCart.add(itemOne);
		customer.shoppingCart.add(itemTwo);
		customer.shoppingCart.add(itemThree);
		
		
		//attendant.signalWeightDisc = true;
		
		ProductDatabases.BARCODED_PRODUCT_DATABASE.put(barcodeOne, itemOneProduct);
		ProductDatabases.BARCODED_PRODUCT_DATABASE.put(barcodeTwo, itemTwoProduct);
		ProductDatabases.BARCODED_PRODUCT_DATABASE.put(barcodeThree, itemThreeProduct);
		
		AttendantCheckoutStationGUI attendantGUI  = new AttendantCheckoutStationGUI();
		Attendant attendant = new Attendant(attendantGUI);
		
		ScanItem scanItem = new ScanItem(DIY_Station,attendant);
		
		new CustomerCheckoutStationGUI(customer,scanItem);		
	}
}
