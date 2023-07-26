import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.FormattableFlags;
public class login extends JFrame implements ActionListener {
    JButton proceed,back;
    JTextField field;
    login(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,600,500);
        add(image);

        JLabel heading = new JLabel("Jammy's QUiz");
        heading.setBounds(750,60,300,45);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,40));
        add(heading);

        JLabel name = new JLabel("YOUR NAME");
        name.setBounds(810,150,300,20);
        name.setForeground(Color.BLACK);
        name.setFont(new Font("Mongolion Baiti",Font.BOLD,20));
        add(name);

        field = new JTextField();
        field.setBounds(735,200,300,25);
        field.setFont(new Font("Times New Romab",Font.BOLD,20));
        add(field);

        proceed = new JButton("Proceed");
        proceed.setBounds(735,270,120,25);
        proceed.setBackground(Color.BLUE);
        proceed.setForeground(Color.WHITE);
        proceed.addActionListener(this);
        add(proceed);

        back = new JButton("Back");
        back.setBounds(915,270,120,25);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(1200,500);
        setLocation(90,150);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
      if(e.getSource()==proceed){
        String name = field.getText();
        setVisible(false);
        new proceed(name);
        
      }
      else if(e.getSource()==back){
        setVisible(false);
      }
    }

    public static void main(String args[]){
    new login();
    }
}
