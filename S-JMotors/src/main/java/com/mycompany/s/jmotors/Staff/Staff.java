/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.s.jmotors.Staff;

import com.mycompany.s.jmotors.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author city
 */
public class Staff extends Person {
    
    String fmanager;
    String ID;
    String type;
    
    public void MarkAttendance(String status, Connection addattendance)
    {
         String query2="INSERT INTO Attendance VALUES(?,?,?)";
       
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();  
        
        PreparedStatement pdt;
        
        try
        {
            
            pdt = addattendance.prepareStatement(query2);
                 
                 pdt.setString(1,ID );
                 pdt.setString(2,formatter.format(date));
                 pdt.setString(3,status);
                 pdt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Updated  successfully");
            
            } catch (SQLException ex) {
            
            }
    };
    
    
    public void AddStaff(String id,String Fid ,String name, String username,String password, String phoneno,String oid,String type)
    {
        addPerson(name,username,password,phoneno,oid);
        this.fmanager=Fid;
        this.type=type;
        this.ID = id;
    }
    
}
