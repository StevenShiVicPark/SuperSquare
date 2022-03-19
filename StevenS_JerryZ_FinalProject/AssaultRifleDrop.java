// Jerry Zeng and Steven Shi
// April 12, 2021
// Final Project Assault Rifle Drop Class
// ICS3U7 Ms. Strelkovska

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
//made by steven 
public class AssaultRifleDrop extends Droppable{
	private int x,y;
	private Rectangle drop;
	private ImageIcon img;
	
	public AssaultRifleDrop(){
		//x position is random 
		x=(int)(Math.random()*(1000/50))*50+50;
		//y starts from the top
		y=0;
		
		//load image 
		img = new ImageIcon("Ar1"+".png");
		//hitbox 
		drop = new Rectangle(x,y,100,25);
		
	}
	
	//get item type
	public String getItem(){
		return "ar";
	}
	//get the hitbox 
	public Rectangle getRect(){
		return drop;
		
	}
	//get the y val 
	public int getY(){
		return y;
	}
	//set the y val
	public void setY(int newy){
		y=newy;
	}

	public void myDraw(Graphics g){
		//item falls
		y+=5;
		//hitbox has same pos as r
		drop = new Rectangle(x,y,100,25);
		
		//draw the image
		g.drawImage(img.getImage(), x, y-10,100,25,null);
		
		
	}
	


}
