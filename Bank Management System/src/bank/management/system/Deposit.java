/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Aniket
 */

public class Deposit extends JFrame implements ActionListener{
    JButton back,proc;
    JTextField amount;
    String unm;
    Deposit(String uname){
        unm = uname;
        setLayout(null);
        setTitle("ATM");
        getContentPane().setBackground(Color.WHITE);
        setSize(800,750);
        setLocation(350,10);
        
        back = new JButton("<=");
        back.setBounds(100,200,50,30);
        add(back);
        back.addActionListener(this);
        JLabel un = new JLabel(uname);
        un.setBounds(300,200,200,30);
        add(un);
        
        amount = new JTextField();
        amount.setBounds(200,260,300,50);
        add(amount);
        
        proc = new JButton("Deposit");
        proc.setBounds(200,350,300,50);
        add(proc);
        proc.addActionListener(this);

        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource()==back){
                setVisible(false);
                new Atm(unm).setVisible(true);
                
            }
            if(ae.getSource()==proc){
                int balance=10;
                Con c = new Con();
                String query1 =" select * from balance where username = '"+unm+"'";
                try{
                    ResultSet rs = c.s.executeQuery(query1);
                    if(rs.next()) { 
                 balance = rs.getInt("balance");
                 }
                 String str = amount.getText();
                 int amt = Integer.parseInt(str);
                 balance+=amt;
                 String q2= "UPDATE balance SET balance ='"+balance+"'  where username ='"+unm+"'";
                 c.s.executeUpdate(q2);
  
                 if(balance!=amt+10)JOptionPane.showMessageDialog(null, "Amount Deposited Successfully");
                    
                    
                }
                catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            }
            
            
        }
        catch(Exception e) {
            System.out.println(e);
            
        }
    }
    
    public static void main (String args[]){
        new Deposit("");
    }
    
}
