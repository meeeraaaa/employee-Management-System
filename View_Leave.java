package emp_manage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Locale;
public class View_Leave extends JFrame implements ActionListener{
    JPanel p1,p2,p3;
    JButton b1,b2;
    JTextField tf;
    Font f1,f2;
    JLabel l1,l2;
    JTable t;
    String x[]={"Employee ID","Name","Email","First Half","Second Half","Date"},y[][]=new String[20][7];
    int i=0,j=0;   
    View_Leave(){
        super("Leave record for all employees");
        setSize(1480,400);setLocation(0,10);
        Font f1 =new Font("MS UI Gothic",Font.BOLD,17);
        Font f2 =new Font("Lucida fax",Font.BOLD,25);
        
        try{
           ConnectionClass dd=new ConnectionClass();
           String q="select * from apply_leave";
           ResultSet rs=dd.stm.executeQuery(q);
           while(rs.next()){
               y[i][j++]=rs.getString("eid");
               y[i][j++]=rs.getString("name");
               y[i][j++]=rs.getString("email");
               y[i][j++]=rs.getString("start_date");
               y[i][j++]=rs.getString("end_date");
               y[i][j++]=rs.getString("end_date");
               y[i][j++]=rs.getString("apply_date");
               i++;j=0; 
           }
           t=new JTable(y,x);
           t.setBackground(Color.black);t.setForeground(Color.white);
           t.setFont(f1);
           
       }
        catch(Exception exp){
            exp.printStackTrace();
        }
        JScrollPane js=new JScrollPane(t); 
        add(js);
        l1=new JLabel("Search Employee");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f1);
        l1.setForeground(Color.yellow);
        
        l2=new JLabel("Employee Id");
        l2.setFont(f2);
        l2.setForeground(Color.gray);
        
        tf=new JTextField();
        tf.setFont(f1);
      
        //l1.add(l2);
//        f.add(l1);
//        
          b1=new JButton("Search");
          b1.setBackground(Color.black);b1.setForeground(Color.red);
          b1.setFont(f1);
//        b1.setBounds(140,200,100,30);
//        l1.add(b1);
//        
          b2=new JButton("Cancel");
          b2.setBackground(Color.red);b2.setForeground(Color.white);
//        b2.setBounds(260,200,100,30);
//        l1.add(b2);
//        
           b1.addActionListener(this);b2.addActionListener(this);
           
           p1=new JPanel();
           p1.setLayout(new GridLayout(1,1,10,10));
           p1.add(l1);
           
           p2=new JPanel();
           p2.setLayout(new GridLayout(1,3,10,10));
           p2.add(l2);p2.add(tf);p2.add(b1);
           
           p3=new JPanel();
           p3.setLayout(new GridLayout(2,1,10,10));
           p3.add(p1);p3.add(p2);
           
           add(p3,"South");
           p1.setBackground(Color.black);p2.setBackground(Color.black);p2.setBackground(Color.black);
//        t=new JTextField();
//        t.setBounds(250,90,220,30);
//        l1.add(t);
//        
//        f.setVisible(true);
//        f.setSize(510,340);
//        f.setLocation(500,200);
    }
    public void actionPerformed(ActionEvent e) {
        String eid=tf.getText();
        if(e.getSource()==b1){
            new View_Leave_Single(eid).setVisible(true);  
        }
        
    }
    public static void main(String args[]){
        new View_Leave().setVisible(true);
    }
    
    
}
