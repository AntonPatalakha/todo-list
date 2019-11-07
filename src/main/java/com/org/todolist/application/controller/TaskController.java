package com.org.todolist.application.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.todolist.application.model.TaskUI;
import com.org.todolist.application.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/bulkcreate")
    public String bulkcreate() {
        return taskService.bulkcreate();

    }

    @PostMapping("/create")
    public String create(@RequestBody @Valid TaskUI taskUi) {
        return taskService.create(taskUi);
        
    }
    
    @GetMapping("/findall")
    public Collection<TaskUI> findAll() {
        return taskService.findAll();
    }

    @GetMapping("/findbytaskname")
    public Collection<TaskUI> findByName(String taskName) {
        return taskService.findByName(taskName);
    }
    
//    @GetMapping("/findbytaskcategory")
//    public Collection<TaskUI> findByCategory(String categoryName) {
//        return taskService.findByCategory(categoryName);
//    }
    
    @DeleteMapping("/deletebytaskname")
    public String deleteByName(String taskName) {
        return taskService.deleteByName(taskName);
    }
    
}