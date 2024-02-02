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

/**
 *
 * @author Aniket
 */
public class Atm extends JFrame implements ActionListener{
    JButton withdraw,deposit,chkBalance;
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
        
        JButton accDetails = new JButton("Account Details");
        accDetails.setFont(new Font("Raleway",Font.BOLD,15));
        accDetails.setBounds(400,350,150,50);
        
        add(accDetails);
        
        JButton changePass = new JButton("Change pin");
        changePass.setFont(new Font("Raleway",Font.BOLD,15));
        changePass.setBounds(200,430,350,50);
        add(changePass);
        JButton miniStmt = new JButton("Mini Statement");
        miniStmt.setFont(new Font("Raleway",Font.BOLD,15));
        miniStmt.setBounds(200,500,350,50);
        add(miniStmt);
        
        setVisible(true);
        
        
        
    }
    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource() == withdraw){
                setVisible(false);
                new Withdraw(uname).setVisible(true);
            }
            if(ae.getSource() == deposit){
                setVisible(false);
                new Deposit(uname).setVisible(true);
            }
             if(ae.getSource() == chkBalance){
                setVisible(false);
                new ViewBalance(uname).setVisible(true);
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
