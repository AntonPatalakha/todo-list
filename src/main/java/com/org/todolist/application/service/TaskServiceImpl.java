package com.org.todolist.application.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.org.todolist.application.mapper.TaskMapper;
import com.org.todolist.application.model.CategoryEnum;
import com.org.todolist.application.model.TaskUI;
import com.org.todolist.application.repository.TaskRepository;

@Component
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TaskMapper     taskMapper;

    @Override
    public String bulkcreate() {
        taskRepository.saveAll(taskMapper.fromUiToDaoAll(Arrays.asList(
                new TaskUI("Task1", CategoryEnum.CATEGORY1, CategoryEnum.CATEGORY2),
                new TaskUI("Task Two", CategoryEnum.CATEGORY4, CategoryEnum.CATEGORY2),
                new TaskUI("Task3", CategoryEnum.CATEGORY1, CategoryEnum.CATEGORY5, CategoryEnum.CATEGORY3),
                new TaskUI("Task Four", CategoryEnum.CATEGORY1, CategoryEnum.CATEGORY2, CategoryEnum.CATEGORY6, CategoryEnum.CATEGORY12, CategoryEnum.CATEGORY3,
                        CategoryEnum.CATEGORY15),
                new TaskUI("Task BRG a dir", CategoryEnum.CATEGORY1, CategoryEnum.CATEGORY2, CategoryEnum.CATEGORY8),
                new TaskUI("Task5", CategoryEnum.CATEGORY2, CategoryEnum.CATEGORY7))));
        return "Tasks are created";

    }

    @Override
    public String create(TaskUI taskUi) {
        try {
            taskRepository.save(taskMapper.fromUiToDao(taskUi));
            return "Task is created";
        } catch (RuntimeException e) {
            return "Task with the name: " + taskUi.getTaskName() + " already exists";
        }
    }

    @Override
    public Collection<TaskUI> findAll() {
        return taskMapper.fromDaoToUiAll(taskRepository.findAll());
    }

    @Override
    public Collection<TaskUI> findByName(String taskName) {
        return taskMapper.fromDaoToUiAll(taskRepository.findByTaskName(taskName));
    }

    @Override
    public Collection<TaskUI> findByCategory(String categoryName) {
        return taskMapper.fromDaoToUiAll(taskRepository.findByTaskCategory(categoryName));
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public String deleteByName(String taskName) {
        int deleted = taskRepository.deleleByTaskName(taskName);
        return deleted < 1 ? "No task with the name: " + taskName + " to delete" : deleted + " task is deleted";
    }
}