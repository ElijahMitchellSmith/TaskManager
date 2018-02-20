package com.company;

import java.util.Scanner;

public class Task {
    private Scanner input = new Scanner(System.in);
    private String title;
    private String description;
    private String dueDate;

    public Task() {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        System.out.println("What is the task you would like to enter?");
        input.nextLine();

    }

    public String getDescription() {
        return description;
    }

    public void setDescription() {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
