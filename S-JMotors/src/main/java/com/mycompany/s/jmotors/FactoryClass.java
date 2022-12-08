/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.s.jmotors;

import com.mycompany.s.jmotors.Admin.Admin;
import com.mycompany.s.jmotors.FloorManager.FloorManager;
import com.mycompany.s.jmotors.Staff.Staff;
import com.mycompany.s.jmotors.VehicleOwner.Appointment;
import com.mycompany.s.jmotors.VehicleOwner.Payment;
import com.mycompany.s.jmotors.VehicleOwner.VehicleOwner;

/**
 *
 * @author chhar
 */
public class FactoryClass {
    
    public VehicleOwner getVehicleOwner()
    {
        return new VehicleOwner();
    }
    
    public Admin getAdmin()
    {
        Admin a = new Admin();
        return a;
    }
    
    public Appointment getAppointment()
    {
        return new Appointment();
    }
    
    public Payment getPayment()
    {
        return new Payment();
    }
    
    public Staff getStaff()
    {
        return new Staff();
    }
    
    public FloorManager getFloorManger()
    {
        return new FloorManager();
    }
}
