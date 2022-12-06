/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.s.jmotors;

import com.mycompany.s.jmotors.Login.LoginForm;
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
             con = DriverManager.getConnection("jdbc:mysql://utbm93bwuphgwrmv:KRGIZoX3Z8Jd2UL1Zcq9@bqiopsgzq9fudqmxrwzq-mysql.services.clever-cloud.com:3306/bqiopsgzq9fudqmxrwzq","utbm93bwuphgwrmv","utbm93bwuphgwrmv");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SJMotors.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        LoginForm lf = new LoginForm();
        lf.setConnection(con);
        lf.setVisible(true);
    }
}
