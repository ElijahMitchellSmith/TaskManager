package com.company;

import sun.awt.geom.AreaOp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Task {
    Calendar calendar = Calendar.getInstance();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    private Scanner input = new Scanner(System.in);
    private String title;
    private String description;
    private String dueDate;

    public Task(String title) {
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}

//    public String getCompletedDate() {
//        return completedDate;
//    }
//
//    public void setCompletedDate(String completedDate) {
//        this.completedDate = completedDate;
//    }
//}
