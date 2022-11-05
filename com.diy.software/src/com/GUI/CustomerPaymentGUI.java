package com.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.diy.software.CreditCardPayment;
import com.jimmyselectronics.opeechee.Card;

public class CustomerPaymentGUI 
{

GUI_JFrame window;
	
	/* Title Section Variables*/
	private GUI_JPanel titlePanel;
	private GUI_JLabel titleLabel;
	
	/* Center Section Variables*/
	private GUI_JPanel centerPanel;
	
	
	private JTextField textField;
	
	private GUI_JButton submittButton;
	
	private CreditCardPayment creditCardPayment;
	private Card card;
	long totalPrice = 0;
	
	public CustomerPaymentGUI(CreditCardPayment creditCardPayment, Card card,long totalPrice) 
	{
		this.creditCardPayment = creditCardPayment;
		this.card  = card;
		this.totalPrice = totalPrice;
		
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
		window = new GUI_JFrame("Payment Window");
		window.setLayout(new BorderLayout(0,topBottomMargin));	
		window.setSize(640,480);
	}
	
	/* Initialization of the title  panel*/
	private void initalizeTitlePanel() 
	{
		/* Setup of the title's label */
		titleLabel = new GUI_JLabel();
		titleLabel.setText("PAYMENT WINDOW");
		titleLabel.setFont(GUI_Fonts.TITLE);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		/* Setup of the title's panel */
		titlePanel = new GUI_JPanel();
		titlePanel.setBackground(GUI_Color_Palette.DARK_BLUE);
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
		
		
		int fieldMargin = 120;
		textField = new  JTextField();
		textField.setFont(GUI_Fonts.TITLE);
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setBorder( BorderFactory.createLineBorder(GUI_Color_Palette.LIGHT_BLUE, fieldMargin));
		
		submittButton = new GUI_JButton();
		submittButton.setText("SUBMIT PIN");
		submittButton.addActionListener(e -> getPin());
		

		centerPanel.add(textField, BorderLayout.CENTER);
		centerPanel.add(submittButton, BorderLayout.SOUTH);
		
		//Adding the center panel to the window
		window.add(centerPanel, BorderLayout.CENTER);
	}
	
	private void getPin() 
	{
		String inputPin  = textField.getText().intern();
		if(creditCardPayment.payWithCredit(inputPin, card, totalPrice))
		{
			textField.setText("Payment Sucsessful");
			textField.setEditable(false);
			submittButton.setEnabled(false);
		}
		else
		{
			textField.setText("Try again");
		}

	} 
}
