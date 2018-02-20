package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Scanner input = new Scanner(System.in);
    private Library library = new Library(this);


    public void startMenu() {

        System.out.println("Welcome to the Task Manager. What would you like to do? \n" +
                "1. Add a Task to the library \n" +
                "2. Remove a Task from the library \n" +
                "3. View what is currently in the library \n" +
                "4. Complete a task \n" +
                "5. Edit an incomplete \n" +
                "6. Exit");

        try {


            switch (input.nextLine()) {
                case "1":
                    System.out.println("What is the name of the task you would like to add?");
                    Task task = new Task(input.nextLine());
                    System.out.println("What is the description of " + task.getTitle() +"?");
                    input.nextLine();
                    System.out.println(task.getDescription());
                    break;
                case "2":
                    //Remove game
//                    if (library.gamelibrary.isEmpty()) {
//                        System.out.println("There are no games to select from!");
//                        startMenu();
//                    } else {
//                        System.out.println("You have chosen to remove a game from your library. \n" + "Here is a list of games, type the number of the one you would like to remove");
//
//                        library.viewGameLibrary();
//                        library.removeGame(input.nextInt());
//                    }
//
//                    break;
//                case "3":
//                    library.viewGameLibrary();
//                    startMenu();
//                    break;
//                case "4":
//                    System.out.println("Which game would you like to remove? Type in its number");
//                    library.viewGameLibrary();
//                    library.checkoutGame(input.nextInt());
//                    startMenu();
//                    break;
//                case "5":
//                    if (library.gamelibrary.isEmpty()) {
//                        System.out.println("There are no games to select from!");
//                        startMenu();
//                    } else System.out.println("What Game would you like to check in? Type in its number.");
//                    library.viewCheckedOutGames();
//                    library.checkInGame(input.nextInt());
//                    startMenu();
//                    break;
//                case "6":
//                    System.exit(0);
//                    break;
//                default:

//                    System.out.println("Pick a valid number!");
//                    break;
            }
            } catch(InputMismatchException ime){
                input.nextLine();

                System.out.println("Select a number from 1 - 7");
                startMenu();


            }
        }
    }
