package com.org.todolist.application.model;

public class TaskUI {

    private String         taskName;
    private CategoryEnum[] taskCategory;

    public TaskUI(String taskName, CategoryEnum... taskCategory) {
        this.taskName = taskName;
        this.taskCategory = taskCategory;
    }

    public TaskUI() {
    }

    public String getTaskName() {
        return taskName;
    }

    public CategoryEnum[] getTaskCategories() {
        return taskCategory;
    }

    public void setTaskCategories(CategoryEnum... taskCategory) {
        this.taskCategory = taskCategory;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TaskUI other = (TaskUI) obj;
        if (!this.taskName.equalsIgnoreCase(other.taskName)) {
            return false;
        }
        return false;
    }
}
