// Jerry Zeng and Steven Shi
// April 12, 2021
// Final Project Gun Class
// ICS3U7 Ms. Strelkovska

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
//Mainly made by SS
public class Gun {
	
	//Declaring Variables
	private Color color;
	int rightX;
	private int leftXHandle;
	private int leftXBarrel;
	private boolean isRight;
	
	private int y;
	private ArrayList<Projectile> bullet = new ArrayList<Projectile>();
	private int ammo; 
	
	//constructor
	public Gun() {
		//set ammount of ammo and color
		ammo = 12; 
		color = Color.black;
	}
	//subtract ammo
	public void lessAmmo(){
		ammo--;
	}
	//get ammo amount
	public int getAmmo(){
		return ammo; 
	}
	//reset the ammo
	public void resetAmmo(){
		ammo = 12;
	}
	//set position of barrel for gun
	public void setLeftXBarrel(int newx){
		leftXBarrel=newx;
	}
	//set position of handle for gun 
	public void setLeftXHandle(int newx){
		leftXHandle=newx;
	}
	//isRight setter
	public void setIsRight(boolean t){
		isRight=t;
	}
	//set the y position of the gun
	public void setY(int newy){
		y=newy;
	}
	//remove all bullets from arraylist
	public void removeAll(){
		bullet.clear();
	}
	public void myDraw(Graphics g) {
			
			g.setColor(color);
			//draw the gun
			g.fillRect(leftXHandle,y,10,25);
			g.fillRect(leftXBarrel, y, 35, 10);
			
			//Shooting the projectile/bullet JZ
			for(int i =0; i < bullet.size();i++){
				bullet.get(i).myDraw(g);
				
				bullet.get(i).bulletTravel();
				
				if(bullet.get(i).isExited()){
					bullet.remove(i);
				}
			}
	
	}
	//shoot method
	public void shoot(){
		bullet.add(new Projectile(leftXBarrel,y,isRight));
		
	}
	//get arraylist
	public ArrayList getBullet() {
		return bullet;
	}
	

}

