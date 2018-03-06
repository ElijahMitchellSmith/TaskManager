package com.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;


public class Library {

    public final Menu menu;
    private Scanner input = new Scanner(System.in);
    //    private List<Task> allTasks = new ArrayList<Task>();
    private List<Task> incompleteTask = new ArrayList<Task>();
    private List<Task> completeTask = new ArrayList<Task>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
    private int taskindex = 1;

    public Library(Menu menu) {

        this.menu = menu;
    }


    protected void addTask() {
        Calendar calendar = Calendar.getInstance();
        System.out.println("What is the name of the task you would like to add?");
        Task task = new Task(input.nextLine());
        System.out.println("What is the description of " + task.getTitle() + "?");
        task.setDescription(input.nextLine());
        System.out.println("This task has been added on " + dateFormat.format(calendar.getTime()) + " What is the month, day, and year this task should be completed? \n(Example: 01/02/34)");
        task.setDueDate(input.nextLine());
//        allTasks.add(task);
        System.out.println("Is this task a priority? Y or N.");
        switch (input.nextLine().toUpperCase()) {
            case "Y":
                incompleteTask.add(0, task);
                menu.startMenu();
                break;
            case "N":
                incompleteTask.add(task);
                menu.startMenu();
                break;
            default:
                System.out.println("Please make a valid choice");
                menu.startMenu();
        }
    }

    protected void removeTask(int taskindex) {
        if (incompleteTask.isEmpty() && completeTask.isEmpty()) {
            System.out.println("There are no tasks to select from!");
            menu.startMenu();
        } else
            taskindex--;
        System.out.println(incompleteTask.get(taskindex).getTitle());
        System.out.println("Are you sure? Y or N");
        switch (input.nextLine().toUpperCase()) {
            case "Y":
                System.out.println("Sure thing!");
                incompleteTask.remove(taskindex);
//                allTasks.remove(taskindex);
                menu.startMenu();
                break;
            case "N":
                System.out.println("I'll fix that for ya!");
                menu.startMenu();
                break;
            default:
                System.out.println("Please make a choice");
                removeTask(taskindex);
                break;

        }
    }

    protected void viewTasks() {
        int position = 1;
        int priority = 1;
        System.out.println("Which tasks would you like view.\n1.Incomplete Tasks \n2.Complete \n3.All Tasks");

        switch (input.nextInt()) {
            case 1:
                for (int i = 0; i < incompleteTask.size(); i++) {
                    System.out.println(position + ". " + incompleteTask.get(i).getTitle() + "\n" + incompleteTask.get(i).getDescription() + "\nThis task is due by " + incompleteTask.get(i).getDueDate() + "\nPriority level:" + priority++);
                    position++;
                }
                break;
            case 2:
                for (int i = 0; i < completeTask.size(); i++) {
                    System.out.println(position + ". " + completeTask.get(i).getTitle() + "\n" + completeTask.get(i).getDescription() + "\nCOMPLETED");
                    position++;
                }
                break;

            case 3:
                for (int i = 0; i < incompleteTask.size(); i++) {
                    System.out.println(position + ". " + incompleteTask.get(i).getTitle() + "\n" + incompleteTask.get(i).getDescription() + "\nThis task is due by " + incompleteTask.get(i).getDueDate());
                    position++;
                }
                for (int i = 0; i < completeTask.size(); i++) {
                    System.out.println(position + ". " + completeTask.get(i).getTitle() + "\n" + completeTask.get(i).getDescription() + "\nCOMPLETED");
                    position++;
                }
//                for (int i = 0; i < allTasks.size(); i++) {
//                    System.out.println(position + ". " + allTasks.get(i).getTitle());
//                    position++;
                break;


        }


    }

    protected void viewIncompleteTasks() {
        if (incompleteTask.isEmpty()) {
            System.out.println("There are no tasks to select from!");
            menu.startMenu();
        } else {
            int position = 1;
            for (int i = 0; i < incompleteTask.size(); i++) {
                System.out.println(position + ". " + incompleteTask.get(i).getTitle());
                position++;
            }


        }

    }

    protected void completeATask(int taskindex) {
//        taskindex--;
//        incompleteTask.get(input.nextInt()-1);
//        completeTask.add(incompleteTask.get(taskindex));
//        incompleteTask.remove(taskindex);
//        System.out.println(incompleteTask.get(taskindex).getTitle() + " has been completed!");

        taskindex--;
        Calendar calendar = Calendar.getInstance();
        System.out.println(incompleteTask.get(taskindex).getTitle());
        System.out.println("Are you sure? Y or N");
        switch (input.nextLine().toUpperCase()) {
            case "Y":
                System.out.println("Sure thing!");
                completeTask.add(incompleteTask.get(taskindex));
                incompleteTask.remove(taskindex);
                System.out.println("This task has been completed on " + dateFormat.format(calendar.getTime()));
//                allTasks.remove(taskindex);
                menu.startMenu();
                break;
            case "N":
                System.out.println("I'll fix that for ya!");
                menu.startMenu();
                break;
            default:
                System.out.println("Please make a choice");
                removeTask(taskindex);
                break;


        }


    }

    protected void editATask(int taskindex) {
        taskindex--;
        System.out.println(incompleteTask.get(taskindex).getTitle());
        incompleteTask.remove(taskindex);
        System.out.println("What is the new name of this task?");
        Task task = new Task(input.nextLine());
        System.out.println("What is the new description of " + task.getTitle() + ".");
        task.setDescription(input.nextLine());
        System.out.println("What is the new due date of this task?");
        task.setDueDate(input.nextLine());
        incompleteTask.add(task);
        // essentially deletes and creates a new task. It could be better but this is why this is only the 1st draft of the edit task method.

//        System.out.println("Which task would you like to edit?");
//        viewIncompleteTasks();
//        input.nextInt();


//        System.out.println("What would you like to edit about the task? \n1.Title \n2.Details \n3.Finish Date \n4.Exit Editor.");
//        switch (input.nextInt()) {
//            case 1:
//                incompleteTask.get(taskindex);
//                Task task = new Task(input.nextLine());
//                break;
//            case 2:
//                task.setDescription(input.nextLine());
//                break;
//            case 3:
//                incompleteTask.get(taskindex).setDueDate(input.nextLine());
//                break;
//            case 4:
//                menu.startMenu();
//            default:
//                System.out.println("Please make a valid choice.");
//                menu.startMenu();
    }


    protected void viewAllTasksForRemoval() { //placed this here so the program could eventually be used to remove complete tasks as well. I would have to rework my remove program or create another new method to remove tasks so I decided to save it for a little later.
        int position = 1;
        for (int i = 0; i < incompleteTask.size(); i++) {
            System.out.println(position + ". " + incompleteTask.get(i).getTitle());
            position++;
        }

        for (int i = 0; i < completeTask.size(); i++) {
            System.out.println(position + ". " + completeTask.get(i).getTitle());
            position++;
        }
    }
}
