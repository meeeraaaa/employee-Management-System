package emp_manage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Locale;
public class Generate_PaySlip extends JFrame implements ActionListener{
    JFrame f;
    JLabel l,h,id1,id2,id3,id5,id4,id7,id6;
    JLabel aid1,aid2,aid3,aid5,aid4,aid7,aid6;
    String name,fname,eid,pno,mail,adhar,edu,post,salary,age,addr,dob;
    JButton b1,b2 ;
    Generate_PaySlip(){
        f=new JFrame("Generate PaySlip");
        
        l=new JLabel();
        l.setBounds(0,0,595,640);
        l.setLayout(null);
        
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("emp_manage/icons/gpsbg.jpg"));
        Image img=ic.getImage().getScaledInstance(280,80,Image.SCALE_DEFAULT);
        ImageIcon i = new ImageIcon(img);
        l.setIcon(i);
        
    }
    public static void main(String args[]){
        new Generate_PaySlip();
        
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            f.setVisible(false);
            new HomePage();
        }
        if(e.getSource()==b2){
            f.setVisible(false);
            new View_Employee();
        }
    }
}
