/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.s.jmotors.VehicleOwner;

import static com.mycompany.s.jmotors.Login.OTPform.ACCOUNT_SID;
import static com.mycompany.s.jmotors.Login.OTPform.AUTH_TOKEN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.sql.ResultSet;


/**
 *
 * @author city-
 */
public class Appointment {
    
    String appointmentID;
    String ownerID;
    String vehicleID;
    int maintenanceCost;
    String date;
    
    public boolean bookAppointment(String vehicleID,String ownerID,String Name,String phoneno, String date,Connection con, boolean electrician, boolean mechanic, boolean denter,boolean others)
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
        if(others)
        {
             this.maintenanceCost += 1000;
        }
        
        String query = "INSERT INTO Appointment VALUES (?,?,?,?,?)";
        String query1 = "INSERT INTO Payment VALUES (?,?,?,?,?)";
        PreparedStatement pdt;
        PreparedStatement pdt1;
        
        try {
            pdt = con.prepareStatement(query);
            pdt1 = con.prepareStatement(query1);
            
             pdt.setString(1,appointmentID);
              pdt.setString(2,ownerID);
               pdt.setString(3,vehicleID);
                pdt.setString(4,date);
                 pdt.setInt(5, maintenanceCost);
            
                 pdt1.setString(1, appointmentID);
                 pdt1.setString(2, "U");
                 pdt1.setInt(3, maintenanceCost);
                 pdt1.setInt(4, 0);
                 pdt1.setInt(5,maintenanceCost);
                 
                 pdt.executeUpdate();
                 pdt1.executeUpdate();
                 
             JOptionPane.showMessageDialog(null, "Appointment Booked Successfully. \n Appointment ID" + appointmentID);
             
              Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message message = Message.creator(
                new com.twilio.type.PhoneNumber(phoneno),
                new com.twilio.type.PhoneNumber("+19377499379"),
                "Hi " + Name + ", Your Appointment is Booked on " + date)
            .create();
                 
        } catch (SQLException ex) {
            Logger.getLogger(Appointment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    };
    
    
    public boolean cancelAppointment(){return true;};
    public void displayAppointment(){};
    
}
