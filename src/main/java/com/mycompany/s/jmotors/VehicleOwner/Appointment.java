/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.s.jmotors.VehicleOwner;

import com.mycompany.s.jmotors.Staff.Staff;

/**
 *
 * @author city
 */
public class Appointment {
    
    int appointmentID;
    int ownerID;
    int maintenanceCost;
    String date;
    String time;
    Staff staff;
    
    public boolean bookAppointment(){return true;};
    public boolean cancelAppointment(){return true;};
    public void displayAppointment(){};
    
}
