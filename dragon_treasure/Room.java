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
public class Room 
{
    
    //variabler
    private String roomDesc; 
    
    private ArrayList<Door> doors = new ArrayList<>();
    
    private ArrayList<Monster> monsters = new ArrayList<>();
    
    private ArrayList<Item> items = new ArrayList<>();

    
    
    //Konstruktor
    public Room (String roomDesc)
    {
        this.roomDesc = roomDesc;
    }
    
    //getter hämtar alla dörrar som finns till rummet.
    public ArrayList<Door> getDoors()
    {
        return doors;
    }
    
    //En metod för att lägga in monster i rummen
    public void addMonster(Monster monster)
    {
        monsters.add(monster);
    }
    
    //En metod för att läga till items i rummen
    public void addItem(Item item)
    {
        items.add(item);
    }
    
    //En metod för att lägga in monster i rummen
    public void removeMonster(Monster monster)
    {
        monsters.remove(monster);
    }
    
    //En metod för att läga till items i rummen
    public void removeItem(Item item)
    {
        items.remove(item);
    }
    
    
    //En metod som lägger till dörrar
    public void addDoor(Door door)
    {
         doors.add(door);
    } 
    
    //Kunna kolla på dörrar i ett rum
    public Door seeDoor(char pos)
    {
        //En loop som kollar ifall dör finns i den riktningen
        for (Door door : doors) 
        {
            if (door.getPos() == pos) 
            {
                //Om den hittar en dör i riktningen så retunerar den den dörren
                return door;
            }
        }
        //Om ingen dör hittas så kommer den här metoden att retunera null
        return null;
    } 
    
    //Kunna kolla ifall items finns
    public Item seeItems()
    {
        //En loop som kollar ifall det finns items i rummet
        for (Item item : items) 
        {
             return item;
        }
        
        //Om inget items hittas så kommer den här metoden att retunera null
        return null;
    } 
    
    //Se monsters i rummet
    public Monster seeMonsters()
    {
         //En loop som kollar ifall det finns items i rummet
        for (Monster monster : monsters) 
        {
             return monster;
        }
        
        //Om inget monster hittas så kommer den här metoden att retunera null
        return null;
    }
    
    //Printar ut rumsbeskrivning.
    public void doNarative(Player player)
    {       
       FoundSomething found = new FoundSomething();
        
        /*
        **När vi skriver ut ett objekt i rummet som item eller monster så hanterar vi dem en i taget.
        **Vi kan ta bort saker i metodenrna vi ropar på därför använder vi en kopierad lista att loopa igenom.
        **Detta för att unvidka ConcurrentModificationException, som uppstår när vi försöker tabort något i arraylistan under itterationer.
        **som vi löst problemet nu kan rum hantera flera items och monster.
        */
        for (Monster monster : new ArrayList<>(monsters))
        {
            if (monster.getMonsterId() == 2)
            {
                if (player.getTreasure() == true)
                {
                    System.out.println("\n" + monster.getName() + " " + monster.getMonsterDesc() + "\n");
                    found.foundMonster(monster, player, this);
                }
            }
            else
            {
                System.out.println("\n" + monster.getName() + " " + monster.getMonsterDesc() + "\n");
                found.foundMonster(monster, player, this);
            }
        }
        
        //kollar så att spelaren inte dog när den slogs mot monstret
        if (player.getHealth() > 0)     
        {
            for (Item item : new ArrayList<>(items)) 
            {
                System.out.println("\nIn the room there is " + item.getName() + " " + item.getItemDesc() + "\n");
                found.foundItem(this, player, item);
            }

           //Skriver ut ett rums beskrivning av rummet
           System.out.println(roomDesc + " " + player.getName() + " your options is: ");

           //En loop för att loopa igenom ett rums alla dörar 
           for (Door door : doors)
           {

                //En switch sats för att vetta vad alla dörrar finns i ett rum
                switch (door.getPos()) 
                {

                    //Man kan gå norr
                    case 'N' ->                 
                    {
                        System.out.printf("%n%s", "To go north write [N] and press [Enter] to go there");
                    }

                    //Man kan gå söder
                    case 'S' ->                 
                    {
                        System.out.printf("%n%s", "To go south write [S] and press [Enter] to go there");
                    }

                    //Man kan gå öster
                    case 'E' ->                 
                    {
                        System.out.printf("%n%s", "To go east write [E] and press [Enter] to go there");
                    }

                    //Man kan gå väster
                    case 'W' ->                 
                    {
                        System.out.printf("%n%s", "To go west write [W] and press [Enter] to go there");
                    }

                    //Man kan avsluta
                    case 'Q' ->                 
                    {
                        System.out.printf("%n%s", "To quit write [Q] and press [Enter]");
                    }
                    default ->                 
                    {
                    }

                }

            }
            
            System.out.printf("%n%s", "To see map write [M] and press [Enter]");
            
            //Berättar för användaren att den skall välja ett håll! 
            System.out.printf("%n%s%n", "------------------------------------------------------------------------------");
            System.out.printf("%s","Choose a option: ");
            
        }
        
    } 
    
}
