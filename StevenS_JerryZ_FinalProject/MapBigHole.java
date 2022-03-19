// Jerry Zeng and Steven Shi
// April 12, 2021
// Final Project Map Big Hole Class
// ICS3U7 Ms. Strelkovska

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

//Made by Steven
public class MapBigHole {

	
	//three platforms declare
	private static Platform bigP= new Platform(0,600,500,200);
	private static Platform p1=new Platform(570,450,200,5);
	private static Platform p2 = new Platform(835,600,500,200);
	public MapBigHole(){
		


	}
	//draw method, draws the platforms
	public static void myDraw(Graphics g){
		
		
		p1.myDraw(g);
		p2.myDraw(g);
		bigP.myDraw(g);
		
	}
	
	//getters for platforms
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

