import java.awt.*;
import javax.swing.*;

import org.omg.CORBA.SetOverrideType;

import java.awt.event.*;


public class score extends JFrame implements ActionListener{
    score(String username, int score){
        setBounds(300,140,750,550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,200,300,250);
        add(image);

        JLabel Score = new JLabel("Your Score is "+score);
        Score.setBounds(350,200,300,30);
        Score.setFont(new Font("Tahoma",Font.BOLD,24));  
        add(Score);

        JButton play = new JButton("Play Again");
        play.setBounds(380,270,120,30);
        play.setBackground(Color.BLUE);
        play.setForeground(Color.white);
        play.addActionListener(this);
        add(play);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new login();

    }
    public static void main(String args[]){
        new score("Yo Mama",0);
    }
}
   