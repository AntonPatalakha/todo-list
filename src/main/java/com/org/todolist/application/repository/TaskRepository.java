package com.org.todolist.application.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.todolist.application.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    
    @Query("select t from Task t where t.taskName = :taskName")
    Collection<Task> findByTaskName(String taskName);
    
//    @Query("select new map (T.id as id, T.taskName as taskname, T.taskCategory as taskcategory) from Task T where T.taskCategory = any(categoryName)")
    Collection<Task> findByTaskCategory(String categoryName);
}