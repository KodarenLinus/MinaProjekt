package com.mycompany.dragon_treasure;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;



/**
 *
 * @author Linus, Emil, Viggo, Oliver
 * V.2.3.1
 */
public class Dungeon 
{
    
    public static final String welcomeMessage = "Welcome to Dragon Treasure, the worlds best text based game. Can you manage this epic gameplay....";
    
    
    //Våran spel metod.
    public void playGame(Player player)
    {
        //Välkomnar spelaren till spelet
        System.out.printf("%n%s%n", "-----------------------------------------------------------------------------");
        System.out.println(welcomeMessage);
        System.out.printf("%s%n", "------------------------------------------------------------------------------");
        
    
       //Skapar en instans objekt av klassen Dragon_Treasure och kallar den för map
       //Ropar på en metod som bygger en spelmap åt oss 
       Dragon_Treasure gameMaster = new Dragon_Treasure(); 
       gameMaster.gameSetup(); 
       
       //En klass som hanterar att dricka potions
       DrinkPotion drinkP = new DrinkPotion();
       
       //En scanner som används för att hantera användar input
       //Skapar en char som vi kommer använda för att lagra användar input
       Scanner input = new Scanner(System.in); 
       char choice; 
       
       //En boolean som används för att kunna bryta spel loopen
       boolean play = true; 
       
       //Skapar en variabler som vi använder för att hålla koll på vart
       //Spelaren är och vart den vill gå
       Room currentRoom = gameMaster.getStart(); 
       Room nextRoom; 
                          
       //en while loop som körs så länge man vill spela!
       while(play == true)
       {
           
           //Används för att lättare skilja mellan rumsbeskrivningar!
           System.out.printf("%n%s%n", "------------------------------------------------------------------------------");
           
           //Skriver ut beskrivning av rummet
           currentRoom.doNarative(player);
            
            if (player.getHealth() <= 0)
            {
                System.out.println("You died...");
                play = false;
            }
            else
            {
                //Här använder vi våran scanner och vi lagrar resultatet i våran char choice
                choice = input.next().charAt(0);

                //Här converterar vi inputen så det är stora bokstäver, för att undivka att skriva
                //Både stora och små bokstäver på varje case i switch statementet!
                //Därför kallar vi den choice_u = choice converterat till uppercase bokstäver.
                char choice_u = Character.toUpperCase(choice);

                //Här en switch rule sats som låter oss tolka användarens input,
                //och navigera våra olika rum
                switch(choice_u)
                {
                    //Kollar om användaren valt ett värdesträck att gå mot.
                    case 'N', 'S', 'E', 'W' -> 
                    {
                        //kollar om det finns en door i den riktningen
                        if (currentRoom.seeDoor(choice_u) != null)
                        {
                            //Kollar ifall dörren är låst, är den inte det går vi vidare till nästa rum
                            if (currentRoom.seeDoor(choice_u).isLocked() == false)
                            {
                                //Här letar vi upp vad nästa rum skall vara                       
                                nextRoom = gameMaster.nextRoom(choice_u, currentRoom);
                                currentRoom = nextRoom;

                                //Skriver ut vilket håll spelaren gick åt.
                                System.out.printf("%n%s", "------------------------------------------------------------------------------");
                                System.out.printf("%n%s", "you went through a door");

                            }

                            //Kollar om våran spelare har en nyckel för att öppna en låst dörr
                            else if(player.seeItems(4) != null)
                            {
                                //Låser upp dörren 3
                                currentRoom.seeDoor(choice_u).setLock(false);

                                //Här letar vi upp vad nästa rum skall vara                       
                                nextRoom = gameMaster.nextRoom(choice_u, currentRoom);
                                currentRoom = nextRoom;

                                //Skriver ut att spelaren gick igenom en dörr som var låst
                                System.out.printf("%n%s", "------------------------------------------------------------------------------");
                                System.out.printf("%n%s", "you went through a door that was locked");
                            }
                            else
                            {
                                //Här skriver vi ut att dörren var låst så att 
                                //användaren vett att dörren var låst som hen ville gå igenom
                                System.out.printf("%n%s", "------------------------------------------------------------------------------");
                                System.out.printf("%n%s", "The door was loocked, to go through you need a key");
                            }

                        }
                        else 
                        {
                            //Här skriver vi ut att användaren gick in i en vägg. 
                            //Så användaren vett att det inte finns en dörr i den riktning i det rum hen är i
                            System.out.printf("%n%s", "------------------------------------------------------------------------------");
                            System.out.printf("%n%s", "There was no door there");
                        }
                    }
                    //Om användare vill avsluta
                    case 'Q' -> 
                    {
                        //kollar om det finns en dörr i den riktningen
                        if (currentRoom.seeDoor(choice_u) != null)
                        {
                            //Kollar ifall dörren är låst och att spelaren hämtat skatten!
                            if (player.getTreasure() == true)
                            {
                                //Här letar vi upp vad nästa rum skall vara med hjälp av
                                //metoden nexrRoom som ligger i klassen map                             
                                nextRoom = gameMaster.nextRoom(choice_u, currentRoom);

                                //Detta kollar ifall de finns ett rum kopplat till dörren. 
                                //Om de inte finns så ett rum kommer spelet att avslutas!
                                if (nextRoom == null)
                                {
                                    //Ropar på endGame metoden
                                    gameMaster.endGame(player);
                                    //ändrar play till false... vilket gör att våran while loop avslutas, 
                                    //och spelet tar slut
                                    play = false;
                                }
                            } 
                            //Om använder inte hämta skatten kan de inte avsluta spelet.
                            else
                            {
                                System.out.printf("%n%s", "------------------------------------------------------------------------------");
                                System.out.printf("%n%s", "You can't quit.... you need to get the treasure firs!");
                            }
                        }
                        else 
                        {
                            //Här skriver vi ut att användaren gick in i en väg. 
                            //Så användaren vett att det inte finns en dör i den riktning i det rum hen är i
                            System.out.printf("%n%s", "------------------------------------------------------------------------------");
                            System.out.printf("%n%s", "You can't quit.... ");   
                        }

                    }
                    //Hämtar en karta över mapen och vilket rum man är i!
                    case 'M' ->
                    {
                        //Skapar en instans av klassen kompass och skriver ut en kompass
                        Compass compass = new Compass();
                        compass.showCompas();
                        
                        //Skapar en instans av classen Map och sdkriver ut en karta
                        Map map = new Map();
                        map.checkCurrentRoom(currentRoom, gameMaster.getRooms());
                    }  
                    //Användaren skrev ett ogiltigt värd!
                    default -> 
                    {
                        //Här låter vi användaren vetta att det hen skrev in inte är ett gilltigt värde
                        System.out.printf("%n%s", "------------------------------------------------------------------------------");
                        System.out.printf("%n%s", "Press valid input [N, S, W, E, M Q]");
                    }

                }
                
                //Kollar om spelaren är låg på liv
                if ((player.seeItems(1) != null) && player.getMaxHealth() > player.getHealth())
                {
                    drinkP.drinkPotion(currentRoom, player);
                }
            }
        } 
    }
}
