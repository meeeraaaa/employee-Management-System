package emp_manage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Add_Employee extends JFrame implements ActionListener{
    JLabel l1,l,id1,id2,id3,id5,id4,id7,id8,id9,id10,id11,id12,id6;
        JFrame f;
        JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
        JButton b1,b2;
        Add_Employee(){
        f=new JFrame("Add Employee");f.setBackground(Color.black);f.setLayout(null);
       
        l=new JLabel();
        l.setBounds(0,0,900,600);
        l.setLayout(null);
        
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("emp_manage/icons/aebg.png"));
        Image img=ic.getImage().getScaledInstance(900,600,Image.SCALE_DEFAULT);
        ImageIcon i = new ImageIcon(img);
        JLabel l3=new JLabel(i);
        l.setIcon(i);
        
        l1=new JLabel("New Employee Details");
        l1.setForeground(Color.white);
        l1.setBounds(280,30,500,50);
        l1.setFont(new Font("Ariel",Font.BOLD,30));
        l.add(l1);
  
        id1=new JLabel("Name");//2
        id1.setBounds(50,150,150,30);
        id1.setFont(new Font("Ariel",Font.BOLD,20));
        id1.setForeground(Color.gray);
        l.add(id1);
        t1=new JTextField();
        t1.setBounds(200,150,150,30);
        l.add(t1);
        
        id2=new JLabel("Father's Name");//2
        id2.setBounds(450,150,200,30);
        id2.setFont(new Font("Ariel",Font.BOLD,20));
        id2.setForeground(Color.gray);
        l.add(id2);
        t2=new JTextField();
        t2.setBounds(600,150,150,30);
        l.add(t2);
        
        id3=new JLabel("Age");//3
        id3.setBounds(50,200,100,30);
        id3.setFont(new Font("Ariel",Font.BOLD,20));
        id3.setForeground(Color.gray);
        l.add(id3);
        t3=new JTextField();
        t3.setBounds(200,200,150,30);
        l.add(t3);
        
        id4=new JLabel("Date Of Birth");//4
        id4.setBounds(450,200,200,30);
        id4.setFont(new Font("Ariel",Font.BOLD,20));
        id4.setForeground(Color.gray);
        l.add(id4);
        t4=new JTextField();
        t4.setBounds(600,200,150,30);
        l.add(t4);
        
        id5=new JLabel("Address");//5
        id5.setBounds(50,250,100,30  );
        id5.setFont(new Font("Ariel",Font.BOLD,20));
        id5.setForeground(Color.gray);
        l.add(id5);
        t5=new JTextField();
        t5.setBounds(200,250,150,30);
        l.add(t5);
        
        id6=new JLabel("Phone Number");//6
        id6.setBounds(450,250,100,30);
        id6.setFont(new Font("Ariel",Font.BOLD,20));
        id6.setForeground(Color.gray);
        l.add(id6);
        t6=new JTextField();
        t6.setBounds(600,250,150,30);
        l.add(t6);
        
        id7=new JLabel("Email");//7
        id7.setBounds(50,300,100,30);
        id7.setFont(new Font("Ariel",Font.BOLD,20));
        id7.setForeground(Color.gray);
        l.add(id7);
        t7=new JTextField();
        t7.setBounds(200,300,150,30);
        l.add(t7);
        
        id8=new JLabel("Highest Education");//8
        id8.setBounds(450,300,100,30);
        id8.setFont(new Font("Ariel",Font.BOLD,20));
        id8.setForeground(Color.gray);
        l.add(id8);
        t8=new JTextField();
        t8.setBounds(600,300,150,30);
        l.add(t8);
        
        id9=new JLabel("Job Post");//9
        id9.setBounds(50,350,100,30  );
        id9.setFont(new Font("Ariel",Font.BOLD,20));
        id9.setForeground(Color.gray);
        l.add(id9);
        t9=new JTextField();
        t9.setBounds(200,350,150,30);
        l.add(t9);
        
        id10=new JLabel("Adhar No.");//10
        id10.setBounds(450,350,100,30);
        id10.setFont(new Font("Ariel",Font.BOLD,20));
        id10.setForeground(Color.gray);
        l.add(id10);
        t10=new JTextField();
        t1.setBounds(600,350,150,30);
        l.add(t10);
        f.add(l);
        
        id11=new JLabel("Employee Id");//11
        id11.setBounds(50,400,150,30);
        id11.setFont(new Font("Ariel",Font.BOLD,20));
        id11.setForeground(Color.gray);
        l.add(id11);
        t11=new JTextField();
        t11.setBounds(200,400,150,30);
        l.add(t11);
        
        b1=new JButton("Submit");
        b1.setBackground(Color.black);b1.setForeground(Color.gray);
        b1.setBounds(250,500,150,40);
        l.add(b1);
        
         b2=new JButton("Cancel");
        b2.setBackground(Color.red);b2.setForeground(Color.gray);
        b2.setBounds(450,500,150,40);
        l.add(b2);
        
        b1.addActionListener(this);b2.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(900,600);
        f.setLocation(300,100);
        
    }
    public void actionPerformed(ActionEvent e) {
        String name=t1.getText( );String fname=t2.getText( );
        String age=t3.getText( );String dob=t4.getText( );
        String addr=t5.getText( );String pno=t6.getText( );
        String mail=t7.getText( );String edu=t8.getText( );
        String post=t9.getText( );String adhar=t10.getText( );
        String eid=t11.getText( );
        
        if(e.getSource()==b1)
        {
            try{
                ConnectionClass dd=new ConnectionClass();
                String q="insert into employee values('"+name+"','"+fname+"','"+age+"','"+dob+"','"+addr+"','"+pno+"','"+mail+"','"+edu+"','"+post+"','"+adhar+"','"+eid+"');";
                dd.stm.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"details successfully inserted");
                f.setVisible(false);
                new HomePage();
            }
            catch(Exception exc){
                exc.printStackTrace();
            }
        }
        else if(e.getSource()==b2)
        {
            f.setVisible(false);
                new HomePage();
        }
    }
    public static void main(String args[]){
        new Add_Employee();
    }  
}
