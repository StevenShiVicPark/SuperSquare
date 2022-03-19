// Jerry Zeng and Steven Shi
// April 12, 2021
// Final Project Assault Rifle Class
// ICS3U7 Ms. Strelkovska

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;

//Mainly made by steven
public class AssaultRifle {
	
	
	
	private int rightX;
	private ImageIcon img;
	private boolean isRight;
	private int change; 
	private int y;
	private ArrayList<Projectile> bullet = new ArrayList<Projectile>();
	private int ammo; 
	
	//constructor
	public AssaultRifle() {
		//set ammo amount 
		ammo = 20;
		isRight=true;
		change=1;
	
	}
	//subtract ammo 
	public void lessAmmo(){
		ammo--;
	}
	//getter for ammo
	public int getAmmo(){
		return ammo; 
	}
	//sets ar x pos 
	public void setRightX(int newx){
		
		rightX=newx;
	}
	//sets y pos
	public void setY(int newy){
		y=newy;
	}
	//reset ammo
	public void resetAmmo(){
		ammo=20;
	}
	//setter for isRight
	public void setIsRight(boolean t){
		isRight=t;
	}
	//clear all bullets 
	public void removeAll(){
		bullet.clear();
	}
	public void myDraw(Graphics g) {
			//draw img depending on if character is facing right 
			if(isRight){
				change=1;
			}else{
				change=2;
			}
			
			img = new ImageIcon("Ar"+change+".png");
			g.drawImage(img.getImage(), rightX, y,100,25,null);
			
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
		//add projectile to bullet arraylist
		bullet.add(new Projectile(rightX,y,isRight));
		
	}
	//getter for bullet
	public ArrayList getBullet() {
		return bullet;
	}
}
