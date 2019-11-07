package com.org.todolist.application.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.org.todolist.application.model.CategoryEnum;
import com.org.todolist.application.model.Task;
import com.org.todolist.application.model.TaskUI;

@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task fromUiToDao(TaskUI taskUi) {
        return taskUi != null ? new Task(taskUi.getTaskName(), getTaskCategories(taskUi.getTaskCategories())) : null;
    }

    private String[] getTaskCategories(CategoryEnum[] taskCategories) {
        return (null != taskCategories ? Arrays.asList(taskCategories)
                .stream()
                .map(taskCategory -> taskCategory.name())
                .collect(Collectors.toList()) : Collections.emptyList())
                        .toArray(new String[0]);
    }

    @Override
    public TaskUI fromDaoToUi(Task task) {
        return task != null ? new TaskUI(task.getTaskName(), getTaskCategoriesEnum(task.getTaskCategories())) : null;
    }

    private CategoryEnum[] getTaskCategoriesEnum(String[] taskCategories) {
        return (null != taskCategories ? Arrays.asList(taskCategories)
                .stream()
                .map(taskCategory -> CategoryEnum.valueOf(taskCategory))
                .collect(Collectors.toList()) : Collections.emptyList())
                        .toArray(new CategoryEnum[0]);
    }

    @Override
    public Collection<Task> fromUiToDaoAll(Collection<TaskUI> taskUis) {
        return taskUis != null ? taskUis.stream().map(taskUi -> fromUiToDao(taskUi)).collect(Collectors.toCollection(ArrayList::new)) : Collections.emptyList();
    }

    @Override
    public Collection<TaskUI> fromDaoToUiAll(Collection<Task> tasks) {
        return tasks != null ? tasks.stream().map(task -> fromDaoToUi(task)).collect(Collectors.toCollection(ArrayList::new)) : Collections.emptyList();
    }
}
