package com.org.todolist.application.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tasks", uniqueConstraints = @UniqueConstraint(columnNames = { "taskname" }))
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long               id;

    @NotNull
    @Column(name = "taskname")
    @Size(min = 2, max = 30)
    private String             taskName;

    @Column(name = "taskcategory")
    private String[] taskCategory;

    public Task(String taskName, String[] taskCategory) {
        this.taskName = taskName;
        this.taskCategory = taskCategory;
    }

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public String[] getTaskCategories() {
        return taskCategory;
    }

    public void setTaskCategories(String[] taskCategory) {
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
        final Task other = (Task) obj;
        if (!this.taskName.equalsIgnoreCase(other.taskName)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
}
