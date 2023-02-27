package emp_manage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Locale;
public class View_Employee_Data extends JFrame implements ActionListener{
    JFrame f;
    JLabel l,h,id1,id2,id3,id5,id4,id7,id6;
    JLabel aid1,aid2,aid3,aid5,aid4,aid7,aid6;

    String name,fname,eid,pno,mail,adhar,edu,post,age,addr,dob;
    JButton b1,b2 ;
    View_Employee_Data(String e_id){
        try{
            ConnectionClass dd=new ConnectionClass();
            String q="'select * from employee where eid='"+e_id+"'";
            ResultSet rs=dd.stm.executeQuery(q);
            
            while(rs.next()){
                name=rs.getString("name");fname=rs.getString("fname");
                eid=rs.getString("eid");pno=rs.getString("pno");
                mail=rs.getString("mail");adhar=rs.getString("adhar");
                edu=rs.getString("edu");post=rs.getString("post");
                age=rs.getString("age");
                addr=rs.getString("addr");dob=rs.getString("dob");
                System.out.println(name+""+eid+""+mail+""+edu);
            }
            f.setVisible(false);
            new HomePage();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        f=new JFrame("Employee Details");
        
        l=new JLabel();
        l.setBounds(0,0,595,640);
        l.setLayout(null);
        
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("emp_manage/icons/uddbg.png"));
        Image img=ic.getImage().getScaledInstance(280,80,Image.SCALE_DEFAULT);
        ImageIcon i = new ImageIcon(img);
        l.setIcon(i);
        
        h=new JLabel("Employee Details");
        h.setBounds(170,10,250,40);
        h.setFont(new Font("Ariel",Font.BOLD,30));
        h.setForeground(Color.black);
        l.add(h);
        
        id1=new JLabel("Name");
        id1.setBounds(150,70,120,30);
        id1.setFont(new Font("Ariel",Font.BOLD,30));
        id1.setForeground(Color.black);
        l.add(id1);
        
       aid1=new JLabel(name);
        aid1.setBounds (330, 70,200,30);
        aid1.setFont (new Font("serif", Font. BOLD, 20)); 
        l.add(aid1);
        
        id2=new JLabel("Employee Id");
        id2.setBounds(150,120,100,30);
        id2.setFont(new Font("Ariel",Font.BOLD,30));
        id2.setForeground(Color.black);
        l.add(id2);
        
       aid2=new JLabel(eid);
        aid2.setBounds (330, 170,300,30);
        aid2.setFont (new Font("serif", Font. BOLD, 20)); 
        l.add(aid2);
        
        id3=new JLabel("Contact");
        id3.setBounds(150,70,120,30);
        id3.setFont(new Font("Ariel",Font.BOLD,30));
        id3.setForeground(Color.black);
        l.add(id3);
        
       aid3=new JLabel(pno);
        aid3.setBounds (330, 220,200,30);
        aid3.setFont (new Font("serif", Font. BOLD, 20)); 
        l.add(aid3);
        
        id4=new JLabel("Email");
        id4.setBounds(150,70,120,30);
        id4.setFont(new Font("Ariel",Font.BOLD,30));
        id4.setForeground(Color.black);
        l.add(id4);
        
       aid4=new JLabel(mail);
        aid4.setBounds (330, 270,200,30);
        aid4.setFont (new Font("serif", Font. BOLD, 20)); 
        l.add(aid4);
        
        id5=new JLabel("Education");
        id5.setBounds(150,70,120,30);
        id5.setFont(new Font("Ariel",Font.BOLD,30));
        id5.setForeground(Color.black);
        l.add(id5);
        
       aid1=new JLabel(edu);
        aid5.setBounds (330, 320,200,30);
        aid5.setFont (new Font("serif", Font. BOLD, 20)); 
        l.add(aid5);
        
        id6=new JLabel("Job Post");
        id6.setBounds(150,70,120,30);
        id6.setFont(new Font("Ariel",Font.BOLD,30));
        id6.setForeground(Color.black);
        l.add(id6);
        
       aid6=new JLabel(post);
        aid6.setBounds (330, 370,200,30);
        aid6.setFont (new Font("serif", Font. BOLD, 20)); 
        l.add(aid6);
        
        id7=new JLabel("Address");
        id7.setBounds(150,70,120,30);
        id7.setFont(new Font("Ariel",Font.BOLD,30));
        id7.setForeground(Color.black);
        l.add(id7);
        
       aid7=new JLabel(addr);
        aid7.setBounds (330, 170,200,30);
        aid7.setFont (new Font("serif", Font. BOLD, 20)); 
        l.add(aid7);
        
        b1=new JButton("Print");
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.setBounds(500,520,100,30);
        l.add(b1);
        
        b1.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(595,640);
        f.setLocation(450,120);
        f.add(l);
        
        
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            JOptionPane.showMessageDialog(null,"Printing....");
            f.setVisible(false);
            new HomePage();
        }
        if(e.getSource()==b2){
            f.setVisible(false);
            new View_Employee();
        }
    }
    public static void main(String args[]){
        new View_Employee_Data("view data");
        
    }
}
