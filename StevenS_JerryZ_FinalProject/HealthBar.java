// Jerry Zeng and Steven Shi
// April 12, 2021
// Final Project Health Bar and Ammo count Class JZ
// ICS3U7 Ms. Strelkovska

//Java imports
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;

//made by jz
public class HealthBar {
	
	public HealthBar() {
		
	}
	
	//Drawing the health bar and player
	public void myDrawHP(Graphics g, int num, int hp, Color colour) {
		if(num == 1) {
			//Setting text for player 1
			g.setFont(new Font("Impact", Font.PLAIN, 50));
			g.setColor(Color.black);
			g.drawString("PLAYER 1", 50, 150);
			//Setting square colour for player1
			g.setColor(colour);
			g.fillRect(250,100,50,50);

			//Creating health bar that changes colour as hp decreases/increases
			if(hp>6) {
				g.setColor(Color.green);
				g.fillRect(50, 50, hp*25, 50);
			}
			else if(hp>3 && hp<7) {
				g.setColor(Color.yellow);
				g.fillRect(50, 50, hp*25, 50);
			}
			else {
				g.setColor(Color.red);
				g.fillRect(50, 50, hp*25, 50);
			}
			
			//Displaying amount of health for player 1
			g.setColor(Color.black);
			g.drawString(hp*10 + ("%"), 50, 95);
			
		}
		if(num == 2) {
			//Setting text for player 2
			g.setFont(new Font("Impact", Font.PLAIN, 50));
			g.setColor(Color.black);
			g.drawString("PLAYER 2", 1050, 150);
			//Setting square colour for player2
			g.setColor(colour);
			g.fillRect(1250, 100, 50, 50);
			
			//Creating health bar that changes colour as hp decreases/increases 
			if(hp>6) {
				g.setColor(Color.green);
				g.fillRect(1050, 50, hp*25, 50);
			}
			else if(hp>3 && hp<7) {
				g.setColor(Color.yellow);
				g.fillRect(1050, 50, hp*25, 50);
			}
			else {
				g.setColor(Color.red);
				g.fillRect(1050, 50, hp*25, 50);
			}
			
			//Displaying amount of health for player 2
			g.setColor(Color.black);
			g.drawString(hp*10 + ("%"), 1050, 95);

		}
	}
	
	//Drawing the ammo count
	public void myDrawAmmo(Graphics g, int playerNum, int gunNum, int ammo) {
		g.setFont(new Font("Impact", Font.PLAIN, 50));
		g.setColor(Color.black);	
		if(ammo<0) {
			ammo=0;
		}
		//Displaying different ammo capacity for different guns for player 1
		if(playerNum == 1) {
			if(gunNum == 0) {
				g.drawString("AMMO: " + ammo + "/12", 50, 200);
			}
			if(gunNum == 1) {
				g.drawString("AMMO: " + ammo/3 + "/8", 50, 200);
			}
			if(gunNum == 2) {
				g.drawString("AMMO: " + ammo + "/20", 50, 200);
			}
		}
		//Displaying different ammo capacity for different guns for player 2
		if(playerNum == 2) {
			if(gunNum == 0) {
				g.drawString("AMMO: " + ammo + "/12", 1050, 200);
			}
			if(gunNum == 1) {
				g.drawString("AMMO: " + ammo/3 + "/8", 1050, 200);
			}
			if(gunNum == 2) {
				g.drawString("AMMO: " + ammo + "/20", 1050, 200);
			}
		}
	}
}
