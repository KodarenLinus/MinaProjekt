package com.mycompany.dragon_treasure;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Linus, Emil, Viggo, Oliver
 * V.2.3.1
 */
public class Door 
{
    private char position;
    
    private Room leadsTo;
    
    private boolean locked;
   
    
    //Konstruktor för klassen Door
    public Door (char position, boolean locked, Room leadsTo)
    {
        this.leadsTo = leadsTo;
        this.position = position;
        this.locked = locked;

    }
    
    //Getters
    public char getPos () //Getter för variabeln position
    {
        return position;
    }
    
    public Room getLeadsTo () //Getter för variabeln position
    {
        return leadsTo;
    }
    
    //Setter
    public void setLock (boolean locked) //Setter för variabeln Locked
    {
        this.locked = locked;
    }
    
    //En metod för att kolla om en dör är låst
    public boolean isLocked()
    {
        return locked;
    }
  
}
