/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.s.jmotors.VehicleOwner;

import static com.mycompany.s.jmotors.Login.OTPform.ACCOUNT_SID;
import static com.mycompany.s.jmotors.Login.OTPform.AUTH_TOKEN;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
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
public class Payment {
 
    int appointmentID;
    int paymentID;
    int paymentStage;
    int amount;
    
    public void makeNewPayment(String ID, int paid, Connection payment,String name, String phoneno)
    {
        String query = "select appointmentID from `Payment` where appointmentID = ?";
        String query1="UPDATE Payment SET Status = ? WHERE appointmentID = ? ";
        String query2="UPDATE Payment SET Paid = ? WHERE appointmentID = ? ";
        String query3="UPDATE Payment SET Balance = ? WHERE appointmentID = ? ";
        String query4="SELECT Balance From Payment Where  appointmentID = ? ";
        
         PreparedStatement pdt;
        PreparedStatement pdt1;
        PreparedStatement pdt2;
        PreparedStatement pdt3;
        PreparedStatement pdt4;
        String appid="";
        
        try
        {
            
            pdt = payment.prepareStatement(query);
            pdt1=payment.prepareStatement(query1);
            pdt2=payment.prepareStatement(query2);
            pdt3=payment.prepareStatement(query3);
            pdt4=payment.prepareStatement(query4);
            
           pdt.setString(1, ID);
            ResultSet rn=pdt.executeQuery();
            
           
            while(rn.next())
            {
             appid=rn.getString("appointmentID");
          }
            if(appid.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Appointment not found");
            }
            else
            { 
                  pdt4.setString(1,ID);
                 ResultSet rn1=pdt4.executeQuery();
                
                amount=0;
            
                while(rn1.next())
                {
                   amount=rn1.getInt(1);
                }
                 
                if(paid > amount || paid < 0)
                {
                     JOptionPane.showMessageDialog(null, "Enter a Valid Amount");
                }
                else
                {
                        pdt2.setInt(1, paid);
                 pdt2.setString(2,ID);
                 pdt2.executeUpdate();
                 
                int temp=amount-paid;
                 
                 pdt3.setInt(1,temp);
                 pdt3.setString(2,ID);
                 pdt3.executeUpdate();
                 
                 if(temp == 0)
                 {
                    pdt1.setString(1, "P");
                 pdt1.setString(2,ID);
                 pdt1.executeUpdate();
                 
                  JOptionPane.showMessageDialog(null, "Full Payment Done Successfully");
                  
                    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message message = Message.creator(
                new com.twilio.type.PhoneNumber(phoneno),
                new com.twilio.type.PhoneNumber("+19377499379"),
                "Hi " + name + ", You have fully Paid for your Appointment No " + appid)
            .create();
                 
                 }
                 else
                 {
                     pdt1.setString(1, "U");
                 pdt1.setString(2,ID);
                 pdt1.executeUpdate();
                 
                  JOptionPane.showMessageDialog(null, "Partial Payment Done successfully");
                 
                    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message message = Message.creator(
                new com.twilio.type.PhoneNumber(phoneno),
                new com.twilio.type.PhoneNumber("+19377499379"),
                "Hi " + name + ", You have Partially Paid for your Appointment No " + appid)
            .create();
                  
                 }
                }
            }
             
        
        } catch (SQLException ex) {
        Logger.getLogger(MakePayemet.class.getName()).log(Level.SEVERE, null, ex);
        }
    };
    
    
    
    public void displayPayment(){};
    public int checkPaymentStage(){return 1;}; 
}
