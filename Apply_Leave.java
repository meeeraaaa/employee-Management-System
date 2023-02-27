package emp_manage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Locale;
public class Apply_Leave extends JFrame implements ActionListener{
    Font f1,f2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JPanel p1,p2,p3;
    JButton b1,b2,b3 ; 
    Choice ch1,ch2;
    JTextField t1,t2,t3,t4;
    Apply_Leave(){
        super("Apply_Leave");
        setLocation(450,50);
        setSize(950,450);
        setResizable(false);
        setBackground(Color.white);
        
        f1=new Font ("ariel",Font.BOLD,25);
        f2=new Font ("ariel",Font.BOLD,16);
        
        l1=new JLabel("Apply Leave");
        l2=new JLabel("Select employee id");
        l3=new JLabel("Name");
        l4=new JLabel("Email");
        l5=new JLabel("Start Date");
        l6=new JLabel("End Date");
        l7=new JLabel("Reason for Leave");
        
        t1=new JTextField();t2=new JTextField();
        t3=new JTextField();t4=new JTextField();
      
        b1=new JButton("Submit");b1.addActionListener(this);b1.setForeground(Color.white);b1.setBackground(Color.black);
        b2=new JButton("Close");b2.addActionListener(this);;b1.setForeground(Color.white);b1.setBackground(Color.red);
        
        ch1=new Choice();
        try{
           ConnectionClass dd=new ConnectionClass();
           String q="select eid from employee";
           ResultSet rs=dd.stm.executeQuery(q);
           while(rs.next()){
               ch1.add(rs.getString("eid"));
           }
       }
        catch(Exception exp){
            exp.printStackTrace();
        }
        ch2=new Choice();
        ch2.add("Sick Leave");ch2.add("Personal Days");ch2.add("Marriage");
        ch2.add("Family Health");ch2.add("Travelling for election day");
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        l1.setFont(f1);l2.setFont(f1);
        l3.setFont(f1);l4.setFont(f1);
        l5.setFont(f1);l6.setFont(f1);
        l7.setFont(f1);
        ch1.setFont(f1);ch2.setFont(f1);
        t1.setFont(f1);t2.setFont(f1);
        b1.setFont(f1);b2.setFont(f1);
        
        t1.setEditable(false);t2.setEditable(false);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(7,2,10,10));
        p2.add(l2);p2.add(ch1);p2.add(l3);p2.add(t1);p2.add(l4);p2.add(t2); p2.add(l5);     
        p2.add(t3);p2.add(l6);p2.add(t4); p2.add(l7);p2.add(ch2);p2.add(b1);p2.add(b2);
        
        p3=new JPanel();
        p3.setLayout(new GridLayout(1,1,10,10));
        
        l8=new JLabel();
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("emp_manage/icons/albg.png"));
        Image img=ic.getImage().getScaledInstance(250,400,Image.SCALE_DEFAULT);
        ImageIcon i = new ImageIcon(img);
        l8.setIcon(i);
        
        p3.add(l8); 
        
        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"West");
        add(p3,"Center");
        
        ch1.addMouseListener(new MouseAdapter(){
           public void mouseClicked(MouseEvent arg0) {
               try{
                    ConnectionClass dd2=new ConnectionClass();
                    String eid=ch1.getSelectedItem();
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
           String name=ch1.getSelectedItem(),
                   eid=t1.getText(),mail=t2.getText(),
                   startdt=t3.getText(),end_dt=t4.getText(),reason=ch2.getSelectedItem(),
                   apply_dt=new java.util.Date().toString();
           try{
           ConnectionClass dd1=new ConnectionClass();
           String q="insert into apply_leave values('"+eid+"','"+name+"','"+mail+"','"+startdt+"','"+end_dt+"','"+reason+"','"+apply_dt+"')";
           int aa=dd1.stm.executeUpdate(q);
           if(aa==1){
               JOptionPane.showMessageDialog(null,"data successfully updated");
               this.setVisible(false);
           }
           else{
               JOptionPane.showMessageDialog(null,"fill data carefully");
           }
           
       }
        catch(Exception exp){
            exp.printStackTrace();
        }
        }
        if(e.getSource()==b2){
               JOptionPane.showMessageDialog(null,"fill data carefully");
        }
    }
    public static void main(String args[]){
        new Apply_Leave().setVisible(true);
        
    }
    public void actionListener(ActionEvent e) {
        
    }

    
}








//create table apply_leave (eid varchar(50), name varchar(50), mail varchar(50), start_date varchar(50), end_date varchar(50), reason varchar(150), apply_date varchar(150));
