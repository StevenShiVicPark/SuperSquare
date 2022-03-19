// Jerry Zeng and Steven Shi
// April 12, 2021
// Final Project Platform Class
// ICS3U7 Ms. Strelkovska

import java.awt.Color;
import java.awt.Graphics;
//made by Steven
public class Platform {
	//declare variables
	private int x,y,w,h;
	public Platform(int x, int y, int w, int h){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
	}
	//draw the platform
	public void myDraw(Graphics g){
		g.setColor(Color.darkGray);
		
		g.fillRect(x,y,w,h);
		
	}
	//get the x,y,width, height of the platform 
	public int getX() {
		return x;

	}
	public int getY() {
		return y;
	}
	public int getW() {
		return w;
	}
	public int getH() {
		return h;
	}
}










