package emp_manage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Update_Details_Data  extends JFrame  implements MouseListener, ActionListener{
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JButton b1,b2 ;
    JPanel p1,p2,p3;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    Choice ch;
    Font f1,f2;
    Update_Details_Data(){
        super("Update Employee");
        setLocation(450,50);
        setSize(950,750);
        
        f1=new Font("Ariel",Font.BOLD,25);
        f1=new Font("Ariel",Font.BOLD,10);
        
        ch=new Choice();
        
       try {
                ConnectionClass dd=new ConnectionClass();
                String q="select eid from employee";
                ResultSet rs=dd.stm.executeQuery(q);
                while(rs.next()){
                     ch.add(rs.getString("eid"));
                }
            }
            catch(Exception e){
                e.printStackTrace();
             } 
       
       l1=new JLabel("Update Employee");l2=new JLabel("Name");
       l3=new JLabel("Father's Name");l4=new JLabel("Age");
       l5=new JLabel("Date of Birth");l6=new JLabel("Address");
       l7=new JLabel("Phone");l8=new JLabel("Email");
       l9=new JLabel("Education");l10=new JLabel("Job Post");
       l11=new JLabel("Adhar");l12=new JLabel("Employee ID");
       
       t1=new JTextField();t2=new JTextField();
       t3=new JTextField();t4=new JTextField();
       t5=new JTextField();t5=new JTextField();
       t6=new JTextField();t7=new JTextField();
       t8=new JTextField();t9=new JTextField();
       t10=new JTextField();
       
       b1=new JButton("Update Data");
       b2=new JButton("Back");
       
       l1.setHorizontalAlignment(JLabel.CENTER);
       
       b1.addActionListener(this);b2.addActionListener(this);
       
       l1.setFont(f1);
       l2.setFont(f2);l3.setFont(f2);
       l4.setFont(f2);l5.setFont(f2);
       l6.setFont(f2);l7.setFont(f2);
       l8.setFont(f2);l9.setFont(f2);
       l10.setFont(f2);l11.setFont(f2);
       
       t1.setFont(f2);
       t2.setFont(f2);t3.setFont(f2);
       t4.setFont(f2);t5.setFont(f2);
       t6.setFont(f2);t7.setFont(f2);
       t8.setFont(f2);t9.setFont(f2);
       t10.setFont(f2);t11.setFont(f2);
       
        b1.setFont(f2);b2.setFont(f2);
        
        b1.setForeground(Color.WHITE);b2.setForeground(Color.WHITE);
        b1.setBackground(Color.black);b2.setBackground(Color.red);
        
        p1=new JPanel();//p1for the heading update employee,p2 for picture
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        
        p2=new JPanel();//p1for the heading update employee,p2 for picture
        p2.setLayout(new GridLayout(12,2,10,10));
        p2.add(l12);p2.add(ch);p2.add(l2);
        p2.add(t1);p2.add(l3);p2.add(t2);
        p2.add(l4);p2.add(t3);p2.add(l5);
        p2.add(t4);p2.add(l6);p2.add(t5);
        p2.add(l7);p2.add(t6);p2.add(l8);
        p2.add(t7);p2.add(l9);p2.add(t8);
        p2.add(l10);p2.add(t9);p2.add(l11);
        p2.add(t10);p2.add(b1);p2.add(b2);

        
        p3=new JPanel();//p2 for picture
        p3.setLayout(new GridLayout(1,1,10,10));
        
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("emp_manage/icons/uddbg.jpg"));
        Image img=ic.getImage().getScaledInstance(280,80,Image.SCALE_DEFAULT);
        ImageIcon i = new ImageIcon(img);
        l13=new JLabel(i);
        
        p3.add(l13);
        
        setLayout(new BorderLayout(10,10));
        add(p1,"North");add(p2,"Center");add(p3,"West");
        
        ch.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent arg0) {
                    try{
                        ConnectionClass dd2=new ConnectionClass();
                        String eid=ch.getSelectedItem();
                        String q="select * from employee where eid='"+eid+"'";
                        ResultSet rs=dd2.stm.executeQuery(q);
                        while(rs.next()){
                            t1.setText(rs.getString("name"));t2.setText(rs.getString("fname"));
                            t3.setText(rs.getString("age"));t4.setText(rs.getString("dob"));
                            t5.setText(rs.getString("addr"));t6.setText(rs.getString("pno"));
                            t7.setText(rs.getString("mail"));t8.setText(rs.getString("edu"));
                            t9.setText(rs.getString("post"));t10.setText(rs.getString("adhar"));
                        }
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
        });
        

    }  
    public void actionPerformed(ActionEvent e) {
        String id=ch.getSelectedItem();
        String name=t1.getText() ,fname= t2.getText() ,
        age= t3.getText() ,dob= t4.getText() ,
        addr= t5.getText() ,pno= t6.getText() ,
        mail= t7.getText() ,edu= t8.getText() ,
        post= t9.getText() ,adhar= t10.getText();
        
        if(e.getSource()==b1){
            try{
                ConnectionClass dd3=new ConnectionClass();
                String q="update employee set name='"+name+"',fname='"+fname+"',age='"+age+"',dob='"+dob+"',addr='"+addr+"',pno='"+pno+"mail='"+mail+"',edu='"+edu+"',post='"+post+"',adhar='"+adhar+"'where eid='"+id+"'";
                int aa=dd3.stm.executeUpdate(q);
                if(aa==1){
                    JOptionPane.showMessageDialog(null,"Data successfully executed");
                    this.setVisible(false);
                    new Update_Details_Data();
                }
                else{
                    JOptionPane.showMessageDialog(null,"oops! error.  please enter the details again");
                }
            }
            catch(Exception exc){
                exc.printStackTrace();
            }
        }
        if(e.getSource()==b2){
            this.setVisible(false);
        }
    }
     
    public static void main(String args[]){
        new Update_Details_Data().setVisible(true);
    }
    
    
    
    
    
    public void mouseClicked(MouseEvent e) {
    }
    public void mousePressed(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }

    static class setVisible {

        public setVisible(boolean b) {
        }
    }
    
    
     
}
     
    