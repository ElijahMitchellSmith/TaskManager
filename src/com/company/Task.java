package com.company;

public class Task {
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
