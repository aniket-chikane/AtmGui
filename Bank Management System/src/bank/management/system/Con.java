/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import java.sql.*;
/**
 *
 * @author Aniket
 */

public class Con {
    Connection c;
    Statement s;
    public Con(){
        try{
            c =DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","root");
            s = c.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}
