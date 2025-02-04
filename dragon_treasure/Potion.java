
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
public class Potion extends Item
{
    //Variabler
    private int healing;
    private static final String nameP = "Potion";
    private static final int itemId = 1;
    private static final String itemPic = "            __ \n"
    		+ "              )==( \n"
    		+ "              )==( \n"
    		+ "              |H | \n"
    		+ "              |H | \n"
    		+ "              |H | \n"
    		+ "             /====\\ \n"
    		+ "            / Dr S \\ \n"
    		+ "           /========\\ \n"
    		+ "          :HHHHHHHH H: \n"
    		+ "          |HHHHHHHH H| \n"
    		+ "          |HHHHHHHH H| \n"
    		+ "          |HHHHHHHH H| \n"
    		+ "   \\______|=/========\\________/ \n"
    		+ "    \\     :/oO/      |\\      / \n"
    		+ "     \\    / oOOO  Le | \\    / \n"
    		+ "      \\__/| OOO Grape|  \\__/ \n"
    		+ "       )( |  O       |   )( \n"
    		+ "       )( |==========|   )( \n"
    		+ "       )( |HHHHHHHH H|   )( \n"
    		+ "       )( |HHHHHHHH H|   )( \n"
    		+ "      .)(.|HHHHHHHH H|  .)(. \n"
    		+ "     ~~~~~~~~~~~~~~~~  ~~~~~~";

    ////Konstruktor för klassen Potion
    public Potion (int healing)
    {
        super(nameP, itemPic, itemId);
        this.healing = healing; 
    }

    //Getters
    public int getHealing() //getter för variabeln healing
    {
        return healing;
    }
}
