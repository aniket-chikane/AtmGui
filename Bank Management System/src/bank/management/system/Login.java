/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 *
 * @author Aniket
 */
public class Login extends JFrame implements ActionListener{
    private String passw;
    JButton login,reset,signup;
    JTextField  cardTextFeild;
    JPasswordField pinTextFeild;
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100, 100);
        add(label);
        getContentPane().setBackground(Color.white);
        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward,Font",Font.BOLD,38));
        text.setBounds(200, 40, 400, 40);
        add(text);
        
        JLabel cardno = new JLabel("Username ");
        cardno.setFont(new Font("Railway,Font",Font.BOLD,28));
        cardno.setBounds(120, 150, 400, 40);
        add(cardno);
        
        cardTextFeild = new JTextField();
        cardTextFeild.setBounds(300, 150, 250, 30);
        add(cardTextFeild);
        
        JLabel pin = new JLabel("Pin No : ");
        pin.setFont(new Font("Railway,Font",Font.BOLD,28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);
        
        pinTextFeild = new JPasswordField();
        pinTextFeild.setBounds(300, 220, 250, 30);
        add(pinTextFeild);
        
        login = new JButton("Sign In");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.blue);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        reset = new JButton("Reset");
        reset.setBounds(400,300,100,30);
        reset.setBackground(Color.red);
        reset.setForeground(Color.white);
        reset.addActionListener(this);
        add(reset);
        
        signup = new JButton("Sign Up");
        signup.setBounds(350,350,100,30);
        signup.setBackground(Color.green);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
        
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
      
    }
   
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== reset){
            cardTextFeild.setText("");
            pinTextFeild.setText("");
            
        }
        if(ae.getSource()== login){
            Con c = new Con();
            String uname =cardTextFeild.getText();
            
            passw=String.valueOf(pinTextFeild.getPassword());
            String query1 =" select * from signup where email = '"+uname+"'";
            
            
            try {
                ResultSet rs = c.s.executeQuery(query1);
                int id=0;
                String pass ="";
                if(rs.next()) { 
                 id = rs.getInt("formno");
                 }
                String query2 =" select * from additional where form_no = '"+id+"'";
                rs = c.s.executeQuery(query2);
                if(rs.next()) { 
                  pass= rs.getString("password");
                 }
                if(pass.equals(passw)){
                    setVisible(false);
                    new Atm(uname).setVisible(true);
                    
                }
                else{
                    JOptionPane.showMessageDialog(null, "Username or password is incorrect");
                }
                
                
                
               
               
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        }
        if(ae.getSource()== signup){
            setVisible(false);
            new SignupOne().setVisible(true);
            
        }
        
    };
    
    public static void main (String args[]){
        new Login();
        
    }
    
}
