package com.org.todolist.application.service;

import java.util.Collection;

import com.org.todolist.application.model.TaskUI;

public interface TaskService {

    
    public String bulkcreate();
    
    public String create(TaskUI taskUi);
    
    public String deleteByName(String taskName);
    
    public Collection<TaskUI> findAll();
    
    public Collection<TaskUI> findByName(String taskName);
 
    public Collection<TaskUI> findByCategory(String taskCategory);
}