/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.s.jmotors.Staff;

import com.mycompany.s.jmotors.Person;

/**
 *
 * @author city
 */
public class Staff extends Person {
    
    String fmanager;
    String ID;
    String type;
    
    public void MarkAttendance(){};
    public void AddStaff(String id,String Fid ,String name, String username,String password, String phoneno,String oid,String type)
    {
        addPerson(name,username,password,phoneno,oid);
        this.fmanager=Fid;
        this.type=type;
        this.ID = id;
    }
    
}
