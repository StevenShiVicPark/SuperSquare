// Jerry Zeng and Steven Shi
// April 12, 2021
// Final Project ShotGun Class
// ICS3U7 Ms. Strelkovska

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
//made by SS
public class Shotgun {


	private int rightX;
	private ImageIcon img;
	private boolean isRight;

	private int change; 

	private int y;
	private ArrayList<Projectile> bullet = new ArrayList<Projectile>();
	private boolean rs,ru,rd;
	private int rsi,rui,rdi;
	private int ammo;
	//constructor 
	public Shotgun() {
		//set ammo 
		ammo = 24; 
		isRight=true;
		change=1;


	}
	//make ammo go down (for shooting)
	public void lessAmmo(){
		ammo-=3;
	}
	//getter for ammo
	public int getAmmo(){
		return ammo; 
	}
	//make ammo reset after picking up shotgun
	public void resetAmmo(){
		ammo = 24; 
	}
	//set the x pos
	public void setRightX(int newx){
		rightX=newx;
	}
	//set y pos
	public void setY(int newy){
		y=newy;
	}
	//set character facing right
	public void setIsRight(boolean t){
		isRight=t;
	}
	//remove all bullets
	public void removeAll(){
		bullet.clear();
	}
	//draw shotgun
	public void myDraw(Graphics g) {
		//draw different image depending on which way gun is pointing
		if(isRight){
			change=1;
		}else{
			change=-1;
		}
		img = new ImageIcon("Shotgun"+change+".png");
		g.drawImage(img.getImage(), rightX, y,100,25,null);
		//shoot shotgun ss
		for(int i =0; i < bullet.size();i+=3){

			
			bullet.get(i).bulletTravel();
			bullet.get(i+1).shotup();
			bullet.get(i+2).shotdown();
			bullet.get(i).myDraw(g);
			bullet.get(i+1).myDraw(g);
			bullet.get(i+2).myDraw(g);
			
			//if bullet left the page, remove them 
			//cannot remove them individually or else stack overflow
			
			if(bullet.get(i).isExited()){
				rs=true;
				rsi=i;
			}
			if(bullet.get(i+1).isExited()){
				ru=true;
				rui=i+1;
			}
			if(bullet.get(i+2).isExited()){
				rd=true;
				rdi=i+2;
			} 
			//remove bullets together
			if(rs&&ru&&rd){

				bullet.remove(rdi);
				bullet.remove(rui);
				bullet.remove(rsi);

			}
			rs=false;
			ru=false;
			rd=false;
		}

	}
	//shoot shotgun 
	public void shoot(){

		bullet.add(new Projectile(rightX,y,isRight));
		bullet.add(new Projectile(rightX,y,isRight));
		bullet.add(new Projectile(rightX,y,isRight));
	}

	public ArrayList getBullet() {
		return bullet;
	}
}
