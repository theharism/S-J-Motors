/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.s.jmotors;

/**
 *
 * @author city
 */
public class Person {
    
    String name;
    String username;
    String email;
    String password;
    int    phoneno;
    
    public Person()
    {
        this.name = "";
        this.username = "";
        this.email = "";
        this.password = "";
        this.phoneno = 0;
    }
    
    public Person(String name, String username, String email, String password, int phoneno)
    {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneno = phoneno;
    }
    
    public void addPerson(String name, String username, String email, String password, int phoneno)
    {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneno = phoneno;
    }
}
