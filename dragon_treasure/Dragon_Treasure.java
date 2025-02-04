package com.mycompany.dragon_treasure;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Linus, Emil, Viggo, Oliver
 * V.2.3.1
 */
public class Dragon_Treasure 
{
    
    private ArrayList<Room> rooms = new ArrayList<>();;
    
    private Room startRoom; 
    
      //Main functionen
    public static void main(String[] args) 
    {   
       AddPlayer();
    }
    
    public static void AddPlayer ()
    {
        Dungeon dungeon = new Dungeon();
        
        //Låter spelaren välja ett namn och skappar 
        //sedan ett player objekt med det namnet
        String name;
        Scanner input_n = new Scanner(System.in); 
        System.out.printf("%s", "Write a name: ");
        name = input_n.nextLine();
        Player player = new Player(name);
                
        //Ropar på en metod som kör spelet.
        dungeon.playGame(player); 
    }
  
   //Getter för att hämta ut start rummet
   public Room getStart()
   {
       return startRoom;
   }
   
   public ArrayList<Room> getRooms()
   {
       return rooms;
   }
   //Sätter upp spelet, skapar rum och länkar ihop dem.
    public void gameSetup ()
    {
        
        //Skapar rumen till vårat spel
        Room start = new Room("You are in a room you need to escape from here"); //Start rum
        Room room1 = new Room("It's dark in here in the corner a tourch lights upp the room for "); //Rum 1
        Room room2 = new Room("The room is creepy water running between the cracks"); //Rum 2
        Room room3 = new Room("The room smells a litel rotten"); //Rum 3
        Room room4 = new Room("You sens the smell of grass, but also a with of something that smells rooten"); //Rum 4
        Room room5 = new Room("This room smells even worse"); //Rum 5
        Room room6 = new Room("A tourch lights up the room, and sens a horibell smells"); //Rum 6
        Room exit = new Room("You are in the exit room"); //Exit rum
        
        //Lägger in rummen i en Arraylista.
        rooms.add(start);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        rooms.add(room5);
        rooms.add(room6);
        rooms.add(exit);
        
        //Skapar kopplingar till de olika rummen
        //Start room och dens tillhörande dörar och vilket rum de leder till
        start.addDoor(new Door('E', false, room1));
        
        //Room 1 och dens tillhörande dörar och vilket rum de leder till
        //room1.addDoor(new Door('N', true, start));
        room1.addDoor(new Door('N', false, room2));
        room1.addDoor(new Door('S', false, room3));
        room1.addItem(new Potion(30));
        
        //Room 2 och dens tillhörande dörar och vilket rum de leder till
        room2.addDoor(new Door('S', false, room1));
        room2.addDoor(new Door('E', true, room4));
        room2.addItem(new Treasure());
        room2.addMonster(new Goblin(1, 10));
                
        //Room 3 och dens tillhörande dörar och vilket rum de leder till
        room3.addDoor(new Door('N', false, room1));
        room3.addDoor(new Door('E', false, room5));
        room3.addItem(new Sword(5));
        
        //Room 4 och dens tillhörande dörar och vilket rum de leder till
        room4.addDoor(new Door('W', false, room2));
        room4.addDoor(new Door('S', false, room5));
        room4.addDoor(new Door('E', false, exit));
        room4.addItem(new Key());
        
        //Room 5 och dens tillhörande dörar och vilket rum de leder till
        room5.addDoor(new Door('W', false, room3));
        room5.addDoor(new Door('N', false, room4));
        room5.addDoor(new Door('E', true, room6));
        room5.addMonster(new Goblin(1, 10));
        
        //Room 6 och dens tillhörande dörar och vilket rum de leder till
        room6.addDoor(new Door('W', false, room5));
        room6.addItem(new Treasure());
        room6.addMonster(new Dragon(2, 10));
        
        //exit och dens tillhörande dörar och vilket rum de leder till
        exit.addDoor(new Door('W', false, room4));
        //Vi säger att dörren leder till null här eftersom om användaren vill gå igenom 
        //här så har hen velat avsluta spelet!
        exit.addDoor(new Door('Q', false, null)); 
        
        //Sätter variabeln startRoom till att vara det rum vi kallar för start!
        this.startRoom = start;
    }
    
    //Avslutar spelet.
    public void endGame (Player player)
    {
        //Skriver ut en text som låter användaren vetta att spelet är över.
        System.out.println("Thanks for playing this game, you are now offically a gamer \n this is the gold you colected " + player.getGold());
        System.out.println(
        		  "\n                   \\       /            _\\/_\n"
        		+ "                     .-'-.              //o\\  _\\/_\n"
        		+ "  _  ___  __  _ --_ /     \\ _--_ __  __ _ | __/o\\\\ _\n"
        		+ "=-=-_=-=-_=-=_=-_= -=======- = =-=_=-=_,-'|\"'\"\"-|-,_ \n"
        		+ " =- _=-=-_=- _=-= _--=====- _=-=_-_,-\"          |\n"
        		+ "   =- =- =-= =- = -  -===- -= - .\"");
    }
    
    //En metod för att förflytta sig till ett nytt rum
    public Room nextRoom (char pos, Room currentRoom)
    {
        Room nRoom; //näst rum som vi vill retunera.
       
            //Kollar alla dörrar för att se om det finns en dör 
            for (Door door : currentRoom.getDoors()) 
            {
                if (door.getPos() == pos) 
                {
                    nRoom = door.getLeadsTo();
                    return nRoom;
                }
            }
        
        //ifall vi det inte finns något rum retunera vi null    
        return null;
    }
}
