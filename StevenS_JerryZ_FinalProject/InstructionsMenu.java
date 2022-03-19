// Jerry Zeng and Steven Shi
// April 12, 2021
// Final Project Instructions Menu Class JZ
// ICS3U7 Ms. Strelkovska

//Java imports
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class InstructionsMenu
//made by jz
{
	// Instructions Menu Constructor
    public InstructionsMenu()
    {    
    	// Creating the frame
        JFrame frame = new JFrame("SUPER SQUARE BROS!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1350, 710);
        JPanel p = new JPanel();
        p.setLayout(null);
        
        //Background image
        JLabel background;
        ImageIcon img = new ImageIcon("InstructionsBackground.jpg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1350, 710);
        
        //Instructions Title
        JLabel title = new JLabel("test");
        title.setFont(new Font("Impact", Font.PLAIN, 50));
        title.setForeground(Color.white);
        title.setText("INSTRUCTIONS!");
        title.setBounds(560, 75, 600, 50);

        //Back button
        JButton button = new JButton("BACK");
        button.setBounds(25, 625, 120, 30);

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
        p.add(background);
        
        frame.add(p);

        frame.setVisible(true);
        
    }



}