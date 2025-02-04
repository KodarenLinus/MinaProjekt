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
public class Sword extends Item 
{
    private int damage;
    private static final int itemId = 3;
    private static final String nameS = "Sword";
    private static final String descS = "\n    ||\n"+
                                        "O|===|*[===============>\n"+
                                        "    ||\n";

     
    public Sword (int damage)
    {
        super(nameS, descS, itemId);
        this.damage = damage;
    }
   
    public int getDamage ()
    {
        return damage;
    }
    
}
