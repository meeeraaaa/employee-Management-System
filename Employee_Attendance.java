package emp_manage; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Locale;
public class Employee_Attendance  extends JFrame  implements MouseListener, ActionListener{
    JPanel p;
    Font f;
    JLabel l1,l2,l3,l4,l5;
    JTextField t1,t2;
    Choice c1,c2,c3;
    JButton b1,b2 ;
    Employee_Attendance(){
        super("Employee Attendance");
        setLocation(450,300);
        setSize(300,200);
        setResizable(false);
        
        f=new Font ("ariel",Font.BOLD,15);
        
        c1=new Choice();
       
        try{
           ConnectionClass dd=new ConnectionClass();
           String q="select * from employee";
           ResultSet rs=dd.stm.executeQuery(q);
           while(rs.next()){
               c1.add(rs.getString("eid"));
           }
       }
        catch(Exception exp){
            exp.printStackTrace();
        }
        
        l1=new JLabel("select employee id");l1.setFont(f);
        l2=new JLabel(" half first");l2.setFont(f);
        l3=new JLabel("second first");l3.setFont(f);
        l4=new JLabel("name"); l4.setFont(f);
        l5=new JLabel("email");l5.setFont(f);
        
        t1=new JTextField();t1.setFont(f);t1.setEditable(false);
        t2=new JTextField();t2.setFont(f);t2.setEditable(false);
        
        c3=new Choice();c3.add("present");c3.add("absent");c3.setFont(f);
        c2=new Choice();c2.add("present");c2.add("absent");c3.setFont(f);
        
        
       b1=new JButton("Submit");b1.setBackground(Color.black);b1.setForeground(Color.white);b1.setFont(f);b1.addActionListener(this);
       b2=new JButton("Close");b2.setBackground(Color.black);b2.setForeground(Color.white);b2.setFont(f);b2.addActionListener(this);
       
       p=new JPanel();p.setLayout(new GridLayout(6,2,10,10));//6 rows, 2 colums , 10px gaps
       
       p.add(l1);p.add(c1);p.add(l4);
       p.add(t1);p.add(l5);p.add(t2);
       p.add(l2);p.add(c2);p.add(l3);
       p.add(c3);p.add(b1);p.add(b2);
       add(p);
               
       c1.addMouseListener(new MouseAdapter(){
           public void mouseClicked(MouseEvent arg0) {
               try{
                    ConnectionClass dd2=new ConnectionClass();
                    String eid=c1.getSelectedItem();
                    String q="select * from employee where eid='"+eid+ "'";
                    ResultSet rs1=dd2.stm.executeQuery(q);
                    while(rs1.next()){
                        t1.setText(rs1.getString("name"));
                        t2.setText(rs1.getString("mail"));
                        }
                    }
               catch(Exception exp){
                    exp.printStackTrace();
                    }
               
            }
       });
    }
     public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            String ch_eid=c1.getSelectedItem(),ch_first_half=c2.getSelectedItem(),
                    ch_second_half=c3.getSelectedItem(),name=t1.getText(),email=t2.getText(),
                     dt=new java.util.Date().toString();
            try{
                ConnectionClass dd3=new ConnectionClass();
                String q="insert into attendance values ('"+ch_eid+"','"+name+"','"+email+"','"+ch_first_half+"','"+ch_second_half+"','"+dt+"')";
                dd3.stm.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"data inserted");
                setVisible(false);
            }
            catch(Exception exp){
                exp.printStackTrace();
                }
                 
        }
        if(e.getSource()==b2){
            JOptionPane.showMessageDialog(null,"are you sure you want to close this window?");
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new Employee_Attendance();
        
    }
   
    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    static class setVisible {

        public setVisible(boolean b) {
        }
    }
}
