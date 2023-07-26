import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class quiz extends JFrame implements ActionListener{
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    JLabel qno,question;
    JRadioButton op1,op2,op3,op4;
    ButtonGroup groupop;
    String uanswers[][] = new String[10][1];
    JButton submit,next,lifeline;

    public static int  timer =15 ;
    public static int ans_given = 0;
    public static int c=0;
    public static int score =0;
    String username;

    quiz(String username){
        this.username =username; 
        setBounds(0,0,1440,850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1440,392);
        add(image);
        
        qno = new JLabel();
        qno.setBounds(100,450,900,30);
        qno.setFont(new Font("Tahoma",Font.PLAIN,24));  
        add(qno);

        question = new JLabel();
        question.setBounds(150,450,900,30);
        question.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(question); 

        questions[0][0]= "Naruto's first justu ?";
        questions[0][1]="shadow clone";
        questions[0][2]="rasengan";
        questions[0][3]="byakugan";
        questions[0][4]="your mother";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";


        answers[0][1] = "your mother";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

        op1 = new JRadioButton();
        op1.setBounds(170,520,700,30);
        op1.setBackground(Color.WHITE);
        op1.setFont(new Font("Dialog",Font.PLAIN,20));
        add(op1);

        op2 = new JRadioButton();
        op2.setBounds(170,560,700,30);
        op2.setBackground(Color.WHITE);
        op2.setFont(new Font("Dialog",Font.PLAIN,20));
        add(op2);

        op3 = new JRadioButton();
        op3.setBounds(170,600,700,30);
        op3.setBackground(Color.WHITE);
        op3.setFont(new Font("Dialog",Font.PLAIN,20));
        add(op3);

        op4 = new JRadioButton();
        op4.setBounds(170,640,700,30);
        op4.setBackground(Color.WHITE);
        op4.setFont(new Font("Dialog",Font.PLAIN,20));
        add(op4);

        groupop= new ButtonGroup();
        groupop.add(op1);
        groupop.add(op2);
        groupop.add(op3);
        groupop.add(op4);

        next = new JButton("Next");
        next.setBounds(1100,490,200,40);
        next.setFont(new Font("Tahoma",Font.PLAIN,22));
        next.setBackground(Color.BLUE);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100,570,200,40);
        lifeline.setFont(new Font("Tahoma",Font.PLAIN,22));
        lifeline.setBackground(Color.BLUE);
        lifeline.setForeground(Color.white);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(1100,650,200,40);
        submit.setFont(new Font("Tahoma",Font.PLAIN,22));
        submit.setBackground(Color.BLUE);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        setVisible(true);

        start(c);

    }
     public void actionPerformed(ActionEvent e){
       if(e.getSource()==next){
        repaint();
        op1.setEnabled(true);
        op2.setEnabled(true);
        op3.setEnabled(true);
        op4.setEnabled(true);
        ans_given =1;
        if(groupop.getSelection()==null){
                uanswers[c][0]="";
            }
            else{
                uanswers[c][0] = groupop.getSelection().getActionCommand();        
            }
        if(c==8){
            next.setEnabled(false);
            submit.setEnabled(true);                        
        }
        c++;
        start(c);
       }
       else if(e.getSource()==lifeline){
         if(c==2||c==4||c==6||c==8||c==9){
            op2.setEnabled(false);
            op3.setEnabled(false);
         }
         else{
            op1.setEnabled(false);
            op4.setEnabled(false);
         }
         lifeline.setEnabled(false);
       }
       else if(e.getSource()==submit){
            ans_given =1;
              if(groupop.getSelection()==null){
                 uanswers[c][0]="";
                }
                else{
                 uanswers[c][0] = groupop.getSelection().getActionCommand();        
                }
            for(int i =0;i<uanswers.length;i++){
                if(uanswers[i][0].equals(answers[i][1])){
                    score += 10;
                } 
            }
            setVisible(false);
            new score(username,score);
       }
     }

     public void paint(Graphics g){
        super.paint(g);
        String time = "Time left "+timer+" sec";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma",Font.BOLD,25));

        if(timer>0){
            g.drawString(time,1100,500);
        }
        else{
             g.drawString("Time's UP!!",1100,500);
        }
        timer--;

        try{
            Thread.sleep(1000);
            repaint();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        if(ans_given == 1){
            ans_given = 0;
            timer=15;
        }
        else if(timer<0){
            timer =15;
            op1.setEnabled(true);
            op2.setEnabled(true);
            op3.setEnabled(true);
            op4.setEnabled(true);
            
            if(c==8){
            next.setEnabled(false);
            submit.setEnabled(true);                        
            }
            if(c==9){                       //submit button
                if(groupop.getSelection()==null){
                 uanswers[c][0]="";
                }
                else{
                 uanswers[c][0] = groupop.getSelection().getActionCommand();        
                }
            for(int i =0;i<uanswers.length;i++){
                if(uanswers[i][0].equals(answers[i][1])){
                    score += 10;
                }
            setVisible(false);
            new score(username,score);

            }
            }
            else{                           //next button
                if(groupop.getSelection()==null){
                uanswers[c][0]="";
            }
            else{
                uanswers[c][0] = groupop.getSelection().getActionCommand();        
            }
            c++;
            start(c);
            }
            
        }
     }
    public void start(int c){
        qno.setText(""+(c+1)+")");
        question.setText(questions[c][0]);

        op1.setText(questions[c][1]);
        op1.setActionCommand(questions[c][1]);

        op2.setText(questions[c][2]);
        op2.setActionCommand(questions[c][2]);

        op3.setText(questions[c][3]);
        op3.setActionCommand(questions[c][3]);

        op4.setText(questions[c][4]);
        op4.setActionCommand(questions[c][4]);

        groupop.clearSelection();
    }

    public static void main(String args[]){
        new quiz("Daddy");
    }
}
