// Jerry Zeng and Steven Shi
// April 12, 2021
// Final Project MyFrame Class
// ICS3U7 Ms. Strelkovska

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.*;

//made equally by Steven, Jerry
public class MyFrame extends JFrame{

	
	private MyPanel mp;
	public static Container c;
	//set width and height of frame JZ
	private int width = 1350;
	private int height = 710;

	public MyFrame(String title, int map, Color player1, Color player2) {
		
		//Inheritance
		super(title);
		
		//assign mypanel
		mp= new MyPanel(map, player1, player2);
		
		
		c= this.getContentPane();
		c.setLayout(new BorderLayout());
		//add mypanel to container
		c.add(mp, BorderLayout.CENTER);
		
	
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(width, height);
	}


}