// Jerry Zeng and Steven Shi
// April 12, 2021
// Final Project Basic Map Class
// ICS3U7 Ms. Strelkovska
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;


//made by steven
public class BasicMap {

	
	//three platforms 
	private static Platform p1= new Platform(100,450,200,5);
	private static Platform p2 = new Platform(1000,450, 200,5);
	private static Platform bigP=new Platform(150,600,1350-350,200);
	public BasicMap(){
		


	}
	//draw method 
	public static void myDraw(Graphics g){
		
		
		//draw the three platforms 
		p1.myDraw(g);
		p2.myDraw(g);
		bigP.myDraw(g);
		
	}
	
	//get the platforms
	public static Platform getp1() {
		return p1;
	}
	public static Platform getp2() {
		return p2;
	}
	public static Platform getBigP() {
		return bigP;
	}

}











