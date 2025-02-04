/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dragon_treasure;

/**
 *
 * @author Linus, Emil, Viggo, Oliver
 * V.2.3.1
 */
import java.util.ArrayList;

public class Map 
{

    public void checkCurrentRoom(Room currentRoom, ArrayList<Room> rooms) 
    {
        //Lagra det nuvrandets rummets index
        int roomIndex = rooms.indexOf(currentRoom);
        
        //En switch sats som innehåller en karta med vart man är med alla rum utom exit rummet.
        switch (roomIndex) 
        {
            case 0 -> System.out.println("           __          \n"
                                        +"     [ ]->|  |         \n"
                                        +"      ^   |__| --> Exit\n"
                                        +"      |     ^          \n"
                                        +"[*]->[ ]    |          \n"
                                        +"      |     V     ____ \n"
                                        +"      |    __    |    |\n"
                                        +"      v   |  |-->|    |\n"
                                        +"     [ ]->|__|   |____|\n");

            case 1 -> System.out.println("           __          \n"
                                        +"     [ ]->|  |         \n"
                                        +"      ^   |__| --> Exit\n"
                                        +"      |     ^          \n"
                                        +"[ ]->[*]    |          \n"
                                        +"      |     V     ____ \n"
                                        +"      |    __    |    |\n"
                                        +"      v   |  |-->|    |\n"
                                        +"     [ ]->|__|   |____|\n");

            case 2 -> System.out.println("           __          \n"
                                        +"     [*]->|  |         \n"
                                        +"      ^   |__| --> Exit\n"
                                        +"      |     ^          \n"
                                        +"[ ]->[ ]    |          \n"
                                        +"      |     V     ____ \n"
                                        +"      |    __    |    |\n"
                                        +"      v   |  |-->|    |\n"
                                        +"     [ ]->|__|   |____|\n");

            case 3 -> System.out.println("           __          \n"
                                        +"     [ ]->|  |         \n"
                                        +"      ^   |__| --> Exit\n"
                                        +"      |     ^          \n"
                                        +"[c]->[ ]    |          \n"
                                        +"      |     V     ____ \n"
                                        +"      |    __    |    |\n"
                                        +"      v   |  |-->|    |\n"
                                        +"     [*]->|__|   |____|\n");

            case 4 -> System.out.println("           __          \n"
                                        +"     [ ]->| *|         \n"
                                        +"      ^   |__| --> Exit\n"
                                        +"      |     ^          \n"
                                        +"[ ]->[ ]    |          \n"
                                        +"      |     V     ____ \n"
                                        +"      |    __    |    |\n"
                                        +"      v   |  |-->|    |\n"
                                        +"     [ ]->|__|   |____|\n");

            case 5 -> System.out.println("           __          \n"
                                        +"     [ ]->|  |         \n"
                                        +"      ^   |__| --> Exit\n"
                                        +"      |     ^          \n"
                                        +"[ ]->[ ]    |          \n"
                                        +"      |     V     ____ \n"
                                        +"      |    __    |    |\n"
                                        +"      v   | *|-->|    |\n"
                                        +"     [ ]->|__|   |____|\n");

            case 6 -> System.out.println("           __          \n"
                                        +"     [ ]->|  |         \n"
                                        +"      ^   |__| --> Exit\n"
                                        +"      |     ^          \n"
                                        +"[ ]->[ ]    |          \n"
                                        +"      |     V     ____ \n"
                                        +"      |    __    |    |\n"
                                        +"      v   |  |-->| *  |\n"
                                        +"     [ ]->|__|   |____|\n");

            default -> System.out.println("You are in an unknown room.");
        }
    }
}