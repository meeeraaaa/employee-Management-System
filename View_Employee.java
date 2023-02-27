package emp_manage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Locale;
public class View_Employee extends JFrame implements ActionListener{
    JFrame f;JLabel l1,l2;JTextField t;JButton b1,b2;
    View_Employee(){
        
        Font fnt =new Font("Ariel",Font.BOLD,30);

                 
        f=new JFrame ("view Employee");
        f.setLayout(null);
        
        l1=new JLabel();
        l1.setBounds(0,0,570,320);
        l1.setLayout(null);
        
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("emp_manage/icons/vebg1.jpg"));
        Image img=ic.getImage().getScaledInstance(500,280,Image.SCALE_DEFAULT);
        ImageIcon i = new ImageIcon(img);
        l1.setIcon(i);
        
        l2=new JLabel("Employee Id");
        l2.setVisible(true);
        l2.setBounds(40,90,250,30);
        l2.setForeground(Color.black);
        l2.setFont(fnt);
        
        l1.add(l2);
        f.add(l1);
        
        b1=new JButton("Search");
        //b1.setForeground(Color.gray);
        b1.setBounds(140,200,100,30);
        l1.add(b1);
        
         b2=new JButton("Cancel");
        b2.setBackground(Color.red);b2.setForeground(Color.white);
        b2.setBounds(260,200,100,30);
        l1.add(b2);
        
        b1.addActionListener(this);b2.addActionListener(this);
        
        t=new JTextField();
        t.setBounds(250,90,220,30);
        l1.add(t);
        
        f.setVisible(true);
        f.setSize(510,340);
        f.setLocation(500,200);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            f.setVisible(false);
            new View_Employee_Data(t.getText( ));
            
        }
        else if(e.getSource()==b2)
        {
            f.setVisible(false);
                new HomePage();
        }
    }
    public static void main(String args[]){
        new View_Employee();
    }
    
    
}
