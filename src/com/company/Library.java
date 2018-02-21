package com.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Library {

    public final Menu menu;
    private Scanner input = new Scanner(System.in);
    private List<Task> allTasks = new ArrayList<Task>();
    private List<Task> incompleteTask = new ArrayList<Task>();
    private List<Task> completeTask = new ArrayList<Task>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");


    public Library(Menu menu) {
        this.menu = menu;
    }


    protected void addTask() {
        Calendar calendar = Calendar.getInstance();
        System.out.println("What is the name of the task you would like to add?");
        Task task = new Task(input.nextLine());
        System.out.println("What is the description of " + task.getTitle() + "?");
        task.setDescription(input.nextLine());
        System.out.println("This task has been added on " + dateFormat.format(calendar.getTime()) + "What is the month, day, and year this task should be completed?");
        task.setDueDate(input.nextLine());
        allTasks.add(task);
        incompleteTask.add(task);
        menu.startMenu();

    }

    protected void removeTask(int taskindex) {
        if (incompleteTask.isEmpty()) {
            System.out.println("There are no tasks to select from!");
            menu.startMenu();
        } else
        System.out.println("Which task would you like to remove?");
        System.out.println(incompleteTask);
        incompleteTask.remove(input.nextInt());
        System.out.println("Are you sure? Y or N");
        switch (input.nextLine().toUpperCase()) {
            case "Y":
                System.out.println("Sure thing!");
                menu.startMenu();
                break;
            case "N":
                Task task = new Task(input.nextLine());
                System.out.println("I'll fix that for ya!");
                incompleteTask.add(task);
            default:
                System.out.println("Please make a choice");
                removeTask(taskindex);

        }
    }

    protected void viewTasks() {
        int position = 1;
        for (int i = 0; i < incompleteTask.size(); i++) {
            System.out.println(position + ". " + incompleteTask.get(i).getTitle());
            position++;

        }

    }
}
