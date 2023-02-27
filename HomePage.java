package emp_manage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Locale; 
 public class HomePage extends JFrame implements ActionListener{
     //JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
     Font f1,f2,f3;
     JPanel p1 ;
    HomePage(){
         super("Home page");
         setLocation(120,10);
         setSize(1300,800);
         
         f1 =new Font("Lucida Fax",Font.BOLD,28);
         f2 =new Font("Gadugi",Font.BOLD,20);
         f3 =new Font("MD UI Gothic",Font.BOLD,10);
         
         ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("emp_manage/icons/hpbg.png"));
         Image img=ic.getImage().getScaledInstance(1300,800,Image.SCALE_DEFAULT);
         ImageIcon i = new ImageIcon(img);
         JLabel l=new JLabel(i);
         
         JMenuBar m1= new JMenuBar();
         JMenu men1=new JMenu("Profile");
         JMenuItem men11=new JMenuItem("Complete Profile");
         JMenuItem men12=new JMenuItem("View Profile");
         
         JMenu men2=new JMenu("Manage");
         JMenuItem men21=new JMenuItem("Update Details");
         
         JMenu men3=new JMenu("Attendance");
         JMenuItem men31=new JMenuItem("Take Attendance");
         JMenuItem men32=new JMenuItem("View Attendance");
         
         JMenu men4=new JMenu("Leave");
         JMenuItem men41=new JMenuItem("Apply Leave");
         JMenuItem men42=new JMenuItem("View Leave");
         
         JMenu men5=new JMenu("Salary");
         JMenuItem men51=new JMenuItem("Add Salary");
         JMenuItem men52=new JMenuItem("Generate Salary slip");
         
         JMenu men6=new JMenu("Exit");
         JMenuItem men61=new JMenuItem("Logout");
         
         JMenu men7=new JMenu("Delete");
         JMenuItem men71=new JMenuItem("Delete Profile");
         
         men1.add(men11);men1.add(men12);
         men2.add(men21);
         men3.add(men31);men1.add(men12);
         men4.add(men41);men1.add(men12);
         men5.add(men51);men1.add(men12);
         men6.add(men61);men1.add(men12);
         men7.add(men71);
         
         
         m1.add(men1);
         m1.add(men2);
         m1.add(men3);
         m1.add(men4);
         m1.add(men5);
         m1.add(men6);
         m1.add(men7);
         
         
         men1.setFont(f1);men2.setFont(f1);men3.setFont(f1);men4.setFont(f1);men5.setFont(f1);men6.setFont(f1);men7.setFont(f1);
         men11.setFont(f2);men12.setFont(f2);men21.setFont(f2);men31.setFont(f2);men32.setFont(f2);men41.setFont(f2);men42.setFont(f2);men51.setFont(f2);men52.setFont(f2);men61.setFont(f2);men71.setFont(f2);
         
         m1.setBackground(Color.BLACK);
         
         men1.setForeground(Color.GRAY);men2.setForeground(Color.GRAY);men3.setForeground(Color.GRAY);men4.setForeground(Color.GRAY);men5.setForeground(Color.GRAY);men6.setForeground(Color.RED);men7.setForeground(Color.GRAY);
         men11.addActionListener(this);men12.addActionListener(this);men21.addActionListener(this);men31.addActionListener(this);men32.addActionListener(this);men41.addActionListener(this);men42.addActionListener(this);men51.addActionListener(this);men52.addActionListener(this);men61.addActionListener(this);men71.addActionListener(this);

         men11.setBackground(Color.BLACK);men12.setBackground(Color.BLACK);men21.setBackground(Color.BLACK);men31.setBackground(Color.BLACK);men32.setBackground(Color.BLACK);men41.setBackground(Color.BLACK);men42.setBackground(Color.BLACK);men51.setBackground(Color.BLACK);men52.setBackground(Color.BLACK);men61.setBackground(Color.BLACK);men71.setBackground(Color.BLACK);
          men11.setForeground(Color.WHITE);men12.setForeground(Color.WHITE);men21.setForeground(Color.WHITE);men31.setForeground(Color.WHITE);men32.setForeground(Color.WHITE);men41.setForeground(Color.WHITE);men42.setForeground(Color.WHITE);men51.setForeground(Color.WHITE);men52.setForeground(Color.WHITE);men61.setForeground(Color.WHITE);men71.setForeground(Color.WHITE);
          setJMenuBar(m1);      m1.setVisible (true);
          add(l);
    }
    public void actionPerformed(ActionEvent e) {
        String comnd=e.getActionCommand();
        if(comnd.equals("Complete Profile")){
            new Add_Employee();
        }
        if(comnd.equals("View Profile")){
            new View_Employee();
        }
        if(comnd.equals("Update Details")){
            new Update_Details_Data.setVisible(true);
        }
        if(comnd.equals("Take Attendance")){
            new Employee_Attendance.setVisible(true);
        }
        if(comnd.equals("View Attendance")){
            //new View_Attendance.setVisible(true);
        }
        if(comnd.equals("Apply Leave")){
            //new Apply_Leave.setVisible(true);
        }
        if(comnd.equals("View Leave")){
            //new View_Leave.setVisible(true);
        }
        if(comnd.equals("Add Salary")){
            //new Salary.setVisible(true);
        }
        if(comnd.equals("Generate Salary slip")){
            //new Generate_PaySlip.setVisible(true);
        }
        if(comnd.equals("Logout")){
            //new Delete_Employee().setVisible(true);
        }
        if(comnd.equals("Delete Profile")){
            System.exit(0);
        }
    }
    public static void main(String args[]){
        new HomePage().setVisible(true); 
    }
    
}
