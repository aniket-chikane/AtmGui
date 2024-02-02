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
public class ViewBalance extends JFrame implements ActionListener {
    String unm,a;
    
    ViewBalance(String uname){
        unm = uname;
        
        setLayout(null);
        setTitle("View Balance");
        getContentPane().setBackground(Color.WHITE);
        setSize(800,750);
        setLocation(350,10);
        JLabel rem = new JLabel(a);
        rem.setFont(new Font("Raleway",Font.BOLD,15));
        rem.setBounds(100,200,150,30);
        add(rem);
        
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        
                
        
        
    }
    public static void main(String args[]){
        new ViewBalance ("");
    }
}
