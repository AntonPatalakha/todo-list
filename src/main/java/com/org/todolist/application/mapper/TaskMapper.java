package com.org.todolist.application.mapper;

import java.util.Collection;

import com.org.todolist.application.model.Task;
import com.org.todolist.application.model.TaskUI;

public interface TaskMapper {

    Task fromUiToDao(TaskUI taskUi);

    TaskUI fromDaoToUi(Task task);
    
    Collection<Task> fromUiToDaoAll(Collection<TaskUI> taskUi);

    Collection<TaskUI> fromDaoToUiAll(Collection<Task> task);

}
