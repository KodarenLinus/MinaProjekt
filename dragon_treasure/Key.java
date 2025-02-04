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
public class Key extends Item
{
    private static final String nameK = "Key";
    private static final int itemId = 4;
    private static final String descK = "\n |====|*\n" +
                                        " |    |________________\n" +
                                        " | () | ________   _   _)\n" +
                                        " |    |         |_| | |\n" +
                                        " |====|*            |_|\n";

    
    public Key ()
    {
        super(nameK, descK, itemId);
    }
}
