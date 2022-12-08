/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.s.jmotors.Admin;

import com.mycompany.s.jmotors.Person;

/**
 *
 * @author city
 */
public class Admin extends Person {

    String adminID;
    
    public Admin()
    {
        this.adminID  = "";
    }
    
    private static Admin admin;

    public static Admin getInstance()
    {
        if(admin == null)
        {
            admin = new Admin();
        }
        
        return admin;
    }
    
    public String getID()
    {
        return adminID;
    }
    
    public void setAdmin(String adminID, String name, String username, String password, String phoneno,String outletID)
    {
        addPerson(name,username,password,phoneno,outletID);
        this.adminID  = adminID;
    }
     
    public boolean assignWorkingSchedule(){return true;};
    public boolean addPartstoInventory(){return true;};
    public boolean transferUsers(){return true;};
    public boolean deactivateAccount(){return true;};
    public void manageOutlet(){};
}
