// Jerry Zeng and Steven Shi
// April 12, 2021
// Final Project Projectile Class JZ
// ICS3U7 Ms. Strelkovska

//Java imports
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
//made mainly by JZ
public class Projectile {
	//declaring instance variables JZ
	private int r;
	private int x;
	private int y;
	private int dx,dy;
	private Color c;

	//hitbox of projectile SS
	private Rectangle proj; 
	
	//Constructor JZ
	public Projectile(int x, int y, boolean right) {
		r = 8;
		c = Color.black;
		
		if(right) {
			dx = 15;
			dy=15;
		}
		else {
			dx = -15;
			dy=-15;
		}
		this.x = x; 
		this.y = y;
		
		//projectile hitbox declare SS
		proj = new Rectangle(this.x,this.y,r,r);
	}
	
	//Drawing the projectile JZ
	public void myDraw(Graphics g) {
		
		g.setColor(c);
		g.fillOval(x, y, r, r);
		g.drawOval(x, y, r, r);
		
		//SS
		proj = new Rectangle(this.x,this.y,r,r);
	}
	
	//Making the bullet travel JZ
	public void bulletTravel() {
		x+=dx;
	}
	
	//Shotup method SS
	public void shotup(){
		x+=dx;
		y+=dy;
		
	}
 
	//Shotdown method SS
	public void shotdown(){
		x+=dx;
		y-=dy;
		
	}
	
	//Boolean method to see if bullet has left the frame JZ
	public boolean isExited() {
		return x<0 || x>1350 || y<0 || y>710;
	}
	
	public void setY() {
		y = -1000;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	//getter for projectile hitbox SS
	public Rectangle getProj(){
		return proj; 
	}

}