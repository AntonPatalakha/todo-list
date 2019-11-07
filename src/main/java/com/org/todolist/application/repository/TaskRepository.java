package com.org.todolist.application.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.org.todolist.application.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("select t from Task t where t.taskName = :taskname")
    Collection<Task> findByTaskName(@Param("taskname") String taskName);

    @Modifying
    @Query("delete from Task t where t.taskName = :taskname")
    int deleleByTaskName(@Param("taskname")  String taskName);

    // @Query("select new map (T.id as id, T.taskName as taskname, T.taskCategory as taskcategory) from Task T where T.taskCategory = any(categoryName)")
    Collection<Task> findByTaskCategory(String categoryName);
}