
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignupOne extends JFrame implements ActionListener{
    private JTextField pin,staten,cityt,address,emailn,fatherName,nametxt;
    private JRadioButton married,single,other,male,female;
    private JDateChooser daten;
    long random;
    private JButton reset,next;
    SignupOne(){
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(800,750);
        setLocation(350,10);
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO. "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personDetails = new JLabel("page 1: Personal Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personDetails.setBounds(290,80,400,30);
        add(personDetails);
        
        JLabel name  = new JLabel("Name");
        name.setFont(new Font("Raleway",Font.BOLD,15));
        name.setBounds(100,140,100,50);
        add(name);
        
         nametxt = new JTextField();
         nametxt.setFont(new Font("Raleway",Font.BOLD,15));
         nametxt.setBounds(300,140,300,30);
         add(nametxt);
        
        JLabel fname = new JLabel("Father Name");
        fname.setFont(new Font("Raleway",Font.BOLD,15));
        fname.setBounds(100,180,100,30);
        add(fname);
        fatherName = new JTextField();
        fatherName.setFont(new Font("Raleway",Font.BOLD,15));
        fatherName.setBounds(300,180,300,30);
        add(fatherName);
        
        JLabel dob = new JLabel("Date of Birth");
        dob.setFont(new Font("Raleway",Font.BOLD,15));
        dob.setBounds(100,220,100,30);
        add(dob);
        
        daten = new JDateChooser();
        daten.setBounds(300,230,300,30);
        daten.setForeground(Color.red);
        add(daten);
        
        
        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Raleway",Font.BOLD,15));
        gender.setBounds(100,260,100,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,260,70,30);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(370,260,70,30);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        
        JLabel email = new JLabel("Email Address");
        email.setFont(new Font("Raleway",Font.BOLD,15));
        email.setBounds(100,300,150,30);
        add(email);
        
        emailn = new JTextField(); 
        emailn.setFont(new Font("Raleway",Font.BOLD,15));
        emailn.setBounds(300,300,300,30);
        add(emailn);
        
        
        JLabel mstatus = new JLabel("Marital Status");
        mstatus.setFont(new Font("Raleway",Font.BOLD,15));
        mstatus.setBounds(100,340,150,30);
        add(mstatus);
        
         married = new JRadioButton("Married");
        married.setBounds(300,340,70,30);
        add(married);
         single = new JRadioButton("Single");
        single.setBounds(370,340,70,30);
        add(single);
         other  = new JRadioButton("Other");
        other.setBounds(440,340,70,30);
        add(other);
        
        ButtonGroup maritals = new ButtonGroup();
        maritals.add(married);
        maritals.add(single);
        maritals.add(other);
        
        
        JLabel addr = new JLabel("Address");
        addr.setFont(new Font("Raleway",Font.BOLD,15));
        addr.setBounds(100,380,100,30);
        add(addr);
        
        address = new JTextField(); 
        address.setFont(new Font("Raleway",Font.BOLD,15));
        address.setBounds(300,380,300,30);
        add(address);
        
        JLabel city = new JLabel("City");
        city.setFont(new Font("Raleways",Font.BOLD,15));
        city.setBounds(100,420,100,30);
        add(city);
        
        cityt = new JTextField();
        cityt.setFont(new Font("Raleway",Font.BOLD,15));
        cityt.setBounds(300,420,300,30);
        add(cityt);
        
        JLabel state = new JLabel("State");
        state.setFont(new Font("Raleway",Font.BOLD,15));
        state.setBounds(100,460,100,30);
        add(state);
        
        staten = new JTextField();
        staten.setFont(new Font("Raleway",Font.BOLD,15));
        staten.setBounds(300,460,300,30);
        add(staten);
        
        
        JLabel pincode = new JLabel("Pincode");
        pincode.setFont(new Font("Raleway",Font.BOLD,15));
        pincode.setBounds(100,500,100,30);
        add(pincode);
        
        pin = new JTextField();
        pin.setFont(new Font("Raleway",Font.BOLD,15));
        pin.setBounds(300,500,300,30);
        add(pin);
        
        next = new JButton("Next");
        next.setBounds(300,550,100,30);
        next.setBackground(Color.green);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);
        
        reset = new JButton("Reset");
        reset.setBounds(450,550,100,30);
        reset.setBackground(Color.red);
        reset.setForeground(Color.white);
        reset.addActionListener(this);
        add(reset);
        setVisible(true);
        
        
        
        
         
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== reset){
            nametxt.setText(" ");
            fatherName.setText(" ");
            pin.setText(" ");
            staten.setText(" ");
            cityt.setText("");
            address.setText("");
            emailn.setText("");  
        }
        String formno = "" + random;
        String name = nametxt.getText();
        String fname = fatherName.getText();
        String dob = ((JTextField)daten.getDateEditor().getUiComponent()).getText();
        String gender =null;
        if(male.isSelected()){
            gender = "Male";
        }
        else if(female.isSelected()){
            gender = "Female";
        }
        
        String email = emailn.getText();
        String marital = null;
        if(single.isSelected()){
            marital = "Single";
        }
        else if(married.isSelected()){
            marital = "Married";
        }
        else if(other.isSelected()){
            marital= "Other";
        }
        
        String addr = address.getText();
        String city = cityt.getText();
        String state  = staten.getText();
        String pinc =pin.getText();
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else {
                Con c = new Con();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+addr+"','"+city+"','"+pinc+"','"+state+"')";
                c.s.executeUpdate(query);
                String q2 = "insert into balance values('"+email+"','"+0+"')";
                c.s.executeUpdate(q2);
                if(ae.getSource()== next){
            setVisible(false);
            new SignupTwo(formno).setVisible(true);
            
        }
            }
            
        }catch (Exception e){
            System.out.println(e);
        }
        
        
    }
    
    public static void main(String args[]){
        new SignupOne();
    }
}
