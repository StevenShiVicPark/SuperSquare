// Jerry Zeng and Steven Shi
// April 12, 2021
// Final Project Golden Apple Drop Class JZ
// ICS3U7 Ms. Strelkovska

//Java imports
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

//made by jerry
public class GoldenAppleDrop extends Droppable{
	//Declaring instance variables
	private int x,y;
	private Rectangle drop;
	private ImageIcon img;
	
	//Constructor
	public GoldenAppleDrop(){
		//Assigning variables
		x=(int)(Math.random()*(1000/50))*50+50;
		y=0;
		drop = new Rectangle(x,y,50,50);
		img = new ImageIcon("goldenapple.png");
		
	}
	
	//getItem method used to identify which item is being picked up
	public String getItem(){
		return "golden apple";
	}

	public Rectangle getRect(){
		return drop;
		
	}
	public int getY(){
		return y;
	}
	public void setY(int newy){
		y=newy;
	}
	public int getX(){
		return x;
	}
	
	//myDraw method to draw the golden apple dropping
	public void myDraw(Graphics g){
		y+=5;
		drop = new Rectangle(x,y,50,50);
		g.drawImage(img.getImage(), x, y-35,50,50,null);
		
		
	}
	


}
