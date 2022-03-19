// Jerry Zeng and Steven Shi
// April 12, 2021
// Final Project Shotgun Drop Class
// ICS3U7 Ms. Strelkovska

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
//made by steven
public class ShotgunDrop extends Droppable{
	private int x,y;
	private Rectangle drop;
	private ImageIcon img;
	
	public ShotgunDrop(){
		//set x, y pos
		//x is random, y starts at the top 
		x=(int)(Math.random()*(1000/50))*50+50;
		y=0;
		//load the image and the hitbox
		img = new ImageIcon("Shotgun1"+".png");
		drop = new Rectangle(x,y,100,25);
		
	}
	//get item type 
	public String getItem(){
		return "shotgun";
	}
	//get hitbox
	public Rectangle getRect(){
		return drop;
		
	}
	//get y value
	public int getY(){
		return y;
	}
	//set the y value
	public void setY(int newy){
		y=newy;
	}
	//get x value
	public int getX(){
		return x;
	}
	//draw shotgun drop
	public void myDraw(Graphics g){
		//make shotgun go down
		y+=5;
		//load hitbox
		drop = new Rectangle(x,y,100,25);
		//draw the image
		g.drawImage(img.getImage(), x, y-10,100,25,null);
		
		
	}
	


}

