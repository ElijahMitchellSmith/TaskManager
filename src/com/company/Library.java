package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    public final Menu menu;
    private Scanner input = new Scanner(System.in);
    private List<Task> allTasks = new ArrayList<Task>();
    private List<Task> incompleteTask = new ArrayList<Task>();
    private List<Task> completeTask = new ArrayList<Task>();



    public Library(Menu menu) {
        this.menu = menu;
    }




    protected void addTask() {
        System.out.println("What is the name of the task you would like to add?");
        Task task = new Task(input.nextLine());
        System.out.println("What is the description of " + task.getTitle() +"?");
        task.setDescription(input.nextLine());
        System.out.println(task.getDescription());
        task.setTitle(input.nextLine());
        allTasks.add(task);
        incompleteTask.add(task);
        menu.startMenu();

    }

}
