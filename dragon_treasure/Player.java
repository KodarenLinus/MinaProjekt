package com.mycompany.dragon_treasure;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;

/**
 *
 * @author Linus, Emil, Viggo, Oliver
 * V.2.3.1
 */
public class Player 
{
    private String name;
    
    private boolean gotTreasure = false;
    
    private int gold = 0;
    
    private static final int damage = 2;
    
    private int health = 10;
    
    private static final int maxHealth = 10;
    
    private ArrayList<Item> items = new ArrayList<>();
    
    
    //Konstruktor för klassen player!
    public Player (String name)
    {
        this.name = name;
    }
    
    //Getters
    public String getName ()
    {
        return name;
    }  

    public int getHealth()
    {
        return health;
    }
            
    public int getMaxHealth()
    {
        return maxHealth;
    }
    
    public int getDamage()
    {
        return damage;
    }
    
    public int getGold ()
    {
        return gold;
    }
    
    public boolean getTreasure ()
    {
       return gotTreasure;         
    }
    
    //Setters
    public void setGold (int gold)
    {
        
        //Kollar så att spelaren kan ha gold mindre än 0
        if (this.gold + gold >= 0)
        {
            this.gold = this.gold + gold;
        }
        else
        {
            this.gold = 0;
        }
    }
    
    public void setTreasure (boolean gotTreasure)
    {
        this.gotTreasure = gotTreasure;
    }
    
    public void setHealth (int health)
    {
        this.health = health;
    }
    
    //En metod för att lägga in items i vårat iventory(items arrayList)
    public void addItem (Item item)
    {
        items.add(item);
    }
    
    public void removeItem (Item item)
    {
        items.remove(item);
    }
    
    //En loop för att kolla efter ett visst item
    public Item seeItems (int id)
    {
        //Loopar igenom våran item arraylist och kollar efter ett vist item namn.
        for (Item item : items)
        {
            if (item.getItemId() == id)
            {
                return item;
            }
        }
        
        //Hittar vi inget som matchar retunerar vi null
        return null;
    }
}
