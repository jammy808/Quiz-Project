import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class proceed extends JFrame implements ActionListener{
    JButton start,back;
    String name;
    proceed(String name){
        this.name =name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Konichiwa "+name+" to my Quiz");
        heading.setBounds(50,20,700,30);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,28));
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(20,90,700,350);
        rules.setFont(new Font("Tahoma",Font.PLAIN,16));
        rules.setText(
            "<html>"+
            "Aree ee vedya"+"<br><br>"+
            "<html>"
        );
        add(rules);

        back = new JButton("Back");
        back.setBounds(250,500,100,30);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        start = new JButton("Let's Go!");
        start.setBounds(400,500,100,30);
        start.setBackground(Color.BLUE);
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);

        setSize(800,650);
        setLocation(350,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==start){
            setVisible(false);
            new quiz(name);
        }
        else if(e.getSource()==back){
            setVisible(false);
            new login();
        }
    }
 public static void main(String args[]){
    new proceed("Baka");
 }
}
