package com.GUI;

import java.awt.Color;

import javax.swing.JFrame;

/*This is an extension of JFrame in order to handle the setting up of a JFrame Window
 * */
@SuppressWarnings("serial")
public class GUI_Jframe extends JFrame
{

	//JFrames title
	private String windowTitle = "Self CheckOut System";
	
	//JFrames Size
	private int windowSizeX = 1280;
	private int windowSizeY = 720;
	
	//JFrame Setup
	public GUI_Jframe() 
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(windowTitle);
		this.setSize(windowSizeX,windowSizeY);
		
		this.setLayout(null);
		
		//JFrames background color in Hex
		ChangeBackgroundColor( GUI_Color_Palette.LIGHT_BLUE);
	}
	
	
	public void ChangeBackgroundColor(Color newBackgroundColor)
	{
		this.getContentPane().setBackground(newBackgroundColor);
	}

}
