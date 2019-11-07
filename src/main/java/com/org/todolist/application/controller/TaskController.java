package com.org.todolist.application.controller;

import java.util.Arrays;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.todolist.application.model.Task;
import com.org.todolist.application.repository.TaskRepository;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/bulkcreate")
    public String bulkcreate() {
        taskRepository.saveAll(Arrays.asList(
                new Task("Task1", new String[] {"Test1", "Test2"} )  ,
                new Task("Task2", new String[] {"Test1", "Test2"} )  ,
                new Task("Task3", new String[] {"Test1", "Test2"} )  ,
                new Task("Task4", new String[] {"Test1", "Test2"} )  ));
        return "Tasks are created";

    }

    @PostMapping("/create")
    public String create(@RequestBody @Valid Task task) {
        taskRepository.save(new Task(task.getTaskName(), task.getTaskCategories()));
        return "Task is created";
    }
    
    @GetMapping("/findall")
    public Collection<Task> findAll() {
        return taskRepository.findAll();
    }

    @GetMapping("/findbytaskname")
    public Collection<Task> findByTaskName(String taskName) {
        return taskRepository.findByTaskName(taskName);
    }
    
    @GetMapping("/findbytaskcategory")
    public Collection<Task> findByCategory(String categoryName) {
        return taskRepository.findByTaskCategory(categoryName);
    }
    
    
}