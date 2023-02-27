package emp_manage;
import com.mysql.cj.xdevapi.Table;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Locale;
public class View_Attendance extends JFrame implements ActionListener{
    JPanel p1,p2,p3;
    JButton b;
    JTextField tf;
    Font f1,f2;
    JLabel l1,l2;
    JTable t;
    String x[]={"Employee ID","Name","Email","First Half","Second Half","Date"},y[][]=new String[20][6];
    int i=0,j=0;
    View_Attendance(){
        super("Employee Attendance Record ");
        setSize(1480,400);
        setLocation(0,10);
        f1=new Font ("ariel",Font.BOLD,17);
        
        try{
           ConnectionClass dd=new ConnectionClass();
           String q="select * from attendance";
           ResultSet rs=dd.stm.executeQuery(q);
           while(rs.next()){
               y[i][j++]=rs.getString("eid");
               y[i][j++]=rs.getString("name");
               y[i][j++]=rs.getString("email");
               y[i][j++]=rs.getString("first_half");
               y[i][j++]=rs.getString("second_half");
               y[i][j++]=rs.getString("day_date");
               i++;j=0; 
           }
           t=new JTable(y,x);
       }
        catch(Exception exp){
            exp.printStackTrace();
        }
        
        t.setBackground(Color.black);t.setForeground(Color.white);
        t.setFont(f1);
        
        JScrollPane js=new JScrollPane(t); 
        
        f2=new Font ("Lucida fax",Font.BOLD,25);
        
        l1=new JLabel("Search Employee");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f2);
        l1.setForeground(Color.yellow);
        
        l2=new JLabel("Employee Id");
        l2.setHorizontalAlignment(JLabel.CENTER);
        l2.setFont(f2);
        l2.setForeground(Color.gray);
        
        b.setBackground(Color.black);b.setBackground(Color.red);
        b.addActionListener(this);

        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(1,3,10,10));
        p2.add(l2);
        
        p3=new JPanel();
        p3.setLayout(new GridLayout(2,1,10,10));
        p3.add(p1);p3.add(p2);
        
        p1.setBackground(Color.black);p2.setBackground(Color.black);p3.setBackground(Color.black);
        
        add(p3,"south");add(js); 

        
    }
    public static void main(String args[]){
        new View_Attendance().setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e) {
        String eid=tf.getText();
        if(e.getSource()==b){
            new View_Attendance_Single(eid).setVisible(true);
        }
        
    }
}
