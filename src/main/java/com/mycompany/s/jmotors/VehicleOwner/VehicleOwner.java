/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.s.jmotors.VehicleOwner;

import com.mycompany.s.jmotors.Admin.admin_Adduser;
import com.mycompany.s.jmotors.Person;
import com.mycompany.s.jmotors.Vehicle.Vehicle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author city
 */
public class VehicleOwner extends Person {
    
    String ownerID;
    
    List<Appointment> AppointmentList;
    List<Vehicle> VehiclesList;
    
    public VehicleOwner()
    {
            ownerID="";
    }
    
    public void setOwner(String ownerID, String name, String username, String password, String phoneno,String outletID)
    {
        addPerson(name,username,password,phoneno,outletID);
        this.ownerID  = ownerID;
    }
    
    public void setUnregisteredOwner(String ownerID, String name, String phoneno,String outletID,Connection con)
    {
        addPerson(name,"","",phoneno,outletID);
        this.ownerID  = ownerID;
        
        String query = "INSERT INTO `unregisteredvehicleowners` VALUES (?,?,?,?)";
        PreparedStatement pdt;
         
        try {
            pdt = con.prepareStatement(query);
            
            pdt.setString(1,ownerID);
            pdt.setString(2,name);
            pdt.setString(3,phoneno);
            pdt.setString(4,outletID);
            
            pdt.executeUpdate();
            
             JOptionPane.showMessageDialog(null, "New USer added to the System");
            
            //vehicleowner.
        } catch (SQLException ex) {
            Logger.getLogger(admin_Adduser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void deactivateAccount(String ownerID, boolean status, Connection con)
    {
        if(status = true)
        {
            String username="";
            String query3 = "SELECT username FROM `vehicleowner` WHERE id=?";
            String query = "DELETE FROM `vehicleowner` WHERE id=?";
            String query1 = "DELETE FROM `login` WHERE username=?";
            
            PreparedStatement pdt;
            PreparedStatement pdt1;
            PreparedStatement pdt2;
         
        try {
            pdt = con.prepareStatement(query3);
            pdt.setString(1,ownerID);
            
            ResultSet rs = pdt.executeQuery();
            
            while(rs.next())
            {
                username = rs.getString("username");
            }
            
            pdt1 = con.prepareStatement(query);
            pdt2 = con.prepareStatement(query1);
            
            pdt1.setString(1,ownerID);
            pdt2.setString(1,username);
            
            pdt1.executeUpdate();
            pdt2.executeUpdate();
            
             JOptionPane.showMessageDialog(null, "Account Deactivated");
            
            //vehicleowner.
        } catch (SQLException ex) {
            Logger.getLogger(admin_Adduser.class.getName()).log(Level.SEVERE, null, ex);
        }
        }      
    }
    
    public void changeOutlet(String ownerID, String newOutletID, Connection con)
    {
        String query = "UPDATE `vehicleowner` SET outletID=? WHERE id=?";
        
        PreparedStatement pdt;
        
        try{
            
            pdt = con.prepareStatement(query);
            
            pdt.setString(1,newOutletID);
            pdt.setString(2,ownerID);
        
            pdt.executeUpdate();
    
             JOptionPane.showMessageDialog(null, "Outlet Changed");
            
        }catch (SQLException ex) {
            Logger.getLogger(admin_Adduser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
}
