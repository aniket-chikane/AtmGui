
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignupTwo extends JFrame implements ActionListener{
    
    private JTextField pin,staten,aadhar,pan,emailn,fatherName,income,passText;
    private JRadioButton married,single,other,male,female,seniorY,seniorN,exacY,exacN;
    private JDateChooser daten;
    public String formno;
    private JComboBox  incSource;
    private JButton reset,next;
    
    
    SignupTwo(String formno){
        this.formno =formno;
        
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM PAGE 2");
        getContentPane().setBackground(Color.WHITE);
        setSize(800,750);
        setLocation(350,10);
        
     
        
       
        
        JLabel personDetails = new JLabel("page 2: Additional Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personDetails.setBounds(290,80,400,30);
        add(personDetails);
        
        JLabel inc_src  = new JLabel("Income source");
        inc_src.setFont(new Font("Raleway",Font.BOLD,15));
        inc_src.setBounds(100,140,150,30);
        add(inc_src);
        String valinctype[] = {null,"Salery","Self employed","Buisness","Farming","Other"};
        incSource = new JComboBox(valinctype);
        incSource.setBackground(Color.WHITE);
        incSource.setFont(new Font("Raleway",Font.BOLD,15));
        incSource.setBounds(300,140,300,30);
        add(incSource);
        JLabel fname = new JLabel("Income");
        fname.setFont(new Font("Raleway",Font.BOLD,15));
        fname.setBounds(100,180,100,30);
        add(fname);
        
        income = new JTextField();
        income.setBounds(300,180,300,30);
        income.setForeground(Color.red);
        add(income);
        
        
        JLabel addr = new JLabel("Pan No : ");
        addr.setFont(new Font("Raleway",Font.BOLD,15));
        addr.setBounds(100,220,100,30);
        add(addr);
        
        pan = new JTextField(); 
        pan.setFont(new Font("Raleway",Font.BOLD,15));
        pan.setBounds(300,220,300,30);
        add(pan);
        
        JLabel city = new JLabel("Aadhar no :");
        city.setFont(new Font("Raleways",Font.BOLD,15));
        city.setBounds(100,260,100,30);
        add(city);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,15));
        aadhar.setBounds(300,260,300,30);
        add(aadhar);
        

        JLabel pass = new JLabel("Password");
        pass.setFont(new Font("Raleways",Font.BOLD,15));
        pass.setBounds(100,300,100,30);
        add(pass);
        
        passText = new JTextField();
        passText.setFont(new Font("Raleway",Font.BOLD,15));
        passText.setBounds(300,300,300,30);
        add(passText);
        
        JLabel seni = new JLabel("Senior citizen");
        seni.setFont(new Font("Raleway",Font.BOLD,15));
        seni.setBounds(100,340,150,30);
        add(seni);
        
        seniorY = new JRadioButton("Yes");
        seniorY.setFont(new Font("Raleway",Font.BOLD,15));
        seniorY.setBounds(300,340,70,30);
        add(seniorY);
        seniorN = new JRadioButton("No");
        seniorN.setFont(new Font("Raleway",Font.BOLD,15));
        seniorN.setBounds(380,340,70,30);
        add(seniorN);
        
        ButtonGroup senior = new ButtonGroup();
        senior.add(seniorY);
        senior.add(seniorN);

        JLabel exac = new JLabel("Exiting account");
        exac.setFont(new Font("Raleway",Font.BOLD,15));
        exac.setBounds(100,380,150,30);
        add(exac);
        exacY = new JRadioButton("Yes");
        exacY.setFont(new Font("Raleway",Font.BOLD,15));
        exacY.setBounds(300,380,70,30);
        add(exacY);
        exacN = new JRadioButton("No");
        exacN.setFont(new Font("Raleway",Font.BOLD,15));
        exacN.setBounds(380,380,70,30);
        add(exacN);
        ButtonGroup existingAccount = new ButtonGroup();
        existingAccount.add(exacY);
        existingAccount.add(exacN);
        
      
        
        next = new JButton("Submit");
        next.setBounds(350,450,100,30);
        next.setBackground(Color.green);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);
        
        
        setVisible(true);
        
        
        
        
         
    }
    public void actionPerformed(ActionEvent ae){
        
        String incsrc = (String)incSource.getSelectedItem();
        String inc = income.getText();
        String panCard = pan.getText();
        String aadharCard = aadhar.getText();
        String Password = passText.getText();
        String senCit =null;
        if(seniorY.isSelected()){
            senCit = "Yes";
        }
        else if(seniorN.isSelected()){
            senCit = "No";
        }
        
        String exiAcc = null;
        if(exacY.isSelected()){
            exiAcc = "Yes";
        }
        else if(exacN.isSelected()){
            exiAcc = "No";
        }

        try{
            
            if(panCard.equals("")){
                JOptionPane.showMessageDialog(null, "Pan Number is Required");
            }
            else if(aadharCard.equals("")){
                JOptionPane.showMessageDialog(null, "AAdhar Number is Required");
            }
            else if(Password.equals("")){
                JOptionPane.showMessageDialog(null, "Password is Required");
            }
            
            
            else {
                Con c = new Con();
                String query = "insert into additional values('"+incsrc+"','"+inc+"','"+panCard+"','"+aadharCard+"','"+Password+"','"+senCit+"','"+exiAcc+"','"+formno+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new Login().setVisible(true);
                
            }
            
        }catch (Exception e){
            System.out.println(e);
        }
        
        
    }
    
    public static void main(String args[]){
        new SignupTwo("");
    }
}
