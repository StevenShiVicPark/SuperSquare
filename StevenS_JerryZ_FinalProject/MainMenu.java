// Jerry Zeng and Steven Shi
// April 12, 2021
// Final Project Main Menu Class JZ
// ICS3U7 Ms. Strelkovska

//Java imports
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

//made by jz
public class MainMenu
{
	//Main Menu Constructor
    public MainMenu()
    { 
    	
    	//Creating the frame
        JFrame f = new JFrame("SUPER SQUARE BROS!");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1350, 710);
        JPanel p = new JPanel();
        p.setLayout(null);
        
        //Background image
        JLabel background;
        ImageIcon img = new ImageIcon("MainBackground.jpg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1350, 710);
        
        //Title of the Menu Screen
        JLabel title = new JLabel("test");
        title.setFont(new Font("Impact", Font.PLAIN, 100));
        title.setForeground(Color.white);
        title.setText("SUPER SQUARE BROS!");
        title.setBounds(275, 75, 900, 100);

        
        //Start button
        JButton button = new JButton("START");
        button.setBounds(225,275,160,40);

        //Instructions button
        JButton button2 = new JButton("INSTRUCTIONS");
        button2.setBounds(225,350,160,40);

        //Credits button
        JButton button3 = new JButton("CREDITS");
        button3.setBounds(225,425,160,40);

        //Exit button
        JButton button4 = new JButton("QUIT");
        button4.setBounds(225,500,160,40);
        
        //Adding actionListeners to buttons
        button.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            { 
            	f.dispose();
                new Player1Colour();
            } 
        });

        button2.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            {
                f.dispose();
                new InstructionsMenu();
            } 
        });

        button3.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            { 
            	f.dispose();
                new CreditsMenu();
            } 
        });

        button4.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            { 
                 f.dispose();
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