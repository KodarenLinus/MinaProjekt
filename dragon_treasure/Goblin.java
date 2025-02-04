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
public class Goblin extends Monster
    
{
    //Variabler
    private static final String monsterDesc =
			  "           ,      ,\n"
			+ "            /(.-\"\"-.)\\\n"
			+ "        |\\  \\/      \\/  /|\n"
			+ "        | \\ / =.  .= \\ / |\n"
			+ "        \\( \\   o\\/o   / )/\n"
			+ "         \\_, '-/  \\-' ,_/\n"
			+ "           /   \\__/   \\\n"
			+ "           \\ \\__/\\__/ /\n"
			+ "         ___\\ \\|--|/ /___\n"
			+ "       /`    \\      /    `\\\n"
			+ "      /       '----'       \\";
    
    private static final String nameG = "Goblin";
    
    private static final int stealGold = -10;
    
    private static final int monsterId = 2;

    
    //Konstruktor för klassen Goblin
    public Goblin (int damage, int healthPoints)
    {
        super(nameG, damage, healthPoints, monsterDesc, monsterId);
    }

    //En metod för att ta guld
    public int stealGold()
    {
        return stealGold;
    }
}