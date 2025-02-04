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
abstract public class Monster 
{
    //Variabler
    private String name;
    
    private int damage;
    
    private int healthPoints;
    
    private String monsterDesc;
    
    private int monsterId;

    //Konstruktor för klassen monster
    
    public Monster (String name, int damage, int healthPoints, String monsterDesc, int monsterId)
    {
        this.name = name;
        this.damage = damage;
        this.healthPoints = healthPoints;
        this.monsterDesc = monsterDesc;
        this.monsterId = monsterId;
    }
    
    // getters för monster
    public String getName() //getter för namnet på monstret
    {
        return name;
    }
    
    public int getMonsterId() //getter för vilket monster det är
    {
        return monsterId;
    }
    
    public int getDamage () //getter för skada
    {
        return damage;
    }
    
    public String getMonsterDesc() //getter för monster 
    {
        return monsterDesc;
    }
    
    public int getHealthPoints () //getter för healing
    {
        return healthPoints;
    }
    
    //setter för att få hur mycket liv man har
    public void setHealthPoints (int dmg) 
    {
        
        //Ser till så att ett monster inte kan ha mindre än 0 liv!
        if(healthPoints - dmg >= 0)
        {
            healthPoints -= dmg;
        }
        else
        {
            healthPoints = 0;
        }
    }
}
