/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.s.jmotors.FloorManager;

import com.mycompany.s.jmotors.Person;
import com.mycompany.s.jmotors.Staff.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author city
 */
public class FloorManager extends Person {
    
    int FloorManagerID;
    
    // add a new employeee //
    public void addnewemployee(String ID,String fid,String name,String username,String password,String phone,String oid,String x,Connection  s)
    {
        
        // sql queeries  to run //
           String queery="INSERT INTO `Staff` Values(?,?,?,?,?,?,?,?)";
        String queery1="INSERT INTO login Values(?,?,?)";
        
        // variable to run the query //
        PreparedStatement pdt;
        PreparedStatement pdt2;
        //initializing the person classs and staff classs //
        Staff staf=new Staff();
        staf.AddStaff(ID, fid, name, username, password, phone, oid,"x");
        
        
        try
        {
            //passsing parameters to the queery //
            pdt = s.prepareStatement(queery);
            pdt2=s.prepareStatement(queery1);
            
            pdt.setString(1, ID);
            pdt.setString(2, name);
            pdt.setString(3, username);
            pdt.setString(4, phone);
            pdt.setString(5, password);
            pdt.setString(6, "x");
            pdt.setString(7, fid);
            pdt.setString(8, oid);
            
            pdt2.setString(1,username);
            pdt2.setString(2,password);
            pdt2.setString(3,"S");
            
            //executing the queery /
            pdt.executeUpdate();
            pdt2.executeUpdate();
            
             JOptionPane.showMessageDialog(null, "Employee Added Successfully");
            
        } catch (SQLException ex) {
            Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void removeemployee(String ID,Connection con)
    {
        // sql queeries //
        
         String query = "select Username from Staff where ID = ?";
        String query1="DELETE FROM Staff WHERE ID = ? ";
        // variable to imlemenet the queery //
        PreparedStatement pdt;
        PreparedStatement pdt2;
        String Username="";
        
        try
        {
            
            //passssing the paameters to thw queeries //
            pdt = con.prepareStatement(query);
            pdt2=con.prepareStatement(query1);
            
            pdt.setString(1, ID);
            
            //retun variable //
            ResultSet rn=pdt.executeQuery();
            
           
            while(rn.next())// storing return varibale the the username 
            {
             Username=rn.getString("Username");
            }
            if(Username.equals(""))// check to check is username is not entered //
            {
                JOptionPane.showMessageDialog(null, "Username not found");
            }
            else{
                 JOptionPane.showMessageDialog(null, "deleted successfully");
                 pdt2.setString(1,ID);
                 pdt2.executeUpdate();
            
            }
       
            
        } catch (SQLException ex) {
            Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void manageStaff(String ID,String Type,Connection con)
    {
        // sql queeries //
         String query = "select Username from Staff where ID = ?";
        String query1="UPDATE Staff SET Type = ? WHERE ID = ? ";
        //variable to implement the queeries //
        PreparedStatement pdt;
        PreparedStatement pdt2;
        String Username="";
        
        try
        {
            // passing the parameters to the queeies //
            pdt = con.prepareStatement(query);
            pdt2=con.prepareStatement(query1);
            
            pdt.setString(1, ID);
            ResultSet rn=pdt.executeQuery();//return variable //
            
           
            while(rn.next())// storing return varibale in the string //
            {
             Username=rn.getString("Username");
            }
            if(Username.equals("")) /// check to found if user exists //
            {
                JOptionPane.showMessageDialog(null, "Username not found");
            }
            else{
                 JOptionPane.showMessageDialog(null, "Updated  successfully");
                 pdt2.setString(1, Type);
                 pdt2.setString(2,ID);
                 pdt2.executeUpdate();
            
            }
       
            
        } catch (SQLException ex) {
            Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    public void manageReports(){};
    public boolean returnItems(){return true;};
}
