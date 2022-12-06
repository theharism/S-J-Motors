/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.s.jmotors;

import com.mycompany.s.jmotors.Admin.Admin;
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
        return new Admin();
    }
    
}
