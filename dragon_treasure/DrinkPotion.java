/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dragon_treasure;

import java.util.Scanner;

/**
 *
 * @author Linus, Emil, Viggo, Oliver
 * V.2.3.1
 */
public class DrinkPotion 
{
    
    public void drinkPotion (Room curRoom, Player player)
    {
        //Vi castar en potion från vårt inventory eftersom vi kommer bara kunna nå den här 
        //Metoden om vi har en potion!!!
        Potion potion = (Potion)player.seeItems(1);
        
        System.out.printf("%n%nDo you want to drink potion press: [Y], No press [N]");
        
        //Användar input
        Scanner input_p = new Scanner(System.in);
        char choice_t = input_p.next().charAt(0);
        
        //Vi gör så att användarens input alltid är i stora bokstäver
        char choice_t_U = Character.toUpperCase(choice_t);

        //En switch-sats som kollar vad användaren vallt att göra!
        //Ifall den vill drika potionen eller inte
        switch (choice_t_U) 
        {
            case 'Y' ->
            {
                //kollar ifall vi tar våran potion att vi inte kan få mer än maxHealth
                if ((player.getHealth() + potion.getHealing()) < player.getMaxHealth())
                {
                    player.setHealth(player.getHealth()+potion.getHealing());
                    player.removeItem(potion);
                }
                else
                {
                    player.setHealth(player.getMaxHealth());
                    player.removeItem(potion);
                }
                System.out.printf("%n%s", "------------------------------------------------------------------------------");
                System.out.println("\nYou drank a potion you health is now at " + player.getHealth());
                System.out.printf("%n%s%n", "------------------------------------------------------------------------------");
            } 
            
            //Om spelaren inte dricker potionen
            case 'N' ->
            {
                System.out.printf("%n%s", "------------------------------------------------------------------------------");
                System.out.println("\nYou did not drink the potion");
                System.out.printf("%n%s%n", "------------------------------------------------------------------------------");
            } 
            
            //Fel hantering ifall vi inte får förväntad input
            default ->
            {
                System.out.printf("%n%s", "------------------------------------------------------------------------------");
                System.out.println("\nSomething went wrong... select valid input");
                System.out.printf("%n%s%n", "------------------------------------------------------------------------------");
            }
        }
    }  
}
