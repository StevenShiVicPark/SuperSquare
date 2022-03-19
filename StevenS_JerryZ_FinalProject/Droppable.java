// Jerry Zeng and Steven Shi
// April 12, 2021
// Final Project Droppable Class
// ICS3U7 Ms. Strelkovska

import java.awt.Graphics;
import java.awt.Rectangle;
//made by steven
public abstract class Droppable {
	//abstract class for things that drop from the sky 
	public Droppable(){
		
	}
	//methods droppable classes have in common 
	public abstract void myDraw(Graphics g);
	public abstract Rectangle getRect();
	public abstract void setY(int newy);
	public abstract int getY();
	public abstract String getItem();
}
