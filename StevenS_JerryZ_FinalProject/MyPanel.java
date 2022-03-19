// Jerry Zeng and Steven Shi
// April 12, 2021
// Final Project MyPanel Class
// ICS3U7 Ms. Strelkovska

//Java imports
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class MyPanel extends JPanel implements KeyListener,ActionListener, MouseListener, MouseMotionListener{
	//Declaring instance variables
	private  MainCharacter joe;
	private  MainCharacter mama;
	private Timer timer;
	private boolean selfd,selfd2; 
	private static boolean left;
	private static boolean left2;
	private static boolean right;
	private static boolean right2;
	private boolean jump;
	private boolean jump2; 
	private int joePlayerNum;
	private int mamaPlayerNum;
	HealthBar joeBar = new HealthBar();
	HealthBar mamaBar = new HealthBar();
	HealthBar joeAmmo = new HealthBar();
	HealthBar mamaAmmo = new HealthBar();
	private static int map;
	private Color player1Colour;
	private Color player2Colour;
	private int countShot,countGun,countAr, countShot2,countGun2,countAr2,countTime;
	private static ArrayList<Droppable> items;
	private static int randomDrop;
	private boolean shootAr,shootAr2,shootGun,shootGun2, shootShot,shootShot2;
	private static boolean hitShot,hitGun,hitAr,redApple, goldenApple;
	private ImageIcon background;
	private int restart; 

	//Constructor
	public MyPanel(int map, Color player1Colour, Color player2Colour){
	
		super();
		//set the map JZ
		this.map = map;
		//variables by SS
		left=false;
		left2 =false;
		right=false;
		right2=false;
		jump=false;
		jump2=false;
		shootAr =false;
		shootAr2 = false;
		shootGun = false;
		shootGun2 =false;
		shootShot =false;
		shootShot2=false;
		hitShot =false;
		hitGun=false;
		hitAr =false;
		redApple=false;
		goldenApple=false;
		restart=0;

		//assign player id and colour JZ
		joePlayerNum = 1;
		mamaPlayerNum = 2;
		this.player1Colour = player1Colour;
		this.player2Colour = player2Colour;

		//create main character objects,SS and JZ
		joe = new MainCharacter(joePlayerNum, player1Colour);
		mama = new MainCharacter(mamaPlayerNum, player2Colour);
		//assign timer variable
		timer= new Timer(10, this);

		//add mouse and key listener SS
		this.addMouseListener(this);
		this.addMouseMotionListener(this);	
		this.addKeyListener(this);
		setFocusable(true);

		//below are the counts for fire rate. Later check if they are divisible by a certain number for fire rate
		//we have different counts because players may fire at different times
		//we have counts for all guns so players won't have to fire exactly when count divisible by number(better explained later)
		//SS
		//shotgun fire rate count for player 1 and 2 SS
		countShot=0;
		countShot2=0;
		//pistol fire rate count for p1,p2 SS
		countGun=0;
		countGun2=0;
		//Ar fire rate count for p1,p2 SS
		countAr=0;
		countAr2=0;
		//how much time the program has count SS
		countTime=0;

		//initiate droppable items araylist SS
		items = new ArrayList<Droppable>();

	}

	//Paint Component method for drawing everything
	public void paintComponent(Graphics g){

		super.paintComponent(g);

		//check what map is loaded and draw JZ
		if(map==0){

			background = new ImageIcon("background.png");

			g.drawImage(background.getImage(), 0, 0, 1350, 710, null);

			BasicMap.myDraw(g);

		}
		if(map==1){
			background = new ImageIcon("background2.png");
			g.drawImage(background.getImage(), 0, 0, 1350, 710, null);

			MapBigHole.myDraw(g);

		}

		if(map==2) {
			background = new ImageIcon("background3.png");
			g.drawImage(background.getImage(), 0, 0, 1350, 710, null);

			XMap.myDraw(g);

		}
		//draw the characters SS
		joe.myDraw(g);
		mama.myDraw(g);

		//draw the hp JZ
		joeBar.myDrawHP(g, joePlayerNum, joe.getHp(), player1Colour);
		mamaBar.myDrawHP(g, mamaPlayerNum, mama.getHp(), player2Colour);

		//check gun type and draw ammo count JZ
		if(joe.getIsGun()) {
			joeAmmo.myDrawAmmo(g, joePlayerNum, 0, joe.getGun().getAmmo());
		}
		if(mama.getIsGun()) {
			mamaAmmo.myDrawAmmo(g, mamaPlayerNum, 0, mama.getGun().getAmmo());
		}
		if(joe.getIsShotty()) {
			joeAmmo.myDrawAmmo(g, joePlayerNum, 1, joe.getShot().getAmmo());
		}
		if(mama.getIsShotty()) {
			mamaAmmo.myDrawAmmo(g, mamaPlayerNum, 1, mama.getShot().getAmmo());
		}
		if(joe.getIsAr()) {
			joeAmmo.myDrawAmmo(g, joePlayerNum, 2, joe.getAr().getAmmo());
		}
		if(mama.getIsAr()) {
			mamaAmmo.myDrawAmmo(g, mamaPlayerNum, 2, mama.getAr().getAmmo());
		}

		//randomly drop 10 different possibilities JZ
		randomDrop = (int)(Math.random()*10);
		//randomly drop items every 300 ticks SS
		if(countTime%300==0) {
			//drop shotgun if random number is 0 or 1 SS
			if(randomDrop==0 || randomDrop==1){
				hitShot=true;
				hitAr=false;
				hitGun=false;

				items.add(new ShotgunDrop());
			}
			//drop ar if random number is 3 SS
			if(randomDrop==2){
				hitAr=true;
				hitShot=false;
				hitGun=false;

				items.add(new AssaultRifleDrop());
			}
			//drop gun if random number is 4 or 5 or 6 SS
			if(randomDrop==3 || randomDrop == 4 || randomDrop == 5){
				hitGun=true;
				hitShot=false;
				hitAr=false;

				items.add(new GunDrop());
			}
			//drop red apple if random number is 7 or 8 or 9 JZ
			if(randomDrop == 6 || randomDrop == 7 || randomDrop == 8) {
				redApple = true;

				items.add(new RedAppleDrop());
			}
			//drop golden apple if random number is 10 JZ
			if(randomDrop == 9) {
				goldenApple = true;

				items.add(new GoldenAppleDrop());
			}

		}
		//draw everything in item arraylist SS
		for(int i= 0; i< items.size();i++){
			items.get(i).myDraw(g);
			//if items go past 750, remove the item from arraylist SS
			if(items.get(i).getY()>750){
				items.remove(i);
			}
		}

	}
	//get the item type (eg, apple, shotgun, ar) SS
	public static String getHitItem(int i ){
		return items.get(i).getItem();
	}

	//get the hitbox of the item SS
	public static Rectangle getBox(int i){
		return items.get(i).getRect();
	}

	//check if key is pressed
	public void keyPressed(KeyEvent e){

		int key =e.getKeyCode();
		//movement SS

		//hitting d or a will make right and left true, respectively SS
		if(key==KeyEvent.VK_D){
			right=true;

		}
		if(key==KeyEvent.VK_A){
			left=true;
		}
		//pressing w and if the character is not already falling will make character jump  SS

		if(key==KeyEvent.VK_W && joe.getGravAct()==false){
			//set the character ground position (tempy) SS
			joe.setTempy();
			//make jump and selfd to true SS
			//selfd makes sure that the character does not go up and down forever
			jump=true;
			selfd=true;



		}
		//movement for character 2 SS

		//pressing left or right arrow will make character move left and right respectively SS
		if(key==KeyEvent.VK_LEFT){
			left2=true;
		}
		if(key==KeyEvent.VK_RIGHT){
			right2=true;
		}

		//same jump logic as character 1 SS
		if(key==KeyEvent.VK_UP&& mama.getGravAct()==false){

			mama.setTempy();
			jump2=true;
			selfd2=true;
		}
		//Character 1 shoot SS

		if(key==KeyEvent.VK_SPACE) {
			//depending on which gun is being held, character will shoot differently SS

			if(joe.getIsAr()){
				shootAr=true;
				shootGun=false;
				shootShot=false;
			}

			if(joe.getIsGun()){
				shootGun=true;
				shootAr=false;
				shootShot=false;

			}
			if(joe.getIsShotty()){
				shootShot=true;
				shootGun=false;
				shootAr=false;

			}
			//if shoot key is pressed, set switched to false SS
			joe.setSwitched(false);
		}
		//character 2 shoot, same logic as character 1 shoot SS
		if(key==KeyEvent.VK_ENTER) {
			if(mama.getIsAr()){
				shootAr2=true;
				shootGun2=false;
				shootShot2=false;

			}
			if(mama.getIsGun()){
				shootGun2=true;
				shootAr2=false;
				shootShot2=false;

			}
			if(mama.getIsShotty()){
				shootShot2=true;
				shootGun2=false;
				shootAr2=false;

			}
			mama.setSwitched(false);

		}

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==timer) {
			//increment the count for shot SS
			countShot++;
			countShot2++;
			countGun++;
			countGun2++;
			countAr++;
			countAr2++;
			countTime++;
			//check if players intersect SS
			if(toRect(joe).intersects(toRect(mama))) {
				//if p1 in front of p2, p1 move forward and p2 move back (make sure diff is always positive) SS
				//make it move back by how much the characters intersect
				if(joe.getX()>=mama.getX()) {
					int diff = (mama.getX()+50)-joe.getX();
					joe.setX(joe.getX()+diff/2);
					mama.setX(mama.getX()-diff/2);

				}
				//if p2 in front of p1, p1 move back and p2 move forward SS
				if(joe.getX()<=mama.getX()) {
					int diff = (joe.getX()+50)-mama.getX();
					joe.setX(joe.getX()-diff/2);
					mama.setX(mama.getX()+diff/2);

				}

			}
			//guns can't shoot if character has switched and hasn't let go of space SS
			//you will stop shooting if you hold space and switch guns
			if(joe.getSwitched()){
				shootAr=false;
				shootGun=false;
				shootShot=false;
			}
			if(mama.getSwitched()){
				shootAr2=false;
				shootGun2=false;
				shootShot2=false;
			}

			//check if a bullet hits players JZ
			
			//Player 1's pistol bullets
			for(int i =0 ;i < joe.getGun().getBullet().size();i++){
				if(((Projectile)joe.getGun().getBullet().get(i)).getProj().intersects(toRect(mama))){
					joe.getGun().getBullet().remove(i);
					mama.setHp(mama.getHp()-2);
				}
			}

			//Player 2's pistol bullets
			for(int i =0 ;i < mama.getGun().getBullet().size();i++){
				if(((Projectile)mama.getGun().getBullet().get(i)).getProj().intersects(toRect(joe))){
					mama.getGun().getBullet().remove(i);
					joe.setHp(joe.getHp()-2);;
				}
			}

			//Player 1's AR bullets
			for(int i =0 ;i < joe.getAr().getBullet().size();i++){
				if(((Projectile)joe.getAr().getBullet().get(i)).getProj().intersects(toRect(mama))){
					joe.getAr().getBullet().remove(i);
					mama.setHp(mama.getHp()-1);
				}
			}

			//Player 2's AR bullets
			for(int i =0 ;i < mama.getAr().getBullet().size();i++){
				if(((Projectile)mama.getAr().getBullet().get(i)).getProj().intersects(toRect(joe))){
					mama.getAr().getBullet().remove(i);
					joe.setHp(joe.getHp()-1);;
				}
			}

			//Player 1's Shotgun bullets
			for(int i =0 ;i < joe.getShot().getBullet().size();i+=3){
				
				if(((Projectile)joe.getShot().getBullet().get(i)).getProj().intersects(toRect(mama))){
					//shotgun bullets are not removed, they are set off screen
					//once all three bullets are off screen, they will be removed
					//avoids stack overflow
					((Projectile) joe.getShot().getBullet().get(i)).setY();
					mama.setHp(mama.getHp()-3);
				}
				if(((Projectile)joe.getShot().getBullet().get(i+1)).getProj().intersects(toRect(mama))){
					((Projectile) joe.getShot().getBullet().get(i+1)).setY();
					mama.setHp(mama.getHp()-3);
				}
				if(((Projectile)joe.getShot().getBullet().get(i+2)).getProj().intersects(toRect(mama))){
					((Projectile) joe.getShot().getBullet().get(i+2)).setY();
					mama.setHp(mama.getHp()-3);
				}
			}

			//Player 2's shotgun bullets
			for(int i =0 ;i < mama.getShot().getBullet().size();i+=3){
				if(((Projectile)mama.getShot().getBullet().get(i)).getProj().intersects(toRect(joe))){
					((Projectile) mama.getShot().getBullet().get(i)).setY();
					joe.setHp(joe.getHp()-3);;
				}
				if(((Projectile)mama.getShot().getBullet().get(i+1)).getProj().intersects(toRect(joe))){
					((Projectile) mama.getShot().getBullet().get(i+1)).setY();
					joe.setHp(joe.getHp()-3);;
				}
				if(((Projectile)mama.getShot().getBullet().get(i+2)).getProj().intersects(toRect(joe))){
					((Projectile) mama.getShot().getBullet().get(i+2)).setY();
					joe.setHp(joe.getHp()-3);;
				}
			}


			//characters move SS
			joe.myMove();
			mama.myMove();

			//check if character should move left or right SS
			//in action performed and not in key listener so multiple buttons can be pressed and makes movement smoother
			if(right){
				joe.moveRight();

			}
			if(left){
				joe.moveLeft();
			}
			if(jump){

				//make joe go up to certain limit, then move down. (tempy is joe's ground height (initial height when space is pressed))SS
				if(!(joe.getY()<=joe.getTempy()-200) && selfd){
					joe.yAdd();


				}else{
					//selfd makes sure that when character hits limit, it will go down until it hits the ground SS
					//without this, the square will go up and down forever(because once the square goes below limit, it will go back up) SS
					selfd=false;
				}

			}
			//check movement for second character SS
			if(right2){

				mama.moveRight();

			}
			if(left2){

				mama.moveLeft();
			}
			//same jump logic as character 1 SS
			if(jump2){
				if(!(mama.getY()<=mama.getTempy()-200) && selfd2){
					mama.yAdd();

				}else{

					selfd2=false;
				}
			}
			//Ar fire rate (Every 15 ticks, you can shoot). You can hold down as well SS
			if(countAr%15==0){

				if(shootAr){
					joe.arshoot();

				}else{
					//makes sure that you don't have to press the button exactly at 15 ticks 
					//if 15 ticks passes, you can shoot immediately when you press the key 

					//we had to have different shoot counts because of this
					countAr--;
				}
			}
			//pistol fire rate
			if(countGun%35==0){
				if(shootGun){
					joe.gunShoot();
				}else{
					countGun--;
				}
			}
			//shotgun fire rate
			if(countShot%50==0){
				if(shootShot){
					joe.shotShoot();
				}else{
					countShot--;
				}
			}

			//check for second character shoot (same rules as the first character) SS
			if(countAr2%15==0){
				if(shootAr2){

					mama.arshoot();

				}else{
					countAr2--;
				}
			}

			if(countGun2%35==0){
				if(shootGun2){

					mama.gunShoot();
				}else{
					countGun2--;
				}
			}
			if(countShot2%50==0){
				if(shootShot2){
					mama.shotShoot();
				}else{
					countShot2--;
				}
			}

			//if hp is 0 for any player, load death screen JZ
			if((mama.getHp()<=0 || joe.getHp() <= 0) && restart ==0){
				
				timer.stop();
				//Load deathscreen
				new DeathScreen(joe.getHp(), mama.getHp());

				//dispose of the game screen SS
				SwingUtilities.getWindowAncestor(this).dispose();
				//restart makes sure this only happens once SS
				//without it, deathscreens will pop up forever because hp<0
				restart++;

			}

			repaint();

		}


	}


	//turn maincharacter into a rectangle (for intersection) SS
	public Rectangle toRect(MainCharacter dad) {
		Rectangle h = new Rectangle(dad.getX(),dad.getY(),50,50);
		return h;
	}

	//getter for items SS
	public static ArrayList getItems(){
		return items;
	}

	//get the current map JZ
	public static int getMap() {
		return map;
	}

	//start game if mouse enters, stop game if mouse leaves
	public void mouseEntered(MouseEvent me) {	
		timer.start();
	}
	public void mouseExited(MouseEvent me) {
		timer.stop();	
	}

	public void mouseClicked(MouseEvent me) {	}

	public void mousePressed(MouseEvent me) {

	}
	public void mouseReleased(MouseEvent me) {}


	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {

	}

	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	//check for key released SS
	public void keyReleased(KeyEvent e) {
		int key =e.getKeyCode();

		if(key==KeyEvent.VK_D){
			right=false;

		}
		if(key==KeyEvent.VK_A){
			left=false;
		}
		if(key==KeyEvent.VK_LEFT){
			left2=false;
		}
		if(key==KeyEvent.VK_RIGHT){
			right2=false;
		}
		if(key==KeyEvent.VK_SPACE){
			if(joe.getIsAr()){
				shootAr=false;
			}
			if(joe.getIsGun()){
				shootGun=false;
			}
			if(joe.getIsShotty()){
				shootShot=false;
			}

		}
		if(key==KeyEvent.VK_ENTER){
			if(mama.getIsAr()){
				shootAr2=false;
			}
			if(mama.getIsGun()){
				shootGun2=false;
			}
			if(mama.getIsShotty()){
				shootShot2=false;
			}
		}



	}



}