// Jerry Zeng and Steven Shi
// April 12, 2021
// Final Project Gun Drop Class
// ICS3U7 Ms. Strelkovska

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

//made by steven
public class GunDrop extends Droppable{
	private int x,y;
	private Rectangle drop;

	public GunDrop(){
		//x and y coordinates
		x=(int)(Math.random()*(1000/50))*50+50;
		y=0;
		//hitbox 
		drop = new Rectangle(x,y,35,35);
		
	}
	
	//get item type
	public String getItem(){
		return "gun";
	}
	//get hitbox
	public Rectangle getRect(){
		return drop;
		
	}
	//getter and setter for y
	public int getY(){
		return y;
	}
	public void setY(int newy){
		y=newy;
	}

	public void myDraw(Graphics g){
		//item falls
		y+=5;
		//hitbox
		drop = new Rectangle(x,y,35,35);
		
		//set color
		g.setColor(Color.black);
		//draw the gun
		g.fillRect(x, y-10,10,25);
		g.fillRect(x, y-10, 35, 10);		
		
		
	}
	


}
