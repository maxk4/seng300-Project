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
		
		//Panel Border Size
		int panelTopSize  = 30;
		int panelBottomSize  = 30;
		int panelLeftSize  = 10;
		int panelRightSize  = 30;
		
		//Panel Grid Size
		int panelGridRow  = 4;
		int panelGridColumn  = 4;

		//Panel Setup
		JPanel panel  = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(panelTopSize,panelBottomSize,panelLeftSize,panelRightSize));
		panel.setLayout(new GridLayout(panelGridRow, panelGridColumn));
		panel.add(button);
		
		
		//Window title
		String windowTitle = "test Gui";
		int windowSizeX = 1280;
		int windowSizeY = 720;
		
		//Window Setup
		JFrame window = new JFrame();
		window.add(panel, BorderLayout.CENTER);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle(windowTitle);
		window.setSize(windowSizeX,windowSizeY);
		window.setVisible(true);
		panel.setBackground(Color.decode("#D9D0C5"));
		button.setBackground(Color.decode("#5D6A73"));
		
	}
	public static void main(String[] args) 
	{
		new TestGUI();
	}
}
