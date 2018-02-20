package com.company;

import java.util.ArrayList;
import java.util.List;

public class Library {
    public final Menu menu;
    private List<Task> allTasks = new ArrayList<Task>();
    private List<Task> incompleteTask = new ArrayList<Task>();
    private List<Task> completeTask = new ArrayList<Task>();



    public Library(Menu menu) {
        this.menu = menu;
    }

    protected void addTask(Task task) {
        allTasks.add(task);
        task.setDescription();
        menu.startMenu();


    }

}
