// Jerry Zeng and Steven Shi
// April 12, 2021
// Final Project Player 2 Colour Class JZ
// ICS3U7 Ms. Strelkovska

//Java imports
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
//made by JZ
public class Player2Colour
{

	//Constructor
    public Player2Colour(Color color)
    { 
    	//Creating frame
        JFrame f = new JFrame("SUPER SQUARE BROS!");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1350, 710);
        JPanel p = new JPanel();
        p.setLayout(null);
        
        //Background image
        JLabel background;
        ImageIcon img = new ImageIcon("carbonfiber.jpg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1350, 710);
        
        //Title of the Menu Screen
        JLabel title = new JLabel("test");
        title.setFont(new Font("Impact", Font.PLAIN, 50));
        title.setForeground(Color.white);
        title.setText("PLAYER 2 CHOOSE YOUR COLOUR!");
        title.setBounds(400, 100, 700, 50);

        
        //BLUE
        JButton button = new JButton("BLUE");
        //button.addActionListener(bHandler);
        button.setBounds(625,200,160,40);

        //RED
        JButton button2 = new JButton("RED");
        //button2.addActionListener(bHandler);
        button2.setBounds(625,275,160,40);

        //PINK
        JButton button3 = new JButton("PINK");
        //button3.addActionListener(bHandler);
        button3.setBounds(625,350,160,40);
        
        //YELLOW
        JButton button4 = new JButton("YELLOW");
        button4.setBounds(625, 425, 160, 40);
        
        //CYAN
        JButton button5 = new JButton("CYAN");
        button5.setBounds(625, 500, 160, 40);
        
        //ORANGE
        JButton button6 = new JButton("ORANGE");
        button6.setBounds(625, 575, 160, 40);
        
        //Back button
        JButton button7 = new JButton("BACK");
        button7.setBounds(50, 600, 120, 30);
        
        //Adding actionListeners to buttons
        //Passes both chosen colours through to next class
        button.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            { 
            	f.dispose();
                new ChoosingMenu(color, Color.blue);
            } 
        });

        button2.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            {
                f.dispose();
                new ChoosingMenu(color, Color.red);
            } 
        });

        button3.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            { 
            	f.dispose();
                new ChoosingMenu(color, Color.magenta);
            } 
        });
        
        button4.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            { 
            	f.dispose();
                new ChoosingMenu(color, Color.yellow);
            } 
        });
        
        button5.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            { 
            	f.dispose();
                new ChoosingMenu(color, Color.cyan);
            } 
        });
        
        button6.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            { 
            	f.dispose();
                new ChoosingMenu(color, Color.orange);
            } 
        });

        button7.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            { 
            	f.dispose();
                new Player1Colour();
            } 
        });

        //Adding every element to frame
        p.add(title);
        p.add(button);
        p.add(button2);
        p.add(button3);
        p.add(button4);
        p.add(button5);
        p.add(button6);
        p.add(button7);
        p.add(background);
        
        f.add(p);

        f.setVisible(true);
    }
    
}