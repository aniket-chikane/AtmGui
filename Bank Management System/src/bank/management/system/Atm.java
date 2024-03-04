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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aniket
 */
public class Atm extends JFrame implements ActionListener{
    JButton withdraw,deposit,chkBalance,accDetails,miniStmt;
    String uname;
    Atm(String userName){
        uname = userName;
        setLayout(null);
        setTitle("ATM");
        getContentPane().setBackground(Color.WHITE);
        setSize(800,750);
        setLocation(350,10);
        
        
        JLabel wel = new JLabel("Welcome");
        wel.setBounds(320,100,300,30);
        wel.setFont(new Font("Raleway",Font.BOLD,30));
        add(wel);
        
        JLabel un = new JLabel(userName);
        un.setBounds(300,150,300,30);
        un.setFont(new Font("Raleway",Font.BOLD,15));
        add(un);
        
        withdraw = new JButton("Withdraw");
        withdraw.setFont(new Font("Raleway",Font.BOLD,15));
        withdraw.setBounds(200,250,150,50);
        add(withdraw);
        withdraw.addActionListener(this);
        
        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Raleway",Font.BOLD,15));
        deposit.setBounds(400,250,150,50);
        add(deposit);
        deposit.addActionListener(this);
        
        chkBalance = new JButton("Check Balance");
        chkBalance.setFont(new Font("Raleway",Font.BOLD,15));
        chkBalance.setBounds(200,350,150,50);
        chkBalance.addActionListener(this);
        add(chkBalance);
        
        accDetails = new JButton("Account Details");
        accDetails.setFont(new Font("Raleway",Font.BOLD,15));
        accDetails.setBounds(400,350,150,50);
        accDetails.addActionListener(this);
        
        add(accDetails);
        
        JButton changePass = new JButton("Change pin");
        changePass.setFont(new Font("Raleway",Font.BOLD,15));
        changePass.setBounds(200,430,350,50);
        add(changePass);
        
        miniStmt = new JButton("Mini Statement");
        miniStmt.setFont(new Font("Raleway",Font.BOLD,15));
        miniStmt.setBounds(200,500,350,50);
        add(miniStmt);   
        miniStmt.addActionListener(this);
        
        setVisible(true);
        
        
        
    }
    public void actionPerformed(ActionEvent ae){
        Con c = new Con();
        try{
            if(ae.getSource() == withdraw){
                setVisible(false);
                new Withdraw(uname).setVisible(true);
            }
            if(ae.getSource() == deposit){
                setVisible(false);
                new Deposit(uname).setVisible(true);
            }
            if(ae.getSource() == miniStmt){
                String stmt = "";
                String query1 =" select * from transaction where email = '"+uname+"' order by no desc limit 5;";
                try{
                    ResultSet rs = c.s.executeQuery(query1);
                    for(int i=0;i<5;i++){
                        if(rs.next()){
                            stmt+=rs.getNString("status")+" | "+rs.getNString("email")+" | "+rs.getNString("date_time")+" | Amount : "+rs.getInt("amount");
                            
                        }
                        stmt+="\n";
                    }
                    JOptionPane.showMessageDialog(null,stmt);
                    
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
                
            }
             if(ae.getSource() == chkBalance){
                int balance=10;
                
                String query1 =" select * from balance where email = '"+uname+"'";
                try{
                    ResultSet rs = c.s.executeQuery(query1);
                    if(rs.next()) { 
                 balance = rs.getInt("balance");
                 
                 }
                  if(balance!=10)JOptionPane.showMessageDialog(null, "Balance is "+balance);  
                }
                catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            if(ae.getSource() == accDetails){
                
                String name = "",dob="",gen="",mail="",cit="";
                 String query2 = "select * from signup where email ='"+uname+"'";
                try{
                   ResultSet rs = c.s.executeQuery(query2);
                   
                  
                    if(rs.next()) { 
                 name+= rs.getNString("name");
                 dob+= rs.getNString("dob");
                 gen+=rs.getNString("gender");
                 mail+=rs.getNString("email");
                 cit+=rs.getNString("city");
                    }
                    JOptionPane.showMessageDialog(null, "Name : "+name+
                                                    "\nDate of Birth : "+dob+
                                                    "\nGender : "+gen+
                                                    "\nEmail : "+mail+"\n City : "+cit);
                    
                }
                
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
            
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        new Atm("");
    }
    
}
