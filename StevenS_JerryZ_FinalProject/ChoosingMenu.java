// Jerry Zeng and Steven Shi
// April 12, 2021
// Final Project Choosing map Class JZ
// ICS3U7 Ms. Strelkovska

//Java imports
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
//made by jerry
public class ChoosingMenu
{
	//Constructor
    public ChoosingMenu(Color player1, Color player2)
    { 
    	//Creating frame
        JFrame f = new JFrame("SUPER SQUARE BROS!");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1350, 710);
        JPanel p = new JPanel();
        p.setLayout(null);
        
        //Background image
        JLabel background;
        ImageIcon img = new ImageIcon("MapBackground.jpeg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1350, 710);
        
        //Title of the Menu Screen
        JLabel title = new JLabel("test");
        title.setFont(new Font("Impact", Font.PLAIN, 50));
        title.setForeground(Color.black);
        title.setText("CHOOSE YOUR MAP!");
        title.setBounds(510, 100, 450, 50);

        
        //MAP 1
        JButton button = new JButton("IONIA");
        //button.addActionListener(bHandler);
        button.setBounds(625,225,160,40);

        //MAP 2
        JButton button2 = new JButton("SHURIMA");
        //button2.addActionListener(bHandler);
        button2.setBounds(625,300,160,40);

        //MAP 3
        JButton button3 = new JButton("FREJLORD");
        //button3.addActionListener(bHandler);
        button3.setBounds(625,375,160,40);
        
        //Back button
        JButton button4 = new JButton("BACK");
        button4.setBounds(50, 600, 120, 30);
        
        //Adding actionListeners to buttons
        //Passes both chosen colours and chosen map to next class
        button.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            { 
            	f.dispose();
                new CountDown(0, player1, player2);
            } 
        });

        button2.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            { 
            	f.dispose();
                new CountDown(1, player1, player2);
            } 
        });

        button3.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            { 
            	f.dispose();
                new CountDown(2, player1, player2);
            } 
        });
        
        button4.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            { 
            	f.dispose();
                new Player2Colour(player1);
            } 
        });


        //Adding every element to frame
        p.add(title);
        p.add(button);
        p.add(button2);
        p.add(button3);
        p.add(button4);
        p.add(background);
        
        f.add(p);

        f.setVisible(true);
    }
    
}