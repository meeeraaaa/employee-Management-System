package emp_manage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Locale;
public class Salary extends JFrame  implements MouseListener, ActionListener{
    
    JFrame f;
    Font f1,f2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    Choice ch,ch2,ch3;
    JPanel p1,p2,p3,p4;
    String x[]={"Employee ID","Name","Email","First Half","Second Half","Date"},y[][]=new String[20][6];
     int i=0,j=0,count=0;JLabel aid1,aid2,aid3,aid5,aid4,aid7,aid6;
    String name,fname,eid,pno,mail,adhar,edu,post,salary,age,addr,dob;
    JButton b1,b2 ;
    Salary(){
        super("Salary");
        setSize(950,700);
        setLocation(100,100);
        setResizable(false);
    f1=new Font ("MS UI Gothic",Font.BOLD,18);
    f2=new Font ("MS UI Gothic",Font.BOLD,25);
    
        
        l1=new JLabel("Select employee id");l2=new JLabel("Name");l3=new JLabel("email");
        l4=new JLabel("HRA");l5=new JLabel("DA");l6=new JLabel("MID");
        l7=new JLabel("PF");l8=new JLabel("Basic Salary");l9=new JLabel("Select Month");
        l10=new JLabel("Select Year");l12=new JLabel("Employee Salary");
        l11=new JLabel();
        l12.setHorizontalAlignment(JLabel.CENTER);
        
        
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
        ch2=new Choice();
        ch2.add("January");ch2.add("February");ch2.add("March");ch2.add("April");
        ch2.add("May");ch2.add("June");ch2.add("July");ch2.add("August");
        ch2.add("September");ch2.add("October");ch2.add("November");ch2.add("December");
        
        ch3 =new Choice();
        ch3.add("2015");ch3.add("2016");ch3.add("2017");ch3.add("2018");
        ch3.add("2019");ch3.add("2020");ch3.add("2021");ch3.add("2022");
        
        l1.setFont(f1);l2.setFont(f1);l3.setFont(f1); l4.setFont(f1);
        l5.setFont (f1);l6.setFont (f1);l7.setFont (f1); l8.setFont (f1);
        l9.setFont (f1);l10.setFont (f1);l12.setFont(f2);
        
        ch.setFont (f1);ch2.setFont(f1);ch3.setFont(f1);
        
        t1=new JTextField();t2=new JTextField();t3=new JTextField();
        t4=new JTextField();t5=new JTextField();t6=new JTextField();
        t7=new JTextField();
        
        t1.setFont(f1);t2.setFont(f1);t3.setFont(f1); t4.setFont(f1);
        t5.setFont (f1);t6.setFont (f1);t7.setFont (f1);
        
        t1.setEditable(false);t2.setEditable(false);
        
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("emp_manage/icons/sbg.jpg"));
        Image img=ic.getImage().getScaledInstance(400,600,Image.SCALE_DEFAULT);
        ImageIcon i = new ImageIcon(img);
        l11.setIcon(i);
        
        b1=new JButton("submit");b2=new JButton("close");
        b1.setFont(f1);b2.setFont(f1);
        b1.setBackground(Color.BLACK);b1.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);b2.setForeground(Color.WHITE);
        b1.addActionListener(this);b2.addActionListener(this);
        
        p1=new JPanel();
        p1.setLayout (new GridLayout (11,2,10,10));
        p1.add(l1); p1.add(ch);p1.add(l2);p1.add(t1);
        p1.add(l3);p1.add(t2);p1.add(l4);p1.add(t3);
        p1.add(l5);p1.add(t4);p1.add(l6);p1.add(t5); 
        p1.add(l7);p1.add(t6);p1.add(l8);p1.add(t7);
        p1.add(l9);p1.add(ch2);p1.add(l10);p1.add(ch3);
        p1.add(b1);p1.add(b2);
        
        p2=new JPanel();
        p2.setLayout (new GridLayout(1, 1, 10, 10));
        p2.add(l11);
        
        p3=new JPanel();
        p3.setLayout (new GridLayout (1,1,10,10));
        p3.add(l12);
        
        setLayout(new BorderLayout(30,30));
        
        
        add(p1,"Center"); add(p2,"West"); add(p3,"North");
        
        ch.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent arg) {
            try {
                ConnectionClass dd2=new ConnectionClass();
                String eid2=ch.getSelectedItem();
                String q3="select 8 from employee where eid2='"+eid2+"';";
                ResultSet rs=dd2.stm.executeQuery(q3);
                while(rs.next()){
                     t1.setText(rs.getString("name"));
                     t2.setText(rs.getString("mail"));
                }
            }
            catch(Exception e){
                e.printStackTrace();
             } 
            }
        });
    }
    public static void main(String args[]){
        new Salary().setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            String eid=ch.getSelectedItem()
                    ,name=t1.getText(),email=t2.getText();
            float hra =Float.parseFloat(t3.getText()), da= Float.parseFloat(t4.getText()),
                    mid=Float.parseFloat (t5.getText()), pf=Float.parseFloat(t6.getText()),
                    basic=Float.parseFloat (t7.getText());
            String month=ch2.getSelectedItem()+" "+ch3.getSelectedItem();
            try {
                ConnectionClass dd3=new ConnectionClass();
                String q="insert into salary values('"+0+"','"+eid+"','"+name+"','"+email+"','"+hra+"','"+da+"','"+pf+"','"+basic+"','"+month+"');";
                int aa=dd3.stm.executeUpdate(q);
                System.out.println(aa);
                if(aa==1){
                     JOptionPane.showMessageDialog(null,"data inserted successfully");
                     this.setVisible(false);
                }
                else{
                     JOptionPane.showMessageDialog(null,"are you sure?");
                     setVisible(false);
                }
            }
            catch(Exception exp){
                exp.printStackTrace();
             } 
        }
        if(e.getSource()==b2){
            f.setVisible(false);
            new View_Employee();
        }
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
}
