package emp_manage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Locale;
class View_Attendance_Single  extends JFrame implements ActionListener{
    Font f1,f2;
    JLabel l1,l2;
    JTable t;
    String x[]={"Employee ID","Name","Email","First Half","Second Half","Date"},y[][]=new String[20][6];
     int i=0,j=0,count=0;
    public View_Attendance_Single(String eid) {
        super("Attendance record employee");
        setSize(1480,400);
        setLocation(0,10);
        f1=new Font ("ariel",Font.BOLD,17);
        
        try{
           ConnectionClass dd=new ConnectionClass();
           String q="select * from attendance where eid+'"+eid+"'";
           ResultSet rs=dd.stm.executeQuery(q);
           while(rs.next()){
               count++;
               y[i][j++]=rs.getString("eid");
               y[i][j++]=rs.getString("name");
               y[i][j++]=rs.getString("email");
               y[i][j++]=rs.getString("first_half");
               y[i][j++]=rs.getString("second_half");
               y[i][j++]=rs.getString("day_date");
               i++;j=0; 
           }
           if(count==0)JOptionPane.showMessageDialog(null,"No record found");
           else 
           {
               t=new JTable(y,x);
                t.setBackground(Color.black);t.setForeground(Color.white);
                t.setFont(f1);
                JScrollPane js=new JScrollPane(t); 
                add(js);
           }
       }
        catch(Exception exp){
            exp.printStackTrace();
        }
        
        t.setBackground(Color.black);t.setForeground(Color.white);
        t.setFont(f1);
        
    }
    public static void main(String args[]){
        
    }

    public void setVisible(boolean b) {
    }
    public void actionPerformed(ActionEvent e) {
    }
}

    

