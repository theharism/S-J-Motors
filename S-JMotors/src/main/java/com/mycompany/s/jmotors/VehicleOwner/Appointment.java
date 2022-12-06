/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.s.jmotors.VehicleOwner;

import com.mycompany.s.jmotors.Staff.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author city
 */
public class Appointment {
    
    String appointmentID;
    String ownerID;
    String vehicleID;
    int maintenanceCost;
    String date;
    
    public boolean bookAppointment(String vehicleID,String ownerID, String date,Connection con, boolean electrician, boolean mechanic, boolean denter)
    {
        Random rand = new Random();
        
        this.vehicleID = vehicleID;
        this.ownerID = ownerID;
        this.appointmentID = Integer.toString(rand.nextInt(99999));
        this.date = date;
        
        if(electrician)
        {
            this.maintenanceCost += 2000;
        }
        if(mechanic)
        {
            this.maintenanceCost += 3000;
        }
        if(denter)
        {
            this.maintenanceCost += 5000;
        }
        
        String query = "INSERT INTO Appointment VALUES (?,?,?,?,?)";
        PreparedStatement pdt;
        
        try {
            pdt = con.prepareStatement(query);
            
             pdt.setString(1,appointmentID);
              pdt.setString(2,ownerID);
               pdt.setString(3,vehicleID);
                pdt.setString(4,date);
                 pdt.setInt(5, maintenanceCost);
            
                 pdt.executeUpdate();
                 
             JOptionPane.showMessageDialog(null, "Appointment Booked Successfully");
                 
        } catch (SQLException ex) {
            Logger.getLogger(Appointment.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
        JOptionPane.showMessageDialog(null, date);
        
        return true;
    };
    public boolean cancelAppointment(){return true;};
    public void displayAppointment(){};
    
}
