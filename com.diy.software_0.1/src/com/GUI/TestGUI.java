package com.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestGUI 
{
	//Constructor 
	public TestGUI()
	{
		
		//Button Text
		String buttonText = "Test Button";
		//Button setup 
		JButton button = new JButton(buttonText);
		button.setBackground(Color.decode("#5D6A73"));
		button.setFocusable(false);//Removes the border around button text
		button.setBounds(0,0, 40,500);
		button.addActionListener(e -> ButtonPressAction());
		
		//Panel Setup
		GUI_JPanel panel  = new GUI_JPanel();
		
		
		panel.add(button);
		
		GUI_Jframe window = new GUI_Jframe();
		//Add a panel to the window
		window.add(panel, BorderLayout.CENTER);


		
	}
	
	public static void main(String[] args) 
	{
		new TestGUI();
	}
	
	
	public void ButtonPressAction()
	{
		System.out.println("Hey");
	}
}
