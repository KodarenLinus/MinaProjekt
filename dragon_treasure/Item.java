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
abstract public class Item 
{
    private String name;
    private String itemDesc;
    private int itemId;
    
    
    public Item (String name, String itemDesc, int itemId)
    {
        this.name = name;
        this.itemDesc = itemDesc;
        this.itemId = itemId;
    }
    
    public int getItemId()
    {
        return itemId;
    }
    
    public String getItemDesc()
    {
        return itemDesc;
    }
    
    public String getName()
    {
        return name;
    }
}
