/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dragon_treasure;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Linus, Emil, Viggo, Oliver
 * V.2.3.1
 */

public class FoundSomething 
{
    
    //En metod vi ropar på om användaren hittar draken!
    public void foundMonster (Monster monster, Player player, Room curRoom)
    {
        boolean battle = true;
        Scanner input_t = new Scanner(System.in);
        
        // våran battle loop
        while (battle == true)
        {           
            //kollar om spelaren har ett svärd, vi har gett svärd itemId 3
            if (player.seeItems(3) != null)
            {
                 //Testar koden för att undvika programmet krashar ifall det
                 //blir fel när vi castar objektet
                try
                {
                    //Det är är lite fullt då programmet kan smälla om det inte finns ett svärd objekt
                    Sword sword = (Sword)player.seeItems(3); 

                    //Battle variabler som vi använder i samband med svärd fight
                    int chanceOfHit = 1;
                    Random rand = new Random();

                    System.out.println("You have a sword" +"\n Do you wanna go fo a crit press: [Y], normal attack [N]");
                    char choice_b = input_t.next().charAt(0);

                     //Vi gör så att användarens input alltid är i stora bokstäver
                    char choice_b_U = Character.toUpperCase(choice_b);

                    //En if sats för att hantera vall av slag från användaren
                    switch(choice_b_U)
                    {
                        //Om spelaren vill göra en crit attack (Med ett svärd)
                        case 'Y' ->
                        {
                            //Slumpar tal om det slumpade talet är samma som chanceOfHit
                            //Så gör vi en attack på monstret. Annars missar vi!
                            if (rand.nextInt(1, 3) == chanceOfHit)
                            {
                                monster.setHealthPoints(sword.getDamage()*2);

                                System.out.printf("%n%s", "------------------------------------------------------------------------------");
                                System.out.println("\nyou hit");
                                System.out.printf("%n%s", "------------------------------------------------------------------------------");
                            }
                            else
                            {
                                System.out.printf("%n%s", "------------------------------------------------------------------------------");
                                System.out.println("\nyou missed");
                                System.out.printf("%n%s", "------------------------------------------------------------------------------");
                            }

                        }

                        //En vanlig attack
                        case 'N' ->
                        {
                            monster.setHealthPoints(sword.getDamage());
                            System.out.printf("%n%s", "------------------------------------------------------------------------------");
                            System.out.println("\nyou hit");
                            System.out.printf("%n%s", "------------------------------------------------------------------------------");
                        }
                        default ->
                        {
                            System.out.printf("%n%s", "------------------------------------------------------------------------------");
                            System.out.println("\nSomething went wrong.... pls select a valid input");
                            System.out.printf("%n%s", "------------------------------------------------------------------------------");
                        }

                    }

                }
                catch (ClassCastException e)
                {
                    throw new ClassCastException("The program try to cast a item objekt to sword."
                            + "\nThat wasn't a sword check your code");
                }
                
            }
            //Spelaren gör en attack utan svärd
            else
            {
                System.out.println("\n Do you wanna go fo a crit press: [Y], normal attack [N]");
                char choice_b = input_t.next().charAt(0);
                
                //Battle variabler 
                int chanceOfHit = 1;
                Random rand = new Random();
                
                //Vi gör så att användarens input alltid är i stora bokstäver
                char choice_b_U = Character.toUpperCase(choice_b);

                switch (choice_b_U)
                {
                    case 'Y' ->
                    {
                        if (rand.nextInt(1, 3) == chanceOfHit)
                        {
                            monster.setHealthPoints(player.getDamage()*2);

                            System.out.printf("%n%s", "------------------------------------------------------------------------------");
                            System.out.println("\nyou hit");
                            System.out.printf("%n%s", "------------------------------------------------------------------------------");
                        }
                        else
                        {
                            System.out.printf("%n%s", "------------------------------------------------------------------------------");
                            System.out.println("\nyou missed");
                            System.out.printf("%n%s", "------------------------------------------------------------------------------");
                        }  
                    }
                    case 'N' ->
                    {
                        monster.setHealthPoints(player.getDamage());
                        System.out.printf("%n%s", "------------------------------------------------------------------------------");
                        System.out.println("\nyou hit");
                        System.out.printf("%n%s", "------------------------------------------------------------------------------");   
                    }
                    default ->
                    {
                        System.out.printf("%n%s", "------------------------------------------------------------------------------");
                        System.out.println("\nSomething went wrong.... pls select a valid input");
                        System.out.printf("%n%s", "------------------------------------------------------------------------------");
                    }
                }
            }
        
            //Kollar ifall monstret har liv,
            //om den inte har det tar vi bort monstret från rummet.
            //Om monstret har liv attackerar den!
            if (monster.getHealthPoints() <= 0)
            {
                battle = false;
                curRoom.removeMonster(monster);
            }
            else
            {
                
                player.setHealth(player.getHealth()-monster.getDamage());
                System.out.printf("%n%s", "------------------------------------------------------------------------------");
                System.out.println("\nYou took damage from the monster, you have " + player.getHealth() + " hp left");
                System.out.printf("%n%s%n", "------------------------------------------------------------------------------");
            
                //Om monstret är en Goblin kommer den sno från spelaren
                if (monster.getMonsterId() == 2)
                {
                    //Testar koden så programmet inte krashar
                    try
                    {
                        Goblin goblin = (Goblin)monster;
                        player.setGold(goblin.stealGold());
                        
                        System.out.printf("%n%s", "------------------------------------------------------------------------------");
                        System.out.println("\nThe goblin stole gold from you. You have " + player.getGold() + " gold left");
                        System.out.printf("%n%s%n", "------------------------------------------------------------------------------");
                    }
                    catch (ClassCastException e)
                    {
                        throw new ClassCastException("The program try to cast a monster objekt to goblin."
                                + "\nThat wasn't a goblin check your code");
                    }
                }
            }
            
            if (player.getHealth() <= 0)
            {
                battle = false;
            }
            //Skriver ut hur mycket liv monstret har kvar
            System.out.printf("%n%s%n", "------------------------------------------------------------------------------");
            System.out.println(monster.getName() + " has " + monster.getHealthPoints());
        }
        System.out.printf("%s%n", "------------------------------------------------------------------------------");
        
    }

    
    //En metod som vi anropar när vi hittar ett item!!!
    public void foundItem (Room curRoom, Player player, Item item)
    {
        Scanner input_t = new Scanner(System.in);
        
        //Skapar en boolean för våran while loop nedanför
        boolean actionPickUpOrNot = false;
        
        //En loop som är tillför att kolla ifall användaren vill plocka upp skatten
        while (actionPickUpOrNot == false)
        {
            System.out.printf("%s%n", "------------------------------------------------------------------------------");
            System.out.println("Do you want to pick up the " + item.getName() + " press: [Y], No press [N]");
            
            //Char som vi lagrar input från användare
            char choice_t = input_t.next().charAt(0);
            
            //Vi gör så att användarens input alltid är i stora bokstäver
            char choice_t_U = Character.toUpperCase(choice_t);
            
            //En switch-sats som kollar vad användaren vallt att göra!
            //Ifall den vill plocka upp skatten eller inte
            switch (choice_t_U) 
            {
                //Användaren valde att plocka upp skatten
                case 'Y' -> 
                {
                    
                    // spelaren tar upp itemet från rummet
                    player.addItem(item);
                    curRoom.removeItem(item);
                    
                    //Kollar om det var en skatt som spelaren plocka utt
                    if (item.getItemId() == 2)
                    {
                        //Testar koden för att undvika programmet krashar ifall det
                        //blir fel när vi castar objektet
                        try
                        {
                            //Castar ett treasure objekt ur item arrayen
                            Treasure treasure = (Treasure)player.seeItems(2);
                            player.setTreasure(true);
                            player.setGold(treasure.getGoldValue());
                        }
                        catch (ClassCastException e)
                        {
                            throw new ClassCastException("The program try to cast a item objekt to treasure."
                                    + "\nThat wasn't a treasure check your code");
                        }
                    }
                    
                    //Bryter loopen
                    actionPickUpOrNot = true;
                    
                    //Berättar att användaren har skatten
                    System.out.printf("%n%s", "------------------------------------------------------------------------------");
                    System.out.println("\nYou picked up a " + item.getName());
                    System.out.printf("%n%s%n", "------------------------------------------------------------------------------");
                }
                //Användaren har valt att inte plocka upp skatten
                case 'N' -> 
                {
                    //Bryter loopen 
                    actionPickUpOrNot = true;
                    
                    //Berättar för användaren att den inte plocka upp skatten!
                    System.out.printf("%n%s", "------------------------------------------------------------------------------");
                    System.out.println("\nYou didn´t pick up a " + item.getName());
                    System.out.printf("%n%s%n", "------------------------------------------------------------------------------");
                    
                }
                
                //Användaren har givit ogiltig input!!!
                default -> 
                {
                    //Berättar för användaren att inputen är fel
                    System.out.printf("%n%s", "------------------------------------------------------------------------------");
                    System.out.printf("%n%s", "Something went wrong!!!");
                    System.out.printf("%n%s", "------------------------------------------------------------------------------");
                } 
            }
        }
    }
}
