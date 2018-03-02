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
        //Fixed recursion error. My switch case was asking fpr a String and was taking user input twice which caused the startmenu to run twice with my try catch method"

        try {


            switch (input.nextInt()) {
                case 1:
                    library.addTask();
                    startMenu();
                    break;
                case 2:
                    System.out.println("You have chosen to remove a task from your library. \n" + "Here is a list of tasks, type the number of the one you would like to remove");
                    library.viewIncompleteTasks();
                    library.removeTask(input.nextInt());
                    break;
//
//
                case 3:
                    library.viewTasks();
                    startMenu();
                    break;
                case 4:
                    System.out.println("What task would you like to set as complete.");
                    library.viewIncompleteTasks();
                    library.completeATask(input.nextInt());
                    startMenu();
                    break;
                case 5:
                    System.out.println("You have chosen to edit an incomplete task. \nWhich task would you like to edit.");
                    library.viewIncompleteTasks();
                    library.editATask(input.nextInt());
                    startMenu();

                default:
//
                    System.out.println("Pick a valid number!");
                    break;
            }
        } catch (InputMismatchException ime) {
            input.nextLine();

            System.out.println("Select a number from 1 - 6");
            startMenu();


        }
    }
}

