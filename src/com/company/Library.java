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
        System.out.println("This task has been added on " + dateFormat.format(calendar.getTime()) + " What is the month, day, and year this task should be completed?");
        task.setDueDate(input.nextLine());
//        allTasks.add(task);
        incompleteTask.add(task);
        menu.startMenu();

    }

    protected void removeTask(int taskindex) {
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
        System.out.println("Which tasks would you like view.\n1.Incomplete Tasks \n2.Complete \n3.All Tasks");

        switch (input.nextInt()) {
            case 1:
                for (int i = 0; i < incompleteTask.size(); i++) {
                    System.out.println(position + ". " + incompleteTask.get(i).getTitle());
                    position++;
                }
                break;
            case 2:
                for (int i = 0; i < completeTask.size(); i++) {
                    System.out.println(position + ". " + completeTask.get(i).getTitle());
                    position++;
                }
                break;

            case 3:
                for (int i = 0; i < incompleteTask.size(); i++) {
                    System.out.println(position + ". " + incompleteTask.get(i).getTitle());
                    position++;
                }
                for (int i = 0; i < completeTask.size(); i++) {
                    System.out.println(position + ". " + completeTask.get(i).getTitle());
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
        System.out.println(incompleteTask.get(taskindex).getTitle());
        System.out.println("Are you sure? Y or N");
        switch (input.nextLine().toUpperCase()) {
            case "Y":
                System.out.println("Sure thing!");
                completeTask.add(incompleteTask.get(taskindex));
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
}
