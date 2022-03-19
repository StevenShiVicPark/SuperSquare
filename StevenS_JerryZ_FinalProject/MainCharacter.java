// Jerry Zeng and Steven Shi
// April 12, 2021
// Final Project Main Character Class
// ICS3U7 Ms. Strelkovska

//Java imports
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
//mainly made by steven
public class MainCharacter {
	//Declaring Instance Variables
	private int x;
	private int y;
	private int sx;
	private int sy;
	private int tempy;
	private int gravity; 
	private boolean gravAct;
	private int hp; 
	private Platform pnMain; 
	private ArrayList<Platform> p;
	private boolean isJumping;
	private boolean isRight;
	private boolean isLeft;
	private Gun gun;
	private Color colour;
	private Shotgun shot;
	private AssaultRifle ar;
	private boolean isShotty;
	private boolean isGun; 
	private boolean isAr; 
	private Rectangle box;
	private boolean switched;
	
	//Constructor
	public MainCharacter(int playerNum, Color colour){
		//Assigning variables
		isJumping=false;
		
		//Setting players to face each other JZ
		if(playerNum == 1) {
			isRight = true;
			isLeft = false;
		}
		if(playerNum == 2) {
			isRight = false;
			isLeft = true;
		}
		
		//create instance of guns SS
		shot=new Shotgun();
		gun=new Gun();
		ar=new AssaultRifle();
		
		//character is holding gun, spawn with gun SS
		isGun = true;
		
		//arraylist of platforms SS
		p = new ArrayList<Platform>();
		
		//Creating the map that is chosen by user
		if(MyPanel.getMap()==0){
			//assign variables to platforms SS
			p.add(BasicMap.getp1());
			p.add(BasicMap.getp2());
			pnMain=BasicMap.getBigP();
		}
		if(MyPanel.getMap()==1){
			//assign variables to platforms SS
			p.add(MapBigHole.getp1());
			p.add(MapBigHole.getp2());
			pnMain=MapBigHole.getBigP();
		}

		if(MyPanel.getMap()==2){
			//add variables to platforms SS
			p.add(XMap.getp1());
			p.add(XMap.getp2());
			pnMain=XMap.getBigP();
			p.add(XMap.getp4());
			p.add(XMap.getp5());
		}
		
		//Spawn points of characters JZ
		if(playerNum == 1) {
			x=300;
		}
		if(playerNum == 2) {
			x=1000;
		}
		y= pnMain.getY()-50;
		
		//add pnMain to arraylist ss
		p.add(pnMain);
		//set gravity SS
		gravity=15;
		gravAct=true;
		//character move and jump speed SS
		sx=12;
		sy=30;
		//height of character on the ground ss
		tempy=y;
		hp=10;
		
		//set color JZ
		this.colour = colour;
		
	}
	//shoot guns SS
	//shot ar 
	public void arshoot(){
		//if ar has enough AMmo
		if(ar.getAmmo()>0){
			//shoot 
			ar.shoot();
			//recoil, character move back depending on direction faced JZ
			recoil(isRight);
		}
		//make ar have less ammo SS
		ar.lessAmmo();
	}
	//gun shoot
	public void gunShoot(){
		//if gun has enough ammo ss
		if(gun.getAmmo()>0){
			//shoot ss
			gun.shoot();
			//recoil ss
			recoil(isRight);
		}
		//make gun have less ammo ss
		gun.lessAmmo();
	}
	//shotgun shoot 
	public void shotShoot(){
		
		//if shotgun has enough ammo ss
		if(shot.getAmmo()>0){
			//shoot ss
			shot.shoot();
			//recoil ss
			recoil(isRight);
		}
		//make shotgun have less ammo ss
		shot.lessAmmo();
	}
	
	//get what gun is currently held ss
	public boolean getIsGun(){
		return isGun;
	}
	public boolean getIsAr(){
		return isAr;
	}
	
	public boolean getIsShotty(){
		return isShotty;

	}
	//getter switched ss
	public boolean getSwitched() {
		return switched;
	}
	//setter switched ss
	public void setSwitched(boolean t) {
		switched = t;
	}
	//draw method
	public void myDraw(Graphics g){

		//Setting colour of character JZ
		g.setColor(colour);

		//hitbox of character ss
		box = new Rectangle(x,y,50,50);
		
		
		for(int i =0; i < MyPanel.getItems().size();i++){
			//check if item has hit platform. If so, make item go above platform ss
			for(int j = 0; j < p.size();j++){
				if(MyPanel.getBox(i).intersects(toRect(p.get(j)))){
					((Droppable)MyPanel.getItems().get(i)).setY(p.get(j).getY()-25);
				}
			}
			//if character intersects item, check what item it is ss
			if(box.intersects(MyPanel.getBox(i))){
				//character has switched items ss
				switched = true;
				
				//if item is shotgun, signal that shotgun is being held ss
				if(MyPanel.getHitItem(i).equals("shotgun")){
					isShotty=true;
					isGun=false;
					isAr=false;
					
					shot.resetAmmo();
				}
				//if item is gun, signal that gun is being held ss
				if(MyPanel.getHitItem(i).equals("gun")){
					
					isShotty=false;
					isGun=true;
					isAr=false;
					
					gun.resetAmmo();
					
				}
				//if item is ar, signal that ar is being held ss
				if(MyPanel.getHitItem(i).equals("ar")){
				
					isShotty=false;
					isGun=false;
					isAr=true;
					
					ar.resetAmmo();
				}
				
				//User gains 10% hp if they obtain a red apple JZ
				if(MyPanel.getHitItem(i).equals("red apple")) {
					if(hp != 10) {
						hp++;
					}
				}
				
				//User gains 30% hp if they obtain a golden apple JZ
				if(MyPanel.getHitItem(i).equals("golden apple")) {
					hp+=3;
					if(hp>10) {
						hp = 10;
					}
				}
				//remove item once touched ss
				MyPanel.getItems().remove(i);
				//remove all bullets from all guns once new gun touched ss
				gun.removeAll();
				shot.removeAll();
				ar.removeAll();
				
			}

		}
		
		//draw the character ss
		g.fillRect(x,y,50,50);
		//set gun's y value ss
		gun.setY(y);
		shot.setY(y);
		ar.setY(y);
		
		
		if(isRight){
			//draw gun depending on what gun player is holding while facing right SS 
			if(isGun){
				
				gun.setIsRight(true);
				//set handle to x+character length
				gun.setLeftXHandle(x + 50);	
				//set barrel to x + character length
				gun.setLeftXBarrel(x+50);
				gun.myDraw(g);

			}
			if(isShotty){
				
				shot.setIsRight(true);
				//set image to x+character length
				shot.setRightX(x + 50);
				shot.myDraw(g);
				
			}
			if(isAr){
				
				ar.setIsRight(true);
				//set image to x+character length
				ar.setRightX(x+50);
				ar.myDraw(g);
			}
			

		}
		else if(isLeft){
			//draw gun depending on what gun player is holding while facing left SS 
			if(isGun){
				gun.setIsRight(false);
				//set handle at x-10 (to account for barrel size)
				gun.setLeftXHandle(x-10);
				//set handle at x-35 (to account for handle size)
				gun.setLeftXBarrel(x-35);
				gun.myDraw(g);
			}
			if(isShotty){
				shot.setIsRight(false);
				//set image at x-100(account for img size)
				shot.setRightX(x - 100);
				shot.myDraw(g);
			}
			if(isAr){
				ar.setIsRight(false);
				//set image at x-100(account for img size)
				ar.setRightX(x-100);
				ar.myDraw(g);
			}
			
		}

       
	}
	
	//gun getters ss
	public Gun getGun(){
		return gun;
	}
	
	public AssaultRifle getAr() {
		return ar;
	}
	
	public Shotgun getShot() {
		return shot;
	}
	//character move right and left methods ss
	public void moveRight(){
		isRight=true;
		isLeft=false;
		x+=sx;


	}
	public void moveLeft(){
		isLeft=true;
		isRight=false;
		x-=sx;


	}
	//getter for character position ss
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	//returns hp of character JZ
	public int getHp(){
		return hp; 
	}
	//Sets hp of character JZ
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	//set the y value when character is on ground
	public void setTempy(){
		tempy=y;
	}
	//set character x pos ss
	public void setX(int newX) {
		x=newX;
	}


	//jumping method ss
	public void yAdd(){
		isJumping=true;
		y+=-sy;
	}
	//getter for tempy ss
	public int getTempy(){
		return tempy;
	}
	//getter for gravity act ss
	public boolean getGravAct(){
		return gravAct;
	}
	//turn platform to rectangle, (for detecting if platform and item intersects) ss
	public Rectangle toRect(Platform e){
		Rectangle j = new Rectangle(e.getX(),e.getY(),e.getW(),e.getH());
		return j;
	}
	//getter for what direction character is facing ss
	public boolean getIsRight(){
		return isRight;
	}
	public boolean getIsLeft(){
		return isLeft;
	}
	
	//When a player shoots a gun, recoil is applied JZ
	public void recoil(boolean right) {
		if(right) {
			x-=5;
		}
		else {
			x+=5;
		}
	}
	//move character
	public void myMove(){

		//gravity applied
		gravAct=true;



		
		for(int i =0;i<p.size();i++) {
			//detect if character is on small platform ss
			if((y+50>=p.get(i).getY() &&y<p.get(i).getY()) && (x+50>p.get(i).getX() &&(x<p.get(i).getX()+p.get(i).getW())) && isJumping==false){
				y=p.get(i).getY()-50;
				gravAct=false;


			}
			
			//make sure square doesn't go into platforms (while falling) ss
			if(x<p.get(i).getX()+p.get(i).getW() && y+50>p.get(i).getY() && (y< p.get(i).getY()+p.get(i).getH()) && x+50>p.get(i).getX()+p.get(i).getW()&& isJumping==false){

				x=p.get(i).getX()+p.get(i).getW();
			
			}
			if(x+50>p.get(i).getX() && y+50>p.get(i).getY() && (y< p.get(i).getY()+p.get(i).getH()) && x<p.get(i).getX()&& isJumping==false){

				x=p.get(i).getX()-50;
				
			}

		}
		//apply gravity ss
		if(gravAct){

			y+=gravity;
		}

		//make sure character can't leave screen jz
		if(x<0) {
			x = 1;
		}
		if(x>1350-70) {
			x = 1350 - 70;
		}
		if(y<0) {
			y = 0;
		}
		//if character falls, set hp to 0 ss
		if(y>=730){


			hp=0;

		}
		
		isJumping=false;


	}

}



