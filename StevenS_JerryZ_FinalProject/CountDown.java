// Jerry Zeng and Steven Shi
// April 12, 2021
// Final Project Countdown Class JZ
// ICS3U7 Ms. Strelkovska

//Java imports
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

//made by jerry
public class CountDown{
	//Declaring instance Variables
	private Timer timer;
	private JLabel title;
	private JFrame frame;
	private int map;
	private Color player1, player2;
	private int seconds;
	private ImageIcon img;
	
	//Constructor
	public CountDown(int map, Color player1, Color player2) {
		
		//Assigning instance variables
		this.map = map;
		this.player1 = player1;
		this.player2 = player2;
		seconds = 3;
		//calls the timerdraw method
		timerDraw();
		//Starts the timer
		timer.start();
				
		//Create frame
		frame = new JFrame("SUPER SQUARE BROS!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1350, 710);
		JPanel p = new JPanel();
		p.setLayout(null);
    
		//Background image
		JLabel background;
		if(map == 0) {
			img = new ImageIcon("background.png");

		}
		if(map == 1) {
			img = new ImageIcon("background2.png");

		}
		if(map == 2) {
			img = new ImageIcon("background3.png");

		}
		background = new JLabel("", img, JLabel.CENTER);
		background.setBounds(0, 0, 1350, 710);
    
		//Displaying get ready
		title = new JLabel("GET READY!");
		title.setFont(new Font("Impact", Font.PLAIN, 100));
		title.setForeground(Color.black);
		title.setBounds(475, 300, 600, 100);
		
		//Adding elements to frame
		p.add(title);
        p.add(background);
        
        frame.add(p);

        frame.setVisible(true);

	}
	
	//timerDraw method to draw countdown timer before game starts
	public void timerDraw() {
		
		//Initialize timer to tick every 750 millisec
		timer = new Timer(750, new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Displaying 3,2,1,Fight!
				title.setBounds(675, 300, 600, 100);
				title.setText("" + seconds);
				
				if(seconds < 1) {
					title.setBounds(575, 300, 600, 100);
					title.setText("FIGHT!");
				}
				if(seconds < 0) {
					frame.dispose();
					new MyFrame("SUPER SQUARE BROS!", map, player1, player2);
					timer.stop();
				}
				
				//Decrement seconds
				seconds--;
			}
		});
		
	}
}