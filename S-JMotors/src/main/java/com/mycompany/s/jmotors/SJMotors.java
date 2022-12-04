/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.s.jmotors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author city
 */
public class SJMotors {

    public static void main(String[] args) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/s&jmotors","root","Sahiwal@144");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SJMotors.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        LoginForm lf = new LoginForm();
        lf.getConnection(con);
        lf.setVisible(true);
    }
}
