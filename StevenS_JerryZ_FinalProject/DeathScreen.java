// Jerry Zeng and Steven Shi
// April 12, 2021
// Final Project DeathScreen Class JZ
// ICS3U7 Ms. Strelkovska

//Java imports
import java.awt.event.*;

import java.awt.*;
import javax.swing.*;

//made by jerry
public class DeathScreen {
	
	//Constructor
    public DeathScreen(int player1Hp, int player2Hp) {    
    	//Creating frame
        JFrame frame = new JFrame("SUPER SQUARE BROS!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1350, 710);
        JPanel p = new JPanel();
        p.setLayout(null);
        
        //Background image
        JLabel background;
        ImageIcon img = new ImageIcon("carbonfiber.jpg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1350, 710);
        
        //Fireworks
        JLabel fireworks;
        ImageIcon fireworksimg = new ImageIcon("fireworks.png");
        fireworks = new JLabel("", fireworksimg, JLabel.CENTER);
        fireworks.setBounds(0, 0, 1350, 710);
        
        JLabel title = new JLabel("test");
        title.setFont(new Font("Impact", Font.PLAIN, 50));
        title.setForeground(Color.white);
        
        //Displaying which player won the game
		if(player2Hp <= 0 && player1Hp>0) {
	        title.setText("PLAYER 1 HAS WON!");
	        title.setBounds(530, 300, 600, 50);

		}
		if(player1Hp <= 0 && player2Hp>0) {
	        title.setText("PLAYER 2 HAS WON!");
	        title.setBounds(530, 300, 600, 50);
			
		}
		if(player1Hp <= 0 && player2Hp<=0) {
	        title.setText("BOTH PLAYERS HAVE DIED");
	        title.setBounds(530, 300, 600, 50);
			
		}

        //RESTART BUTTON
        JButton button = new JButton("RESTART");
        button.setBounds(625, 600, 160, 40);

        //Adding actionListeners to buttons
        button.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                frame.dispose();
                new MainMenu();
            } 
        });

        //Adding every element to frame
        p.add(title);
        p.add(button);
        p.add(fireworks);
        p.add(background);
        
        frame.add(p);

        frame.setVisible(true);
        
    }



}